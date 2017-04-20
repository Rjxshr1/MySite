<!DOCTYPE html>
<html>
<head>
    <title>
    <@block name="title"></@block>
    </title>
    <meta charset="utf-8"/>
    <script src="/scripts/jquery.js" type="text/javascript">
    </script>
    <script src="/scripts/semantic.min.js" type="text/javascript">
    </script>
    <link href="/themes/semantic.min.css" rel="stylesheet">
    </link>
<@block name="head"></@block>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0" name="viewport">
    </meta>
</head>
<body>
<@block name="sidebar">
<div class="ui left vertical labeled icon menu sidebar" id="sidebar">
    <a class="item">
        <i class="book icon">
        </i>
        分类管理
    </a>
    <a class="item">
        <i class="write icon">
        </i>
        添加文章
    </a>
    <a class="item">
        <i class="configure icon">
        </i>
        系统设置
    </a>
    <a class="item">
        <i class="power icon">
        </i>
        退出系统
    </a>
</div>
</@block>
<div class="ui pusher">
    <div class="ui attached top inverted red menu" id="nav-menu">
        <a class="item toggler">
            <i class="sidebar icon">
            </i>
        </a>
        <div class="menu right">
            <a class="item">
                <i class="user icon"></i>Admin
            </a>
        </div>
    </div>
    <div class="ui grid container" id="content" style="min-height:670px;">
    <@block name="content">

    </@block>
    </div><!--end of content-->
    <div class="ui vertical footer segment " id="footer">
    <@block name="footer">
        <div class="ui container">
            copyrigth
        </div>
    </@block>
    </div>
</div>
</body>
<script>
    $('.toggler').on('click', function () {
        $('#sidebar').sidebar('toggle');
    });
</script>
</html>
