package net.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.project.dao.ContactDao;
import net.project.model.Contact;

public class MainController {

	@Autowired
	private ContactDao contactDAO;
	@RequestMapping(value="/")
	public ModelAndView listTask(ModelAndView model)
	{
		List<Contact> list=contactDAO.list();
		model.addObject("listContact", list);
		model.setViewName("index");
		
		
		return model;
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView newTask(ModelAndView model)
	{
		Contact newTask=new Contact();
	
		model.addObject("task", newTask);
		model.setViewName("task_form");
		
		
		return model;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute Contact task)
	{
		if(task.getId()==null)
		{
		contactDAO.save(task);
		}
		else
		{
			contactDAO.update(task);
		}
		
		
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public ModelAndView editTask(HttpServletRequest request)
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Contact contact=contactDAO.get(id);
		ModelAndView model=new ModelAndView("task_form");
		model.addObject("contact", contact);
		
		return model;
	}
	

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteTask(@RequestParam Integer id)
	{
		
		contactDAO.delete(id);
		return new ModelAndView("redirect:/");
		
	}
	
}
