<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js?v=<%=Math.random()%>"></script>


</head>

<body>
	<header class='demos-header'>
		<h1 class="demos-title">jQuery WeUI</h1>
		<p class='demos-sub-title'>轻量强大的UI库，不仅仅是 WeUI</p>
	</header>

	<div class="weui-grids">
		<a href="" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="images/icon_nav_button.png" alt="">
			</div>
			<p class="weui-grid__label">Button</p>
		</a>
		<a href="" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="images/icon_nav_cell.png" alt="">
			</div>
			<p class="weui-grid__label">List</p>
		</a>
	</div>
</body>

</html>