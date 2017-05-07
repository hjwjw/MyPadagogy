<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改App</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- PAGE LEVEL STYLES -->
    <link href="assets/css/bootstrap-fileupload.min.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
    <!-- 多图上传 -->
     <link href="assets/css/fileinput.min.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.js"></script>
    <!-- PAGE LEVEL SCRIPTS -->
    <script src="assets/js/bootstrap-fileupload.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script> 
    <!-- 多图上传 -->
    <script src="assets/js/fileinput.min.js"></script>
    <!-- summernote编辑器 -->
    <link href="assets/summernote.css" rel="stylesheet" />
    <script src="assets/summernote.js"></script> 
    <!-- summernote编辑器 -->
</head>
<body>
    <div id="wrapper">
        <!-- /. NAV TOP  -->
	<jsp:include page="leftTopMenu.jsp"/>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">修改文章 </h1>
                    </div>
                </div>
                
                 <!-- /. ROW  -->
                  <div class="row">
                    <div class="col-md-12">
                       <form action="appItem/update/" method="post" role="form" class="form-horizontal" Enctype="multipart/form-data">
                           <div class="form-group">
                              <label for="name" class="col-md-1 control-label">名称</label>
                              <div class="col-md-3">
                                 <input type="text" class="form-control" id="name" 
                                    placeholder="请输入名称" name="name" value="${appItem.name}">
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="typeName" class="col-md-1 control-label">类别</label>
                              <div class="col-md-3">
                                <select class="form-control" id="typeSelect" name="typeSelect"></select> 
                                  
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="typeName" class="col-md-1 control-label">标签</label>
                              <div style="height: 150px" class="col-md-9 pre-scrollable">
                                  <c:forEach items="${keywordList}" var="keyword">
                                  	<input type="checkbox" name="keyId[]" value="${keyword.keyId }" />${keyword.name }
                                  </c:forEach>
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="downLink" class="col-md-1 control-label">下载链接</label>
                              <div class="col-md-5">
                                 <input type="text" class="form-control" id="downLink" name="downLink"
                                    placeholder="请输入链接" value="${appItem.downLink}">
                              </div>
                           </div>
                           <div class="form-group">
                                <label class="control-label col-lg-1">图标</label>
                                <div class="col-lg-5">
                                    <div class="fileupload fileupload-new" data-provides="fileupload">
                                        <div class="fileupload-new thumbnail" style="width: 150px; height: 100px;"><img src="assets/img/demoUpload.jpg" alt="" /></div>
                                        <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 150px; max-height: 100px; line-height: 20px;"></div>
                                        <div>
                                            <span class="btn btn-file btn-primary"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input type="file" name="iconPic" id="iconPic" value="${appItem.logo}"></span>
                                            <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">Remove</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">滚动图</label>
                                <div class="col-lg-11 ">
                                    <input id="input-dim-2" name="focusPic" type="file" multiple class="file-loading" accept="image/*">
                                    <input type="hidden" name="img1" id="img1">
                                    <input type="hidden" name="img2" id="img2">
                                    <input type="hidden" name="img3" id="img3">
                                </div>
                                <script type="text/javascript"> 
                                  $('#input-dim-2').parent().css('width','80%');
                                  
                                </script>
                            </div>
                           <div class="form-group">
                              <label for="introduce" class="col-md-1 control-label">介绍</label>
                              <div class="col-md-10">
                                 <textarea id="summernote" name="introduce">${appItem.introduce}</textarea>
                                 <script>
                                  $(document).ready(function() {
                                	  
                                      $('#summernote').summernote({
                                          height: '300',
                                          lang:'zh-CN' ,                // set editor height
                                       	  callbacks: {  
                                                 onImageUpload: function(files, editor, $editable) {  
                                                     sendFile(files[0],editor,$editable);  
                                                 }  
                                             } 
                                        });

                                      $(".note-codable").attr("name","introduce");
                                  });
                                </script>
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="submit" class="col-md-1 control-label"></label>
                              <div class="col-md-2">
                                 <input type="submit" class="form-control btn btn-success" id="submit" >
                              </div>
                           </div>
                       </form>
                    </div>
                </div>
                 <!-- /. ROW  -->
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
	<jsp:include page="footer.jsp" />
    <!-- /. FOOTER  -->

