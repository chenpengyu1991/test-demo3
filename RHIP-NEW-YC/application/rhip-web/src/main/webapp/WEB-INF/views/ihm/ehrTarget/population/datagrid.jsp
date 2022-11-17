<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div class="repeattable" style="width: 99.8%">
        <table class="layui-table x-admin-sm-table-list-middle">
            <colgroup>
                <col style="width:100px" />
                <col span="19" style="width: 5.5%" />
                <col  style="width:90px" />
            </colgroup>
            <thead>
            <tr>
                <th>机构名称</th>
                <th>0-5</th>
                <th>5-10</th>
                <th>10-15</th>
                <th>15-20</th>
                <th>20-25</th>
                <th>25-30</th>
                <th>30-35</th>
                <th>35-40</th>
                <th>40-45</th>
                <th>45-50</th>
                <th>50-55</th>
                <th>55-60</th>
                <th>60-65</th>
                <th>65-70</th>
                <th>70-75</th>
                <th>75-80</th>
                <th>80-85</th>
                <th>85-90</th>
                <th>90-</th>
                <th>金字塔图</th>
            </thead>
            <tbody>

            <c:forEach var="item" items="${data}"> <c:choose> <c:when test="${item.targetCode=='-1'}">
                <c:set var="total" scope="request" value="${item}"></c:set> </c:when> <c:otherwise>
                <tr>
                    <td data-is-name="true"><ehr:tip>${item.targetName}</ehr:tip></td>
                    <td data-is-data="true" data-total-level="0" data-total="${item.zero}" data-total-man="${item.zero1}" data-total-woman="${item.zero2}" ><tags:numberLabel  defaultValue="0"  value="${item.zero}" type="number" /></td>
                    <td data-is-data="true" data-total-level="1" data-total="${item.one}" data-total-man="${item.one1}" data-total-woman="${item.one2}"><tags:numberLabel  defaultValue="0"  value="${item.one}" type="number" /></td>
                    <td data-is-data="true" data-total-level="2"  data-total="${item.two}" data-total-man="${item.two1}" data-total-woman="${item.two2}"><tags:numberLabel  defaultValue="0"  value="${item.two}" type="number" /></td>
                    <td data-is-data="true" data-total-level="3"  data-total="${item.three}" data-total-man="${item.three1}" data-total-woman="${item.three2}"><tags:numberLabel  defaultValue="0"  value="${item.three}" type="number" /></td>
                    <td data-is-data="true" data-total-level="4"  data-total="${item.four}" data-total-man="${item.four1}" data-total-woman="${item.four2}"><tags:numberLabel  defaultValue="0"  value="${item.four}" type="number" /></td>
                    <td data-is-data="true"  data-total-level="5" data-total="${item.five}" data-total-man="${item.five1}" data-total-woman="${item.five2}"><tags:numberLabel  defaultValue="0"  value="${item.five}" type="number" /></td>
                    <td data-is-data="true" data-total-level="6"  data-total="${item.six}" data-total-man="${item.six1}" data-total-woman="${item.six2}"><tags:numberLabel  defaultValue="0"  value="${item.six}" type="number" /></td>
                    <td data-is-data="true" data-total-level="7"  data-total="${item.seven}" data-total-man="${item.seven1}" data-total-woman="${item.seven2}"><tags:numberLabel  defaultValue="0"  value="${item.seven}" type="number" /></td>
                    <td data-is-data="true" data-total-level="8"  data-total="${item.eight}" data-total-man="${item.eight1}" data-total-woman="${item.eight2}"><tags:numberLabel  defaultValue="0"  value="${item.eight}" type="number" /></td>
                    <td data-is-data="true" data-total-level="9"  data-total="${item.nine}" data-total-man="${item.nine1}" data-total-woman="${item.nine2}"><tags:numberLabel  defaultValue="0"  value="${item.nine}" type="number" /></td>
                    <td data-is-data="true" data-total-level="10"  data-total="${item.ten}" data-total-man="${item.ten1}" data-total-woman="${item.ten2}"><tags:numberLabel  defaultValue="0"  value="${item.ten}" type="number" /></td>
                    <td data-is-data="true" data-total-level="11"  data-total="${item.eleven}" data-total-man="${item.eleven1}" data-total-woman="${item.eleven2}"><tags:numberLabel  defaultValue="0"  value="${item.eleven}" type="number" /></td>
                    <td data-is-data="true" data-total-level="12"  data-total="${item.twelve}" data-total-man="${item.twelve1}" data-total-woman="${item.twelve2}"><tags:numberLabel  defaultValue="0"  value="${item.twelve}" type="number" /></td>
                    <td data-is-data="true" data-total-level="13"  data-total="${item.thirteen}" data-total-man="${item.thirteen1}" data-total-woman="${item.thirteen2}"><tags:numberLabel  defaultValue="0"  value="${item.thirteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="14"  data-total="${item.fourteen}" data-total-man="${item.fourteen1}" data-total-woman="${item.fourteen2}"><tags:numberLabel  defaultValue="0"  value="${item.fourteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="15"  data-total="${item.fifteen}" data-total-man="${item.fifteen1}" data-total-woman="${item.fifteen2}"><tags:numberLabel  defaultValue="0"  value="${item.fifteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="16"  data-total="${item.sixteen}" data-total-man="${item.sixteen1}" data-total-woman="${item.sixteen2}"><tags:numberLabel  defaultValue="0"  value="${item.sixteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="17"  data-total="${item.seventeen}" data-total-man="${item.seventeen1}" data-total-woman="${item.seventeen2}"><tags:numberLabel  defaultValue="0"  value="${item.seventeen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="18"  data-total="${item.eighteen}" data-total-man="${item.eighteen1}" data-total-woman="${item.eighteen2}"><tags:numberLabel  defaultValue="0"  value="${item.eighteen}" type="number" /></td>
                    <td><a class="pop" href="javascript:void(0)"  >金字塔图</a> </td>
                </tr>
            </c:otherwise> </c:choose> </c:forEach> <c:if test="${not empty total}">
                <tr>
                    <td  data-is-name="true">合计</td>
                    <td data-is-data="true" data-total-level="0" data-total="${total.zero}" data-total-man="${total.zero1}" data-total-woman="${total.zero2}" ><tags:numberLabel  defaultValue="0"  value="${total.zero}" type="number" /></td>
                    <td data-is-data="true" data-total-level="1" data-total="${total.one}" data-total-man="${total.one1}" data-total-woman="${total.one2}"><tags:numberLabel  defaultValue="0"  value="${total.one}" type="number" /></td>
                    <td data-is-data="true" data-total-level="2"  data-total="${total.two}" data-total-man="${total.two1}" data-total-woman="${total.two2}"><tags:numberLabel  defaultValue="0"  value="${total.two}" type="number" /></td>
                    <td data-is-data="true" data-total-level="3"  data-total="${total.three}" data-total-man="${total.three1}" data-total-woman="${total.three2}"><tags:numberLabel  defaultValue="0"  value="${total.three}" type="number" /></td>
                    <td data-is-data="true" data-total-level="4"  data-total="${total.four}" data-total-man="${total.four1}" data-total-woman="${total.four2}"><tags:numberLabel  defaultValue="0"  value="${total.four}" type="number" /></td>
                    <td data-is-data="true"  data-total-level="5" data-total="${total.five}" data-total-man="${total.five1}" data-total-woman="${total.five2}"><tags:numberLabel  defaultValue="0"  value="${total.five}" type="number" /></td>
                    <td data-is-data="true" data-total-level="6"  data-total="${total.six}" data-total-man="${total.six1}" data-total-woman="${total.six2}"><tags:numberLabel  defaultValue="0"  value="${total.six}" type="number" /></td>
                    <td data-is-data="true" data-total-level="7"  data-total="${total.seven}" data-total-man="${total.seven1}" data-total-woman="${total.seven2}"><tags:numberLabel  defaultValue="0"  value="${total.seven}" type="number" /></td>
                    <td data-is-data="true" data-total-level="8"  data-total="${total.eight}" data-total-man="${total.eight1}" data-total-woman="${total.eight2}"><tags:numberLabel  defaultValue="0"  value="${total.eight}" type="number" /></td>
                    <td data-is-data="true" data-total-level="9"  data-total="${total.nine}" data-total-man="${total.nine1}" data-total-woman="${total.nine2}"><tags:numberLabel  defaultValue="0"  value="${total.nine}" type="number" /></td>
                    <td data-is-data="true" data-total-level="10"  data-total="${total.ten}" data-total-man="${total.ten1}" data-total-woman="${total.ten2}"><tags:numberLabel  defaultValue="0"  value="${total.ten}" type="number" /></td>
                    <td data-is-data="true" data-total-level="11"  data-total="${total.eleven}" data-total-man="${total.eleven1}" data-total-woman="${total.eleven2}"><tags:numberLabel  defaultValue="0"  value="${total.eleven}" type="number" /></td>
                    <td data-is-data="true" data-total-level="12"  data-total="${total.twelve}" data-total-man="${total.twelve1}" data-total-woman="${total.twelve2}"><tags:numberLabel  defaultValue="0"  value="${total.twelve}" type="number" /></td>
                    <td data-is-data="true" data-total-level="13"  data-total="${total.thirteen}" data-total-man="${total.thirteen1}" data-total-woman="${total.thirteen2}"><tags:numberLabel  defaultValue="0"  value="${total.thirteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="14"  data-total="${total.fourteen}" data-total-man="${total.fourteen1}" data-total-woman="${total.fourteen2}"><tags:numberLabel  defaultValue="0"  value="${total.fourteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="15"  data-total="${total.fifteen}" data-total-man="${total.fifteen1}" data-total-woman="${total.fifteen2}"><tags:numberLabel  defaultValue="0"  value="${total.fifteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="16"  data-total="${total.sixteen}" data-total-man="${total.sixteen1}" data-total-woman="${total.sixteen2}"><tags:numberLabel  defaultValue="0"  value="${total.sixteen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="17"  data-total="${total.seventeen}" data-total-man="${total.seventeen1}" data-total-woman="${total.seventeen2}"><tags:numberLabel  defaultValue="0"  value="${total.seventeen}" type="number" /></td>
                    <td data-is-data="true" data-total-level="18"  data-total="${total.eighteen}" data-total-man="${total.eighteen1}" data-total-woman="${total.eighteen2}"><tags:numberLabel  defaultValue="0"  value="${total.eighteen}" type="number" /></td>
                    <td><a class="pop" href="javascript:void(0)"  >金字塔图</a> </td>
                    <td></td>
                </tr>

            </c:if>

            </tbody>
        </table>
    </div>
