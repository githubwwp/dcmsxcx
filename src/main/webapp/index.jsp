<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/index.js?v=<%=Math.random()%>"></script>


</head>

<body>
	<div class="weui-tab">
		<div class="weui-tab__bd">
			<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
				<header class='demos-header'>
					<h1 class="demos-title">易汇企业微信</h1>
				</header>

				<div class="weui-grids">
					<a href="<%=request.getContextPath()%>/jsp/dialy/dialyAdd.jsp" class="weui-grid js_grid">
						<div class="weui-grid__icon">
							<img src="images/day_work.png" alt="">
						</div>
						<p class="weui-grid__label">报工</p> 
					</a> 
					<a href="" class="weui-grid js_grid">
						<div class="weui-grid__icon">
							<img src="images/icon_lunch.png" alt="">
						</div>
						<p class="weui-grid__label">午餐补贴</p> 
					</a>
				</div>
			</div>
			
			<div id="tab2" class="weui-tab__bd-item">
				<header class='demos-header'>
					<h1 class="demos-title">个人信息</h1>
					<p class='demos-sub-title'>。。。</p>
				</header>
				<div class="weui-grids">
					<a href="<%=request.getContextPath()%>/login/logout.do" class="weui-grid js_grid">
						<div class="weui-grid__icon">
							<img src="images/logout.png" alt="">
						</div>
						<p class="weui-grid__label">登出</p> 
					</a> 
				</div>
			</div>
		</div>

		<!-- 底部导航栏 -->
		<div class="weui-tabbar">
			<a href="#tab1" class="weui-tabbar__item weui-bar__item--on">
				<div class="weui-tabbar__icon">
					<img src="./images/index.png" alt="">
				</div>
				<p class="weui-tabbar__label">模块</p> 
			</a> 
			<a href="#tab2" class="weui-tabbar__item">
				<div class="weui-tabbar__icon">
					<img src="./images/person.png" alt="">
				</div>
				<p class="weui-tabbar__label">我</p> 
			</a>
		</div>
	</div>


</body>

</html>