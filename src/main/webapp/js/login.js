
$(function(){
    wxCode();
});

function wxCode(){
    $.ajax({
        url: contextPath+'/test/wxCode.do',
        type: 'post',
        data: { code: code },
        success: function(data){
            alert("userId: " + data.userId);
        }
    });
}