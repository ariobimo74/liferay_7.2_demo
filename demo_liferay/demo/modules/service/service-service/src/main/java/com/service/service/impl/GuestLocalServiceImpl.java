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

package com.service.service.impl;

import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.service.model.Guest;
import com.service.service.base.GuestLocalServiceBaseImpl;


import java.util.Date;
import java.util.List;

/**
 * The implementation of the guest local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.service.service.GuestLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GuestLocalServiceBaseImpl
 */
public class GuestLocalServiceImpl extends GuestLocalServiceBaseImpl
{
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.service.service.GuestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.service.service.GuestLocalServiceUtil</code>.
	 */

	@Indexable(type = IndexableType.REINDEX)
	public Guest addGuest(int id, String userName) throws PortalException
	{
		User user = userLocalService.getUserById(id);

		Guest guest = guestPersistence.create(id);

		guest.setUserName(userName);
		guest.setCreateDate(new Date());

		guestPersistence.update(guest);

		return guest;
	}

	@Indexable(type = IndexableType.REINDEX)
	public Guest updateGuest(int id, String userName) throws PortalException
	{
		User user = userLocalService.getUserById(id);

		Guest guest = guestPersistence.findByPrimaryKey(id);

		guest.setUserName(userName);
		guest.setModifiedDate(new Date());

		guestPersistence.update(guest);

		return guest;
	}

	public List<Guest> getGuest(int start, int end)
	{
		return guestPersistence.findAll(start, end);
	}

	public List<Guest> getGuest(int start, int end, String orderByColumn, boolean isAsc)
	{
		return guestPersistence.findAll(start, end, comparator(orderByColumn, isAsc));
	}

	public int countByUserName(String userName)
	{
		return guestPersistence.countByuserName(userName);
	}

	public List<Guest> findByUserName(String userName, int start, int end, String orderByColumn, boolean isAsc)
	{
		return guestPersistence.findByuserName(userName, start, end, comparator(orderByColumn, isAsc));
	}

	public OrderByComparator<Guest> comparator(String columnn, boolean isAsc)
	{
		return OrderByComparatorFactoryUtil.create("guest", columnn, isAsc);
	}
}