package com.fang.testAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface FindResource
{
    String Id() default "";
    String Text() default "";
    String clazz() default "";
    String ios_xpath() default "";
    String ios_predicate() default "";

    int ios_x() default -1;
    int ios_y() default -1;
    String ios_name() default "";

    boolean ios_ignore() default false;
}
