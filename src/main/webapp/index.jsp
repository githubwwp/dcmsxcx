<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>

<title>index</title>

<!-- head 中 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/weui/0.4.3/style/weui.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/0.8.3/css/jquery-weui.css">

<!-- jquery -->
<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/0.8.3/js/jquery-weui.min.js"></script>

<script>
var contextPath = "<%=request.getContextPath()%>"; // 项目根目录
</script>

</head>

<body>

	<header class='demos-header'>
		<h1 class="demos-title">表单</h1>
	</header>

	<div class="weui_cells weui_cells_form">
		<div class="weui_cell">
			<div class="weui_cell_hd">
				<label class="weui_label">qq</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input class="weui_input" type="tel" placeholder="请输入qq号">
			</div>
		</div>
		<div class="weui_cell weui_vcode">
			<div class="weui_cell_hd">
				<label class="weui_label">验证码</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input class="weui_input" type="number" placeholder="请输入验证码">
			</div>
			<div class="weui_cell_ft">
				<img src="images/vcode.jpg">
			</div>
		</div>
		<div class="weui_cell weui_cell_switch">
			<div class="weui_cell_hd weui_cell_primary">接受通知</div>
			<div class="weui_cell_ft">
				<input class="weui_switch" type="checkbox">
			</div>
		</div>
		<div class="weui_cell">
			<div class="weui_cell_hd">
				<label for="" class="weui_label">日期</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input class="weui_input" type="date" value="">
			</div>
		</div>
		<div class="weui_cell">
			<div class="weui_cell_hd">
				<label for="" class="weui_label">时间</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input class="weui_input" type="datetime-local" value="" placeholder="">
			</div>
		</div>
		<div class="weui_cell weui_cell_select">
			<div class="weui_cell_bd weui_cell_primary">
				<select class="weui_select" name="select1">
					<option selected="" value="0">选择</option>
					<option value="1">微信号</option>
					<option value="2">QQ号</option>
					<option value="3">Email</option>
				</select>
			</div>
		</div>
	</div>
	<div class="weui_cells_title">文本域</div>
	<div class="weui_cells weui_cells_form">
		<div class="weui_cell">
			<div class="weui_cell_bd weui_cell_primary">
				<textarea class="weui_textarea" placeholder="请输入评论" rows="3"></textarea>
				<div class="weui_textarea_counter">
					<span>0</span>/200
				</div>
			</div>
		</div>
	</div>

	<div class="weui_cells weui_cells_form">
		<div class="weui_cell">
			<div class="weui_cell_bd weui_cell_primary">
				<div class="weui_uploader">
					<div class="weui_uploader_hd weui_cell">
						<div class="weui_cell_bd weui_cell_primary">图片上传</div>
						<div class="weui_cell_ft">0/2</div>
					</div>
					<div class="weui_uploader_bd">
						<ul class="weui_uploader_files">
							<li class="weui_uploader_file"
								style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/)"></li>
							<li class="weui_uploader_file"
								style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/)"></li>
							<li class="weui_uploader_file"
								style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/)"></li>
							<li class="weui_uploader_file weui_uploader_status"
								style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/)">
								<div class="weui_uploader_status_content">
									<i class="weui_icon_warn"></i>
								</div>
							</li>
							<li class="weui_uploader_file weui_uploader_status"
								style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/)">
								<div class="weui_uploader_status_content">50%</div>
							</li>
						</ul>
						<div class="weui_uploader_input_wrp">
							<input class="weui_uploader_input" type="file" accept="image/*" multiple="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<h2 class="demos-second-title">表单校验</h2>
	<div class="weui_cells weui_cells_form">
		<div class="weui_cell weui_cell_warn">
			<div class="weui_cell_hd">
				<label class="weui_label">qq</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input id='tel' class="weui_input" type="tel" placeholder="请输入qq号">
			</div>
		</div>
		<div class="weui_cell weui_vcode weui_cell_warn">
			<div class="weui_cell_hd">
				<label class="weui_label">验证码</label>
			</div>
			<div class="weui_cell_bd weui_cell_primary">
				<input id='code' class="weui_input" type="number" placeholder="请输入验证码">
			</div>
			<div class="weui_cell_ft">
				<i class="weui_icon_warn"></i> <img src="images/vcode.jpg">
			</div>
		</div>
		<div class="weui_cells_tips">底部说明文字底部说明文字</div>
		<div class="weui_btn_area">
			<a class="weui_btn weui_btn_primary" href="javascript:" id="showTooltips">确定</a>
		</div>
	</div>


	<script>
        $("#showTooltips").click(function() {
            var tel = $('#tel').val();
            var code = $('#code').val();
            if (!tel || !/1[3|4|5|7|8]\d{9}/.test(tel))
                $.toptip('请输入手机号');
            else if (!code || !/\d{6}/.test(code))
                $.toptip('请输入六位手机验证码');
            else
                $.toptip('提交成功', 'success');
        });
    </script>
</body>

</html>