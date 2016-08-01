package main.java.todolist;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.ControllerAdvice;


@SpringBootApplication
@ControllerAdvice
public class TodoListAppilication extends SpringBootServletInitializer  {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TodoListAppilication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(TodoListAppilication.class);
	}
}
