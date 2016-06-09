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
					<span class="glyphicon glyphicon-remove control-label"></span>
					<span class="glyphicon glyphicon-ok control-label"></span>
				</div>
				<span class="control-label error-text">Username must consist at least 7 characters</span>
				<span class="default-text">Use at least seven characters</span>
			</div>
			
			<div class="form-group ${errorEmail}">
				<label class="control-label">Email</label>
				<div class="input-field">
					<form:input path="email" cssClass="form-control" id="email"/>
					<span class="glyphicon glyphicon-remove control-label"></span>
					<span class="glyphicon glyphicon-ok control-label"></span>
				</div>
				<span class="control-label error-text">Invalid email address.</span>
				<span class="default-text">We promise not to share your email with anyone</span>
			</div>
			
			<div class="form-group ${errorPassword}">
				<label class="control-label">Password</label>
				<div class="input-field">
					<form:password path="password" cssClass="form-control" id="password"/>
					<span class="glyphicon glyphicon-remove control-label"></span>
					<span class="glyphicon glyphicon-ok control-label"></span>
				</div>
				<span class="default-text">Use at least seven characters</span>
				<span class="control-label error-text">Use at least seven characters</span>
			</div>

			<div class="form-group">
				<button type="submit" id="button-signup" class="btn">Create
					an account</button>
			</div>
		</form:form>
	</div>
	<div class="col-md-5"></div>
	<c:url var="home" value="/"/>
</div>
<!--end div.row-->

<script>
	
 jQuery(document).ready(function($) {
	
	 $('input.form-control').on("change", function(){
		 var jsonRequest = {};
		 jsonRequest["type"] = $(this).attr("id");
		 jsonRequest["value"] = $(this).val();
		 console.log(JSON.stringify(jsonRequest))
		 $.ajax({
			 type: "POST",
			 contentType : "application/json",
			 url: "${home}signup/validate",
			 timeout: 100000,
			 dataType: "json",
			 data: JSON.stringify(jsonRequest),
			 success: function(jsonResponse){
				 console.log("SUCCESS");
			 },
			 error: function(textError){
				console.log("ERROR");
			 }
		 })
	 })
	 
	 /*
	 function validExcitingUsernameEmail($input){
		 var error = true;
		 if ($input.is("#username")) {
			 error = isValidUsername();
		 } 
		 if ($input.is("#email")) {
			 error = isValidEmail();
		 } 
		 
		 if (error == true){
		 $.ajax({
			type : "GET",
			url : "${home}signup/validUsername",
			data : "usernameOrEmail=" + $input.val(),
			timeout : 100000,
			success : function(data) {
				if (data == "true"){
					if ($input.is("#username")) text = "Current username is excited";
					if ($input.is("#email")) text = "Current email is excited";
					$input.parents(".form-group").addClass("has-error").removeClass("has-success");
					$input.parents(".form-group").find(".error-text").html(text);
				} else{
					$input.parents(".form-group").addClass("has-success").removeClass("has-error");
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		 }  
	 }
	 
	 $('#username').on('change', function(){
		validExcitingUsernameEmail($(this));
	});
	 $('#email').on('change', function(){
			validExcitingUsernameEmail($(this));
	})
	$('#password').on('change', function(){
		isValidPassword();
	})
	
	var regExEmail = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/i;
	var regExUsername =/^[a-zA-Z0-9\.]+$/i;
	
	function isValidEmail(){
		var checkValid = true;
		if (regExEmail.test($("#email").val())){
			$("#email").parents(".form-group").addClass("has-success").removeClass("has-error");
		} else {
			checkValid = false;
			$("#email").parents(".form-group").addClass("has-error").removeClass("has-success");
			$("#email").parents(".form-group").find(".error-text").html("Invalid email");
		}
		return checkValid;
	}
	
	function isValidUsername(){
		var checkValid = true;
		var textError = "";
		
		if ($("#username").val().length < 7){
			checkValid = false;
			textError = "Username must consist at least 7 characters"
		}
		if (!regExUsername.test($("#username").val())){
			checkValid = false;
			textError = "Username consist invalid simbols"
		} 
		if (!checkValid){
			$("#username").parents(".form-group").addClass("has-error").removeClass("has-success");
			$("#username").parents(".form-group").find(".error-text").html(textError);
		} else {
			$("#username").parents(".form-group").addClass("has-success").removeClass("has-error");
		}
		return checkValid;
	}
	
	function isValidPassword(){
		var checkValid = true;
		if ($("#password").val().length <7){
			checkValid = false;
			$("#password").parents(".form-group").addClass("has-error").removeClass("has-success");
		} else{
			$("#password").parents(".form-group").addClass("has-success").removeClass("has-error");
		}
		return checkValid ;
	}
	
	$("#button-signup").on("click", function(e){
		if (!(isValidUsername() & isValidEmail() & isValidPassword())){
			e.preventDefault();
		}
	})*/
 });
</script>