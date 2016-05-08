<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:url value="/resources/css" var="baseUrlCss" />
<spring:url value="/resources/js" var="baseUrlJS" />
<spring:url value="/resources/img" var="baseUrlImg" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Template</title>

<!-- Bootstrap -->
<link href="${baseUrlCss}/bootstrap.css" rel="stylesheet">
<link href="${baseUrlCss}/style-commons.css" rel="stylesheet">
<link href="${baseUrlCss}/style-signin.css" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
<script src="${baseUrlJS}/jquery-1.12.3.min.js"></script>


<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${baseUrlJS}/bootstrap.js"></script>


<!--JQuery UI-->
<link href="${baseUrlJS}/jquery-ui-1.11.4/jquery-ui.min.css"
	rel="stylesheet">
<script src="${baseUrlJS}/jquery-ui-1.11.4/jquery-ui.min.js"></script>

</head>
<body>
	<div class="container" id="wrap">


		<div id="content">
			<a href=""> <img src="${baseUrlImg}/logo-signin.png" />
			</a>
			<p>Sign in to DistributionNetwork</p>

			<c:if test="${error != null}">
				<div class="alert alert-danger fade-in">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					Incorrect username or password.
				</div>
			</c:if>



			<c:url value="/j_spring_security_check" var="signinUrl" />

			<form:form action="${signinUrl}" method="POST" id="signin">
				<div class="form-group">
					<label for="username">Username or email address</label> <input
						type="text" name="j_username" id="username" class="form-control">
				</div>

				<div class="form-group">
					<label for="password">Password</label> <a href="" id="forgot">Forgot
						password?</a> <input type="password" name="j_password" id="password"
						class="form-control">
				</div>
				<div class="form-group">
					<button type="submit" id="button-signin" class="btn">Sign
						in</button>
					<input type="checkbox">Remember me
				</div>
			</form:form>
		</div>
		<!-- end content-->
	</div>
	<!-- end wrap-->
</body>
</html>