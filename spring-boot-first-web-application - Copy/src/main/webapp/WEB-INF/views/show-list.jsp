<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<html>
<head>
    <title>Home</title>

</head>
<body>

<span style="color:red"><i>Here are the list of students</i></span>

<div class="container">
    <div class="pull-right">
        <a href="/add" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Add Student</a>
    </div>

    <table class="table table-striped">
    <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.address}</td>
                <td>${student.email}</td>
                <td><a button class="btn btn-danger" href="/delete/${student.id}"><span class="glyphicon glyphicon-trash"></span></a>
                <a button class="btn btn-success" href="/edit/${student.id}"><span class="glyphicon glyphicon-pencil"></span></a> </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<%@include file="common/footer.jspf"%>
</body>
</html>