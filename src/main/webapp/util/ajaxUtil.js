/* 公用ajax函数 */
function ajaxFun(url, datas, cb) {
    $.ajax({
        url : url,
        type : "post",
        data : datas,
        success : function(json) {
            cb.call(this, json);
        },
        error : function(xhr) {
            if (xhr.status == "404") {
                alert("404 Not Found");
            } else if (xhr.status == "500") {
                alert("500 Servlet Exception");
            } else {
                alert(xhr.status);
            }
        }
    });
}
