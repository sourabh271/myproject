package net.project.model;

public class Contact {
	private Integer id;
	private Integer priority;
	private String name;
	private String time;
	private String date;
	public Contact() {
		
	}
	public Contact(Integer id, Integer priority, String name, String time, String date) {
		this.id = id;
		this.priority = priority;
		this.name = name;
		this.time = time;
		this.date = date;
	}
	public Contact( Integer priority, String name, String time, String date) {
		
		this.priority = priority;
		this.name = name;
		this.time = time;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", priority=" + priority + ", name=" + name + ", time=" + time + ", date=" + date
				+ "]";
	}
	

}
