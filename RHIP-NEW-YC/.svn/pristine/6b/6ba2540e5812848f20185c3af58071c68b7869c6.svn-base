<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/populace/index.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <div id="inquiry" style="width:100%;height: 313px;">
    <b class="jiandang">基础信息</b>
    <br/>
    <span id="modifyCommunityIdSpan">
       	&nbsp;&nbsp;<a class="xiug" style="height:26px;" href="javascript:void(0);" id="modifyCommunityId">修改</a>
        &nbsp;&nbsp;<a class="baocun" style="height:26px;" href="javascript:void(0);" id="modifyCommunityId">保存</a>
    </span>
    <span id="cancelCommunityIdSpan">
		&nbsp;&nbsp;<a class="quxiao" style="height:26px;" href="javascript:void(0);" id="cancelCommunityId">取消</a>&nbsp;&nbsp;&nbsp;
		<a class="baocun" style="height:26px;" href="javascript:void(0);" id="saveCommunityId">保存</a>
    </span>
    <input type="hidden" name="CommunityInfoDTO.populace.id" id="CommunityInfoDTO_populace_id_Hidden" value="${CommunityInfoDTO.populace.id}"/>
	    <form action="#" id="communityInfoForm">
	    <div class="postcontent">
	    	<table style="width: 97%"  class="posttable">
	       			<tr>
	       				<td style="width: 30%;text-align: right;">环境状况：</td>
	       				<td style="width: 70%">
	       					<div class="showDic"  title=<ehr:dic dicmeta="FS10248" code="${CommunityInfoDTO.environment}"></ehr:dic>>
	       						<ehr:dic dicmeta="FS10248" code="${CommunityInfoDTO.environment}"></ehr:dic>
	       					</div>
	       					<div class="editDic">
	       						<ehr:dic-list id="environmentType" dicmeta="FS10248" value="${CommunityInfoDTO.environment}" name="CommunityInfoDTO.environment" type="true"/>
	       					</div>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td style="text-align: right;">
	       					<div style="height: 40px;text-align: right;">饮用水：</div>
	       				</td>
	       				<td>
	       					<div class="showDic" style="height: 40px;" title=<ehr:dic dicmeta="CV0300115" code="${CommunityInfoDTO.water}"></ehr:dic>>
	       						<ehr:dic dicmeta="CV0300115" code="${CommunityInfoDTO.water}"></ehr:dic>
	       					</div>
	       					<div class="editDic" style="height: 40px;">
	       						<ehr:dic-list dicmeta="CV0300115" id="waterType" value="${CommunityInfoDTO.water}" name="CommunityInfoDTO.water" type="true"/>
	       					</div>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td style="text-align: right;"><div style="height: 40px;text-align: right;">垃圾处理：</div></td>
	       				<td>
	       					<div class="showDic" style="height: 40px;" title=<ehr:dic dicmeta="FS10247" code="${CommunityInfoDTO.garbage}"></ehr:dic>>
	       						<ehr:dic dicmeta="FS10247" code="${CommunityInfoDTO.garbage}"></ehr:dic>
	       					</div>
	       					<div class="editDic" style="height: 40px;">
	       						<ehr:dic-list id="rubbishType" dicmeta="FS10247" value="${CommunityInfoDTO.garbage}" name="CommunityInfoDTO.garbage" type="true"/>
	       					</div>
	       				</td>
	       			</tr>
					<tr>
	       				<td style="text-align: right;">经济状况：</td>
	       				<td>
	       					<span id="CommunityInfoDTO_economic" class="showDic" title="${CommunityInfoDTO.economic}万/年">
	       						<c:out value="${CommunityInfoDTO.economic}"/>
	       					</span>
	       					<input type="text" class="editDic" name="CommunityInfoDTO.economic" id="CommunityInfoDTO_economic" value="${CommunityInfoDTO.economic}" reg='{"min":0,"max":999999.99999}'/>万/年
	       				</td>
	       			</tr>
					<tr>
	       				<td style="text-align: right;">养老院：</td>
	       				<td>
	       					<div style="width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
		       					<span id="CommunityInfoDTO_oldPeopleHome" class="showDic" >
		       						<c:out value="${CommunityInfoDTO.oldPeopleHome}"/>
		       						<input id="oldPeopleTitle" value="${CommunityInfoDTO.oldPeopleHome}" type="hidden"/>
		       					</span>
	       					</div>
	       					<input type="text" class="editDic" name="CommunityInfoDTO.oldPeopleHome" id="CommunityInfoDTO_oldPeopleHome" value="${CommunityInfoDTO.oldPeopleHome}" reg='{"maxlength":"333"}'/>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td style="text-align: right;">学校：</td>
	       				<td>
	       					<div style="width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
		       					<span id="CommunityInfoDTO_school" class="showDic" title="${CommunityInfoDTO.school}">
		       						<c:out value="${CommunityInfoDTO.school}"/>
		       						<input id="schoolTitle" value="${CommunityInfoDTO.school}" type="hidden"/>
		       					</span>
	       					</div>
	       					<input type="text" class="editDic" name="CommunityInfoDTO.school" id="CommunityInfoDTO_school" value="${CommunityInfoDTO.school}" reg='{"maxlength":"333"}'/>
	       				</td>
	       			</tr>
			</table>
			</div>
		</form>
