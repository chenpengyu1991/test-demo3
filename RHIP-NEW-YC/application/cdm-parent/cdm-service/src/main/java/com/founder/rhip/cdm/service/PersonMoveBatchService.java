package com.founder.rhip.cdm.service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chen_haibing
 * Date: 12/4/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("personMoveBatchService")
@TaskBean(description = "批量转移到车路坝社区卫生服务站")
public class PersonMoveBatchService implements Task {
//    @Autowired(required = false)
//    PersonalRecordManagmentServiceImpl personalRecordManagmentService;
    @Autowired(required = false)
    private List<IPersonRecordMoveService> personRecordMove;
    @Autowired
    IPlatformService platformService;
    @Autowired
    private IOrganizationApp organizationApp;

//    protected Logger log = Logger.getLogger(this.getClass());
    Logger loggger = LoggerFactory.getLogger(this.getClass());

    public void run(Map<String, Object> data){
        String[] idCardList ={"320520196209152916",
                "320520196208152922",
                "320520195110062940",
                "320520193812142954",
                "320520196312042950",
                "320520192409092913",
                "320520194607192914",
                "320520196710262924",
                "320520194512172910",
                "320520194404182919",
                "320581198604052917",
                "320520193302102928",
                "32052019540318292X",
                "320520194003102914",
                "320520195605202917",
                "320520194504132927",
                "320520193401122924",
                "320520194401152925",
                "320520194803202913",
                "320520193304222923",
                "320520194403192912",
                "320520195305082917",
                "320520196208232922",
                "320520196303152947",
                "320520196508222937",
                "320520192909082965",
                "320520192508082913",
                "320520193605122926",
                "320520193507272912",
                "320520194807122929",
                "320520194508112915",
                "320520194807152917",
                "320520193809192918",
                "320520194112082924",
                "320520194310202915",
                "320520194504082915",
                "320521192705207320",
                "320520194703082918",
                "320520196212012922",
                "320520195011102927",
                "32052019470301291X",
                "320520193408032913",
                "320520192212062913",
                "320520193603072929",
                "320520193208182925",
                "320520192010062915",
                "320520196206222923",
                "320520195903302924",
                "320520195808102916",
                "320520194909132933",
                "320520194111302921",
                "32052019410908294X",
                "320520194405232914",
                "320520194202122926",
                "320520192903052917",
                "320520194709062918",
                "320520194206252912",
                "320520194502152940",
                "320520194706062912",
                "320520193811202919",
                "320511194405152037",
                "32052019470612292X",
                "320520193708142911",
                "320520194407242913",
                "320520196512152919",
                "320520196912162913",
                "320520193610032925",
                "320520193511022924",
                "320520192704212922",
                "320520194508262921",
                "320520195209082925",
                "320520195406272920",
                "320520196304252915",
                "320520194409142924",
                "320520194705222910",
                "320520194203272918",
                "320520196211272917",
                "320520194801262920",
                "320520194801062945",
                "32052019410907291X",
                "320520196808252919",
                "320520192812242926",
                "320520194509222921",
                "320520194709182928",
                "32052019450618291X",
                "32052019410325291X",
                "320520194811132927",
                "320520193807302925",
                "320520194004052920",
                "320520194702202914",
                "320520193303032917",
                "320520193812142938",
                "320520196711172920",
                "320520195003032922",
                "32052019461003292X",
                "32052019620816291X",
                "320520194510102927",
                "320520195209192921",
                "320520193301252916",
                "320520196112102912",
                "320520194511062912",
                "320520194308232920",
                "320520194912272910",
                "320520193509272924",
                "320520193603152929",
                "320520194511292945",
                "320520193701112920",
                "320520194103032925",
                "320520197110062915",
                "320520191410092916",
                "320520196208142927",
                "320520194609092917",
                "320520193607052925",
                "320520193310052924",
                "320520193911082918",
                "320520195601072924",
                "320520195203072929",
                "320520195511262919",
                "320520193006152920",
                "320520193005042914",
                "320520193310162920",
                "320520195707272916",
                "320520195606122943",
                "320520193408202927",
                "320520193008082946",
                "320520194606202922",
                "320520194806282920",
                "320520194409212937",
                "320520195708172925",
                "320520194912052942",
                "320520194706102929",
                "320520194709092914",
                "320520195004142920",
                "320520194706202911",
                "320520194709242927",
                "320520194112142923",
                "320520195306122917",
                "320520192702252912",
                "320520192807302912",
                "320520193304282926",
                "320520192911112924",
                "320520193510272921",
                "320520192807072942",
                "320520193307202936",
                "320520193301132914",
                "320520192811122922",
                "320520193509292925",
                "320520193612072920",
                "320520195707102917",
                "320520194805022924",
                "320520193009092919",
                "320520196708302034",
                "320520193012202912",
                "320520193603172911",
                "320520194712152922",
                "320520193304242924",
                "320520193007042926",
                "320520193907212919",
                "32052019600421292X",
                "320520194705162911",
        };
        for(String idCard: idCardList){
            PersonInfo personInfo = platformService.queryPersonalInfo("", idCard);
            if(!ObjectUtil.isNotEmpty(personInfo)){
                loggger.error("找不到身份证号为:" + idCard + "的personInfo");
                continue;
            }
            if(StringUtil.isNullOrEmpty(personInfo.getInputOrganCode())){
                loggger.error("找不到身份证号为:" + idCard +"姓名为："+personInfo.getName() + "的原管理单位");
                continue;
            }
            Organization oldOrg = organizationApp.queryOrgan(personInfo.getInputOrganCode());
            if(!ObjectUtil.isNotEmpty(oldOrg)){
                loggger.error("找不到身份证号为:" + idCard +"姓名为："+personInfo.getName() + "的原管理单位");
                continue;
            }
            Organization newOrg = organizationApp.queryOrgan("320002917");

//            personalRecordManagmentService.personRecordMove(personInfo.getId(), personInfo.getSmpiId(), oldOrg, newOrg);
            if(ObjectUtil.isNotEmpty(personRecordMove)){
                for (IPersonRecordMoveService personMove : personRecordMove) {
                    personMove.personRecordMove(personInfo.getId(), personInfo.getSmpiId(), oldOrg, newOrg);
                }
            }
        }


    }
}
