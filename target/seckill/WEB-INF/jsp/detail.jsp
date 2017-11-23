<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp" %>
<html>
<head>
    <title>商品详情页</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<%--弹出登录层--%>

<div class="container">
    <div class="panel panel-default text-center">
        <div class="pannel-heading"><h1>${seckill.name}</h1></div>
    </div>
    <div class="panel-body">
        <h2 class="text-danger text-center">
            <%--显示time图标--%>
            <span class="glyphicon glyphicon-time"></span>
                <%--显示倒计时--%>
            <span class="glyphicon" id="seckill-box"></span>
        </h2>

    </div>
</div>

<%--登录弹出层,输入电话--%>
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <input type="text" name="killPhone" id="killPhoneKey"
                        placeholder="填手机号^o^" class="form-control"/>
                </div>
            </div>

            <div class="modal-footer">
                <%--验证信息--%>
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                </button>
            </div>

        </div>
    </div>


</div>


</body>
<script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="/resources/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        //使用EL表达式传入参数
        seckill.detail.init({
            seckillId : ${seckill.seckillId},
            startTime: ${seckill.startTime.time},//毫秒
            endTime: ${seckill.endTime.time}
        })
    })
</script>
</html>
