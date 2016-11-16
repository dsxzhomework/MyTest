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
                  <img src="images/img.jpg" alt=""> 总店服务员
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
                  <h2>制定 ${name} 产品计划</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                 <table id="example" listSize="${sumbitedDays }"  class="table table-striped responsive-utilities jambo_table">
                    <thead>
                      <tr class="headings">
                        <th>店铺名称 </th>
                        <th>计划日期</th>
                         <th>删除</th>
                        <th class=" no-link last"><span class="nobr">查看详情</span>
                        </th>
                      </tr>
                    </thead>

                    <tbody>
                    <s:iterator id="item" value="pageDataList">


                      <tr class="even pointer">
                        <td class=" "> ${name} </td>
                        <td class=" "><s:property value="#item.date"/></td>
                        <td class="" date='<s:property value="#item.date"/>'>
                        <a class="delete" date='<s:property value="#item.date"/>' href="#">删除</a></td>
                        <td class="last"><a class="seeDetail" date='<s:property value="#item.date"/>' href="">查看详情</a>
                        </td>
                      </tr>
   					</s:iterator>                  
                 </tbody>

                  </table>                   
                    <div class="ln_solid"></div>   
                              
                  <br>
                  <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left">
                   
                    
                   <div class="form-group" id="date" style="display:block">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">日期*:</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
	                 <select id="dateChoose" class="form-control">  
   					<s:iterator id="item" value="timeList">
						<option ><s:property value="#item"/></option>
   					</s:iterator>                            

                        </select>
                    </div>
                    </div>
                                        
                     <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button class="btn btn-default add_button">添加产品</button>
                      </div>
                    </div>                  
                    
                    <div class="form-group" id="add" role="add-commodity-item">
                   <label class="control-label col-md-2 col-sm-3 col-xs-12" for="first-name">产品编号<span class="required">*</span></label>
                	<div class="col-md-3 col-sm-12 col-xs-12 form-group">
                      <select id="goodsChoose" class="form-control">
   					<s:iterator id="item" value="goodsList">
						<option value='<s:property value="#item.productId"/>'><s:property value="#item.productName"/></option>
   					   </s:iterator>                            

                        </select>
                	</div> 
                	           	 
                	  <div class="col-md-2 col-sm-12 col-xs-12 form-group">
                	  <div class="row">
                	  <a class="btn btn-default" id="minus" style="width:37px"><i class="fa fa-minus"></i></a>
                	  <input type="text" id="quantity" style="width:50px;height:28px" value="1"> 
                	   <a class="btn btn-default" id="plus" style="width:37px"><i class="fa fa-plus"></i> </a>  
                	  </div>	  
                	  </div>
                	  
                	  <div class="col-md-2 col-sm-12 col-xs-12 form-group">
						<input type="text" class="form-control has-feedback-left" id="price">
						<span class="fa fa-cny form-control-feedback left" aria-hidden="true"></span>
                	  </div>
                	  <div class="col-md-1 col-sm-12 col-xs-12 form-group">
                	  <button class="btn btn-default" onclick="del_form()">删除</button>
                	  </div>            
               	    </div>                 
                                     
                    <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button type="submit" class="btn btn-success">日计划提交</button>
                      </div>
                    </div>
                    <div class="ln_solid"></div>                   
                  </form>
                 <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-8">
                        <button type="submit" id="weekSubmit" class="btn btn-dark">完整周计划提交</button>
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


  <!-- Datatables -->
  <script src="js/datatables/js/jquery.dataTables.js"></script>
  <script src="js/datatables/tools/js/dataTables.tableTools.js"></script>

  <!-- pace -->
  <script src="js/pace/pace.min.js"></script>

  <script>
//删除当日计划
$('.delete').click(function() {
	  var date=$(this).attr('date');
	  alert(date);
		$.ajax({
			type : "post", //请求方式
			url : "deleteDetail", //发送请求地址
			data : {
				date:date,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="ShowStaffSchedule"; 
			}
		});		
		return false;
  }); 
//查看计划详情
  $('.seeDetail').click(function() {
	  var date=$(this).attr('date');
	  alert(date);
	  
		$.ajax({
			type : "post", //请求方式
			url : "searchDetail", //发送请求地址
			data : {
				date:date,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="showDetail"; 
			}
		});		
		return false;
  });
  
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
	  
	 var quantity=$(this).parent().children('input').val();
	 if(false){
		//判断是否超过库存
	 }
	 else{
		 $(this).parent().children('input').val(parseInt(quantity)+1);
	 }
  });
  $('.add_button').click(function(){
	  add_form();
	  return false;
  });
//增加一行产品
  function add_form(){

	  var content=$('#add');
	  content.after(content.clone(true));
};
 //删除一行产品
   function del_form() {
	   var content=$('#add')
       content.remove();
	   return false;
  }

 
 var goodData = {};
 function getAllCommodity() {
	 $('div[role="add-commodity-item"]').each(function(idx) {
		 goodData['data.goodsDetail['+idx+'].quantity']=$(this).children().children().children('#quantity').val();
		 goodData['data.goodsDetail['+idx+'].goodsId']=$(this).children().children('#goodsChoose').find("option:selected").attr('goodsId');
		 goodData['data.goodsDetail['+idx+'].price']=$(this).children().children('#price').val(); 
		 goodData['data.goodsDetail['+idx+'].date']=$("#dateChoose").find("option:selected").text();
	 });
 }
  
  $('#demo-form2').submit(function() {
	  getAllCommodity();
	  
	  var date=$("#dateChoose").find("option:selected").text();
	  
	  goodData['data.date'] = date;

	  
   		$.post('newDaySchedule',
   				goodData,
   				function(data, status) {
   			 window.location.href="ShowStaffSchedule"; 
   		});   
   		return false; 
   		
});
  //提交完整周计划
    $('#weekSubmit').click(function() {
	  var listSize=$('#example').attr('listSize');
	   
 	  if(listSize==7){
		  window.location.href="weekSubmited";  
	  }
	  else{
		  alert('周计划未完整填写，请完整填写再提交');
	  } 

		return false;
  });
  </script>
  
</body>

</html>
