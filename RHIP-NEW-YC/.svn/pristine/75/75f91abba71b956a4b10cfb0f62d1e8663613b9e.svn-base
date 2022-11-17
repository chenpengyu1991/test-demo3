<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/standardSearch.js" type="text/javascript"></script>
<c:choose>
	<c:when test="${standardType==5}">
		<div class="toolbar">
			<a href="javascript:void(0)" onclick="standardSearch.addFg()"><b class="xinz">新建</b></a>
		</div>
	</c:when>
	<c:when test="${standardType==6}">
		<div class="toolbar">
			<a href="javascript:void(0)" onclick="standardSearch.addAi()"><b class="xinz">新建</b></a>
		</div>
	</c:when>	
</c:choose>
<div class="searchbox">
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<input type="hidden" id="idmId" value="">
	<input type="hidden" id="standardType" value="${standardType}">
	<form id="standardSearchForm">	
		<c:choose>
			<c:when test="${standardType==1 || standardType==2 || standardType==3 ||standardType==4 }">
		        <table id="standardSearch" >
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 25%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 25%;"/>
						<col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 20%;"/>
                    </colgroup>
					<tbody>
                    <tr>
                        <td class="coltext">患者姓名</td>
                        <td class="colinput"><input type="text" name="name"/></td>
                        <td class="coltext">发病日期</td>
                        <td class="colinput">
                            <tag:dateInput nullToToday="true" id="pathogenesisBeginDate" name="pathogenesisBeginDate"
                                           pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;"></tag:dateInput>
                            ~<tag:dateInput nullToToday="true" id="pathogenesisEndDate" name="pathogenesisEndDate"
                                            pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;" reg='{"compare":["pathogenesisBeginDate","ge","结束时间不能早于开始时间"]}'></tag:dateInput>
                        </td>
                        <td class="coltext">档案状态</td>
                        <td class="colinput">
                            <ehr:dic-radio  name="logoff" dicmeta="PH00031" value="" isDefault="Y"/>
                        </td>                         
                    </tr>
                    <tr>
                        <td class="coltext">患者性别</td>
                        <td class="colinput">
                            <ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" value="" isDefault="Y"/>
                        </td>
                        <td class="coltext">血检日期</td>
                        <td class="colinput">
                            <tag:dateInput nullToToday="true" id="testBeginDate" name="testBeginDate"
                                           pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;"></tag:dateInput>
                            ~<tag:dateInput nullToToday="true" id="testEndDate" name="testEndDate" pattern="yyyy/MM/dd"
                                            onlypast="true" style="width: 36%;" reg='{"compare":["testBeginDate","ge","结束时间不能早于开始时间"]}'></tag:dateInput>
                        </td>
                        <td></td>
                        <td>
                            <input type="button" id="standardBtnSearch" value="查询" onclick="" class="search_btn"/>
                        </td>
                    </tr>
					</tbody>
				</table>
			</c:when>
			<c:when test="${standardType==5}">
		        <table id="standardSearch" >
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:183px; width: 23%;"/>
					</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">患者姓名</td>
							<td class="colinput"><input type="text" name="name" /></td>
                            <td class="coltext">所属机构</td>
                            <td class="colinput" rowspan="2" style="vertical-align: top; padding-top: 5px;">
                            	<c:choose>
                            		<c:when test="${empty acceptUnit}">
                            			<ehr:dic-town-centre-station centreName="acceptUnit" centreValue="${acceptUnit}" stationName="" townName="acceptTown" townValue="${acceptTown}"/>
                            		</c:when>
                            		<c:otherwise>
                            			<select  title="<ehr:dic dicmeta="FS990001" code="${acceptTown}"/>" name="acceptTown">
                            				<option title="<ehr:dic dicmeta="FS990001" code="${acceptTown}"/>" value="${acceptTown}"><ehr:dic dicmeta="FS990001" code="${acceptTown}"/></option>
                            			</select>
                            			<select  title="<ehr:org code="${acceptUnit}"/>" name="acceptUnit">
                            				<option title="<ehr:org code="${acceptUnit}"/>" value="${acceptUnit}"><ehr:org code="${acceptUnit}"/></option>
                            			</select>	
                            		</c:otherwise>
                            	</c:choose>
                            </td>
                            <td class="coltext">填表日期</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="reportBeginDate" name="reportBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="reportEndDate" name="reportEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;" reg='{"compare":["reportBeginDate","ge","结束时间不能早于开始时间"]}'></tag:dateInput>
							</td>   
						</tr>
						<tr>
                            <td class="coltext">患者性别</td>
                            <td class="colinput">
                                <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2" />
                            </td>
                            <td></td>
                            <td></td>
                            <td>
                                <input type="button" id="standardBtnSearch" value="查询" onclick="" class="search_btn"/>
                                <input type="button" id="fgDown" value="导出" onclick="" class="search_btn"/>
                            </td>
                        </tr>
					</tbody>
				</table>
			</c:when>
			<c:when test="${standardType==6}">
            <table id="standardSearch" >
                <colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:183px; width: 23%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">患者姓名</td>
                    <td class="colinput">
                        <input type="text" name="name" />
                            <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                        <input type="text" style="display: none;">
                    </td>
                    <td class="coltext">所属机构</td>
                    <td class="colinput" rowspan="2" style="vertical-align: top; padding-top: 5px;">
                    	<c:choose>
	                 		<c:when test="${empty acceptUnit}">
	                 			<ehr:dic-town-centre-station centreName="acceptUnit" centreValue="${acceptUnit}" stationName="" townName="acceptTown" townValue="${acceptTown}"/>
	                 		</c:when>
                 			<c:otherwise>
	                 			<select  title="<ehr:dic dicmeta="FS990001" code="${acceptTown}"/>" name="acceptTown">
	                 				<option title="<ehr:dic dicmeta="FS990001" code="${acceptTown}"/>" value="${acceptTown}"><ehr:dic dicmeta="FS990001" code="${acceptTown}"/></option>
	                 			</select>
	                 			<select  title="<ehr:org code="${acceptUnit}"/>" name="acceptUnit">
	                 				<option title="<ehr:org code="${acceptUnit}"/>" value="${acceptUnit}"><ehr:org code="${acceptUnit}"/></option>
	                 			</select>	
                 			</c:otherwise>
                 		</c:choose>
                    </td>
                    <td class="coltext">走访结果</td>
                    <td class="colinput">
                        <ehr:dic-list name="visitResult" dicmeta="IDM00273"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">患者性别</td>
                    <td class="colinput">
                        <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2"/>
                    </td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="button" value="查询" onclick="standardSearch.searchStandard()" class="search_btn"/>
                        <input type="button" value="导出" onclick="standardSearch.aiDown()" class="search_btn"/>
                    </td>
                </tr>
                </tbody>
            </table>
			</c:when>
         </c:choose>					
        <table>
               <tr>
                   <td colspan="6" class="colbottom">
                         <span onclick="malariaIndex.toggle(this,'standardSearch')" class="ico-bottom">&nbsp;</span>
                   </td>
               </tr>
		</table>
	 </form>
</div>