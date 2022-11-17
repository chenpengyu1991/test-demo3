<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

	<div class="postcontent">
			<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend><span style="font-size: 12px;">肿瘤随访</span></legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label for="visitDate">随访日期</label></th>
					<td><fmt:formatDate value="${tumor.visitDate}" pattern="yyyy/MM/dd"/></td>
				<tr>
					<th><label  for="visitWayCode">随访方式</label></th>
					<td><ehr:dic dicmeta="DMD00026"  code="${tumor.visitWayCode}" ></ehr:dic>
				</tr>
				<tr>
					<th>是否失访</th>
					<td><ehr:dic dicmeta="FS10246" code="${tumor.lossVisit}"></ehr:dic></td>
				</tr>
				<tr ${tumor.lossVisit !='1'?'style="display:none"':'' }>
                    <th>失访原因</th>
                    <td>
                        <ehr:dic dicmeta="CDM00004" code="${tumor.lossVisitReason}" ></ehr:dic>
                        <span id="lossVisit-reason" ${!(tumor.lossVisitReason).contains('7')?'style="display:none"':'' } >
                            :${tumor.lossVisitReasonDesc}
                        </span>
                    </td>
                </tr>
				<tr>
                    <th>具体随访地址</th>
                    <td>
                        <ehr:dic dicmeta="CDM00005" code="${tumor.followupPlace }"></ehr:dic>
                        <br />
                        <span id="tumor-followupPlace"  ${tumor.followupPlace !='3'?'style="display:none"':'' }>
                            <label id="tempFlValue">
                                <ehr:dic code="${tumor.fltownShip}" dicmeta="FS990001"/>
                                <ehr:dic code="${tumor.flstreet}" dicmeta="FS990001"/>
                                <ehr:dic code="${tumor.flGroup}" dicmeta="FS990001"/>
                            </label>
                            ${tumor.flhouseNumber}
                        </span>
                    </td>
                </tr>
				<tr>
					<th>是否治疗</th>
					<td><ehr:dic dicmeta="DMD00048" code="${tumor.cure }"></ehr:dic></td>
				</tr>
				<tr id="tumor-cure" ${tumor.cure !='1'?'style="display:none"':'' }>
                    <th>治疗方式</th>
                    <td>
                        <ehr:dic dicmeta="DMD00047" code="${tumor.cureProject}"></ehr:dic>
                    </td>
                </tr>
                <tr>
                    <th>是否死亡</th>
                    <td><ehr:dic dicmeta="FS10246" code="${tumor.death }"></ehr:dic></td>
                </tr>
				 <tr id="tumor-deathDate" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th>死亡日期</th>
                    <td>
                    	<fmt:formatDate value="${tumor.deathDate}" pattern="yyyy/MM/dd"/>
                    </td>
                </tr>
                <tr id="tumor-deathForTumor" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th>是否死于肿瘤</th>
                    <td><ehr:dic dicmeta="FS10246" code="${tumor.deathForTumor }" /></td>
                </tr>
                <tr id="tumor-deathReason" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th>根本死因</th>
                    <td>${tumor.deathReason}</td>
                </tr>
                <tr id="tumor-deathPlace" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th>死亡地点</th>
                    <td>
                        <ehr:dic dicmeta="DMD00052" code="${tumor.deathPlaceCode }"/>
                        <span style="display:${tumor.deathPlaceCode !='4'?'none':'inline' }" id="death-place">
                            	：${tumor.deathPlace }
                        </span>
                    </td>
                </tr>
                 <tr>
                    <th>是否撤销随访</th>
                    <td><ehr:dic dicmeta="FS10246" code="${tumor.cancel }"></ehr:dic></td>
                </tr>
                <tr id="tumor-cancelDate" ${tumor.cancel !='1'?'style="display:none"':'' }>
                    <th>撤销随访日期</th>
                    <td><fmt:formatDate value="${tumor.cancelDate}" pattern="yyyy/MM/dd"/></td>
                </tr>
                <tr id="tumor-cancelRea" ${tumor.cancel !='1'?'style="display:none"':'' }>
                    <th>撤销随访原因</th>
                    <td><ehr:dic dicmeta="CDM00006" code="${tumor.cancelReason }" /></td>
                </tr>
			</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend><span style="font-size: 12px;">工作记录</span></legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label>调查日期</label></th>
					<td><fmt:formatDate value="${input.createDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th><label>调查医师签名</label></th>
					<td>${input.createDoctorName}</td>
				</tr>
				<tr>
					<th><label>调查单位</label></th>
					<td><ehr:org code="${input.createOrganCode}"></ehr:org></td>
				</tr>
				<tr>
					<th><label>核查医师签名</label></th>
					<td>${input.createDoctorName}</td>
				</tr>
			</table>
		</fieldset>
		</div>
	</div>