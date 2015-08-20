package com.bug.commons.dao.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import com.bug.commons.dao.annotation.Edge;
import com.bug.commons.dao.annotation.Id;
import com.bug.commons.dao.annotation.ModelType;
import com.bug.commons.dao.annotation.Property;
import com.bug.commons.dao.exception.DaoException;
import com.bug.shared.hcm.Employee;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanVertex;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

public abstract class GraphDaoAbstract<T> {
	private static final String vertexIdFieldName = "vertexId";

	public T createVertex(TitanGraph titanGraph, T vertex) throws Exception {
		// Class<?> clazz = vertex.getClass();
		//
		// ModelType modelType = clazz.getDeclaredAnnotation(ModelType.class);
		// TitanVertex titanVertex =
		// titanGraph.addVertex(modelType.value().toString());
		//
		// Field[] fields = clazz.getDeclaredFields();
		// for (Field field : fields) {
		// field.setAccessible(true);
		// Property property = field.getAnnotation(Property.class);
		// if (property != null) {
		// String key = property.value();
		// Object o = field.get(vertex);
		// if (o == null) {
		// titanVertex.property(key);
		// } else {
		//
		// titanVertex.property(key, o);
		// }
		// }
		//
		// Edge edge = field.getAnnotation(Edge.class);
		// if (edge != null) {
		// Object o = field.get(vertex);
		// if (!Objects.isNull(o)) {
		//// Field vertexIdField = getVertexIdField(o.getClass());
		//// Object vertexId = vertexIdField.get(o);
		// TitanVertex existingVertix = getVertex(titanGraph, vertex);
		// titanVertex.addEdge(edge.value(), existingVertix);
		// }
		// }
		// }
		TitanVertex titanVertex = addVertex(titanGraph, vertex);

		return mappingBean(vertex.getClass(), titanVertex);

	}

	private TitanVertex addVertex(TitanGraph titanGraph, Object obj) throws Exception {

		ModelType modelType = obj.getClass().getDeclaredAnnotation(ModelType.class);
		TitanVertex titanVertex = titanGraph.addVertex(modelType.value().toString());
		Field[] fields = obj.getClass().getDeclaredFields();

		Field vertexIdField = getVertexIdField(obj.getClass());
		Object vertexId = vertexIdField.get(obj);

		for (Field field : fields) {
			field.setAccessible(true);
			Property property = field.getAnnotation(Property.class);

			if (!Objects.isNull(property) && Objects.isNull(vertexId)) {
				String key = property.value();
				Object o = field.get(obj);
				if (o == null) {
					titanVertex.property(key);
				} else {

					titanVertex.property(key, o);
				}
			}

			Edge edge = field.getAnnotation(Edge.class);
			if (edge != null) {
				Object o = field.get(obj);
				if (!Objects.isNull(o)) {

					// TitanVertex existingVertix = getVertex(titanGraph, o);

					TitanVertex childVertex = addVertex(titanGraph, o);

					titanVertex.addEdge(edge.value(), childVertex);
				}
			}
		}
		return titanVertex;
	}

	public void deleteVertexById(TitanGraph titanGraph, T o) throws Exception {

		TitanVertex titanVertex = getVertex(titanGraph, o);

		if (!Objects.isNull(titanVertex) && !titanVertex.isRemoved()) {
			titanVertex.remove();
		}

	}

	public T getVertexById(TitanGraph titanGraph, T vertex) throws Exception {

		TitanVertex titanVertex = getVertex(titanGraph, vertex);
		return mappingBean(vertex.getClass(), titanVertex);

	}

	public <E> E edge(TitanGraph titanGraph, E vertex, String edgeName) throws Exception {

		Field[] fields = vertex.getClass().getDeclaredFields();
		Field selectedField = null;
		for (Field field : fields) {
			Edge edge = field.getAnnotation(Edge.class);
			if (edgeName.equals(edge.value())) {
				selectedField = field;
			}
		}

		// T t = (T) t.getClass().newInstance();
		// ModelType modelType = t.getClass().getAnnotation(ModelType.class);

		// String nodeName = modelType.value();

		Field field = getVertexIdField(vertex.getClass());
		Object o = field.get(vertex);
		GraphTraversal<Vertex, Vertex> graphTraversal = titanGraph.traversal().V(o).outE(edgeName).out();
		T t = null;
		if (graphTraversal.hasNext()) {
			TitanVertex titanVertex = (TitanVertex) graphTraversal.next();
			t = mappingBean(t.getClass(), titanVertex);

			selectedField.set(vertex, t);

		}

		return vertex;

	}

