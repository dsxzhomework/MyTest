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

  <title>分店服务员－无卡销售</title>

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
          <div class="clearfix"></div>

          <!-- /menu prile quick info -->

          <br />
					<!-- sidebar menu -->
					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

						<div class="menu_section">
						<br><br><br><br>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> 销售 <span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: none">
										<li><a href="showStaffCard">会员卡消费</a>
										</li>
										<li><a >现金消费</a>
										</li>
									</ul>
								</li>
								<li><a href="showStoreRecord"><i class="glyphicon glyphicon-user"></i> 查看记录 <span class="fa fa-chevron-down"></span></a>
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
                  <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i>注销登录</a>
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
                  <h2>现金销售</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <br>
                  <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left">

                    
                     <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button class="btn btn-default" id="addGoods">添加产品</button>
                      </div>
                    </div>                  
                    
                    <div class="form-group" id="add" role="add-commodity-item">
                   <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">产品编号<span class="required">*</span></label>
                	<div class="col-md-3 col-sm-12 col-xs-12 form-group">
                      <select id="heard" class="form-control">
                      
					<s:iterator id="item" value="detail">
						<option price='<s:property value="#item.price"/>' storage='<s:property value="#item.quantity"/>' ><s:property value="#item.goodsId"/></option>
   					</s:iterator>                            

                        </select>
                	</div> 
                	           	 
                	  <div class="col-md-2 col-sm-12 col-xs-12 form-group">
                	  <div class="row">
                	  <a class="btn btn-default" id="minus" style="width:37px"><i class="fa fa-minus"></i></a>
                	  <input type="text" id="quantity" placeholder="0" style="width:50px;height:28px" value="1"> 
                	   <a class="btn btn-default" id="plus" style="width:37px"><i class="fa fa-plus"></i> </a>  
                	  </div>	  
                	  </div>
                	  <div class="col-md-1 col-sm-12 col-xs-12 form-group">
                	  <button class="btn btn-default" onclick="del_form()">删除</button>
                	  </div>            
               	    </div>

                    <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button id="calculate" class="btn btn-default">统计</button>
                      </div>
                    </div>
                
                  
                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">总金额<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="totalPrice" disabled="disabled" value="0" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                  
                                    
                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">实收金额<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="received" value="0" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                   <!-- -->
                  <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button id="confirm" class="btn btn-default">确认</button>
                      </div>
                    </div>
                     
                     <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">找零<span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="change" disabled="disabled" value="0" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                                        
                    <div class="ln_solid"></div>
                    <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button type="submit" class="btn btn-success">Submit</button>
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
  <!-- 计算总金额 -->
  <script> 
	totalPrice=0;
	change=0;
  $('#calculate').click(function() {

//	 	alert('');
 	 	 $('div[role="add-commodity-item"]').each(function(idx) {
	 		  quantity=$(this).children().children().children('#quantity').val();
	 		  price=$(this).children().children('#heard').find("option:selected").attr('price');		 
	 		 totalPrice = totalPrice + quantity*price;
	 	 });	 	
	  	$('#totalPrice').val(totalPrice)
	  return false;
});
  $('#confirm').click(function() {
//	 	alert('');
		received = $('#received').val();
		change=received-totalPrice;
	  	$('#change').val(change)
	  return false;
});
  </script>
  <script>
  
  //减少商品数量
  $('#minus').click(function() {
	  var quantity=$(this).parent().children('input').val();
		  //$('#quantity').val();
	 if(quantity==0){
		 alert('数量已经最低！');
	 }
	 else{
		// $('#quantity').attr('placeholder',parseInt(quantity)-1); 
		$(this).parent().children('input').val(parseInt(quantity)-1);
	 }
	  
  });
  //增加商品数量
  $('#plus').click(function() {
	  var max= $("#heard").find("option:selected").attr('storage');
	 var quantity=$(this).parent().children('input').val();
	 if(quantity<=max){
		//判断是否超过库存
		 $(this).parent().children('input').val(parseInt(quantity)+1);
	 }
	 else{
		 alert('超过库存数量');
	 }
  });
//增加一行产品
$('#addGoods').click(function(){
	  var content=$('#add');
	  content.after(content.clone(true));
	  return false;	
});
 //删除一行产品
   function del_form() {
	   var content=$('#add')
       content.remove();
	   return false;
  }
 
 var goodData = {};
 function getAllCommodity() {
	 $('div[role="add-commodity-item"]').each(function(idx) {
		 goodData['newConsume.consumeDetail['+idx+'].quantity']=$(this).children().children().children('#quantity').val();
		 goodData['newConsume.consumeDetail['+idx+'].goodsId']=$("#heard").find("option:selected").text();
	 });
 }
  

  $('#demo-form2').submit(function() {
	  getAllCommodity();
	  alert(totalPrice);		  
	  goodData['newConsume.totalPrice'] = totalPrice;
  
   		$.post('newConsume',
   				goodData,
   				function(data, status) {
   			//前往消费记录界面
   				 window.location.href="showStoreRecord"; 
   			
   		});   
   		return false;
   		
});
  </script>
  
</body>

</html>
