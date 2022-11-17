<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

</div>
<div style="background-color: white; height: 515px;">
    <br/>
    <ul>
        <li style="text-align: center; font-size: 25px;">体弱儿童随访</li>
    </ul>
    <div class="table-basic">
        <table class="layui-table x-admin-sm-table-list-small">
            <colgroup>
                <col style="width: 17%;"/>
                <col style="width: 33%;"/>
                <col style="width: 17%;"/>
                <col style="width: 33%;"/>
            </colgroup>
            <tr>
                <th width="15%">姓名</th>
                <td><c:out value="${chEtbjTresfDetail.xm}"></c:out></td>
                <th width="15%">性别</th>
                <td><c:out value="${chEtbjTresfDetail.xb}"></c:out></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><fmt:formatDate value="${chEtbjTresfDetail.csrq}" pattern="yyyy/MM/dd" /></td>
                <th>随访日期</th>
                <td><fmt:formatDate value="${chEtbjTresfDetail.sfrq}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th width="15%">体弱儿专项档案编号</th>
                <td><c:out value="${chEtbjTresfDetail.trezxdabh}"></c:out></td>
                <th width="15%">随访方式名称</th>
                <td><c:out value="${chEtbjTresfDetail.sffsMc}"></c:out></td>
            </tr>
            <tr>
                <th>随访方式其他详述</th>
                <td colspan="3">${chEtbjTresfDetail.sffsqtxs}</td>
            </tr>
            <tr>
                <th width="15%">体重</th>
                <td><c:out value="${chEtbjTresfDetail.tz}"></c:out></td>
                <th width="15%">身长</th>
                <td><c:out value="${chEtbjTresfDetail.sc}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">身高体重</th>
                <td><c:out value="${chEtbjTresfDetail.sgtz}"></c:out></td>
                <th width="15%">身高体重评价名称</th>
                <td><c:out value="${chEtbjTresfDetail.sgtzpjMc}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">喂养方式名称</th>
                <td><c:out value="${chEtbjTresfDetail.wyfsMc}"></c:out></td>
                <th width="15%">喂母乳次数</th>
                <td><c:out value="${chEtbjTresfDetail.wmrcs}"></c:out></td>
            </tr>
            <tr>
                <th>喂养方式和情况详述</th>
                <td colspan="3">${chEtbjTresfDetail.wyfshqkxs}</td>
            </tr>
            <tr>
                <th>发育情况详述</th>
                <td colspan="3">${chEtbjTresfDetail.fyqkxs}</td>
            </tr>
            <tr>
                <th>临床症状和体征名称</th>
                <td colspan="3">${chEtbjTresfDetail.lczzhtzdmMc}</td>
            </tr>
            <tr>
                <th>辅助检查情况详述</th>
                <td colspan="3">${chEtbjTresfDetail.fzjcqkxs}</td>
            </tr>
            <tr>
                <th>指导处理详述</th>
                <td colspan="3">${chEtbjTresfDetail.zdclxs}</td>
            </tr>
            <tr>
                <th width="15%">是否死亡</th>
                <td><c:out value="${chEtbjTresfDetail.sfswdmMc}"></c:out></td>
                <th>死亡时间</th>
                <td><fmt:formatDate value="${chEtbjTresfDetail.swsj}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th>死亡原因</th>
                <td colspan="3">${chEtbjTresfDetail.swyydmMc}</td>
            </tr>
            <tr>
                <th>下次随访日期</th>
                <td colspan="3"><fmt:formatDate value="${chEtbjTresfDetail.xcsfrq}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th>下次随访地点</th>
                <td colspan="3">${chEtbjTresfDetail.xcsfdd}</td>
            </tr>
            <tr>
                <th width="15%">随访医生姓名</th>
                <td colspan="3"><c:out value="${chEtbjTresfDetail.sfysxm}"></c:out></td>
            </tr>
            <tr>
                <th>随访机构名称</th>
                <td colspan="3">${chEtbjTresfDetail.sfjgMc}</td>
            </tr>
            <tr>
                <th>备注</th>
                <td colspan="3">${chEtbjTresfDetail.bz}</td>
            </tr>
            <tr>
                <th>登记时间(系统)</th>
                <td colspan="3"><fmt:formatDate value="${chEtbjTresfDetail.djsj}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th width="15%">登记人员姓名</th>
                <td colspan="3"><c:out value="${chEtbjTresfDetail.djrymc}"></c:out></td>
            </tr>
            <tr>
                <th>登记机构名称</th>
                <td colspan="3">${chEtbjTresfDetail.djjgMc}</td>
            </tr>
            <tr>
                <th>最后修改时间</th>
                <td colspan="3"><fmt:formatDate value="${chEtbjTresfDetail.zhxgsj}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th width="15%">最后修改人员姓名</th>
                <td colspan="3"><c:out value="${chEtbjTresfDetail.zhxgrymc}"></c:out></td>
            </tr>
            <tr>
                <th>最后修改机构名称</th>
                <td colspan="3">${chEtbjTresfDetail.zhxgjgMc}</td>
            </tr>
            <tr>
                <th>就诊机构名称</th>
                <td colspan="3">${chEtbjTresfDetail.clinicOrganName}</td>
            </tr>
        </table>
    </div>
</div>