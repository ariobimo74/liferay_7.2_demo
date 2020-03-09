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

package transaction.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import org.osgi.annotation.versioning.ProviderType;

import transaction.service.TransactionServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TransactionServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionServiceSoap
 * @generated
 */
@ProviderType
public class TransactionServiceHttp {

	public static java.util.List<transaction.model.Transaction>
		getAllTransaction(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				TransactionServiceUtil.class, "getAllTransaction",
				_getAllTransactionParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<transaction.model.Transaction>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<transaction.model.Transaction>
		getTransactionById(HttpPrincipal httpPrincipal, int theId) {

		try {
			MethodKey methodKey = new MethodKey(
				TransactionServiceUtil.class, "getTransactionById",
				_getTransactionByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, theId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<transaction.model.Transaction>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static transaction.model.Transaction addTransaction(
			HttpPrincipal httpPrincipal, long userId, int transactionWith,
			long transactionTotal, String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TransactionServiceUtil.class, "addTransaction",
				_addTransactionParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, transactionWith, transactionTotal, note,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (transaction.model.Transaction)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<transaction.model.Transaction>
		findTransactionbyId(HttpPrincipal httpPrincipal, int theId) {

		try {
			MethodKey methodKey = new MethodKey(
				TransactionServiceUtil.class, "findTransactionbyId",
				_findTransactionbyIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, theId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<transaction.model.Transaction>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TransactionServiceHttp.class);

	private static final Class<?>[] _getAllTransactionParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _getTransactionByIdParameterTypes1 =
		new Class[] {int.class};
	private static final Class<?>[] _addTransactionParameterTypes2 =
		new Class[] {
			long.class, int.class, long.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _findTransactionbyIdParameterTypes3 =
		new Class[] {int.class};

}