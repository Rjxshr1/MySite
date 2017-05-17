<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="/scripts/jquery.js" type="text/javascript"></script>
    <script src="/scripts/semantic.min.js" type="text/javascript"></script>
    <script src="/scripts/tqeditor/TQEditor.with-plugs.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/themes/semantic.min.css">
    <title>删除</title>

</head>
<body>
<div class="ui stackable middle aligned centered grid container">
    <div class="ui row" style="margin-top: 50px;">
        <div class="ui six wide column">
            <div class="ui centered header"><h1>发表留言</h1></div>
        </div>
    </div>

    <div class="ui ten wide column">

        <form action="/message/delete" method="post" class="ui form">
            <div class="ui segment">
                <div class="field">
                    <label>删除序号</label>
                    <div class="ui fluid input">
                        <input type="text" name="message.id" placeholder="请输入要删除的序号"/>
                    </div>
                </div>

                    <button class="ui fluid green button" type="submit">提交</button>
                </div>

        </form>
    </div>

</div>

</body>

</html>