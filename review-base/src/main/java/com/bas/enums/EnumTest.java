package com.bas.enums;

import com.fasterxml.jackson.core.JsonProcessingException;

public class EnumTest {
    public static void main(String[] args) throws JsonProcessingException {

        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(Pizza.getJsonString(pz));
    }
}
