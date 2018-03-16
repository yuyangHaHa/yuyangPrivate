<#assign base=request.contextPath />
<script src="${base}/static/mods/jquery-1.8.0.js"></script>
<script src="${base}/static/mods/page.js"></script>
<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="fly-logo" href="/">
            <img src="${base}/static/images/logo.png" alt="layui">
        </a>
        <ul class="layui-nav fly-nav layui-hide-xs">
            <li class="layui-nav-item layui-this">
                <a href="/"><i class="iconfont icon-jiaoliu"></i>交流</a>
            </li>
            <li class="layui-nav-item">
                <a href="https://gitee.com/fuhai/jboot" target="_blank"><i class="iconfont icon-iconmingxinganli"></i>GITEE</a>
            </li>
            <li class="layui-nav-item">
                <a href="https://github.com/yangfuhai/jboot" target="_blank"><i class="iconfont icon-ui"></i>GITHUB</a>
            </li>
        </ul>


        <#if (Session["kehu"])??>
               <ul class="layui-nav fly-nav-user">
                   <li class="layui-nav-item">
                       <a class="fly-nav-avatar" href="javascript:;">
                           <cite class="layui-hide-xs">${Session["kehu"].nickname}</cite>
                           <img src="${Session["kehu"].avatar}">
                           <span class="layui-nav-more"></span></a>
                       <dl class="layui-nav-child layui-anim layui-anim-upbit">
                           <dd><a href="/role/post"><i class="layui-icon"></i>我的帖子</a></dd>
                           <dd><a href="/role/personalSettings"><i class="layui-icon"></i>基本设置</a></dd>
                           <dd><a href="/role/personalInformation"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
                           <dd><a href="/role/user/${kehu.id}"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;"></i>我的主页</a></dd>
                           <hr style="margin: 5px 0;">
                           <dd><a href="/role/logout" style="text-align: center;">退出</a></dd>
                       </dl>
                   </li>
                   <span class="layui-nav-bar" style="left: 49.5px; top: 55px; width: 0px; opacity: 0;"></span>
               </ul>
        <#else>
        <ul class="layui-nav fly-nav-user">
            <!-- 未登入的状态 -->
            <li class="layui-nav-item">
                <a class="iconfont icon-touxiang layui-hide-xs" href="/logintz"></a>
            </li>
            <li class="layui-nav-item">
                <a href="/logintz">登入</a>
            </li>
            <li class="layui-nav-item">
                <a href="/register">注册</a>
            </li>
            <span class="layui-nav-bar" style="left: 27px; top: 55px; width: 0px; opacity: 0;"></span></ul>
        </#if>













        <script>
            $(function () {
                var flag = null;
                $(".fly-nav-user").hover(
                        function () {
                            clearInterval(flag);
                            $(".layui-nav-child").show();
                        },
                        function () {
                            flag = setTimeout("$(\".layui-nav-child\").hide()",800);
                        }
                )
            })
        </script>

    </div>
</div>