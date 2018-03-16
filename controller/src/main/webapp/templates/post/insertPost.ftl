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
    <div class="fly-panel" pad20 style="padding-top: 5px;">
        <!--<div class="fly-none">没有权限</div>-->
        <div class="layui-form layui-form-pane">
            <div class="layui-tab layui-tab-brief" lay-filter="user">
                <ul class="layui-tab-title">
                    <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
                </ul>
                <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                    <div class="layui-tab-item layui-show">
                        <form id="myform">
                            <div class="layui-row layui-col-space15 layui-form-item">
                                <div class="layui-col-md3">
                                    <label class="layui-form-label">所在专栏</label>
                                    <div class="layui-input-block">
                                        <select lay-verify="required" name="category_id" lay-filter="column">
                                            <option></option>
                                            <option value="0c275ece74fe4c1fbcaa9d3c7438f1f3"   >提问</option>
                                            <option value="7796fa78031a4b3988d6bc5a629041f3"   >分享</option>
                                            <option value="ae361130722f47cfba93019ba27177ba"   >讨论</option>
                                            <option value="bb21e00b41174683bd4e5ec2baa88032"   >公告</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-col-md9">
                                    <label for="L_title" class="layui-form-label">标题</label>
                                    <div class="layui-input-block">
                                        <input type="text" id="L_title" name="title" required lay-verify="required"
                                               autocomplete="off" class="layui-input" value="">
                                    </div>
                                </div>
                            </div>


                            <div class="layui-form layui-form-pane">
                                <div class="layui-form-item layui-form-text">
                                    <a name="comment"></a>
                                    <div class="layui-input-block">
                                <textarea name="content" class="layui-textarea" id="LAY_demo1" style="display: none">
                                </textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                </div>
                            </div>





                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">悬赏元宝</label>
                                    <div class="layui-input-inline" style="width: 190px;">
                                        <select name="pay_point">
                                            <option value="20">20</option>
                                            <option value="30">30</option>
                                            <option value="50">50</option>
                                            <option value="60">60</option>
                                            <option value="80">80</option>
                                        </select>
                                    </div>
                                    <div class="layui-form-mid layui-word-aux">发表后无法更改元宝数量</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_vercode" class="layui-form-label">验证码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="vercode"
                                           placeholder="请输入验证码"  class="layui-input">
                                </div>
                                <div class="layui-form-mid">
                                    <span style="color: #c00;"><img src="${base}/authImage" style="width: 80px;height: 25px"
                                                                    onclick="javascript:this.src='${base}/authImage?'+Math.random()"></span>
                                </div>
                            </div>
                            <div class="layui-form-item">

                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" type="button" id="submit">立即发布</button>
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

    var index = "";
    var layedit = "";



    $("#submit").click(function(){

        layedit.sync(index);
        $.ajax({
            url:"/role/insertPostTure",
            type:"post",
            async:false,
            data:$("#myform").serialize(),
            dataType:"text",
            success:function(response){

                if(response=="验证码错误")
                {
                    alert("验证码错误");
                }
                else if(response.indexOf("/")>-1)
                {
                    location.href=response;
                }
                else if(response=="验证码已经失效了！请点击验证码刷新！！")
                {
                    alert(response);
                }
                else
                {
                    location.href="/post/"+response;
                }

            },
            error:function(){
                alert("失败！");
            }
        });

    });



    layui.use('layedit', function(){

        var layeditimg = layui.layedit;

        layeditimg.set({
            uploadImage: {
                url: '/role/uploadImage', //接口url
                type: 'post'
            }
        });



        layedit = layui.layedit
                ,$ = layui.jquery;
        //构建一个默认的编辑器
        index = layedit.build('LAY_demo1');
    });









</script>

</body>
</html>