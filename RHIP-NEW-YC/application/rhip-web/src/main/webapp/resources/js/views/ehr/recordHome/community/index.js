/**
 *
 * 1, Loading 社区信息
 * 2, Loading 快捷办公
 * 3, Loading 建档情况
 * 4, Loading 其他统计
 *
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-11-30
 * Time: 上午10:41
 */

var communityIndex = (function() {

    var CommunityInfoUrl = contextPath+"/populace/index";
    var CommunityBasicInfoUrl = contextPath+"/populace/basicInfo";
    
    $(function() {
        //人口信息
        loadingCommunityInfo();
        //基本信息
        loadingCommunityBasicInfo()
        //快捷办公
        loadingShortcutOffice();
        //其他统计
        loadingOthersStat();
    });

    function loadingCommunityInfo() {
        $.loadHtmlByUrl({
            url: CommunityInfoUrl,
            insertDiv: "communityInfo"
        });
    };
    
    function loadingCommunityBasicInfo() {
        $.loadHtmlByUrl({
            url: CommunityBasicInfoUrl,
            insertDiv: "communityBasicInfo"
        });
    };

    function loadingShortcutOffice() {
    	$.getJsonByUrl({
		 	url : "/haStatistics/getQuickJob",
			callback : function(data){
				if (isEmpty(data)) {
					return;
				}
				$("#personWaitCreate").append(data.personWaitCreate);
				if(data.personWaitCreate > 0){
					$("#personWaitCreate").attr("style","text-decoration:underline;");
				}
				
				$("#personHadCreate").append(data.personHadCreate);
				if(data.personHadCreate > 0){
					$("#personHadCreate").attr("style","text-decoration:underline;");
				}
					
				$("#familyHadCreate").append(data.familyHadCreate);
				if(data.familyHadCreate > 0)
					$("#familyHadCreate").attr("style","text-decoration:underline;");
				
				$("#personHadWriteoff").append(data.personHadWriteoff);
				if(data.personHadWriteoff > 0)
					$("#personHadWriteoff").attr("style","text-decoration:underline;");
				
				$("#familyHadWriteoff").append(data.familyHadWriteoff);
				if(data.familyHadWriteoff > 0)
					$("#familyHadWriteoff").attr("style","text-decoration:underline;");
				else
					$("#familyHadWriteoff").attr("style","cursor：help");
			}
	 });
    };

    function loadingOthersStat() {
        //alert("Developing...");
    };

    return {

    };
})();