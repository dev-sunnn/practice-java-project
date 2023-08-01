package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.dto.TodoListRequest;
import com.example.app.dto.TodoListUpdateRequest;
import com.example.app.entity.TodoList;
import com.example.app.service.TodoListService;

/**
 * TODO情報 Controller
 */
@Controller
public class TodoListController {

    /**
     * TODO情報 TodoList
     */
    @Autowired
    private TodoListService todoListService;

    /**
     * TODO情報 一覧画面を表示
     * 
     * @param model Model
     * @return TODO情報 一覧画面
     */
    @GetMapping(value = "/todo/list")
    public String displayList(Model model) {
        List<TodoList> todolist = todoListService.searchAll();
        model.addAttribute("todolist", todolist);
        return "todo/list";
    }

    /**
     * TODO情報 詳細画面を表示
     * 
     * @param id    表示するTODOID
     * @param model Model
     * @return TODO情報 詳細画面
     */
    @GetMapping("/todo/{id}")
    public String displayView(@PathVariable Long id, Model model) {
        TodoList data = todoListService.searchById(id);
        model.addAttribute("tododata", data);
        return "todo/view";
    }

    /**
     * TODO情報 新規登録画面を表示
     * 
     * @param model Model
     * @return TODO情報 新規登録画面
     */
    @GetMapping(value = "/todo/add")
    public String displayAdd(Model model) {
        model.addAttribute("todoListRequest", new TodoListRequest());
        return "todo/add";
    }

    /**
     * TODO情報 新規登録
     * 
     * @param todoListRequest リクエストデータ
     * @param model           Model
     * @return TODO情報 一覧画面
     */
    @RequestMapping(value = "/todo/create", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute TodoListRequest todoListRequest, BindingResult result, Model model) {

        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "todo/add";
        }
        // TODO情報の登録
        todoListService.create(todoListRequest);
        return "redirect:/todo/list";
    }

    /**
     * TODO情報 編集画面を表示
     * 
     * @param id    表示するTODOID
     * @param model Model
     * @return TODO情報 編集画面
     */
    @GetMapping("/todo/{id}/edit")
    public String displayEdit(@PathVariable Long id, Model model) {
        TodoList todoList = todoListService.searchById(id);
        TodoListUpdateRequest todoListUpdateRequest = new TodoListUpdateRequest();
        todoListUpdateRequest.setId(todoList.getId());
        todoListUpdateRequest.setTitle(todoList.getTitle());
        todoListUpdateRequest.setDetail(todoList.getDetail());
        model.addAttribute("todoListUpdateRequest", todoListUpdateRequest);
        return "todo/edit";
    }

    /**
     * TODO情報 更新
     * 
     * @param todoListRequest リクエストデータ
     * @param model           Model
     * @return TODO情報 詳細画面
     */
    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute TodoListUpdateRequest todoListUpdateRequest, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();

            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "todo/edit";
        }

        // TODO情報の更新
        todoListService.update(todoListUpdateRequest);
        return String.format("redirect:/todo/%d", todoListUpdateRequest.getId());
    }

    /**
     * TODO情報 削除
     * 
     * @param id    削除するTODO情報ID
     * @param model Model
     * @return TODO情報 詳細画面
     */
    @GetMapping("/todo/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        // TODO情報の削除
        todoListService.delete(id);
        return "redirect:/todo/list";
    }
}
