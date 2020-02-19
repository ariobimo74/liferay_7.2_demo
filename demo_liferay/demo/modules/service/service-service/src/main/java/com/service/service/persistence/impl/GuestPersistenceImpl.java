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

package com.service.service.persistence.impl;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.service.exception.NoSuchGuestException;
import com.service.model.Guest;
import com.service.model.impl.GuestImpl;
import com.service.model.impl.GuestModelImpl;
import com.service.service.persistence.GuestPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the guest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GuestPersistenceImpl
	extends BasePersistenceImpl<Guest> implements GuestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GuestUtil</code> to access the guest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GuestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByuserName;
	private FinderPath _finderPathWithPaginationCountByuserName;

	/**
	 * Returns all the guests where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @return the matching guests
	 */
	@Override
	public List<Guest> findByuserName(String userName) {
		return findByuserName(
			userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guests where userName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @return the range of matching guests
	 */
	@Override
	public List<Guest> findByuserName(String userName, int start, int end) {
		return findByuserName(userName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guests where userName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByuserName(String, int, int, OrderByComparator)}
	 * @param userName the user name
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guests
	 */
	@Deprecated
	@Override
	public List<Guest> findByuserName(
		String userName, int start, int end,
		OrderByComparator<Guest> orderByComparator, boolean useFinderCache) {

		return findByuserName(userName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guests where userName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guests
	 */
	@Override
	public List<Guest> findByuserName(
		String userName, int start, int end,
		OrderByComparator<Guest> orderByComparator) {

		userName = Objects.toString(userName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByuserName;
		finderArgs = new Object[] {userName, start, end, orderByComparator};

		List<Guest> list = (List<Guest>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Guest guest : list) {
				if (!StringUtil.wildcardMatches(
						guest.getUserName(), userName, '_', '%', '\\', true)) {

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

			query.append(_SQL_SELECT_GUEST_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GuestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				if (!pagination) {
					list = (List<Guest>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Guest>)QueryUtil.list(
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
	 * Returns the first guest in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guest
	 * @throws NoSuchGuestException if a matching guest could not be found
	 */
	@Override
	public Guest findByuserName_First(
			String userName, OrderByComparator<Guest> orderByComparator)
		throws NoSuchGuestException {

		Guest guest = fetchByuserName_First(userName, orderByComparator);

		if (guest != null) {
			return guest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append("}");

		throw new NoSuchGuestException(msg.toString());
	}

	/**
	 * Returns the first guest in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guest, or <code>null</code> if a matching guest could not be found
	 */
	@Override
	public Guest fetchByuserName_First(
		String userName, OrderByComparator<Guest> orderByComparator) {

		List<Guest> list = findByuserName(userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guest in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guest
	 * @throws NoSuchGuestException if a matching guest could not be found
	 */
	@Override
	public Guest findByuserName_Last(
			String userName, OrderByComparator<Guest> orderByComparator)
		throws NoSuchGuestException {

		Guest guest = fetchByuserName_Last(userName, orderByComparator);

		if (guest != null) {
			return guest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append("}");

		throw new NoSuchGuestException(msg.toString());
	}

	/**
	 * Returns the last guest in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guest, or <code>null</code> if a matching guest could not be found
	 */
	@Override
	public Guest fetchByuserName_Last(
		String userName, OrderByComparator<Guest> orderByComparator) {

		int count = countByuserName(userName);

		if (count == 0) {
			return null;
		}

		List<Guest> list = findByuserName(
			userName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guests before and after the current guest in the ordered set where userName LIKE &#63;.
	 *
	 * @param id the primary key of the current guest
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guest
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	@Override
	public Guest[] findByuserName_PrevAndNext(
			int id, String userName, OrderByComparator<Guest> orderByComparator)
		throws NoSuchGuestException {

		userName = Objects.toString(userName, "");

		Guest guest = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Guest[] array = new GuestImpl[3];

			array[0] = getByuserName_PrevAndNext(
				session, guest, userName, orderByComparator, true);

			array[1] = guest;

			array[2] = getByuserName_PrevAndNext(
				session, guest, userName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Guest getByuserName_PrevAndNext(
		Session session, Guest guest, String userName,
		OrderByComparator<Guest> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GUEST_WHERE);

		boolean bindUserName = false;

		if (userName.isEmpty()) {
			query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUserName = true;

			query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GuestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserName) {
			qPos.add(userName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(guest)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Guest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guests where userName LIKE &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByuserName(String userName) {
		for (Guest guest :
				findByuserName(
					userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(guest);
		}
	}

	/**
	 * Returns the number of guests where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching guests
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathWithPaginationCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GUEST_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

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

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 =
		"guest.userName LIKE ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(guest.userName IS NULL OR guest.userName LIKE '')";

	public GuestPersistenceImpl() {
		setModelClass(Guest.class);

		setModelImplClass(GuestImpl.class);
		setModelPKClass(int.class);
		setEntityCacheEnabled(GuestModelImpl.ENTITY_CACHE_ENABLED);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("userName", "user_name");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the guest in the entity cache if it is enabled.
	 *
	 * @param guest the guest
	 */
	@Override
	public void cacheResult(Guest guest) {
		entityCache.putResult(
			GuestModelImpl.ENTITY_CACHE_ENABLED, GuestImpl.class,
			guest.getPrimaryKey(), guest);

		guest.resetOriginalValues();
	}

	/**
	 * Caches the guests in the entity cache if it is enabled.
	 *
	 * @param guests the guests
	 */
	@Override
	public void cacheResult(List<Guest> guests) {
		for (Guest guest : guests) {
			if (entityCache.getResult(
					GuestModelImpl.ENTITY_CACHE_ENABLED, GuestImpl.class,
					guest.getPrimaryKey()) == null) {

				cacheResult(guest);
			}
			else {
				guest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all guests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GuestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the guest.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Guest guest) {
		entityCache.removeResult(
			GuestModelImpl.ENTITY_CACHE_ENABLED, GuestImpl.class,
			guest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Guest> guests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Guest guest : guests) {
			entityCache.removeResult(
				GuestModelImpl.ENTITY_CACHE_ENABLED, GuestImpl.class,
				guest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new guest with the primary key. Does not add the guest to the database.
	 *
	 * @param id the primary key for the new guest
	 * @return the new guest
	 */
	@Override
	public Guest create(int id) {
		Guest guest = new GuestImpl();

		guest.setNew(true);
		guest.setPrimaryKey(id);

		return guest;
	}

	/**
	 * Removes the guest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the guest
	 * @return the guest that was removed
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	@Override
	public Guest remove(int id) throws NoSuchGuestException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the guest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the guest
	 * @return the guest that was removed
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	@Override
	public Guest remove(Serializable primaryKey) throws NoSuchGuestException {
		Session session = null;

		try {
			session = openSession();

			Guest guest = (Guest)session.get(GuestImpl.class, primaryKey);

			if (guest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGuestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(guest);
		}
		catch (NoSuchGuestException nsee) {
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
	protected Guest removeImpl(Guest guest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(guest)) {
				guest = (Guest)session.get(
					GuestImpl.class, guest.getPrimaryKeyObj());
			}

			if (guest != null) {
				session.delete(guest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (guest != null) {
			clearCache(guest);
		}

		return guest;
	}

	@Override
	public Guest updateImpl(Guest guest) {
		boolean isNew = guest.isNew();

		if (!(guest instanceof GuestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(guest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(guest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in guest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Guest implementation " +
					guest.getClass());
		}

		GuestModelImpl guestModelImpl = (GuestModelImpl)guest;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (guest.getCreateDate() == null)) {
			if (serviceContext == null) {
				guest.setCreateDate(now);
			}
			else {
				guest.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!guestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				guest.setModifiedDate(now);
			}
			else {
				guest.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (guest.isNew()) {
				session.save(guest);

				guest.setNew(false);
			}
			else {
				guest = (Guest)session.merge(guest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!GuestModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			GuestModelImpl.ENTITY_CACHE_ENABLED, GuestImpl.class,
			guest.getPrimaryKey(), guest, false);

		guest.resetOriginalValues();

		return guest;
	}

	/**
	 * Returns the guest with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the guest
	 * @return the guest
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	@Override
	public Guest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGuestException {

		Guest guest = fetchByPrimaryKey(primaryKey);

		if (guest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGuestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return guest;
	}

	/**
	 * Returns the guest with the primary key or throws a <code>NoSuchGuestException</code> if it could not be found.
	 *
	 * @param id the primary key of the guest
	 * @return the guest
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	@Override
	public Guest findByPrimaryKey(int id) throws NoSuchGuestException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the guest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the guest
	 * @return the guest, or <code>null</code> if a guest with the primary key could not be found
	 */
	@Override
	public Guest fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the guests.
	 *
	 * @return the guests
	 */
	@Override
	public List<Guest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @return the range of guests
	 */
	@Override
	public List<Guest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the guests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of guests
	 */
	@Deprecated
	@Override
	public List<Guest> findAll(
		int start, int end, OrderByComparator<Guest> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guests
	 */
	@Override
	public List<Guest> findAll(
		int start, int end, OrderByComparator<Guest> orderByComparator) {

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

		List<Guest> list = (List<Guest>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GUEST);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GUEST;

				if (pagination) {
					sql = sql.concat(GuestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Guest>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Guest>)QueryUtil.list(
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
	 * Removes all the guests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Guest guest : findAll()) {
			remove(guest);
		}
	}

	/**
	 * Returns the number of guests.
	 *
	 * @return the number of guests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GUEST);

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
		return _SQL_SELECT_GUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GuestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the guest persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			GuestModelImpl.ENTITY_CACHE_ENABLED,
			GuestModelImpl.FINDER_CACHE_ENABLED, GuestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			GuestModelImpl.ENTITY_CACHE_ENABLED,
			GuestModelImpl.FINDER_CACHE_ENABLED, GuestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			GuestModelImpl.ENTITY_CACHE_ENABLED,
			GuestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByuserName = new FinderPath(
			GuestModelImpl.ENTITY_CACHE_ENABLED,
			GuestModelImpl.FINDER_CACHE_ENABLED, GuestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByuserName = new FinderPath(
			GuestModelImpl.ENTITY_CACHE_ENABLED,
			GuestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByuserName",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(GuestImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GUEST =
		"SELECT guest FROM Guest guest";

	private static final String _SQL_SELECT_GUEST_WHERE =
		"SELECT guest FROM Guest guest WHERE ";

	private static final String _SQL_COUNT_GUEST =
		"SELECT COUNT(guest) FROM Guest guest";

	private static final String _SQL_COUNT_GUEST_WHERE =
		"SELECT COUNT(guest) FROM Guest guest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "guest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Guest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Guest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GuestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"userName", "createDate", "modifiedDate"});

}