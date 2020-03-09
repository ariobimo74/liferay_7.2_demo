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
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Reference;
import transaction.model.Transaction;
import transaction.service.base.TransactionServiceBaseImpl;
import transaction.service.persistence.TransactionPersistence;

import java.util.List;

/**
 * The implementation of the transaction remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>transaction.service.TransactionService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionServiceBaseImpl
 */
public class TransactionServiceImpl extends TransactionServiceBaseImpl
{
	@Reference
	protected TransactionPersistence transactionPersistence;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>transaction.service.TransactionServiceUtil</code> to access the transaction remote service.
	 */
	public List<Transaction> getAllTransaction()
	{
		return transactionLocalService.getAllTransaction();
	}

	public List<Transaction> getTransactionById(int theId)
	{
		return transactionLocalService.getTransactionById(theId);
	}

	public Transaction addTransaction(long userId, int transactionWith, long transactionTotal, String note, ServiceContext serviceContext) throws PortalException
	{
		return transactionLocalService.addTransaction(userId, transactionWith, transactionTotal, note, serviceContext);
	}

	public List<Transaction> findTransactionbyId(int theId)
	{
		return transactionLocalService.findTransactionById(theId);
	}
}