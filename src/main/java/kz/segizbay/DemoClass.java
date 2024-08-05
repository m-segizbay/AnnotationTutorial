package kz.segizbay;

public class DemoClass {
    @MyAnno(priority = 1)
    public static void method1(){
        System.out.println(1);
    }

    @MyAnno()
    public static void method2(){
        System.out.println(2);
    }

    @MyAnno(priority = 3)
    public static void method3(){
        System.out.println(3);
    }
}
