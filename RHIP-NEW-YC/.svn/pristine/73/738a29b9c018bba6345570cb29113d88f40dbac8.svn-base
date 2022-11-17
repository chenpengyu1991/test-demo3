<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/js/views/idm/tb/ndy/fuyao.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>
<div class="section">
	<div id="top_allNdy">
		<div class="searchbox searchSection x-admin-sm">
			<form id="ndyFuyaoSearchForm">
				<input type="hidden" name="typeTb" id="typeTb" value="${typeTb }"/>			
                <table id="ndySearch" >
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 15%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 25%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 20%;"/>
						<col style="min-width:90px; width: 10%;"/>
					</colgroup>			
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input" /></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard" id="idCardNdy2" cssClass="x-layui-input"/>&nbsp;
								<input type="button" id="check-submit-btnNdy2" value="读卡" style="width: 40px;"></td>
							<td class="coltext">性别</td>
							<td class="colinput">
								<ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2" cssClass="x-layui-input"/>
								<input type="hidden" name="ndyFlag" value="1" />
							</td>

							<td class="centertd">
                                <%-- <input type="button" id="ndyFuyaoBtnSearch" value="查询" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="ndyFuyaoBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'ndySearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="listDivNdyFuyao"></div>
	</div>
	<div id="detailDivNdy"></div>
</div>

