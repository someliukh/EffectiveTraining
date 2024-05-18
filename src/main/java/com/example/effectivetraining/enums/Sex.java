package com.example.effectivetraining.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Sex {
    MALE, FEMALE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
