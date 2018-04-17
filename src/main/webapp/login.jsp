<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>login</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js?v=<%=Math.random()%>"></script>

<script>
    var code = '${param.code}'; // 微信段参数
</script>

</head>

<body>

	<header class='demos-header'>
		<h1 class="demos-title">登录</h1>
	</header>

	<form class="weui-cells weui-cells_form">
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">员工编号</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="number" id=username placeholder="请输入员工编号">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">密码</label>
			</div>
			<div class="weui-cell__bd">
				<input type="password" class="weui-input" id="password" placeholder="请输入密码">
			</div>
		</div>

	</form>

	<div class="weui-cells__title">表单报错</div>

	<div class="weui-btn-area">
		<button class="weui-btn weui-btn_primary" onclick="doLogin()" id="loginBtn">确定</button>
		<button class="weui-btn weui-btn_primary" onclick="reset()">重置</button>
	</div>

</body>

</html>