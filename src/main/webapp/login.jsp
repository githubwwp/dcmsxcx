<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>

<title>login</title>

<!-- head 中 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/weui/0.4.3/style/weui.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/0.8.3/css/jquery-weui.css">

<!-- jquery -->
<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/0.8.3/js/jquery-weui.min.js"></script>
<script>
var contextPath = "<%=request.getContextPath()%>"; // 项目根目录
var code = '${param.code}';
</script>

<!-- custom js -->
<script src="js/login.js"></script>

</head>

<body>

	<header class='demos-header'>
		<h1 class="demos-title">登录</h1>
	</header>

	<div class="weui_cells weui_cells_form">
		<div class="weui_cell">
			<div class="weui_cell_hd">
				<label class="weui_label">qq</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input class="weui_input" type="tel" placeholder="请输入帐号">
			</div>
		</div>
		<div class="weui_cell">
			<div class="weui_cell_hd">
				<label class="weui_label">密码</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input class="weui_input" type="number" placeholder="请输入密码">
			</div>
		</div>
	</div>

	<div class="weui_btn_area">
		<a class="weui_btn weui_btn_primary" href="javascript:" id="showTooltips">确定</a>
		<a class="weui_btn weui_btn_primary" href="javascript:wxCode()" id="showTooltips">微信第三方授权</a>
	</div>

</body>

</html>