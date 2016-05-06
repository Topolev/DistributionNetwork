<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-7">
		<p id="header">Create your personal account</p>
		<form:form commandName="user" method="POST" id="form-register">
			<div class="form-group">
				<label class="control-label">Username</label>
				<div class="input-field">
					<form:input path="username" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group has-error">
				<label class="control-label">Email</label>
				<div class="input-field">
					<form:input path="email" cssClass="form-control"/>
					<span class="glyphicon glyphicon-remove control-label"></span>
				</div>
				<span class="control-label">Password can consist 7 characters</span>
				<span class="default-text">We promise not to share your email
					with anyone</span>
			</div>
			<div class="form-group has-success">
				<label class="control-label">Password</label>
				<div class="input-field">
					<form:password path="password" cssClass="form-control"/>
					<span class="glyphicon glyphicon-ok control-label"></span>
				</div>
				<span class="default-text">Use at least one letter, one
					numerical and seven characters</span>
			</div>

			<div class="form-group">
				<button type="submit" id="button-signup" class="btn">Create
					an account</button>
			</div>
		</form:form>
	</div>
	<div class="col-md-5"></div>
</div>
<!--end div.row-->