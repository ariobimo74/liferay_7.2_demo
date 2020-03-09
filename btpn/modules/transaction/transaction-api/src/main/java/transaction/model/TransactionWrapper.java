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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Transaction}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Transaction
 * @generated
 */
@ProviderType
public class TransactionWrapper
	extends BaseModelWrapper<Transaction>
	implements Transaction, ModelWrapper<Transaction> {

	public TransactionWrapper(Transaction transaction) {
		super(transaction);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("updatedOn", getUpdatedOn());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("deletedOn", getDeletedOn());
		attributes.put("deletedBy", getDeletedBy());
		attributes.put("isDelete", isIsDelete());
		attributes.put("transactionDate", getTransactionDate());
		attributes.put("transactionWith", getTransactionWith());
		attributes.put("transactionTotal", getTransactionTotal());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date updatedOn = (Date)attributes.get("updatedOn");

		if (updatedOn != null) {
			setUpdatedOn(updatedOn);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date deletedOn = (Date)attributes.get("deletedOn");

		if (deletedOn != null) {
			setDeletedOn(deletedOn);
		}

		String deletedBy = (String)attributes.get("deletedBy");

		if (deletedBy != null) {
			setDeletedBy(deletedBy);
		}

		Boolean isDelete = (Boolean)attributes.get("isDelete");

		if (isDelete != null) {
			setIsDelete(isDelete);
		}

		Date transactionDate = (Date)attributes.get("transactionDate");

		if (transactionDate != null) {
			setTransactionDate(transactionDate);
		}

		Integer transactionWith = (Integer)attributes.get("transactionWith");

		if (transactionWith != null) {
			setTransactionWith(transactionWith);
		}

		Long transactionTotal = (Long)attributes.get("transactionTotal");

		if (transactionTotal != null) {
			setTransactionTotal(transactionTotal);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	 * Returns the created by of this transaction.
	 *
	 * @return the created by of this transaction
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created on of this transaction.
	 *
	 * @return the created on of this transaction
	 */
	@Override
	public Date getCreatedOn() {
		return model.getCreatedOn();
	}

	/**
	 * Returns the deleted by of this transaction.
	 *
	 * @return the deleted by of this transaction
	 */
	@Override
	public String getDeletedBy() {
		return model.getDeletedBy();
	}

	/**
	 * Returns the deleted on of this transaction.
	 *
	 * @return the deleted on of this transaction
	 */
	@Override
	public Date getDeletedOn() {
		return model.getDeletedOn();
	}

	/**
	 * Returns the ID of this transaction.
	 *
	 * @return the ID of this transaction
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the is delete of this transaction.
	 *
	 * @return the is delete of this transaction
	 */
	@Override
	public boolean getIsDelete() {
		return model.getIsDelete();
	}

	/**
	 * Returns the note of this transaction.
	 *
	 * @return the note of this transaction
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the primary key of this transaction.
	 *
	 * @return the primary key of this transaction
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the transaction date of this transaction.
	 *
	 * @return the transaction date of this transaction
	 */
	@Override
	public Date getTransactionDate() {
		return model.getTransactionDate();
	}

	/**
	 * Returns the transaction total of this transaction.
	 *
	 * @return the transaction total of this transaction
	 */
	@Override
	public long getTransactionTotal() {
		return model.getTransactionTotal();
	}

	/**
	 * Returns the transaction with of this transaction.
	 *
	 * @return the transaction with of this transaction
	 */
	@Override
	public int getTransactionWith() {
		return model.getTransactionWith();
	}

	/**
	 * Returns the updated by of this transaction.
	 *
	 * @return the updated by of this transaction
	 */
	@Override
	public String getUpdatedBy() {
		return model.getUpdatedBy();
	}

	/**
	 * Returns the updated on of this transaction.
	 *
	 * @return the updated on of this transaction
	 */
	@Override
	public Date getUpdatedOn() {
		return model.getUpdatedOn();
	}

	/**
	 * Returns <code>true</code> if this transaction is is delete.
	 *
	 * @return <code>true</code> if this transaction is is delete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDelete() {
		return model.isIsDelete();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created by of this transaction.
	 *
	 * @param createdBy the created by of this transaction
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created on of this transaction.
	 *
	 * @param createdOn the created on of this transaction
	 */
	@Override
	public void setCreatedOn(Date createdOn) {
		model.setCreatedOn(createdOn);
	}

	/**
	 * Sets the deleted by of this transaction.
	 *
	 * @param deletedBy the deleted by of this transaction
	 */
	@Override
	public void setDeletedBy(String deletedBy) {
		model.setDeletedBy(deletedBy);
	}

	/**
	 * Sets the deleted on of this transaction.
	 *
	 * @param deletedOn the deleted on of this transaction
	 */
	@Override
	public void setDeletedOn(Date deletedOn) {
		model.setDeletedOn(deletedOn);
	}

	/**
	 * Sets the ID of this transaction.
	 *
	 * @param id the ID of this transaction
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets whether this transaction is is delete.
	 *
	 * @param isDelete the is delete of this transaction
	 */
	@Override
	public void setIsDelete(boolean isDelete) {
		model.setIsDelete(isDelete);
	}

	/**
	 * Sets the note of this transaction.
	 *
	 * @param note the note of this transaction
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the primary key of this transaction.
	 *
	 * @param primaryKey the primary key of this transaction
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the transaction date of this transaction.
	 *
	 * @param transactionDate the transaction date of this transaction
	 */
	@Override
	public void setTransactionDate(Date transactionDate) {
		model.setTransactionDate(transactionDate);
	}

	/**
	 * Sets the transaction total of this transaction.
	 *
	 * @param transactionTotal the transaction total of this transaction
	 */
	@Override
	public void setTransactionTotal(long transactionTotal) {
		model.setTransactionTotal(transactionTotal);
	}

	/**
	 * Sets the transaction with of this transaction.
	 *
	 * @param transactionWith the transaction with of this transaction
	 */
	@Override
	public void setTransactionWith(int transactionWith) {
		model.setTransactionWith(transactionWith);
	}

	/**
	 * Sets the updated by of this transaction.
	 *
	 * @param updatedBy the updated by of this transaction
	 */
	@Override
	public void setUpdatedBy(String updatedBy) {
		model.setUpdatedBy(updatedBy);
	}

	/**
	 * Sets the updated on of this transaction.
	 *
	 * @param updatedOn the updated on of this transaction
	 */
	@Override
	public void setUpdatedOn(Date updatedOn) {
		model.setUpdatedOn(updatedOn);
	}

	@Override
	protected TransactionWrapper wrap(Transaction transaction) {
		return new TransactionWrapper(transaction);
	}

}