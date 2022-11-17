<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>--%>
<script>
    $(function(){
        init('receivingUnit','R2,A1,B1,B2,G2',[0]);//其他,市级医院,卫生院  [镇不能选择]
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

<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:messageSearch.search(1)" id="cancelContact"><b class="fanhui">返回</b></a>
        <a href="javascript:messageSearch.save()"><b class="baocun">保存</b></a>
    </div>
</div>
<form id="messageForm">
    <div class="postcontent">
        <i class="popno" style="height: auto;padding-top: 10px;"> 发布新消息</i>
        <div class="postdiv">
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 15%"/>
                        <col style="width: 35%"/>
                        <col style="width: 15%"/>
                        <col style="width: 35%"/>
                    </colgroup>
                    <tr>
                        <th><label class="required">主题：</label></th>
                        <td><input type="text" name="title" reg='{"maxlength":"50","required":"true"}'></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th><label class="required">接受机构：</label></th>
                        <td>
                        <%--<input type="text" name="receivingUnit" reg='{"required":"true"}'>--%>
                        <tag:autoSelect name="receivingUnit" id="receivingUnit" style="width:180px" reg='{"required":"true"}'></tag:autoSelect>
                        </td>
                    </tr>
                    <tr>
                    <th><label class="required">内容：</label></th>
                    <td colspan="3">
                        <%--<input type="text" name="content">--%>
                        <textarea name="content" rows="7" reg='{"maxlength":"1000","required":"true"}'></textarea>
                    </td>
                </tr>
                </table>
            </fieldset>
        </div>
    </div>
</form>
