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
<#include "share/top.ftl">
<#include "share/toptwo.ftl">
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">

        <#include "share/zhiding.ftl">


            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="/<#if category_id??>?category_id=${category_id}</#if>" class="<#if !status?? && !recommend??>layui-this</#if>">综合</a>
                    <span class="fly-mid"></span>
                    <a href="/?status=0<#if category_id??>&category_id=${category_id}</#if>" class="<#if status??><#if status==0>layui-this</#if></#if>">未结</a>
                    <span class="fly-mid"></span>
                    <a href="/?status=9<#if category_id??>&category_id=${category_id}</#if>" class="<#if status??><#if status==9>layui-this</#if></#if>">已结</a>
                    <span class="fly-mid"></span>
                    <a href="/?recommend=1<#if category_id??>&category_id=${category_id}</#if>" class="<#if recommend??><#if recommend==1>layui-this</#if></#if>">精华</a>
                    </span>
                </div>

                <ul class="fly-list">
                    <#list pageInfo.list as list>
                        <li>
                            <a href="/role/user/${list.user.id}" class="fly-avatar">
                                <img src="${list.user.avatar!'/static/images/avatar/default.png'}"
                                     alt="${list.user.nickname}">
                            </a>
                            <h2>

                                <a class="layui-badge">${list.category.name}</a>

                                <a href="/post/${list.id}">${list.title}</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="/user/${list.user.id}" link>
                                    <cite>${list.user.nickname}</cite>
                                </a>
                                <span class="fly-list-kiss layui-hide-xs" title="悬赏元宝"><i class="layui-icon" style="color: #FF7200;font-size: 14px;">&#xe62b;</i>  ${list.pay_point}</span>
                                ${list.created?string('yyyy-MM-dd')}


                 <#if list.status==9>
                 <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>
                 <#else>
                 <span class="fly-list-nums">
                    <i class="iconfont icon-pinglun1" title="回答"></i> ${list.comment_count}
                 </span>
                 </#if>



                            </div>
                            <div class="fly-list-badge">


                    <#if list.recommend==1>
                    <span class="layui-badge layui-bg-red">精帖</span>
                    </#if>


                            </div>
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
                            var lj = "";
                            var cate = "";
                            <#if status??>
                                    lj = "&status=${status}";
                            <#else>
                                lj="";
                            </#if>

                            <#if recommend??>
                            lj = "&recommend=1"
                            </#if>

                            <#if category_id??>cate = "&category_id=${category_id}";</#if>


                            window.location.href="/?pn="+mm+lj+cate;
                        }
                    }
                    $("#page").initPage(${pageInfo.total},${pageInfo.pageNum},GG.kk);
                    // 总条数  当前页
                </script>







            </div>
        </div>
        <div class="layui-col-md4">



            <div class="fly-panel fly-signin">
                <div class="fly-panel-title">
                    签到
                    <i class="fly-mid"></i>
                    <a href="javascript:;" class="fly-link" id="LAY_signinHelp">说明</a>
                    <i class="fly-mid"></i>
                </div>
                <div class="fly-panel-main fly-signin-main">


                    <!-- 已签到状态 -->
                    <#if certification=='0'>
                    <button class="layui-btn layui-btn-disabled">请登录签到</button>
                    <#elseif certification=='1'>
                    <button class="layui-btn layui-btn-danger" id="Today">今日签到</button>
                    <#else>
                    <button class="layui-btn layui-btn-disabled">今日已签到</button>
                    </#if>

                    <span>获得了<cite>5</cite> 元宝</span>
                </div>
            </div><div class="fly-panel">
            <h3 class="fly-panel-title">温馨通道</h3>
            <ul class="fly-panel-main fly-list-static">
                <li>
                    <a href="#" target="_blank">Jboot 简介</a>
                </li>
                <li>
                    <a href="#" target="_blank">
                        Jboot 的 github 地址，欢迎 start
                    </a>
                </li>
                <li>
                    <a href="#" target="_blank">Jboot 的 gitee 地址，欢迎 start</a>
                </li>
                <li>
                    <a href="#" target="_blank">
                        Jboot 常见问题收集
                    </a>
                </li>
            </ul>
        </div><div class="fly-panel fly-link">
            <h3 class="fly-panel-title">友情链接</h3>
            <dl class="fly-panel-main">
                <dd><a href="http://jboot.io" target="_blank">Jboot</a>
                <dd>
                <dd><a href="http://www.jfinal.com/" target="_blank">Jfinal</a>
                <dd>
                <dd><a href="http://www.layui.com/" target="_blank">layui</a>
                <dd>
                <dd>
                    <a href="#"
                       class="fly-link">申请友链</a>
                <dd>
            </dl>
        </div>

        </div>
    </div>
</div>

<@shiro.hasPermission name="yy">
	<h1 style="text-align:center">此人有yy权限</h1>
</@shiro.hasPermission>

<div class="fly-footer">
    <p><a href="http://jboot.io/" target="_blank">JBoot Fly 社区</a> 2018 &copy; <a href="http://jboot.io"  target="_blank"> Jboot.io</a></p>
</div>


<script src="${base}/static/layui/layui.js"></script>

<script>
    $("#Today").click(function () {
        $.ajax({
            url:"/role/todaySign",
            type:"post",
            dataType:"text",
            success:function(response){

                if(response.indexOf("/")>-1)
                {
                    location.href=response;
                }
                else if(response=="1")
                {
                    $("#Today").attr("class","layui-btn layui-btn-disabled").html("今日已签到").removeAttr("id");
                }
                else {
                    alert("非法签到！积分清0！");
                }

            },
            error:function(){
                alert("失败！");
            }
        });
    })
</script>
</body>
</html>