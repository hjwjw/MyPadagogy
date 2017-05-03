<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>所有类别</title>
<!-- BOOTSTRAP STYLES-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!--CUSTOM BASIC STYLES-->
<link href="assets/css/basic.css" rel="stylesheet" />
<!--CUSTOM MAIN STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- bootstrap 树状结构 -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<link href="css/jquery.bootstrap.css" rel="stylesheet">
<link href="css/prettify.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="css/demo.css" type="text/css"> -->
<link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script> -->
<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="js/jquery.ztree.excheck.min.js"></script>
    <script type="text/javascript" src="js/jquery.ztree.exedit.min.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assets/js/bootstrap.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assets/js/custom.js"></script>
<!--[if lt IE 9]>
	  <script src="js/html5shiv.js"></script>
	  <script src="js/respond.min.js"></script>
	<![endif]-->
    <style type="text/css">
.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
    </style>
</head>
<body>
	<div id="wrapper">
		<!-- /. NAV TOP include  -->
		<jsp:include page="leftTopMenu.jsp" />
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">所有分类</h1>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<ul id="treeDemo" class="ztree"></ul>
					<!--  <div id="folder"></div> -->
				</div>

			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<jsp:include page="footer.jsp" />
	<!-- /. FOOTER  -->
	<!-- 分类的树状结构插件 -->
	<!-- <script src="js/jquery-1.10.2.min.js"></script> -->
	<!-- <script src="js/bootstrap.min.js"></script> -->
	<script src="js/prettify.js"></script>
	<script src="js/jquery.bootstrap.js"></script>
	<script src="js/site.js"></script>

	<SCRIPT type="text/javascript">
		var setting = {
            async: {
                enable: true,
                type:"POST",
                url: "type/insert",
                autoParam: ["id","pId","name"]
            },
			view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            edit: {
                enable: true,
                editNameSelectAll: true,
                showRemoveBtn: showRemoveBtn,
                showRenameBtn: showRenameBtn
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeDrag: beforeDrag,
                beforeEditName: beforeEditName,
                beforeRemove: beforeRemove,
                beforeRename: beforeRename,
                onRemove: onRemove,
                onRename: onRename,
                onNodeCreated: zTreeOnNodeCreated
            }
		};

		var zNodes;

var log, className = "dark";
        function beforeDrag(treeId, treeNodes) {
            return false;
        }
        function beforeEditName(treeId, treeNode) {
            className = (className === "dark" ? "":"dark");
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.selectNode(treeNode);
            setTimeout(function() {
                if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {
                    setTimeout(function() {
                        zTree.editName(treeNode);
                    }, 0);
                }
            }, 0);
            return false;
        }
        function beforeRemove(treeId, treeNode) {
            className = (className === "dark" ? "":"dark");
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.selectNode(treeNode);
            return confirm("确认删除 节点 -- " + treeNode.name + "以及其它子节点 吗？");
        }
        function onRemove(e, treeId, treeNode) {
        	$.ajax({
                url: "type/del/" + treeNode.id,
                type:"GET",
                error : function(data) {
                    alert("error");
                    console.log(data);
                },
                success : function(data) {
                    alert("success");
                    console.log(data);
                }
            });
            return false;
        }
        function beforeRename(treeId, treeNode, newName, isCancel) {
            className = (className === "dark" ? "":"dark");
            
            if (newName.length == 0) {
                setTimeout(function() {
                    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                    zTree.cancelEditName();
                    alert("节点名称不能为空.");
                }, 0);
                return false;
            }
            return true;
        }
        function onRename(e, treeId, treeNode, isCancel) {
            /* console.log("e:" + e+"treeid:" + treeId + "treeNode:"+treeNode + "isCancel:"+isCancel); */
            console.log(e);
            console.log(treeNode);
            console.log(isCancel);
            $.ajax({
                    url: "type/updateById",
                    type:"POST",
                    data:{
                        typeId:treeNode.id,
                        name:treeNode.name,
                        parentId:treeNode.pId
                    },
                    error : function(data) {
                        alert("error");
                        console.log(data);
                    },
                    success : function(data) {
                        alert("success");
                        console.log(data);
                    }
                });
            return false;
        }
        function showRemoveBtn(treeId, treeNode) {
            return true;
        }
        function showRenameBtn(treeId, treeNode) {
            return true;
        }

        function zTreeOnNodeCreated(event, treeId, treeNode) {
            return true;
        };
        /*function showLog(str) {
            if (!log) log = $("#log");
            log.append("<li class='"+className+"'>"+str+"</li>");
            if(log.children("li").length > 8) {
                log.get(0).removeChild(log.children("li")[0]);
            }
        }
        function getTime() {
            var now= new Date(),
            h=now.getHours(),
            m=now.getMinutes(),
            s=now.getSeconds(),
            ms=now.getMilliseconds();
            return (h+":"+m+":"+s+ " " +ms);
        }*/

        var newCount = 1;
        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
                $.ajax({
                    url: "type/insert",
                    type:"POST",
                    data:{
                        name:"new node",
                        parentId:treeNode.id
                    },
                    error : function(data) {
                        alert("error");
                        console.log(data);
                    },
                    success : function(data) {
                        alert("success");
                        console.log(data);
                    }
                });
                return false;
            });
        };
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
        function selectAll() {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
        }


		$(document).ready(function() {
			$.ajax({
				url : 'type/typeIteration',
				type : 'GET',
				error : function(data) {
					console.log(data);
				},
				success : function(data) {
					zNodes = data;
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
                    $("#selectAll").bind("click", selectAll);
				}
			});

		});
	</SCRIPT>
</body>
</html>