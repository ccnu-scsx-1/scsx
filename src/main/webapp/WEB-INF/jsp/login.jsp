<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<title>系统登陆</title>
<meta charset="utf-8">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<%=request.getContextPath() %>/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/static/js/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
  type="text/css">
<link href="<%=request.getContextPath() %>/static/css/login.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/static/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/js/jUtil.js" type="text/javascript"></script>
</head>
<body>
  <div id='header' class='clearfix'>
    <div id='logo'></div>
    <h1 id='title' style="color: #00BFFF">管理系统</h1>
  </div>
  <div id='main'>
    <div id='login-frame' class='clearfix'>
      <div id='picture'></div>
      <div id='input-form'>
        <p id='login-text'>管理员登录</p>
        <p id='error-info' class='alert alert-danger' style='display: none'></p>
        <form id='login-form' method="post" action="<%=request.getContextPath()%>/scsx/register">
          <div class="form-group">
            <label for="exampleInputEmail1">帐&nbsp;&nbsp;&nbsp;号:</label> <input type="text" class="form-control"
              id="email" name="name" placeholder="您的邮箱地址" /> <span class='clear'></span>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">密&nbsp;&nbsp;&nbsp;码:</label> <input type="password" class="form-control"
              name="password" id="password" /> ${requestScope.errorMsg }
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">age</label> <input type="password" class="form-control"
              name="password" id="password" /> ${requestScope.errorMsg }
          </div>
          <button id='login-button' class='btn btn-danger' type='submit'>登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
        </form>
      </div>
    </div>
  </div>
  <div id='footer'>
    <p id='copyright'>Copyright©2017 Joban Inc. All rights reserved</p>
    <div id='foot-img'>
      <div></div>
</body>
<script type="text/javascript">
	
</script>
</html>