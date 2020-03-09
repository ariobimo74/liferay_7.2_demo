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

package transaction.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TransactionService}.
 *
 * @author Brian Wing Shun Chan
 * @see TransactionService
 * @generated
 */
@ProviderType
public class TransactionServiceWrapper
	implements TransactionService, ServiceWrapper<TransactionService> {

	public TransactionServiceWrapper(TransactionService transactionService) {
		_transactionService = transactionService;
	}

	@Override
	public transaction.model.Transaction addTransaction(
			long userId, int transactionWith, long transactionTotal,
			String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionService.addTransaction(
			userId, transactionWith, transactionTotal, note, serviceContext);
	}

	@Override
	public java.util.List<transaction.model.Transaction> findTransactionbyId(
		int theId) {

		return _transactionService.findTransactionbyId(theId);
	}

	@Override
	public java.util.List<transaction.model.Transaction> getAllTransaction() {
		return _transactionService.getAllTransaction();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _transactionService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<transaction.model.Transaction> getTransactionById(
		int theId) {

		return _transactionService.getTransactionById(theId);
	}

	@Override
	public TransactionService getWrappedService() {
		return _transactionService;
	}

	@Override
	public void setWrappedService(TransactionService transactionService) {
		_transactionService = transactionService;
	}

	private TransactionService _transactionService;

}