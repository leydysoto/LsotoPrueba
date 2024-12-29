package com.desarrolladora.leydy.Barberia.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;
}
