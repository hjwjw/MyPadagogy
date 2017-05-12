<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 格式化 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%  
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
<title>${keyword.name } 相关的APP</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">

<!-- Owl Carousel Assets -->
<link href="owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="owl-carousel/owl.theme.css" rel="stylesheet">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Custom Fonts -->
<link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
<link href='https://fonts.googleapis.com/css?family=Asap:400,700' rel='stylesheet' type='text/css'>
<!-- search -->
<link href="css/searchMeme.css" rel="stylesheet" type="text/css" />
<link href="css/wordbox.css" rel="stylesheet" type="text/css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<jsp:include page="head.jsp" />
	<!-- /////////////////////////////////////////Content -->
	<div id="page-content" class="index-page container">
	
	<div class="row">
		
		<div class="col-md-6 col-md-offset-1" id="main-container">
			<div id="main-content">
			<c:forEach items="${appItemList}" var="appItem">
				<article>
					<div class="art-header">
						<a href="appItem/select/${appItem.appId}"><h2>${appItem.name }</h2></a>
						<div class="info">
							By <a href="javascript:void(0)">${appItem.userName }</a> 
							<fmt:formatDate value='${appItem.createtime}' pattern='yyyy-MM-dd' />  - 
							<i class="fa fa-comment"></i> 0 Comments
							<ul class="list-inline">
								<li><a href="javascript:void(0)" style="text-decoration: underline;color:#333;">分类</a></li>
								<li> - </li>
								<li>
									<span class="rating">
										<c:forEach items="${appItem.typeName}" var="next">  ${next}  | </c:forEach>
									</span>
								</li>
							</ul>
						</div>
						
					</div>
					<div class="art-content">
						<img src="${appItem.logo }" />
						${appItem.introduce }
						<button type="submit" class="btn btn-skin"><i class="fa fa-android"></i> <span>Google Play</span></button>
						<button type="submit" class="btn btn-skin"><i class="fa fa-apple"></i> App Store</button>
					</div>
				</article>
			  <hr>
			  </c:forEach>
			  
			  <center>
					<ul class="pagination">
						<li
								<c:if test="${page.pageNum eq page.firstPage}"> class='disabled' </c:if>>
								<a href="keyList/selectAppItem/${keyword.keyId }?pageNum=${page.firstPage } " alt="首页">&laquo;</a>
						</li>
						<c:forEach items="${page.navigatepageNums }" var="i">
							<li <c:if test="${page.pageNum eq i}"> class="active" </c:if>>
									<a href="keyList/selectAppItem/${keyword.keyId}?pageNum=${i} ">${i} <span class="sr-only">(current)</span></a>
							</li>
						</c:forEach>
						<li
							<c:if test="${page.pageNum eq page.lastPage}"> class='disabled' </c:if>><a
							href="keyList/selectAppItem/${keyword.keyId}?pageNum=${page.lastPage} " alt="最后一页">&raquo;</a></li>
					</ul>
				</center>
			</div>
		</div>
	
		<div class="col-md-4" id="flexFrame">
			<div class=" bs-sidebar affix hidden-xs hidden-sm" id="sidebar">
				<h3>标签</h3>
				<div id="boxWord" class="wordbox"></div>
			</div>
		</div>
    </div>

	
	</div>
	
	<!-- FOOTER -->
	<jsp:include page="footer.jsp" />
  
	<!-- jQuery -->


	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/wordbox.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

	
	<!-- search -->
	<script src="js/jquery.searchMeme.js" type="text/javascript"></script>
	<script type="text/babel" src="js/head.js"></script>	
	<script>
		if ($(window).width() < 1199) {
			$('#sidebar').affix({
			  offset: {
				top: 398
			  }
			}); 
		} else {
			$('#sidebar').affix({
			  offset: {
				top: 442
			  }
			}); 
		}

		$(function() {
			$('#nav-wrapper').height($("#nav").height());
			
			$('#nav').affix({
				offset: { top: $('#nav').offset().top }
			});
			
		});
	</script>
	
	<!-- carousel -->
	<script src="owl-carousel/owl.carousel.js"></script>
    <script>
    $(document).ready(function() {
      $("#owl-demo1").owlCarousel({
        autoPlay: 3000,
        items : 3,
		itemsDesktop : [1199,2],
        itemsDesktopSmall : [979,2]
      });
	  $("#owl-demo2").owlCarousel({
        autoPlay: 3000,
        items : 3,
		itemsDesktop : [1199,2],
        itemsDesktopSmall : [979,2]
      });
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

<script type="text/javascript">
$(function() {
	var keywordData = [];
	$.ajax({
		url:'keywordRest/queryAll',
		type:'GET',
		async: false,
		success:function(result){
			keywordData = result.list;
		}
	});
	var words = [];
    for(var i = 0; i < keywordData.length; i++) {
        words[i] = {
            'title' : keywordData[i].name,
            'url' : 'keyList/selectAppItem/' + keywordData[i].keyId
        }
    }
    var colors1 = ['#F46779', '#045DA4'];    
    var colors2 = ['#D59A3E', '#C58B59'];    
    var colors3 = ['#49B4E0', '#FCBDA2', '#EBADBD', '#D5C2AF', '#C0BDE5', '#CBCC7F', '#FFDA7F', '#8dd0c3', '#bbbfc6', '#a4d9ef', '#bbdb98'];

    $('#boxWord').wordbox({
        isLead: true,          
        words: words,
        colors: colors3,
        borderWidth: 2,
        isFixedWidth: true,
        width: 320,
		height: 400,

    });

    // 鼠标浮动字体变大
    var fontSize = $('#boxWord').css('font-size');
    $('#boxWord .box a').hover(function(event) {  
        $(this).css({'font-size': '1.4em'});
        event.stopPropagation();
    }, function(event) {
        $(this).css({'font-size': fontSize});
        event.stopPropagation();
    });

});
 </script>
</body>
</html>