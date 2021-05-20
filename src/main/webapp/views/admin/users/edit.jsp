<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" ></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light px-5">
	  <a class="navbar-brand" href="#">Navbar</a>
	
	  <div class="collapse navbar-collapse">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Users</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Categories</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Products</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="mt-5 col-10 offset-1">
		<form
			method="POST"
			action="${ pageContext.request.contextPath }/admin/users/update/1">
			<input type="hidden" name="_method" value="put" />
			<div class="form-group mt-3">
				<label for="name">Name</label>
			    <input value="${ user.name }" type="text" class="form-control" id="name" name="name" autocomplete="off">
			    <small id="name_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="email">Email</label>
			    <input value="${ user.email }" type="email" class="form-control" id="email" name="email" autocomplete="off">
			    <small id="email_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="password">Password</label>
				<input value="${ user.password }" type="hidden" name="password"/>
			    <input value="${ user.password }" type="password" class="form-control" id="password" autocomplete="off" disabled>
			    <small id="password_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="dob">Date of Birth</label>
			    <input value="${ user.dob }" type="text" class="form-control" id="dob" name="dob" autocomplete="off">
			    <small id="dob_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="role">Role</label>
				<select name="role" id="role" class="form-control" required>
					<option selected disabled>Choose</option>
					<option value="1" ${ user.role == 1 ? "selected" : "" }>User</option>
					<option value="2" ${ user.role == 2 ? "selected" : "" }>Admin</option>
				</select>
			    <small id="role_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="avatar">Image</label>
			    <input type="file" value="${ user.avatar }" class="form-control" id="avatar" name="avatar">
			    <small id="avatar_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="gender">Gender</label>
				<select name="gender" id="gender" class="form-control" required>
					<option selected disabled>Choose</option>
					<option value="1" ${ user.gender == 1 ? "selected" : "" }>Male</option>
					<option value="2" ${ user.gender == 2 ? "selected" : "" }>Female</option>
				</select>
			    <small id="gender_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<label for="status">Status</label>
				<select name="status" id="status" class="form-control" required>
					<option selected disabled>Choose</option>
					<option value="1" ${ user.status == 1 ? "selected" : "" }>Active</option>
					<option value="2" ${ user.status == 2 ? "selected" : "" }>Inactive</option>
				</select>
			    <small id="status_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group mt-3">
				<button class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Clear</button>
			</div>
		</form>
	</div>
</body>
</html>