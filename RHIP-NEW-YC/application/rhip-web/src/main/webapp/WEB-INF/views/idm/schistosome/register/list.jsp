<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.SchStatus" %>
<c:set var="REGISTER_DOCTOR" value="<%=SchStatus.REGISTER_DOCTOR.getValue()%>" />
<c:set var="REGISTER_SQZX" value="<%=SchStatus.REGISTER_SQZX.getValue()%>" />
<c:set var="REGISTER_JKTJZX" value="<%=SchStatus.REGISTER_JKTJZX.getValue()%>" />
<c:set var="REGISTER_WSYJYK" value="<%=SchStatus.REGISTER_WSYJYK.getValue()%>" />
<c:set var="FBK_VERIFY"  value="<%=SchStatus.FBK_VERIFY.getValue()%>" />
<c:set var="JK_VERIFY"  value="<%=SchStatus.JK_VERIFY.getValue()%>" />
<c:set var="WRITE"  value="<%=SchStatus.WRITE.getValue()%>" />
<c:set var="ELIMINATION"  value="<%=SchStatus.ELIMINATION.getValue()%>" />
<c:set var="CURE"  value="<%=SchStatus.CURE.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<c:if test="${ZXXXC=='1'}">
				<col style="min-width:20px;width:20px;"/>	
			</c:if>	
			<col style="min-width:60px;width:10%;"/>
	        <col style="min-width:50px;width:10%;"/>
			<col style="min-width:120px;width:10%;"/>
			<col style="min-width:150px;width:35%;"/>
            <col style="min-width:100px;width:10%;"/>
            <col style="min-width:150px;width:150px;"/>
		</colgroup>	
		<thead>
			<tr>
				<c:if test="${ZXXXC=='1'}">
					<th><input type="checkbox" id="checkAllId" name="checkedAll"  onclick="chkAll(this);"/></th>
				</c:if>			
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>现住址</th>
                <th>DDIA检验结果</th>
                <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="register" items="${statusInfo}" varStatus="status">
				<tr>
					<c:if test="${ZXXXC=='1'}">
						<td>
							<c:if test="${register.specialStatus == REGISTER_DOCTOR}">
								<input type="checkbox" name="check"  value="${register.schDto.singleId}" onclick="doChk(this);"/>
								<input type="hidden" id="name" value="${register.schDto.name}">
							</c:if>
						</td>
					</c:if>				
					<td class="centertd">
       					<a href="javascript:void(0)" onclick='javascript:registerSearch.editRegister(${register.schDto.singleId},"view")' class="person-link-btn">${register.schDto.name}</a>
					</td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${register.schDto.gender}" /></ehr:tip></td>
					<td class="centertd"><ehr:tip>${register.schDto.age}</ehr:tip></td>
					<td>
						<ehr:tip>${register.schDto.paAddress}</ehr:tip>
					</td>
                    <td class="centertd">
                        <ehr:tip><ehr:dic dicmeta="PH00004" code="${register.schDto.ddia}" /></ehr:tip>
                    </td>
					<td class="centertd">
                       <c:choose>
                             <c:when test="${JKXXC=='1'&& (register.specialStatus == FBK_VERIFY || register.specialStatus == REGISTER_SQZX || register.specialStatus == REGISTER_JKTJZX || register.specialStatus == REGISTER_WSYJYK)}">
								<a href="javascript:void(0)" onclick="registerSearch.editRegister(${register.schDto.singleId},'add')"class="person-link-btn">疾控审核</a>
                            </c:when>
                             <c:when test="${ZXXXC=='1' && register.specialStatus == REGISTER_DOCTOR}">
								<a href="javascript:void(0)" onclick="registerSearch.editRegister(${register.schDto.singleId},'add')"class="person-link-btn">防保科审核</a>
                            </c:when> 
                             <c:when test="${register.specialStatus == CURE}">
								<label class="loadclass">治愈</label>
                            </c:when>  
                             <c:when test="${register.specialStatus == REGISTER_DOCTOR}">
								<label class="loadclass">防保科审核</label>
                            </c:when> 
                             <c:when test="${register.specialStatus == REGISTER_SQZX}">
								<label class="loadclass">疾控审核</label>
                            </c:when>  
                             <c:when test="${register.specialStatus == REGISTER_JKTJZX}">
								<label class="loadclass">疾控审核</label>
                            </c:when>
                             <c:when test="${register.specialStatus == REGISTER_WSYJYK}">
								<label class="loadclass">疾控审核</label>
                            </c:when>                             
                             <c:when test="${register.specialStatus == FBK_VERIFY}">
								<label class="loadclass">疾控审核</label>
                            </c:when> 
                             <c:when test="${register.specialStatus == JK_VERIFY}">
								<label class="loadclass">通过</label>
                            </c:when>  
                             <c:when test="${register.specialStatus == WRITE}">
								<label class="loadclass">个案已填写</label>
                            </c:when>
                             <c:when test="${register.specialStatus == ELIMINATION}">
								<label class="loadclass">排除</label>
                            </c:when>                                                                                                                                                                                                                                                          
                        </c:choose>					
					</td>
				</tr>
			</c:forEach>
			<tr>
				<c:if test="${ZXXXC=='1'}">
				<ehr:pagination action="registerSearch.registerSearch" colspan="7"/>
				</c:if>	
				<c:if test="${ZXXXC!='1'}">
				<ehr:pagination action="registerSearch.registerSearch" colspan="6"/>
				</c:if>	
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="registerSearch.registerSearch" />
		</tr>
	</table> --%>
</div>