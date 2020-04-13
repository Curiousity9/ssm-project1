package com.ay.test;

/**
 * @author xiangwehao
 * create 2020/3/31
 */
public class FactoryMethodPattren {
    public static void main(String[] args)throws Exception{
        //生产汽车
        Factory carFactory = new CarFactory();
        Vehicle car =  carFactory.produce();
        car.run();
        //生产公交车
        Factory busFactory = new BusFactory();
        busFactory.produce().run();
        //生产自行车
        Factory bycleFactory = new BycleFactory();
        bycleFactory.produce().run();
    }
}
/*
抽象工厂类
 */
interface Factory{
    Vehicle produce();
}
/*
汽车工厂
 */
class CarFactory implements Factory{
    @Override
    public Vehicle produce() {
        return new Car();
    }
}
/*
公交车工厂
 */
class BusFactory implements Factory{
    @Override
    public Vehicle produce() {
        return new Bus();
    }
}
/*
自行车工厂
 */
class BycleFactory implements Factory{
    @Override
    public Vehicle produce() {
        return new Bycle();
    }
}
/*
交通工具
 */
interface Vehicle{
    void run();
}
/*
汽车
 */
class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("Car run...");
    }
}
/*
公交车
 */
class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("Bus run...");
    }
}
/*
自行车
 */
class Bycle implements Vehicle{
    @Override
    public void run() {
        System.out.println("Bycle run...");
    }
}


