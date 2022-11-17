<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/idm/tb/diagnosis.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div>
	<div id="top_allDiagnosis">
		<div class="searchbox searchSection x-admin-sm">
			<form id="diagnosisSearchForm">
				<table id="diagnosisSearch">
					<colgroup>
						<col style="min-width:70px; width: 8%;"/>
						<col style="min-width:100px; width: 20%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 28%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:183px; width: 23%;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard" id="idcard3" cssClass="x-layui-input"/>
							<input type="button" id="check-submit-btn3" value="读卡" style="width: 40px;"></td>
						</tr>
						<tr>
							<td class="coltext">性别</td>
							<td class="colinput"><ehr:dic-list name="gender"
									dicmeta="GBT226112003" code="1,2"/></td>
							<td class="coltext">状态</td>
							<td class="colinput">
								<select name="diagnosisType" class="x-layui-input">
									<option value="">请选择</option>
									<option value="1">已诊断</option>
									<option value="2">未诊断</option>
								</select>
							</td>
                            <td colspan="2" class="centertd">
                                <%-- <input type="button" id="diagnosisBtnSearch" value="查询" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="diagnosisBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'diagnosisSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
			</div>
		<div id="listDivDiagnosis"></div>
	</div>
	<div id="detailDivDiagnosis"></div>
</div>