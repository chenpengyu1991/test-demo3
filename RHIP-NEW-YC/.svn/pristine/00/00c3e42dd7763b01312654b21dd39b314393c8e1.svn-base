<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/list.js" type="text/javascript"></script>

<div  class="section" id="cdm-manage-list-box">
	<div class="toolbar">
          <a href="javascript:void(0)" ><b ></b></a>
    </div>   
		<div class="searchbox"  >
			<form method="post" id="form_search">
				<table id="conclusionSearch">
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:160px; width: 23%;"/>
	                    <col style="min-width:70px; width: 10%;"/>
						<col style="min-width:160px; width: 26%;"/>
	                    <col style="min-width:70px; width: 10%;"/>
						<col style="min-width:105px; width: 15%;"/>
						<col style="min-width:70px; width: 5%;"/>
					</colgroup>	
					<tbody>
						<tr>
							
							<td class="coltext" >姓名</td>
							<td class="colinput"><input type="text" name="personName" id="personName" /></td>
							
							<td class="coltext" >身份证号</td>
							<td class="colinput"><tag:idcardInput name="idCard" id="idcard" style="ime-mode:Disabled;"></tag:idcardInput>
								<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
							</td>
							
							<td class="coltext"  >患病类型</td>
							<td class="colinput" style="width: 80%;">
								<input type="checkbox" name="disType" value="1" />高血压
								<input type="checkbox" name="disType" value="2" />糖尿病
							</td>
						</tr>
						<tr>
							<td class="coltext">年龄段</td>
							<td class="colinput">
								<tag:numberInput maxlength="3"  name="beginAge" id="beginAge"  style="width: 34%;"/> ~ 
								<tag:numberInput maxlength="3"  name="endAge" id="endAge"  style="width: 34%;"/>岁
							</td>
							
							<td class="coltext">性别</td>
							<td class="colinput">
								<ehr:dic-list dicmeta="GBT226112003" name="genderCode" id="genderCode" />
							</td>
							
							<td class="coltext"  >状态</td>
							<td class="colinput" style="width: 80%">
								<input type="radio" name="planStatus" value="1" checked="checked"/>未建
								<input type="radio" name="planStatus" value="2"/>已建
							</td>
						
							<td  align="left">
								<input type="button" id="per_search_btn" value="查询"  class="search_btn"  width="80">
							</td>							
						</tr>
						
					<ehr:authorize ifAnyGranted="11,01">
						<tr>
							<td class="coltext">管理机构</td>
							<td colspan="3">
								<ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" width="27.5%;"/>
							</td>
						</tr>
					</ehr:authorize>
					
					<ehr:authorize ifAnyGranted="03">
						<tr>
							<td class="coltext">管理机构</td>
							<td colspan="3">
									<ehr:dic-org-list id="nowAddressCode" name="stationOrganCode"  width="27.5%;"></ehr:dic-org-list>
							</td>
						</tr>
					</ehr:authorize>
						
					</tbody>
				</table>
				 <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="cdmManagePlanlist.toggle(this,'conclusionSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
		</div>
		<div id="planInfo" class="repeattable" >
		</div>
	</div>
	<div id="cdm-manage-input-box" class="postdiv" >
	</div>

