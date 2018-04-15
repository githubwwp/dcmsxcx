<!DOCTYPE html>
<html>
<head>
<title>test</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->


</head>
<body>
	<!-- App root element -->
	<div id="app">
		<!-- Statusbar overlay -->
		<div class="statusbar"></div>

		<!-- Your main view, should have "view-main" class -->
		<div class="view view-main">
			<!-- Initial Page, "data-name" contains page name -->
			<div data-name="home" class="page">

				<!-- Top Navbar -->
				<div class="navbar">
					<div class="navbar-inner">
						<div class="title">Awesome App</div>
					</div>
				</div>

				<!-- Toolbar -->
				<div class="toolbar">
					<div class="toolbar-inner">
						<!-- Toolbar links -->
						<a href="#" class="link">Link 1</a> <a href="#" class="link">Link
							2</a>
					</div>
				</div>

				<!-- Scrollable page content -->
				<div class="page-content">
					<p>Page content goes here</p>
					<!-- Link to another page -->
					<a href="<%=request.getContextPath()%>/jsp/test/accordionTest.jsp">About app</a>
				</div>
			</div>
		</div>
	</div>
</body>

	<!-- App routes -->
  <script src="routes.js"></script>

  <!-- Your custom app scripts -->
  <script src="js/app.js"></script>

</html>