<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee View</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-color: #e2e2e2;
}
</style>
</head>
<body>
	<!-- 	<h1 class="text-center">Create Company Here</h1> -->
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-12">
				<div class="card">
					<div class="card-header">
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-12">
									<h3 class="text-center">
										<i class="fa fa-building-o" aria-hidden="true">&nbsp;
											${company.companyName }</i>
									</h3>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-8">
									<h3>
										<i class="fa fa-users" aria-hidden="true">&nbsp; Employees
											List</i>
									</h3>
								</div>
								<div class="col-sm-4 text-right">
									<a class="btn btn-warning" href="<c:url value='/company/view' />">View
										Companies</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body">
						<table class="table table-striped text-center">
							<thead>
								<tr>
									<th>SR. NO.</th>
									<th>FIRST NAME</th>
									<th>LAST NAME</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="employee" items="${employeeList }"
									varStatus="ind">
									<tr>
										<td>${ind.index+1}</td>
										<td>${employee.firstName }</td>
										<td>${employee.lastName }</td>
										<td><a class="btn btn-danger"
											href="<c:url value='/company/employee/delete/${employee.employeeId}' />">Delete</a>
											<a class="btn btn-primary"
											href="<c:url value='/company/employee/edit/${employee.employeeId}' />">Update</a>
											<a class="btn btn-info"
											href="<c:url value='/employee/${employee.employeeId}/project' />">Projects</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- <div class="card-footer text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div> -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>