<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="top" class="fixed_nav">
    <div id="top_input" class="lf">
        <input 
        id="input" 
        type="text" 
        placeholder="请输入您要搜索的内容"
        style="width:350px"/>
        <a href="search.html" class="rt"><img id="search" src="${pageContext.request.contextPath}/images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
            <li><a href="${pageContext.request.contextPath}/user/showPassword.do">${user.username}</a></li>
           <c:if test="${user==null}">
           <li><a href="${pageContext.request.contextPath}/user/showLogin.do">登录</a></li>
           </c:if>
            <c:if test="${user!=null}">
           <li><a href="${pageContext.request.contextPath}/user/exit.do">退出</a></li>
           </c:if>

        </ul>
    </div>
</header> 