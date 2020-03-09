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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

import transaction.model.Transaction;
import transaction.model.TransactionModel;
import transaction.model.TransactionSoap;

/**
 * The base model implementation for the Transaction service. Represents a row in the &quot;transaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TransactionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TransactionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TransactionModelImpl
	extends BaseModelImpl<Transaction> implements TransactionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a transaction model instance should use the <code>Transaction</code> interface instead.
	 */
	public static final String TABLE_NAME = "transaction";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.INTEGER}, {"created_on", Types.TIMESTAMP},
		{"created_by", Types.VARCHAR}, {"updated_on", Types.TIMESTAMP},
		{"updated_by", Types.VARCHAR}, {"deleted_on", Types.TIMESTAMP},
		{"deleted_by", Types.VARCHAR}, {"is_delete", Types.BOOLEAN},
		{"transaction_date", Types.TIMESTAMP},
		{"transaction_with", Types.INTEGER},
		{"transaction_total", Types.BIGINT}, {"note", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("created_on", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("updated_on", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updated_by", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted_on", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("deleted_by", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("is_delete", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("transaction_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("transaction_with", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("transaction_total", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("note", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table transaction (id INTEGER not null primary key,created_on DATE null,created_by VARCHAR(75) null,updated_on DATE null,updated_by VARCHAR(75) null,deleted_on DATE null,deleted_by VARCHAR(75) null,is_delete BOOLEAN,transaction_date DATE null,transaction_with INTEGER,transaction_total LONG,note VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table transaction";

	public static final String ORDER_BY_JPQL =
		" ORDER BY transaction.transactionDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY transaction.transaction_date ASC";

	public static final String DATA_SOURCE = "transactionDatasource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		transaction.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.transaction.model.Transaction"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		transaction.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.transaction.model.Transaction"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		transaction.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.transaction.model.Transaction"),
		true);

	public static final long ID_COLUMN_BITMASK = 1L;

	public static final long TRANSACTIONDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Transaction toModel(TransactionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Transaction model = new TransactionImpl();

		model.setId(soapModel.getId());
		model.setCreatedOn(soapModel.getCreatedOn());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setUpdatedOn(soapModel.getUpdatedOn());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setDeletedOn(soapModel.getDeletedOn());
		model.setDeletedBy(soapModel.getDeletedBy());
		model.setIsDelete(soapModel.isIsDelete());
		model.setTransactionDate(soapModel.getTransactionDate());
		model.setTransactionWith(soapModel.getTransactionWith());
		model.setTransactionTotal(soapModel.getTransactionTotal());
		model.setNote(soapModel.getNote());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Transaction> toModels(TransactionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Transaction> models = new ArrayList<Transaction>(
			soapModels.length);

		for (TransactionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		transaction.service.util.ServiceProps.get(
			"lock.expiration.time.transaction.model.Transaction"));

	public TransactionModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Transaction.class;
	}

	@Override
	public String getModelClassName() {
		return Transaction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Transaction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Transaction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Transaction, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Transaction)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Transaction, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Transaction, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Transaction)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Transaction, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Transaction, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Transaction>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Transaction.class.getClassLoader(), Transaction.class,
			ModelWrapper.class);

		try {
			Constructor<Transaction> constructor =
				(Constructor<Transaction>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Transaction, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Transaction, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Transaction, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Transaction, Object>>();
		Map<String, BiConsumer<Transaction, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Transaction, ?>>();

		attributeGetterFunctions.put("id", Transaction::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Transaction, Integer>)Transaction::setId);
		attributeGetterFunctions.put("createdOn", Transaction::getCreatedOn);
		attributeSetterBiConsumers.put(
			"createdOn",
			(BiConsumer<Transaction, Date>)Transaction::setCreatedOn);
		attributeGetterFunctions.put("createdBy", Transaction::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<Transaction, String>)Transaction::setCreatedBy);
		attributeGetterFunctions.put("updatedOn", Transaction::getUpdatedOn);
		attributeSetterBiConsumers.put(
			"updatedOn",
			(BiConsumer<Transaction, Date>)Transaction::setUpdatedOn);
		attributeGetterFunctions.put("updatedBy", Transaction::getUpdatedBy);
		attributeSetterBiConsumers.put(
			"updatedBy",
			(BiConsumer<Transaction, String>)Transaction::setUpdatedBy);
		attributeGetterFunctions.put("deletedOn", Transaction::getDeletedOn);
		attributeSetterBiConsumers.put(
			"deletedOn",
			(BiConsumer<Transaction, Date>)Transaction::setDeletedOn);
		attributeGetterFunctions.put("deletedBy", Transaction::getDeletedBy);
		attributeSetterBiConsumers.put(
			"deletedBy",
			(BiConsumer<Transaction, String>)Transaction::setDeletedBy);
		attributeGetterFunctions.put("isDelete", Transaction::getIsDelete);
		attributeSetterBiConsumers.put(
			"isDelete",
			(BiConsumer<Transaction, Boolean>)Transaction::setIsDelete);
		attributeGetterFunctions.put(
			"transactionDate", Transaction::getTransactionDate);
		attributeSetterBiConsumers.put(
			"transactionDate",
			(BiConsumer<Transaction, Date>)Transaction::setTransactionDate);
		attributeGetterFunctions.put(
			"transactionWith", Transaction::getTransactionWith);
		attributeSetterBiConsumers.put(
			"transactionWith",
			(BiConsumer<Transaction, Integer>)Transaction::setTransactionWith);
		attributeGetterFunctions.put(
			"transactionTotal", Transaction::getTransactionTotal);
		attributeSetterBiConsumers.put(
			"transactionTotal",
			(BiConsumer<Transaction, Long>)Transaction::setTransactionTotal);
		attributeGetterFunctions.put("note", Transaction::getNote);
		attributeSetterBiConsumers.put(
			"note", (BiConsumer<Transaction, String>)Transaction::setNote);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		_columnBitmask |= ID_COLUMN_BITMASK;

		if (!_setOriginalId) {
			_setOriginalId = true;

			_originalId = _id;
		}

		_id = id;
	}

	public int getOriginalId() {
		return _originalId;
	}

	@JSON
	@Override
	public Date getCreatedOn() {
		return _createdOn;
	}

	@Override
	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return "";
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getUpdatedOn() {
		return _updatedOn;
	}

	@Override
	public void setUpdatedOn(Date updatedOn) {
		_updatedOn = updatedOn;
	}

	@JSON
	@Override
	public String getUpdatedBy() {
		if (_updatedBy == null) {
			return "";
		}
		else {
			return _updatedBy;
		}
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	@JSON
	@Override
	public Date getDeletedOn() {
		return _deletedOn;
	}

	@Override
	public void setDeletedOn(Date deletedOn) {
		_deletedOn = deletedOn;
	}

	@JSON
	@Override
	public String getDeletedBy() {
		if (_deletedBy == null) {
			return "";
		}
		else {
			return _deletedBy;
		}
	}

	@Override
	public void setDeletedBy(String deletedBy) {
		_deletedBy = deletedBy;
	}

	@JSON
	@Override
	public boolean getIsDelete() {
		return _isDelete;
	}

	@JSON
	@Override
	public boolean isIsDelete() {
		return _isDelete;
	}

	@Override
	public void setIsDelete(boolean isDelete) {
		_isDelete = isDelete;
	}

	@JSON
	@Override
	public Date getTransactionDate() {
		return _transactionDate;
	}

	@Override
	public void setTransactionDate(Date transactionDate) {
		_columnBitmask = -1L;

		_transactionDate = transactionDate;
	}

	@JSON
	@Override
	public int getTransactionWith() {
		return _transactionWith;
	}

	@Override
	public void setTransactionWith(int transactionWith) {
		_transactionWith = transactionWith;
	}

	@JSON
	@Override
	public long getTransactionTotal() {
		return _transactionTotal;
	}

	@Override
	public void setTransactionTotal(long transactionTotal) {
		_transactionTotal = transactionTotal;
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return "";
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		_note = note;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Transaction toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Transaction>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TransactionImpl transactionImpl = new TransactionImpl();

		transactionImpl.setId(getId());
		transactionImpl.setCreatedOn(getCreatedOn());
		transactionImpl.setCreatedBy(getCreatedBy());
		transactionImpl.setUpdatedOn(getUpdatedOn());
		transactionImpl.setUpdatedBy(getUpdatedBy());
		transactionImpl.setDeletedOn(getDeletedOn());
		transactionImpl.setDeletedBy(getDeletedBy());
		transactionImpl.setIsDelete(isIsDelete());
		transactionImpl.setTransactionDate(getTransactionDate());
		transactionImpl.setTransactionWith(getTransactionWith());
		transactionImpl.setTransactionTotal(getTransactionTotal());
		transactionImpl.setNote(getNote());

		transactionImpl.resetOriginalValues();

		return transactionImpl;
	}

	@Override
	public int compareTo(Transaction transaction) {
		int value = 0;

		value = DateUtil.compareTo(
			getTransactionDate(), transaction.getTransactionDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Transaction)) {
			return false;
		}

		Transaction transaction = (Transaction)obj;

		int primaryKey = transaction.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TransactionModelImpl transactionModelImpl = this;

		transactionModelImpl._originalId = transactionModelImpl._id;

		transactionModelImpl._setOriginalId = false;

		transactionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Transaction> toCacheModel() {
		TransactionCacheModel transactionCacheModel =
			new TransactionCacheModel();

		transactionCacheModel.id = getId();

		Date createdOn = getCreatedOn();

		if (createdOn != null) {
			transactionCacheModel.createdOn = createdOn.getTime();
		}
		else {
			transactionCacheModel.createdOn = Long.MIN_VALUE;
		}

		transactionCacheModel.createdBy = getCreatedBy();

		String createdBy = transactionCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			transactionCacheModel.createdBy = null;
		}

		Date updatedOn = getUpdatedOn();

		if (updatedOn != null) {
			transactionCacheModel.updatedOn = updatedOn.getTime();
		}
		else {
			transactionCacheModel.updatedOn = Long.MIN_VALUE;
		}

		transactionCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = transactionCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			transactionCacheModel.updatedBy = null;
		}

		Date deletedOn = getDeletedOn();

		if (deletedOn != null) {
			transactionCacheModel.deletedOn = deletedOn.getTime();
		}
		else {
			transactionCacheModel.deletedOn = Long.MIN_VALUE;
		}

		transactionCacheModel.deletedBy = getDeletedBy();

		String deletedBy = transactionCacheModel.deletedBy;

		if ((deletedBy != null) && (deletedBy.length() == 0)) {
			transactionCacheModel.deletedBy = null;
		}

		transactionCacheModel.isDelete = isIsDelete();

		Date transactionDate = getTransactionDate();

		if (transactionDate != null) {
			transactionCacheModel.transactionDate = transactionDate.getTime();
		}
		else {
			transactionCacheModel.transactionDate = Long.MIN_VALUE;
		}

		transactionCacheModel.transactionWith = getTransactionWith();

		transactionCacheModel.transactionTotal = getTransactionTotal();

		transactionCacheModel.note = getNote();

		String note = transactionCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			transactionCacheModel.note = null;
		}

		return transactionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Transaction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Transaction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Transaction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Transaction)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Transaction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Transaction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Transaction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Transaction)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Transaction>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _id;
	private int _originalId;
	private boolean _setOriginalId;
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
	private long _columnBitmask;
	private Transaction _escapedModel;

}