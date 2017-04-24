<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/MyPadagogy/css/bootstrap.min-v3.3.7.css" >
<script type="text/javascript" src="/MyPadagogy/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/MyPadagogy/js/bootstrap.min-3.3.7.js"></script>
<title>测试</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#sub").click(function() {
				alert("在这");
				$.ajax({
					type : "get",
					url : "type/query",
					/* data : {
						_method : "put",
						name : "hsj",
						pwd : "hsj123"
					}, */
					success : function(data) {
						console.log(data);
					}
				});
			})
		});
	</script>
	
<!-- <div class="panel-group" id="accordion">
<ul>
	<li  data-toggle="collapse" data-target="#demo"  >水果
	   <div id="demo" class="collapse">
	 			<ul>
	         		<li>香蕉</li>
	         		<li>苹果</li>
	         	</ul>  
	  </div>
	</li>
	
	<li  data-toggle="collapse" data-target="#demo2">多碳水
	   <div id="demo2" class="collapse">
	 			<ul>
	         		<li data-toggle="collapse" data-target="#demo3">香蕉
	         			<div  id="demo3" class="collapse">
		         			<ul>
		         				<li>芭蕉</li>
		         			</ul>
	         			</div>
	         		</li>
	         	</ul>  
	  </div>
	</li>	
</ul>


   </div> -->
	
	
	<!-- <form method="post" action="type/insert">
	 类名:<input type="text" name="name">
	父类:<input type="text" name="parentId"> 
	 时间<input type="date" name="lateTime"> 
	<button type="submit" id="sub">提交</button>
	</form>  -->
	<button type="submit" id="sub">提交</button>
</body>
</html>