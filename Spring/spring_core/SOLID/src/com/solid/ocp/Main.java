package com.solid.ocp;

public class Main {
    public static void main(String[] args) {
        Purchasable purchasable1 = new CardA();
        Purchasable purchasable2 = new CardB();
        Purchasable purchasable3 = new CardC();

        Pos pos = new Pos();
        System.out.println(pos.purchase(purchasable1,1200));
        System.out.println(pos.purchase(purchasable2,2400));
        System.out.println(pos.purchase(purchasable3,3600));
    }
}
