<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch Section</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<div class="d-flex justify-content-center align-center">
		<div class="w-50 align-middle border border-info border-3 mt-2"
			style="height: 500px">

			<h6 class="p-3 text-primary ">
				<u>Batch Shift :-</u>
			</h6>
			<div class="border border-secondary m-3 p-2">
				<table class="table table-hover border border-secondary ">
					<tbody>
						<tr class="table-primary fs-6">
							<th>Student Id</th>
							<td>${st.studentId}</td>
						</tr>
						<tr class="table-primary fs-6">
							<th>Student Name</th>
							<td>${st.studentFullName}</td>
						<tr class="table-primary fs-6">
							<th>Course Name</th>
							<td>${st.studentCourse}</td>
						</tr>

						<tr class="table-primary fs-6">
							<th>Batch Number</th>
							<td>${st.batchNumber}</td>
						</tr>
						<tr class="table-primary fs-6">
							<th>Batch Mode</th>
							<td>${st.batchMode}</td>
						</tr>
						</tr>
						<tr class="table-danger fs-6">
							<th>Fees Paid</th>
							<td>${st.feesPaid}</td>
						</tr>

					</tbody>
				</table>
				<div class="row">
					
					<form action="shiftbatch">
						<input type="text" name="studentId" value="${st.studentId}"
							hidden="true">
						<div class="row">

							<div class="row">
								<div class="col">
									<select class="select form-control-sm" name="mode">
										<option value="#" disabled>Select Batch Mode</option>
										<option value="Online">Online</option>
										<option value="Offline">Offline</option>

									</select> <label class="form-label select-label">Batch Mode</label>
								</div>
								<div class="col">
									<select class="select form-control-sm" name="batch">
										<option value="#" disabled>Select Batch Number</option>
										<option value="FDJ-185">FDJ-185</option>
										<option value="REG-185">REG-185</option>
										<option value="FDJ-186">FDJ-186</option>
										<option value="REG-186">REG-186</option>
										<option value="REG-188">REG-188</option>

									</select> <label class="form-label select-label">Batch Number</label>
									  <input type="submit" value="SUBMIT">
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>