<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><tiles:insertAttribute name="title" ignore="true" /></title>

<spring:url value="/resources/css" var="baseUrlCss" />
<spring:url value="/resources/js" var="baseUrlJS" />

<!-- Bootstrap -->
<link href="${baseUrlCss}/bootstrap.css" rel="stylesheet" />
<link href="${baseUrlCss}/style-commons.css" rel="stylesheet" />
<link href="${baseUrlCss}/<tiles:insertAttribute name="csspage" ignore="true" />" rel="stylesheet" />




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
<!-- 
<link href="${baseUrlJS}/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet">
<script src="${baseUrlJS}/jquery-ui-1.11.4/jquery-ui.min.js"></script> -->

</head>
<body>
	<tiles:insertAttribute name="header" />

	<div class="container" id="wrap">
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div><!-- end content-->
	</div><!-- end wrap-->

	<tiles:insertAttribute name="footer" />
	
</body>
</html>


<script>
	$(window).resize(
			function() {
				if ($(window).width() > 575) {
					$("#header-tabs-menu").css("height", "auto").removeClass(
							"collapse").addClass("collapse in");
				}
			});
</script>

