package main.java.todolist.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.todolist.domain.Todo;
import main.java.todolist.domain.Todo;
import main.java.todolist.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 


@RestController
public class TodoListController {
	 
	@Inject
	private TodoRepository  repository;
	
	@RequestMapping(value = "/todo/list", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> getTodoList() {
		List<Todo> q = repository.getTodoList();
		return new ResponseEntity<List<Todo>>(q, HttpStatus.OK);  
    }
	
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> getTodo(@PathVariable int id) {
		List<Todo> q = repository.getTodo(id);
		return new ResponseEntity<List<Todo>>(q, HttpStatus.OK);  
    }
	
	@RequestMapping(value = "/todo", method = RequestMethod.PUT)
	public ResponseEntity<Todo> update(@RequestBody Todo todo){
		repository.updateTodo(todo.id, todo.subject, todo.task, todo.status);
		return new ResponseEntity<Todo>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.DELETE)
	public int deleteTodo(@RequestParam(value="id", defaultValue="0") int id){
		return repository.deletTodo(id);
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.POST)
    public ResponseEntity<Object> createTodo(@RequestBody Todo todo){
		int todoId = repository.addTodo(todo.subject, todo.task, todo.status);
		return new ResponseEntity<Object>(todoId , HttpStatus.CREATED);
	}
	
}
