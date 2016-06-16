<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="home" value="/"/>
<div class="row">
	<div class="col-md-7">
		<p id="header">Editing your profile</p>

			
		<form:form modelAttribute="profileForm" action="${home}user/profileUpdate" method="POST">
			<div class="form-group" id="image-profile">
				<form:hidden path="urlAvatar" id="fileAvatar"/>
				<label class="control-label">Profile picture</label> 
					
					<img src="${home}user/photo?fileName=${profileForm.getUrlAvatar()}" id="profile-photo" />
				<div id="wrap-image-btn">
					<div class="file-upload">
						<input type="file" name=""/>
						<button type="button" class="button-without-color">Upload new picture</button>
					</div>
					<span class="default-text">We promise not to share your email with anyone</span>
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="firstname" cssClass="control-label">First Name</form:label>
				<div class="input-field">
					<form:input path="firstname" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="lastname">Lastname</form:label>
				<div class="input-field">
					<form:input path="lastname" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="nameOrganization">Organization name</form:label>
				<div class="input-field">
					<form:input path="nameOrganization" cssClass="form-control"/> 
				</div>
			</div>

			<div class="form-group">
				<form:button id="button-profile" css="btn">Update profile</form:button>
			</div>
		</form:form>
	</div>
	<div class="col-md-5"></div>
</div>
<!--end div.row-->

<div class="modal fade bs-example-modal-sm" id="modal-upload">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Crop your new profile picture</h4>
      </div>
      <div class="modal-body" id="insert-image">
        	<img src="" id="crop-image">
      </div>
      <div class="modal-footer">
      <form action="${home}user/cropPhoto">
         <input type="hidden" name="fileName" id="fileName">
        <button type="button" class="btn btn-primary" id="btn-crop-image">Save image</button>
      </form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




 
 <script type="text/javascript" src="${home}resources/js/jquery.imgareaselect.min.js"></script>
 <link rel="stylesheet" type="text/css" href="${home}resources/css/imgareaselect-default.css" />
<script>
var imgCrop;
$('input[type=file]').change(function(e){
	e.preventDefault();
	formData = new FormData();
	formData.append("file", this.files[0])
	$.ajax({
		url: '${home}user/uploadPhoto', 
	  	type: 'POST',
	  	processData: false, 
		contentType: false, 
		cache: false,
		data: formData,
		success: function(name){
	        $("#crop-image").remove();
	        $("<img />",{"src": "${home}user/photo?fileName="+ name,
	        			 "id" : "crop-image"})
	        			 .appendTo("#insert-image");
	        $("#fileName").val(name);
	        $("#modal-upload").modal("toggle");
	 		$('#modal-upload').on('shown.bs.modal', function (e) {
	 			var $img = $("#crop-image");
	 			imgCrop = $img.imgAreaSelect({
	 				handles: true,
	 				onInit: initCrop,
	 				aspectRatio:"1:1",
	 				instance: true,
	 			});
	 		})
	 		$('#modal-upload').on('hide.bs.modal', function (e) {
	 			imgCrop.cancelSelection();
	 		});
	 	},
	    error: function(e){
	       alert("Sorry uploaded file is valid.")
	    }
	});	
});


$("#btn-crop-image").on("click", function(e){
	e.preventDefault();
	alert("asd");
	var selection = imgCrop.getSelection();
	 $.get(
		'${home}user/cropPhoto',
		{
		  x1 : selection.x1,
		  y1 : selection.y1,
		  widthScaleImg : $("#crop-image").width(),
		  width : selection.width,
		  height : selection.height,
		  fileName : $('#fileName').val()
		},
		function(data){
			$("#profile-photo").attr("src", "${home}user/photo?fileName="+ data);
			$("#modal-upload").modal("toggle");
			$("#fileAvatar").val(data);
		}
	);
});

function initCrop(img, selection){
	var width = $(img).width();
	var height = $(img).height();
	console.log(width + " "+height )
	var selection;
	var x1;
	var y1;
	if (width > height){
		selection = height;
		y1 = 0;
		x1 = (width - selection)/2; 
	} else{
		selection = width;
		x1 = 0;
		y1 = (height - selection)/2;
	}
	imgCrop.setOptions({ 
		show: true, 
		x1: x1, 
		y1: y1, 
		x2: x1+selection, 
		y2: y1+selection, 
		});
}//End function initCrop()



</script>