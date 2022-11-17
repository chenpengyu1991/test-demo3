<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%--<table class="formtable" width="820px;">
    <tr>
        <td valign="top">--%>
            <div class="postdiv" >
                <%--<fieldset>--%>
                    <div class="repeattable" style="overflow-x: auto;">
                        <table class="layui-table x-admin-sm-table-list-small">
                            <thead>
                            <tr><th style="text-align: center;"  width="50px;">操作</th>
                                <th  style="text-align: center;"  width="100px;">检查日期</th>
                                <th  style="text-align: center;"  width="140px;">检查机构</th>
                                <th  style="text-align: center;"  width="50px;">身高</th>
                                <th  style="text-align: center;"  width="50px">体重</th>
                                <th style="text-align: center;"  width="80px">血压</th>
                                <th style="text-align: center;"  width="40px">心率</th>
                                <th style="text-align: center;"  width="40px">血糖</th>
                                <th style="text-align: center;" title="心电图结果描述" width="100px">心电</th>
                                <c:if test="${module eq 'tj'}">
                                    <th style="text-align: center;"  width="40px">体温</th>
                                    <th style="text-align: center;"  width="40px">脉率</th>
                                    <th style="text-align: center;"  width="40px">总胆固醇</th>
                                    <th style="text-align: center;"  width="40px">呼吸频率</th>
                                    <th style="text-align: center;"  width="40px">甘油三脂</th>
                                    <th style="text-align: center;"  width="40px">高密度脂蛋白</th>
                                    <th style="text-align: center;"  width="40px">低密度脂蛋白</th>
                                    <th style="text-align: center;"  width="40px" title="隐血（潜血）">隐血</th>
                                    <th style="text-align: center;"  width="40px">尿蛋白</th>
                                    <th style="text-align: center;"  width="40px">酮体</th>
                                    <th style="text-align: center;"  width="40px">尿糖</th>
                                    <th style="text-align: center;"  width="40px">胆红素</th>
                                    <th style="text-align: center;"  width="40px">白细胞</th>
                                </c:if>
                                
                            </tr>
                            </thead>
                            <c:forEach var="obj" items="${list}" varStatus="status">
                                <tr>
                                	<td style="text-align:center;" >
                                        <a onclick="yishareSearch.select('${obj.height}','${obj.weight}','${obj.sbp}','${obj.dbp}','${obj.fetalheart}','${obj.glu}','${obj.anal}','${obj.memo1}',
                                                '${obj.temp}','${obj.pulse}','${obj.cho}','${obj.breath}','${obj.tg}','${obj.hdl}','${obj.ldl}','${obj.ncgBlo}','${obj.ncgPro}',
                                                '${obj.ncgKet}','${obj.ncgGlu}','${obj.ncgBil}','${obj.ncgLeu}');" class="layui-btn layui-btn-normal layui-btn-xs" href="#" title="选择" style="color: #FFF;"><i class="layui-icon">&#xe605;</i>选择</a>
                                    </td>
                                
                                    <td style="text-align:center;" title="<fmt:formatDate value="${obj.checkTime}" pattern='yyyy/MM/dd'/>"><fmt:formatDate value="${obj.checkTime}" pattern='yyyy/MM/dd'/></td>
                                    <td style="text-align:center;" title="${obj.orgName}">${obj.orgName}</td>
                                    <td style="text-align:center;"><fmt:formatNumber value="${obj.height}" pattern="0.00"/></td>
                                    <td style="text-align:center;"><fmt:formatNumber value="${obj.weight}" pattern="0.00"/></td>
                                         <td style="text-align:center;">${obj.sbp}/${obj.dbp}</td>
                                          <td style="text-align:center;">${obj.fetalheart}</td>
                                    <td style="text-align:center;" title="${('0' eq obj.memo1 ||obj.memo1 ==null)? '空腹血糖':'随机血糖'}">${obj.glu}</td>
                                    <td style="text-align:center;">${obj.anal}</td>
                                    <c:if test="${module eq 'tj'}">
                                        <td style="text-align:center;">${obj.temp}</td>
                                        <td style="text-align:center;">${obj.pulse}</td>
                                        <td style="text-align:center;">${obj.cho}</td>
                                        <td style="text-align:center;">${obj.breath}</td>
                                        <td style="text-align:center;">${obj.tg}</td>
                                        <td style="text-align:center;">${obj.hdl}</td>
                                        <td style="text-align:center;">${obj.ldl}</td>
                                        <td style="text-align:center;">${obj.ncgBlo}</td>
                                        <td style="text-align:center;">${obj.ncgPro}</td>
                                        <td style="text-align:center;">${obj.ncgKet}</td>
                                        <td style="text-align:center;">${obj.ncgGlu}</td>
                                        <td style="text-align:center;">${obj.ncgBil}</td>
                                        <td style="text-align:center;">${obj.ncgLeu}</td>
                                    </c:if>
                                    
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                    <table>
                        <tr>
                            <ehr:pagination action="yishareSearch.searchytj" colspan="${'tj' eq module?'22':'9'}"/>
                        </tr>
                    </table>
                    <input type="hidden" id="indexPage" value="${indexPage}" />
                <%--</fieldset>--%>
            </div>
<%--
        </td>
    </tr>
</table>
--%>
