package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.logging.StreamHandler;
import java.util.stream.Stream;

public enum ERole {
    USER("USER"),
    MODERATOR("MODERATOR"),
    ADMIN("ADMIN");

    String code;

    private ERole(String code) {
        this.code = code;
    }

    @JsonCreator
    public  static  ERole decode(final String code) {
        return Stream.of(ERole.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}
