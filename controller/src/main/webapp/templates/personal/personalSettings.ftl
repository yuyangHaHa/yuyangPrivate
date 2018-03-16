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
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this" lay-id="info">我的资料</li>
                <li lay-id="avatar">头像</li>
                <li lay-id="pass">密码</li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <form class="layui-form layui-form-pane layui-tab-item layui-show" id="myform">
                        <div class="layui-form-item">
                            <label for="L_email" class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_email" name="email" disabled value="${kehu.email}" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux"> 邮箱不能修改。</div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_username" class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_username" name="nickname" value="${kehu.nickname}" class="layui-input">
                            </div>
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input type="radio" name="gender" value="male" <#if (kehu.gender)?? ><#if kehu.gender=="male">checked</#if></#if> title="男">
                                    <input type="radio" name="gender" value="female" <#if (kehu.gender)?? ><#if kehu.gender=="female">checked</#if></#if>    title="女">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_city" class="layui-form-label">城市</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_city" name="address" value="${kehu.address!''}" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_city" class="layui-form-label">博客(网址)</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_site" name="weibo" value="${kehu.weibo!''}" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label for="L_sign" class="layui-form-label">签名</label>
                            <div class="layui-input-block">
                                <textarea placeholder="随便写些什么刷下存在感" id="L_sign"  name="signature" autocomplete="off" class="layui-textarea" style="height: 80px;">${kehu.signature!''}</textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" type="button" id="usersubmit">确认修改</button>
                        </div>
                    </form>

                    <div class="layui-form layui-form-pane layui-tab-item">
                        <div class="layui-form-item">
                            <div class="avatar-add">
                                <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过2000KB</p>

                                <button type="button" class="layui-btn layui-btn-danger diyuplod" id="test7">
                                    <i class="layui-icon"></i>上传图片
                                </button>

                                <img src="${kehu.avatar!'/static/images/avatar/default.png'}">
                                <span class="loading"></span>
                            </div>
                        </div>
                    </div>

                    <div class="layui-form layui-form-pane layui-tab-item">
                        <form id="pwdForm">
                            <div class="layui-form-item">
                                <label for="L_nowpass" class="layui-form-label">当前密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_nowpass" name="nowpassword" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_pass" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_repass" class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_repass" name="repassword" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" type="button" id="pwdSubmit">确认修改</button>
                            </div>
                        </form>
                    </div>


            </div>

        </div>
    </div>
</div>
</div>




<div class="fly-footer">
    <p><a href="http://jboot.io/" target="_blank">JBoot Fly 社区</a> 2018 &copy; <a href="http://jboot.io"  target="_blank"> Jboot.io</a></p>
</div>
<script src="${base}/static/layui/layui.js"></script>

<style>

    .diyuplod{
        position: absolute;
        left: 50%;
        top: 35px;
        margin: 0 0 0 -56px;
    }

</style>
<script>
//layui-this
    $("ul.layui-nav-tree .layui-nav-item:eq(2)").addClass("layui-this");
    layui.use('upload', function(){

        var $ = layui.jquery
                ,upload = layui.upload;

        upload.render({
            elem: '#test7'
            ,url: '/role/uploadUserImg'
            ,size: 2000 //限制文件大小，单位 KB
            ,done: function(res){
                location.reload();
            }
        });
    })

    $("#usersubmit").click(function () {

        $.ajax({
            url:"/role/doSetting",
            type:"post",
            data:$("#myform").serialize(),
            dataType:"text",
            success:function(response){
                if(response.indexOf("/")>-1)
                {
                    location.href=response;
                }
                else {
                    location.reload();
                }
            },
            error:function(){
                alert("失败！");
            }
        });

    })

    layui.use('layer', function(){



    $("#pwdSubmit").click(function () {

        $.ajax({
            url:"/role/resetpwd",
            type:"post",
            data:$("#pwdForm").serialize(),
            dataType:"text",
            success:function(response){
                if(response.indexOf("/")>-1)
                {
                    location.href=response;
                }
                else {
                    var icons = 1;
                    if(response!="密码修改成功,重新登录"){icons = 2}
                    layer.msg(response, {
                        icon: icons,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        if(icons==1)
                        {
                            location.reload();
                        }
                    })
                }
            },
            error:function(){
                alert("失败！");
            }
        });

    })
    })

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