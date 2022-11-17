<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-24
  Time: 上午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
    .table-info{overflow:auto;clear:both;vertical-align:middle;}
    .table-info table{width:100%; border-left:#C8BArrayAE solid 1px;border-top:#C8BArrayAE solid 1px;border-collapse:collapse;}
    .table-info td{text-align:left;height:28px;line-height:28px;border:1px solid #ccc;padding-left:2px;}
    .table-info th{border:1px solid #CCC;background:#EFF7FF;font-weight:normal;}
    .table-info td.td_gray{background:#EEE;}
    .table-info td.h_top{background:#66B9DB; font-weight:bold;text-align:center;color:#FFF;}
</style>


<div class="repeattable x-admin-sm" id="basicinfodiv">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width:25%;" />
            <col style="width: 25%;" />
            <col style="width: 25%;" />
            <col style="width: 25%;" />
        </colgroup>
        <tr>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="childHealth.follow('${child.babyCardNo}','1')">新生儿家庭访视管理</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="childHealth.viewChildExams('${exam.babyCardNo}','1')">1-8月龄儿童健康检查记录表</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="childHealth.viewChildExams('${exam.idCard}','2')">12-30月龄儿童健康检查记录</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="childHealth.viewChildExams('${exam.idCard}','6')">3-6岁儿童健康检查记录表</a></th>
        </tr>
    </table>
</div>
<div class="repeattable x-admin-sm" >
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 7%;" />
            <col style="width: 26%;" />
            <col style="width: 7%;" />
            <col style="width: 26%;" />
            <col style="width: 10%;" />
            <col style="width: 23%;" />
        </colgroup>
        <tr>
            <th>姓名</th>
            <td><ehr:tip>${child.name}</ehr:tip></td>
            <th>出生编号</th>
            <td><ehr:tip>${child.babyCardNo}</ehr:tip></td>
            <th>出生日期</th>
            <td><ehr:tip><fmt:formatDate value="${child.childBirthday}" pattern="yyyy/MM/dd" /></ehr:tip></td>
        </tr>
        <tr>
            <th>性别</th>
            <td><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${child.gender}" /></ehr:tip></td>
            <th>身份证号</th>
            <td><ehr:tip>${child.idCard}</ehr:tip></td>
            <th>母亲身份证号</th>
            <td><ehr:tip>${exam.motherIdcard}</ehr:tip></td>
        </tr>
        <tr>
            <th>现住地址</th>
            <td colspan="3">
                <ehr:dic code="${exam.pacounty}" dicmeta="FS990001" />
                <ehr:dic code="${exam.patownShip}" dicmeta="FS990001" />
                <ehr:dic code="${exam.pastreet}" dicmeta="FS990001" />
                ${exam.pahouseNumber}
            </td>
            <th>联系电话</th>
            <td><ehr:tip>${exam.telNumber}</ehr:tip></td>
        </tr>
    </table>
</div>