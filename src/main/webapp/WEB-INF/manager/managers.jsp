<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 格式化 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>所有管理员列表</title>
<base href="<%=basePath%>">
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

</head>
<body>
		<!-- /. NAV TOP   -->
		<jsp:include page="leftTopMenu.jsp" />
		<!-- /. NAV SIDE  -->

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">全部管理员</h1>

					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive">
						<form action="admin/selectDel" method="post" id="adminList">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											<div class="checkbox">
												<label> <input type="checkbox" id="allsel">#
												</label>
											</div>
										</th>
										<th>用户名</th>
										<th>密码</th>
										<th>最后登陆时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${adminList }" var="admin">

										<tr>
											<td>
												<div class="checkbox">
													<label> <input type="checkbox" name="adminInfo" value="${admin.id }">${admin.id }
													</label>
												</div>
											</td>
											<td> ${admin.name }</td>
											<td> ${admin.pwd }</td>
											<td><fmt:formatDate value='${admin.lateTime }'
													pattern='yyyy-MM-dd' /></td>
											<td class="text-center"><a class="btn btn-primary"
												href="admin/up/${admin.id }" id="ad_update">修改</a>
												<a  href="admin/del/${admin.id }" class="btn btn-danger" value="${admin.id }"
													 id="ad_del">删除</a></td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</form>
						</div>

						<ul class="pagination">
							<li
								<c:if test="${page.pageNum eq page.firstPage}"> class='disabled' </c:if>>
								<a href="admin/queryAll?pageNum=${page.firstPage } " alt="首页">&laquo;</a>
							</li>
							<c:forEach items="${page.navigatepageNums }" var="i">
								<li <c:if test="${page.pageNum eq i}"> class="active" </c:if>>
									<a href="admin/queryAll?pageNum=${i} ">${i} <span class="sr-only">(current)</span></a>
								</li>
							</c:forEach>
							<li
								<c:if test="${page.pageNum eq page.lastPage}"> class='disabled' </c:if>><a
								href="admin/queryAll?pageNum=${page.lastPage} " alt="最后一页">&raquo;</a></li>
						</ul>

						<div class="form-group form-inline">
							<label>多选操作</label> <select class="form-control">
								<option>删除</option>
							</select>
							<button class="btn btn-primary form-control" id="init_btn">执行操作</button>
						</div>
					</div>


				</div>
				<!--/.ROW-->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<jsp:include page="footer.jsp" />
	<!-- /. FOOTER  -->
	
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>

	<script type="text/javascript">
        $(document).ready(function(){
       	  //实现全选功能
       	   $("#allsel").click(function(e) {
       			if($(this).prop("checked")){ 
       			$(":checkbox").prop("checked",true); 
       			}else{ 
       			$(":checkbox").prop("checked",false); 
       			} 
       		});
       	   //全选操作验证并提交
       	   $("#init_btn").click(function(e) {
       	   	var init_btn = $("input:checked");
       	   	if(init_btn.length==0){
       	   		alert("请选择要执行操作的项目");
       	   		return false;
       	   		}else{
       	   			init_btn.closest('form').submit(); //获取被选中的复选框所属的表单，并实现提交事件
       	   		}
       	   });
        } );
		
    </script>

</body>
</html>