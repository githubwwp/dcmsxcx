
function wxCode(){
    $.ajax({
        url: contextPath+'/test/wxCode.do',
        type: 'post',
        success: function(data){
            console.log(data);
        }
    });
}