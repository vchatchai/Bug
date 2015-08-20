//package com.bug.commons.dao.impl;
//
//import java.util.Objects;
//
//import com.bug.commons.dao.annotation.ModelType;
//
//import javassist.CannotCompileException;
//import javassist.ClassPool;
//import javassist.CtClass;
//import javassist.CtField;
//import javassist.Modifier;
//import javassist.NotFoundException;
//
//public class CustomClassLoader extends ClassLoader {
//
//	@Override
//	public Class<?> loadClass(String name) throws ClassNotFoundException {
//
//		ClassPool cp = ClassPool.getDefault();
//		CtClass ctc;
//		try {
//			ctc = cp.get(name);
//
//			// ClassPool classes1Pool = new ClassPool(defaultPool);
//			// CtClass info =
//			// cp.makeClass("org.jboss.test.scoped.interfaces.dto.SimpleResponseDTO");
//			// info.addInterface(classes1Pool.get("java.io.Serializable"));
//			CtClass s = cp.get(Long.class.getName());
//			ModelType modelType = (ModelType) ctc.getAnnotation(ModelType.class);
//			Class<?> cls = null;
//			if (!Objects.isNull(modelType)) {
//				CtField firstName = new CtField(s, "vertexId", ctc);
//				firstName.setModifiers(Modifier.PRIVATE);
//				ctc.addField(firstName);
//
//				cls = ctc.toClass();
//			} else {
//				cls = super.loadClass(name);
//			}
//
//			return cls;
//
//			// ctc.writeFile();
//			// ctc.freeze();
//
//			// for(CtField field : ctc.getFields()){
//			// System.out.println(field.getName());
//			// }
//			// System.out.println("finish CtField");
//			//
//			// for(Field field : cls.getDeclaredFields()){
//			// System.out.println(field.getName());
//			// }
//
//		} catch (NotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CannotCompileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return super.loadClass(name);
//	}
//
//}
