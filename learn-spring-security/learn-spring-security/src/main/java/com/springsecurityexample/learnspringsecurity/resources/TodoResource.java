package com.springsecurityexample.learnspringsecurity.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<Todo> Todos_List = List.of(new Todo("user", "Learn aws"),
			new Todo("user", "Learn ng"));

	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return Todos_List;
	}
	
	@GetMapping("/users/{username}/todos")
	public Todo retrieveTodosForASpecificUser(@PathVariable("username") String username) {
		return Todos_List.get(0);
	}

	@PostMapping("/users/{username}/todos")
	public void createTodosForASpecificUser(@PathVariable("username") String username, @RequestBody Todo todo) {
		logger.info("create {} for {}", todo, username);
	}
}

record Todo(String username, String description) {
}

