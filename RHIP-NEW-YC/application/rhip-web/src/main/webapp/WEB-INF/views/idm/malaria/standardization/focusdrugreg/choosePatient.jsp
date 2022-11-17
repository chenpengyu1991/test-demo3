<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/choosepatient.js" type="text/javascript"></script>
<div class="postcontent">
<div>
	<div id="register_top_all">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="patientSearchForm">
				<input type="hidden" id="idmId" name="idmId" value=""/>
		        <table id="patientSearch" >
					<colgroup>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 45%;"/>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 25%;"/>
					</colgroup>		
					<tbody>
						<tr>
                            <td class="coltext">所属城镇</td>
                            <td class="colinput" colspan="3" style="vertical-align: top; padding-top: 5px;">
                                <ehr:dic-town-centre-station centreName="acceptUnit" stationName="" townName="acceptTown" width="200px;" />
                            </td>

						</tr>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput">
                                <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                                <input type="text" style="display: none;">
                                <input type="text" name="name" /></td>
                            <td class="coltext">性别</td>
                            <td class="colinput">
                                <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2" width="100px"/>
                            </td>
                            <td rowspan="2">
		                           <input type="button" id="patientBtnSearch" value="查询" onclick="" class="search_btn"/>
		                	</td> 		                          
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="choosepatient.toggle(this,'patientSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="patientResultDiv"></div>
	</div>
</div>
<div class="toolbarpop">
	<input type="button" id="chooseOk" name="chooseOk" value="选择" onclick="choosepatient.chooseOk()">
	<input type="button" id="chooseCancel" name="chooseCancel" value="取消" onclick="idmCommon.closePopUp('chooseDialog')">
</div>
</div>