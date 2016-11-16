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

  <title>查看计划状态</title>

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
            <a href="#" class="site_title" id="store" storeId="${storeId}"><i class="fa fa-paw"></i> <span>${storeName}</span></a>
          </div>

  
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
                  <li><a href="showMemberInfo"> 修改个人信息</a>
                  </li>
                  <li>
                    <a href="login.jsp">注销登录</a>
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
        <div class="">
          <div class="clearfix"></div>

          <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>提交计划状态</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <table id="example" class="table table-striped responsive-utilities jambo_table">
                    <thead>
                      <tr class="headings">
                        <th>计划id </th>
                        <th>起始时间</th>
                        <th>店铺名称</th>
                        <th>计划状态</th>
                        <th class=" no-link last"><span class="nobr">查看详情</span>
                        </th>
                      </tr>
                    </thead>

                    <tbody>
                 <s:iterator id="item" value="stateVo">

                      <tr class="even pointer">
                        <td class=" "><s:property value="#item.scheduleId"/></td>
                        <td class=" "><s:property value="#item.date"/> </td>
                        <td class=" "><s:property value="#item.storeName"/></td>
                        <td class=" "><s:property value="#item.state"/></td>
                        <td class="last"><a class="seeDetail" scheduleId='<s:property value="scheduleId"/>'href="#">查看详情</a>
                        </td>
                      </tr>
   					</s:iterator>                  
                 </tbody>

                  </table>
                </div>
              </div>
            </div>

            <br />
            <br />
            <br />

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
  
   <!--查看详情-->
  <script>
  $('.seeDetail').click(function() {
	  var scheduleId = $(this).attr('scheduleId');
		$.ajax({
			type : "post", //请求方式
			url : "managerScheduleDetail", //发送请求地址
			data : {
				scheduleId:scheduleId,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="managerShowDetail"; 
			}
		});		
});
  </script>
</body>

</html>
