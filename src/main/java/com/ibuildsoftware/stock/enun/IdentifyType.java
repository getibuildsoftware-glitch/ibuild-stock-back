package com.ibuildsoftware.stock.enun;

import lombok.Getter;

@Getter
public enum IdentifyType {

    PERSON("Person"),
    ORGANIZATION("Organization");

    private final String description;

    IdentifyType(String description) {
        this.description = description;
    }
}
