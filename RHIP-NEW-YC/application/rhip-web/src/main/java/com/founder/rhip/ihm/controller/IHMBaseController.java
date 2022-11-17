package com.founder.rhip.ihm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import org.springframework.ui.Model;

import com.founder.elb.entity.Role;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.mdm.entity.Organization;

public class IHMBaseController extends BaseController {

    /** EChart xAxis */
    protected static final String XAXIS_JSON = "xAxisJSON";
    protected static final String YAXIS_JSON = "yAxisJSON";
    /** EChart series */
    protected static final String SERIES_JSON = "seriesJSON";
    /** EChart legend */
    protected static final String LEGEND_JSON = "legendJSON";
    //提示信息
    protected static final String TOOLTIP_JSON = "tooltipJSON";
    //附加提示信息：例如（下钻）
    protected static final String EXTRA_TOOLTIP_JSON = "extraTooltipJSON";

	protected Integer codeType(HttpServletRequest request, Integer codeType) {
		List<Role> roleList = this.getCurrentUserRole(request);
		for (Role role : roleList) {
			if (RoleType.ZX_GLY.getValue().equals(role.getRoleCode())) {
				return TargetDTO.CENTER;
			} else if (RoleType.Z_GLY.getValue().equals(role.getRoleCode())) {
				return TargetDTO.STATION;
			}
		}
		return codeType;
	}
	
	protected void initOrg(HttpServletRequest request, Model model) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("orgCode",org.getOrganCode());	
		model.addAttribute("currentBeginDate",DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
	}

	protected String orgCode(HttpServletRequest request, String orgCode) {
		String code = this.getCurrentOrg(request).getOrganCode();
		List<Role> roleList = this.getCurrentUserRole(request);
		for (Role role : roleList) {
			if (RoleType.ZX_GLY.getValue().equals(role.getRoleCode())
					|| RoleType.Z_GLY.getValue().equals(role.getRoleCode())) {
				return code;
			}
		}
		return orgCode;
	}

	protected Integer nextCodeType(HttpServletRequest request, Integer nextCodeType){
		List<Role> roleList = this.getCurrentUserRole(request);
		for (Role role : roleList) {
			if (RoleType.ZX_GLY.getValue().equals(role.getRoleCode())
					|| RoleType.Z_GLY.getValue().equals(role.getRoleCode())) {
				return TargetDTO.STATION;
			}
		}
		return nextCodeType;
	}

    protected String convertToJSON(Object o) {
        return JSONArray.fromObject(o).toString();
    }

    /**
     * 添加Y轴数据
     * @param name 名称
     * @param unit 单位
     * @return
     */
    protected Map<String,Object> addYAxis(String name, String unit){
        Map<String,Object> yAxisMap = new HashMap<>();
        yAxisMap.put("name",name);
        yAxisMap.put("type","value");
        Map<String,Object> axisLabelMap = new HashMap<>();
        axisLabelMap.put("formatter","{value} " + unit);
        yAxisMap.put("axisLabel",axisLabelMap);
        return  yAxisMap;
    }

    protected Map<String,Object> addSeries(String name, String type, List<String> seriesDataList){
        Map<String,Object> seriesMap = new HashMap<>();
        seriesMap.put("name",name);
        seriesMap.put("type",type);
        seriesMap.put("data",seriesDataList.toArray(new String[seriesDataList.size()]));
        return seriesMap;
    }


    protected Map<String,Object> addSeries(String name,String type,List<Object> seriesDataList,Integer yAxisIndex){
        Map<String,Object> seriesMap = new HashMap<>();
        seriesMap.put("name",name);
        seriesMap.put("type",type);
        seriesMap.put("yAxisIndex",yAxisIndex);
        seriesMap.put("data",seriesDataList.toArray(new Object[seriesDataList.size()]));
        return seriesMap;
    }

    /**
     * 添加饼图数据
     * @param value
     * @param name
     * @return
     */
    protected Map<String, Object> addPieData(Object value,String name){
        Map<String, Object> data = new HashMap<String,Object>();
        data.put("value",value);
        data.put("name",name);
        return data;
    }
}
