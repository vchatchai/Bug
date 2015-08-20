package com.bug.commons.dao;

import java.util.List;

import org.apache.tinkerpop.gremlin.structure.T;

import com.bug.commons.dao.exception.DaoException;
import com.thinkaurelius.titan.core.TitanGraph;

public interface GraphDao {

	public void createVertex(TitanGraph titanGraph, T object) throws IllegalArgumentException, IllegalAccessException ;

	public void deleteVertexById(TitanGraph titanGraph, T vertex)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, DaoException ;
	public <E> List<T> relatedVertexParameter(E vertext) ;
	public T getVertexById(TitanGraph titanGraph, T t)
			throws IllegalArgumentException, IllegalAccessException, DaoException, InstantiationException ;

}
