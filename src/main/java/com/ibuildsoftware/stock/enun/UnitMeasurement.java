package com.ibuildsoftware.stock.enun;

import lombok.Getter;

@Getter
public enum UnitMeasurement {

    UN("Unit"),
    BOX("Box"),
    PACK("Pack"),
    KG("Kilogram"),
    G("Gram"),
    LB("Pound"),
    L("Liter"),
    ML("Milliliter"),
    M("Meter"),
    CM("Centimeter");

    private final String description;

    UnitMeasurement(String description) {
        this.description = description;
    }
}