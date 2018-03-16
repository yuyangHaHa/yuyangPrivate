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
</head>
<body>
<#include "../share/top.ftl">

<div class="fly-home fly-panel" style="background-image: url();">
    <img src="${kehu.avatar!'/static/images/touxiang.jpg'}" alt="">
    <h1>
      ${kehu.nickname!''}
    </h1>

    <p style="padding: 10px 0; color: #5FB878;">
    </p>

    <p class="fly-home-info">
        <i class="layui-icon" style="color: #FF7200;">&#xe62b;</i>  <span style="color: #FF7200;">${kehu.point!0} 元宝</span>
        <i class="iconfont icon-shijian"></i><span>${kehu.created?string('yyyy-MM-dd')} 加入</span>
        <i class="iconfont icon-chengshi"></i><span>博客：${kehu.weibo!''}</span>
    </p>

    <p class="fly-home-sign">个人签名：${kehu.signature!''}</p>

    <div class="fly-sns" data-user="">
        <a href="javascript:;" class="layui-btn layui-btn-primary fly-imActive" data-type="addFriend">加为好友</a>
        <a href="javascript:;" class="layui-btn layui-btn-normal fly-imActive" data-type="chat">发起会话</a>
    </div>

</div>

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6 fly-home-jie">
            <div class="fly-panel">
                <h3 class="fly-panel-title">${kehu.nickname} 最近的发布</h3>
                <ul class="jie-row">

                    <#list listPost as post>
                        <li>
                            <span class="fly-jing">精</span>
                            <a href="/post/${post.id}" class="jie-title">${post.title}</a>
                            <i>刚刚</i>
                            <em class="layui-hide-xs">6阅 / 6答</em>
                        </li>
                    </#list>


                </ul>
            </div>
        </div>

        <div class="layui-col-md6 fly-home-da">
            <div class="fly-panel">
                <h3 class="fly-panel-title">admin 最近的动态</h3>
                <ul class="home-jieda">

                    <#list userActions as actions>
                        <#if actions.action=='new_post'>
                        <li>
                            <p>
                                <span>${actions.created?string("yyyy-MM-dd HH:mm:ss")}</span>
                                发布了帖子<a href="/post/${actions.ps.id}" target="_blank">${actions.ps.title}</a>，打赏${actions.point}个元宝。
                            </p>
                        </li>
                        <#elseif actions.action=='new_comment'>
                        <li>
                            <p>
                                <span>${actions.created?string("yyyy-MM-dd")}</span>
                                在<a href="/post/${actions.ps.id}" target="_blank">${actions.ps.title}</a>中回答：
                            </p>
                            <div class="home-dacontent">
                                ${actions.cm.content}
                            </div>
                        </li>
                        <#elseif actions.action=='finished_post'>
                        <li>
                            <p>
                                <span>${actions.created?string("yyyy-MM-dd")}</span>
                                结帖了<a href="/post/${actions.ps.id}" target="_blank">${actions.ps.title}</a>，获得${actions.point}元宝。
                            </p>
                        </li>
                        <#elseif actions.action=='comment_adopted'>
                        <li>
                            <p>
                                <span>${actions.created?string("yyyy-MM-dd")}</span>
                                在帖子<a href="/post/${actions.ps.id}" target="_blank">发帖的信息</a>，回答被采纳了，获得${actions.point}元宝。
                            </p>
                        </li>
                        <#else>
                        <li>
                            <p>
                                <span>${actions.created?string("yyyy-MM-dd")}</span>
                                进行签到了，获得了${actions.point}个元宝。
                            </p>
                        </li>
                        </#if>
                    </#list>



                </ul>
            </div>
        </div>
    </div>
</div>




<div class="fly-footer">
    <p><a href="http://jboot.io/" target="_blank">JBoot Fly 社区</a> 2018 &copy; <a href="http://jboot.io"  target="_blank"> Jboot.io</a></p>
</div>
<script src="${base}/static/layui/layui.js"></script>

<script>
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