<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
	require(['views/ihm/deathAnalysTarget/index'],function(deathAnalysIndex){
		deathAnalysIndex.load();
	});
</script>
<div class="sectionnoborder">
	<ul id=tagsl>
		<li class=selectTag>
			<a id="tag1" href="javascript:void(0)" data-url="/ihm/deathAnalys/icd10ComposeChart">死因构成</a>
		</li>
		<li>
			<a id="tag2" href="javascript:void(0)" data-url="/ihm/deathAnalys/personTypeComposeChart">人群分类构成</a>
		</li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
		<div id="tagContent1" class="selectTag" ></div>
	</div>
</div>

