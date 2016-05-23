
<!-- Nav tabs -->
<ul class="nav nav-tabs" id="main-tabs">
	<li><a href="#catalog">Catalog of equipments</a></li>
	<li><a href="#network">Settings if network</a></li>
	<li><a href="#results">Results of calculate</a></li>
</ul>

<!-- Tab panes -->
<div id="list-main-tabs">
	<!--Каталог оборудования-->
	<div class="tab displayTable" id="catalog">
		<div class="displayTableRow">
			<div id="catalog-tabs" class="displayTableCell default-tabs">
				<ul>
					<li class="active"><a href="#tab-transformer">Transformer</a></li>
					<li><a href="#tab-VL">Overhead lines</a></li>
					<li><a href="#tab-KL">Cable lines</a></li>
				</ul>
			</div>
			<div id="list-catalog-tabs" class="displayTableCell default-list-tabs">
				
				<div class="tab active" id="tab-transformer">
					<div class="control-panel">
						<a href="#view" class="active" id="viewTransform">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a> 
						<a href="#edit" id="editTransform">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="#" id="addTransformer">
							<span class="glyphicon glyphicon-plus"></span> Add transformer
						</a> 
						<a href="#" id="saveTransformer">
							<span class="glyphicon glyphicon-floppy-save"></span> 
							Save
						</a> 
						<a href="#" id="loadTransformer" data-toggle="modal" data-target="#modalDownloadTransformer">
							<span class="glyphicon glyphicon-import"></span> 
							Download catalog
						</a>
						<a href="#" id="clearTransformer">
							<span class="glyphicon glyphicon-trash"></span>
							Clear table
						</a>
						
					</div><!-- end .control-panel -->
					
					
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
								<th class="input-field id" data-name="id">id</th>
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
				</div><!-- end #tab-transformer -->
				
				<div class="tab" id="tab-VL">
					<div class="control-panel">
						<a href="#view" class="active" id="viewVL">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a> 
						<a href="#edit" id="editVL">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="#" id="addVL">
							<span class="glyphicon glyphicon-plus"></span> Add overhead line
						</a> 
						<a href="#" id="saveVL">
							<span class="glyphicon glyphicon-floppy-save"></span> 
							Save
						</a> 
						<a href="#" id="loadVL" data-toggle="modal" data-target="#modalDownloadVL">
							<span class="glyphicon glyphicon-import"></span> 
							Download catalog
						</a>
						<a href="#" id="clearVL">
							<span class="glyphicon glyphicon-trash"></span>
							Clear table
						</a>
					</div><!-- end .control-panel -->
					<table class="table table-bordered" id="VL">
						<thead>
							<tr>
								<th class="action-field"></th>
								<th class="input-field id" data-name="id">id</th>
								<th class="input-field" data-name="type">Type</th>
								<th class="input-field" data-name="s">s, mm<sup>2</sup></th>
								<th class="input-field" data-name="u">U,kV</th>
								<th class="input-field" data-name="r0">r<sub>0</sub> ,Om/km</th>
								<th class="input-field" data-name="x0">x<sub>0</sub> ,Om/km</th>
								<th class="input-field" data-name="i">I<sub>max</sub>, A</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div><!-- end #tab-VL -->
				
				<div class="tab" id="tab-KL">
					<div class="control-panel">
						<a href="#view" class="active" id="viewKL">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a> 
						<a href="#edit" id="editKL">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="#" id="addKL">
							<span class="glyphicon glyphicon-plus"></span> Add cabel line
						</a> 
						<a href="#" id="saveKL">
							<span class="glyphicon glyphicon-floppy-save"></span> 
							Save
						</a> 
						<a href="#" id="loadKL" data-toggle="modal" data-target="#modalDownloadKL">
							<span class="glyphicon glyphicon-import"></span> 
							Download catalog
						</a>
						<a href="#" id="clearKL">
							<span class="glyphicon glyphicon-trash"></span>
							Clear table
						</a>
					</div><!-- end .control-panel -->
					<table class="table table-bordered" id="KL">
						<thead>
							<tr>
								<th class="action-field"></th>
								<th class="input-field id" data-name="id">id</th>
								<th class="input-field" data-name="type">Type</th>
								<th class="input-field" data-name="s">s, mm<sup>2</sup></th>
								<th class="input-field" data-name="u">U,kV</th>
								<th class="input-field" data-name="r0">r<sub>0</sub> ,Om/km</th>
								<th class="input-field" data-name="x0">x<sub>0</sub> ,Om/km</th>
								<th class="input-field" data-name="i">I<sub>max</sub>, A</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div><!-- end #tab-KL -->
			</div><!-- end #list-catalo-tabs -->
		</div>
	</div><!-- end catalog-->
	
	<!-- Modal window for download Transformer-->
	<div class="modal fade" id="modalDownloadTransformer">
 		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
       				<h4 class="modal-title">Download catalog</h4>
      			</div>
      			<div class="modal-body">
      				<div class="alert alert-warning">
      					Download text file with the following format:
      					<div class="example-file">
      						Transformer</br>
      						type;s;uVN;uNN;pHH;pKZ;uk</br>
      						TMG-100;100;10;0.4;100;600;4.5
      					</div>
      					The first row unchanged. Each following
      					rows set the parameters of power transformer.
      					The sequence of the parameters must comply
      					with according the sequence in the first row.
      					There is parameters of one power transformer 
      					for example.  
      				</div>
       				<form  method="post" action="${pageContext.request.contextPath}/calculate/download" enctype="multipart/form-data">
       						<input type="hidden" name="nameClassTable" value="Transformer"/>
       						<input type="file" name="file" id="downloadTransformer"/>
       					<button name="submit">Upload</button>
       				</form>
      			</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!-- Modal window for download Overhead Lines-->
	<div class="modal fade" id="modalDownloadVL">
 		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
       				<h4 class="modal-title">Download catalog</h4>
      			</div>
      			<div class="modal-body">
      				<div class="alert alert-warning">
      					Download text file with the following format:
      					<div class="example-file">
      						OverheadLine</br>
      						type;s;u;r0;x0;i</br>
							AC-25/4.2;25;10;1.15;0.402;135
      					</div>
      					The first row unchanged. Each following
      					rows set the parameters of overhead line wire.
      					The sequence of the parameters must comply
      					with according the sequence in the first row.
      					There is parameters of one wire overhead line 
      					for example.  
      				</div>
       				<form method="post" action="${pageContext.request.contextPath}/calculate/download" enctype="multipart/form-data">
       					<input type="hidden" name="nameClassTable" value="OverheadLine"/>
       					<input type="file" name="file" id="downloadVL"/>
       					<button name="submit">Upload</button>
       				</form>
      			</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!-- Modal window for download Cable Lines-->
	<div class="modal fade" id="modalDownloadKL">
 		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
       				<h4 class="modal-title">Download catalog</h4>
      			</div>
      			<div class="modal-body">
      				<div class="alert alert-warning">
      					Download text file with the following format:
      					<div class="example-file">
      						CableLine</br>
      						type;s;u;r0;x0;i</br>
							AC-25/4.2;25;10;1.15;0.402;135
      					</div>
      					The first row unchanged. Each following
      					rows set the parameters of overhead line wire.
      					The sequence of the parameters must comply
      					with according the sequence in the first row.
      					There is parameters of one wire overhead line 
      					for example.  
      				</div>
       				<form method="post" action="${pageContext.request.contextPath}/calculate/download" enctype="multipart/form-data">
       					<input type="hidden" name="nameClassTable" value="CableLine"/>
       					<input type="file" name="file" id="downloadKL"/>
       					<button name="submit">Upload</button>
       				</form>
      			</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
						
						
	<div class="tab displayTable" id="network">
		<div class="displayTableRow">
			<div id="network-tabs" class="displayTableCell default-tabs">
				<ul>
					<li class="active"><a href="#tab-nodes">Nodes</a></li>
					<li><a href="#tab-edges">Edges</a></li>
				</ul>
			</div>
			<div id="list-network-tabs"
				class="displayTableCell  default-list-tabs">
				<div class="tab" id="tab-nodes">
					<div class="control-panel">
						<a href="#view" class="active" id="viewNodes">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a> 
						<a href="#edit" id="editNodes">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="#" id="addNodes">
							<span class="glyphicon glyphicon-plus"></span> Add node
						</a> 
						<a href="#" id="saveNodes">
							<span class="glyphicon glyphicon-floppy-save"></span> 
							Save
						</a> 
						<a href="#" id="loadNode" data-toggle="modal" data-target="#modalDownloadNodes">
							<span class="glyphicon glyphicon-import"></span> 
							Download catalog
						</a>
						<a href="#" id="clearNodes">
							<span class="glyphicon glyphicon-trash"></span>
							Clear table
						</a>
					</div><!-- end .control-panel -->
					<table class="table table-bordered" id="nodes">
						<thead>
							<tr>
								<th class="action-field"></th>
								<th class="input-field">N node</th>
								<th class="input-field">Type of node</th>
								<th class="input-field">Name of node</th>
								<th class="input-field">U<sub>nom</sub>, kV</th>
								<th class="input-field">P<sub>nom</sub>, kV</th>
								<th class="input-field">Q<sub>nom</sub>, kvar</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					
					
				</div><!-- end #nodes -->
				
				<div class="tab" id="tab-edges">
					<div class="control-panel">
						<a href="#view" class="active" id="viewEdges">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a> 
						<a href="#edit" id="editEdges">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="#" id="addEdges">
							<span class="glyphicon glyphicon-plus"></span> Add edge
						</a> 
						<a href="#" id="saveEdges">
							<span class="glyphicon glyphicon-floppy-save"></span> 
							Save
						</a> 
						<a href="#" id="loadEdge" data-toggle="modal" data-target="#modalDownloadEdges">
							<span class="glyphicon glyphicon-import"></span> 
							Download catalog
						</a>
						<a href="#" id="clearEdges">
							<span class="glyphicon glyphicon-trash"></span>
							Clear table
						</a>
					</div><!-- end .control-panel -->
					<table class="table table-bordered" id="edges">
						<thead>
							<tr>
								<th rowspan=2 class="action-field"></th>
								<th rowspan=2 class="id">id</th>
								<th colspan=2>Edge</th>
								<th rowspan=2>Name of edge</th>
								<th>Transformer:</th>
								<th>type</th>
								<th rowspan=2>ID</th>
								<th>S, kVA</th>
								<th>u<sub>k</sub>, %</th>
								<th>P<sub>HH</sub>, kW</th>
								<th>P<sub>KZ</sub>, kW</th>
							</tr>
							<tr>
								<th>begin</th>
								<th>end</th>
								<th>Overhead,cable:</th>
								<th>mark</th>
								<th>s, mm<sup>2</sup></th>
								<th>L, km</th>
								<th>r<sub>0</sub>, Om/km</th>
								<th>x<sub>0</sub>, Om/km</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="tab" id="results">Результаты расчета</div>
