package com.example.app.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * TODO情報 リクエストデータ
 */
@Data
public class TodoListRequest implements Serializable {

    /**
     * タイトル
     */
    @NotEmpty(message = "タイトルを入力してください")
    @Size(max = 100, message = "タイトルは100文字以内で入力してください")
    private String title;

    /**
     * 本文
     */
    @NotEmpty(message = "本文を入力してください")
    @Size(max = 2000, message = "本文は2000文字以内で入力してください")
    private String detail;
}
