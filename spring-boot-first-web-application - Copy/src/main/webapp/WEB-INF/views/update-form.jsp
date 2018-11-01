<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<html>
<head>
    <title>Home</title>

</head>
<body>
<i>Fill out the forms. Asterik (*) measns required</i>
<div class="container">
<form:form method="post" modelAttribute="student" action="/update">

    <form:hidden path="id"/>

    <div class="form-group">
    <form:label path="name">Name(*)</form:label>
    <form:input path="name" type="text" class="form-control" name="name" placeholder="name"/>

    </div>

    <div class="form-group">
    <form:label path="address">Address</form:label>
    <form:input path="address" type="text" class="form-control" placeholder="address"/>
    </div>

    <div class="form-group">
    <form:label path="email">Email</form:label>
    <form:input path="email" class="form-control" placeholcer="email"/>
    </div>

    <input type="submit" class="btn btn-primary" value="Update Student"/>


</form:form>
</div>
<%@include file="common/footer.jspf"%>
</body>
</html>