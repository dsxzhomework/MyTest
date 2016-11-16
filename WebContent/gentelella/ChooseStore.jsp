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

  <title>总店服务员</title>

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
            <a href="#" class="site_title"><i class="fa fa-paw"></i> <span>总店服务</span></a>
          </div>
          <div class="clearfix"></div>

          <!-- /menu prile quick info -->

          <br />
					<!-- sidebar menu -->
					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

						<div class="menu_section">
						<br><br><br><br>
							<ul class="nav side-menu">
								<li><a href="staffChoose"><i class="fa fa-home"></i> 制定产品计划 </a>
								</li>
								<li><a href="showScheduleState"><i class="fa fa-home"></i> 查看计划状态 </a>
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
                  <li><a href="login.jsp"><i class="fa fa-sign-out pull-right"></i>注销登录</a>
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
                  <h2>选择店铺</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">                          
                  <br>
                  <form  data-parsley-validate="" class="form-horizontal form-label-left">
                   
                   <div class="form-group" id="store" style="display:block">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">选择分店*:</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                    <select id="storeChoose" class="form-control">
   
   					<s:iterator id="item" value="storeInfoList">
						<option test='<s:property value="#item.storeId"/>'> <s:property value="#item.name"/></option>
   					</s:iterator>                              

                        </select>
                    </div>
                    </div>
                                                  
                               
                                        
                    <div class="ln_solid"></div>
                    <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button class="btn btn-success">制定计划</button>
                      </div>
                    </div>

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

  <script>
  $('.btn.btn-success').click(function() {
	  
	  var storeId=$("#storeChoose").find("option:selected").attr('test');
		$.ajax({
			type : "post", //请求方式
			url : "StaffSchedule", //发送请求地址
			data : {
				storeID:storeId,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="ShowStaffSchedule"; 
			}
		});		
		return false;
});
  </script>
  
</body>

</html>
