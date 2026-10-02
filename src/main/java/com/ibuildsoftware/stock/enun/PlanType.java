package com.ibuildsoftware.stock.enun;

import lombok.Getter;

@Getter
public enum PlanType {

    FREE("Free Plan"),
    PRO("Professional Plan"),
    ENTERPRISE("Corporate Plan");

    private final String description;

    PlanType(String description) {
        this.description = description;
    }

}
