package com.bug.commons.dao.cassandra;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Table;

public abstract class CassandraDao<T> implements CommonDao<T> {

	public void save(T t) throws Exception {
		Table modelType = t.getClass().getAnnotation(Table.class);
		String table = modelType.name();

		Field[] fields = t.getClass().getDeclaredFields();

		Map<String, Object> preparInsert = new HashMap<>();
		for (Field f : fields) {
			Column property = f.getAnnotation(Column.class);
			if (Objects.isNull(property)) {
				throw new Exception("ERROR " + f.getName() + "does not have property anotation");
			}
			String columnName = property.name();
			f.setAccessible(true);
			Object value = f.get(t);
			preparInsert.put(columnName, value);
		}

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("INSERT INTO ");
		stringBuffer.append(table);
		stringBuffer.append(" ( ");

		StringBuffer parameter = new StringBuffer();
		for (Entry<String, Object> entry : preparInsert.entrySet()) {
			stringBuffer.append(entry.getKey());
			stringBuffer.append(",");

			parameter.append("?");
			parameter.append(",");

		}
		stringBuffer.deleteCharAt(stringBuffer.length() - 1);
		parameter.deleteCharAt(parameter.length() - 1);

		stringBuffer.append(" ) VALUES (");
		stringBuffer.append(parameter);
		stringBuffer.append(" ) ");

		System.out.println("Sql:" + stringBuffer.toString());
	}

	@Override
	public void edit(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public T getBeanById(String b) {
		// TODO Auto-generated method stub
		return null;
	}
}
