/**
 * 
 */
package com.bug.commons.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bug.commons.dao.constant.VertexType;

/**
 * @author chatchai
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ModelType {

	String value();

}
