<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<spring:url value="/resources/img" var="baseUrlImg" />
<spring:url value="/" var="baseUrl" />
<div class="container">
	<header>
		<div id="wrap-logo">
			<a href="${baseUrl}" id="logo"> <img src="${baseUrlImg}/logo.png" /> <span>Distribution</span>
				Networks
			</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#header-tabs-menu">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<div id="header-tabs-menu" class="collapse in">
			<ul class="nav" id="tabs">
				<li><a href="">Support</a></li>
				<li><a href="">About project</a></li>
				<li>
					<div id="form-group">
						<input placeholder="Search...">
						<sec:authorize access="isAuthenticated()">
							<div class="btn-group">
								<a href="" class="button dropdown-toggle" data-toggle="dropdown"
									id="profile"> Profile <span
									class="glyphicon glyphicon-user"></span> <span class="caret"></span>
								</a>
								<spring:url value="j_spring_security_logout" var="urlLogout"/>
								<ul class="dropdown-menu" role="menu" id="menu-profile">
									<li><a href="">Your profile</a></li>
									<li><a href="">Settings</a></li>
									<li class="divider"></li>
									<li><a href="${urlLogout}">Sign Out</a></li>
								</ul>
							</div>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<a href="${baseUrl}signin" class="button" id="signin">Sign in</a>
							<a href="${baseUrl}signup" class="button">Sign up</a>
						</sec:authorize>

					</div>
				</li>
			</ul>
			<div>
	</header>
</div>