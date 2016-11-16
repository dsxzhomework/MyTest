<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-e
  quiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>甜品屋会员系统</title>

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

<body style="background:#F7F7F7;background-image:url('images/background.jpeg');">

  <div class="">
    <a class="hiddenanchor" id="toregister"></a>
    <a class="hiddenanchor" id="tologin"></a>

    <div id="wrapper">
      <div id="login" class="animate form">
        <section class="login_content">
          <form>
            <h1>会员登录</h1>
            <div>
              <input type="text" class="form-control" id="loginNum" placeholder="手机号或会员卡号" />
            </div>
            <br>
            <div>
              <input type="password" class="form-control" id="loginPassword" placeholder="登录密码"/>
            </div>
            <div>
            <br>
              <a class="btn btn-default submit" id="confirmLogin">登录</a>
            </div>
            <div class="clearfix"></div>
            <div class="separator">

              <p class="change_link">新用户？
                <a href="#toregister" class="to_register">注册</a>
              </p>
              <div class="clearfix"></div>
              <br />
            </div>
          </form>
          <!-- form -->
        </section>
        <!-- content -->
      </div>
      <div id="register" class="animate form">
        <section class="login_content">
          <form>
            <h1>会员注册</h1>
            <div>
              <input type="text" class="form-control" placeholder="姓名" id="registerName" />
            </div>
            <div>
              <input type="text" class="form-control" placeholder="手机号" id="registerNum" data-inputmask="'mask': '9999-9999-999'"/>
            </div>
            <div>
              <input type="password" class="form-control" placeholder="密码" id="registerPassword" />
            </div>
            <div>
              <a class="btn btn-default submit" id="confirmRegister" >注册</a>
            </div>
            <div class="clearfix"></div>
            <div class="separator">

              <p class="change_link">已有账号？
                <a href="#tologin" class="to_register"> 登录 </a>
              </p>
              <div class="clearfix"></div>
            </div>
          </form>
          <!-- form -->
        </section>
        <!-- content -->
      </div>
    </div>
  </div>

</body>
   <!-- input mask -->
 <script src="js/input_mask/jquery.inputmask.js"></script>
   <script src="js/toaster.js"></script>
  <script>$('#invokesToastMessage').click(function(){});</script>
  
<script>
$('#confirmLogin').click(function() {
	
	name=$('#loginNum').val();
	password=$('#loginPassword').val();

	if(name.length > 0 && password.length > 0){
 		$.ajax({
			type : "post", //请求方式
			url : "memberLogin", //发送请求地址
			data : {
				loginName:name,
				loginPassword:password,
			//发送给数据库的数据
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
				toastr.success("登录成功，马上跳转");
			    window.location.href="showMemberMain"; 
			}
		});	 
	}
	else{
		toastr.warning("用户名和密码不能为空");	

}
	return false;

});
//注册
$('#confirmRegister').click(function() {
	
	name=$('#registerName').val();
	password=$('#registerPassword').val();
	phoneNum=$('#registerNum').val();
	

 	if(phoneNum.substr(12) == '_'){
 		toastr.warning("手机号格式错误");
	} 
 	else{
		var phoneNumRe = phoneNum.substring(0,4)+phoneNum.substring(5,9)+phoneNum.substring(10,13);
		if(name.length > 0 && password.length > 0 && phoneNumRe.length > 0){
			 	 		$.ajax({
							type : "post", //请求方式
							url : "memberRegister", //发送请求地址
							data : {
								registerName:name,
								registerPassword:password,
								registerPhoneNum:phoneNumRe,
							//发送给数据库的数据
							},
							//请求成功后的回调函数有两个参数
							success : function(data, textStatus) {
								
							    window.location.href="memberLogin.jsp"; 
							}
							
						});	  
				 		 toastr.success("注册成功，请用手机号登录");
				 		//alert('注册成功，请用手机号登录！');
				}
				else{
						toastr.warning("不能有空项");

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
