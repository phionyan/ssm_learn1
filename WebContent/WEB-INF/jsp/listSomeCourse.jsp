<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header" style="text-align: center">
				<h1>用户名:${user.name}</h1>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="warning">
						<th>id</th>
						<th>name</th>
						<th>price</th>
						<th width="50">编辑</th>
						<th width="50">删除</th>
					</tr>
				</thead>
				<c:forEach items="${courses}" var="course" varStatus="st">
					<tr class="success">
						<td>${course.id}</td>
						<td>${course.name}</td>
						<td>${course.price}</td>
						<td><a herf="editCourse?id=${course.id}" width="50">编辑</a></td>
						<td><a herf="deleteCourse?id=${course.id}" width="50">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div style="text-align: center">
				<a href="?id=${user.id}&start=0">首 页</a> 
				<a href="?id=${user.id}&start=${page.start-page.count}">上一页</a>
				<a href="?id=${user.id}&start=${page.start+page.count}">下一页</a>
				<a href="?id=${user.id}&start=${page.last}">末 页</a>
			</div>
		</div>
	</div>

	<div style="text-align:center;margin-top:40px">
		
		<form method="post" action="addCourse">
			课程名称： <input name="name" value="" type="text"> <br><br>
			课程价格： <input name="price" value="" type="text"> <br><br>
			<input name="user.id" value="${user.id}" type="hidden"> <br><br>
			<input type="submit" value="增加课程">
		</form>

	</div>	

</div>