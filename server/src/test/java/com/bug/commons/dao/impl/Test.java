package com.bug.commons.dao.impl;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get(Hello.class.getName());
        System.out.println(cc.getName());
//        CtMethod m = cc.getDeclaredMethod("say");
//        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
//      
        
        Class c = cc.toClass();//Hello.class.getClassLoader(), Hello.class.getProtectionDomain());
        Hello h = (Hello)c.newInstance();
        h.say();
    }
}
