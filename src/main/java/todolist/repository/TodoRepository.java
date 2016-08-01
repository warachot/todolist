package main.java.todolist.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import main.java.todolist.domain.Todo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
 
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public List<Todo> getTodoList()
    {
		String sql = "SELECT * FROM todolist";
		return jdbcTemplate.query(sql, new TodoMapper());
    }
	
	public int addTodo(String subject, String desc,String status)
	{		
		String sql =  "INSERT INTO todolist (subject,task,status,creation_date)  values (?,?,?,CURRENT_TIMESTAMP)";
		return jdbcTemplate.update(sql, subject,desc, status );
	}
	
	public List<Todo> getTodo(int id)
	{		
		String sql =  "SELECT * FROM todolist WHERE id = ?";
		return jdbcTemplate.query(sql, new TodoMapper(),id);
	}
	
	public int updateTodo(int id, String subject, String desc,String status ){
		String sql =  "UPDATE todolist SET subject=?,task = ?, status = ?  WHERE id = ?";
		return jdbcTemplate.update(sql, subject,desc, status, id );
	}
	
	public int deletTodo(int id){
		String sql =  "DELETE FROM todolist WHERE id = ?";
		return jdbcTemplate.update(sql, id );
	}
	
	private class TodoMapper implements RowMapper<Todo>
	{

		public Todo mapRow(ResultSet result, int rowNum) throws SQLException {
			Todo todo = new Todo();
			todo.id = result.getInt("id");
			todo.subject = result.getString("subject");
			todo.task = result.getString("task");
			todo.status = result.getString("status");
			todo.creationDate = result.getTimestamp("creation_date");
			return todo;
		}
		
	}
}
