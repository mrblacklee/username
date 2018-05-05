<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 学子商城</title>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="${pageContext.request.contextPath}/main/showIndex.do" class="acti">首页</a></li>
      <%--  <li><a href="index.html#computer" >电脑办公</a></li>
        <li><a href="index.html#stationery" >办公文具</a></li>--%>
    </ul>
</nav>
<!-- 我的订单导航栏-->
<%--<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>--%>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="left.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span >
            <a href="${pageContext.request.contextPath}/user/showPersonInfo.do">
                        我的信息
            </a></span>
            <span class="rs_header_active">
            <a href="${pageContext.request.contextPath}/user/showPassword.do">
                      安全管理
            </a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span>
                <input 
                type="password"
                name="oldPwd"
                id="oldPwd"/>
                <span 
                class="change_hint"
                id="oldPwdSpan"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span>
                <input 
                type="password"
                name="newPwd"
                id="newPwd"/>
                <span 
                class="change_hint"
                id="newPwdSpan"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span>
                <input 
                type="password"
                name="confirmPwd"
                id="confirmPwd"/>
                <span 
                class="confirm_hint"
                id="confirmPwdSpan"></span>
            </div>
            <div class="save_password">
            <a href="#" 
            style="color:#fff"
            onclick="changePassword()">保存更改</a>
            </div>
        </div>


    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript">
//定义ajax异步提交函数

function changePassword(){
	var oldPwdVal = $("#oldPwd").val();
	var newPwdVal = $("#newPwd").val();
	var confirmPwdVal = $("#confirmPwd").val();
	if(checkPasswordLength(oldPwdVal)&&
	   checkPasswordLength(newPwdVal)&&
	   checkPasswordLength(confirmPwdVal)&&
	   checkPasswordEquals()){
		//ajax提交
		$.ajax({
			"url":"${pageContext.request.contextPath}/user/password.do",
			"data":"oldPwd="+oldPwdVal+"&newPwd="+newPwdVal,
			"type":"POST",
			"dataType":"json",
			"success":function(obj){
				if(obj.state==0){
					alert(obj.message);
				}else{
					alert(obj.message);
					//清空文本框和span信息
					$("#oldPwd").val("");
					$("#newPwd").val("");
					$("#confirmPwd").val("");
					$("#oldPwdSpan").html("");
					$("#newPwdSpan").html("");
					$("#confirmPwdSpan").html("");
					
				}
			}
			
		});
		
	}
}


//验证密码的长度 6~9
function checkPasswordLength(pwd){
	
	return pwd.length>=6 && pwd.length<=9;
}
//验证新密码和确认密码是否一致
function checkPasswordEquals(){
	var newPwdValue=$("#newPwd").val();
	var confirmPwdValue = $("#confirmPwd").val();
	if(newPwdValue==confirmPwdValue){
		return true;
	}else{
		return false;
	}
}
//验证旧密码格式是否正确
$("#oldPwd").blur(function(){
	if(checkPasswordLength($("#oldPwd").val())){
		$("#oldPwdSpan").html("密码格式正确");
		$("#oldPwdSpan").css("color","green");
	}else{
		$("#oldPwdSpan").html("密码格式不正确");
		$("#oldPwdSpan").css("color","red");
	}
});
//验证新密码格式是否正确
$("#newPwd").blur(function(){
	if(checkPasswordLength($("#newPwd").val())){
		$("#newPwdSpan").html("密码格式正确");
		$("#newPwdSpan").css("color","green");
	}else{
		$("#newPwdSpan").html("密码格式不正确");
		$("#newPwdSpan").css("color","red");
	}
});
//验证确认密码格式是否正确
$("#confirmPwd").blur(function(){
	if(checkPasswordLength($("#confirmPwd").val())){
		$("#confirmPwdSpan").html("密码格式正确");
		$("#confirmPwdSpan").css("color","green");
		//验证确认密码和新密码是否一致
		if(checkPasswordEquals()){
			$("#confirmPwdSpan").html("两次输入的密码一致");
			$("#confirmPwdSpan").css("color","green");
		}else{
			$("#confirmPwdSpan").html("两次输入的密码不一致");
			$("#confirmPwdSpan").css("color","red");
		}
	}else{
		$("#confirmPwdSpan").html("密码格式不正确");
		$("#confirmPwdSpan").css("color","red");
	}
});

$(function(){
	//所有的dd隐藏
	 $("#leftsidebar_box dd").hide();
	//让账号管理显示
	 $("#leftsidebar_box .count_managment dd").show();
	//所有的自定义列表的标题后边的图片 myOrder2.png
	$("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
    //设置账号管理的图片和其他的三个不相同
	$("#leftsidebar_box .count_managment").find('img').attr("src","../images/myOrder/myOrder1.png");
     
});
</script>


</html>











