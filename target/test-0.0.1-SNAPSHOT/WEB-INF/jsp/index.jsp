<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
 uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head lang="cn">
    <meta charset="UTF-8">
    <title>学子商城首页</title>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/slide.css" rel="stylesheet"/>
    </head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<div>
    <table width="600px" heigth="500px" border="2px" cellpadding="10px"  style="margin:150px auto;font-size: 15%">
        <tr>
            <td>Id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>电话</td>
            <td>邮箱</td>
            <td>性别</td>
        </tr>
        <c:forEach items="${list}" var="l" varStatus="s">
            <tr>
                <td>${l.id}</td>
                <td>${l.username}</td>
                <td>${l.password}</td>
                <td>${l.phone}</td>
                <td>${l.email}</td>
                <td>${l.gender}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div height="600px" style="margin-left:600px;padding-top: 20px;font-size: 20px">当前第 页.总共 页.一共 条记录</div>
<div style="margin-left:600px">
    <ul>
        <li style="padding-top: 5px;font-size: 20px"><a href="#">上一页</a></li>
        <li style="padding-top: 5px;font-size: 20px" ><a href="${pageContext.request.contextPath}/user/.do">下一页</a></li>
    </ul>
</div>



<%--<div>
    <div>当前第 ${pageInfo.pageNum}页.总共 ${pageInfo.pages}页.一共 ${pageInfo.total}条记录</div>
    <div>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/list?pn=1">首页</a> </li>
                <li>
                    <c:if test="${pageInfo.hasPreviousPage}"><a href="${pageContext.request.contextPath}/list?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true"></span>
                    </a>
                    </c:if>
                </li>
               &lt;%&ndash; <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                    <c:if test="${page_num==pageInfo.pageNum}">
                        <li><a href="#">${page_num}</a></li>
                    </c:if>
                    <c:if test="${page_num !=pageInfo.pageNum}">
                        <li><a href="${pageContext.request.contextPath}/list?pn=${page_num}">${page_num}</a></li>
                    </c:if>
                </c:forEach>&ndash;%&gt;
                <li>
                    <c:if test="${pageInfo.hashNextPage}">
                        <a href="${pageContext.request.contextPath}/list?pn=${pageInfo.pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">»</span>
                    </a>
                    </c:if>
                </li>
                <li><a href="${pageContext.request.contextPath}/list?pn=${pageInfo.pages}">尾页</a></li>
            </ul>
        </nav>
    </div>
</div>--%>
</body>
</html>