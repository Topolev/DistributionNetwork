
<!-- Nav tabs -->
<ul class="nav nav-tabs" id="main-tabs">
	<li><a href="#catalog">Catalog of equipments</a></li>
	<li><a href="#network">Settings if network</a></li>
	<li><a href="#results">Resulys of calculate</a></li>
</ul>

<!-- Tab panes -->
<div id="list-main-tabs">
	<!--Каталог оборудования-->
	<div class="tab displayTable" id="catalog">
		<div class="displayTableRow">
			<div id="catalog-tabs" class="displayTableCell default-tabs">
				<ul>
					<li class="active"><a href="#transformer">Transformer</a></li>
					<li><a href="#VL">Overhead lines</a></li>
					<li><a href="#KL">Cable lines</a></li>
				</ul>
			</div>
			<div id="list-catalog-tabs"
				class="displayTableCell default-list-tabs">
				<div class="tab active" id="transformer">
					<div class="control-panel">
						<a href="#view" class="active" id="viewTransform"><span
							class="glyphicon glyphicon-eye-open"></span></a> <a href="#edit"
							id="editTransform"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="#" id="addTransformer">
							<span class="glyphicon glyphicon-plus"></span> Add transformer
						</a> 
						<a href="#" id="saveTransformer">
							<span class="glyphicon glyphicon-floppy-save"></span> 
							Save
						</a> 
						<a href="#" id="loadTransformer" data-toggle="modal" data-target="#modal-download-catalog">
							<span class="glyphicon glyphicon-import"></span> 
							Download catalog
						</a>
						<a href="#" id="clearTransformer">
							<span class="glyphicon glyphicon-trash"></span>
							Clear table
						</a>
						<!-- Modal window -->
						
						<div class="modal fade" id="modal-download-catalog">
 							<div class="modal-dialog">
    							<div class="modal-content">
      								<div class="modal-header">
        								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
       									 <h4 class="modal-title">Download catalog</h4>
      								</div>
      								<div class="modal-body">
       									<form id="form-download" method="post" action="${pageContext.request.contextPath}/calculate/download" enctype="multipart/form-data">
       										<input type="file" name="file" id="downloadTransformer"/>
       										<button name="submit">Upload</button>
       									</form>
      								</div>
    							</div><!-- /.modal-content -->
  							</div><!-- /.modal-dialog -->
						</div><!-- /.modal -->
						
						<script>
							
						 $("#uploadTransformer").on("change", function(e){
							 e.preventDefault();
							 alert("HERE");
							 $.ajax({
								 url: "${pageContext.request.contextPath}/calculate/download",
								 type: "POST",
								 data: new FormData($("#form-download")[0]),
								 enctype: 'multipart/form-data',
								 processData: false,
								 contentType: false,
								 cache: false,
								 success: function(data){
									 var $sampleRow = $("<tr />");
									 var $listData = [];
									 var i = 0;
									 $th = $("#transformer th").each(function(){
									 	if ($(this).hasClass("input-field")){
											$row = $("<td />",{
														"class" : $(this).attr("class"),
														"data-name" : $(this).attr("data-name"),
														"data-value" : ""
													});
											$row.append("<input></input>");
											$listData[i++] = $(this).attr("data-name");
										}
										if ($(this).hasClass("action-field")){
											$row = $("<td/>",{
														"class" : $(this).attr("class"),
													});
											$row.append('<a href="" class="delete"><span class="glyphicon glyphicon-remove"></span></a>');
										}
										$sampleRow.append($row);
									 });
									
									$("#transformer").show();
									$placeInsert = $("#transformer tbody");
									$placeInsert.html("");
									for (i=0; i<data.table.length; i++){
										var $newRow = $sampleRow.clone();
										for (j=0; j<$listData.length; j++){
											if ($listData[j] in data.table[i]){
												$newRow.find('[data-name="' +$listData[j] +'"]')
												       .attr("data-value",data.table[i][$listData[j]])
												       .find("input").attr("value", data.table[i][$listData[j]]);
											}
										}
										$newRow.appendTo($placeInsert);
									}
									
									
									
									 
									
								 },
								 error: function(){
									 
								 }
							 });
							 alert("after ajax");
							 
						 });
							
							
						</script>
					</div>
					<div class="default-text-table alert alert-warning">
						
						To display the table , you must add at least one 
						power transformer using the button 
						<span class="bold">"Add transformer"</span> 
						or download CSV format file usung the
						button <span class="bold">"Download catalog"</span>.
					</div>
					<table class="table table-bordered" id="transformer">
						<thead>
							<tr>
								<th class="action-field"></th>
								<th class="input-field" data-name="id">id</th>
								<th class="input-field" data-name="type">Type</th>
								<th class="input-field" data-name="s">S<sub>NOM</sub>, kVA</th>
								<th class="input-field" data-name="uVN">U<sub>VN</sub>,kV</th>
								<th class="input-field" data-name="uNN">U<sub>NN</sub>,kV</th>
								<th class="input-field" data-name="uk">u<sub>k</sub>,%</th>
								<th class="input-field" data-name="pHH">P<sub>HH</sub>, W</th>
								<th class="input-field" data-name="pKZ">P<sub>KZ</sub>, W</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div class="tab" id="VL">Воздушные линии</div>
				<div class="tab" id="KL">Кабельные линии</div>
			</div>
		</div>
	</div>
	<!-- end catalog-->

	<div class="tab displayTable" id="network">
		<div class="displayTableRow">
			<div id="network-tabs" class="displayTableCell default-tabs">
				<ul>
					<li class="active"><a href="#nodes">Узлы</a></li>
					<li><a href="#edges">Ветви</a></li>
				</ul>
			</div>
			<div id="list-network-tabs"
				class="displayTableCell  default-list-tabs">
				<div class="tab" id="nodes">Узлы</div>
				<div class="tab" id="edges">Ветви</div>
			</div>
		</div>
	</div>

	<div class="tab" id="results">Результаты расчета</div>
