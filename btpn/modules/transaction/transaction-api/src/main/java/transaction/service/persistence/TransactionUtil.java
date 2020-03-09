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

package transaction.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import transaction.model.Transaction;

/**
 * The persistence utility for the transaction service. This utility wraps <code>transaction.service.persistence.impl.TransactionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionPersistence
 * @generated
 */
@ProviderType
public class TransactionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Transaction transaction) {
		getPersistence().clearCache(transaction);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Transaction> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Transaction> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Transaction update(Transaction transaction) {
		return getPersistence().update(transaction);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Transaction update(
		Transaction transaction, ServiceContext serviceContext) {

		return getPersistence().update(transaction, serviceContext);
	}

	/**
	 * Returns all the transactions where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching transactions
	 */
	public static List<Transaction> findByid(int id) {
		return getPersistence().findByid(id);
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
	public static List<Transaction> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
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
	public static List<Transaction> findByid(
		int id, int start, int end,
		OrderByComparator<Transaction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
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
	public static List<Transaction> findByid(
		int id, int start, int end,
		OrderByComparator<Transaction> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns the first transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaction
	 * @throws NoSuchTransactionException if a matching transaction could not be found
	 */
	public static Transaction findByid_First(
			int id, OrderByComparator<Transaction> orderByComparator)
		throws transaction.exception.NoSuchTransactionException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaction, or <code>null</code> if a matching transaction could not be found
	 */
	public static Transaction fetchByid_First(
		int id, OrderByComparator<Transaction> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaction
	 * @throws NoSuchTransactionException if a matching transaction could not be found
	 */
	public static Transaction findByid_Last(
			int id, OrderByComparator<Transaction> orderByComparator)
		throws transaction.exception.NoSuchTransactionException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last transaction in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaction, or <code>null</code> if a matching transaction could not be found
	 */
	public static Transaction fetchByid_Last(
		int id, OrderByComparator<Transaction> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the transactions where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of transactions where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching transactions
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the transaction in the entity cache if it is enabled.
	 *
	 * @param transaction the transaction
	 */
	public static void cacheResult(Transaction transaction) {
		getPersistence().cacheResult(transaction);
	}

	/**
	 * Caches the transactions in the entity cache if it is enabled.
	 *
	 * @param transactions the transactions
	 */
	public static void cacheResult(List<Transaction> transactions) {
		getPersistence().cacheResult(transactions);
	}

	/**
	 * Creates a new transaction with the primary key. Does not add the transaction to the database.
	 *
	 * @param id the primary key for the new transaction
	 * @return the new transaction
	 */
	public static Transaction create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws NoSuchTransactionException if a transaction with the primary key could not be found
	 */
	public static Transaction remove(int id)
		throws transaction.exception.NoSuchTransactionException {

		return getPersistence().remove(id);
	}

	public static Transaction updateImpl(Transaction transaction) {
		return getPersistence().updateImpl(transaction);
	}

	/**
	 * Returns the transaction with the primary key or throws a <code>NoSuchTransactionException</code> if it could not be found.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction
	 * @throws NoSuchTransactionException if a transaction with the primary key could not be found
	 */
	public static Transaction findByPrimaryKey(int id)
		throws transaction.exception.NoSuchTransactionException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	 */
	public static Transaction fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the transactions.
	 *
	 * @return the transactions
	 */
	public static List<Transaction> findAll() {
		return getPersistence().findAll();
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
	public static List<Transaction> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Transaction> findAll(
		int start, int end, OrderByComparator<Transaction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<Transaction> findAll(
		int start, int end, OrderByComparator<Transaction> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the transactions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of transactions.
	 *
	 * @return the number of transactions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TransactionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TransactionPersistence, TransactionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TransactionPersistence.class);

		ServiceTracker<TransactionPersistence, TransactionPersistence>
			serviceTracker =
				new ServiceTracker
					<TransactionPersistence, TransactionPersistence>(
						bundle.getBundleContext(), TransactionPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}