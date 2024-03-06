package com.example.todoAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.todoAPI.model.ToDo;

@Service
public class ToDoService {
	
	private List<ToDo> list = new ArrayList<>();
	private static int counter = 0;
	
	public List<ToDo> getAllTodos(){  //TODOすべてをリストで返す
		return list;
	}
	
	public void addTodo(ToDo todo) {  //TODOを追加する
		counter++;
		String id = String.valueOf(counter);  //ToDoが追加されるたびに1増える変数でidを設定
		todo.setId(id);
		list.add(todo);
	}
	
	public ToDo getTodo(String id) {  //TODOをidで指定して一つ返す
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				return list.get(i);
			}
		}
		//throw new ItemNotFoundException(id);
		return null;
	}
	
	public void deleteTodo(String id) {  //TODOをidで指定して削除する　　←　後でTODOが見つからなかった場合の例外処理
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
			}
		}
	}
	
	public void updateTodo(ToDo todo, String id) {  //TODOを更新する
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.set(i, todo);
				list.get(i).setId(id);  //idは変えない
			}
		}
	}
	
	//フィルタリング
	public List<ToDo> statusFilter(String status){  //statusによってフィルタリングしてリストを返す
		List<ToDo> sList = list.stream().filter(todo -> status.equals(todo.getStatus()))
				.collect(Collectors.toList());
		return sList;
	}
	
	public List<ToDo> titleFilter(String title){  //titleによってフィルタリングしてリストを返す
		List<ToDo> tList = list.stream().filter(todo -> !(todo.getTitle().indexOf(title) == -1))
				.collect(Collectors.toList());
		return tList;
		
	}

}
