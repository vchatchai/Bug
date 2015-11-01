package com.bug.commons.dao.cassandra;

public interface CommonDao<T> {
	public void save(T t) throws Exception;

	public void edit(T t);

	public void delete(T t);

	public T getBeanById(String b);

}
