<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>会员注册信息</title>

  <!-- Bootstrap core CSS -->

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/icheck/flat/green.css" rel="stylesheet">
  <link href="css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">

  <script src="js/jquery.min.js"></script>


</head>


<body class="nav-md">

  <div class="container body">


    <div class="main_container">

      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">

          <div class="navbar nav_title" style="border: 0;">
            <a href="#" class="site_title"><i class="fa fa-paw"></i> <span>欢迎您！ ${name}</span></a>
          </div>
          <div class="clearfix"></div>


          <br /><br><br>

          <!-- sidebar menu -->
         <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
              <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i> 产品 <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="showMemberMain">查看全部产品</a>
                    </li>
                    <li><a href="showMemberCollection">收藏夹</a>
                    </li>
                    <li><a href="showCart">购物车</a>
                    </li>
                  </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> 会员信息 <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="#">注册信息</a>
                    </li>
                    <li><a href="showCardInfo">会员卡信息</a>
                    </li>
                    <li><a href="showMemberInfo">会员个人信息</a>
                    </li>                      
                  </ul>
                </li>
                 <li><a><i class="fa fa-search"></i>记录查询<span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display:none">
                    <li><a href="memberConsumeRecord">消费记录</a></li>
                    <li><a href="showMemberRecharge">充值记录</a></li>
                  </ul>
                </li>      
              </ul>
            </div>

          </div>
          <!-- /sidebar menu -->

        </div>
      </div>

      <!-- top navigation -->
      <div class="top_nav">

        <div class="nav_menu">
          <nav class="" role="navigation">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
              <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <img src="images/img.jpg" alt=""> ${name}
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                   <li>
                    <a href="showMemberPassword">密码修改</a>
                  </li>
                  <li>
                    <a href="memberLogin.jsp">注销登录</a>
                  </li>
                </ul>
              </li>
            </ul>
          </nav>
        </div>

      </div>
      <!-- /top navigation -->

      <!-- page content -->
         <div class="right_col" role="main">
<div class="x_panel">
                <div class="x_title">
                  <h2>注册信息</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <br>
                  <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left">

                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">会员卡号<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" disabled="disabled" required="required" value="${cardNum}"  class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"> 姓名<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text"  name="last-name" disabled="disabled" value="${name}" required="required" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">联系电话<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input   class="form-control col-md-7 col-xs-12"  value="${phoneNum}" disabled="disabled" type="text" name="middle-name">
                      </div>
                    </div>
                    <div class="ln_solid"></div>
 

                  </form>
                </div>
              </div>

      </div>
      <!-- /page content -->
    </div>

  </div>

  <div id="custom_notifications" class="custom-notifications dsp_none">
    <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
    </ul>
    <div class="clearfix"></div>
    <div id="notif-group" class="tabbed_notifications"></div>
  </div>

  <script src="js/bootstrap.min.js"></script>

  <!-- chart js -->
  <script src="js/chartjs/chart.min.js"></script>
  <!-- bootstrap progress js -->
  <script src="js/progressbar/bootstrap-progressbar.min.js"></script>
  <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
  <!-- icheck -->
  <script src="js/icheck/icheck.min.js"></script>

  <script src="js/custom.js"></script>


  <!-- Datatables -->
  <script src="js/datatables/js/jquery.dataTables.js"></script>
  <script src="js/datatables/tools/js/dataTables.tableTools.js"></script>

  <!-- pace -->
  <script src="js/pace/pace.min.js"></script>
  
</body>

</html>
