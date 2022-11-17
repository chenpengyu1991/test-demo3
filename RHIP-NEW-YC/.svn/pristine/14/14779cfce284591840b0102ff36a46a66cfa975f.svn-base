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
    .table-info th{border:1px solid #CCC;background:#F2F2F2;;font-weight:normal;}
    .table-info td.td_gray{background:#EEE;}
    .table-info td.h_top{background:#66B9DB; font-weight:bold;text-align:center;color:#FFF;}
</style>

<div class="table-info" >

    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 20%;height:4%;" />
            <col style="width: 20%;height:4%;" />
            <col style="width: 20%;height:4%;" />
            <col style="width: 20%;height:4%;" />
            <col style="width: 20%;height:4%;" />
        </colgroup>
        <tr>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="womenHealth.follow('${child.idCard}')">第1次产前随访服务记录</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="womenHealth.follow1('${child.idCard}')">第2-5次产前随访服务记录</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="womenHealth.follow2('${child.idCard}')">分娩信息记录</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="womenHealth.follow3('${child.idCard}')">产后访视记录表</a></th>
            <th style="text-align: center;"><a href="javascript:void(0);"  onclick="womenHealth.follow4('${child.idCard}')">产后42天健康检查记录</a></th>
        </tr>
    </table>
</div >
<div class="table-info" id="basicinfodiv">
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
            <td class="centertd"><ehr:tip>${child.name}</ehr:tip></td>
            <th>身份证号</th>
            <td class="centertd"><ehr:tip>${child.idCard}</ehr:tip></td>
            <th>健康档案编号</th>
            <td class="centertd"><ehr:tip>${child.healthFileNo}</ehr:tip></td>
        </tr>
        <tr>
            <th>性别</th>
            <td class="centertd"><ehr:tip><ehr:dic code="${child.gender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
            <th>创建日期</th>
            <td class="centertd"><ehr:tip><fmt:formatDate value="${child.createDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
            <th>管理机构</th>
            <td class="centertd"><ehr:tip><ehr:org code="${child.orgCode}"/></ehr:tip></td>
        </tr>
    </table>
</div>