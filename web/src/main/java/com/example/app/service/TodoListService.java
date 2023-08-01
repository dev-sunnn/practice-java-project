package com.example.app.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dto.TodoListRequest;
import com.example.app.dto.TodoListUpdateRequest;
import com.example.app.entity.TodoList;
import com.example.app.repository.TodoListRepository;

/**
 * Todo情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TodoListService {
  /**
   * Todo情報 Repository
   */
  @Autowired
  private TodoListRepository todoListRepository;

  /**
   * Todo情報 ID検索
   * 
   * @return 検索結果
   */
  public TodoList searchById(long id) {
    return todoListRepository.findById(id).get();
  }

  /**
   * Todo情報 全検索
   * 
   * @return 検索結果
   */
  public List<TodoList> searchAll() {
    return todoListRepository.findAll();
  }

  /**
   * Todo情報 登録
   * 
   * @param todoListRequest 登録用リクエストデータ
   */
  public void create(TodoListRequest todoListRequest) {
    Date now = new Date();
    TodoList todoList = new TodoList();
    todoList.setTitle(todoListRequest.getTitle());
    todoList.setDetail(todoListRequest.getDetail());
    todoList.setCreateDate(now);
    todoList.setUpdateDate(now);
    todoListRepository.save(todoList);
  }

  /**
   * Todo情報 更新
   * 
   * @param todoUpdateRequest 更新用リクエストデータ
   */
  public void update(TodoListUpdateRequest todoUpdateRequest) {
    TodoList todoList = searchById(todoUpdateRequest.getId());
    todoList.setTitle(todoUpdateRequest.getTitle());
    todoList.setDetail(todoUpdateRequest.getDetail());
    todoList.setUpdateDate(new Date());
    todoListRepository.save(todoList);
  }

  /**
   * Todo情報 物理削除
   * 
   * @param id TodoID
   */
  public void delete(Long id) {
    TodoList todoList = searchById(id);
    todoListRepository.delete(todoList);
  }

}
