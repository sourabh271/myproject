package net.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.project.model.Contact;

public class ContactDAOImpl implements ContactDao{
  private JdbcTemplate jdbcTemplate;
  public ContactDAOImpl(DataSource dataSource)
  {
	  this.jdbcTemplate=new JdbcTemplate(dataSource);
  }
	@Override
	public int save(Contact contact) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Contact (priority,name,time,date) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql,contact.getPriority(),contact.getName(),contact.getTime(),contact.getDate());
		
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		String sql="UPDATE Contact SET priority=?, name=?, time=?, date=? WHERE id=?";
		
		return jdbcTemplate.update(sql,contact.getPriority(),contact.getName(),contact.getTime(),contact.getDate(),contact.getId());
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Contact WHERE id="+id;
		ResultSetExtractor<Contact> extractor=new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					int priority=rs.getInt("priority");
					String name=rs.getString("name");
					String time=rs.getString("time");
					String date=rs.getString("date");
					
					return new Contact(id,priority,name,time,date);
				}
				return null;
			}
			
		};
		return jdbcTemplate.query(sql,extractor);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Contact WHERE id="+id;
		return jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Contact";
		RowMapper<Contact> rowMapper=new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				int id=rs.getInt("id");
				int priority=rs.getInt("priority");
				String name=rs.getString("name");
				String time=rs.getString("time");
				String date=rs.getString("date");
				
				
				return new Contact(id,priority,name,time,date);
			}
			
		};
		return jdbcTemplate.query(sql,rowMapper);
		
	}

}