</body>
<script type="text/javascript"> 

	var data =new Array();
  /* EL表达式与JS相结合 */
  <c:set var="index" value="0" /> 
  <c:forEach items="${typeList}" var="type" >
	//js中可以使用此标签，将EL表达式中的值push到数组中  
	data['${index}'] = {id:'${type.typeId}',pid:'${type.parentId}',text:'${type.name}'}; 
	<c:set var="index" value="${index+1}" />
  </c:forEach>
	
	function TreeSelector(item,data,rootId){ 
	this._data = data; 
	this._item = item; 
	this._rootId = rootId; 
	} 
	TreeSelector.prototype.createTree = function(){ 
	var len =this._data.length; 
	for( var i= 0;i<len;i++){ 
	if ( this._data[i].pid == this._rootId){ 
	this._item.options.add(new Option(".."+this._data[i].text,this._data[i].id)); 
	for(var j=0;j<len;j++){ 
	this.createSubOption(len,this._data[i],this._data[j]); 
	} 
	} 
	} 
	} 
	TreeSelector.prototype.createSubOption = function(len,current,next){ 
	var blank = ".."; 
	if ( next.pid == current.id){ 
	intLevel =0; 
	var intlvl =this.getLevel(this._data,this._rootId,current); 
	for(a=0;a<intlvl;a++) 
	blank += ".."; 
	blank += "├-"; 
	this._item.options.add(new Option(blank + next.text,next.id)); 
	for(var j=0;j<len;j++){ 
	this.createSubOption(len,next,this._data[j]); 
	} 
	} 
	} 
	TreeSelector.prototype.getLevel = function(datasources,topId,currentitem){ 
	var pid =currentitem.pid; 
	if( pid !=topId) 
	{ 
	for(var i =0 ;i<datasources.length;i++) 
	{ 
	if( datasources[i].id == pid) 
	{ 
	intLevel ++; 
	this.getLevel(datasources,topId,datasources[i]); 
	} 
	} 
	} 
	return intLevel; 
	} 
	
	var ts = new TreeSelector(document.getElementById("typeSelect"),data,0); 
	ts.createTree(); 
	
</script> 
<script type="text/javascript">

function sendFile(files, editor, $editable) {  
	var filename =false;
	try{
		filename = file['name'];
	}catch(e){
		filename = false;
	}
	if(!filename){
		$(".note-alarm").remove();
	}
	//以上防止图片在编辑器内拖动引发第二次上传导致的提示错误
    var data = new FormData();  
    data.append("file", files); 
    data.append("key",filename);//唯一性参数
    
    $.ajax({  
        data : data,  
        type : "POST",  
        url : "appItem/uploadFileEdit", //图片上传出来的url，返回的是图片上传后的路径，http格式  
        cache : false,  
        contentType : false,  
        processData : false,         
        success: function(data) {//data是返回的hash,key之类的值，key是定义的文件名
        	
            $('#summernote').summernote('insertImage', data);  
        },  
        error:function(){  
            alert("上传失败");  
        }  
    });  
} 

</script>
<script type="text/javascript">
	window.imgNum = 1;
  $("#input-dim-2").fileinput({
      uploadUrl: "appItem/uploadPics",
      allowedFileExtensions: ["jpg", "png"],
      maxFileSize: 1000,
      minImageWidth: 500,
      minImageHeight: 200,
      maxFileCount:3,
      overwriteInitial: false,
      initialPreviewAsData: true,
      initialPreview: [
        "${appItem.img1}",
        "${appItem.img2}",
     	"${appItem.img3}"
       ],
      initialPreviewConfig: [
          {caption: "nature-1.jpg", size: 329892, width: "120px", url: "${appItem.img1}", key: 1},
          {caption: "nature-2.jpg", size: 872378, width: "120px", url: "${appItem.img2}", key: 2},
          {caption: "nature-3.jpg", size: 632762, width: "120px", url: "${appItem.img3}", key: 3}
      ]
  }).on("fileuploaded", function(e, data) {
      var res = data.response;
      
      $("#img"+window.imgNum).attr("value", res.success);
      window.imgNum ++;
  });
  
</script>
</html>