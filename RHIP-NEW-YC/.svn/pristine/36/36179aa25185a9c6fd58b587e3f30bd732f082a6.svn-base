<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/mhm/patient/move/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>



	<div class="section" id="patientMove_top_all">

        <div class="toolbar">
            <!-- <a href="javascript:void(0)" id="outButtonDiv" onclick="javascript:patientMoveSearch.popSransfer(1, null)"><b class="fanhui">迁出</b></a> -->
            <a href="javascript:void(0)" id="outButtonDiv" onclick="javascript:patientMoveSearch.popSransfer(1, null)" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>迁出</button></a>
            <input type="hidden" id="pageIndex" value="${pageIndex}">
        </div>

		<div class="searchbox searchSection x-admin-sm">
			<form id="patientMoveSearchForm">
                <table id="patientMoveSearch" >
				<colgroup>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:120px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:120px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:190px; width: 23%;"/>
                </colgroup>
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">性别</td>
                            <td class="colinput">
                                <ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" isDefault="Y" value="" />
                            </td>
                            <td class="coltext">身份证号</td>
                            <td class="colinput"><input type="text" name="idcard" class="x-layui-input"/></td>
						</tr>
						<tr>
                            <td class="coltext">迁出时间</td>
                            <td class="colinput">
                                <%-- tag:dateInput name="transferOutBeginDt" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"/>
                                至
                                <tag:dateInput name="transferOutEndDt" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"/> --%>
                                <input type="text" class="layui-input x-admin-sm-date"  name="transferOutBeginDt" id="transferOutBeginDtId" style="padding-left: 0px;width: 36%;" /> 至
                                <input type="text" class="layui-input x-admin-sm-date"  name="transferOutEndDt" id="transferOutEndDtId" style="padding-left: 0px;width: 36%;" />
                            </td>
                            <td class="coltext">迁入时间</td>
                            <td class="colinput">
                                <%-- <tag:dateInput name="transferInBeginDt" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"/>
                                至
                                <tag:dateInput name="transferInEndDt" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"/> --%>
                                <input type="text" class="layui-input x-admin-sm-date"  name="transferInBeginDt" id="transferInBeginDtId" style="padding-left: 0px;width: 36%;" /> 至
                                <input type="text" class="layui-input x-admin-sm-date"  name="transferInEndDt" id="transferInEndDtId" style="padding-left: 0px;width: 36%;" />
                            </td>
                            <td class="coltext">迁移状态</td>
                            <td class="colinput">
                                <ehr:dic-list name="transferStatus" dicmeta="MH00046" code="1,2,3"/>
                            </td>
						</tr>
						<tr>
                            <td class="coltext">迁出单位</td>
                            <td class="colinput">
                                <tag:autoSelect name="moveOutOrgan" id="moveOutOrgan"></tag:autoSelect>
                                <%--<ehr:org-type-list name="moveOutOrgan"  type="station" code="${currentLoginInfo.organization.organCode}"/>--%>
                            <%--<ehr:dic-org-list name="inputOrganCode" id="patownShip" width="250px"/>--%>
                                <%--<ehr:dic-town-centre-station centreName="managementCenterOut" stationName="managementStationOut" townName="managementTownOut" width="180px;"/>--%>
                                <%--<ehr:dic-town-village villageId="pavillage_address" villageName="pastreet" townName="patownShip" width="30%"/>--%>
                            </td>
                            <td class="coltext">迁入单位</td>
                            <td class="colinput">
                                <tag:autoSelect name="moveInOrgan" id="moveInOrgan"></tag:autoSelect>
                                <%--<ehr:org-type-list name="moveInOrgan"  type="station" code=""/>--%>
                                <%--<ehr:dic-town-centre-station centreName="managementCenterIn" stationName="managementStationIn" townName="managementTownIn" width="180px;" />--%>
                            </td>
                            <td></td>
                            <td>
                                <!-- <input type="button" id="patientMoveBtnSearch" value="查询" onclick="" class="search_btn"/> -->
                                <%--<input type="button" id="patientMoveBtnExport" value="导出" onclick="" class="search_btn"/>--%>
                                <button class="layui-btn layui-btn-sm" id="patientMoveBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                                
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="mhmCommon.toggle(this,'patientMoveSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="patientMoveResultDiv"></div>
	</div>
	<div id="patientMoveDetailDiv" ></div>


<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#transferOutBeginDtId' 
        	  ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#transferOutEndDtId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
        laydate.render({
            elem: '#transferInBeginDtId' 
          	  ,format: 'yyyy/MM/dd'
         	   ,max:0
          });

          laydate.render({
            elem: '#transferInEndDtId'
             ,format: 'yyyy/MM/dd'
          	   ,max:0
          });
      
      });

    </script>
