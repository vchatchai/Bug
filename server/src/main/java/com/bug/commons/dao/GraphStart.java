package com.bug.commons.dao;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import com.bug.config.Configuration;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanTransaction;
import com.thinkaurelius.titan.core.TitanVertex;
import com.thinkaurelius.titan.core.log.LogProcessorFramework;

public class GraphStart {

	public static void main(String[] args) throws ConfigurationException, IOException {

		TitanGraph titanGraph = getConnection();

//		TitanGraph titanGraph1 = getConnection();
//		TitanGraph titanGraph2 = getConnection();
//
//		TitanGraph titanGraph3 = getConnection();
//
//		TitanGraph titanGraph4 = getConnection();
		
		
		
		
		TitanTransaction titanTransaction =  titanGraph.newTransaction();
		
		
		
		
		LogProcessorFramework logProcessorFramework = TitanFactory.openTransactionLog(titanGraph);
		logProcessorFramework.addLogProcessor("test");

		// TitanTransaction t = titanGraph.tx();

		GraphTraversalSource g = titanGraph.traversal();
		Vertex gt = g.V().has("name", "saturn").next();
		// VertexLabel vertexLabel = g.V

	

		// GraphOfTheGodsFactory.load(g);

		// saturn = g.V().has('name', 'saturn').next()

		// VertexLabel vertexLabel = titanGraph.getVertexLabel("Chatchai");

		 addVertex(titanTransaction);

//		VertexLabel vertexLabel = titanGraph.getVertexLabel("person");

		// System.out.println("variables:" + titanGraph.variables().asMap());

//		TitanTransaction titanTransaction = titanGraph.newTransaction();

//		Vertex vertex = titanTransaction.traversal().V().has("Name", "Chatchai").next();

		listVertex(titanTransaction);
		
//		printVertex(vertex);

		// t.commit();
		titanTransaction.close();
		titanGraph.close();

	}

	private static TitanGraph getConnection() throws IOException, ConfigurationException {
		TitanGraph titanGraph = TitanFactory.open(Configuration.getTitanConfiguration());
		return titanGraph;
	}

	public static void printVertex(Vertex v) {

		TitanVertex titanVertex = (TitanVertex) v;

		System.out.println("########Vertex Value" + titanVertex.vertexLabel());

		for (String key : titanVertex.keys()) {
			System.out.print(key + " : ");
//			System.out.println(v.value(key));
		}

		System.out.println("#########Vertex Value" + titanVertex.vertexLabel());
	}

	public static void listVertex(TitanTransaction titanTransaction) {
		GraphTraversal<Vertex, Vertex> graphTraversal = titanTransaction.traversal().V().hasLabel("person").has("Age", "2");
		while (graphTraversal.hasNext()) {
			printVertex(graphTraversal.next());
		}
	}

	public static void addVertex(TitanTransaction titanTransaction) {

//		TitanManagement mgmt =  titanTransaction.openMa
//		VertexLabel person = mgmt.getVertexLabel("person");
//		mgmt.commit();
		// Create a labeled vertex
		// person = titanGraph.addVertex( "person");
		// Create an unlabeled vertex

		// graph.tx().commit()

		TitanVertex titanVertex = titanTransaction.addVertex("person");
//		titanVertex.property("Name", "Chatchai");
//		titanVertex.property("Surname", "Chatchai");
//		titanVertex.property("LastName", "Vichai");
//		titanVertex.property("Age", "12");
//		titanVertex.property("Name", "A");
//		titanVertex.property("Surname", "A");
//		titanVertex.property("LastName", "A");
//		titanVertex.property("Age", "1");
//		titanVertex.property("Name", "D");
//		titanVertex.property("Surname", "D");
//		titanVertex.property("LastName", "D");
//		titanVertex.property("Age", "4");

//		titanVertex.property("Name", "E");
//		titanVertex.property("Surname", "E");
//		titanVertex.property("LastName", "E");
//		titanVertex.property("Age", "4");

//		titanVertex.property("Name", "F");
//		titanVertex.property("Surname", "F");
//		titanVertex.property("LastName", "F");
//		titanVertex.property("Age", "4");
//		titanVertex.property("value", BigDecimal.ZERO);
//		titanTransaction.
//		titanTransaction.commit();
//		titanTransaction.query().
//		titanTransaction.rollback();

	}

	// public static void frame( TitanGraph graph){
	// System.out.println("frame()");
	// TitanTransaction transactionalGraph = graph.newTransaction();
	//
	//
	//
	//
	//
	// transactionalGraph.commit();
	//
	//
	//
	//// TinkerGraph graph = TinkerGraphFactory.createTinkerGraph(); //This
	// graph is pre-populated.
	// FramedGraphFactory factory = new FramedGraphFactory(); //(1) Factories
	// should be reused for performance and memory conservation.
	//
	//// FramedGraphFactory factory = new FramedGraphFactory();
	// FramedTransactionalGraph<TransactionalGraph> transaction =
	// factory.create(graph);
	//
	// FramedGraph framedGraph = factory.create(graph); //Frame the graph.
	//
	// Person person = (Person) framedGraph.getVertex(1, Person.class);
	//// person.setName("Test");
	// System.out.println("Name" + person.getName()); // equals "marko"
	// }

}
