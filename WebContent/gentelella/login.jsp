
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

  <title>服务人员登录系统</title>

  <!-- Bootstrap core CSS -->

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/icheck/flat/green.css" rel="stylesheet">


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

<body style="background:#F7F7F7;">

  <div class="">
    <a class="hiddenanchor" id="toregister"></a>
    <a class="hiddenanchor" id="tologin"></a>

    <div id="wrapper">
      <div id="login" class="animate form">
        <section class="login_content">
          <div id="login-form">
            <h1>服务人员登陆系统</h1>
            <div>
              <input type="text" class="form-control" id="userName" placeholder="用户名" required="" />
            </div>
            <br>
            <div>
              <input type="password" class="form-control" id="password" placeholder="密码" required="" />
            </div>
            <div>
            <br>
              <a class="btn btn-default submit" href="">登陆</a>

            </div>
            <div class="clearfix"></div>
            <div class="separator">
              <div class="clearfix"></div>
              <br />
            </div>
          </div>
          <!-- form -->
        </section>
        <!-- content -->
      </div>

    </div>
  </div>

</body>
<script>
$('.submit.btn').click(function() {
	
	name=$('#userName').val();
	password=$('#password').val();
	
	if(name=="manager"){
		window.location.href="managerLogin"; 
	}
	else if(name=="admin"){
		window.location.href="showStoreInfo"; 
	}
	else{
				
		$.ajax({
			type : "post", //请求方式
			url : "staffLogin", //发送请求地址
			data : {
				waiterID:name,
				password:password,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
			    window.location.href="staffChoose"; 
			}
		});	
}
	return false;

});
</script>

</html>
