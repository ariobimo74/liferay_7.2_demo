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

package com.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Guest service. Represents a row in the &quot;Guest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.service.model.impl.GuestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.service.model.impl.GuestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Guest
 * @generated
 */
@ProviderType
public interface GuestModel extends BaseModel<Guest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a guest model instance should use the {@link Guest} interface instead.
	 */

	/**
	 * Returns the primary key of this guest.
	 *
	 * @return the primary key of this guest
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this guest.
	 *
	 * @param primaryKey the primary key of this guest
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this guest.
	 *
	 * @return the ID of this guest
	 */
	public int getId();

	/**
	 * Sets the ID of this guest.
	 *
	 * @param id the ID of this guest
	 */
	public void setId(int id);

	/**
	 * Returns the user name of this guest.
	 *
	 * @return the user name of this guest
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this guest.
	 *
	 * @param userName the user name of this guest
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this guest.
	 *
	 * @return the create date of this guest
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this guest.
	 *
	 * @param createDate the create date of this guest
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this guest.
	 *
	 * @return the modified date of this guest
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this guest.
	 *
	 * @param modifiedDate the modified date of this guest
	 */
	public void setModifiedDate(Date modifiedDate);

}