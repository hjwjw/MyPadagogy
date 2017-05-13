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
<title>待审文章</title>
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
	<div id="wrapper">
		<!-- /. NAV TOP   -->
		<jsp:include page="leftTopMenu.jsp" />
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">待审核文章</h1>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive">
							<form action="#" method="post" id="appListForm">
								<input type="hidden" name="p" value="pending" />
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>
												<div class="checkbox">
													<label> <input type="checkbox" id="allsel">ID
													</label>
												</div>
											</th>
											<th>APP 名</th>
											<th>类别</th>
											<!-- <th>下载方式</th> -->
											<th>创建者</th>
											<th>创建时间</th>
											<th>状态</th>
											<!-- <th>浏览量</th>
                                        <th>评价(赞/踩)</th> -->
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${appList}" var="appItem">
											<tr>
												<td>
													<div class="checkbox">
														<label> <input type="checkbox" name="appinfo"
															value="${appItem.appId }">${appItem.appId }
														</label>
													</div>
												</td>
												<td><a href="appItem/select/${appItem.appId}">${appItem.name }</a></td>
												<td><c:forEach items="${appItem.typeName}" var="next">  ${next}  | </c:forEach></td>
												<%-- <td>${appItem.downLink}</td> --%>
												<td>${appItem.userName}</td>
												<td><fmt:formatDate value='${appItem.createtime}'
														pattern='yyyy-MM-dd ' /></td>
												<td>${appItem.stateStr}</td>
												<%-- <td>${appItem.count}</td>
												<td>${appItem.support}/ ${appItem.dislike}</td> --%>
												<td class="text-center"><a class="btn btn-primary"
													href="appItem/up/${appItem.appId }">修改</a> <a class="btn btn-danger"
													href="appItem/changeStateById/${appItem.appId }?p=pending">通过</a> <a
													class="btn btn-danger" href="appItem/del/${appItem.appId }?p=pending">删除</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>

						<ul class="pagination">
							<li
								<c:if test="${page.pageNum eq page.firstPage}"> class='disabled' </c:if>>
								<a href="appItem/queryPending?pageNum=${page.firstPage } " alt="首页">&laquo;</a>
							</li>
							<c:forEach items="${page.navigatepageNums }" var="i">
								<li <c:if test="${page.pageNum eq i}"> class="active" </c:if>>
									<a href="appItem/queryPending?pageNum=${i} ">${i} <span
										class="sr-only">(current)</span></a>
								</li>
							</c:forEach>
							<li
								<c:if test="${page.pageNum eq page.lastPage}"> class='disabled' </c:if>><a
								href="appItem/queryPending?pageNum=${page.lastPage} " alt="最后一页">&raquo;</a></li>
						</ul>

						<div class="form-group form-inline">
							<label>多选操作</label> <select class="form-control" id="selectList">
								<option value="del">删除</option>
								<option value="no">通过</option>
							</select>
							<button class="btn btn-primary form-control" id="init_btn">确定</button>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
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
       	   			var str  = $("#selectList").val();
       	   			if(str == "del"){
       	   				$('form[id=appListForm]').attr('action','appItem/selectDel?p=pending');
       	   				$('form[id=appListForm]').submit();
       	   			}else if(str == "no"){
       	   				$('form[id=appListForm]').attr('action','appItem/changeState?p=pending');
       	   				$('form[id=appListForm]').submit();
       	   			}
       	   		}
       	   });
        } );
		
</script>
</body>
</html>