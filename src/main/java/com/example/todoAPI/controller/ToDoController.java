package com.example.todoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoAPI.exception.ItemNotFoundException;
import com.example.todoAPI.model.ToDo;
import com.example.todoAPI.service.ToDoService;

@RestController
public class ToDoController {
	
	@Autowired
	private ToDoService tds;
	
	@GetMapping("/todos")  //TODOリストを取得
	public List<ToDo> getAllToDos(){
		return tds.getAllTodos();
	}
	
	@PostMapping("/todos")  //TODOを追加
	public void addTodo(@RequestBody ToDo todo) {
		tds.addTodo(todo);
	}
	
	@GetMapping("/todos/{id}")  //idを指定してTODOを取得
	public ToDo getTodo(@PathVariable("id") String id) {
		if(tds.getTodo(id) == null) {
			throw new ItemNotFoundException(id);
		}
		return tds.getTodo(id);
		//return tds.getTodo(id).orElseThrow(() -> new ItemNotFoundException(id));
	}
	
	@DeleteMapping("/todos/{id}")  //idを指定してTODOを削除
	public void deleteTodo(@PathVariable("id") String id) {
		if(tds.getTodo(id) == null) {
			throw new ItemNotFoundException(id);
		}
		tds.deleteTodo(id);
	}
	
	@PutMapping("/todos/{id}")  //idを指定してTODOを更新
	public void updateTodo(@RequestBody ToDo todo, @PathVariable("id") String id) {
		if(tds.getTodo(id) == null) {
			throw new ItemNotFoundException(id);
		}
		tds.updateTodo(todo, id);
	}
	
	//フィルタリング
	@GetMapping("/todos/status/{status}")  //statusによってフィルタリング
	public List<ToDo> statusFilter(@PathVariable("status") String status){
		return tds.statusFilter(status);
	}
	
	@GetMapping("/todos/title/{title}")  //titleによってフィルタリング
	public List<ToDo> titleFilter(@PathVariable("title") String title){
		return tds.titleFilter(title);
	}

}
