<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/paramSetting/secrecyDegree/search.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        init('orgCode','',[0]);//其他,市级医院,卫生院  [镇不能选择] R2,A1,B1,B2,G2
    })
    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
    function init(orgId,orgType,unSelectType){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param:{organType:orgType}  //查询机构类型,逗号分割
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:orgType}  //查询机构类型,逗号分割
        };

        var hospitalCode=$("#" + orgId);
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }
</script>
<div id="top_all">
    <div class="toolbar" >
        <a href="javascript:void(0)" id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
    </div>
    <div class="section">
        <div class="searchBox">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <input type="hidden" id="personal" value="${personal}">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 70px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 70px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 15%; min-width: 70px;"/>
                        <col/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="col-text">机构</td>
                        <td class="col-input" colspan="4">
                            <tag:autoSelect name="orgCode" id="orgCode" style="width:240px" reg='{"required":"true"}'></tag:autoSelect>
                            <input type="text" style="display: none">
                        </td>
                        <td style="text-align: right;">
                            <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="col-bottom"><span onclick="secrecyDegreeSearch.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
<div id="resultDiv"></div>
</div>
<div id="detailDiv"></div>
