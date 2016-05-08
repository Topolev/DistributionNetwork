<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<spring:url value="/resources/img" var="baseUrlImg" />

<div id="slider">
	<img src="${baseUrlImg}/back.jpg">
	<div class="text-slider">
		<span class="header-text"> Distribution network 6-10 kV </span> <span
			class="description-slider"> Calculate fault currents, flow
			distribution power and voltage at nodes of scheme distribution. </span>
	</div>
	
	<sec:authorize access="!isAuthenticated()">
		<div id="wrap-form">
			<c:url value="/signup" var="urlSignup" />
			<form:form commandName="user" method="POST"
				cssClass="form-horizontal" action="${urlSignup}">

				<div class="form-group">
					<form:input path="username" cssClass="form-control"
						placeholder="Username" />
					<form:input path="email" cssClass="form-control"
						placeholder="Email" />
					<form:password path="password" cssClass="form-control"
						placeholder="Password" />
					<span>Use at least one letter, one numerecal and seven
						characters</span>
					<button type="submit" class="btn btn-default">Sign up</button>
				</div>

			</form:form>
		</div>
	</sec:authorize>
</div>



<div id="description-ability">
	<p>Welcome, engineer!</p>
	<span> Our service allow you to make fast calculations for the
		electrical distribution networks 6-10 kV using an intuitive interface.
	</span>
	<div class="container-fluid" id="items-description">
		<div class="row">
			<div class="col-md-4">
				<div class="block">
					<img src="${baseUrlImg}/img1.png">
					<h1>Download or create the catalog of used equipment</h1>
				</div>
			</div>
			<div class="col-md-4">
				<div class="block">
					<img src="${baseUrlImg}/img2.png">
					<h1>Create a model of the power distribution network</h1>
				</div>
			</div>
			<div class="col-md-4">
				<div class="block">
					<img src="${baseUrlImg}/img3.png">
					<h1>One click and get the calculated parameters</h1>
				</div>
			</div>
		</div>
	</div>
</div>