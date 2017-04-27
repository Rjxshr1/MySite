<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="/scripts/jquery.js" type="text/javascript"></script>
    <script src="/scripts/semantic.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/themes/semantic.min.css">
    <title>登录</title>

</head>
<body>
<div class="ui stackable middle aligned centered grid container">
    <div class="ui row" style="margin-top: 50px;">
        <div class="ui six wide column">
            <div class="ui centered header"><h1>登录</h1></div>
        </div>
    </div>

    <div class="ui six wide column">
        <div class="ui segment">

            <form class="ui fluid form" id="register-form">
                <div class="ui error message">a</div>
                <div class="field"><label>用户名</label><input type="text" name="user.username" class="ui input"
                                                            placeholder="请输入用户名"></div>
                <div class="field"><label>密码</label><input type="password" name="user.password" class="ui input"></div>
                <div class="field"><label>重复密码</label><input type="password" name="repeatpwd" class="ui input">
                </div>
                <button class="ui fluid blue button" id="btn-register">注册</button>
            </form>

        </div>


    </div>

</div>

</body>
<script>
    var f = $("#register-form").form({
        on: 'blur',
        fields: {
            username: {
                identifier: "user.username",
                rules: [{
                    type: "empty",
                    prompt: "用户名不能为空"
                }]
            },
            password: {
                identifier: "user.password",
                rules: [{
                    type: "minLength[8]",
                    prompt: "密码至少为8位"
                }]
            },
            repeatpwd: {
                identifier: "repeatpwd",
                rules: [{
                    type: "match[user.password]",
                    prompt: "密码不一致"
                }]
            }
        }
    });
    $("#btn-register").click(function () {
        f.form("validate form");

    });
</script>
</html>