<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>dialyAdd</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->
<script type="text/javascript" src="js/dialyAdd.js?v=<%=Math.random()%>"></script>

</head>

<body>
	<header class='demos-header'>
		<h1 class="demos-title">工作日志</h1>
	</header>

	<form class="weui-cells weui-cells_form">
		<div class="weui-cells__title">报告日期</div>
		<div class="weui-cells">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<input id="date" class="weui-input" type="text" placeholder="选择日期">
				</div>
			</div>
		</div>

		<div class="weui-cells__title">工作内容</div>
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<textarea class="weui-textarea" placeholder="请输入文本" rows="3"></textarea>
					<div class="weui-textarea-counter">
						<span>0</span>/200
					</div>
				</div>
			</div>
		</div>

		<button class="weui-btn weui-btn_primary" onclick="" id="loginBtn">确定</button>
		<button type="reset" class="weui-btn weui-btn_primary">重置</button>
		</div>

	</form>

</body>

</html>