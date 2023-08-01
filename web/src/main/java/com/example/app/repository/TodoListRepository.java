package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.app.entity.TodoList;

/**
 * 練習情報 Repository
 */
@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}

