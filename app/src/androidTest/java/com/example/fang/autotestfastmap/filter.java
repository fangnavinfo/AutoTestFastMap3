package com.example.fang.autotestfastmap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fang on 18/3/20.
 */

@Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME)
@interface IMPORTANT {}

