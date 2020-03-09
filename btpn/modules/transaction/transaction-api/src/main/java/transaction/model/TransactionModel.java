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

package transaction.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Transaction service. Represents a row in the &quot;transaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>transaction.model.impl.TransactionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>transaction.model.impl.TransactionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Transaction
 * @generated
 */
@ProviderType
public interface TransactionModel extends BaseModel<Transaction> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a transaction model instance should use the {@link Transaction} interface instead.
	 */

	/**
	 * Returns the primary key of this transaction.
	 *
	 * @return the primary key of this transaction
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this transaction.
	 *
	 * @param primaryKey the primary key of this transaction
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this transaction.
	 *
	 * @return the ID of this transaction
	 */
	public int getId();

	/**
	 * Sets the ID of this transaction.
	 *
	 * @param id the ID of this transaction
	 */
	public void setId(int id);

	/**
	 * Returns the created on of this transaction.
	 *
	 * @return the created on of this transaction
	 */
	public Date getCreatedOn();

	/**
	 * Sets the created on of this transaction.
	 *
	 * @param createdOn the created on of this transaction
	 */
	public void setCreatedOn(Date createdOn);

	/**
	 * Returns the created by of this transaction.
	 *
	 * @return the created by of this transaction
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this transaction.
	 *
	 * @param createdBy the created by of this transaction
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the updated on of this transaction.
	 *
	 * @return the updated on of this transaction
	 */
	public Date getUpdatedOn();

	/**
	 * Sets the updated on of this transaction.
	 *
	 * @param updatedOn the updated on of this transaction
	 */
	public void setUpdatedOn(Date updatedOn);

	/**
	 * Returns the updated by of this transaction.
	 *
	 * @return the updated by of this transaction
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this transaction.
	 *
	 * @param updatedBy the updated by of this transaction
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the deleted on of this transaction.
	 *
	 * @return the deleted on of this transaction
	 */
	public Date getDeletedOn();

	/**
	 * Sets the deleted on of this transaction.
	 *
	 * @param deletedOn the deleted on of this transaction
	 */
	public void setDeletedOn(Date deletedOn);

	/**
	 * Returns the deleted by of this transaction.
	 *
	 * @return the deleted by of this transaction
	 */
	@AutoEscape
	public String getDeletedBy();

	/**
	 * Sets the deleted by of this transaction.
	 *
	 * @param deletedBy the deleted by of this transaction
	 */
	public void setDeletedBy(String deletedBy);

	/**
	 * Returns the is delete of this transaction.
	 *
	 * @return the is delete of this transaction
	 */
	public boolean getIsDelete();

	/**
	 * Returns <code>true</code> if this transaction is is delete.
	 *
	 * @return <code>true</code> if this transaction is is delete; <code>false</code> otherwise
	 */
	public boolean isIsDelete();

	/**
	 * Sets whether this transaction is is delete.
	 *
	 * @param isDelete the is delete of this transaction
	 */
	public void setIsDelete(boolean isDelete);

	/**
	 * Returns the transaction date of this transaction.
	 *
	 * @return the transaction date of this transaction
	 */
	public Date getTransactionDate();

	/**
	 * Sets the transaction date of this transaction.
	 *
	 * @param transactionDate the transaction date of this transaction
	 */
	public void setTransactionDate(Date transactionDate);

	/**
	 * Returns the transaction with of this transaction.
	 *
	 * @return the transaction with of this transaction
	 */
	public int getTransactionWith();

	/**
	 * Sets the transaction with of this transaction.
	 *
	 * @param transactionWith the transaction with of this transaction
	 */
	public void setTransactionWith(int transactionWith);

	/**
	 * Returns the transaction total of this transaction.
	 *
	 * @return the transaction total of this transaction
	 */
	public long getTransactionTotal();

	/**
	 * Sets the transaction total of this transaction.
	 *
	 * @param transactionTotal the transaction total of this transaction
	 */
	public void setTransactionTotal(long transactionTotal);

	/**
	 * Returns the note of this transaction.
	 *
	 * @return the note of this transaction
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this transaction.
	 *
	 * @param note the note of this transaction
	 */
	public void setNote(String note);

}