<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:hasBindErrors name="user">

	<c:set var="errorUsername" value="has-success" />
	<c:if test="${errors.hasFieldErrors('username')}">
		<c:set var="errorUsername" value="has-error" />
	</c:if>

	<c:set var="errorEmail" value="has-success" />
	<c:if test="${errors.hasFieldErrors('email')}">
		<c:set var="errorEmail" value="has-error" />
	</c:if>

	<c:set var="errorPassword" value="has-success" />
	<c:if test="${errors.hasFieldErrors('password')}">
		<c:set var="errorPassword" value="has-error" />
	</c:if>

	<c:set var="errorConfirmPassword" value="has-success" />
	<c:if test="${errors.hasFieldErrors('confirmPassword')}">
		<c:set var="errorConfirmPassword" value="has-error" />
	</c:if>
</spring:hasBindErrors>


<div class="row">
	<div class="col-md-7">
		<p id="header">Create your personal account</p>
		<form:form commandName="user" method="POST" id="form-register">
			
			<div class="form-group ${errorUsername}">
				<label class="control-label">Username</label>
				<div class="input-field">
					<form:input path="username" cssClass="form-control" id="username"/>
					<c:if test="${errorUsername.equals('has-error')}">
						<span class="glyphicon glyphicon-remove control-label"></span>
					</c:if>
					<c:if test="${errorUsername.equals('has-success')}">
						<span class="glyphicon glyphicon-ok control-label"></span>
					</c:if>
				</div>
				<c:if test="${errorUsername.equals('has-error')}">
					<span class="control-label">Username must consist at least 7
						characters</span>
				</c:if>
				<span class="default-text">Use at least seven characters</span>

			</div>
			
			<div class="form-group ${errorEmail}">
				<label class="control-label">Email</label>
				<div class="input-field">
					<form:input path="email" cssClass="form-control" />
					<c:if test="${errorEmail.equals('has-error')}">
						<span class="glyphicon glyphicon-remove control-label"></span>
					</c:if>
					<c:if test="${errorEmail.equals('has-success')}">
						<span class="glyphicon glyphicon-ok control-label"></span>
					</c:if>
				</div>
				<c:if test="${errorEmail.equals('has-error')}">
					<span class="control-label">Invalid email address.</span>
				</c:if>
				<span class="default-text">We promise not to share your email
					with anyone</span>
			</div>
			
			<div class="form-group ${errorPassword}">
				<label class="control-label">Password</label>
				<div class="input-field">
					<form:password path="password" cssClass="form-control" />
					<c:if test="${errorPassword.equals('has-error')}">
						<span class="glyphicon glyphicon-remove control-label"></span>
					</c:if>
					<c:if test="${errorPassword.equals('has-success')}">
						<span class="glyphicon glyphicon-ok control-label"></span>
					</c:if>
				</div>
				<span class="default-text">Use at least seven characters</span>
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
<script>
 jQuery(document).ready(function($) {
	
 });
</script>