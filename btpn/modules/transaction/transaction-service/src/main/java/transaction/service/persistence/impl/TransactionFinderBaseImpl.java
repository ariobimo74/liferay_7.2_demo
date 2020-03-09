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

package transaction.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import transaction.model.Transaction;

import transaction.service.persistence.TransactionPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TransactionFinderBaseImpl
	extends BasePersistenceImpl<Transaction> {

	public TransactionFinderBaseImpl() {
		setModelClass(Transaction.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("createdOn", "created_on");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("updatedOn", "updated_on");
		dbColumnNames.put("updatedBy", "updated_by");
		dbColumnNames.put("deletedOn", "deleted_on");
		dbColumnNames.put("deletedBy", "deleted_by");
		dbColumnNames.put("isDelete", "is_delete");
		dbColumnNames.put("transactionDate", "transaction_date");
		dbColumnNames.put("transactionWith", "transaction_with");
		dbColumnNames.put("transactionTotal", "transaction_total");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getTransactionPersistence().getBadColumnNames();
	}

	/**
	 * Returns the transaction persistence.
	 *
	 * @return the transaction persistence
	 */
	public TransactionPersistence getTransactionPersistence() {
		return transactionPersistence;
	}

	/**
	 * Sets the transaction persistence.
	 *
	 * @param transactionPersistence the transaction persistence
	 */
	public void setTransactionPersistence(
		TransactionPersistence transactionPersistence) {

		this.transactionPersistence = transactionPersistence;
	}

	@BeanReference(type = TransactionPersistence.class)
	protected TransactionPersistence transactionPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		TransactionFinderBaseImpl.class);

}