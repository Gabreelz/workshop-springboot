package com.educandoweb.course.enums;

// Enum que representa os possíveis status de um pedido
public enum OrderStatus {
    // Cada status tem um código numérico associado
    WAINTING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELEDE(5);

    private int code; // Código numérico do status acima

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    // Converte código numérico em Enum (ex: 1 → WAITING_PAYMENT)
    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){ // percorre todos os valores do enum
            if(value.getCode() == code){
                return value; // retorna o enum correspondente
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
