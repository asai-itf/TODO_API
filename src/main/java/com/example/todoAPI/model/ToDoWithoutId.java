package com.example.todoAPI.model;

public class ToDoWithoutId {
	
	private String title;
	private String status;
	private String details;
	
	public ToDoWithoutId() {
		
	}
	
	public ToDoWithoutId(String title, String status, String details) {
		this();
		this.title = title;
		this.status = status;
		this.details = details;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
