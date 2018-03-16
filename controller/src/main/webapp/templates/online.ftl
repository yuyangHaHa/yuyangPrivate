<#assign base=request.contextPath />
<html>
<head>
    <title>online</title>
    <script src="${base}/static/mods/jquery-1.8.0.js"></script>
</head>
<body>


<h1>在线用户管理</h1>
<#list online as ol>
<ul>
    <li>${ol}<a href="javascript:online('${ol.id}')">退出</a></li>
</ul>
</#list>

<script>

    function online(id) {
        $.ajax({
            url:"/exitUser/"+id,
            type:"post",
            dataType:"text",
            success:function(response){

                location.reload();

            },
            error:function(){
                alert("失败！");
            }
        });
    }


</script>
</body>
</html>
