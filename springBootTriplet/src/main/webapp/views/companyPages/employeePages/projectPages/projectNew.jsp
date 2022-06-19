<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Project New</title>
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
				<c:if test="${newProject == true }">
					<form:form action="/employee/project/save" method="post"
						modelAttribute="employee">
						<form:hidden path="employeeId" name="employeeId" id="employeeId" />
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
													Allot Projects</i>
											</h3>
										</div>
										<div class="col-sm-4 text-right">
											<a class="btn btn-warning"
												href="<c:url value='/employee/${employee.employeeId}/project' />">View
												Projects</a>
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
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="firstName">Project Name</label> <input
													type="text" class="form-control" id="projectName"
													name="projectName" placeholder="Enter First Name">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label for="lastName">Status</label> <select
													class="form-control" name="status" id="status">
													<option value="">--SELECT STATUS--</option>
													<option value="C">Complete</option>
													<option value="P">Pending</option>
													<option value="D">Dropped</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label for="lastName">Description</label>
												<textarea class="form-control" id="description"
													name="description" placeholder="Enter Last Name"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-12">
											<button type="button" class="btn btn-info form-control"
												id="addBtn">ADD</button>
										</div>
									</div>
								</div>
								<input type="hidden" id="data" name="data" />
								<div id="unHide" style="display: none;">
									<table class="table table-striped text-center mt-5"
										id="myTableWhileEmployeeNew">
										<thead>
											<tr>
												<th>SR. NO.</th>
												<th>PROJECT NAME</th>
												<th>STATUS</th>
												<th>DESCRIPTION</th>
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
									disabled="disabled" id="submitBtn" onclick="html2json();">SUBMIT</button>
							</div>
						</div>
					</form:form>
				</c:if>
				<c:if test="${editProject == true }">
					<form:form action="/employee/project/edit" method="post"
						modelAttribute="employee">
						<form:hidden path="employeeId" name="employeeId" id="employeeId" />
						<input type="hidden" id="projectId" name="projectId"
							value="${project.projectId }" />
						<input type="hidden" id="editValues" name="editValues" value="" />
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
													Allot Projects</i>
											</h3>
										</div>
										<div class="col-sm-4 text-right">
											<a class="btn btn-warning"
												href="<c:url value='/employee/${employee.employeeId}/project' />">View
												Projects</a>
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
									</div>
								</div>
							</div>

							<div class="card-body">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="firstName">Project Name</label> <input
													type="text" class="form-control" id="projectName"
													name="projectName" placeholder="Enter First Name"
													value="${project.projectName }">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label for="lastName">Status</label> <select
													class="form-control" name="status" id="status">
													<option value="">--SELECT STATUS--</option>
													<option value="C">Complete</option>
													<option value="P">Pending</option>
													<option value="D">Dropped</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label for="lastName">Description</label>
												<textarea class="form-control" id="description"
													name="description" placeholder="Enter Last Name" value=""></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="card-footer text-center">
								<button type="submit" class="btn btn-primary" id="submitBtnEdit">SUBMIT</button>
							</div>
						</div>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						// Add button functionality
						$("#addBtn")
								.click(
										function() {
											var projectName = $('#projectName')
													.val();
											var status = $('#status').val();
											if (projectName == ''
													|| projectName == null) {
												$('#projectName')
														.attr('title',
																'Please Select Project Name');
												setTimeout(function() {
													$("#projectName").focus(),
															5
												});
												$("#projectName").tooltip();
											} else if (status == ''
													|| status == null) {
												$('#status').attr('title',
														'Please Select Status');
												setTimeout(function() {
													$("#status").focus(), 5
												});
												$("#status").tooltip();
											} else {
												$("#submitBtn").prop(
														'disabled', false);
												document
														.getElementById("unHide").style.display = 'block';
												var len = document
														.getElementById("tBody").rows.length;
												len++;
												var employeeId = $(
														"#employeeId").val();
												var projectName = $(
														"#projectName").val();
												var status = $("#status").val();
												var description = $(
														"#description").val();
												$("#tBody")
														.append(
																'<tr id="id"><td>'
																		+ len
																		+ '</td><td>'
																		+ projectName
																		+ '</td><td>'
																		+ status
																		+ '</td><td>'
																		+ description
																		+ '</td><td class="text-danger remCF" id="remove"><i class="fa fa-trash remove"></i></td></tr>');
												$('#projectName').val('');
												$('#status').val('');
												$('#description').val('');
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
		var employeeId = $("#employeeId").val();
		for (var i = 0; i < myTableWhileEmployeeNew.rows.length; i++) {
			var jsonObject = {
				// 				"employeeId" : employeeId,
				"projectName" : myTableWhileEmployeeNew.rows[i].cells[1].innerHTML,
				"status" : myTableWhileEmployeeNew.rows[i].cells[2].innerHTML,
				"description" : myTableWhileEmployeeNew.rows[i].cells[3].innerHTML
			};
			jsonArray.push(jsonObject);
		}
		var data = document.getElementById('data');
		data.value = JSON.stringify(jsonArray);
	}
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("#description").val('${project.description}');
				$("#status").val('${project.status}');
				$("#submitBtnEdit").click(
						function() {
							$("#editValues").val('');
							var editValues = [];
							editValues.push($('#employeeId').val(), $(
									'#projectId').val(), $('#projectName')
									.val(), $('#status').val(), $(
									'#description').val());
							$("#editValues").val(editValues);
						});

			});
</script>

</html>