<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script>
	$(function() {
		toggleOtherCK('symptom','symptomOther','99');
		standardization.firstVistChange();
	});
</script>
<div class="postcontent">
	<form id="addFrForm" method="get">
		<input type="hidden" id="rowIndexed" value="${rowIndex}"/>
			<table class="formtable" id="popFrTable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 30%" />
					<col style="width: 20%" />
					<col style="width: 30%" />
				</colgroup>
				<tr>
					<th>是否首次随访：</th>
					<td>
						<ehr:dic-list name="firstVist" id="firstVist" onchange="standardization.firstVistChange();"  dicmeta="IDM00420" value="${listSr.firstVist}"/>
					</td>
					<th><span name="firstTr">患者类型：</span></th>
					<td ><span name="firstTr">
						<ehr:dic-list name="patType" defaultval="true" dicmeta="IDM00421" value="${listSr.patType}"/>
						</span>
					</td>
				</tr>
				<tr name="firstTr">
					<th>痰菌情况：</th>
					<td>
						<ehr:dic-list name="tjResult" dicmeta="IDM00422" value="${listSr.tjResult}"/>
					</td>
					<th>耐药情况：</th>
					<td>
						<ehr:dic-list name="nyResult" dicmeta="IDM00423" value="${listSr.nyResult}"/>
					</td>
				</tr>
			</table>
				<div class="postdiv" name="firstTr">
					<fieldset class="layui-elem-field">
						<legend>家庭居住环境评估</legend>
						<table class="formtable">
							<colgroup>
								<col style="width: 20%" />
								<col style="width: 30%" />
								<col style="width: 20%" />
								<col style="width: 30%" />
							</colgroup>
							<tbody>
							<tr >
								<th><label class="">单独居室：</label></th>
								<td>
									<ehr:dic-list name="room" dicmeta="IDM00418" value="${listSr.room}"/>
								</td>
								<th>通风情况：</th>
								<td>
									<ehr:dic-list name="wind" dicmeta="IDM00424" value="${listSr.wind}"/>
								</td>
							</tr>
							</tbody>
						</table>
					</fieldset>
				</div>
			<table class="formtable" >
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 30%" />
					<col style="width: 20%" />
					<col style="width: 30%" />
				</colgroup>
				<tr>
					<th>随访时间：</th>
					<td>
                         <%--<tag:dateInput name="visitTime" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                         	 date="${listSr.visitTime==null ? nowDate : listSr.visitTime}"/>--%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="visitTime" id="visitTime" value="<fmt:formatDate value='${listSr.visitTime==null ? nowDate : listSr.visitTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
					</td>
					<th name="firstHide">治疗月序：</th>
					<td name="firstHide">
						<tag:numberInput name="monthCount" value="${listSr.monthCount}"
                                     style="width: 140px"
                                     reg="{'min':0,'max':12}" id="leftBloodUp" maxlength="2"/>
					</td>
				</tr>
				<tr>
					<th>督导人员：</th>
					<td>
						<ehr:dic-list name="supervisorType" dicmeta="IDM00413" value="${listSr.supervisorType}"/>
					</td>
					<th>随访方式：</th>
					<td>
						<ehr:dic-list name="visitType" dicmeta="IDM00414" value="${listSr.visitType}"/>
					</td>
				</tr>
				<tr>
					<th>症状及体征：</th>
					<td colspan="3">
						<ehr:dic-checkbox id="occupation" dicmeta="IDM00415" name="symptom"  value="${listSr.symptom}"
                                              reg='{"required":"false"}' onchange="toggleOtherCK('symptom','symptomOther','99')"/>
                            <span id="symptomOther" style="display: none">
									<input type="text" name="symptomOther" value="${listSr.symptomOther}"
                                           style="width: 30%;" reg='{"maxlength":"20"}'/>
								</span>
									
						<%--onchange="toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299')"--%>
					</td>
				</tr>
			</table>
				<div class="postdiv" >
					<fieldset class="layui-elem-field">
						<legend>生活方式评估</legend>
						<table class="formtable">
							<colgroup>
								<col style="width: 20%" />
								<col style="width: 30%" />
								<col style="width: 20%" />
								<col style="width: 30%" />
							</colgroup>
							<tr>
								<th>吸烟：</th>
								<td>
									<input type="text" name="smoke" reg='{"maxlength":"2"}' value="${listSr.smoke}" maxlength="2">
									支/天
								</td>
								<th>饮酒：</th>
								<td>
									<input type="text" name="drink" reg='{"maxlength":"2"}' value="${listSr.drink}" maxlength="2">
									两/天
								</td>
							</tr>
						</table>
					</fieldset>
				</div>

			<div class="postdiv" >
				<fieldset class="layui-elem-field">
					<legend>用药</legend>
					<table class="formtable">
						<colgroup>
							<col style="width: 20%" />
							<col style="width: 30%" />
							<col style="width: 20%" />
							<col style="width: 30%" />
						</colgroup>
							<tr>
								<th>化疗方案：</th>
								<td>
									<ehr:dic-list name="method" dicmeta="IDM00635" value="${listSr.method}"/>
									<%-- <input type="text" name="method" reg='{"maxlength":"200"}' value="${listSr.method}" maxlength="50"> --%>
								</td>
								<th>用法：</th>
								<td>
									<ehr:dic-list name="usage" dicmeta="IDM00416" value="${listSr.usage}"/>
								</td>
							</tr>
							<tr>
								<th>药品剂型：</th>
								<td>
									<ehr:dic-list name="drugForm" dicmeta="IDM00417" value="${listSr.drugForm}"/>
								</td>
								<th name="firstHide">漏服次数：</th>
								<td name="firstHide">
									<input type="text" name="forgotTimes" reg='{"maxlength":"2"}' value="${listSr.forgotTimes}" maxlength="2">次
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
			<table class="formtable" >
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 30%" />
					<col style="width: 20%" />
					<col style="width: 30%" />
				</colgroup>
				<tr name="firstHide">
					<th>药物不良反应：</th>
					<td>
						<ehr:dic-list name="untowardEffect" dicmeta="IDM00418" value="${listSr.untowardEffect}"/>
					</td>
					<th>并发症/合并症：</th>
					<td>
						<ehr:dic-list name="complication" dicmeta="IDM00418" value="${listSr.complication}"/>
					</td>
				</tr>
				<tr name="firstHide"><th>转诊</th></tr>
				<tr name="firstHide">
					<th>科室：</th>
					<td>
						<input type="text" name="clicName" value="${listSr.clicName}" maxlength="20">
					</td>
					<th>科别：</th>
					<td>
						<input type="text" name="clic" value="${listSr.clic}" maxlength="20">
					</td>
				</tr>
				<tr name="firstHide">
					<th>原因：</th>
					<td>
						<input type="text" name="season" value="${listSr.season}" maxlength="20">
					</td>
					<th>2周内随访结果：</th>
					<td>
						<input type="text" name="visitResult" value="${listSr.visitResult}" maxlength="20">
					</td>

				</tr>
				<tr name="firstHide">
					<th>处理意见：</th>
					<td colspan="3">
						<input type="text" name="adv" value="${listSr.adv}" maxlength="20">
					</td>
				</tr>
			</table>
				<div class="postdiv" name="firstTr">
					<fieldset class="layui-elem-field">
						<legend>健康教育及培训</legend>
						<table class="formtable">
							<colgroup>
								<col style="width: 20%" />
								<col style="width: 30%" />
								<col style="width: 20%" />
								<col style="width: 30%" />
							</colgroup>
							<tr >
								<th>取药地点：</th>
								<td>
									<input type="text" name="drugPlace" value="${listSr.drugPlace}">
								</td>
								<th>取药时间：</th>
								<td>
									<%--<tag:dateInput name="drugDate" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
												   date="${listSr.drugDate==null ? nowDate : listSr.drugDate}"/>--%>
									<input type="text" class="layui-input x-admin-content-sm-date" name="drugDate" id="drugDate" value="<fmt:formatDate value='${listSr.drugDate==null ? nowDate : listSr.drugDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
								</td>
							</tr>
							<tr >
								<th>服药记录卡填写：</th>
								<td>
									<ehr:dic-list name="drugRecord" dicmeta="IDM00425" value="${listSr.drugRecord}"/>
								</td>
								<th>服药方法及药品存放：</th>
								<td>
									<ehr:dic-list name="drugSave" dicmeta="IDM00425" value="${listSr.drugSave}"/>
								</td>
							</tr>
							<tr >
								<th>肺结核治疗疗程：</th>
								<td>
									<ehr:dic-list name="treTub" dicmeta="IDM00425" value="${listSr.treTub}"/>
								</td>
								<th>不规律服药危害：</th>
								<td>
									<ehr:dic-list name="drugHarm" dicmeta="IDM00425" value="${listSr.drugHarm}"/>
								</td>
							</tr>
							<tr >
								<th>服药后不良反应及处理：</th>
								<td>
									<ehr:dic-list name="drugUntowardEffect" dicmeta="IDM00425" value="${listSr.drugUntowardEffect}"/>
								</td>
								<th>治疗期间复诊查痰：</th>
								<td>
									<ehr:dic-list name="recheck" dicmeta="IDM00425" value="${listSr.recheck}"/>
								</td>
							</tr>
							<tr >
								<th>外出期间如何坚持服药：</th>
								<td>
									<ehr:dic-list name="outsideKeep" dicmeta="IDM00425" value="${listSr.outsideKeep}"/>
								</td>
								<th>生活习惯及注意事项：</th>
								<td>
									<ehr:dic-list name="notice" dicmeta="IDM00425" value="${listSr.notice}"/>
								</td>
							</tr>
							<tr >
								<th>密切接触者检查：</th>
								<td>
									<ehr:dic-list name="contactCheck" dicmeta="IDM00425" value="${listSr.contactCheck}"/>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
			<table class="formtable" >
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 30%" />
					<col style="width: 20%" />
					<col style="width: 30%" />
				</colgroup>
				<tr>
					<th>下次随访时间：</th>
					<td>
						<%--<tag:dateInput name="nextVisitTime" nullToToday="true"  pattern="yyyy/MM/dd"
									   date="${listSr.nextVisitTime==null ? nowDate : listSr.nextVisitTime}"/>--%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="nextVisitTime" id="nextVisitTime" value="<fmt:formatDate value='${listSr.nextVisitTime==null ? nowDate : listSr.nextVisitTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
					</td>
					<th>随访医生：</th>
					<td>
						<input type="text" name="visitDoctor" value="${listSr.visitDoctor==null?currentLoginInfo.user.name:listSr.visitDoctor}" maxlength="20">
					</td>
					<input type="hidden" name="id" value="${listSr.id}"/>
					<input type="hidden" name="idmId" id="idmId" value="${listSr.idmId==null?singleId:listSr.idmId}"/>
					<input type="hidden" name="visitInst" value="${listFr.visitInst==null ? currentLoginInfo.organization.organCode : listFr.visitInst }">
					<input type="hidden" name="visitById" value="${listFr.visitById == null ? currentLoginInfo.user.id : listFr.visitById}"/>
				</tr>
			</table>

	</form>
<%--    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                &lt;%&ndash;<input type="button" id="saveContact" value="添加" onclick="standardization.saveServiceRecord()">&ndash;%&gt;
				<button class="layui-btn layui-btn-sm"  id="saveContact" onclick="standardization.saveServiceRecord()">添加</button>
            </c:if>
            <c:if test="${type == 'edit'}">
                &lt;%&ndash;<input type="button" id="editContact" value="修改" onclick="standardization.saveServiceRecord()">&ndash;%&gt;
				<button class="layui-btn layui-btn-sm"  id="editContact" onclick="standardization.saveServiceRecord()">修改</button>
            </c:if>
            &lt;%&ndash;<input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('fwDialog')">&ndash;%&gt;
		<button class="layui-btn layui-btn-sm"  id="cancelContact" onclick="standardization.closeAll('fwDialog')">取消</button>
    </div>--%>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#visitTime'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });

        laydate.render({
            elem: '#drugDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });

        laydate.render({
            elem: '#nextVisitTime'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
    });
</script>