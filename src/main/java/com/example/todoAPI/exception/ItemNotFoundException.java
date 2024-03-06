package com.example.todoAPI.exception;

public class ItemNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(String id) {
		super("ID：" + id + "は見つかりません。");
	}
}
