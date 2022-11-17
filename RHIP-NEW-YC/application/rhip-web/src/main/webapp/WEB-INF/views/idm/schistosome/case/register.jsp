<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/schcase.js" type="text/javascript"></script>
<div class="toolbar">
    <%-- <a href="javascript:void(0)" onclick="javascript:schcase.returnSearch()"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:schcase.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>

<form id="registerForm">

    <div class="postcontent">
        <i class="popno">
        	<c:choose>
            	<c:when test="${flag=='Local'}">本地居民吸虫病监测登记表</c:when>
            	<c:otherwise>暂住人口吸虫病监测登记表</c:otherwise>
            </c:choose>
        </i>
        <div class="postdiv">
        	<fieldset class="layui-elem-field">
        		<legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 15%;"/>
                        <col style="min-width: 120px; width: 15%;"/>
                        <col style="min-width: 150px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 150px; width: 20%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>姓名</th>
                        <td>${schistosomeDto.generalCondition.name}</td>
                       <th>身份证号码</th>
                        <td>${schistosomeDto.generalCondition.idcard}</td>                     
                        <th>性别</th>
                        <td>
                        	<ehr:dic dicmeta="GBT226112003" code="${schistosomeDto.generalCondition.gender}"/>
                        </td>
                    </tr>
					<tr>
                        <th>年龄</th>
                        <td>${schistosomeDto.generalCondition.age}</td>
 						<c:choose>
                    		<c:when test="${flag=='Local'}">
		                        <th>标本来源</th>
		                        <td>
		                        	<ehr:dic dicmeta="IDM00230" code="${schistosomeDto.labExamine.sampleResource}"/>
		                        </td>                    			     
                    		</c:when>
                    		<c:otherwise>
						       	<th>就业单位或暂住地址</th>
							       	<td colspan="3">${schistosomeDto.generalCondition.unitName}</td>                    		
                    		</c:otherwise>
                    	</c:choose>                   					
		       		</tr>
	        		<tr>
		            	<th>
		            	<c:choose>
                    		<c:when test="${flag=='Local'}">详细地址</c:when>
							<c:otherwise>现住址</c:otherwise>
                    	</c:choose>	
		            	</th>
			            <td colspan="5">
                    		<ehr:dic code="${schistosomeDto.generalCondition.patownShip}" dicmeta="FS990001"/>&nbsp;&nbsp;
                    		<ehr:dic code="${schistosomeDto.generalCondition.pastreet}" dicmeta="FS990001"/>&nbsp;&nbsp;
                    		${schistosomeDto.generalCondition.pahouseNumber}&nbsp;（门牌号）
				        </td>
			     	</tr>                    
                    <tr>
                        <th>检验日期</th>
                        <td>
                        	<fmt:formatDate value="${schistosomeDto.labExamine.ihaDt}" pattern="yyyy/MM/dd"/>
                       <th>检验结果-IHA</th>
                        <td colspan="3">
                        	<ehr:dic dicmeta="IDM00320" code="${schistosomeDto.labExamine.ihaCheck}" />
                        </td>                        		
                    </tr>
                    <tr>
                        <th>检验日期</th>
                        <td>
                        	<fmt:formatDate value="${schistosomeDto.labExamine.ddiaDt}" pattern="yyyy/MM/dd"/>
                        <th>检验结果-DDIA</th>
                        <td colspan="3">
                        	<ehr:dic  dicmeta="PH00004" code="${schistosomeDto.labExamine.ddia}" />
                        </td>                        		
                    </tr>
                    <tr>
                        <th>检验日期</th>
                        <td>
                        	<fmt:formatDate value="${schistosomeDto.labExamine.coptDt}" pattern="yyyy/MM/dd"/>
                        <th>检验结果-COPT</th>
                        <td colspan="3">
                        	<ehr:dic dicmeta="IDM00321" code="${schistosomeDto.labExamine.copt}" />
                        </td>                        		
                    </tr>
                    <tr>
                        <th>检验日期</th>
                        <td>
                        	<fmt:formatDate value="${schistosomeDto.labExamine.stoolDt}" pattern="yyyy/MM/dd"/>
                       <th>检验结果-粪检</th>
                        <td colspan="3">
                        	<ehr:dic dicmeta="PH00004" code="${schistosomeDto.labExamine.stool}"/>
                        </td>                        		
                    </tr>                                                            
                    </tbody>
                </table>
            </fieldset>
        </div>
    </div>
</form>
