package org.eddydashcode.reflection.class_loader;

public class Main {

    public static void main(String[] args) throws Exception {

        String classDir = "class_loader"; // path to your .class file
        String className = "HelloWorld";
        String classPackage = "org.umaxcode.reflection.class_loader";

        CustomClassLoader loader = new CustomClassLoader(classDir);
        Class<?> loadedClass = loader.loadClass(classPackage + "." +className);

        Object instance = loadedClass.getDeclaredConstructor().newInstance();

        loadedClass.getMethod("sayHello").invoke(instance);

    }
}
