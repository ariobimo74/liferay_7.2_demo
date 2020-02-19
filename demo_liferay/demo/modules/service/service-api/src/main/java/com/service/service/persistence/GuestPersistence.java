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

package com.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.service.exception.NoSuchGuestException;
import com.service.model.Guest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the guest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GuestUtil
 * @generated
 */
@ProviderType
public interface GuestPersistence extends BasePersistence<Guest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GuestUtil} to access the guest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the guest in the entity cache if it is enabled.
	 *
	 * @param guest the guest
	 */
	public void cacheResult(Guest guest);

	/**
	 * Caches the guests in the entity cache if it is enabled.
	 *
	 * @param guests the guests
	 */
	public void cacheResult(java.util.List<Guest> guests);

	/**
	 * Creates a new guest with the primary key. Does not add the guest to the database.
	 *
	 * @param id the primary key for the new guest
	 * @return the new guest
	 */
	public Guest create(int id);

	/**
	 * Removes the guest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the guest
	 * @return the guest that was removed
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	public Guest remove(int id) throws NoSuchGuestException;

	public Guest updateImpl(Guest guest);

	/**
	 * Returns the guest with the primary key or throws a <code>NoSuchGuestException</code> if it could not be found.
	 *
	 * @param id the primary key of the guest
	 * @return the guest
	 * @throws NoSuchGuestException if a guest with the primary key could not be found
	 */
	public Guest findByPrimaryKey(int id) throws NoSuchGuestException;

	/**
	 * Returns the guest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the guest
	 * @return the guest, or <code>null</code> if a guest with the primary key could not be found
	 */
	public Guest fetchByPrimaryKey(int id);

	/**
	 * Returns all the guests.
	 *
	 * @return the guests
	 */
	public java.util.List<Guest> findAll();

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
	public java.util.List<Guest> findAll(int start, int end);

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
	public java.util.List<Guest> findAll(
		int start, int end, OrderByComparator<Guest> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Guest> findAll(
		int start, int end, OrderByComparator<Guest> orderByComparator);

	/**
	 * Removes all the guests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of guests.
	 *
	 * @return the number of guests
	 */
	public int countAll();

}