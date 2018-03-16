<#assign base=request.contextPath />
<div class="fly-panel">

    <div class="fly-panel-title fly-filter">
        <a>置顶</a>
        <a href="#signin" class="layui-hide-sm layui-show-xs-block fly-right" id="LAY_goSignin" style="color: #FF5722;">去签到</a>
    </div>
    <ul class="fly-list">
    <#if zhiding??>
<#list zhiding as role>


         <li>
             <a href="/role/user/${role.user.id}" class="fly-avatar">
                 <img src="${role.user.avatar!'/static/images/avatar/default.png'}"
                      alt="${role.user.nickname}">
             </a>
             <h2>

                 <a class="layui-badge">${role.category.name}</a>

                 <a href="/post/${role.id}">${role.title}</a>
             </h2>
             <div class="fly-list-info">
                 <a href="/user/${role.user.id}" link>
                     <cite>${role.user.nickname}</cite>
                 </a>
                 <span class="fly-list-kiss layui-hide-xs" title="悬赏元宝"><i class="layui-icon" style="color: #FF7200;font-size: 14px;">&#xe62b;</i>  ${role.pay_point}</span>
                 ${role.created?string('yyyy-MM-dd')}


                 <#if role.status==9>
                 <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>
                 <#else>
                 <span class="fly-list-nums">
                    <i class="iconfont icon-pinglun1" title="回答"></i> ${role.comment_count}
                 </span>
                 </#if>



             </div>
             <div class="fly-list-badge">

                 <span class="layui-badge layui-bg-black">置顶${role.level}</span>

                    <#if role.recommend==1>
                    <span class="layui-badge layui-bg-red">精帖</span>
                    </#if>


             </div>
         </li>



</#list>
    </#if>





    </ul>


</div>