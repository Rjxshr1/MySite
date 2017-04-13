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
    <title>留言列表</title>

</head>
<body>
<div class="ui stackable middle aligned centered grid container">
    <div class="ui centered row" style="margin-top: 50px;">
        <div class="four wide column">
            <div class="ui header"><h1>留言列表</h1></div>
        </div>
    </div>
    <div class="fourteen wide column">
        <table class="ui celled striped table" id="message-tables">
            <thead>
            <tr>
                <th>编号</th>
                <th>用户</th>
                <th class="ten wide">内容</th>
                <th>发表时间</th>
            </tr>
            </thead>
            <tbody>
            <#if messages??>
                <#list messages! as message>
                <tr>
                    <td>${message.id!''}</td>
                    <td>${message.author!''}</td>
                    <td>${message.content!''}</td>
                    <td>${message.pubdate!''}</td>
                </tr>
                </#list>
            </#if>
            </tbody>
        </table>

    </div>
</div>
</body>

</html>