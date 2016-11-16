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

  <title>店面管理</title>

  <!-- Bootstrap core CSS -->

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/icheck/flat/green.css" rel="stylesheet">
  <link href="css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">

  <script src="js/jquery.min.js"></script>

  <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>


<body class="nav-md">

  <div class="container body">


    <div class="main_container">

      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">

          <div class="navbar nav_title" style="border: 0;">
            <a href="#" class="site_title"><i class="fa fa-paw"></i> <span>管理后台</span></a>
          </div>
          <div class="clearfix"></div>

          <!-- menu prile quick info -->
          <div class="profile">
            <div class="profile_pic">
              <img src="images/img.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>欢迎登录,</span>
              <h2>管理员</h2>
            </div>
          </div>
          <!-- /menu prile quick info -->

          <br />


					<!-- sidebar menu -->
					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

						<div class="menu_section">
						<br><br><br><br>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> 店面管理 <span class="fa fa-chevron-down"></span></a>
<!-- 									<ul class="nav child_menu" style="display: none">
										<li><a href="empty.html">Sub1.1</a>
										</li>
										<li><a href="empty.html">Sub1.2</a>
										</li>
									</ul> -->
								</li>
								<li><a href="showWaiterInfo"><i class="glyphicon glyphicon-user"></i> 店员管理 <span class="fa fa-chevron-down"></span></a>
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
                  <img src="images/img.jpg" alt="">管理员
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
        <div class="">
          <div class="clearfix"></div>

          <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>全部店面 </h2>
                  <ul class="nav navbar-right panel_toolbox"> 
				  <li role="presentation" class="dropdown">
					<button type="button" class="btn btn-dark">添加新店面</button>
                  </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <table id="example" class="table table-striped responsive-utilities jambo_table">
                    <thead>
                      <tr class="headings">
                        <th>商店编号 </th>
                        <th>店铺名称 </th>
                        <th>店铺地址</th>
                        <th>联系方式</th>
                        <th>修改 </th>
                        <th class=" no-link last"><span class="nobr">删除</span>
                        </th>
                      </tr>
                    </thead>

                    <tbody>
                    <s:iterator id="item" value="storeInfoList">


                      <tr class="even pointer">
                        <td class=" "><s:property value="#item.storeId"/></td>
                        <td class=" "><s:property value="#item.name"/></td>
                        <td class=" "><s:property value="#item.address"/> </td>
                        <td class=" "><s:property value="#item.phoneNum"/></td>
                        <td class="" storeId='<s:property value="#item.storeId"/>' name='<s:property value="#item.name"/>' address='<s:property value="#item.address"/>' phoneNum='<s:property value="#item.phoneNum"/>'>
                        <a class="update" href="#">修改</a></td>
                        <td class="last" value='<s:property value="#item.storeId"/>'><a class="delete" href="#">删除</a>
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
  <!--删除-->
  <script>
  $('.delete').click(function() {
	  var storeId = $(this).parent().attr('value');
		$.ajax({
			type : "post", //请求方式
			url : "delStoreInfo", //发送请求地址
			data : {
				storeId:storeId,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="showStoreInfo"; 
			}
		});		
});
  </script>
  <!--更新 -->
    <script>
  $('.update').click(function() {
	  var name = $(this).parent().attr('name');
	  var address = $(this).parent().attr('address');
	  var phoneNum = $(this).parent().attr('phoneNum');	  
	  var storeId=$(this).parent().attr('storeId');	
		$.ajax({
			type : "post", //请求方式
			url : "chooseUpdateInfo", //发送请求地址
			data : {
				name:name,
				address:address,
				phoneNum:phoneNum,
				storeId:storeId,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="StoreUpdate"; 
			}
		});		
});
  </script>
  <!-- 添加新店面 -->
  <script>
  $('.btn.btn-dark').click(function() {
	    window.location.href="StoreAdd"; 
});		  
  </script>
  
  <script>
    $(document).ready(function() {
      $('input.tableflat').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green'
      });
    });

    var asInitVals = new Array();
    $(document).ready(function() {
      var oTable = $('#example').dataTable({
        "oLanguage": {
          "sSearch": "Search all columns:"
        },
        "aoColumnDefs": [{
            'bSortable': false,
            'aTargets': [0]
          } //disables sorting for column one
        ],
        'iDisplayLength': 12,
        "sPaginationType": "full_numbers",
        "dom": 'T<"clear">lfrtip',
        "tableTools": {
          "sSwfPath": "<?php echo base_url('assets2/js/Datatables/tools/swf/copy_csv_xls_pdf.swf'); ?>"
        }
      });
      $("tfoot input").keyup(function() {
        /* Filter on the column based on the index of this element's parent <th> */
        oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
      });
      $("tfoot input").each(function(i) {
        asInitVals[i] = this.value;
      });
      $("tfoot input").focus(function() {
        if (this.className == "search_init") {
          this.className = "";
          this.value = "";
        }
      });
      $("tfoot input").blur(function(i) {
        if (this.value == "") {
          this.className = "search_init";
          this.value = asInitVals[$("tfoot input").index(this)];
        }
      });
    });
  </script>
</body>

</html>
