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
<#include "../share/toptwo.ftl">




<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8 content detail">
            <div class="fly-panel detail-box">
                <h1>${post.title}</h1>
                <div class="fly-detail-info">
                    <!-- <span class="layui-badge">审核中</span> -->
                    <span class="layui-badge layui-bg-green fly-detail-column">${post.category.name}</span>
                    <#if post.status==9 ><span class="layui-badge" style="background-color: #5FB878;">已结</span></#if>

                    <#if (post.level>0) ><span class="layui-badge layui-bg-black">置顶${post.level}</span></#if>

                    <#if (post.recommend==1) ><span class="layui-badge layui-bg-red">精帖</span></#if>


                    <div class="fly-admin-box" data-id="13cc8e0acd7848929a35b10637ef0d71">

                    <#if kehu??>

                        <span class="layui-btn layui-btn-xs jie-admin" onclick="theUserAction(0)">删除</span>
                        <span class="layui-btn layui-btn-xs jie-admin" onclick="theUserAction(1)">置顶1</span>
                        <span class="layui-btn layui-btn-xs jie-admin" onclick="theUserAction(2)">置顶2</span>
                        <span class="layui-btn layui-btn-xs jie-admin" onclick="theUserAction(3)">置顶3</span>
                        <#if (post.recommend!=1)><span class="layui-btn layui-btn-xs jie-admin" onclick="theUserAction(88)">加精</span></#if>
                        <#if (post.level>0) ><span class="layui-btn layui-btn-xs jie-admin" style="background-color:#ccc;" onclick="theUserAction(66)">取消置顶</span></#if>
                        <#if (post.recommend==1) ><span class="layui-btn layui-btn-xs jie-admin" style="background-color:#ccc;" onclick="theUserAction(888)">取消加精</span></#if>

                    </#if>



                    </div>

                    <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i>${post.comment_count}</a>
            <i class="iconfont" title="人气">&#xe60b;</i> ${post.view_count}
          </span>
                </div>
                <div class="detail-about">
                    <a class="fly-avatar" href="/user/70ee8bd502b643378a61de0d5b0000cf">
                        <img src="${post.user.avatar!'/static/images/avatar/default.png'}" alt="${post.user.nickname}">
                    </a>
                    <div class="fly-detail-user">
                        <a href="/user/70ee8bd502b643378a61de0d5b0000cf" class="fly-link">
                            <cite>${post.user.nickname}</cite>
                            <i class="iconfont icon-renzheng" title="认证信息：{{ rows.user.approve }}"></i>
                            <i class="layui-badge fly-badge-vip">VIP3</i>
                        </a>
                        <span>${post.created?string('yyyy-MM-dd')}</span>
                    </div>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="13cc8e0acd7848929a35b10637ef0d71">
                        <span style="padding-right: 10px; color: #FF7200">悬赏：${post.pay_point} 元宝</span>
                        <#if kehu??>

    <span class="layui-btn layui-btn-xs jie-admin" type="edit">
        <a href="/role/updatePost/${post.id}">编辑此贴</a>
    </span>
                            <#if userCollection??>
                            <span class="layui-btn layui-btn-xs jie-admin layui-btn-danger collection">取消收藏</span>
                            <#else>
                            <span class="layui-btn layui-btn-xs jie-admin collection">收藏</span>
                            </#if>

                        </#if>
                    </div>
                </div>
                <div class="detail-body photos">
                ${post.content}
                </div>
            </div>


            <div class="fly-panel detail-box" id="flyReply">
                <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
                    <legend>回帖</legend>
                </fieldset>

                <ul class="jieda" id="jieda">


                    <#list pageInfo.list as list>
                    <li data-id="${list.id}">
                        <a name="item-002e58cd906b4cfb9104cdf589d7ae42"></a>
                        <div class="detail-about detail-about-reply">
                            <a class="fly-avatar" href="">
                                <img src="${list.avatar!'/static/images/avatar/default.png'}" alt=" ">
                            </a>
                            <div class="fly-detail-user">
                                <a href="" class="fly-link">
                                    <cite>${(list.nickname)!'游客'}</cite>
                                </a>
                            </div>
                            <div class="detail-hits">
                                <span>${list.created?string('yyyy-MM-dd HH:mm:ss')}</span>
                            </div>
                            <#if list.status == 9 >
                                <i class="iconfont icon-caina" title="最佳答案"></i>
                            </#if>
                        </div>
                        <div class="jieda-body photos">
                            ${list.content}
                        </div>
                        <div class="jieda-reply">
              <span class="jieda-zan" type="zan">
                <i class="iconfont icon-zan"></i>
                <em>0</em>
              </span>
                            <span type="reply">
                <i class="iconfont icon-svgmoban53"></i>
                回复
              </span>
                            <div class="jieda-admin">
                                <span type="edit">编辑</span>
                                <span type="del">删除</span>
                                <span class="jieda-accept"><input type="hidden" value="${list.user_id}">采纳</span>
                            </div>
                        </div>
                    </li>
                    </#list>











                </ul>

                <div style="text-align: center">
                    <div style="text-align: center">
                        <div style="text-align: center">
                            <ul class="page" maxshowpageitem="3" pagelistcount="${pageInfo.pageSize}"  id="page"></ul>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                    var GG = {
                        "kk":function(mm){
                            window.location.href="?pn="+mm;
                        }
                    }
                    $("#page").initPage(${pageInfo.total},${pageInfo.pageNum},GG.kk);
                    // 总条数  当前页
                </script>





                <div class="layui-form layui-form-pane">
                <form id="myform">
                    <div class="layui-form-item layui-form-text">
                        <a name="comment"></a>
                        <div class="layui-input-block">
                                <textarea name="content" class="layui-textarea" id="LAY_demo1" style="display: none">
                                </textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <input type="hidden" name="id" value="${post.id}">
                        <input type="hidden" name="to_id" value="${post.user.id}">
                        <button class="layui-btn" type="button" id="hfsubmit">提交回复</button>
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

    



    <#if userCollection??>
     var panduanCollection = 1;
    <#else>
     var panduanCollection = 0;
    </#if>

