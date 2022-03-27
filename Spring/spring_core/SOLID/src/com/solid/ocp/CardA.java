package com.solid.ocp;

public class CardA implements Purchasable{
    @Override
    public boolean send(int price) {
        System.out.println(this.getClass().getSimpleName()+" "+price+"원 결제요청");
        return true;
    }
}
