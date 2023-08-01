package com.example.app.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TodoListUpdateRequest extends TodoListRequest {
    /**
     * ID
     */
    @NotNull
    private Long id;
}
