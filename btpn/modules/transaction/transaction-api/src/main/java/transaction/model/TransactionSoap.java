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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link transaction.service.http.TransactionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TransactionSoap implements Serializable {

	public static TransactionSoap toSoapModel(Transaction model) {
		TransactionSoap soapModel = new TransactionSoap();

		soapModel.setId(model.getId());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setUpdatedOn(model.getUpdatedOn());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setDeletedOn(model.getDeletedOn());
		soapModel.setDeletedBy(model.getDeletedBy());
		soapModel.setIsDelete(model.isIsDelete());
		soapModel.setTransactionDate(model.getTransactionDate());
		soapModel.setTransactionWith(model.getTransactionWith());
		soapModel.setTransactionTotal(model.getTransactionTotal());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static TransactionSoap[] toSoapModels(Transaction[] models) {
		TransactionSoap[] soapModels = new TransactionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TransactionSoap[][] toSoapModels(Transaction[][] models) {
		TransactionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TransactionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TransactionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TransactionSoap[] toSoapModels(List<Transaction> models) {
		List<TransactionSoap> soapModels = new ArrayList<TransactionSoap>(
			models.size());

		for (Transaction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TransactionSoap[soapModels.size()]);
	}

	public TransactionSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Date getCreatedOn() {
		return _createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return _updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		_updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getDeletedOn() {
		return _deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		_deletedOn = deletedOn;
	}

	public String getDeletedBy() {
		return _deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		_deletedBy = deletedBy;
	}

	public boolean getIsDelete() {
		return _isDelete;
	}

	public boolean isIsDelete() {
		return _isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		_isDelete = isDelete;
	}

	public Date getTransactionDate() {
		return _transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		_transactionDate = transactionDate;
	}

	public int getTransactionWith() {
		return _transactionWith;
	}

	public void setTransactionWith(int transactionWith) {
		_transactionWith = transactionWith;
	}

	public long getTransactionTotal() {
		return _transactionTotal;
	}

	public void setTransactionTotal(long transactionTotal) {
		_transactionTotal = transactionTotal;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private int _id;
	private Date _createdOn;
	private String _createdBy;
	private Date _updatedOn;
	private String _updatedBy;
	private Date _deletedOn;
	private String _deletedBy;
	private boolean _isDelete;
	private Date _transactionDate;
	private int _transactionWith;
	private long _transactionTotal;
	private String _note;

}