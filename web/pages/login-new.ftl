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

        <form action="loginCheck" method="post" class="ui form" id="login-form">
            <div class="ui segment">
                <div class="ui error message"></div>
                <div class="field">
                    <div class="ui fluid left icon input">
                        <input type="text" name="username" placeholder="用户名" autocomplete="off"/>
                        <i class="user icon"></i>
                    </div>
                </div>
                <div class="field">
                    <div class="ui fluid left icon input">
                        <input type="password" name="password" placeholder="密码" autocomplete="off"/>
                        <i class="lock icon"></i>
                    </div>
                </div>
                <input type="hidden" value="${captcha!''}"/>

                <button class="ui fluid green button" type="submit">登录</button>
            </div>

        </form>


    </div>

</div>
<script>
    loginform = $('#login-form');
    loginform.form({
        onSuccess: function () {
            loginform.addClass('loading');
            $.ajax({
                type: 'POST',
                url: '/loginCheck',
                data: loginform.serialize(),
                dataType: 'json',
                success: function (data) {
                    loginform.removeClass('loading');
                    if (data.success) {
                        window.location.href = "/success";
                    } else {
                        loginform.form('add errors', [data.message]);
                        loginform.form('clear');
                    }
                }
            });
            return false;
        }
    });

</script>

</body>
</html>