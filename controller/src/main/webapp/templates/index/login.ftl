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
<div class="layui-container fly-marginTop">
    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title">
                <li class="layui-this">登入</li>
                <li><a href="/register">注册</a></li>
            </ul>
            <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form layui-form-pane">
                        <form id="myform">

                            <div class="layui-form-item">
                            </div>

                            <div class="layui-form-item">
                                <label for="L_email" class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input value="admin@jboot.io" type="text" id="L_email" name="email" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input value="111111" type="password" id="L_pass" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_vercode" class="layui-form-label">验证码</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_vercode" name="vercode" required lay-verify="required"
                                           placeholder="请输入验证码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">
                                    <span style="color: #c00;"><img src="${base}/authImage" style="width: 80px;height: 25px" onclick="javascript:this.src='${base}/authImage?'+Math.random()"></span>
                                </div>
                                <label style="float:left;padding-top:14px;">
                                    <input type="checkbox" checked="checked" id="rememberMe" name="rememberMe" value="1" style="width: 20px;height: 20px;display: block;float: left;">
                                    记住我
                                </label>
                            </div>
                            <div class="layui-form-item">
                                <button type="button" class="layui-btn" id="loginlima">立即登录</button>
                                <span style="padding-left:20px;">
                  <a href="/getpwd">忘记密码？</a>
                </span>
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



<script>
    $(function () {


        layui.use('layer', function(){

            <#if forceLogout??>
              layer.alert('已被管理员踢出！', {icon: 5});
            </#if>

            $("#loginlima").click(function () {
                $.ajax({
                    url:"${base}/doLogin",
                    type:"post",
                    data:$("#myform").serialize(),
                    dataType:"json",
                    success:function(response){
                        var icons = 1;
                        if(response.msg!="登陆成功"){icons = 2}
                        layer.msg(response.msg, {
                            icon: icons,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            if(response.msg=="登陆成功")
                            {
                                location.href=response.url;
                            }
                        })
                    },
                    error:function(){
                        alert("失败！");
                    }
                });
            })
        })
    })
</script>


</body>
</html>