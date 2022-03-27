package com.solid.ocp;

public interface Purchasable {
    /**
     * 카드사 정보 전송 및 결과 반환 함수
     * @param price 금액
     * @return
     */
    boolean send(int price);
}