	public <E> E edge(TitanGraph titanGraph, E vertex) throws Exception {

		Field[] fields = vertex.getClass().getDeclaredFields();
		HashMap<String, Field> selectedFields = new HashMap<>();
		for (Field field : fields) {
			Edge edge = field.getAnnotation(Edge.class);
			if (!Objects.isNull(edge)) {
				selectedFields.put(edge.value(), field);
			}
		}

		// T t = (T) t.getClass().newInstance();
		// ModelType modelType = t.getClass().getAnnotation(ModelType.class);

		// String nodeName = modelType.value();

		Field vertexField = getVertexIdField(vertex.getClass());
		Object o = vertexField.get(vertex);
		ArrayList<String> arrayList = new ArrayList<>(selectedFields.keySet());
		String[] edges = arrayList.toArray(new String[arrayList.size()]);

		GraphTraversal<Vertex, Vertex> graphTraversal = titanGraph.traversal().V(o).out(edges);
		T t = null;
		if (graphTraversal.hasNext()) {
			TitanVertex titanVertex = (TitanVertex) graphTraversal.next();
			t = mappingBean(t.getClass(), titanVertex);

			// selectedField.set(vertex, t);

		}

		return vertex;

	}

	/**
	 * 
	 * @param titanGraph
	 * @param vertex
	 * @return
	 * @throws Exception
	 */
	private TitanVertex getVertex(TitanGraph titanGraph, T vertex) throws Exception {

		Class<?> clazz = vertex.getClass();
		ModelType modelType = clazz.getDeclaredAnnotation(ModelType.class);

		if (Objects.isNull(modelType)) {
			throw new Exception("Bean is not define model type");
		}

		Field vertexIdField = getVertexIdField(clazz);
		if (!Objects.isNull(vertexIdField)) {
			Long value = (Long) vertexIdField.get(vertex);
			GraphTraversal<Vertex, Vertex> graphTraversal = titanGraph.traversal().V(value);
			if (graphTraversal.hasNext()) {
				TitanVertex titanVertex = (TitanVertex) graphTraversal.next();
				return titanVertex;
			}

		}

		Field[] fields = clazz.getDeclaredFields();
		Id id = null;
		Property property = null;
		Field field = null;
		for (Field f : fields) {
			id = f.getAnnotation(Id.class);
			if (id != null) {

				property = f.getAnnotation(Property.class);
				f.setAccessible(true);
				field = f;
				break;
			}
		}

		if (id == null) {
			throw new DaoException("ID is null");
		}

		GraphTraversal<Vertex, Vertex> graphTraversal = titanGraph.traversal().V()
				.hasLabel(modelType.value().toString()).has(property.value(), field.get(vertex));

		if (graphTraversal.hasNext()) {
			TitanVertex titanVertex = (TitanVertex) graphTraversal.next();
			return titanVertex;
		}
		return null;
	}

	private Field getVertexIdField(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			if (vertexIdFieldName.equals(f.getName())) {
				return f;
			}
		}
		return null;

	}

	/**
	 * @param vertex
	 * @param titanVertex
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	protected T mappingBean(Class<?> vertexClass, TitanVertex titanVertex)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException {
		if (Objects.isNull(titanVertex)) {
			return null;
		}

		Object id = titanVertex.id();
		Class<?> t = createClass(vertexClass);
		Field[] fields = vertexClass.getDeclaredFields();
		Object obj = t.newInstance();

		Field versionIdField = t.getField(vertexIdFieldName);
		versionIdField.set(obj, id);

		T o = (T) obj;

		System.out.println("TitanVertex:" + titanVertex);
		for (Field f : fields) {
			Property p = f.getAnnotation(Property.class);
			if (!Objects.isNull(p)) {
				Object value = titanVertex.value(p.value());
				f.setAccessible(true);
				f.set(o, value);
			}

		}
		return o;
	}

	private static Class<?> createClass(Class<?> c) {

		Annotation[] annotations = c.getDeclaredAnnotations();

		Class<?> cls = new ByteBuddy().subclass(c).name(Employee.class.getName() + "Version")
				.defineField(vertexIdFieldName, Long.class, Modifier.PUBLIC).annotateType(annotations).make()
				.load(Employee.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded();

		return cls;
	}

}
