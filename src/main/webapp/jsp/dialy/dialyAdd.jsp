<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>dialyAdd</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/login.js?v=<%=Math.random()%>"></script>

<script>
	var code = '${param.code}'; // 微信段参数
</script>

</head>

<body>
	<header class='demos-header'>
		<h1 class="demos-title">工作日志</h1>
	</header>
</body>

</html>