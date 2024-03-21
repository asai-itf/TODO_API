package com.example.todoAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoAPI.model.ToDo;
import com.example.todoAPI.model.ToDoWithoutId;
import com.example.todoAPI.repository.ToDoMapper;

@Service
public class ToDoService {
	
	@Autowired
	ToDoMapper mapper;
	
	public List<ToDo> getAllTodos(){  //TODOすべてをリストで返す
		return mapper.selectAll();
	}
	
	public void addTodo(ToDoWithoutId toDoWithoutId) {  //TODOを追加する
		mapper.insert(toDoWithoutId);;
	}
	
	public ToDo getTodo(int id) {  //TODOをidで指定して一つ返す
		return mapper.select(id);
	}
	
	public void deleteTodo(int id) {  //TODOをidで指定して削除する
		mapper.delete(id);
	}
	
	public void updateTodo(ToDoWithoutId toDoWithoutId, int id) {  //TODOを更新する
		mapper.update(toDoWithoutId, id);
	}
	
	//フィルタリング
	public List<ToDo> statusFilter(String status){  //statusによってフィルタリングしてリストを返す
		//List<ToDo> list = mapper.selectAll().stream().filter(todo -> status.equals(todo.getStatus()))
		//		.collect(Collectors.toList());   // ←DB接続前
		return mapper.statusFilter(status);
	}
	
	public List<ToDo> titleFilter(String title){  //titleによってフィルタリングしてリストを返す
		//List<ToDo> list = mapper.selectAll().stream().filter(todo -> !(todo.getTitle().indexOf(title) == -1))
		//		.collect(Collectors.toList());　　　// ←DB接続前
		return mapper.titleFilter(title);
	}
	
	//ソート
	public List<ToDo> statusSort(String status){
		return mapper.statusSort(status);
	}
	
	public List<ToDo> idSort(int id){
		return mapper.idSort(id);
	}

}
