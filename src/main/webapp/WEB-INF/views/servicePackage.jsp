<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>We're glad to offer some service packages.</h1>
<p>Get more opportunities to calculate distribution network !</p>
<div class="row">
	<c:forEach items="${servicePackages}" var="servicePackage">
		<div class="col-md-4" >
				<div href="#" 
					class="service <c:if test="${(activeServicePackage == servicePackage.getId())}">active</c:if>"
					idPackage="${servicePackage.getId()}">
				<div class="status-service">
					<span class="glyphicon glyphicon-ok"></span>
				</div>
				<h1 class="name-service">
					<c:out value="${servicePackage.getName()}"/>
				</h1>
				<div class="description-service">
					<c:out value="${servicePackage.getDescription()}"/>
				</div>
				<ul class="list-service">
					<c:forEach items="${servicePackage.getPermitions()}" var="permition">
						<li><c:out value="${permition.getName()}"/></li>
					</c:forEach>
				</ul>
				<div class="wrap-choose-service">
					<a href="" class="choose-service button">Choose package</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<div id="wrap-next-step">
	<form:form action="servicePackages/change" method="GET">
		<input type="hidden" name="idServicePackage" value="${activeServicePackage}" id="hidden-field"/>
		<button id="next-step">
			Next step 
			<span class="glyphicon glyphicon-circle-arrow-right"></span>
		</button>
	</form:form>
</div>


<script>
$(document).ready(function(){
	setEqualHeight()
	
	
	
	$(".service").on("click", function(e){
		e.preventDefault();
		changeService($(this));
	})
	$(".choose-service").on("click", function(){
		e.preventDefault();
		changeService($(this).parents(".servis"));
	})
	
})
function changeService($chooseService){
	$(".service").removeClass("active");
	$chooseService.addClass("active");
	$("#hidden-field").val($chooseService.attr("idPackage"));
	return false;
}
function setEqualHeight(){
	var height = 0;
	$('.service').each(function(){
		if ($(this).height() > height) height = $(this).height();
	});
	$('.service').height(height);
}
$(window).resize(function(){
	setEqualHeight();
	if ($(window).width()>575){
		$("#header-tabs-menu").css("height","auto").removeClass("collapse").addClass("collapse in");
	}
});
</script>