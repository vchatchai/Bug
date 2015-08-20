package com.bug.commons.dao.impl;
import java.lang.reflect.Field;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;

public class TestResist {
    public static void main(String[] args) throws Exception {
//        HotSwapper hs = new HotSwapper("8000");

//        File newfile = new File("logging/HelloWorld.class");
//        byte[] bytes = new byte[(int)newfile.length()];
//        new FileInputStream(newfile).read(bytes);
//        System.out.println("** reload a logging version");
//        com.sun.jdi.connect.IllegalConnectorArgumentsExceptio
        
//        InputStream inputStream = Employee.class.getResourceAsStream("Employee.class");
//        DataInputStream dataInputStream = new DataInputStream(inputStream);
        
//        System.out.println(Employee.class.getName());
        
        ClassPool cp = ClassPool.getDefault();
        CtClass  ctc = cp.get("com.bug.module.hcm.bean.Employee");

        
        //ClassPool classes1Pool = new ClassPool(defaultPool);
//        CtClass info = cp.makeClass("org.jboss.test.scoped.interfaces.dto.SimpleResponseDTO");
//        info.addInterface(classes1Pool.get("java.io.Serializable"));
        CtClass s = cp.get(Long.class.getName());
        CtField firstName = new CtField(s, "vertexId", ctc);
        firstName.setModifiers(Modifier.PRIVATE);
        ctc.addField(firstName);
        
        
//        ClassFile cf = new ClassFile(dataInputStream);
////        ConstPool constPool = new ConstPool(dataInputStream);
//        FieldInfo f = new FieldInfo(cf.getConstPool() , "vertexId", "Desc");
//        cf.addField(f);
//        
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        
//        
//       
//        cf.getClass();
//        cf.write(bytes);
       
        
        
//        ClassFile cf = new ClassFile(false, "test.Foo", null);
//        cf.setInterfaces(new String[] { "java.lang.Cloneable" });
//         
//        FieldInfo f = new FieldInfo(cf.getConstPool(), "width", "I");
//        f.setAccessFlags(AccessFlag.PUBLIC);
//        cf.addField(f);
//
//        cf.write(new DataOutputStream(new FileOutputStream("Foo.class")));
        
        
        
//        hs.reload(Employee.class.getName(), bytes.toByteArray());
//        new HelloWorld().print();

//        newfile = new File("HelloWorld.class");
//        bytes = new byte[(int)newfile.length()];
//        new FileInputStream(newfile).read(bytes);
//        System.out.println("** reload the original version");
//
//        hs.reload("HelloWorld", bytes);
//        new HelloWorld().print();
        
        Class cls = ctc.toClass();
        
//        ctc.writeFile();
//        ctc.freeze();
        
        
        for(CtField field : ctc.getFields()){
        	System.out.println(field.getName());
        }
        System.out.println("finish CtField");
        
        for(Field field : cls.getDeclaredFields()){
        	System.out.println(field.getName());
        }
    }
}