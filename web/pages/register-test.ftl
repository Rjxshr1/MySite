<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册新用户</title>
</head>
<body>
<form action="/doregister" method="post">
   用&nbsp;户&nbsp;名：<input type="text" name="username" autocomplete="off" placeholder="请输入用户名"><br>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" autocomplete="off" placeholder="请输入密码"><br>
    重复密码：<input type="password" name="password2" autocomplete="off" placeholder="请重复输入密码"><br>
    <button type="submit">注册</button>
</form>
</body>
</html>