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
 * Provides the local service utility for Transaction. This utility wraps
 * <code>transaction.service.impl.TransactionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLocalService
 * @generated
 */
@ProviderType
public class TransactionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>transaction.service.impl.TransactionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static transaction.model.Transaction addTransaction(
			long userId, int transactionWith, long transactionTotal,
			String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTransaction(
			userId, transactionWith, transactionTotal, note, serviceContext);
	}

	/**
	 * Adds the transaction to the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaction the transaction
	 * @return the transaction that was added
	 */
	public static transaction.model.Transaction addTransaction(
		transaction.model.Transaction transaction) {

		return getService().addTransaction(transaction);
	}

	/**
	 * Creates a new transaction with the primary key. Does not add the transaction to the database.
	 *
	 * @param id the primary key for the new transaction
	 * @return the new transaction
	 */
	public static transaction.model.Transaction createTransaction(int id) {
		return getService().createTransaction(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws PortalException if a transaction with the primary key could not be found
	 */
	public static transaction.model.Transaction deleteTransaction(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTransaction(id);
	}

	/**
	 * Deletes the transaction from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaction the transaction
	 * @return the transaction that was removed
	 */
	public static transaction.model.Transaction deleteTransaction(
		transaction.model.Transaction transaction) {

		return getService().deleteTransaction(transaction);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>transaction.model.impl.TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>transaction.model.impl.TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static transaction.model.Transaction fetchTransaction(int id) {
		return getService().fetchTransaction(id);
	}

	public static java.util.List<transaction.model.Transaction>
			findTransactionById(int theId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findTransactionById(theId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<transaction.model.Transaction>
		getAllTransaction() {

		return getService().getAllTransaction();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the transaction with the primary key.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction
	 * @throws PortalException if a transaction with the primary key could not be found
	 */
	public static transaction.model.Transaction getTransaction(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTransaction(id);
	}

	public static java.util.List<transaction.model.Transaction>
		getTransactionById(int theId) {

		return getService().getTransactionById(theId);
	}

	/**
	 * Returns a range of all the transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>transaction.model.impl.TransactionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transactions
	 * @param end the upper bound of the range of transactions (not inclusive)
	 * @return the range of transactions
	 */
	public static java.util.List<transaction.model.Transaction> getTransactions(
		int start, int end) {

		return getService().getTransactions(start, end);
	}

	/**
	 * Returns the number of transactions.
	 *
	 * @return the number of transactions
	 */
	public static int getTransactionsCount() {
		return getService().getTransactionsCount();
	}

	/**
	 * Updates the transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param transaction the transaction
	 * @return the transaction that was updated
	 */
	public static transaction.model.Transaction updateTransaction(
		transaction.model.Transaction transaction) {

		return getService().updateTransaction(transaction);
	}

	public static TransactionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TransactionLocalService, TransactionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TransactionLocalService.class);

		ServiceTracker<TransactionLocalService, TransactionLocalService>
			serviceTracker =
				new ServiceTracker
					<TransactionLocalService, TransactionLocalService>(
						bundle.getBundleContext(),
						TransactionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}