<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>

  <!-- ########################### -->
  <div class="top container">
    <div class="row">
      <div class="col-md-12">
        <img class="toplogo" src="images/logo.png"/>
      </div>
    </div>
  </div>

  <!-- ############################## -->
  <div id="nav-wrapper">
    <div id="nav" class="navbar navbar-default navbar-inner container">
        <div class="row">
          <div class="col-md-12">
    
            <!-- BAR CONTENTS -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.html">Padagogy</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <!-- LEFT CONTENT -->
              <ul class="nav navbar-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">应用平台<span class="fa fa-arrow-down"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>android</a></li>
 
                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>ios</a></li>
					
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">学科<span class="fa fa-arrow-down"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>数学</a></li>
                    <li class="divider"></li>
                    <li><a href="#" style="font-weight:300"><span class="glyphicon glyphicon-asterisk"></span>高数</a></li>
                    <li><a href="#" style="font-weight:300"><span class="glyphicon glyphicon-asterisk"></span>线代</a></li>
                    <li><a href="#" style="font-weight:300"><span class="glyphicon glyphicon-asterisk"></span>统计学</a></li>

                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>外语</a></li>
                    <li class="divider"></li>
                    <li><a href="#" style="font-weight:300"><span class="glyphicon glyphicon-asterisk"></span>英语</a></li>
                    <li><a href="#" style="font-weight:300"><span class="glyphicon glyphicon-asterisk"></span>德语</a></li>
                    <li><a href="#" style="font-weight:300"><span class="glyphicon glyphicon-asterisk"></span>法语</a></li>
                  </ul>
                </li>

                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">年龄<span class="fa fa-arrow-down"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>幼儿</a></li>

                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>中学</a></li>

                    <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>大学</a></li>
                    
                  </ul>
                </li>
              </ul>
              
              <!-- RIGHT CONTENT -->
				
              <ul class="nav navbar-nav navbar-right">
				<li><input type="text" id="search-green" /></li>
                <li><a href="index.html"><span class="fa fa-home"></span> Home</a></li>
                <li><a href="login.html"><span class="fa fa-user"></span> Login</a></li>
                <li><a href="contact.html"><span class="fa fa-envelope"></span> Contact</a></li>
              </ul>
            </div>
		
          </div> <!-- col -->
        </div> <!-- row -->
    </div> <!-- nav -->
  </div> <!-- wrapper -->

	<div class="container">
		<!-- CAROUSEL -->
		<div id="carousel-example-generic" class="carousel slide row hidden-xs" data-ride="carousel" data-interval="4000">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>
		 
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="images/banner1.jpg" alt="..." style="width:100%">
				</div>
				<div class="item">
					<img src="images/banner2.jpg" alt="..." style="width:100%">
				</div>
				<div class="item">
					<img src="images/banner3.jpg" alt="..." style="width:100%">
				</div>
			</div>
		 
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div> <!-- Carousel -->
	</div>
</header>
    