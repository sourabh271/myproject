<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyApp</title>
</head>
<body>
 <div align="center">
 <h1>Task List</h1>
 <h3><a href="new"></a>Add Task</h3>
 <table border="1" cellpadding="5">
 <tr>
 <th>No</th>
 <th>Priority</th>
 <th>TasK</th>
 <th>Time</th>
 <th>Date</th>
 </tr>
 <c:forEach items="${listContact}" var="task" varStatus="status">
 <tr>
 <td>${status.index +1 }</td>
 <td>${task.priority }</td>
 <td>${ task.name}</td>
 <td>${task.time }</td>
 <td>${task.date }</td>
 <td>
 <a href="edit?id=${task.id }">Edit<a>
 @nbsp;@nbsp;
 <a href="delete?id=${task.id }">Delete</a>
 </td>
 </tr>
 </c:forEach>
 </table>
 
 </div>
</body>
</html>