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

package transaction.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Reference;
import transaction.model.Transaction;
import transaction.service.base.TransactionLocalServiceBaseImpl;
import transaction.service.persistence.TransactionPersistence;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the transaction local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>transaction.service.TransactionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLocalServiceBaseImpl
 */
public class TransactionLocalServiceImpl extends TransactionLocalServiceBaseImpl
{
	@Reference
	protected TransactionPersistence transactionPersistence;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>transaction.service.TransactionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>transaction.service.TransactionLocalServiceUtil</code>.
	 */

	public List<Transaction> getAllTransaction()
	{
		return transactionPersistence.findAll();
	}

	public List<Transaction> getTransactionById(int theId)
	{
		return transactionPersistence.findByid(theId);
	}

	public Transaction addTransaction(long userId, int transactionWith, long transactionTotal, String note, ServiceContext serviceContext) throws PortalException
	{
		int id = (int) counterLocalService.increment();
		Transaction transaction = transactionPersistence.create(id);

		Date now = new Date();
		User user = userLocalService.getUserById(userId);

		transaction.setCreatedOn(now);
		transaction.setCreatedBy(user.getFullName());
		transaction.setIsDelete(false);
		transaction.setTransactionDate(now);
		transaction.setTransactionWith(transactionWith);
		transaction.setTransactionTotal(transactionTotal);
		transaction.setNote(note);

		transactionPersistence.update(transaction);
		return transaction;
	}

	public List<Transaction> findTransactionById(int theId) throws SystemException
	{
		return transactionFinder.findTransactionById(theId);
	}
}