/**
 * 1、获取该机构的populace信息，展示
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-11-30
 * Time: 下午1:02
 */

var populaceIndex = (function() {

    var sourceSpanContent = "";
    
    var validate=null;
    
    $(function() {
    	validate = $("#communityInfoForm").easyValidate();
    	
        showModifyButton();

        $("#modifyCommunityId").click(function(){
            //将显示的内容转化为input：
//            translateCommunitySpanToInput();
            showCancelButton();
        });

        $("#cancelCommunityId").click(function(){
            //将input转化为普通显示的内容：
//            translateCommunityInputToSpan();
            showModifyButton();
        });

        $("#saveCommunityId").click(function(){
            //保存修改的内容：
            saveCommunityInfo();
            showCancelButton();
        });
        
        $("#waterType").multiselect({
			 header:false,
			 noneSelectedText: '选择饮用水类型',
			 selectedList: 6
		 });
        
        $("#environmentType").multiselect({
			 header:false,
			 noneSelectedText: '选择环境状况类型',
			 selectedList: 5
		 });
        
        $("#rubbishType").multiselect({
			 header:false,
			 noneSelectedText: '选择垃圾处理类型',
			 selectedList: 7
		 });
        
        setTitle("oldPeopleTitle", "CommunityInfoDTO_oldPeopleHome");
        setTitle("schoolTitle", "CommunityInfoDTO_school");
    });
    
    function setTitle(title, id){
    	var title = $("#" + title).val();
    	if(title != null && title != undefined){
    		var titled = "";
        	for(var i=0;i<=Math.round(title.length / 30);i++){
        		titled = titled + title.substring(i*30,30*(i+1)) + "\n";
        	}
        	titled = titled.substring(0, titled.length - 2);
        	$("#" + id).attr("title", titled);
    	}
    }

    function showModifyButton(){
        $("#cancelCommunityIdSpan").hide();
        $("#modifyCommunityIdSpan").show();
        $(".editDic").hide();
        $(".showDic").show();
    };

    function showCancelButton(){
        $("#modifyCommunityIdSpan").hide();
        $("#cancelCommunityIdSpan").show();
        $(".editDic").show();
        $(".showDic").hide();
    };
    
    /**
     * 将显示的内容转化为input：
     * 1、获取communityInfoForm下所有的Span
     * 2、获取每个Span的ID和value
     * 3、将该span的内容清空，填入input：其id是span的ID加上input；name是Span的ID（将_替换为.）；value为Span的Value
     */
    function translateCommunitySpanToInput(){
    };

    /**
     * Generate the text input
     * @param spanId
     * @param spanValue
     */
    function generateInputText(spanId, spanValue) {
        var inputId = spanId+"_input";
        //var inputName = inputId.replace("_", ".");
        $("#"+spanId).html("<input size='8' maxlength='9' type='text' id='"+inputId+"' value='"+spanValue+"'>");
    }

    /**
     *  Set the value for hidden input
     * @param spanId
     * @param spanValue
     */
    function assignValueForInputHidden(spanId, spanValue) {
        var hiddenId = spanId+"_Hidden";
        $("#"+hiddenId).val(spanValue);
    }

    /**
     * About canceling the screen of modifying community info
     */
    function translateCommunityInputToSpan(){
        $("#communityInfoForm").html(sourceSpanContent);
    }

    /**
     * About saving the community info that include New or modify
     */
    function saveCommunityInfo(){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        assignTextValueForHidden();
        $("#communityInfoForm").submitFormGetJson({
            url : "/populace/update",
            insertDiv :"communityBasicInfo",
            callback: function(data){
               $("#communityBasicInfo").empty();
               $("#communityBasicInfo").append(data);
               layui.use('layer', function(){
   				var layer = layui.layer;
   				layer.alert("修改成功！", {icon:0,title:'提示'});
   			});
            }
        });
    }

    /**
     * Assign value for hidden input
     */
    function assignTextValueForHidden() {
        $("form[id=communityInfoForm] input[type=text]").each(function(){
            //_input replace to _Hidden
            var tempId = this.id.replace("_input", "");
            assignValueForInputHidden(tempId, this.value);
        });
    }

    return {
    };
})();