</div> --%>
<fieldset class="layui-elem-field" style="width: 99%;height: 313px;">
            <legend>基础信息</legend>
             <span id="modifyCommunityIdSpan">
       	&nbsp;&nbsp;<%-- <a class="xiug" style="height:26px;" href="javascript:void(0);" id="modifyCommunityId">修改</a> --%>
       	<a href="#" title="修改" id="modifyCommunityId"><i class="layui-icon">&#xe642;</i></a>
        &nbsp;&nbsp;<%-- <a class="baocun" style="height:26px;" href="javascript:void(0);" id="modifyCommunityId">保存</a> --%>
        <a href="#" title="保存" id="modifyCommunityId"></a>
    </span>
    <span id="cancelCommunityIdSpan">
		&nbsp;&nbsp;
		<%-- <a class="quxiao" style="height:26px;" href="javascript:void(0);" id="cancelCommunityId">取消</a> --%>
		<a href="#" title="取消" id="cancelCommunityId"><i class="layui-icon">&#xe65c;</i></a>
		&nbsp;&nbsp;&nbsp;
		<%-- <a class="baocun" style="height:26px;" href="javascript:void(0);" id="saveCommunityId">保存</a> --%>
		<a href="#" title="保存" id="saveCommunityId"><i class="layui-icon"> &#xe605;</i></a>
    </span>
    <input type="hidden" name="CommunityInfoDTO.populace.id" id="CommunityInfoDTO_populace_id_Hidden" value="${CommunityInfoDTO.populace.id}"/>
	    <form action="#" id="communityInfoForm">
	    <div class="postcontent">
	    	<table style="width: 97%"  class="posttable">
	       			<tr>
	       				<td style="width: 30%;text-align: right;">环境状况：</td>
	       				<td style="width: 70%">
	       					<div class="showDic"  title=<ehr:dic dicmeta="FS10248" code="${CommunityInfoDTO.environment}"></ehr:dic>>
	       						<ehr:dic dicmeta="FS10248" code="${CommunityInfoDTO.environment}"></ehr:dic>
	       					</div>
	       					<div class="editDic">
	       						<ehr:dic-list id="environmentType" dicmeta="FS10248" value="${CommunityInfoDTO.environment}" name="CommunityInfoDTO.environment" type="true"/>
	       					</div>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td style="text-align: right;">
	       					<div style="height: 40px;text-align: right;">饮用水：</div>
	       				</td>
	       				<td>
	       					<div class="showDic" style="height: 40px;" title=<ehr:dic dicmeta="CV0300115" code="${CommunityInfoDTO.water}"></ehr:dic>>
	       						<ehr:dic dicmeta="CV0300115" code="${CommunityInfoDTO.water}"></ehr:dic>
	       					</div>
	       					<div class="editDic" style="height: 40px;">
	       						<ehr:dic-list dicmeta="CV0300115" id="waterType" value="${CommunityInfoDTO.water}" name="CommunityInfoDTO.water" type="true"/>
	       					</div>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td style="text-align: right;"><div style="height: 40px;text-align: right;">垃圾处理：</div></td>
	       				<td>
	       					<div class="showDic" style="height: 40px;" title=<ehr:dic dicmeta="FS10247" code="${CommunityInfoDTO.garbage}"></ehr:dic>>
	       						<ehr:dic dicmeta="FS10247" code="${CommunityInfoDTO.garbage}"></ehr:dic>
	       					</div>
	       					<div class="editDic" style="height: 40px;">
	       						<ehr:dic-list id="rubbishType" dicmeta="FS10247" value="${CommunityInfoDTO.garbage}" name="CommunityInfoDTO.garbage" type="true"/>
	       					</div>
	       				</td>
	       			</tr>
					<tr>
	       				<td style="text-align: right;">经济状况：</td>
	       				<td>
	       					<span id="CommunityInfoDTO_economic" class="showDic" title="${CommunityInfoDTO.economic}万/年">
	       						<c:out value="${CommunityInfoDTO.economic}"/>
	       					</span>
	       					<input type="text" class="editDic" name="CommunityInfoDTO.economic" id="CommunityInfoDTO_economic" value="${CommunityInfoDTO.economic}" reg='{"min":0,"max":999999.99999}'/>万/年
	       				</td>
	       			</tr>
					<tr>
	       				<td style="text-align: right;">养老院：</td>
	       				<td>
	       					<div style="width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
		       					<span id="CommunityInfoDTO_oldPeopleHome" class="showDic" >
		       						<c:out value="${CommunityInfoDTO.oldPeopleHome}"/>
		       						<input id="oldPeopleTitle" value="${CommunityInfoDTO.oldPeopleHome}" type="hidden"/>
		       					</span>
	       					</div>
	       					<input type="text" class="editDic" name="CommunityInfoDTO.oldPeopleHome" id="CommunityInfoDTO_oldPeopleHome" value="${CommunityInfoDTO.oldPeopleHome}" reg='{"maxlength":"333"}'/>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td style="text-align: right;">学校：</td>
	       				<td>
	       					<div style="width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
		       					<span id="CommunityInfoDTO_school" class="showDic" title="${CommunityInfoDTO.school}">
		       						<c:out value="${CommunityInfoDTO.school}"/>
		       						<input id="schoolTitle" value="${CommunityInfoDTO.school}" type="hidden"/>
		       					</span>
	       					</div>
	       					<input type="text" class="editDic" name="CommunityInfoDTO.school" id="CommunityInfoDTO_school" value="${CommunityInfoDTO.school}" reg='{"maxlength":"333"}'/>
	       				</td>
	       			</tr>
			</table>
			</div>
		</form>
 </fieldset>