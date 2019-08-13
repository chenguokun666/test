package controller;

public class Singtelon {
    //懒汉  如果有多个线程进入，它会多次进行实例化，加锁虽然安全 但是会造成线程阻塞，因此性能会有问题
    private static Singtelon uniqueInstance;
    private Singtelon(){

    }
    public static Singtelon getInstance(){
        if (uniqueInstance==null){
            synchronized (Singtelon.class){
                if(uniqueInstance==null){
                    uniqueInstance=new Singtelon();
                }
            }

        }
        return uniqueInstance;
    }
}
