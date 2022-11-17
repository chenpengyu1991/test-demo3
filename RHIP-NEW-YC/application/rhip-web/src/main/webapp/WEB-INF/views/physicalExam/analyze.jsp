<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/physicalExam/analyze.js" type="text/javascript"></script>
    <div class="searchBox" >
        <form method="post" id="analyzeSearchForm">
            <input type="hidden" name="beginDate" value="${beginDate}"/>
            <input type="hidden" name="endDate" value="${endDate}"/>
            <input type="hidden" name="phyExamOrg" value="${phyExamOrg}"/>
            <input type="hidden" name="phyType" value="${phyType}"/>
            <input type="hidden" name="name" value="${name}"/>
            <input type="hidden" name="idcard" value="${idcard}"/>
            <table>
                <colgroup>
                    <col style="width: 15%">
                    <col style="width: 85%">
                </colgroup>
                <tr>
                    <td class="col-text">体重</td>
                    <td class="col-input">
                        <label><input type="radio" name="weight" value="1"/><span> 超重</span></label>
                        <label><input type="radio"  name="weight" value="2"/><span> 肥胖</span></label>
                    </td>
                </tr>
    <!-- 			<tr> -->
    <!-- 				<td> -->
    <!-- 					<label><input type="checkbox" name="cigarate"/><span> 吸烟</span></label> -->
    <!-- 				</td> -->
    <!-- 				<td> -->
    <!-- 					<label><input type="checkbox" name="drink"/><span> 饮酒</span></label> -->
    <!-- 				</td> -->
    <!-- 			</tr> -->
                <tr>
                    <td class="col-text">异常指标</td>
                    <td class="col-input">
                        <table>
                            <colgroup>
                                <col style="width: 25%">
                                <col style="width: 25%">
                                <col style="width: 25%">
                                <col style="width: 25%">
                            </colgroup>
                            <tr>
                                <td class="col-input">
                                    <label><input type="checkbox" name="hepatitisB"/><span> 乙肝表面抗原阳性</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="bloodfat"/><span> 血脂异常</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="bpvQuantity"/><span> 血压异常</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="ifgQuantity"/><span> 血糖异常</span></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-input">
                                    <label><input type="checkbox" name="liverAbnormalQuantity"/><span> 肝功能异常</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="renalAbnormalQuantity"/><span> 肾功能异常人数</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="xRayAbnormalQuantity"/><span> 心电图异常</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="hepaticCystQuantity"/><span> 肝囊肿</span></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-input">
                                    <label><input type="checkbox" name="gallStoneQuantity"/><span> 胆结石</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="cholecystitisQuantity"/><span> 胆囊炎</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="renalCystQuantity"/><span> 肾囊肿</span></label>
                                </td>
                                <td class="col-input">
                                    <label><input type="checkbox" name="kidneyStoneQuantity"/><span> 肾结石</span></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-input">
                                    <label><input type="checkbox" name="tumorQuantity"/><span> 可疑肿瘤</span></label>
                                </td>
                                <td class="col-input" colspan="3">
                                    <label><input type="checkbox" name="tuberculosisQuantity"/><span> 可疑肺结核</span></label>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="button" id="analyzeForm" class="search_btn" value="分析" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
