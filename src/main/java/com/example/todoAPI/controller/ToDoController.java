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

import com.example.todoAPI.model.ToDo;
import com.example.todoAPI.model.ToDoWithoutId;
import com.example.todoAPI.service.ToDoService;

@RestController
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@GetMapping("/todos")  //TODOリストを取得
	public List<ToDo> getAllToDos(){
		return toDoService.getAllTodos();
	}
	
	@PostMapping("/todos")  //TODOを追加
	public void addTodo(@RequestBody ToDoWithoutId toDoWithoutId) {
		toDoService.addTodo(toDoWithoutId);
	}
	
	@GetMapping("/todos/{id}")  //idを指定してTODOを取得
	public ToDo getTodo(@PathVariable("id") int id) {
		//if(toDoService.getTodo(id) == null) {
		//	throw new ItemNotFoundException(id);
		//}
		//return toDoService.getTodo(id);
		return toDoService.getTodo(id);  //.orElseThrow(() -> new ItemNotFoundException(id));
	}
	
	@DeleteMapping("/todos/{id}")  //idを指定してTODOを削除
	public void deleteTodo(@PathVariable("id") int id) {
		//if(toDoService.getTodo(id) == null) {
		//	throw new ItemNotFoundException(id);
		//}
		toDoService.deleteTodo(id);
	}
	
	@PutMapping("/todos/{id}")  //idを指定してTODOを更新
	public void updateTodo(@RequestBody ToDoWithoutId toDoWithoutId, @PathVariable("id") int id) {
		//if(toDoService.getTodo(id) == null) {
		//	throw new ItemNotFoundException(id);
		//}
		toDoService.updateTodo(toDoWithoutId, id);
	}
	
	//フィルタリング
	@GetMapping("/todos/status/{status}")  //statusによってフィルタリング
	public List<ToDo> statusFilter(@PathVariable("status") String status){
		return toDoService.statusFilter(status);
	}
	
	@GetMapping("/todos/title/{title}")  //titleによってフィルタリング
	public List<ToDo> titleFilter(@PathVariable("title") String title){
		return toDoService.titleFilter(title);
	}
	
	//ソート
	@GetMapping("/todos/sort/status")
	public List<ToDo> statusSort(String status){
		return toDoService.statusSort(status);
	}
	
	@GetMapping("/todos/sort/id")
	public List<ToDo> idSort(int id){
		return toDoService.idSort(id);
	}

}
