<div class="fly-panel fly-column">
    <div class="layui-container">
        <ul class="layui-clear">
            <li class="<#if !category_id??>layui-this</#if>"><a href="/">首页</a></li>
            <li class="<#if category_id??><#if category_id=='0c275ece74fe4c1fbcaa9d3c7438f1f3'>layui-this</#if></#if>"><a href="/?category_id=0c275ece74fe4c1fbcaa9d3c7438f1f3" >提问</a></li>
            <li class="<#if category_id??><#if category_id=='7796fa78031a4b3988d6bc5a629041f3'>layui-this</#if></#if>"><a href="/?category_id=7796fa78031a4b3988d6bc5a629041f3" >分享</a></li>
            <li class="<#if category_id??><#if category_id=='ae361130722f47cfba93019ba27177ba'>layui-this</#if></#if>"><a href="/?category_id=ae361130722f47cfba93019ba27177ba" >讨论</a></li>
            <li class="<#if category_id??><#if category_id=='bb21e00b41174683bd4e5ec2baa88032'>layui-this</#if></#if>"><a href="/?category_id=bb21e00b41174683bd4e5ec2baa88032" >公告</a></li>
            <!--
            <li><a href="/post/category/aaa">分享<span class="layui-badge-dot"></span></a></li>
            -->
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li>

            <!-- 用户登入后显示 -->
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="/role/post">我发表的帖子</a></li>
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="/role/postCollection">我收藏的帖子</a></li>
        </ul>

        <div class="fly-column-right layui-hide-xs">
            <span class="fly-search"><i class="layui-icon"></i></span>
            <a href="/role/insertPost" class="layui-btn">发表新帖</a>
        </div>
        <div class="layui-hide-sm layui-show-xs-block" style="margin-top: -10px; padding-bottom: 10px; text-align: center;">
            <a href="/role/insertPost" class="layui-btn">发表新帖2</a>
        </div>
    </div>
</div>