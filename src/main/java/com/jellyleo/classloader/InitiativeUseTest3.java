package com.jellyleo.classloader;

class YeYe3{
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father3 extends YeYe3{
    public static String strFather="HelloJVM_Father";

    static{
        System.out.println("Father静态代码块");
    }
}

class Son3 extends Father3{
    public static String strSon="HelloJVM_Son";

    static{
        System.out.println("Son静态代码块");
    }
}

public class InitiativeUseTest3 {
    public static void main(String[] args) {
        System.out.println(Son3.strFather); 
    }
}
