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

package transaction.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

import transaction.model.Transaction;

/**
 * The cache model class for representing Transaction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TransactionCacheModel
	implements CacheModel<Transaction>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TransactionCacheModel)) {
			return false;
		}

		TransactionCacheModel transactionCacheModel =
			(TransactionCacheModel)obj;

		if (id == transactionCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", updatedOn=");
		sb.append(updatedOn);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", deletedOn=");
		sb.append(deletedOn);
		sb.append(", deletedBy=");
		sb.append(deletedBy);
		sb.append(", isDelete=");
		sb.append(isDelete);
		sb.append(", transactionDate=");
		sb.append(transactionDate);
		sb.append(", transactionWith=");
		sb.append(transactionWith);
		sb.append(", transactionTotal=");
		sb.append(transactionTotal);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Transaction toEntityModel() {
		TransactionImpl transactionImpl = new TransactionImpl();

		transactionImpl.setId(id);

		if (createdOn == Long.MIN_VALUE) {
			transactionImpl.setCreatedOn(null);
		}
		else {
			transactionImpl.setCreatedOn(new Date(createdOn));
		}

		if (createdBy == null) {
			transactionImpl.setCreatedBy("");
		}
		else {
			transactionImpl.setCreatedBy(createdBy);
		}

		if (updatedOn == Long.MIN_VALUE) {
			transactionImpl.setUpdatedOn(null);
		}
		else {
			transactionImpl.setUpdatedOn(new Date(updatedOn));
		}

		if (updatedBy == null) {
			transactionImpl.setUpdatedBy("");
		}
		else {
			transactionImpl.setUpdatedBy(updatedBy);
		}

		if (deletedOn == Long.MIN_VALUE) {
			transactionImpl.setDeletedOn(null);
		}
		else {
			transactionImpl.setDeletedOn(new Date(deletedOn));
		}

		if (deletedBy == null) {
			transactionImpl.setDeletedBy("");
		}
		else {
			transactionImpl.setDeletedBy(deletedBy);
		}

		transactionImpl.setIsDelete(isDelete);

		if (transactionDate == Long.MIN_VALUE) {
			transactionImpl.setTransactionDate(null);
		}
		else {
			transactionImpl.setTransactionDate(new Date(transactionDate));
		}

		transactionImpl.setTransactionWith(transactionWith);
		transactionImpl.setTransactionTotal(transactionTotal);

		if (note == null) {
			transactionImpl.setNote("");
		}
		else {
			transactionImpl.setNote(note);
		}

		transactionImpl.resetOriginalValues();

		return transactionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		createdOn = objectInput.readLong();
		createdBy = objectInput.readUTF();
		updatedOn = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		deletedOn = objectInput.readLong();
		deletedBy = objectInput.readUTF();

		isDelete = objectInput.readBoolean();
		transactionDate = objectInput.readLong();

		transactionWith = objectInput.readInt();

		transactionTotal = objectInput.readLong();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);
		objectOutput.writeLong(createdOn);

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(updatedOn);

		if (updatedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeLong(deletedOn);

		if (deletedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deletedBy);
		}

		objectOutput.writeBoolean(isDelete);
		objectOutput.writeLong(transactionDate);

		objectOutput.writeInt(transactionWith);

		objectOutput.writeLong(transactionTotal);

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public int id;
	public long createdOn;
	public String createdBy;
	public long updatedOn;
	public String updatedBy;
	public long deletedOn;
	public String deletedBy;
	public boolean isDelete;
	public long transactionDate;
	public int transactionWith;
	public long transactionTotal;
	public String note;

}