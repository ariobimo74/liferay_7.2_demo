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

package com.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link GuestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GuestLocalService
 * @generated
 */
@ProviderType
public class GuestLocalServiceWrapper
	implements GuestLocalService, ServiceWrapper<GuestLocalService> {

	public GuestLocalServiceWrapper(GuestLocalService guestLocalService) {
		_guestLocalService = guestLocalService;
	}

	/**
	 * Adds the guest to the database. Also notifies the appropriate model listeners.
	 *
	 * @param guest the guest
	 * @return the guest that was added
	 */
	@Override
	public com.service.model.Guest addGuest(com.service.model.Guest guest) {
		return _guestLocalService.addGuest(guest);
	}

	/**
	 * Creates a new guest with the primary key. Does not add the guest to the database.
	 *
	 * @param id the primary key for the new guest
	 * @return the new guest
	 */
	@Override
	public com.service.model.Guest createGuest(int id) {
		return _guestLocalService.createGuest(id);
	}

	/**
	 * Deletes the guest from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guest the guest
	 * @return the guest that was removed
	 */
	@Override
	public com.service.model.Guest deleteGuest(com.service.model.Guest guest) {
		return _guestLocalService.deleteGuest(guest);
	}

	/**
	 * Deletes the guest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the guest
	 * @return the guest that was removed
	 * @throws PortalException if a guest with the primary key could not be found
	 */
	@Override
	public com.service.model.Guest deleteGuest(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestLocalService.deleteGuest(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _guestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.service.model.impl.GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _guestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.service.model.impl.GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _guestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _guestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _guestLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.service.model.Guest fetchGuest(int id) {
		return _guestLocalService.fetchGuest(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _guestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the guest with the primary key.
	 *
	 * @param id the primary key of the guest
	 * @return the guest
	 * @throws PortalException if a guest with the primary key could not be found
	 */
	@Override
	public com.service.model.Guest getGuest(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestLocalService.getGuest(id);
	}

	/**
	 * Returns a range of all the guests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.service.model.impl.GuestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of guests
	 * @param end the upper bound of the range of guests (not inclusive)
	 * @return the range of guests
	 */
	@Override
	public java.util.List<com.service.model.Guest> getGuests(
		int start, int end) {

		return _guestLocalService.getGuests(start, end);
	}

	/**
	 * Returns the number of guests.
	 *
	 * @return the number of guests
	 */
	@Override
	public int getGuestsCount() {
		return _guestLocalService.getGuestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _guestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the guest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param guest the guest
	 * @return the guest that was updated
	 */
	@Override
	public com.service.model.Guest updateGuest(com.service.model.Guest guest) {
		return _guestLocalService.updateGuest(guest);
	}

	@Override
	public GuestLocalService getWrappedService() {
		return _guestLocalService;
	}

	@Override
	public void setWrappedService(GuestLocalService guestLocalService) {
		_guestLocalService = guestLocalService;
	}

	private GuestLocalService _guestLocalService;

}