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
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>添加App</title>

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
                        <h1 class="page-head-line">添加新文章 </h1>
                    </div>
                </div>
                
                 <!-- /. ROW  -->
                  <div class="row">
                    <div class="col-md-12">
                       <form action="#" method="post" role="form" class="form-horizontal">
                           <div class="form-group">
                              <label for="name" class="col-md-1 control-label">名称</label>
                              <div class="col-md-3">
                                 <input type="text" class="form-control" id="name" 
                                    placeholder="请输入名称">
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="typeName" class="col-md-1 control-label">类别</label>
                              <div class="col-md-3">
                                  <select class="form-control" id="typeName">
                                      <option>1</option>
                                      <option>2</option>
                                  </select>
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="typeName" class="col-md-1 control-label">标签</label>
                              <div style="height: 150px" class="col-md-9 pre-scrollable">
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                                  <input type="checkbox" name="" />1
                                  <input type="checkbox" name="" />2
                                  <input type="checkbox" name="" />3
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="downLink" class="col-md-1 control-label">下载链接</label>
                              <div class="col-md-5">
                                 <input type="text" class="form-control" id="downLink" 
                                    placeholder="请输入链接">
                              </div>
                           </div>
                           <div class="form-group">
                                <label class="control-label col-lg-1">图标</label>
                                <div class="col-lg-5">
                                    <div class="fileupload fileupload-new" data-provides="fileupload">
                                        <div class="fileupload-new thumbnail" style="width: 150px; height: 100px;"><img src="assets/img/demoUpload.jpg" alt="" /></div>
                                        <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 150px; max-height: 100px; line-height: 20px;"></div>
                                        <div>
                                            <span class="btn btn-file btn-primary"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input type="file"></span>
                                            <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">Remove</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">滚动图</label>
                                <div class="col-lg-11 ">
                                    <input id="input-dim-2" name="inputdim2[]" type="file" multiple class="file-loading" accept="image/*">
                                </div>
                                <script type="text/javascript"> 
                                  $('#input-dim-2').parent().css('width','80%');
                                </script>
                            </div>
                           <div class="form-group">
                              <label for="introduce" class="col-md-1 control-label">介绍</label>
                              <div class="col-md-10">
                                 <div id="summernote"></div>
                                 <script>
                                  $(document).ready(function() {
                                      $('#summernote').summernote({
                                          height: 300,                 // set editor height
                                        });
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
  $("#input-dim-2").fileinput({
      uploadUrl: "/file-upload-batch/2",
      allowedFileExtensions: ["jpg", "png"],
      maxFileSize: 1000,
      minImageWidth: 500,
      minImageHeight: 200,
      maxFileCount:3
  });
</script>
</html>