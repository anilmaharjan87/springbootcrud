<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<html>
<head>
    <title>Home</title>

</head>
<body>
<p>Welcome mr. ${name}</p>
<p>
    <a href="/show-list">Click here to manage the student</a>
</p>
<%@include file="common/footer.jspf"%>
</body>
</html>