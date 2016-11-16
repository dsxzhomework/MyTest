<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>产品详情</title>

  <!-- Bootstrap core CSS -->

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/icheck/flat/green.css" rel="stylesheet">
  <link href="css/toaster.css" rel="stylesheet"/>

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
                    <li><a href="showConsumeRegisterInfo">注册信息</a>
                    </li>
                    <li><a href="showCardInfo">会员卡信息</a>
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
                  <img src="images/img.jpg" alt="">  ${name }
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
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2> ${productName}</h2>
                  <ul class="nav navbar-right panel_toolbox"> 
				  <li role="presentation" class="dropdown">
					<button type="button" class="btn btn-dark">返回</button>
                  </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">

                  <div class="col-md-7 col-sm-7 col-xs-12">
                    <div class="product-image">
                      <img src="${productImage}" alt="..." />
                    </div>
                  </div>

                  <div class="col-md-5 col-sm-5 col-xs-12" style="border:0px solid #e5e5e5;">

                    <h3 class="prod_title">产品详情介绍</h3>

                    <p>  ${productInfo}</p>
                    <br />

                    <br />

                    <div class="">
                      <div class="product_price">
                        <h1 class="price">¥ ${productPrice}</h1>                   
                        <br>
                      </div>
                    </div>
			<br /><br />
	<!-- test -->
	                <div class="col-md-9 col-sm-12 col-xs-12 form-group">
	                	
                	  <div class="row">
                	  <a class="btn btn-default" id="minus" style="width:37px"><i class="fa fa-minus"></i></a>
                	  <input type="text" id="quantity" style="width:50px;height:28px" value="1"> 
                	   <a class="btn btn-default" id="plus" style="width:37px"><i class="fa fa-plus"></i> </a>  
                	  </div>	  
                	  </div>
	

	<!-- test -->		
                    <div class="">
                      <button type="button" class="btn btn-success btn-lg" id="cart">添加到购物车</button> 
<!--                       <button type="button" class="btn btn-success btn-lg" id="collection" >添加到收藏夹</button> -->
					  <button type="button" class="btn btn-success btn-lg"  id="collect">添加到收藏夹</button>
                    </div>

                  </div>
			
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
  <!-- pace -->
  <script src="js/pace/pace.min.js"></script>
  <script src="js/custom.js"></script>
  <script src="js/toaster.js"></script>
  <script>$('#invokesToastMessage').click(function(){});</script>
  
</body>
<!-- 模态框 -->
<script>
$('#myModal').on('shown.bs.modal', function () {
	 $('#myInput').focus()
	})
</script>
  <script>
  $('.btn.btn-dark').click(function() {
	    window.location.href="showMemberMain"; 
});		  
  </script>
  <script>
  
  //添加到购物车
  
  $('#cart').click(function() {
	  var productId = $(this).attr('productId');  
	  var quantity=$('#quantity').val();
	  
 		$.ajax({
			type : "post", //请求方式
			url : "addToCart", //发送请求地址
			data : {
				productId:productId,
				quantity:quantity,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {	
				//alert('添加到购物车成功');
				toastr.success("添加到购物车成功");
			}
		});	 
 	return false;
});
  //添加到收藏
    $('#collect').click(function() {
  
 	  toastr.success("添加到收藏夹成功");
 		return false;
});
  </script>
  <script>
    //减少商品数量
  $('#minus').click(function() {
	  var quantity=$(this).parent().children('input').val();
		  //$('#quantity').val();
	 if(quantity==1){
		// alert('数量已经最低！');
		 toastr.warning("数量已经最低！");
	 }
	 else{
		// $('#quantity').attr('placeholder',parseInt(quantity)-1); 
		$(this).parent().children('input').val(parseInt(quantity)-1);
	 }
	  
  });
  //增加商品数量
  $('#plus').click(function() {
	  
	 var quantity=$(this).parent().children('input').val();
	 if(false){
		//判断是否超过库存
	 }
	 else{
		 $(this).parent().children('input').val(parseInt(quantity)+1);
	 }
  });
  </script>
</html>
