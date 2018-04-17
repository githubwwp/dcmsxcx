$(function() {
    // wxCode();
});

function wxCode() {
    var url = theContextPath + '/login/getUserIdByCode.do';
    ajaxFun(url, {}, function(data) {
        alert("userId: " + data.userId);
    });
}

// 登录操作
function doLogin() {
    var username = $("#username").val(); // 帐号
    var password = $("#password").val(); // 密码

    // 验证参数
    if (1/*username && password*/) { // TODO
        var datas = {
            username : username,
            password : password
        };

        // 登录操作
        $("#loginBtn").attr("disabled", true); 
        ajaxFun(theContextPath + '/login/doLogin.do', datas, function(rst) {
            $("#loginBtn").attr("disabled", false); 
            if(rst.rst_code == '00'){
                // TODO 
                window.location.href = theContextPath+"/index.jsp";
            } else{
                $.toptip(rst.rst_msg, 'warning');
            }
        });
    } else {
        $.toptip('请输入用户和密码!', 'warning');
    }
}

// 表单重置
function reset() {
    $("form")[0].reset();
}
