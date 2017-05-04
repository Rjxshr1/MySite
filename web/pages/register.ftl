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
<div class="ui centered grid container">
    <div class="six wide column">
        <div class="ui header">
            <h1>注册</h1>
        </div>
        <div class="ui segment">
            <form class="ui fluid form" id="register-form">
                <div class="ui success message" id="success-message">
                    <i class="close icon"></i>
                    <div class="header">
                        注册成功
                    </div>
                    <p>你可以使用注册的用户名登录了</p>
                </div>
                <div class="ui error message"></div>
                <div class="field">
                    <label>用户名</label>
                    <input type="text" class="ui fluid input" name="user.username" autocomplete="off"
                           placeholder="请输入用户名">
                </div>
                <div class="field">
                    <label>密码</label>
                    <input type="password" class="ui fluid input" name="user.password" autocomplete="off"
                           placeholder="请输入密码">
                </div>
                <div class="field">
                    <label>重复密码</label>
                    <input type="password" class="ui fluid input" name="password2" autocomplete="off"
                           placeholder="请重复输入密码">
                </div>
                <button class="ui fluid blue button" id="btn-register">注册</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $('#register-form').form({
        fields: {
            username: {
                identifier: 'user.username',
                rules: [{
                    type: 'minLength[5]',
                    prompt: '用户名至少为5位'
                }]
            },
            password: {
                identifier: 'user.password',
                rules: [{
                    type: 'minLength[6]',
                    prompt: '密码至少为6位'
                }]
            },
            password2: {
                identifier: 'password2',
                rules: [{
                    type: 'match[user.password]',
                    prompt: '两次密码不一致'
                }]
            }

        },

        onSuccess: function (obj) {
            var f = $(this).addClass('loading');
            $.ajax({
                type: 'POST',
                url: '/doregister',
                data: $('#register-form').serialize(),
                dataType: 'json',
                success: function (data) {
                    f.removeClass('loading');
                    if(data.success) {
                        f.form("reset");
                        $('#success-message').show();
                    }else{
                        f.form("add errors", [data.message]);
                        f.form("clear");
                    }
                }

            });
            return false;
        }
    });

    $('#success-message .close').click(
            function () {
                $(this).closest('.message').transition('fade');
            });


</script>
</html>