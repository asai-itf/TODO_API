package com.example.todoAPI.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.todoAPI.model.ToDo;
import com.example.todoAPI.model.ToDoWithoutId;

@Mapper
public interface ToDoMapper {

	List<ToDo> selectAll();
	void insert(ToDoWithoutId toDoWithoutId);
	ToDo select(int id);
	void delete(int id);
	void update(@Param("toDoWithoutId") ToDoWithoutId toDoWithoutId, @Param("id") int id);
	
	//Filter
	List<ToDo> statusFilter(String status);
	List<ToDo> titleFilter(String title);
	
	//Sort
	List<ToDo> statusSort(String status);
	List<ToDo> idSort(int id);
}
