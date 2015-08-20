//package com.bug.commons.dao.impl;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.lang.reflect.Field;
//
//import org.apache.bcel.Constants;
//import org.apache.bcel.Repository;
//import org.apache.bcel.classfile.JavaClass;
//import org.apache.bcel.generic.ArrayType;
//import org.apache.bcel.generic.ClassGen;
//import org.apache.bcel.generic.ConstantPoolGen;
//import org.apache.bcel.generic.FieldGen;
//import org.apache.bcel.generic.FieldInstruction;
//import org.apache.bcel.generic.InstructionFactory;
//import org.apache.bcel.generic.InstructionHandle;
//import org.apache.bcel.generic.InstructionList;
//import org.apache.bcel.generic.MethodGen;
//import org.apache.bcel.generic.ObjectType;
//import org.apache.bcel.generic.PUSH;
//import org.apache.bcel.generic.Type;
//
//import com.bug.module.hcm.bean.Employee;
//
//public class HelloWorldCreator implements Constants {
//  private InstructionFactory _factory;
//  private ConstantPoolGen    _cp;
//  private ClassGen           _cg;
//
//  public  HelloWorldCreator() {
////    _cg = new ClassGen("HelloWorld", "java.lang.Object", "HelloWorld.java", ACC_PUBLIC | ACC_SUPER, new String[] {  });
//	 
//		JavaClass jc = Repository.lookupClass(Employee.class);
//		
////		ClassGen classGen = new ClassGen(jc);
//	_cg = new ClassGen(jc);
//	
//    _cp = _cg.getConstantPool();
//    _factory = new InstructionFactory(_cg, _cp);
//  }
//  
//  private void createField(){
//	    InstructionList il = new InstructionList();
////	    MethodGen method = new MethodGen(ACC_PUBLIC, Type.VOID, Type.NO_ARGS, new String[] {  }, "<init>", "HelloWorld", il, _cp);
//
////	    InstructionHandle ih_0 = il.append(_factory.createLoad(Type.OBJECT, 0));
////	    il.append(_factory.createInvoke("java.lang.Object", "<init>", Type.VOID, Type.NO_ARGS, Constants.INVOKESPECIAL));
//	   
//	    FieldInstruction  fieldInstruction =  _factory.createFieldAccess(Employee.class.getName(), "vertext", Type.LONG, Constants.GETFIELD);
//	    
////	    _cg.addField(fieldInstruction);
//	    il.append(fieldInstruction);
//
//	    ConstantPoolGen cPoolGen = _cg.getConstantPool();
//		FieldGen fieldGen = new FieldGen(Constants.ACC_PUBLIC, Type.LONG, "vertexId", cPoolGen);
//		_cg.addField(fieldGen.getField());
//	    
//		
//		
////	    InstructionHandle ih_4 = il.append(_factory.createReturn(Type.VOID));
////	    method.setMaxStack();
////	    method.setMaxLocals();
////	    _cg.addMethod(method.getMethod());
//	    il.dispose(); 
//  }
//
//  public void create(OutputStream out) throws IOException {
//	  createField();
////    createMethod_0();
////    createMethod_1();
////    _cg.getJavaClass().dump(out);
//		System.out.println("Lists of field");
//		for (Field fe : Employee.class.getDeclaredFields()) {
//			System.out.println(fe.getName());
//		}
//  }
//
//  private void createMethod_0() {
//    InstructionList il = new InstructionList();
////    MethodGen method = new MethodGen(ACC_PUBLIC, Type.VOID, Type.NO_ARGS, new String[] {  }, "<init>", "HelloWorld", il, _cp);
////
////    InstructionHandle ih_0 = il.append(_factory.createLoad(Type.OBJECT, 0));
////    il.append(_factory.createInvoke("java.lang.Object", "<init>", Type.VOID, Type.NO_ARGS, Constants.INVOKESPECIAL));
//   
//    FieldInstruction  fieldInstruction = null;//  _factory.createFieldAccess(class_name, "vertext", type, kind)
//    
////    _cg.addField(fieldInstruction);
//    il.append(fieldInstruction);
//
//
//    
////    InstructionHandle ih_4 = il.append(_factory.createReturn(Type.VOID));
////    method.setMaxStack();
////    method.setMaxLocals();
////    _cg.addMethod(method.getMethod());
//    il.dispose();
//  }
//
//  private void createMethod_1() {
//    InstructionList il = new InstructionList();
//    MethodGen method = new MethodGen(ACC_PUBLIC | ACC_STATIC, Type.VOID, new Type[] { new ArrayType(Type.STRING, 1) }, new String[] { "arg0" }, "main", "HelloWorld", il, _cp);
//
//    
//    
//    InstructionHandle ih_0 = il.append(_factory.createFieldAccess("java.lang.System", "err", new ObjectType("java.io.PrintStream"), Constants.GETSTATIC));
//    il.append(new PUSH(_cp, "Hello World through BCEL!"));
//    il.append(_factory.createInvoke("java.io.PrintStream", "println", Type.VOID, new Type[] { Type.STRING }, Constants.INVOKEVIRTUAL));
//    InstructionHandle ih_8 = il.append(_factory.createReturn(Type.VOID));
//    method.setMaxStack();
//    method.setMaxLocals();
//    _cg.addMethod(method.getMethod());
//    il.dispose();
//  }
//
//  public static void main(String[] args) throws Exception {
//    HelloWorldCreator creator = new HelloWorldCreator();
//    creator.create(null);
////    creator.create(new FileOutputStream("HelloWorld.class"));
//  }
//}
