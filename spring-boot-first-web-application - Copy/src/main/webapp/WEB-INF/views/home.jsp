<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Home</title>
</head>
<body>

<p>Welcome to our company! mr ${name}.<a href="/show-list"> click here </a>to manage students </p>
User:<security:authentication property="principal.username"/>
Roels(s):<security:authentication property="principal.authorities"/>
<br>
<hr>




<security:authorize access="hasRole('MANAGER')">
<p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
    (only for managers)

</p>
</security:authorize>





<security:authorize access="hasRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/systems">Admin Page</a>
</p>
</security:authorize>

<%@include file="common/footer.jspf"%>
</body>
</html>