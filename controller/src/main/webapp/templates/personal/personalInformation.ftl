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

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>


    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user" id="LAY_msg" style="margin-top: 15px;">
            <button class="layui-btn layui-btn-danger" id="deleteAll">清空全部消息</button>
            <div  id="LAY_minemsg" style="margin-top: 10px;">

                <ul class="mine-msg">

                        <#list pageInfo.list as roles>
                            <li data-id="${roles.id}">
                                <blockquote class="layui-elem-quote">
                                    <a href="/role/user/${roles.us.id}" target="_blank"><cite>${roles.us.nickname}</cite></a>回答了您的帖子<a target="_blank" href="/post/${roles.ps.id}"><cite>${roles.ps.title}</cite></a>
                                </blockquote>
                                <p><span>${roles.timeDifferencel}前</span><a href="/role/messageDel/${roles.id}?pn=${pageInfo.pageNum}&total=${pageInfo.total}&pageSize=${pageInfo.pageSize}" class="layui-btn layui-btn-small layui-btn-danger messageDel">删除</a></p>
                            </li>
                        </#list>

                </ul>

                <div style="text-align: center">
                    <ul class="page" maxshowpageitem="3" pagelistcount="${pageInfo.pageSize}"  id="page"></ul>
                </div>

                <script type="text/javascript">
                    var GG = {
                        "kk":function(mm){
                            //链接地址
                            window.location.href="/role/personalInformation?pn="+mm;
                        }
                    }
                    $("#page").initPage(${pageInfo.total},${pageInfo.pageNum},GG.kk);
                    // 总条数  当前页
                </script>


            </div>
        </div>
    </div>

</div>




<div class="fly-footer">
    <p><a href="http://jboot.io/" target="_blank">JBoot Fly 社区</a> 2018 &copy; <a href="http://jboot.io"  target="_blank"> Jboot.io</a></p>
</div>
<script src="${base}/static/layui/layui.js"></script>

<script>

    //deleteAll
    layui.use('layer', function(){


        $("#deleteAll").click(function () {
            layer.confirm("你确定全部删除吗？", {
                btn: ['确定','取消'] //按钮
            }, function(){

                    location.href="/role/deleteAllMessage";

            }, function(){

            });
        });



    })

    $("ul.layui-nav-tree .layui-nav-item:eq(3)").addClass("layui-this");
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