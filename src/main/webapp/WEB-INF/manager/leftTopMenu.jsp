<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">移动端导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Padagogy </a>
            </div>

            <div class="header-right">

                <a href="index.html" class="btn btn-info" title="首页"><i class="fa fa-home fa-2x"></i></a>
                <a href="message-task.html" class="btn btn-primary" title="管理员"><i class="fa fa-user fa-2x"></i></a>
                <a href="login.html" class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>

            </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="assets/img/user.png" class="img-thumbnail" />

                            <div class="inner-text">
                                HJW
                            <br />
                                <small>最后登陆 : 2017-4-25 14：50 </small>
                            </div>
                        </div>

                    </li>


                    <li>
                        <a class="active-menu" href="index.html"><i class="fa fa-dashboard "></i>仪表盘</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop "></i>app管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="appItem/queryAll"><i class="fa fa-list-alt"></i>已通过文章</a>
                            </li> 
                            <li>
                                <a href="appItem/queryPending"><i class="fa fa-check-square"></i>待审核文章</a>
                            </li>
                             <li>
                                <a href="appItem/toAdd"><i class="fa fa-edit "></i>添加新文章</a>
                            </li>
                             
                        </ul>
                    </li>
                     <li>
                        <a href="type/to"><i class="fa fa-list "></i>分类管理 </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-tag "></i>标签管理 <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                 <li>
                                    <a href="keyword/queryAll"><i class="fa fa-tags "></i>全部标签 </a>
                                </li>
                                 <li>
                                    <a href="keyword/toAdd"><i class="fa fa-plus-square"></i>新增标签</a>
                                </li> 
                                                          
                            </ul>
                    </li>
                    <li>
                        <a href="table.html"><i class="fa fa-comments "></i>留言管理 <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                 <li>
                                    <a href="form.html"><i class="fa fa-users "></i>全部留言 </a>
                                </li>
                                 <li>
                                    <a href="form-advance.html"><i class="fa fa-check-square"></i>待审核</a>
                                </li> 
                                                          
                            </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-users"></i>管理员 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                           
                            <li>
                                <a href="manager/queryAll"><i class="fa fa-users "></i>全部管理员 </a>
                            </li>
                             <li>
                                <a href="manager/toAdd"><i class="fa fa-plus-square"></i>新增管理员</a>
                            </li> 
                            <li>
                                <a href="form-advance.html"><i class="fa fa-list "></i>访问记录</a>
                            </li>                          
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-bar-chart"></i>数据统计 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                           
                             <li>
                                <a href="form.html"><i class="fa fa-line-chart "></i>网站访问量 </a>
                            </li>
                             <li>
                                <a href="form-advance.html"><i class="fa fa-pie-chart "></i>用户数</a>
                            </li>                          
                        </ul>
                    </li>
                    

                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->