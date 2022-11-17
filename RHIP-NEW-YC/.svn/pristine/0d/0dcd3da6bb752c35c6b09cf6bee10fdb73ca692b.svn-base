<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/finance/edit.js"/>
<script>
    $(function(){
            //机构下拉树设置
            var option={
                url:"/mdmOrganization/organationTree",
                unSelecteType:['0','B1','B2']  //不能选择：0是镇，B1是中心, B2是中心
            };
            //机构自动检索设置
            var opb = {
                url:"/mdmOrganization/organationSelect",
                feild: {
                    value: "organCode",
                    lable: "organName"
                },
                param:{organType:"A100", subsid:0}  //只查询B1（市级医院）
            };
            var organCode=$("#organCode");
            if(organCode.length>0){
                //初始化自动检索
                organCode.selectBox(opb);
                //初始化下拉树
                organCode.initTreeSelect(option);
            }
    })
</script>

<div class="toolbar">
    <a href="javascript:void(0);" id="save"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
    <a href="javascript:void(0)" id="back"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<form class="postcontent searchSection x-admin-sm" id="editForm">
    <div class="postdiv">
        <fieldset class="layui-elem-field">
            <legend>本次录入</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                <tr>
                    <input type="hidden" name="id" value="${finance.id}"/>
                    <th><label class="required">单位</label></th>
                    <td>
                        <%--<input type="text" name="organCode" value="${finance.organCode}" reg="{'maxlength':30}"/>--%>
                        <tag:autoSelect name="organCode" id="organCode" style="width:180px" reg='{"required":"true"}'></tag:autoSelect>
                    </td>
                    <th><label class="required">月份</label></th>
                    <td><input type="text" name="month" value="${finance.year}" reg="{'required':'true','number':'true','length':6}"/></td>
                </tr>
                <tr>
                    <th><label class="required">收入合计</label></th>
                    <td><input type="text" name="srhj" value="${finance.srhj}" reg="{'required':'true','scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>医疗收入</th>
                    <td><input type="text" name="ylsr" value="${finance.srhj}" reg="{'required':'true','scale':2, 'number':'true', 'maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">药品收入</label></th>
                    <td><input type="text" name="ypsr" value="${finance.ypsr}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>财政补助收入</th>
                    <td><input type="text" name="czbz" value="${finance.czbz}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                </tr>
                <tr>
                    <th>其他收入</th>
                    <td><input type="text" name="qtsr" value="${finance.qtsr}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>支出合计</th>
                    <td><input type="text" name="zchj" value="${finance.zchj}" reg="{'scale':2, 'number':'true', 'maxlength':15}">
                    </td>
                </tr>
                <tr>
                    <th>医疗业务成本</th>
                    <td><input type="text" name="ylcb" value="${finance.ylcb}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>药品费</th>
                    <td><input type="text" name="ypf" value="${finance.ypf}" reg="{'scale':2, 'number':'true', 'maxlength':15}">
                    </td>
                </tr>
                <tr>
                    <th>折旧（摊销）</th>
                    <td><input type="text" name="zj" value="${finance.zj}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>财政项目补助支出</th>
                    <td>
                        <input type="text" name="czxmbz" value="${finance.czxmbz}" reg="{'scale':2, 'number':'true', 'maxlength':15}">
                    </td>
                </tr>
                <tr>
                    <th>科教项目支出</th>
                    <td><input type="text" name="kjzc" value="${finance.kjzc}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>管理费用</th>
                    <td><input type="text" name="glfy" value="${finance.glfy}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                </tr>
                <tr>
                    <th>其他支出</th>
                    <td><input type="text" name="qtzc" value="${finance.qtzc}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>结余(含财政基本补助）</th>
                    <td><input type="text" name="jyc" value="${finance.jyc}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                </tr>
                <tr>
                    <th>结余(不含财政补助）</th>
                    <td><input type="text" name="jyn" value="${finance.jyn}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    <th>药品收入占业务总收入比例%</th>
                    <td><input type="text" name="ypb" value="${finance.ypb}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                </tr>
                <tr>
                    <th>药品综合差价率%</th>
                    <td><input type="text" name="ypcj" value="${finance.ypcj}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>

                </tr>

                </tbody>
            </table>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>去年同期</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                    <tr>
                        <th>收入合计</th>
                        <td><input type="text" name="srhjl" value="${finance.srhjl}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    </tr>
                    <tr>
                        <th>财政补助</th>
                        <td><input type="text" name="xzbzl" value="${finance.xzbzl}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                        <th>结余（含财政补助）</th>
                        <td><input type="text" name="jyl" value="${finance.jyl}" reg="{'scale':2, 'number':'true', 'maxlength':15}"></td>
                    </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>

</div>