</div>
<div id="hidden-workspace">
	<select id="select-transformer" style="color : red">
		<option>Choose</option>
	</select>
	<select id="select-VL" style="color : red">
		<option>Choose</option>
	</select>
	<select id="select-KL" style="color : red">
		<option>Choose</option>
	</select>
	
	<a href="#" onclick="createSelectCatalogElement('VL')">ATTENTION</a>
	
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
	
	
	/*The manager data of Catalog */
	Catalog = function(){
		/*Create unique identifier for each position of catalog*/
		this.id=0;
		/* Container for entity of catalog
		/* each element of array consists JSON in format 
		/* {"id"              : "<unique_numbe_value>",       //for example: "1"
		/*  "elementType"     : "<string_of_element_type>,    //for example: "transformer","CL","VL"
		/*	"type"            : "<string_of_type_element>",   //for example: "ТМГ-100", "АС-35", "ВВГнг 3x10"
		/*	"<nameProperty1>" : "<valueProperty1>",           //for example: "r0":"0.2", "s":"100", "uk":"5.5"
		/*	......................................
		/*	"<namePropertyN>" : "<valuePropertyN>"}    */
		this.data = [];
		
		/* index of array usesData is id of entity of catalog, the value of array is array rows
		/* edges using this entity, for example usesData[2] = [4,5] this mean that enity catalog with id 1 uses in
		/* row of table of edge with id 4 and 5*/
		this.usesData = [];
		
		/* Insert new entity in catalog if one isn't exist or 
		/* update entity if one exist */
		this.insertEntity = function(element){
			var p = true;
			for (var i in this.data){
				if (this.data[i].id == element.id){
					this.data[i] = element;
					p = false;
				} 
			}
			if (p) this.data.push(element);
		}
		
		/* Delete all entity from container with specified elementType*/
		this.deleteAllEntityByElementType = function(elementType){
			var rez = [];
			for (var i in this.data){
				/*console.log("type:" + this.data[i].elementType)*/
				if (this.data[i].elementType != elementType) {
					/*console.log("condition complete");*/
					rez.push(this.data[i]);
				}
			}
			this.data = rez;
		}
		
		/* Get element in JSON-format by id element*/
		this.getElementById = function(id){
			for (var i in this.data){
				if (this.data[i].id == id) return this.data[i];
			}
			return null;
		}

		this.deleteUsesRowFromUsesData = function(idRow){
			for (var i in this.usesData){
				for(var j in this.usesData[i]){
					if (this.usesData[i][j]==idRow) {
						this.usesData[i].splice(j,1);
					}
				}
			}
		}
		
		this.getIndexArrayByIdEntity = function(id){
			for (var i in this.data){
				if (data[i].id == id) return i;
			}
			return null;
		}
		
		this.updateData = function(){
			
		}
	}
	var catalog = new Catalog();
	

	
	
	
	(function($){
		$.fn.controllerTable = function (options) {
			var opt={
				'NameClassTable':'defaultClassTable',
				'Edit':'#defaultEdit',
				'View':'#defaultView',
				'ButtonAddRow':'#defaultButtonAddRow',
				'ButtonClearTable':'#defaultButtonClearTable',
				'ButtonSave' : '#defaultButtonSave',
				'ButtonDownload' :'defaultButtonTransformer',
				'ModalDownload' : 'defaultModalDownload',
				'CallbackFuncAddRow' : undefined,
				'HandleFuncBeforeDeleteRow' : undefined,
			};
			this.each(function(){ 
				if (options) { 
					$.extend(opt, options);
				};
				
				var $table = $(this);
				var actionTable = function(){
					this.table = $table;
					this.nameClassTable = opt.NameClassTable;
					this.edit = $(opt.Edit);
					this.view = $(opt.View);
					this.mode = 'view';
					this.row = $(opt.RowForAdd);
					this.buttonAddRow = $(opt.ButtonAddRow); 
					this.buttonClearTable = $(opt.ButtonClearTable);
					this.buttonDownload = $(opt.ButtonDownload);
					this.buttonSave = $(opt.ButtonSave);
					this.modalDownload = $(opt.ModalDownload);
					this.callbackFuncAddRow = opt.CallbackFuncAddRow;
					this.handleFuncBeforeDeleteRow = opt.HandleFuncBeforeDeleteRow;
					this.listData = [];
					
					this.init = function(){
						this.table.hide();
						this.buttonAddRow.hide();
						
						if (opt.RowForAdd == undefined){
							this.createSampleRow();
						}
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
						this.changeSelect();
						
						return false;
					};
					
					/*ADD NEW ROW*/				
					this.addRow = function addRow(){
						this.table.show();
						$row = this.row.clone();
						$row.find('.id').attr('data-value',catalog.id++);
						$row.appendTo(this.table);
						/*this.table.append(this.row);*/
						this.table.find('tr:last td:nth-child(2) input').focus();
						if (this.callbackFuncAddRow != undefined) this.callbackFuncAddRow($row);
						return false;
					}
					
					/*DELETE ROW*/
					this.deleteRow = function($row){
						p = true;
						if (opt.HandleFuncBeforeDeleteRow != undefined) p = opt.HandleFuncBeforeDeleteRow($row.find('.id').attr("data-value"));
						if (p){
							$row.remove();
							if (this.table.find('tr').size() == 1){
								this.table.hide();
								this.buttonAddRow.show();
							}
						} else {
							alert("This entity has used")
						}
						return false;
					}
					
					/*Clear data of table*/
					this.clearTable = function(){
						this.table.find("tbody").html("");
						this.table.hide();
					}
					
					/*ADD NEW LINE IN SELECT FOR CHOOSING*/
					this.changeSelect = function(){
						var nameElement = this.table.attr('id');
						$rows = this.table.find('tbody').find('tr');
						$rows.each(function(){
							var array = {};
							$(this).find('td').each(function(){
								if ($(this).attr('data-name') != undefined) {
									array[$(this).attr('data-name')] = $(this).attr('data-value'); }
							});
							array['elementType'] =  nameElement;
							catalog.insertEntity(array);
						});
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
					if (event.keyCode == 9) {
						currentTable.addRow();
						return false;
					}
					
				});
				
				currentTable.table.on('change', function(event){
					var $target = $(event.target);
					if ($target.is('input')) {
						value = $.trim($target[0].value);
						/*alert(value);*/
						$target.parent().attr('data-value',value);
						/*currentTable.changeSelect();*/
					}
				});
				
				/*Download catalog from file*/
				currentTable.buttonDownload.on('change', function(e){
					 e.preventDefault();
					 $(opt.ModalDownload).modal('hide');
					 $.ajax({
						 url: "${pageContext.request.contextPath}/calculate/download",
						 type: "POST",
						 data: new FormData(currentTable.buttonDownload.parent('form')[0]),
						 enctype: 'multipart/form-data',
						 processData: false,
						 contentType: false,
						 cache: false,
						 success: function(data){
							if (data.textError == null){
								$table = currentTable.table;
								$table.show();
								currentTable.editMode();
								$placeInsert = $table.find("tbody");
								$placeInsert.html("");
								
								
								catalog.deleteAllEntityByElementType(currentTable.table.attr("id"));
								
								for (i=0; i<data.table.length; i++){
									data.table[i].id = catalog.id++;
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
							} else{
								 alert("CSVFile Invalid");
							}
						 },
						 error: function(){
							 alert("error");
						 }
					 });
				});
				
				/*SAVE CATALOG*/
				currentTable.buttonSave.on('click', function(e){
					e.preventDefault();
					alert("save")
					var data = '{"nameClass":"'+currentTable.nameClassTable + '","table":[';
					currentTable.table.find('tbody tr').each(function(i){
						var row = {};
						$(this).find("td").each(function(){
							var $cell = $(this);
							if ($cell.attr('data-name') !=  undefined){
								row[$cell.attr('data-name')] = $cell.attr('data-value');
							};
						});
						if (i==0) data = data + JSON.stringify(row);
						else data = data + ',' + JSON.stringify(row);	
					})
					data = data + "]}";
					alert(data);
					$.ajax({
						 url: "${pageContext.request.contextPath}/calculate/save",
						 type: "POST",
						 data: data,
						 contentType: "application/json; charset=utf-8",
						 success: function(data){
							window.location.href = '${pageContext.request.contextPath}/calculate/save/' + data;
							/*window.open('${pageContext.request.contextPath}/calculate/save/' + data);*/
						 },
						 error: function(){
							 alert("error");
						 }
					 });
					
					
					
				});
				
			});
		};
	})(jQuery);
	

			
	$("#transformer").controllerTable({
		'NameClassTable':'Transformer',
		'Edit':'#editTransform',
		'View':'#viewTransform',
		'ButtonAddRow':'#addTransformer',
		'ButtonClearTable' : '#clearTransformer',
		'ButtonDownload': '#downloadTransformer',
		'ButtonSave' : '#saveTransformer',
		'ModalDownload':'#modalDownloadTransformer',
		'HandleFuncBeforeDeleteRow' : deleteElementCatalog,
	});
	
	$("#VL").controllerTable({
		'NameClassTable':'OverheadLine',
		'Edit':'#editVL',
		'View':'#viewVL',
		'ButtonAddRow':'#addVL',
		'ButtonClearTable' : '#clearVL',
		'ButtonDownload': '#downloadVL',
		'ButtonSave' : '#saveVL',
		'ModalDownload':'#modalDownloadVL',
		'HandleFuncBeforeDeleteRow' : deleteElementCatalog,
	});
	
	$("#KL").controllerTable({
		'NameClassTable':'CableLine',
		'Edit':'#editKL',
		'View':'#viewKL',
		'ButtonAddRow':'#addKL',
		'ButtonClearTable' : '#clearKL',
		'ButtonDownload': '#downloadKL',
		'ButtonSave' : '#saveKL',
		'ModalDownload':'#modalDownloadKL',
		'HandleFuncBeforeDeleteRow' : deleteElementCatalog,
	});
	
	function deleteElementCatalog(idElementCatalog){
		if (catalog.usesData[idElementCatalog] == undefined || catalog.usesData[idElementCatalog].length == 0){
			for (var i in catalog.data){
				if (catalog.data[i].id == idElementCatalog) {
					catalog.data.splice(i,1);
					break;
				}
			}
			console.log(catalog.data);
			return true;
		} else{
			return false;
		}
	}
	
	function deleteRowEdge(idElementCatalog){
		
	}
	
	sampleRowForTableEdges = 
			'<tr>'+
				'<td class="action-field"><a href="" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>'+
				'<td class="input-field id" data-name="id" data-value=""><input></input></td>'+
				'<td class="input-field" data-name="begin" data-value=""><input></input></td>'+
				'<td class="input-field" data-name="end" data-value=""><input></input></td>'+
				'<td class="input-field" data-name="name" data-value=""><input></input></td>'+
				'<td class="select-choose" data-name="element" data-value="">'+
					'<select class="choose-element">'+
						'<option value="">Choose</option>'+
						'<option value="transformer">Transformer</option>'+
						'<option value="VL">Overhead line</option>'+
						'<option value="KL">Cable line</option>'+
					'</select>'+
				'</td>'+
				'<td class="select-choose" data-name="id" data-value=""></td>'+
				'<td class="input-field property" data-property-transformer="id" data-property-VL="id data-property-KL="id" '+
					'data-value=""><input></input></td>'+
				'<td class="input-field property" data-property-transformer="s" data-property-VL="s" data-property-KL="s" '+
					'data-value=""><input></input></td>'+
				'<td class="input-field property" data-property-transformer="uk" data-property-VL="L" data-property-KL="L"'+
					' data-value=""><input></input></td>'+
				'<td class="input-field property" data-property-transformer="pHH" data-property-VL="r0" data-property-KL="r0"'+
					' data-value=""><input></input></td>'+
				'<td class="input-field property" data-property-transformer="pKZ" data-property-VL="x0" data-property-KL="x0"'+
					' data-value=""><input></input></td>'+
			'</tr>';
			
	$("#edges").controllerTable({
		'Edit':'#editEdges',
		'View':'#viewEdges',
		'ButtonAddRow':'#addEdges',
		'ButtonClearTable' : '#clearEdges',
		'ButtonDownload': '#downloadEdges',
		'ModalDownload':'#modalDownloadEdges',
		'RowForAdd':sampleRowForTableEdges, 
		'CallbackFuncAddRow' : addRowEdge,
	});
	
	
	
	
	function addRowEdge($row){
		var idRow = $row.find(".id").attr("data-value");
	}
	
	
	
	function createSelectCatalogElement(elementType,$placeToInsertSelect){
		var $options = $('<select/>',{"class" : "currentElement"});
		$options.append($("<option/>",{text  : 'Custom',
									   value : 'custom'}));
		for (var i in catalog.data){
			if (!catalog.data.hasOwnProperty(i)) continue;
			if (catalog.data[i].elementType == elementType) {
				$result = $("<option/>",{
								text  : catalog.data[i].type,
								value : catalog.data[i].id,
				});
				$result.appendTo($options); 
			}
		}
		$options.appendTo($placeToInsertSelect)
	}
	
	
	$("#edges").on("change", function(e){
		alert("changeEdges");
		$target = $(e.target);
		if( $target.is("select.choose-element")){
			chooseElementType = $target.find('option:selected').val();
			$placeToInsert = $target.parent().next().html("");
			createSelectCatalogElement(chooseElementType,$placeToInsert);
			$elementsProperty = $target.parent().parent().find('.property').find('input').attr("disabled",false).attr("value","");
		}
		
		if ($target.is('.currentElement')){
			var idElement = $target.find('option:selected').val();
			if (idElement == 'custom'){
				var $targetProperty = $target.parent().parent().find('.property').find("input").attr("disabled",false).attr("value","");
				var idRow = $target.parent().parent().find('.id').attr("data-value");
				catalog.deleteUsesRowFromUsesData(idRow);
				console.log(catalog.usesData);
			} else{
				var entity = catalog.getElementById(idElement);
				alert(entity.id);
				alert(catalog.usesData[entity.id]);
				
				var idRow = $target.parent().parent().find('.id').attr("data-value");
				catalog.deleteUsesRowFromUsesData(idRow);
				if (catalog.usesData[entity.id] == undefined) catalog.usesData[entity.id] = [];
				catalog.usesData[entity.id].push(idRow);
				
				console.log(catalog.usesData);
				var $targetProperty = $target.parent().parent().find('.property');
				$targetProperty.each(function(e){
					var nameParametr = $(this).attr("data-property-" + entity.elementType);
					if (nameParametr in entity){
						$(this).attr("data-value",entity[nameParametr]).find('input').attr("value",entity[nameParametr]).attr("disabled",true);
					}
					console.log("data-property-" + entity.elementType);
				});
			}
		}
	})
	
	sampleRowForTableNodes = 
		'<tr>'+
			'<td class="action-field"><a href="" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>'+
			'<td class="input-field" data-name="n" data-value=""><input></input></td>'+
			'<td class="select-choose">'+
				'<select name="typeNode">'+
					'<option>Load</option>'+
					'<option>Bus</option>'+
				'</select>'+
			'</td>'+
			'<td class="input-field" data-name="u" data-value=""><input></input></td>'+
			'<td class="input-field" data-name="p" data-value=""><input></input></td>'+
			'<td class="input-field" data-name="q" data-value=""><input></input></td>'+
		'</tr>';
		$("#nodes").controllerTable({
		'Edit':'#editNodes',
		'View':'#viewNodes',
		'ButtonAddRow':'#addNodes',
		'ButtonClearTable' : '#clearNodes',
		'ButtonDownload': '#downloadNodes',
		'ModalDownload':'#modalDownloadNodes',
		'RowForAdd':sampleRowForTableNodes, 
	});
	
	
	
	
</script>
