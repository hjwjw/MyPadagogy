<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
HttpSession s = request.getSession();
if(s.getAttribute("user") == null){
	response.sendRedirect("login.jsp");
}
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="Free Bootstrap Themes by 365Bootstrap dot com - Free Responsive Html5 Templates">

	<title>用户中心</title>
  
	<!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
	
	<!-- Owl Carousel Assets -->
  <link href="owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="owl-carousel/owl.theme.css" rel="stylesheet">
	
	<!-- Custom CSS -->
  <link rel="stylesheet" href="css/style.css">
    <!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
  
        <!-- PAGE LEVEL STYLES -->
  <link href="css/bootstrap-fileupload.min.css" rel="stylesheet" />    
	<!-- 多图上传 -->
  <link href="css/fileinput.min.css" rel="stylesheet" />
	<!-- Custom Fonts -->
  <link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Asap:400,700' rel='stylesheet' type='text/css'>
	<!-- search -->
	<link href="css/searchMeme.css" rel="stylesheet" type="text/css" />
  <style type="text/css">
  /* ---------------------------------------------------------------------------- */
  /* ----------------------------------重写Navbar------------------------------------ */
  /* ---------------------------------------------------------------------------- */
  #nav {font-family: Asap;}
  #nav > .navbar-inner {border-left: 0;border-right: 0;border-radius: 0;-webkit-border-radius: 0;-moz-border-radius: 0;-o-border-radius: 0;}
  #nav.affix {position: fixed;top: 0;width: 100%}
  .navbar {background-color: transparent;background: transparent;color: #fff;opacity: 100;border: 0px;border-radius: 0px;z-index:9999;}
  .navbar-default {background-color: #29282E;}
  .navbar-default .navbar-brand {color: #fff;font-weight: 700;}
  .navbar-default .navbar-nav > li > a {color: #fff;font-weight: 300;}
  .dropdown-menu > li > a {font-weight: bold;}
  .navbar-default .navbar-nav > li > a:hover, .navbar-default .navbar-brand:hover {color: #CEE3F6;}
  .navbar-default .navbar-toggle {background-color: #00D096;border: 0px;}
  .navbar-default .navbar-toggle .icon-bar {background-color: #ffffff;}
  .open {color: #fff;}
  .navbar-default .navbar-nav .open .dropdown-menu>li>a,.navbar-default .navbar-nav .open .dropdown-menu {background-color: #FBFBFB;color:#000;}

  /* AUTO DROPDOWN FIX  ******************************************* */
  @media (min-width:769px) {
    .dropdown:hover .dropdown-menu {
      display: block;
    }
  }

  </style>

  <!-- jQuery -->
  <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- PAGE LEVEL SCRIPTS -->
  <script src="js/bootstrap-fileupload.js"></script>
    <!-- METISMENU SCRIPTS -->
  <script src="js/jquery.metisMenu.js"></script>  
  <!-- search -->
  <script src="js/jquery.searchMeme.js" type="text/javascript"></script>
  <!-- 多图上传 -->
    <script src="js/fileinput.min.js"></script>
    <!-- summernote编辑器 -->
    <link href="assets/summernote.css" rel="stylesheet" />
    <script src="assets/summernote.js"></script> 
    <!-- summernote编辑器 -->
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
<div id="page-content" class="index-page container">
		<div class="row">
			<div class="col-md-3">
				<ul class="list-group ">
					<li class="list-group-item  "><a href="user.jsp">我的信息</a></li>
				   <li class="list-group-item active"><a href="appItem/userToAdd">申请新增APP</a></li>
				   <!-- <li class="list-group-item"><a href="#">留言</a></li> -->
				</ul>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i>申请新增APP</i>
					</div>
					<div class="panel-body">
             <form action="appItem/userAdd" method="post" role="form" class="form-horizontal" Enctype="multipart/form-data">
               <div class="form-group">
                  <label for="name" class="col-md-1 control-label">名称</label>
                  <div class="col-md-3">
                     <input type="text" class="form-control" id="name" 
                        placeholder="请输入名称" name="name">
                  </div>
               </div>
               <div class="form-group">
					<label for="typeName" class="col-md-1 control-label">类别</label>
					<div class="col-md-2" id="lev1Div">
						<select class="form-control" id="typeLev1"
							onchange="getType(1)">
							<c:forEach items="${rootTypeList}" var="r">
								<option value="${r.typeId }">${r.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-2" id="lev2Div">
						<select class="form-control" id="typeLev2"
							onchange="getType(2)">
						</select>
					</div>
					<div class="col-md-2" id="lev3Div">
						<select class="form-control" id="typeLev3"
							onchange="getType(3)">
						</select>
					</div>
					<div class="col-md-2" id="lev4Div">
						<select class="form-control" id="typeLev4"
							onchange="getType(4)">
						</select>
					</div>
					<div class="col-md-1">
						<button type="button" class="btn btn-primary"
							onclick="addType()">加入分类</button>
					</div>
				</div>
				<div class="form-group" id="tyleListDIV">
					<label for="tyleList" class="col-md-1 control-label"></label>
					<div class="col-md-6">
						<ol id="tyleList"></ol>
					</div>
				</div>
               <div class="form-group">
                  <label for="typeName" class="col-md-1 control-label">标签</label>
                  <div style="height: 150px" class="col-md-9 pre-scrollable">
					<c:forEach items="${keywordList}" var="keyword">
						<input type="checkbox" name="keyId[]"
							value="${keyword.keyId }" />${keyword.name }
                   </c:forEach>
				  </div>
               </div>
               <div class="form-group">
                  <label for="downLink" class="col-md-1 control-label">下载链接</label>
                  <div class="col-md-5">
                     <input type="text" class="form-control" id="downLink" 
                        placeholder="请输入链接" name="downLink">
                  </div>
               </div>
               <div class="form-group">
                    <label class="control-label col-lg-1">图标</label>
                    <div class="col-lg-5">
                        <div class="fileupload fileupload-new" data-provides="fileupload">
                            <div class="fileupload-new thumbnail" style="width: 150px; height: 100px;"><img src="images/demoUpload.jpg" alt="" /></div>
                            <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 150px; max-height: 100px; line-height: 20px;"></div>
                            <div>
                                <span class="btn btn-file btn-primary"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input name="iconPic" id="iconPic" type="file"></span>
                                <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">Remove</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-1 control-label">滚动图</label>
                    <div class="col-lg-11 ">
						<input id="input-dim-2" name="focusPic" type="file" multiple
							class="file-loading" accept="image/*"> <input
							type="hidden" name="img1" id="img1"> <input
							type="hidden" name="img2" id="img2"> <input
							type="hidden" name="img3" id="img3">
					</div>
                    <script type="text/javascript">
						$('#input-dim-2').parent().css('width',
								'80%');
					</script>
                </div>
               <div class="form-group">
                  <label for="introduce" class="col-md-1 control-label">介绍</label>
                  <div class="col-md-11">
                    <textarea id="summernote" name="introduce"></textarea>
                     <script>
                      $(document).ready(function() {
                          $('#summernote').summernote({
                              height: 300,                 // set editor height
                              lang : 'zh-CN', // set editor height
							  callbacks : {
									onImageUpload : function(
											files,
											editor,
											$editable) {
										sendFile(
												files[0],
												editor,
												$editable);
									}
								}
                            });
                          $(".note-codable")
							.attr(
									"name",
									"introduce");
                      });
                    </script>
                  </div>
               </div>
               <div class="form-group">
                  <label for="submit" class="col-md-1 control-label"></label>
                  <div class="col-md-2">
                     <input type="submit" class="form-control btn btn-success" id="submit" value="提交">
                  </div>
               </div>
           </form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp" />
	<script type="text/babel" src="js/head.js"></script>
<script type="text/javascript">
	function getType(levNum) {
		/* alert("lev"+levNum+"change"); */
		$.ajax({
			url : "appItem/typeList",
			type : "GET",
			dataType : "json",
			data : {
				parentId : $('#typeLev' + levNum + ' :selected').val()
			},
			async : true,
			error : function(data) {
				console.info("error");
				console.info(data);
			},
			success : function(data) {
				console.info("success");
				console.info(data);
				$("#typeLev" + (levNum + 1)).empty();
				for (var i = 0; i < data.length; i++) {
					$("#typeLev" + (levNum + 1)).append(
							"<option value=" + data[i].typeId + ">"
									+ data[i].name + "</option>");
				}
				console.log("levnum:");
				console.log(levNum);
				if (levNum < 4) {
					getType(levNum + 1);
				}

			}
		});
	}
	/*
	添加分类到下面的列表中
	 */
	function addType() {
		var n = 0;
		var str = "";
		if ($("#typeLev1 :selected").text() != "") {
			str = $("#typeLev1 :selected").text();
			n = 1;
		}
		if ($("#typeLev2 :selected").text() != "") {
			str = str + ">>" + $("#typeLev2 :selected").text();
			n = 2;
		}
		if ($("#typeLev3 :selected").text() != "") {
			str = str + ">>" + $("#typeLev3 :selected").text();
			n = 3;
		}
		if ($("#typeLev4 :selected").text() != "") {
			str = str + ">>" + $("#typeLev4 :selected").text();
			n = 4;
		}
		$("#tyleListDIV").append(
				"<input type='hidden' value='"
						+ $('#typeLev' + n + ' :selected').val()
						+ "' name='typeSelect' id='intputLev" + n + "' />");
		$("#tyleList")
				.append(
						"<li  id='liLev"+n+"'>"
								+ str
								+ "	<button type='button' class='btn-sm btn-danger' onclick='delType("
								+ n + ")'>删除</button></li>");
	}

	function delType(n) {
		$('#intputLev' + n).remove();
		$('#liLev' + n).remove();
	}
</script>
<script type="text/javascript">
	function sendFile(files, editor, $editable) {
		var filename = false;
		try {
			filename = file['name'];
		} catch (e) {
			filename = false;
		}
		if (!filename) {
			$(".note-alarm").remove();
		}
		//以上防止图片在编辑器内拖动引发第二次上传导致的提示错误
		var data = new FormData();
		data.append("file", files);
		data.append("key", filename);//唯一性参数

		$.ajax({
			data : data,
			type : "POST",
			url : "appItem/uploadFileEdit", //图片上传出来的url，返回的是图片上传后的路径，http格式  
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {//data是返回的hash,key之类的值，key是定义的文件名

				$('#summernote').summernote('insertImage', data);
			},
			error : function() {
				alert("上传失败");
			}
		});
	}
</script>
<script type="text/javascript">
	window.imgNum = 1;
	$("#input-dim-2").fileinput({
		uploadUrl : "appItem/uploadPics",
		allowedFileExtensions : [ "jpg", "png" ],
		maxFileSize : 1000,
		minImageWidth : 300,
		minImageHeight : 200,
		maxFileCount : 3
	}).on("fileuploaded", function(e, data) {
		var res = data.response;

		$("#img" + window.imgNum).attr("value", res.success);
		window.imgNum++;
	});
</script>	
<!-- search -->
	<script type="text/javascript">

        $(document).ready(function () {
        var searchGreen = $('#search-green').searchMeme({ onSearch: function (searchText) {

                setTimeout(function () {

                    searchGreen.searchMeme({ searchComplete: true });

                    $('#search-results').html("You searched for " + searchGreen.val() + "");

                    $('.panel').addClass('go-green').animate({ 'height': 200 }, 500);

                }, 3000);

            }

            , buttonPlacement: 'right', button: 'green'

            });
        });

    </script>
    
</body>
</html>