</div>
<div id="test">
</div>


<script>
$(window).resize(function(){
	if ($(window).width()>575){
		$("#header-tabs-menu").css("height","auto").removeClass("collapse").addClass("collapse in");
	}
});
</script>

<script>
	
	
	
	
	/*Create container for switching among tabs*/
	(function($){
	$.fn.tabs = function (options) {
		var opt={
			'tabsContent':'.tabs-content',
		};
		this.each(function(){        
			if (options) { 
				$.extend(opt, options);
			}
			$(opt.tabsContent).children(".tab").hide().first().show();
			var $list = $(this).find("li");
			$list.first().addClass("active");
			$(this).find('a').each(function(){
				$(this).click(function(){
					$(opt.tabsContent).children(".tab").hide();
					$list.removeClass("active");
					$(this).parent("li").addClass("active");
					href = $(this).attr('href');
					$(href).show();
					return false;
				})
			});
			
		});
	};
	})(jQuery);
	
	$("#main-tabs").tabs({'tabsContent':'#list-main-tabs'});
	$("#catalog-tabs").tabs({'tabsContent':'#list-catalog-tabs'});
	$("#network-tabs").tabs({'tabsContent':'#list-network-tabs'});
	
	
	(function($){
		$.fn.controllerTable = function (options) {
			var opt={
				'Edit':'#defaultEdit',
				'View':'#defaultView',
				'ButtonAddRow':'#defaultButtonAddRow',
				'ButtonClearTable':'#defaultButtonClearTable',
				'ButtonDownload' :'defaultButtonTransformer',
			};
			this.each(function(){ 
				if (options) { 
					$.extend(opt, options);
				};
				
				var $table = $(this).find("table");
				var actionTable = function(){
					this.table = $table;
					this.edit = $(opt.Edit);
					this.view = $(opt.View);
					this.mode = 'view';
					this.row = opt.RowForAdd;
					this.buttonAddRow = $(opt.ButtonAddRow); 
					this.buttonClearTable = $(opt.ButtonClearTable);
					this.buttonDownload = $(opt.ButtonDownload);
					this.listData = [];
					
					this.init = function(){
						this.table.hide();
						this.buttonAddRow.hide();
						this.createSampleRow();
					}
					/*CREATE SAMPLE ROW FOR HEADER ROW OF TABLE*/
					this.createSampleRow = function(){
						$th = this.table.find("th");
						$result = $("<tr />");	
						var i = 0;
						var listData = [];
						$th.each(function(){
							if ($(this).hasClass("input-field")){
								$row = $("<td />",{
									"class" : $(this).attr("class"),
									"data-name" : $(this).attr("data-name"),
									"data-value" : ""
								});
								$row.append("<input></input>");
								listData[i++] = $(this).attr("data-name");
							}
							if ($(this).hasClass("action-field")){
								$row = $("<td/>",{
									"class" : $(this).attr("class"),
								});
								$row.append('<a href="" class="delete"><span class="glyphicon glyphicon-remove"></span></a>');
							}
							($result).append($row);
						});
						this.row = $result;	
						this.listData = listData;
					}
					
					/*CHANGE MODE OF VIEW TABLE: Edit mode*/
					this.editMode= function(){
						if (this.mode == 'edit') return false;
						this.table.find('.action-field').show();
						this.buttonAddRow.show();
						this.edit.addClass('active');
						this.view.removeClass('active');
						this.table.toggleClass('view');
						this.table.find('td').each(function(i){
							typeField = $(this).attr('class');
							if (typeField.indexOf('input-field')!= -1){								
								$(this).empty();
								$(this).append('<input></input>');
								$element = $(this).find('input');
								$element.attr({'type':'text','value':$(this).data('value')});
							}
						
							if (typeField.indexOf('select-choose')!= -1){
								var $select = $(this).find('select').show();
								$(this).empty().append($select);
							}
						
							if (typeField.indexOf('action-field')!=-1){
								$(this).empty();
								$(this).append('<a href="" class="delete"><span class="glyphicon glyphicon-remove"></span></a>');
							}
						});
						this.mode = 'edit';
						return false;
					};
					
					/*CHANGE MODE OF EDIT TABLE: View mode*/
					this.viewMode = function(){
						if (this.mode == 'view') return false;
						this.table.find('.action-field').hide();
					
						this.buttonAddRow.hide();
						this.view.addClass('active');
						this.edit.removeClass('active');
						this.table.toggleClass('view');
					
						this.table.find('th.action-field').hide();
					
						this.table.find('tbody').find('tr').each(function(){
							var p = false;
							$(this).find('td').each(function(){
								typeField = $(this).attr('class');
								if (typeField.indexOf('input-field')!=-1){								
									value = $.trim($(this).find('input')[0].value);
									if (value != "") p = true;
									$(this).data('value',value)
									   .empty()
								       .append(value);
								}
								if (typeField.indexOf('select-choose')!= -1){
									var $select = $(this).find('select').hide();
									$(this).append($select.find('option:selected').text());
								}
							});
							if (p == false) {$(this).remove()};
						});
						this.mode = 'view';
						return false;
					};
					
					/*ADD NEW ROW*/				
					this.addRow = function addRow(){
						this.table.show();
						this.row.clone().appendTo(this.table);
						/*this.table.append(this.row);*/
						this.table.find('tr:last td:nth-child(2) input').focus();	
						return false;
					}
					
					/*DELETE ROW*/
					this.deleteRow = function($row){
						$row.remove();
						if (this.table.find('tr').size() == 1){
							this.table.hide();
							this.buttonAddRow.show();
						}
						return false;
					}
					
					/*Clear data of table*/
					this.clearTable = function(){
						this.table.find("tbody").html("");
						this.table.hide();
					}
				}<!--End class actionTable-->
				
				var currentTable = new actionTable();
				
				
				currentTable.init();
				
				currentTable.edit.on('click', function(){
					currentTable.editMode();
					return false
				});
			
				currentTable.view.on('click', function(){
					currentTable.viewMode();
					return false
				});
				
				currentTable.buttonAddRow.on('click', function(){
					currentTable.addRow();
					return false;
				});
				
				currentTable.table.on('click','.delete',function(){
					currentTable.deleteRow($(this).closest('tr'));
					return false;
				});
				
				currentTable.buttonClearTable.on("click", function(){
					currentTable.clearTable();
				});
				
				currentTable.table.on('keydown', 'td:last input', function(event){
					event = event || window.event;
					if (event.keyCode == 9) currentTable.addRow();
					return false;
				});
				
				/*Download transformer from file*/
				currentTable.buttonDownload.on('change', function(e){
					 e.preventDefault();
					 $.ajax({
						 url: "${pageContext.request.contextPath}/calculate/download",
						 type: "POST",
						 data: new FormData(currentTable.buttonDownload.parent('form')[0]),
						 enctype: 'multipart/form-data',
						 processData: false,
						 contentType: false,
						 cache: false,
						 success: function(data){
							$table = currentTable.table;
							$table.show();
							currentTable.editMode();
							$placeInsert = $table.find("tbody");
							$placeInsert.html("");
							for (i=0; i<data.table.length; i++){
								var $newRow = currentTable.row.clone();
								for (j=0; j<currentTable.listData.length; j++){
									if (currentTable.listData[j] in data.table[i]){
										$newRow.find('[data-name="' +currentTable.listData[j] +'"]')
										       .attr("data-value",data.table[i][currentTable.listData[j]])
										       .find("input").attr("value", data.table[i][currentTable.listData[j]]);
									}
								}
								$newRow.appendTo($placeInsert);
							}
						 },
						 error: function(){
							 
						 }
					 });
					 alert(currentTable.table.attr("id"));
				});
			});
		};
	})(jQuery);
	

			
	$("#transformer").controllerTable({
		'Edit':'#editTransform',
		'View':'#viewTransform',
		'ButtonAddRow':'#addTransformer',
		'ButtonClearTable' : '#clearTransformer',
		'ButtonDownload': '#downloadTransformer',
	});
	
	
	
	
	
</script>
