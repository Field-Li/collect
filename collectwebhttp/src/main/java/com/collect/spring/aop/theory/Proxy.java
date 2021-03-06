package com.collect.spring.aop.theory;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy {
    /**
     *
     * @param infce 被代理类的接口
     * @param h 代理类
     * @return
     * @throws Exception
     */
    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String methodStr = "";
        String rt = "\r\n";

        //利用反射得到infce的所有方法，并重新组装
        Method[] methods = infce.getMethods();
        for(Method m : methods) {
            methodStr += "    @Override" + rt +
                    "    public  "+m.getReturnType()+" " + m.getName() + "() {" + rt +
                    "        try {" + rt +
                    "        Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                    "        h.invoke(this, md);" + rt +
                    "        }catch(Exception e) {e.printStackTrace();}" + rt +
                    "    }" + rt ;
        }

        //生成Java源文件
        String srcCode =
                "package com.collect.spring.aop;" +  rt +
                        "import java.lang.reflect.Method;" + rt +
                        "public class $Proxy1 implements " + infce.getName() + "{" + rt +
                        "    public $Proxy1(InvocationHandler h) {" + rt +
                        "        this.h = h;" + rt +
                        "    }" + rt +
                        "    com.collect.spring.aop.InvocationHandler h;" + rt +
                        methodStr + rt +
                        "}";
        String fileName =
                "D:\\code\\github\\collect\\src\\main\\java\\com\\collect\\spring\\aop\\$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(srcCode);
        fw.flush();
        fw.close();

        //将Java文件编译成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        //加载到内存，并实例化
        URL[] urls = new URL[] {new URL("file:/" + "D:\\code\\github\\collect\\src\\main\\java\\com\\collect\\spring\\aop\\")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.collect.spring.aop.$Proxy1");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(h);

        return m;
    }

}