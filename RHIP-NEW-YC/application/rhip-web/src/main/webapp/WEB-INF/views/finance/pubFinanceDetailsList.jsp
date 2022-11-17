<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<script>
    //合计
    if($("#isAdmin").val() == 'T'){
    $(function () {
        var trData = {};
        var trDataL = {};
        var tds = 0;
        var tdsl = 0;
        for (var s = 1; s < 100; s++) {
            trData[s] = 0;
            trDataL[s] = 0;
        }
        $("#listBody tr").each(function (trindex, tritem) {
            $(tritem).find("td").each(function (tdindex, tditem) {
                if (tdindex > 0 && trindex % 3 == 0) {
                    var inputValue = $(tditem).text();
                    inputValue = inputValue.replace(/\t/g, '');//制表符替换
                    inputValue = inputValue.replace(/\n/g, '');//换行替换
                    inputValue = inputValue.replace(/,/g, '');
                    if ('' != inputValue && "undefined" != inputValue && undefined != inputValue) {
                        trData[tdindex] = trData[tdindex] + Number($.trim(inputValue));
                    }
                    tds = tdindex;
                }
                if (tdindex > 0 && trindex % 3 == 1) {
                    var inputValueL = $(tditem).text();
                    inputValueL = inputValueL.replace(/\t/g, '');//制表符替换
                    inputValueL = inputValueL.replace(/\n/g, '');//换行替换
                    inputValueL = inputValueL.replace(/,/g, '');
                    if ('' != inputValueL && "undefined" != inputValueL && undefined != inputValueL && 0 != inputValueL) {
                        trDataL[tdindex] = trDataL[tdindex] + Number($.trim(inputValueL));
                    }
                    tdsl = tdindex;
                }
            });
        });
        var html = '<tr style="display: ${(empty resultList || isAdmin ==  'F')? 'none':''}"><td rowspan="3">合计</td><td>今年</td>';
        for (var b = 2; b <= tds; b++) {
            html = html + '<td style="text-align:right" id=sumRow' + b + '>' + fmoney(trData[b],2) + '</td>';
        }
        html = html + '</tr>';
        html = html + '<tr style="display: ${(empty resultList || isAdmin ==  'F')? 'none':''}"><td>去年</td>';
        for (var b = 1; b <= tdsl; b++) {
            html = html + '<td style="text-align:right" id=sumRowL' + b + '>' + fmoney(trDataL[b],2) + '</td>';
        }
        html = html + '</tr>';
        html = html + '<tr style="display: ${(empty resultList || isAdmin ==  'F')? 'none':''}"><td>同比(%)</td>';
        for (var b = 1; b < tds; b++) {
            html = html + '<td style="text-align:right" id=yearOnYear' + b + '>' + 0 + '</td>';
        }
        html = html + '</tr>';
        $("#listTable").append(html);
        $("#sumRow41").text('');
        $("#sumRowL40").text('');
    })
    }
    $(function tb() {

        var tbData = {};
        var tdData = {};
        var tdDataL = {};
        for (var s = 1; s < 100; s++) {
            tbData[s] = 0;
            tdData[s] = 0;
            tdDataL[s] = 0;
        }
        $("#listBody tr").each(function (trindex, tritem) {
            $(tritem).find("td").each(function (tdindex, tditem) {
                if (trindex % 3 == 0 && tdindex != 0 && tdindex != 1) {
                    var inputValue = $(tditem).text();
                    inputValue = inputValue.replace(/\t/g, '');//制表符替换
                    inputValue = inputValue.replace(/\n/g, '');//换行替换
                    inputValue = inputValue.replace(/,/g, '');
                    tdData[tdindex] = inputValue;
                }
                if (trindex % 3 == 1 && tdindex != 0) {
                    var inputValueL = $(tditem).text();
                    inputValueL = inputValueL.replace(/\t/g, '');//制表符替换
                    inputValueL = inputValueL.replace(/\n/g, '');//换行替换
                    inputValueL = inputValueL.replace(/,/g, '');
                    if ('' != inputValueL && "undefined" != inputValueL && undefined != inputValueL && 0 != inputValueL) {
                        tdDataL[tdindex+1] = inputValueL;
                        tbData[tdindex] = ((Number(tdData[tdindex]) / Number(tdDataL[tdindex]) - 1)* 100).toFixed(2) ;
                    } else {
                        tbData[tdindex+1] = "";
                    }
                }
                if (trindex % 3 == 2) {
                	
                    if (tdindex != 0) {
                        $(tritem).find("td").eq(tdindex).html(tbData[tdindex+1]);
                        $(tritem).find("td").eq(tdindex).css("text-align", "right");
                    }
                    if(tdindex == 40 ){
                        $(tritem).find("td").eq(tdindex).html('');
                    }
                 }
                tbData[tbData.length-1] ="";
            });
        });

        $("#sumRow41").text('');
        $("#sumRowL40").text('');
    })

    function fmoney(s, n) {
        n = n > 0 && n <= 20 ? n : 2;
        s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
        var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
        t = "";
        for (i = 0; i < l.length; i++) {
            t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
        }
        return t.split("").reverse().join("") + "." + r;
    }
