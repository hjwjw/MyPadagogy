<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/MyPadagogy/js/jquery-3.2.1.js"></script>
<title>测试</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#sub").click(function() {
				alert("在这");
				$.ajax({
					type : "post",
					url : "manager/" + 6,
					data : {
						_method : "put",
						name : "hsj",
						pwd : "hsj123"
					},
					success : function(data) {
						console.log(data);
					}
				});
			})
		});
	</script>
	<!-- <form method="delete" action="manager/9">
 -->

	<!-- 用户名:<input type="text" name="pageNum">
	密码:<input type="password" name="pageSize"> -->
	<!-- 时间<input type="date" name="lateTime"> -->
	<button type="button" id="sub">提交</button>
	<!-- </form> -->
</body>
</html>