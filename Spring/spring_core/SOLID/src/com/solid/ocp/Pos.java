package com.solid.ocp;

public class Pos {
    /**
     * 결제 및 결과 반환 함수
     */
    public boolean purchase(Purchasable purchasable, int price){
        return purchasable.send(price);
    }
}
