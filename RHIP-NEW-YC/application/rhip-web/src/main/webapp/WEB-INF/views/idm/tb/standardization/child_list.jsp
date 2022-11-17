<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/standardization.js" type="text/javascript"></script>

<div class="toolbar">
    <%-- <a href="javascript:tbCommon.returnSearch('standardization.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('standardization.searchTemp')" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
   	<c:if test="${logoff !=1 }">
    	<%-- <a href="javascript:standardization.saveChild('1','standardization.searchTemp')" id="saveContact"><b class="baocun">保存</b></a> --%>
    	<a href="javascript:standardization.saveChild('1','standardization.searchTemp')" id="saveContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</c:if>
</div>
<div class="divFixed105" style="top: 200px;">
	<form id="tbFormList">
		<input type="hidden" id="singleId" name="singleId" value="${singleId}">
		<input type="hidden" id="rowIndex" value="${rowIndex}"/>
		<input type="hidden" id="listSdJson" name="listSdJson"/>
		<input type="hidden" id="listDdJson" name="listDdJson"/>
		<input type="hidden" id="listFrJson" name="listFrJson"/>
		<div>
			<div style="${typeTb == '1' ? '' : 'display:none;'}">
				督导服药
			</div>

			<div style="${typeTb == '2' ? '' : 'display:none;'}">
				预约查痰
			</div>
			<div style="${typeTb == '3' ? '' : 'display:none;'}">
				<div class="toolbarsublist">
					访视记录：<c:if test="${logoff !=1 }">
					<!--<a href="javascript:standardization.popup('','','fr','${singleId}')" id="addEfcList" ><b class="xinz">添加</b> </a>-->
					<a href="javascript:void(0)"  id="addVisit"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
				</c:if>
				</div>
				<div class="repeattable">
					<table id="frTable" class="layui-table x-admin-sm-table-list-middle">
						<colgroup>
							<col style="width: 10%" />
							<col style="width: 25%" />
							<col style="width: 25%" />
							<col style="width: 25%" />
							<col style="width: 15%" />
						</colgroup>
						<thead>
						<tr>
							<th class="centerth" style="width: 10%">日期</th>
							<th class="centerth" style="width: 5%">督导访视内容及改进意见</th>
							<th class="centerth" style="width: 5%">访视单位</th>
							<th class="centerth" style="width: 35%">访视人</th>
							<th class="centerth" style="width: 5%">操作</th>
						</tr>
						</thead>
						<c:forEach var="listFr" items="${tbSaveDto.listFr}" varStatus="status">
							<tr>
								<td class="centertd" field="idmId" style="display: none;">${singleId}</td>
								<td field="visitDt"><fmt:formatDate value="${listFr.visitDt}" pattern="yyyy/MM/dd" /></td>
								<td field="visitContent"><ehr:tip>${listFr.visitContent}</ehr:tip></td>
								<td field="visitInstStr"><ehr:org code="${listFr.visitInst}"/> </td>
								<td field="visitByIdStr"><ehr:user userCode="${listFr.visitById}"/> </td>
								<td field="visitInst" style="display: none;">${listFr.visitInst}</td>
								<td field="visitById" style="display: none;">${listFr.visitById}</td>
								<td class="centertd btnsublist" field="btn">
									<c:choose>
										<c:when test="${logoff == 1 }">
											<%--<label class="loadclass">修改&nbsp;</label>
                                            <label class="loadclass">删除&nbsp;</label>--%>
											<span class="loadclass layui-btn layui-btn-xs" title="修改"  style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</span>
											<span class="loadclass layui-btn layui-btn-danger layui-btn-xs" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</span>
										</c:when>
										<c:otherwise>
											<%--<a href="javascript:void(0)" onclick="standardization.popup(this, 'edit','fr','${singleId}')">修改</a>&nbsp;--%>
											<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="standardization.popup(this, 'edit','fr','${singleId}')" title="修改" class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
											<%--<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>--%>
											<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="idmCommon.removeTr(this)" title="删除"  class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<div style="${typeTb == '4' ? '' : 'display:none;'}">
				<div class="toolbarsublist">
					用药延误记录：<c:if test="${logoff !=1 }">
					<%--<a href="javascript:standardization.popup('','','dd','${singleId}')" ><b class="xinz">添加</b></a>--%>
					<a href="javascript:void(0)"  id="addMissUseDrug"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>

				</c:if>
				</div>
				<div class="repeattable">
					<table id="ddTable" class="layui-table x-admin-sm-table-list-middle">
						<colgroup>
							<col style="width: 15%" />
							<col style="width: 15%" />
							<col style="width: 15%" />
							<col style="width: 15%" />
							<col style="width: 25%" />
							<col style="width: 15%" />
						</colgroup>
						<thead>
						<tr>
							<th class="centerth">日期</th>
							<th class="centerth">补救次数</th>
							<th class="centerth">断药次数</th>
							<th class="centerth">漏治次数</th>
							<th class="centerth">漏治原因</th>
							<th class="centerth">操作</th>
						</tr>
						</thead>
						<c:forEach var="listDd" items="${tbSaveDto.listDd}" varStatus="status">
							<tr>
								<td field="idmId" style="display: none;">${singleId}</td>
								<td field="recordDate"><fmt:formatDate value="${listDd.recordDate}" pattern="yyyy/MM/dd" /></td>
								<td field="repairTreatNumber"><ehr:tip>${listDd.repairTreatNumber}</ehr:tip></td>
								<td field="brokenNum">${listDd.brokenNum}</td>
								<td field="leakageNum">${listDd.leakageNum}</td>
								<td field="leakageReason">${listDd.leakageReason}</td>
								<td class="btnsublist" field="btn">
									<c:choose>
										<c:when test="${logoff == 1 }">
											<%--<label class="loadclass">修改&nbsp;</label>
                                            <label class="loadclass">删除&nbsp;</label>--%>
											<span class="loadclass" title="修改"><i class="layui-icon">&#xe642;</i></span>
											<span class="loadclass" title="删除"><i class="layui-icon">&#xe640;</i></span>
										</c:when>
										<c:otherwise>
											<%--<a href="javascript:void(0)" onclick="standardization.popup(this, 'edit','dd','${singleId}')">修改</a>&nbsp;
                                            <a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>--%>
											<a href="javascript:void(0)" onclick="standardization.popup(this, 'edit','dd','${singleId}')" title="修改"class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
											<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<div style="${typeTb == '5' ? '' : 'display:none;'}">
				密切接触者随访
			</div>
		</div>
	</form>
</div>
