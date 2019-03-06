<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div style="width:500px;margin:0px auto;text-align:center">
	
	
	<div style="text-align:center;margin-top:40px">
		
		<form method="post" action="updateCourse">
			课程名称： <input name="name" value="${c.name}" type="text"> <br><br>
			课程价格： <input name="price" value="${c.price}" type="text"> <br><br>
			
			<input type="hidden" value="${c.id}" name="id">
			<input name="user.id" value="${c.user.id}" type="hidden"> <br><br>
			<input type="submit" value="修改课程">
		</form>

	</div>	
 </div>
