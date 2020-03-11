package com.concon.entity;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"),
    LOW("önemsiz"),
    HIGH("Yüksek Öncelikli");
    private String label;
    PriorityType(String label){
        this.label=label;
    }
}