var index = "";
var layedit = "";


   $(".collection").click(function () {
           $.ajax({
           url:"/role/collection",
           type:"post",
           data:{
               "postid":"${post.id}",
               "posttitle":"${post.title}",
               "panduanCollection":panduanCollection
           },
           dataType:"text",
           success:function(response){

               if(response.indexOf("/")>-1)
               {
                   location.href=response;
               }
               else
               {
                   location.reload();
               }

           },
           error:function(){
               alert("失败！");
           }
           });
   })

    $("#hfsubmit").click(function(){

        layedit.sync(index);
        $.ajax({
            url:"/role/huifu",
            type:"post",
            async:false,
            data:$("#myform").serialize(),
            dataType:"text",
            success:function(response){

                    if(response!=null&&response!="")
                    {
                        location.href=response;
                    }
                    else
                    {
                        location.reload();
                        $(document).scrollTop(600);
                    }

            },
            error:function(){
                alert("失败！");
            }
        });

    });

    var theUserAction="";

    layui.use('layedit', function(){

        theUserAction = function theUserAction(state) {

            var zhuangtai = "";
            switch(state)
            {
                case 0:
                    zhuangtai = "你确定删除啊吗？";
                    break;
                case 66:
                    zhuangtai = "你确定取消置顶吗？";
                    break;
                case 88:
                    zhuangtai = "你确定加精吗？";
                    break;
                case 888:
                    zhuangtai = "你确定取消加精吗？";
                    break;
                default:
                    zhuangtai = "你确定置顶吗？";
            }

            layer.confirm(zhuangtai, {
                btn: ['确定','取消'] //按钮
            }, function(){

                    $.ajax({
                    url:"/role/theUserAction/"+state,
                    type:"post",
                    data:{
                        "postid":"${post.id}"
                    },
                    dataType:"text",
                    success:function(response){
                        if(state==0)
                        {
                            location.href="/";
                        }
                        else if(response.indexOf("/")>-1)
                        {
                            location.href=response;
                        }
                        else
                        {
                            location.reload();
                        }
                    },
                    error:function(){
                        alert("失败！");
                    }
                    });

            }, function(){

            });


        }


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


         $(".jieda-accept").click(function () {
             var commentid = $(this).parents("li").attr("data-id");
             var commentid_user = $("input",this).val();
             layer.confirm('是否采纳该回答为最佳答案？', {
                 btn: ['确定','取消'] //按钮
             }, function(){


                 $.ajax({
                     url:"/role/adopt",
                     type:"post",
                     data:{
                              "postid":"${post.id}",
                              "commentid":commentid,
                              "pay_point":${post.pay_point},
                              "commentid_user":commentid_user
                           },
                     dataType:"text",
                     success:function(response){
                         if("此帖子已经结贴了"==response)
                         {
                             layer.alert('此帖子已经结贴了');
                         }
                         else if(response!=null&&response!="")
                         {
                             location.href=response;
                         }
                         else
                         {
                             location.reload();
                         }
                     },
                     error:function(){
                         alert("失败！");
                     }
                 });

             }, function(){

             });
         });





    });


    layui.cache.page = 'jie';
    layui.cache.user = {
        username: '游客'
        ,uid: '-1'
        ,avatar: '/static/images/avatar/00.jpg'
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