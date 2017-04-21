<#-- @ftlvariable name="categories" type="java.util.List<my.model.Category>" -->
<#-- @ftlvariable name="category" type="my.model.Category" -->
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
    <a class="item">
        <i class="home icon" href="/admin">
        </i>
        主页
    </a>
    <a class="active item" href="/admin/category">
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
        <#if errorMsg?exists>
            <div class="ui error message">${errorMsg}!</div>
        </#if>


            <div class="ui buttons">
                <button class="ui blue button" id="btn-add"><i class="add icon"></i>增加分类</button>
            </div>
            <table class="ui selectable celled table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list categories as category>
                <tr>
                    <td>${category.id!''}</td>
                    <td>${category.name}</td>
                    <td>
                        <i class="edit icon"></i>编辑

                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="ui  modal" id="add-dialog" style="width:350px">

            <div class="ui header">添加分类</div>
            <div class="content">

                <form action="/admin/category/save" class="ui fluid error form" id="category-add-form">
                    <div class="ui error message"></div>
                    <div class="field">
                        <label>名称</label>
                        <div class="ui fluid input">
                            <input type="text" name="category.name" autocomplete="off">
                        </div>
                    </div>
                </form>

            </div>
            <div class="actions">
                <div class="ui ok red button">添加</div>
                <div class="ui cancel blue button">取消</div>
            </div>
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
    $('#btn-add').click(function () {
        $('#add-dialog').modal('show');
    });

    $('#category-add-form').form({
        fields: {
            category_name: {
                identifier: 'category.name',
                rules: [{
                    type: 'empty',
                    prompt: '名字不能为空'
                }]
            }
        }
    });


    $('#add-dialog').modal({
        closable: true,
        onApprove: function () {
            $('#category-add-form').form('validate form');
            if ($('#category-add-form').form('is valid')) {
                $('#category-add-form').form('submit');
            } else {
                return false;
            }
        }
    });
</script>
</html>
