<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>College Crud</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
				<c:if test="${newCompany==true}">
					<form:form action="/company/save" method="post"
						modelAttribute="company">
						<form:hidden path="companyId" name="companyId" id="companyId" />
						<div class="card">
							<div class="card-header">
								<div class="row">
									<div class="col-sm-8">
										<h3>Create Company</h3>
									</div>
									<div class="col-sm-4 text-right">
										<a class="btn btn-warning"
											href="<c:url value='/company/view' />">View Companies</a>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="exampleInputEmail1">Company Name</label>
									<form:input path="companyName" type="text" class="form-control"
										id="companyName" name="companyName"
										placeholder="Enter Company Name" />
								</div>
							</div>
							<div class="card-footer text-center">
								<button type="submit" class="btn btn-primary" id="submitBtn1" disabled="disabled">SUBMIT</button>
							</div>
						</div>
					</form:form>
				</c:if>

				<c:if test="${newEmployee==true}">
					<form:form action="/company/employee/save" method="post"
						modelAttribute="company">
						<form:hidden path="companyId" name="companyId" id="companyId" />
						<form:hidden path="companyName" name="companyName"
							id="companyName" />
						<div class="card">
							<div class="card-header">
								<div class="row">
									<div class="col-sm-8">
										<h3>New Employees</h3>
									</div>
									<div class="col-sm-4 text-right">
										<a class="btn btn-warning"
											href="<c:url value='/company/view' />">View Companies</a>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-5">
											<div class="form-group">
												<label for="firstName">First Name</label> <input type="text"
													class="form-control" id="firstName1" name="firstName"
													placeholder="Enter First Name">
											</div>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<label for="lastName">Last Name</label> <input type="text"
													class="form-control" id="lastName1" name="lastName"
													placeholder="Enter Last Name">
											</div>
										</div>
										<div class="col-md-2" style="margin-top: 33px;">
											<div class="form-group">
												<button type="button" class="btn btn-primary form-control"
													id="addBtn">ADD</button>
											</div>
										</div>
									</div>
								</div>
								<input type="hidden" id="data" name="data" />
								<div style="display: none;" id="unHide">
									<table class="table table-striped text-center mt-5"
										id="myTableWhileEmployeeNew">
										<thead>
											<tr>
												<th>SR. NO.</th>
												<th>FIRST NAME</th>
												<th>LAST NAME</th>
												<th>ACTION</th>
											</tr>
										</thead>
										<tbody id="tBody">

										</tbody>
									</table>
								</div>
							</div>
							<div class="card-footer text-center">
								<button type="submit" class="btn btn-primary"
									onclick="html2json();" disabled="disabled" id="submitBtn">SUBMIT</button>
							</div>
						</div>
					</form:form>
				</c:if>


				<c:if test="${editEmployee==true}">
					<form action="/company/employee/edit" method="get">
						<input type="hidden" name="companyId" id="companyId"
							value="${employee.getCompany().companyId }" /> <input
							type="hidden" name="companyName" id="companyName"
							value="${employee.getCompany().companyName }" /> <input
							type="hidden" name="employeeId" id="employeeId"
							value="${employee.employeeId }" />
						<div class="card">
							<div class="card-header">
								<div class="row">
									<div class="col-sm-8">
										<h3>Update Employee</h3>
									</div>
									<div class="col-sm-4 text-right">
										<a class="btn btn-warning"
											href="<c:url value='/company/employee/view/${employee.getCompany().companyId}' />">View
											Employees</a>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-5">
											<div class="form-group">
												<label for="firstName">First Name</label> <input type="text"
													class="form-control" id="firstName" name="firstName"
													placeholder="Enter First Name"
													value="${employee.firstName }">
											</div>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<label for="lastName">Last Name</label> <input type="text"
													class="form-control" id="lastName" name="lastName"
													placeholder="Enter Last Name" value="${employee.lastName }">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="card-footer text-center">
								<button type="submit" class="btn btn-primary">UPDATE</button>
							</div>
						</div>
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#companyName").bind('keyup mouseup', function() {
		var companyName = $('#companyName').val();
		if (companyName.length >= 1) {
			if (companyName && companyName.trim()) {
				$('#submitBtn1').prop('disabled', false);
			}else{
				$('#submitBtn1').prop('disabled', true);
			}
		}

	});
</script>


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						// Add button functionality
						$("#addBtn")
								.click(
										function() {
											var firstName1 = $('#firstName1')
													.val();
											var lastName1 = $('#lastName1')
													.val();
											if (firstName1 == ''
													|| firstName1 == null) {
												$('#firstName1')
														.attr('title',
																'Please Select First Name');
												setTimeout(function() {
													$("#firstName1").focus(), 5
												});
												$("#firstName1").tooltip();
											} else if (lastName1 == ''
													|| lastName1 == null) {
												$('#lastName1')
														.attr('title',
																'Please Select Last Name');
												setTimeout(function() {
													$("#lastName1").focus(), 5
												});
												$("#lastName1").tooltip();
											} else {
												$("#submitBtn").prop(
														'disabled', false);
												document
														.getElementById("unHide").style.display = 'block';
												var len = document
														.getElementById("tBody").rows.length;
												len++;
												var companyId = $("#companyId")
														.val();
												var firstName = $("#firstName1")
														.val();
												var lastName = $("#lastName1")
														.val();
												$("#tBody")
														.append(
																'<tr id="id"><td>'
																		+ len
																		+ '</td><td>'
																		+ firstName
																		+ '</td><td>'
																		+ lastName
																		+ '</td><td class="text-danger remCF" id="remove"><i class="fa fa-trash remove"></i></td></tr>');
												$('#firstName1').val('');
												$('#lastName1').val('');
											}
										});

						//Remove button functionality
						$("#myTableWhileEmployeeNew")
								.on(
										"click",
										'i.remove',
										function() {
											$(this).parents("tr").remove();
											var len = document
													.getElementById("tBody").rows.length;
											if (len === 0) {
												document
														.getElementById("unHide").style.display = 'none';
												$("#submitBtn").prop(
														'disabled', true);
											}
											updateRowCount();
										});
					});

	function updateRowCount() {
		var table = document.getElementById("myTableWhileEmployeeNew");
		var rowcountAfterDelete = document
				.getElementById("myTableWhileEmployeeNew").rows.length;
		for (var i = 1; i < rowcountAfterDelete; i++) {
			table.rows[i].cells[0].innerHTML = i;
		}
	}
</script>


<script type="text/javascript">
	function html2json() {
		document.getElementById('data').value = '';
		var jsonArray = [];
		var myTableWhileEmployeeNew = document.getElementById("tBody");
		for (var i = 0; i < myTableWhileEmployeeNew.rows.length; i++) {
			var jsonObject = {
				"firstName" : myTableWhileEmployeeNew.rows[i].cells[1].innerHTML,
				"lastName" : myTableWhileEmployeeNew.rows[i].cells[2].innerHTML
			};
			jsonArray.push(jsonObject);
		}

		var data = document.getElementById('data');
		data.value = JSON.stringify(jsonArray);
	}
</script>
</html>