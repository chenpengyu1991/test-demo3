<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/finance/edit.js"/>

<!--新增公立医院收支明细表-->
<div class="toolbar">
    <a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
    <a href="javascript:void(0)" id="save"><b class="baocun">临时保存</b></a>
	<a href="javascript:void(0)" id="submit"><b class="tijiao">上报</b></a>
</div>
<form class="postcontent" id="editForm">
    <div class="postdiv">
        <fieldset>
            <legend>本次录入（单位：元）</legend>
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
                    <th>单位</th>
                    <td>
                        <input type="hidden" name="organCode" id="organCode" value="${organCode}"/>
                        <ehr:org code="${organCode}"></ehr:org>
                    </td>
                    <th><label class="required">截止月份</label></th>
                    <td>
                        <c:if test="${empty finance.id}">
                            <input type="text" name="month" id="month" value="${finance.month}"  reg="{'required':'true','number':'true','length':6}" style="width: 100px;"/>(例：201409)
                        </c:if>
                        <c:if test="${!empty finance.id}">
                              ${finance.month}
                              <input type="hidden" name="month"  value="${finance.month}"  style="width: 100px;" readonly/>
                        </c:if>
                    </td> 
                </tr>
                <tr>
                    <th><label class="required">收入合计</label></th>
                    <td><input type="text" name="incomeTotal" value="${finance.incomeTotal}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">财政补助收入</label></th>
                    <td><input type="text" name="subsidyIncome" value="${finance.subsidyIncome}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">支出合计</label></th>
                    <td><input type="text" name="expensesTotal" value="${finance.expensesTotal}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">人员经费</label></th>
                    <td><input type="text" name="personnelFunds" value="${finance.personnelFunds}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">工资福利支出</label></th>
                    <td><input type="text" name="salariesBenefits" value="${finance.salariesBenefits}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">对个人和家庭补助</label></th>
                    <td><input type="text" name="familySubsidy" value="${finance.familySubsidy}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}">
                    </td>
                    
                </tr>
                <tr>
                    <th><label class="required">卫生材料费</label></th>
                    <td><input type="text" name="materials" value="${finance.materials}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">药品费</label></th>
                    <td><input type="text" name="pharmaceuticalsFee" value="${finance.pharmaceuticalsFee}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}">
                    </td>
                </tr>
                <tr>
                    <th><label class="required">固定资产折旧</label></th>
                    <td><input type="text" name="depreciation" value="${finance.depreciation}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">计提医疗风险基金</label></th>
                    <td>
                        <input type="text" name="vcFunds" value="${finance.vcFunds}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}">
                    </td>
                </tr>
                <tr>
                    <th><label class="required">其他费用</label></th>
                    <td><input type="text" name="otherFee" value="${finance.otherFee}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">商品和服务支出</label></th>
                    <td><input type="text" name="goodsServicesCost" value="${finance.goodsServicesCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">办公费</label></th>
                    <td><input type="text" name="officeCost" value="${finance.officeCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">印刷费</label></th>
                    <td><input type="text" name="printingCost" value="${finance.printingCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">水费</label></th>
                    <td><input type="text" name="waterCost" value="${finance.waterCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">电费</label></th>
                    <td><input type="text" name="electricityCost" value="${finance.electricityCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">保安费</label></th>
                    <td><input type="text" name="securityCost" value="${finance.securityCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">差旅费</label></th>
                    <td><input type="text" name="travelCost" value="${finance.travelCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">出国费</label></th>
                    <td><input type="text" name="abroadCost" value="${finance.abroadCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">维护费</label></th>
                    <td><input type="text" name="maintenanceCost" value="${finance.maintenanceCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">会议费</label></th>
                    <td><input type="text" name="meetingCost" value="${finance.meetingCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">培训费</label></th>
                    <td><input type="text" name="trainingCost" value="${finance.trainingCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">公务接待费</label></th>
                    <td><input type="text" name="hostingCost" value="${finance.hostingCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">其他材料费</label></th>
                    <td><input type="text" name="otherMaterialCost" value="${finance.otherMaterialCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">劳务费</label></th>
                    <td><input type="text" name="laborCost" value="${finance.laborCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">委托业务费</label></th>
                    <td><input type="text" name="commissionsCost" value="${finance.commissionsCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">福利费</label></th>
                    <td><input type="text" name="welfareCost" value="${finance.welfareCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">公务用车运行维护费</label></th>
                    <td><input type="text" name="carCost" value="${finance.carCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">其他商品和服务支出</label></th>
                    <td><input type="text" name="otherGoodsCost" value="${finance.otherGoodsCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">其他支出</label></th>
                    <td><input type="text" name="otherCost" value="${finance.otherCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">其他支出(合计)</label></th>
                    <td><input type="text" name="otherCostTotal" value="${finance.otherCostTotal}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">坏账损失</label></th>
                    <td><input type="text" name="lossesCost" value="${finance.lossesCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">银行利息支出</label></th>
                    <td><input type="text" name="interestPayments" value="${finance.interestPayments}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">洗涤费</label></th>
                    <td><input type="text" name="washCost" value="${finance.washCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">保洁费</label></th>
                    <td><input type="text" name="procterCost" value="${finance.procterCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">燃料费</label></th>
                    <td><input type="text" name="fuelCost" value="${finance.fuelCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">其他</label></th>
                    <td><input type="text" name="other" value="${finance.other}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th><label class="required">食堂支出</label></th>
                    <td><input type="text" name="canteenCost" value="${finance.canteenCost}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                </tr>
                <tr>
                    <th><label class="required">收支结余（含财政补助）</label></th>
                    <td><input type="text" name="balance" value="${finance.balance}" reg="{'required':'true','scale':2,'number':'true','maxlength':15}"></td>
                    <th>说明</th>
                    <td><input type="text" name="comments" value="${finance.comments}" reg="{'maxlength':100}"></td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
