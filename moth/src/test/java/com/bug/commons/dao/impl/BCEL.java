//package com.bug.commons.dao.impl;
//
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.net.URL;
//import java.util.Arrays;
//
//import org.apache.bcel.Constants;
//import org.apache.bcel.classfile.ClassFormatException;
//import org.apache.bcel.classfile.ClassParser;
//import org.apache.bcel.classfile.JavaClass;
//import org.apache.bcel.classfile.Method;
//import org.apache.bcel.generic.ClassGen;
//import org.apache.bcel.generic.ConstantPoolGen;
//import org.apache.bcel.generic.FieldGen;
//import org.apache.bcel.generic.Type;
//import org.apache.bcel.util.ClassLoaderRepository;
//
//import com.bug.commons.dao.Vertex;
//import com.bug.module.hcm.bean.Employee;
//
//import net.sf.cglib.beans.BeanCopier;
//
//public class BCEL {
//	private static int sampleField;
//	private String nameField;
//
//	/**
//	 * @param args
//	 * @throws IOException
//	 * @throws ClassFormatException
//	 * @throws ClassNotFoundException 
//	 */
//	public static void main(String[] args) throws ClassFormatException, IOException, ClassNotFoundException {
//
//		// test1();
//
//		generateClassBCEL();
//		// System.out.println(Employee.class.getName());
//
////		 refectionClass();
//
//	}
//
//	private static void refectionClass() {
//		BeanCopier beanCopier = BeanCopier.create(Vertex.class, Employee.class, false);
//	
//		System.out.println("Lists of field");
//		for (Field fe : Employee.class.getDeclaredFields()) {
//			System.out.println(fe.getName());
//		}
//	}
//
//	public static void test1() throws ClassFormatException, IOException {
//
//		/* An existing class can be parsed with ClassParser */
//		ClassParser parser = new ClassParser(Employee.class.getResourceAsStream("Employee.class"), "Employee.class");
//		JavaClass javaClass = parser.parse();
//
//		System.out.println("*******Constant Pool*********");
//		System.out.println(javaClass.getConstantPool());
//
//		System.out.println("*******Fields*********");
//		System.out.println(Arrays.toString(javaClass.getFields()));
//		System.out.println();
//
//		System.out.println("*******Methods*********");
//		System.out.println(Arrays.toString(javaClass.getMethods()));
//
//		for (Method method : javaClass.getMethods()) {
//			System.out.println(method);
//			System.out.println(method.getCode());
//		}
//	}
//
//	public static void generateClassBCEL() throws IOException, ClassNotFoundException {
//		System.out.println("Generating Class");
////		InstructionList il = new InstructionList();
//		// Create a ClassGen for our brand new class.
//		// ClassGen classGen=new
////		 ClassGen("com.geekyarticles.bcel.SyntheticClass", "java.lang.Object",
////		 "SyntheticClass.java", Constants.ACC_PUBLIC, ClassParser.);
//		ClassLoaderRepository classLoaderRepository = new ClassLoaderRepository(ClassLoader.getSystemClassLoader());
//		JavaClass jc = classLoaderRepository.loadClass(Employee.class);
//		ClassGen classGen = new ClassGen(jc);
//		
//		
//		// JavaClass jc = new
//
////		 ClassGen classGen=new ClassGen(Employee.class.getName(),
////		 "java.lang.Object", "Employee.java", Constants.ACC_PUBLIC, null);
//
//		// Field field = new Field(access_flags, name_index, signature_index,
//		// attributes, constant_pool);
//
//		ConstantPoolGen cPoolGen = classGen.getConstantPool();
//		FieldGen fieldGen = new FieldGen(Constants.ACC_PUBLIC, Type.LONG, "vertexId", cPoolGen);
//		classGen.addField(fieldGen.getField());
//
//		// Now generate the class
//		JavaClass javaClass = classGen.getJavaClass();
////		BeanGenerator beanGenerator = new BeanGenerator();
////		BeanCopier beanCopier = BeanCopier.create(Vertex.class, Employee.class, false);
//
//		// Write the class byte code into a file
//		URL url = Employee.class.getResource("Employee.class");
//		System.out.println("URL+++++++++++++++ " + url.getFile());
//		
////		InstructionFactory f  = new InstructionFactory(classGen);
//		
////		javaClass.HEAP;
//		
////		il.dispose();
//
////		javaClass.dump(url.getFile());
////		classLoaderRepository.storeClass(javaClass);
//	
////		Class cls = ClassLoader.getSystemClassLoader().loadClass(Employee.class.getName());
//		
////		Class cls = javaClass.
//		
//
////		Repository.clearCache();
//		
////		Repository.lookupClass(Employee.class);
////		Repository.removeClass(javaClass);
//
//		System.out.println("Lists of field");
//		for (Field fe : javaClass.getClass().getDeclaredFields()) {
//			System.out.println(fe.getName());
//		}
//
//		// classGen.addField(field);
//	}
//
//	public static void createMethmod() {
//
//		//
//		//
//		//// ClassGen cg = new ClassGen(jc);
//		////
//		//// org.apache.bcel.classfile.Field f = new
//		////
//		//// cg.addField(new org.apache.bcel.classfile.Field(c));
//		////
//		//
//		// //Get a reference to the constant pool of the class. This will be
//		// modified as we add methods, fields etc. Note that it already
//		// constains
//		// //a few constants.
//		//// ConstantPoolGen constantPoolGen=classGen.getConstantPool();
//		//
//		// //The list of instructions for a method.
//		// InstructionList instructionList=new InstructionList();
//		//
//		// //Add the appropriate instructions.
//		//
//		// //Get the reference to static field out in class java.lang.System.
//		// instructionList.append(new
//		// GETSTATIC(constantPoolGen.addFieldref("java.lang.System", "out",
//		// "Ljava/io/PrintStream;")));
//		//
//		// //Load the constant
//		// instructionList.append(new LDC(constantPoolGen.addString(" You are a
//		// real geek!")));
//		//
//		// //Invoke the method.
//		// instructionList.append(new
//		// INVOKEVIRTUAL(constantPoolGen.addMethodref("java.io.PrintStream",
//		// "println", "(Ljava/lang/String;)V")));
//		//
//		// //Return from the method
//		// instructionList.append(new RETURN());
//		//
//		// MethodGen methodGen=new
//		// MethodGen(Constants.ACC_PUBLIC|Constants.ACC_STATIC, Type.VOID, new
//		// Type[]{new ArrayType(Type.STRING, 1)}, new String[]{"args"}, "main",
//		// "com.geekyarticles.bcel.SyntheticClass", instructionList,
//		// constantPoolGen);
//		//
//		// methodGen.setMaxLocals();//Calculate the maximum number of local
//		// variables.
//		// methodGen.setMaxStack();//Very important: must calculate the maximum
//		// size of the stack.
//		//
//		//// classGen.addMethod(methodGen.getMethod()); //Add the method to the
//		// class
//		//
//		// //Print a few things.
//		// System.out.println("********Constant Pool**********");
//		// System.out.println(constantPoolGen.getFinalConstantPool());
//		// System.out.println("********Method**********");
//		// System.out.println(methodGen);
//		// System.out.println("********Instruction List**********");
//		// System.out.println(instructionList);
//		//
//		//
//		//// //Now generate the class
//		//// JavaClass javaClass=classGen.getJavaClass();
//		//// try {
//		//// //Write the class byte code into a file
//		//// URL url = BCEL.class.getResource("GraphDaoTest.class");
//		//// System.out.println("URL+++++++++++++++ " +url.getFile());
//		////
//		//// javaClass.dump(url.getFile());
//		////
//		//// } catch (IOException e) {
//		//// // TODO Auto-generated catch block
//		//// e.printStackTrace();
//		//// }
//		////
//		// That's it.
//
//	}
//
//}
