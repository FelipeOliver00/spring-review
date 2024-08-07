package com.felps.springboot.dtos;

import com.felps.springboot.models.Nivel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SwimmingRecordDto(@NotBlank String name, @NotBlank String description, @NotNull Nivel nivel) {
}
