package com.example.demo.utils;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class PlayerConverter implements AttributeConverter<UUID,  String> {
    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return uuid.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String s) {
        return UUID.fromString(s);
    }
}
