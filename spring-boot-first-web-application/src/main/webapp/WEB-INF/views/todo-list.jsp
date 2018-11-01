<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>First Web application</title>
    <!--<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<p>Here are your todo lists! mr.${name}</p>
<div class="container">
<table class="table table-striped">
    <thead>
    <tr>
        <th>id</th>
        <th>user</th>
        <th>description</th>
        <th>date</th>
        <th>isDone</th>
        <td>action</td>
    </tr>
    </thead>
    <tbody>
<c:forEach var="todo" items="${todos}">
    <tr>
        <td>${todo.id}</td>
        <td>${todo.user}</td>
        <td>${todo.desc}</td>
        <td>${todo.targeDate}</td>
        <td>${todo.done}</td>
        <td><a type="button" class="btn btn-warning" href="/delete-todo/${todo.id}">Delete</a></td>

      <!--  <td><a type="button" class="btn btn-warning" href="/delete-todo?id={todo.id}">Delete</a></td> -->
    </tr>
</c:forEach>
    </tbody>

</table>
<div>
    <a class="button button-bar" href="/add-todo">Add a todo</a>
</div>



<!--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</div>
</body>
</html>