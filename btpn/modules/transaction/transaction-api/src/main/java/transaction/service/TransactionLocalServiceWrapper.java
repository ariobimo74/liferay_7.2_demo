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
 * Provides a wrapper for {@link TransactionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLocalService
 * @generated
 */
@ProviderType
public class TransactionLocalServiceWrapper
	implements TransactionLocalService,
			   ServiceWrapper<TransactionLocalService> {

	public TransactionLocalServiceWrapper(
		TransactionLocalService transactionLocalService) {

		_transactionLocalService = transactionLocalService;
	}

	@Override
	public transaction.model.Transaction addTransaction(
			long userId, int transactionWith, long transactionTotal,
			String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLocalService.addTransaction(
			userId, transactionWith, transactionTotal, note, serviceContext);
	}

	/**
	 * Adds the transaction to the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaction the transaction
	 * @return the transaction that was added
	 */
	@Override
	public transaction.model.Transaction addTransaction(
		transaction.model.Transaction transaction) {

		return _transactionLocalService.addTransaction(transaction);
	}

	/**
	 * Creates a new transaction with the primary key. Does not add the transaction to the database.
	 *
	 * @param id the primary key for the new transaction
	 * @return the new transaction
	 */
	@Override
	public transaction.model.Transaction createTransaction(int id) {
		return _transactionLocalService.createTransaction(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws PortalException if a transaction with the primary key could not be found
	 */
	@Override
	public transaction.model.Transaction deleteTransaction(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLocalService.deleteTransaction(id);
	}

	/**
	 * Deletes the transaction from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaction the transaction
	 * @return the transaction that was removed
	 */
	@Override
	public transaction.model.Transaction deleteTransaction(
		transaction.model.Transaction transaction) {

		return _transactionLocalService.deleteTransaction(transaction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _transactionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _transactionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _transactionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _transactionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _transactionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _transactionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public transaction.model.Transaction fetchTransaction(int id) {
		return _transactionLocalService.fetchTransaction(id);
	}

	@Override
	public java.util.List<transaction.model.Transaction> findTransactionById(
			int theId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _transactionLocalService.findTransactionById(theId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _transactionLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<transaction.model.Transaction> getAllTransaction() {
		return _transactionLocalService.getAllTransaction();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _transactionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _transactionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the transaction with the primary key.
	 *
	 * @param id the primary key of the transaction
	 * @return the transaction
	 * @throws PortalException if a transaction with the primary key could not be found
	 */
	@Override
	public transaction.model.Transaction getTransaction(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLocalService.getTransaction(id);
	}

	@Override
	public java.util.List<transaction.model.Transaction> getTransactionById(
		int theId) {

		return _transactionLocalService.getTransactionById(theId);
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
	@Override
	public java.util.List<transaction.model.Transaction> getTransactions(
		int start, int end) {

		return _transactionLocalService.getTransactions(start, end);
	}

	/**
	 * Returns the number of transactions.
	 *
	 * @return the number of transactions
	 */
	@Override
	public int getTransactionsCount() {
		return _transactionLocalService.getTransactionsCount();
	}

	/**
	 * Updates the transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param transaction the transaction
	 * @return the transaction that was updated
	 */
	@Override
	public transaction.model.Transaction updateTransaction(
		transaction.model.Transaction transaction) {

		return _transactionLocalService.updateTransaction(transaction);
	}

	@Override
	public TransactionLocalService getWrappedService() {
		return _transactionLocalService;
	}

	@Override
	public void setWrappedService(
		TransactionLocalService transactionLocalService) {

		_transactionLocalService = transactionLocalService;
	}

	private TransactionLocalService _transactionLocalService;

}