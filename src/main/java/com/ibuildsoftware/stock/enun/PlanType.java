package com.ibuildsoftware.stock.enun;

public enum PlanType {

    FREE("Free Plan"),
    PRO("Professional Plan"),
    ENTERPRISE("Corporate Plan");

    private final String description;

    PlanType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
