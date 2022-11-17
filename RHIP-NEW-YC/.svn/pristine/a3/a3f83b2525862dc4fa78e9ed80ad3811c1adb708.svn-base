<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="biteLevel" type="java.lang.String" required="false"%>
<%@ attribute name="showSelectLevel" type="java.lang.String" required="false"%>

<div class="repeattable">
    <table>
        <tbody>
            <tr>
                <th style="width: 10%;text-align: center;">分级</th>
                <th style="width: 50%;text-align: center;">接触方式</th>
                <th style="width: 10%;text-align: center;">暴露程度</th>
                <th style="width: 30%;text-align: center;">医师建议</th>
            </tr>
            <tr>
                <td>
                	<c:choose>
                		<c:when test="${showSelectLevel}">
                    		<input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel" 
                        		${biteLevel eq '1' ? 'checked=checked' : ''} type="radio" value="1" checked="checked">
                        </c:when>
                        <c:otherwise>
                        	<input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel" disabled="disabled"
                        		${biteLevel eq '1' ? 'checked=checked' : ''} type="radio" value="1" checked="checked">
                        </c:otherwise>
                    </c:choose> 
                    &nbsp;I级
                </td>
                <td>
					 符合以下情况之一者：
                    <br/>1、接触或喂养动物；
                    <br/>2、完好的皮肤被舔。
                </td>
                <td>无</td>
                <td>确认接触方式可靠则不需处置。</td>
            </tr>
            <tr>
                <td>
                   	<c:choose>
                		<c:when test="${showSelectLevel}">
                    		<input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel" 
                        		${biteLevel eq '2' ? 'checked=checked' : ''} type="radio" value="2" checked="checked">
                        </c:when>
                        <c:otherwise>
                        	<input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel" disabled="disabled"
                        		${biteLevel eq '2' ? 'checked=checked' : ''} type="radio" value="2" checked="checked">
                        </c:otherwise>
                    </c:choose> 
                    &nbsp;II级
                </td>
                <td>
					符合以下情况之一者：
                    <br/>1、裸露的皮肤被轻咬；
                    <br/>2、无出血的轻微抓伤或擦伤。
                </td>
                <td>轻度</td>
                <td>
                	1、处理伤口；<br/>
                	2、接种人狂犬病疫苗。
                </td>
            </tr>
            <tr>
                <td>
                    <c:choose>
                		<c:when test="${showSelectLevel}">
                    		<input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel" 
                        		${biteLevel eq '3' ? 'checked=checked' : ''} type="radio" value="3" checked="checked">
                        </c:when>
                        <c:otherwise>
                        	<input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel" disabled="disabled"
                        		${biteLevel eq '3' ? 'checked=checked' : ''} type="radio" value="3" checked="checked">
                        </c:otherwise>
                    </c:choose> 
                    &nbsp;III级
                </td>
                <td>
                  	  符合以下情况之一者：<br/>
                    1、单处或多处贯穿性皮肤咬伤或抓伤；<br/>
                    2、破损皮肤被舔；<br/>
                    3、开放性伤口或粘膜被污染。
                </td>
                <td>重度</td>
                <td>
                	1、处理伤口；<br/>
               		2、接种人狂犬病疫苗；<br/>
              		3、注射狂犬病人免疫球蛋白。
              	</td>
            </tr>
        </tbody>
    </table>
</div>

     
