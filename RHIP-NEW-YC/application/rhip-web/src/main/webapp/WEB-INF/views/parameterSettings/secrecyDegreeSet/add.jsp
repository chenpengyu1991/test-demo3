<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function(){
        $("#saveButton").click(function(e) {
            e.preventDefault();
            save();
        });

        $("#cancelButton").click(function(e) {
            e.preventDefault();
            layer.closeAll();
        });
        init('organCode','',[0]);//其他,市级医院,卫生院  [镇不能选择] R2,A1,B1,B2,G2
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

    function save() {
        var validate = $("#configForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#configForm").submitFormGetJson({
            url : "/ehrbrowser/service/secrecyDegree/save",
            callback : function(data) {
                layer.closeAll();
                if (data.indexOf("fail") > -1) {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("保存成功！", {icon:0,title:'提示'},function () {
                        layer.closeAll();
                        secrecyDegreeSearch.search(1);
                    });
                }
            }
        });
    }
</script>

<form id="configForm">
    <input type="hidden" name="id" value="${secrecyDegreeSet.id}"/>
    <div class="postcontent">
        <div class="postdiv">
            <%--<fieldset>--%>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 25%"/>
                        <col style="width: 75%"/>
                    </colgroup>
                    <tr>
                        <input type="hidden" id="id" value="${secrecyDegreeSet.id}">
                        <th><label class="required">机构：</label></th>
                        <td>
                            <c:if test="${empty secrecyDegreeSet.id}">
                                <tag:autoSelect name="organCode" id="organCode" style="width:180px" reg='{"required":"true"}'
                                                codeValue="${secrecyDegreeSet.organCode}" nameValue="${secrecyDegreeSet.organName}"></tag:autoSelect>
                            </c:if>
                            <c:if test="${!empty secrecyDegreeSet.id}">
                                ${secrecyDegreeSet.organName}
                                <input type="hidden" name="organCode" value="${secrecyDegreeSet.organCode}">
                                <input type="hidden" name="organName" value="${secrecyDegreeSet.organName}">
                            </c:if>

                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">安全级别：</label></th>
                        <td>
                            <select name="secrecyDegree" reg='{"required":"true"}'>
                                <option value="">请选择</option>
                                <option value="1" <c:if test="${secrecyDegreeSet.secrecyDegree == 1}">selected="selected"</c:if>>可见，隐藏敏感信息</option>
                                <option value="2" <c:if test="${secrecyDegreeSet.secrecyDegree == 2}">selected="selected"</c:if>>不可见</option>
                            </select>
                        </td>
                    </tr>
                </table>
            <%--</fieldset>--%>
        </div>
    </div>
</form>
<p style="margin-bottom: 20px;" align="center">
    <button class="layui-btn layui-btn-sm" id="saveButton">保存</button>
    <button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
</p>