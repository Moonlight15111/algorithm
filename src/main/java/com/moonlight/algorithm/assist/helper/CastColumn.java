package com.moonlight.algorithm.assist.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName CastColumn
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/26 14:06
 * @Version V1.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CastColumn {
    String name() default "";
    String setMethodName() default "";
}
