<!DOCTYPE html>
<html>
<head>
    <title>
    </title>
    <meta charset="utf-8"/>
    <script src="/scripts/jquery.js" type="text/javascript">
    </script>
    <script src="/scripts/semantic.min.js" type="text/javascript">
    </script>
    <link href="/themes/semantic.min.css" rel="stylesheet">
    </link>
    <link rel="stylesheet" href="/themes/admin.css" rel="stylesheet">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0" name="viewport">
    </meta>
</head>
<body>
<body>
<div class="ui left vertical labeled icon menu sidebar" id="sidebar">
    <a class="active item" href="/admin">
        <i class="home icon">
        </i>
        主页
    </a>
    <a class="item" href="/admin/category">
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
<div class="ui pusher">
    <div class="ui attached top inverted red menu" id="nav-menu">
        <a class="item toggler">
            <i class="sidebar icon">
            </i>
        </a>
        <div class="menu right">
            <a class="item">
                <i class="mail icon">
                </i>
                5条消息
            </a>
            <a class="ui dropdown item">
                <div class="text">
                    <i class="user icon">
                    </i>
                    Admin
                </div>
                <i class="dropdown icon">
                </i>
                <div class="ui menu">
                    <div class="item">
                        用户信息
                    </div>
                    <div class="item">
                        退出登录
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div class="ui grid container" id="content">
        <div class="fourteen wide column">
            <h2 class="primary header">
                后台管理
            </h2>
            <div class="ui horizontal header divider">
                <i class="user icon">
                </i>
                统计信息
            </div>
            <div class="ui statistics">
                <div class="statistic">
                    <div class="value">
                        5
                    </div>
                    <div class="label">
                        主题
                    </div>
                </div>
                <div class="statistic">
                    <div class="value">
                        40
                    </div>
                    <div class="label">
                        文章
                    </div>
                </div>
                <div class="statistic">
                    <div class="value">
                        343
                    </div>
                    <div class="label">
                        评论
                    </div>
                </div>
            </div>
            <div class="ui horizontal header divider">
                <i class="user icon">
                </i>
                服务器信息
            </div>
        </div>
    </div>
    <div class="ui attached bottom vertical footer inverted segment" id="footer">
        <div class="ui center aligned container">
            &copy 2017 宁夏大学
        </div>
    </div>
</div>
</body>
<script>
    $('.toggler').on('click', function () {
        $('#sidebar').sidebar('toggle');
    });
</script>
</html>
