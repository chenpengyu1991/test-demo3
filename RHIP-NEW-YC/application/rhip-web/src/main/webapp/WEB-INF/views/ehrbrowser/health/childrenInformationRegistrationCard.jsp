<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />


<div style="background-color: white; height: 515px;">
    <br/>
    <ul>
        <li style="text-align: center; font-size: 25px;">儿童信息登记卡</li>
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
                <td><c:out value="${chEtbjJd.xm}"></c:out></td>
                <th width="15%">性别</th>
                <td><c:out value="${chEtbjJd.xb}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">儿童信息编号</th>
                <td><c:out value="${chEtbjJd.etxxbh}"></c:out></td>
                <th width="15%">健康档案编号</th>
                <td><c:out value="${chEtbjJd.jkdabh}"></c:out></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><fmt:formatDate value="${chEtbjJd.csrq}" pattern="yyyy/MM/dd" /></td>
                <th>身份证件号码</th>
                <td>${chEtbjJd.sfzjh}</td>
            </tr>
            <tr>
                <th>现住址</th>
                <td colspan="3">${chEtbjJd.xzz}</td>
            </tr>
            <tr>
                <th>母亲姓名</th>
                <td>${chEtbjJd.mqxm}</td>
                <th>母亲职业</th>
                <td>${chEtbjJd.mqzy}</td>
            </tr>
            <tr>
                <th>母亲联系电话</th>
                <td>${chEtbjJd.mqlxdh}</td>
                <th>母亲身份证号</th>
                <td>${chEtbjJd.mqsfzhm}</td>
            </tr>
            <tr>
                <th>母亲工作单位</th>
                <td colspan="3">${chEtbjJd.mqgzdw}</td>
            </tr>
            <tr>
                <th>父亲姓名</th>
                <td>${chEtbjJd.fqxm}</td>
                <th>父亲职业</th>
                <td>${chEtbjJd.fqzy}</td>
            </tr>
            <tr>
                <th>父亲联系电话</th>
                <td>${chEtbjJd.fqlxdh}</td>
                <th>父亲身份证号</th>
                <td>${chEtbjJd.fqsfzhm}</td>
            </tr>
            <tr>
                <th>父亲工作单位</th>
                <td colspan="3">${chEtbjJd.fqgzdw}</td>
            </tr>
            <tr>
                <th>助产机构名称</th>
                <td>${chEtbjJd.zcjgMc}</td>
                <th>分娩方式名称</th>
                <td>${chEtbjJd.fmfsMc}</td>
            </tr>
            <tr>
                <th>分娩方式详述</th>
                <td colspan="3">${chEtbjJd.fmfsxs}</td>
            </tr>
            <tr>
                <th>是否出生缺陷名称</th>
                <td>${chEtbjJd.sfcsqxMc}</td>
                <th>出生缺陷类别名称</th>
                <td>${chEtbjJd.csqxlbdmMc}</td>
            </tr>
            <tr>
                <th>是否体弱儿童标志名称</th>
                <td>${chEtbjJd.sftretbzMc}</td>
                <th>结案标志</th>
                <td>${chEtbjJd.jabz}</td>
            </tr>
            <tr>
                <th>出生缺陷详述</th>
                <td colspan="3">${chEtbjJd.csqxxs}</td>
            </tr>
            <tr>
                <th>建档机构名称</th>
                <td>${chEtbjJd.jdjgMc}</td>
                <th>建档人名称</th>
                <td>${chEtbjJd.jdrmc}</td>
            </tr>
            <tr>
                <th>建档人电话号码</th>
                <td>${chEtbjJd.jdrxldhhm}</td>
                <th>管档机构名称</th>
                <td>${chEtbjJd.gdjgMc}</td>
            </tr>
            <tr>
                <th>备注</th>
                <td colspan="3">${chEtbjJd.bz}</td>
            </tr>
            <tr>
                <th>建档日期</th>
                <td><fmt:formatDate value="${chEtbjJd.jdrq}" pattern="yyyy/MM/dd" /></td>
                <th>最后修改时间</th>
                <td><fmt:formatDate value="${chEtbjJd.zhxgsj}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
            </tr>
            <tr>
                <th>最后修改人员名称</th>
                <td>${chEtbjJd.zhxgrymc}</td>
                <th>最后修改机构名称</th>
                <td>${chEtbjJd.zhxgjgMc}</td>
            </tr>
            <tr>
                <th>就诊机构名称</th>
                <td>${chEtbjJd.clinicOrganName}</td>
                <th>系统上传时间</th>
                <td><fmt:formatDate value="${chEtbjJd.uploadTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
            </tr>
        </table>
    </div>
</div>