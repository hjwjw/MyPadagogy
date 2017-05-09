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
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="Free Bootstrap Themes by 365Bootstrap dot com - Free Responsive Html5 Templates">
<title>首页</title>
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
		
		<div class="col-md-6 col-md-offset-1">
			<div id="main-content">
				<article>
					<div class="art-header">
						<a href="single.html"><h2>Lorem ipsum dolor sit amet</h2></a>
						<div class="info">
							By <a href="#">Admin</a> June 12, 2015 - <i class="fa fa-comment"></i> 0 Comments
							<ul class="list-inline">
								<li><a href="#" style="text-decoration: underline;color:#333;">Free</a></li>
								<li> - </li>
								<li>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-o"></i>
									</span>
								</li>
							</ul>
						</div>
						
					</div>
					<div class="art-content">
						<img src="images/1.png" />
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Consetetur sadipscing elitr, sed diam nonumy eirmod tempor inviduntut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.justo duo dolores et ea rebum. Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt orem ipsum dolor sit amet, consetetur sadipscing <a href="single.html">MORE...</a></p>
						<button type="submit" class="btn btn-skin"><i class="fa fa-android"></i> <span>Google Play</span></button>
						<button type="submit" class="btn btn-skin"><i class="fa fa-apple"></i> App Store</button>
					</div>
				</article>

			  <hr>
		  
				<article>
					<div class="art-header">
						<a href="single.html"><h2>Lorem ipsum dolor sit amet</h2></a>
						<div class="info">
							By <a href="#">Admin</a> June 12, 2015 - <i class="fa fa-comment"></i> 0 Comments
							<ul class="list-inline">
								<li><a href="#" style="text-decoration: underline;color:#333;">免费</a></li>
								<li> - </li>
								<li>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-o"></i>
									</span>
								</li>
							</ul>
						</div>
					</div>
					<div class="art-content">
						<img src="images/7.jpg" />
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Consetetur sadipscing elitr, sed diam nonumy eirmod tempor inviduntut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.justo duo dolores et ea rebum. Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt orem ipsum dolor sit amet, consetetur sadipscing <a href="single.html">更多...</a></p>
						<button type="submit" class="btn btn-skin"><i class="fa fa-apple"></i> <span>Google Play</span></button>
						<button type="submit" class="btn btn-skin"><i class="fa fa-android"></i> App Store</button>
					</div>
				</article>
			  
				<center>
					<ul class="pagination">
						<li>
						  <a href="#" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						  </a>
						</li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li>
						  <a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						  </a>
						</li>
					</ul>
				</center>
		
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="bs-sidebar affix hidden-xs hidden-sm" id="sidebar">
				<h3>热门下载</h3>
				<div id="owl-demo1" class="owl-carousel">
					<div class="item">
						<a href="single.html"><img src="images/1.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/2.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/7.jpg" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/3.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/4.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/5.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/6.png" /></a>
					</div>
				</div>
				<h3>最新</h3>
				<div id="owl-demo2" class="owl-carousel">
					<div class="item">
						<a href="single.html"><img src="images/1.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/2.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/7.jpg" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/3.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/4.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/5.png" /></a>
					</div>
					<div class="item">
						<a href="single.html"><img src="images/6.png" /></a>
					</div>
				</div>
			</div>
		</div>
    </div>

	
	</div>
	
	<!-- FOOTER -->
	<jsp:include page="footer.jsp" />
  
	<!-- jQuery -->
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- search -->
	<script src="js/jquery.searchMeme.js" type="text/javascript"></script>
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
    
</body>
</html>