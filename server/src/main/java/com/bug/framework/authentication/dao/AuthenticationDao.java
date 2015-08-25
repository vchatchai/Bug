package com.bug.framework.authentication.dao;

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

public interface AuthenticationDao {

}
