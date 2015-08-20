package com.bug.instrument;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;

public class VertexIdClassFileTransformer implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
	    
        ClassPool cp = ClassPool.getDefault();
        CtClass ctc;
        
		try {
			ctc = cp.get(className);

	        CtClass s = cp.get(Long.class.getName());
	        CtField firstName = new CtField(s, "vertexId1", ctc);
	        firstName.setModifiers(Modifier.PRIVATE);
	        ctc.addField(firstName);
	        
	        classfileBuffer = ctc.toBytecode();
	        
//	        Class cls = ctc.toClass();
		} catch (NotFoundException | CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return classfileBuffer;
        
	}

}
