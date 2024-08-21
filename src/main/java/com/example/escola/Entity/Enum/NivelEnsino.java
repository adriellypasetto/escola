package com.example.escola.Entity.Enum;

public enum NivelEnsino {
    ENSINO_FUNDAMENTAL("Ensino fundamental"),
    ENSINO_MEDIO("Ensino médio"),
    MATERNAL("Maternal"),
    PRE_ESCOLA("Pré escola")
    ;

    private final String value;

    public String getValue() {
        return value;
    }

    NivelEnsino(String value) {
        this.value = value;
    }
}



