<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Jboot Fly 社区</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="jboot,jbootfly,jboot社区,jpress">
    <meta name="description" content="Jboot，专为大型分布式项目和微服务而生，她是一个基于JFinal 和 Undertow开发的微服务框架。">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${base}/static/css/global.css">
    <link rel="stylesheet" href="${base}/static/css/page.css">
</head>
<body>
<#include "../share/top.ftl">


<div class="layui-container fly-marginTop fly-user-main">

     <#include "../share/leftul.ftl">

    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this" lay-id="info">激活账号</li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <form class="layui-form layui-form-pane layui-tab-item layui-show" method="post" action="/api/doActive">
                    <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_email" name="email" value="" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit>确认激活该账号</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</div>








<div class="fly-footer">
    <p><a href="http://jboot.io/" target="_blank">JBoot Fly 社区</a> 2018 &copy; <a href="http://jboot.io"  target="_blank"> Jboot.io</a></p>
</div>
<script src="${base}/static/layui/layui.js"></script>

<script>
    $("ul.layui-nav-tree .layui-nav-item:last").addClass("layui-this");
    layui.cache.page = 'user';
    layui.cache.user = {
        username: 'admin'
        ,uid: 'e90c553ebbd848519c7606d50eab8b6c'
        ,avatar: '/static/images/touxiang.jpg'
        ,experience: 83
        ,sex: '男'
    };
    layui.config({
        version: "3.0.0"
        ,base: '/static/mods/'
    }).extend({
        fly: 'index'

    }).use(['fly', 'face'], function(){
        var $ = layui.$
                ,fly = layui.fly;
        //如果你是采用模版自带的编辑器，你需要开启以下语句来解析。
    });
</script>
</body>
</html>