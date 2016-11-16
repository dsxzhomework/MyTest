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

  <title>购物车 </title>

  <!-- Bootstrap core CSS -->

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/icheck/flat/green.css" rel="stylesheet">
  <link href="css/toaster.css" rel="stylesheet"/>

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
                    <li><a>购物车</a>
                    </li>
                  </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> 会员信息 <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="showConsumeRegisterInfo">注册信息</a>
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

        <div class="">

          <div class="clearfix"></div>

          <div class="row">
            <div class="col-md-12">
              <div class="x_panel">
                <div class="x_title">
                </div>
                <div class="x_content">

                  <section class="content invoice">
                    <!-- title row -->
                    <div class="row">
                      <div class="col-xs-12 invoice-header">
                        <h1>
                                        <i class="fa fa-globe"></i> 购物车
                                        <small class="pull-right">Date: 16/08/2016</small>
                                    </h1>
                      </div>
                      <!-- /.col -->
                    </div>

                    <!-- Table row -->
                    <div class="row">
                      <div class="col-xs-12 table">
                        <table class="table table-striped">
                          <thead>
                            <tr>
                              <th>数量</th>
                              <th>产品</th>
                              <th>单价 </th>
                              <th>总价</th>
                              <th>取消</th>
                            
                            </tr>
                          </thead>
                          <tbody>
                          
                          <s:iterator id="item" value="cart">
                           <tr>
                              <td><s:property value="#item.quantity"/></td>
                              <td><s:property value="#item.productName"/></td>
                              <td><s:property value="#item.price"/></td>
                              <td><s:property value="#item.totalPrice"/></td>
                              <td><a class="delete" productId="<s:property value="#item.productId"/>" >删除</a></td>
                            </tr>
  						</s:iterator>
                          </tbody>
                        </table>
                      </div>
                      
                         <br />        
                             <!-- /.col -->
                    </div>
               <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left">
		          <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">您的会员卡余额<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="balance" disabled="disabled" value="${balance}" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>               
		          <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">本次消费金额<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="totalMoney" disabled="disabled" value="${totalMoney}" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                     <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">收货地址<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="address"  class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                      <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">送货时间<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="sendDate"  class="form-control col-md-7 col-xs-12" data-inputmask="'mask': '99/99 99:99'">
                      </div>
                    </div>    
                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">备注信息 &nbsp
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="sendDate"  class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>              
               </form>
                    </div>                 
                    <div class="row no-print">
                      <div class="col-xs-12">
                        <button class="btn btn-success pull-right"><i class="fa fa-credit-card"></i>提交订单</button>
                      </div>
                    </div>
                  </section>
                  
                  
                  <!-- 模态框 -->

                </div>
              </div>
            </div>
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
   <!-- input mask -->
 <script src="js/input_mask/jquery.inputmask.js"></script>

  <!-- pace -->
  <script src="js/pace/pace.min.js"></script>
    <script src="js/toaster.js"></script>
  <script>$('#invokesToastMessage').click(function(){});</script>
</body>

<script>
//删除购物车中物品
$('.delete').click(function() {
	productId=$(this).attr('productId');
		
		
 		$.ajax({
			type : "post", //请求方式
			url : "cartDelete", //发送请求地址
			data : {
				productId:productId,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="showCart"; 
			}
		});	 
	
	return false;

});
//提交订单
$('.btn.btn-success.pull-right').click(function() {
	//地址
	var address=$('#address').val();
	var sendDate=$('#sendDate').val();
	var balance=$('#balance').val();
	var totalMoney=$('#totalMoney').val();
	
	//alert(balance - totalMoney);
	if(totalMoney == 0){
		toastr.warning("购物车为空！请添加点商品再来吧～");
		//alert('购物车为空！请添加点商品再来吧～');
	}
	else if((balance - totalMoney) < 0){
		toastr.warning("您的会员卡余额不足，请先充值");
		//alert('');
	}
	else{
	if(address.length > 0){
 		$.ajax({
			type : "post", //请求方式
			url : "orderSubmit", //发送请求地址
			data : {
				address:address,
				sendDate:sendDate,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
				//进入我的消费记录
			    window.location.href="memberConsumeRecord"; 
			}
		});	 
	}
	else{
			toastr.warning("收获填写地址不能为空");
			//alert('收获填写地址不能为空');

}
	}
	return false;

});

</script>
  <script>
    $(document).ready(function() {
      $(":input").inputmask();
    });
  </script>
</html>
