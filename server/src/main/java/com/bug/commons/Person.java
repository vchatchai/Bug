//package com.bug.commons;
//
//import com.tinkerpop.frames.Adjacency;
//import com.tinkerpop.frames.Property;
//import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;
//
//public interface Person {
//	@Property("name")
//	public String getName();
//	
//	@Property("name")
//	public String setName(String name);
//
//	@Adjacency(label = "knows")
//	public Iterable<Person> getKnowsPeople();
//
//	@Adjacency(label = "knows")
//	public void addKnowsPerson(final Person person);
//
//	@GremlinGroovy("it.out('knows').out('knows').dedup") //Make sure you use the GremlinGroovy module! #1
//	  public Iterable<Person> getFriendsOfAFriend();
//}
