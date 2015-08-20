package com.bug.commons.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.bug.shared.hcm.Employee;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType.Loaded;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.pool.TypePool;

public class ByteBuddyTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ByteBuddyAgent.installOnOpenJDK();
		Foo foo = new Foo();
		System.out.println(foo.m());
		// new
		// ByteBuddy().redefine(Bar.class).name(Foo.class.getName()).make().load(Foo.class.getClassLoader(),
		// ClassReloadingStrategy.fromInstalledAgent());
		//

		testAddField();

		Class<?> cls = createClass(Employee.class);

		Employee e = (Employee) cls.newInstance();
		System.out.println(cls.getSuperclass());

		System.out.println("Lists of field");
		for (Field fe : cls.getDeclaredFields()) {
			System.out.println(fe.getName());
		}

	}

	public static void testAddField() {
		String classPath = "com.bug.commons.dao.impl.Foo";// Foo.class.getName();
		TypePool typePool = TypePool.Default.ofClassPath();
		Loaded<Object> loaded = new ByteBuddy()
				.redefine(typePool.describe(classPath).resolve(), // do not use
																	// 'Bar.class'
				ClassFileLocator.ForClassLoader.ofClassPath())
				.defineField("qux", String.class) // we learn more about
													// defining fields later
				.make().load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION);
		Class cls =   loaded.getLoaded();
//		assertThat(Bar.class.getDeclaredField("qux"), notNullValue());
		System.out.println("Lists of field:testAddField " + classPath);
		for (Field fe : cls.getDeclaredFields()) {
			System.out.println(fe.getName());
		}
	}

	public static Class<?> createClass(Class<?> c) {
		Class<?> cls = new ByteBuddy().subclass(c).name(Employee.class.getName() + "Version")
				.defineField("vertexId", Long.class, Modifier.PUBLIC).make()
				.load(Employee.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded();

		return cls;
	}

	public static Class<?> rebaseTest() {
		Class<?> cls = new ByteBuddy().redefine(Bar.class).defineField("testField", Long.class, Modifier.PUBLIC).make()
				.load(Bar.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent()).getLoaded();
		return cls;

	}

}

class Foo {
	private String thai;
	String m() {
		return "foo";
	}
}

class Bar {
	String m() {
		return "bar";
	}
}