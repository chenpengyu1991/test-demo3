var viewConsultation = (function () {

    $(function () {
        toggleOrgAndName();
    });

    //获取后台json显示到页面
    function toggleOrgAndName(){
        var consulationOrgAndName = $("#consulationOrgAndName").val();
        var newTrauma;

        if (!$.isEmpty(consulationOrgAndName)  && consulationOrgAndName != "[]"){
            try {
                var jsObject = JSON.parse(consulationOrgAndName);

                $.each(jsObject, function(idx, obj) {
                    var index = idx+1;
                    newTrauma = "<span><input type='text' name='orgName' value='"+obj.key+"' style='width: 50%' readonly='readonly'/> | "+
                                "<input type='text' name='docName"+index+"' value='"+obj.value[0]+"' style='width: 15%' readonly='readonly'/> "+
                                "<input type='text' name='docName"+index+"' value='"+obj.value[1]+"' style='width: 15%' readonly='readonly'/> "+
                                "<input type='text' name='docName"+index+"' value='"+obj.value[2]+"' style='width: 15%' readonly='readonly'/> "+
                                "<br/></span>";
                    $("#orgAndDoc").append(newTrauma);
                });
            }catch (e) {
                alert(e);
            }
        }
	}
})();