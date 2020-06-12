package net.project.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.project.model.Contact;



//import net.codejava.contact.dao.ContactDao;

class ContactDaoTest {
	private DriverManagerDataSource dataSource;
	private ContactDao dao;
	
	@BeforeEach
	void setupBeforeEach()
	{
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("sourabh");
		
		dao=new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		
		Contact contact=new Contact(1,"meeting","kaka","po");
		int result=dao.save(contact);
		assertTrue(result>0);
		
		
		
		//fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		Contact contact=new Contact(1,3,"ko","ds","iu");
		int result=dao.update(contact);
		assertTrue(result>0);
		//fail("Not yet implemented");
	}

	@Test
	void testGet() {
		
	Integer id=1;
	Contact contact=dao.get(id);
	if(contact!=null)
	{
		System.out.println(contact);
	}
	
	assertNotNull(contact);
		
		//fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		Integer id=2;
		int result=dao.delete(id);
		assertTrue(result>0);
		//fail("Not yet implemented");
	}

	@Test
	void testList() {
		List<Contact> listContacts=dao.list();
		for(Contact aContact : listContacts) {
			System.out.println(aContact);
		}
		assertTrue(!listContacts.isEmpty());
		//fail("Not yet implemented");
	}

}
