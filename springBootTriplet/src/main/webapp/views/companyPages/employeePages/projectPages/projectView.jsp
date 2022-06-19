<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Project View</title>
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
										<i class="fa fa-bar-chart" aria-hidden="true">&nbsp;
											Projects List</i>
									</h3>
								</div>
								<div class="col-sm-4 text-right">
									<a class="btn btn-warning"
										href="<c:url value='/company/employee/view/${company.companyId}' />">View
										Employees</a>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-9 text-center">
									<table class="text-left" style="width: 60%">
										<thead>
											<tr>
												<th>Employee Id</th>
												<th>:</th>
												<td>${employee.employeeId}</td>

											</tr>
											<tr>
												<th>Employee Name</th>
												<th>:</th>
												<td>${employee.firstName}&nbsp;${employee.lastName}</td>
											</tr>
										</thead>
									</table>
								</div>
								<div class="col-sm-3 text-right">
									<a class="btn btn-info"
										href="<c:url value='/employee/${employee.employeeId}/project/new' />">Allot
										Projects</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body">
						<table class="table table-striped text-center">
							<thead>
								<tr>
									<th>SR. NO.</th>
									<th>PROJECT NAME</th>
									<!--<th>DESCRIPTION</th> -->
									<th>STATUS</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="project" items="${employee.getProject() }"
									varStatus="ind">
									<tr>
										<td>${ind.index+1}</td>
										<td>${project.projectName }</td>
										<td>${project.status }</td>
										<td><i class="fa fa-eye" aria-hidden="true"
											data-toggle="modal" data-target="#myModal"
											onclick="addDescription('${project.description}');"></i>
											&nbsp;&nbsp; <a
											href="<c:url value='/employee/project/edit/${project.projectId}' />"><i
												class="fa fa-pencil" aria-hidden="true"></i></a> &nbsp;&nbsp; <a
											href="<c:url value='/employee/project/delete/${project.projectId}' />"><i
												class="fa fa-trash" aria-hidden="true"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- The Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="smallmodalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h5 class="modal-title">Description</h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="row form-group">
							<div class="col-md-12 col-sm-12 col-12">
								<textarea class="form-control" id="desc" readonly="readonly"></textarea>
							</div>
						</div>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function addDescription(description) {
		//alert("feedback ====>>>");
		//$("#myModal").show();
		$("#desc").show().val(description);
	}
</script>
</html>