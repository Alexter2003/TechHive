package com.app.TechHive.domain.utilsDTO;

public enum Models {
    GEMINI_2_0_FLASH_LITE("gemini-2.0-flash-lite"),
    GEMINI_2_0_FLASH("gemini-2.0-flash");


    private final String value;

    // Constructor
    Models(String value) {
        this.value = value;
    }

    // Getter method
    public String getValue() {
        return value;
    }
}