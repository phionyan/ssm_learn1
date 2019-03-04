<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>
							id
						</th>
						<th>
							name
						</th>
						<th>
							password
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user" varStatus="vs">
						<tr class="success">
							<td>
								${user.id}
							</td>
							<td>
								${user.name}
							</td>
							<td>
								${user.password}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>