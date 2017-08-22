package com.collect.classLoader;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    private String root;

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args)  throws Exception{

        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("E:\\temp");

        Class<?> testClass = null;
        testClass = classLoader.loadClass("com.collect.arith.QuickSort");
        Object object = testClass.newInstance();
        System.out.println(object.getClass().getClassLoader());

        Field field = object.getClass().getDeclaredField("array");
        System.out.println("field: " + field);

        Method method = object.getClass().getMethod("quikSort");
        String methodResult = (String) method.invoke(testClass.newInstance());
        }
}