<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2020/5/21
  Time: 上午11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<h1>出错了!</h1>
${requestScope.exception.message}
</body>
</html>