</script>
<div class="repeattable" style="overflow-x: auto; overflow-y: auto; min-width: 4000px; width: 100%; height: 700px;">
    <input type="hidden" id="isAdmin" value="${isAdmin}"/>
    <table id="listTable" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 100px;"/>
            <col style="width: 65px;"/>
        </colgroup>
        <caption><h1>公立医院${year}年 1-${month}月收支明细表</h1>（单位：元）</caption>
        <thead>
        <tr>
            <th style="text-align: center" colspan="2">单 位</th>
            <th style="text-align: center">收入合计</th>
            <th style="text-align: center">财政补助收入</th>
            <th style="text-align: center">支出合计</th>
            <th style="text-align: center">人员经费</th>
            <th style="text-align: center">工资福利支出</th>
            <th style="text-align: center">对个人和家庭补助</th>
            <th style="text-align: center">卫生材料费</th>
            <th style="text-align: center">药品费</th>
            <th style="text-align: center">固定资产折旧</th>
            <th style="text-align: center">计提医疗风险基金</th>
            <th style="text-align: center">其他费用</th>
            <th style="text-align: center">商品和服务支出</th>
            <th style="text-align: center">办公费</th>
            <th style="text-align: center">印刷费</th>
            <th style="text-align: center">水费</th>
            <th style="text-align: center">电费</th>
            <th style="text-align: center">保安费</th>
            <th style="text-align: center">差旅费</th>
            <th style="text-align: center">出国费</th>
            <th style="text-align: center">维护费</th>
            <th style="text-align: center">会议费</th>
            <th style="text-align: center">培训费</th>
            <th style="text-align: center">公务接待费</th>
            <th style="text-align: center">其他材料费</th>
            <th style="text-align: center">劳务费</th>
            <th style="text-align: center">委托业务费</th>
            <th style="text-align: center">福利费</th>
            <th style="text-align: center">公务用车运行维护费</th>
            <th style="text-align: center">其他商品和服务支出</th>
            <th style="text-align: center">其他支出</th>
            <th style="text-align: center">其他支出(合计)</th>
            <th style="text-align: center">坏账损失</th>
            <th style="text-align: center">银行利息支出</th>
            <th style="text-align: center">洗涤费</th>
            <th style="text-align: center">保洁费</th>
            <th style="text-align: center">燃料费</th>
            <th style="text-align: center">其他</th>
            <th style="text-align: center">食堂支出</th>
            <th style="text-align: center">收支结余（含财政补助）</th>
            <th style="text-align: center">说明</th>
        </tr>
        </thead>
        <tbody id="listBody" onload=" tb()">
        <c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <c:if test="${status.count%3==1}">
                    <td rowspan="3"><ehr:tip><ehr:org code="${result.organCode}"></ehr:org></ehr:tip></td>
                    <td>今年</td>
                </c:if>
                <c:if test="${status.count%3==2}">
                    <td>去年</td>
                </c:if>
                <c:if test="${status.count%3==0}">
                    <td>同比(%)</td>
                </c:if>
                <td><tags:numberLabel value="${result.incomeTotal}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.subsidyIncome}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.expensesTotal}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.personnelFunds}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.salariesBenefits}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.familySubsidy}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.materials}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.pharmaceuticalsFee}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.depreciation}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.vcFunds}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.otherFee}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.goodsServicesCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.officeCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.printingCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.waterCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.electricityCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.securityCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.travelCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.abroadCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.maintenanceCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.meetingCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.trainingCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.hostingCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.otherMaterialCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.laborCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.commissionsCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.welfareCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.carCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.otherGoodsCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.otherCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.otherCostTotal}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.lossesCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.interestPayments}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.washCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.procterCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.fuelCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.other}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.canteenCost}" defaultValue="0" align="right"/></td>
                <td><tags:numberLabel value="${result.balance}" defaultValue="0" align="right"/></td>
                <td><ehr:tip>${result.comments}</ehr:tip></td>
                <input type="hidden" name="id" value="${result.id}"/>
                <input type="hidden" name="status" value="${result.status}" />
                <input type="hidden" name="isSubmit" value="${result.isSubmit}" />
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
