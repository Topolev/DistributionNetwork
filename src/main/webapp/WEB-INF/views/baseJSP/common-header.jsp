<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources/img" var="baseUrlImg" />
<div class="container">
	<header>
		<div id="wrap-logo">
			<a href="" id="logo"> <img src="${baseUrlImg}/logo.png" /> <span>Distribution</span>
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
						<input placeholder="Search..."> <a href="" class="button"
							id="signin">Sign in</a> <a href="" class="button">Sign up</a>
					</div>
				</li>
			</ul>
			<div>
	</header>
</div>