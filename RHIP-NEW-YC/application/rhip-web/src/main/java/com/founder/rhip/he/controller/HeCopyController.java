package com.founder.rhip.he.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeCopy;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.controller.form.QueryForm;
import com.founder.rhip.he.service.IHeCopyService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康教育-稿件提供
 *
 * @author Cary
 */
@Controller
@RequestMapping(value = "/he/copy")
public class HeCopyController extends BaseController {

    @Resource(name = "heCopyService")
    private IHeCopyService heCopyService;

    @Resource(name = "uploadInfoRecordService")
    private IUploadInfoRecordService uploadInfoRecordService;

    /**
     * 查询稿件提供
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String search(HttpServletRequest request, ModelMap model) {
        model.addAttribute("currentOrgCode", getCurrentOrg(request).getOrganCode());
        return "rhip.he.copy.search";
    }

    /**
     * 列表显示稿件提供
     *
     * @param request
     * @param model
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/list")
    public String list(QueryForm queryForm, HttpServletRequest request, ModelMap model){
        Organization organization = getCurrentOrg(request);
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);

        Criteria criteria = queryForm.getCopyCriteria();
        // 不同身份查询条件
        if(!hasRole(RoleType.JKJKJY, request)){
            criteria.add("authorOrg",organization.getOrganCode());
        }

        PageList<HeCopy> pageList = heCopyService.findHeCopy(criteria, page);
        model.addAttribute("heCopys", pageList.getList());
        model.addAttribute("page", pageList.getPage());
        model.addAttribute("createrOrg", organization.getOrganCode());
        return "rhip.he.copy.list";
    }

    /**
     * 添加稿件提供
     *
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Long id, ModelMap model) {
        if (ObjectUtil.isNotEmpty(id)) {
            HeCopy HeCopy = heCopyService.getHeCopy(new Criteria("ID", id));
            model.addAttribute("heCopy", HeCopy);
            List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_COPY.getCode()));
            model.addAttribute("attches", uploadInfoRecords);
        }
        return "rhip.he.copy.detail";
    }

    /**
     * 添加稿件提供
     *
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(ModelMap model) {
        return "rhip.he.copy.edit";
    }

    /**
     * 编辑稿件提供
     *
     * @param id    稿件提供主键ID
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Long id, ModelMap model) {
        // 编辑稿件提供
        if (ObjectUtil.isNotEmpty(id)) {
            HeCopy heCopy = heCopyService.getHeCopy(new Criteria("ID", id));
            model.addAttribute("heCopy", heCopy);
            List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_COPY.getCode()));
            model.addAttribute("attches", uploadInfoRecords);
        }
        return "rhip.he.copy.edit";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Map<String, Object> remove(@PathVariable("id") Long id, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.HE, "稿件提供", OperationName.DELETE);
        int ret = heCopyService.deleteHeCopy(id);
        Map<String, Object> map = new HashMap<>();
        map.put("result", ret > 0 ? true : false);
        map.put("message", ret > 0 ? "删除成功!" : "删除失败!");
        return map;
    }

    /**
     * 保存稿件提供
     *
     * @param heCopy  健康检验资源对象
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> save(HeCopy heCopy, String positionYear, HttpServletRequest request) {
        int ret = 0;
        Map<String, Object> map = new HashMap<>();
        Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("gjtg_fileMap"); // 附件

        // 宣传资料需上传附件
        map = validateAttchement(map, fileMap, heCopy.getId());
        if (ObjectUtil.isNotEmpty(map)) {
            return map;
        }
//        heCopy.setAuthor(String.valueOf(getCurrentUser(request).getId()));
        heCopy.setAuthorOrg(getCurrentOrg(request).getOrganCode());
        heCopy.setCreator(String.valueOf(getCurrentUser(request).getId()));
        heCopy.setCreateOrgan(getCurrentOrg(request).getOrganCode());
        try {
            // 新增稿件提供
            if (ObjectUtil.isNullOrEmpty(heCopy.getId())) {
                createOperationLog(request, RhipModuleName.HE, "稿件提供", OperationName.ADD);
//				initOrgCode(new ConvertingWrapDynaBean(HeCopy), request);
                //宣传阵地每年一条数据，如果已经存在即更新
                {
                    heCopy.setCreateDate(new Date());
                    ret = heCopyService.createHeCopy(heCopy, fileMap, getCurrentUser(request).getName());
                }
            } else { // 更新稿件提供
                createOperationLog(request, RhipModuleName.HE, "稿件提供", OperationName.UPDATE);
                String[] properties = new String[]{"title", "publishDate", "publishOrgan", "edition", "type", "author", "pLevel", "media", "category", "words"};
                ret = heCopyService.updateHeCopy(heCopy, fileMap, getCurrentUser(request).getName(), properties);
            }
            ret = 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            ret = 0;
        }
        // 保存成功清理session
        if (ret == 1 && ObjectUtil.isNotEmpty(fileMap)){
            request.getSession().removeAttribute("gjtg_fileMap");
        }
        map.put("result", ret > 0 ? true : false);
        map.put("message", ret > 0 ? "操作成功!" : "操作失败!");
        return map;
    }

    /**
     * 验证附件数量
     * @param map
     * @param fileMap
     * @param resourceId
     * @return
     */
    protected Map<String, Object> validateAttchement(Map<String, Object> map, Map<String, String> fileMap, Integer resourceId) {
        if (map == null) {
            throw new IllegalArgumentException("map参数可以为空！");
        }
        int count = 0;
        if (resourceId == null) {
            if (ObjectUtil.isNullOrEmpty(fileMap)) {
                map.put("result", false);
                map.put("message", "请上传附件！");
                return map;
            }
            count = fileMap.size();
        } else {
            List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", ResourceCategory.HEALTH_COPY.getCode()));
            if (ObjectUtil.isNotEmpty(fileMap)) {
                count += fileMap.size();
            }
            if (ObjectUtil.isNotEmpty(infoRecords)) {
                count += infoRecords.size();
            }
        }
        if (count > 5) {
            map.put("result", false);
            map.put("message", "附件总数量不能大于5个！");
            return map;
        }
        return map;
    }
}
