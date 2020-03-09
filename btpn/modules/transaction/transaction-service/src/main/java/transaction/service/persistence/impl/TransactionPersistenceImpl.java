/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package transaction.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

import transaction.exception.NoSuchTransactionException;

import transaction.model.Transaction;
import transaction.model.impl.TransactionImpl;
import transaction.model.impl.TransactionModelImpl;

import transaction.service.persistence.TransactionPersistence;

/**
 * The persistence implementation for the transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TransactionPersistenceImpl
	extends BasePersistenceImpl<Transaction> implements TransactionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TransactionUtil</code> to access the transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TransactionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByid;
	private FinderPath _finderPathWithoutPaginationFindByid;
	private FinderPath _finderPathCountByid;

	/**
	 * Returns all the transactions where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching transactions
	 */
	@Override
	public List<Transaction> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transactions where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @return the range of matching transactions
	 */
	@Override
	public List<Transaction> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the transactions where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByid(int, int, int, OrderByComparator)}
	 * @param id the ID
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching transactions
	 */
	@Deprecated
	@Override
	public List<Transaction> findByid(
		int id, int start, int end,
		OrderByComparator<Transaction> orderByComparator,
		boolean useFinderCache) {

		return findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transactions where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transactions
	 */
	@Override
	public List<Transaction> findByid(
		int id, int start, int end,
		OrderByComparator<Transaction> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByid;
			finderArgs = new Object[] {id};
		}
		else {
			finderPath = _finderPathWithPaginationFindByid;
			finderArgs = new Object[] {id, start, end, orderByComparator};
		}

		List<Transaction> list = (List<Transaction>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Transaction transaction : list) {
				if ((id != transaction.getId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TransactionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				if (!pagination) {
					list = (List<Transaction>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Transaction>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaction
	 * @throws NoSuchTransactionException if a matching transaction could not be found
	 */
	@Override
	public Transaction findByid_First(
			int id, OrderByComparator<Transaction> orderByComparator)
		throws NoSuchTransactionException {

		Transaction transaction = fetchByid_First(id, orderByComparator);

		if (transaction != null) {
			return transaction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append("}");

		throw new NoSuchTransactionException(msg.toString());
	}

	/**
	 * Returns the first transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaction, or <code>null</code> if a matching transaction could not be found
	 */
	@Override
	public Transaction fetchByid_First(
		int id, OrderByComparator<Transaction> orderByComparator) {

		List<Transaction> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaction
	 * @throws NoSuchTransactionException if a matching transaction could not be found
	 */
	@Override
	public Transaction findByid_Last(
			int id, OrderByComparator<Transaction> orderByComparator)
		throws NoSuchTransactionException {

		Transaction transaction = fetchByid_Last(id, orderByComparator);

		if (transaction != null) {
			return transaction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append("}");

		throw new NoSuchTransactionException(msg.toString());
	}

	/**
	 * Returns the last transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaction, or <code>null</code> if a matching transaction could not be found
	 */
	@Override
	public Transaction fetchByid_Last(
		int id, OrderByComparator<Transaction> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Transaction> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the transactions where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Transaction transaction :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(transaction);
		}
	}

	/**
	 * Returns the number of transactions where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching transactions
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ID_ID_2 = "transaction.id = ?";

	public TransactionPersistenceImpl() {
		setModelClass(Transaction.class);

		setModelImplClass(TransactionImpl.class);
		setModelPKClass(int.class);
		setEntityCacheEnabled(TransactionModelImpl.ENTITY_CACHE_ENABLED);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("createdOn", "created_on");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("updatedOn", "updated_on");
		dbColumnNames.put("updatedBy", "updated_by");
		dbColumnNames.put("deletedOn", "deleted_on");
		dbColumnNames.put("deletedBy", "deleted_by");
		dbColumnNames.put("isDelete", "is_delete");
		dbColumnNames.put("transactionDate", "transaction_date");
		dbColumnNames.put("transactionWith", "transaction_with");
		dbColumnNames.put("transactionTotal", "transaction_total");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the transaction in the entity cache if it is enabled.
	 *
	 * @param transaction the transaction
	 */
	@Override
	public void cacheResult(Transaction transaction) {
		entityCache.putResult(
			TransactionModelImpl.ENTITY_CACHE_ENABLED, TransactionImpl.class,
			transaction.getPrimaryKey(), transaction);

		transaction.resetOriginalValues();
	}

	/**
	 * Caches the transactions in the entity cache if it is enabled.
	 *
	 * @param transactions the transactions
	 */
	@Override
	public void cacheResult(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			if (entityCache.getResult(
					TransactionModelImpl.ENTITY_CACHE_ENABLED,
					TransactionImpl.class, transaction.getPrimaryKey()) ==
						null) {

				cacheResult(transaction);
			}
			else {
				transaction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all transactions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TransactionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the transaction.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Transaction transaction) {
		entityCache.removeResult(
			TransactionModelImpl.ENTITY_CACHE_ENABLED, TransactionImpl.class,
			transaction.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Transaction> transactions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Transaction transaction : transactions) {
			entityCache.removeResult(
				TransactionModelImpl.ENTITY_CACHE_ENABLED,
				TransactionImpl.class, transaction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new transaction with the primary key. Does not add the transaction to the database.
	 *
	 * @param id the primary key for the new transaction
	 * @return the new transaction
	 */
	@Override
	public Transaction create(int id) {
		Transaction transaction = new TransactionImpl();

		transaction.setNew(true);
		transaction.setPrimaryKey(id);

		return transaction;
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws NoSuchTransactionException if a transaction with the primary key could not be found
	 */
	@Override
	public Transaction remove(int id) throws NoSuchTransactionException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws NoSuchTransactionException if a transaction with the primary key could not be found
	 */
	@Override
	public Transaction remove(Serializable primaryKey)
		throws NoSuchTransactionException {

		Session session = null;

		try {
			session = openSession();

			Transaction transaction = (Transaction)session.get(
				TransactionImpl.class, primaryKey);

			if (transaction == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransactionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(transaction);
		}
		catch (NoSuchTransactionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Transaction removeImpl(Transaction transaction) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(transaction)) {
				transaction = (Transaction)session.get(
					TransactionImpl.class, transaction.getPrimaryKeyObj());
			}

			if (transaction != null) {
				session.delete(transaction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (transaction != null) {
			clearCache(transaction);
		}

		return transaction;
	}

	@Override
	public Transaction updateImpl(Transaction transaction) {
		boolean isNew = transaction.isNew();

		if (!(transaction instanceof TransactionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(transaction.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(transaction);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in transaction proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Transaction implementation " +
					transaction.getClass());
		}

		TransactionModelImpl transactionModelImpl =
			(TransactionModelImpl)transaction;

		Session session = null;

		try {
			session = openSession();

			if (transaction.isNew()) {
				session.save(transaction);

				transaction.setNew(false);
			}
			else {
				transaction = (Transaction)session.merge(transaction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TransactionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {transactionModelImpl.getId()};

			finderCache.removeResult(_finderPathCountByid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((transactionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					transactionModelImpl.getOriginalId()
				};

				finderCache.removeResult(_finderPathCountByid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByid, args);

				args = new Object[] {transactionModelImpl.getId()};

				finderCache.removeResult(_finderPathCountByid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByid, args);
			}
		}

		entityCache.putResult(
			TransactionModelImpl.ENTITY_CACHE_ENABLED, TransactionImpl.class,
			transaction.getPrimaryKey(), transaction, false);

		transaction.resetOriginalValues();

		return transaction;
	}

	/**
	 * Returns the transaction with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaction
	 * @return the transaction
	 * @throws NoSuchTransactionException if a transaction with the primary key could not be found
	 */
	@Override
	public Transaction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransactionException {

		Transaction transaction = fetchByPrimaryKey(primaryKey);

		if (transaction == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransactionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return transaction;
	}

	/**
	 * Returns the transaction with the primary key or throws a <code>NoSuchTransactionException</code> if it could not be found.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction
	 * @throws NoSuchTransactionException if a transaction with the primary key could not be found
	 */
	@Override
	public Transaction findByPrimaryKey(int id)
		throws NoSuchTransactionException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	 */
	@Override
	public Transaction fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the transactions.
	 *
	 * @return the transactions
	 */
	@Override
	public List<Transaction> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @return the range of transactions
	 */
	@Override
	public List<Transaction> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of transactions
	 */
	@Deprecated
	@Override
	public List<Transaction> findAll(
		int start, int end, OrderByComparator<Transaction> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of transactions
	 */
	@Override
	public List<Transaction> findAll(
		int start, int end, OrderByComparator<Transaction> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Transaction> list = (List<Transaction>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRANSACTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSACTION;

				if (pagination) {
					sql = sql.concat(TransactionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Transaction>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Transaction>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the transactions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Transaction transaction : findAll()) {
			remove(transaction);
		}
	}

	/**
	 * Returns the number of transactions.
	 *
	 * @return the number of transactions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRANSACTION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRANSACTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TransactionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the transaction persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, TransactionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, TransactionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByid = new FinderPath(
			TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, TransactionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByid = new FinderPath(
			TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, TransactionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid",
			new String[] {Integer.class.getName()},
			TransactionModelImpl.ID_COLUMN_BITMASK |
			TransactionModelImpl.TRANSACTIONDATE_COLUMN_BITMASK);

		_finderPathCountByid = new FinderPath(
			TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] {Integer.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(TransactionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRANSACTION =
		"SELECT transaction FROM Transaction transaction";

	private static final String _SQL_SELECT_TRANSACTION_WHERE =
		"SELECT transaction FROM Transaction transaction WHERE ";

	private static final String _SQL_COUNT_TRANSACTION =
		"SELECT COUNT(transaction) FROM Transaction transaction";

	private static final String _SQL_COUNT_TRANSACTION_WHERE =
		"SELECT COUNT(transaction) FROM Transaction transaction WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "transaction.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Transaction exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Transaction exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TransactionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"createdOn", "createdBy", "updatedOn", "updatedBy", "deletedOn",
			"deletedBy", "isDelete", "transactionDate", "transactionWith",
			"transactionTotal"
		});

}