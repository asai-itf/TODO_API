package com.example.todoAPI.model;

public class ToDo {
	
	private String id;
	private String title;
	private String status;
	private String details;
	
	public ToDo() {
		
	}
	
	public ToDo(String title,String status, String details) {
		this();
		this.title = title;
		this.status = status;
		this.details = details;
	}

	// ↓ getterとsetter
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
