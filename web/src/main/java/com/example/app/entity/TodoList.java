package com.example.app.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/**
 * todo_list Entity
 */
@Entity
@Data
@Table(name = "todo_list")
public class TodoList implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * タイトル
   */
  @Column(name = "title")
  private String title;

  /**
   * 本文
   */
  @Column(name = "detail")
  private String detail;

  /**
   * 更新日時
   */
  @Column(name = "update_date")
  private Date updateDate;

  /**
   * 登録日時
   */
  @Column(name = "create_date")
  private Date createDate;

}
