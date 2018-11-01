<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<html>
<head>
    <title>Home</title>

</head>
<body>
<p>Here are the list of students</p>

<div class="container">

    <form method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="Address">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Email">
        </div>

        <input type="submit" class="btn btn-primary" value="Add Student"/>
    </form>

</div>

<%@ include file="common/footer.jspf"%>
</body>
</html>