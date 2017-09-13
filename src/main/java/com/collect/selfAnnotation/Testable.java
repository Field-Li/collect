package com.collect.selfAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention 注解保留时间
RetentionPolicy.SOURCE - 只在源码保留，编译阶段被丢弃
RetentionPolicy.CLASS - 被编译器保留在编译后的类文件中，但在运行时不被虚拟机保留
RetentionPolicy.RUNTIME - 编译阶段和运行阶段虚拟机都一直存在
 @Target 注解可被应用到哪些地方
 ElementType.TYPE - 可用于类，接口或枚举类声明时
 ElementType.FIELD - 可用于属性声明时
 ElementType.METHOD - 可用于方法声明时
 ElementType.PARAMETER - 可用于参数声明时
 ElementType.CONSTRUCTOR - 可用于构造函数声明时
 ElementType.LOCAL_VARIABLE - 可用于本地亦是声明时
 ElementType.ANNOTATION_TYPE - 可用于注解声明时，即定义注解时也可用
 ElementType.PACKAGE - 可用于包声明时
 ElementType.TYPE_PARAMETER - 可用于参数类型的声明时
 ElementType.TYPE_USE - 一种类型使用时
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testable {
}