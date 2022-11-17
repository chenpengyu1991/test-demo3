<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ce/search.js"/>
<div class="section">
    <div  id="top_all">
        <div class="toolbar">
            <div style="position: relative">
                <a href="javascript:void(0)"><b class="xinz" id="addBtn">新增</b></a>
            </div>
        </div>
        <div class="searchbox">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width: 10%;"/>
                        <col style="width: 22%;"/>
                        <col style="width: 10%;"/>
                        <col style="width: 22%;"/>
                        <col style="width: 8%;"/>
                        <col style="width: 15%;"/>
                        <col/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">登记年份</td>
                        <td class="colinput">
                        	<tag:dateInput name="recordYearFrom" pattern="yyyy" style="width:36%;"></tag:dateInput>~<tag:dateInput name="recordYearTo" pattern="yyyy" style="width:36%;"></tag:dateInput>
                        </td>
                        <td class="coltext">举办单位</td>
                        <td class="colinput">
                        	<input type="text" name="organizer"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">姓名</td>
                        <td class="colinput">
                            <input type="text" name="name" >
                        </td>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
                            <input type="text" name="idCard">
                        </td>
                        <td class="coltext">职称</td>
                        <td class="colinput">
                            <select name="technical" style="width: 80px;">
                                <option value="">请选择</option>
                                <option value="1">初级</option>
                                <option value="2">中级</option>
                                <option value="3">高级</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">所属机构</td>
                        <td class="colinput" colspan="5">
                        	<ehr:authorize ifAnyGranted="02">
					    			 <ehr:dic-org-list name="station" width="200px;" defaultval="Y"/>
							  </ehr:authorize>
							  <ehr:authorize ifNotGranted="02">
					    			 <ehr:dic-town-centre-station isShow="true" centreName="centre" stationName="station" townName="town" isShowOther="true"  isShowInfirmary="true"
                                   isShowHealthOversight="true"  townId="sTown" centreId="sCenter" stationId="sStation" width="180px"/>
							  </ehr:authorize>
                         </td>

                        <td><input type="button" id="searchBtn" value="查询" class="search_btn"/></td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="colbottom">
                            <span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
                        	<input type="hidden" id="pageIndex" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="listDiv"></div>
    </div>
    <div id="detailDiv"></div>
</div>