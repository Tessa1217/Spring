package com.company.mvc.todo;

import java.util.List;

public interface TodoMapper {
	
	public List<TodoVO> findAll(TodoVO vo);
	public TodoVO findById(int no);
	public void persist(TodoVO vo);
	public void merge(TodoVO vo);
	public void remove(int no);
	

}
