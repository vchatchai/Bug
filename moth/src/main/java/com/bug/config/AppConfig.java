//package com.bug.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableLoadTimeWeaving;
//import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
//import org.springframework.instrument.classloading.LoadTimeWeaver;
//import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
//
//import com.bug.instrument.VertexIdClassFileTransformer;
//
//@Configuration
//@EnableLoadTimeWeaving
//public class AppConfig implements LoadTimeWeavingConfigurer {
//
//    @Override
//    public LoadTimeWeaver getLoadTimeWeaver() {
//    	
//    	LoadTimeWeaver loadTimeWeaver = new ReflectiveLoadTimeWeaver();
//    	
//    	loadTimeWeaver.addTransformer(new VertexIdClassFileTransformer());
//    	
//    	
//    	
//    	return loadTimeWeaver;
//    }
//}