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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Transaction. This utility wraps
 * <code>transaction.service.impl.TransactionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TransactionService
 * @generated
 */
@ProviderType
public class TransactionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>transaction.service.impl.TransactionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static transaction.model.Transaction addTransaction(
			long userId, int transactionWith, long transactionTotal,
			String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTransaction(
			userId, transactionWith, transactionTotal, note, serviceContext);
	}

	public static java.util.List<transaction.model.Transaction>
		findTransactionbyId(int theId) {

		return getService().findTransactionbyId(theId);
	}

	public static java.util.List<transaction.model.Transaction>
		getAllTransaction() {

		return getService().getAllTransaction();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<transaction.model.Transaction>
		getTransactionById(int theId) {

		return getService().getTransactionById(theId);
	}

	public static TransactionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TransactionService, TransactionService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TransactionService.class);

		ServiceTracker<TransactionService, TransactionService> serviceTracker =
			new ServiceTracker<TransactionService, TransactionService>(
				bundle.getBundleContext(), TransactionService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}