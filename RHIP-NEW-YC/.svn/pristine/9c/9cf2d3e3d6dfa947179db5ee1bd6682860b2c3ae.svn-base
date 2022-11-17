package com.founder.rhip.cic;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;
import com.founder.rhip.ehr.repository.cic.ICicCitizenCardDao;
import com.founder.rhip.ehr.repository.clinic.IReadHealthRecordDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;

/**
 * 市民卡管理
 * 
 * @version 1.0, 2014-5-7
 * @author Ye jianfei
 */
@Service("cicCardService")
public class CicCardService implements ICicCardService {

	@Resource(name = "cicCitizenCardDao")
	private ICicCitizenCardDao cicCitizenCardDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "readHealthRecordDao")
	private IReadHealthRecordDao readHealthRecordDao;
	
	@Override
	@Transactional
	public String blackCitizenCard(CicCitizenCard cicCitizenCard) {
		String result = "";
		if(ObjectUtil.isNotEmpty(cicCitizenCard)){
			String flag = cicCitizenCard.getFlag();
			if(CicConstants.FLAG_ADD.equals(flag)){//增加黑名单
				result = addBlackCitizenCard(cicCitizenCard);
			}else if(CicConstants.FLAG_DELETE.equals(flag)){//删除黑名单
				result = delBlackCitizenCard(cicCitizenCard);
			}
		}
		return result;
	}
	
	@Override
	@Transactional
	public String createCitizenCard(CicCitizenCard cicCitizenCard) {
		String result = "";
		if(ObjectUtil.isNotEmpty(cicCitizenCard)){
			String citizenCardNo = cicCitizenCard.getCitizenCardNo();
			String paperType = cicCitizenCard.getPaperType();
			String paperNo = cicCitizenCard.getPaperNo();
			//根据证件号码、虞城通号查询是否已经存在该市民卡
      		CicCitizenCard citizenCard = getCitizenCard(citizenCardNo,paperType,paperNo,CicCardStatus.NORMAL.getValue());
			if(ObjectUtil.isNotEmpty(citizenCard)){//根据证件号码虞城通号查询,市民卡记录已经存在
				result += "证件号码为：" + paperNo + "虞城通号为:" + citizenCardNo + "的市民卡已经存在！";
			}
			citizenCard = getCitizenCard(citizenCardNo,null,null,CicCardStatus.NORMAL.getValue());
			if(ObjectUtil.isNotEmpty(citizenCard)){//根据虞城通号查询,市民卡记录已经存在
				result += "虞城通号为:" + citizenCardNo + "的市民卡已经存在！";
			}
			if(StringUtil.isNullOrEmpty(result)){
				//根据证件号码查询，如果记录存在，该记录修改为退卡,并新增一条发卡记录
				citizenCard = getCitizenCard(null,paperType,paperNo,CicCardStatus.NORMAL.getValue());
				if(ObjectUtil.isNotEmpty(citizenCard)){
					citizenCard.setCardStatus(CicCardStatus.RETURN.getValue());
					citizenCard.setUpdateDate(new Date());
					updateCitizenCard(citizenCard, new String[]{"cardStatus","updateDate"});
				}
			}

			if(StringUtil.isNullOrEmpty(result)){
				//发卡时，状态为正常
				cicCitizenCard.setCardStatus(CicCardStatus.NORMAL.getValue());
				if(CicConstants.PAPERTYPE.equals(cicCitizenCard.getPaperType())){//更新健康档案
					updatePersonInfo(cicCitizenCard.getPaperNo()
							,cicCitizenCard.getCitizenCardNo()
							,CicCardStatus.NORMAL.getValue()
							,cicCitizenCard.getReleaseDate()
							,null);
					updateOrgInfo(cicCitizenCard);
				}
				updateCitizenCard(cicCitizenCard);
			}
		}
		return result;
	}
	
	@Override
	@Transactional
	public String reissueCitizenCard(CicCitizenCard inCitizenCard) {
		/**
		 * （1）根据旧虞城通号将市民卡表中原记录中状态标记为“补卡”
		 * （2）市民卡中新增一条记录，存储新虞城通号。
		 * （3）更新健康档案中的虞城通号
		 */
		String result = "";
		if(ObjectUtil.isNotEmpty(inCitizenCard)){
			String oldCitizenCardNo = inCitizenCard.getOldCitizenCardNo();
			String paperType = inCitizenCard.getPaperType();
			String paperNo = inCitizenCard.getPaperNo();
			//补卡时，原记录的状态必须为“挂失”状态
			CicCitizenCard oldCitizenCard = getCitizenCard(oldCitizenCardNo,paperType,paperNo,CicCardStatus.LOSS.getValue());
			if(ObjectUtil.isNullOrEmpty(oldCitizenCard)){
    			result =  "虞城通号为：" + oldCitizenCardNo + "原市民卡记录不存在！";
    		}else{
    			CicCitizenCard citizenCard = getCitizenCard(inCitizenCard.getCitizenCardNo(),paperType,paperNo,CicCardStatus.NORMAL.getValue());
				if(ObjectUtil.isNotEmpty(citizenCard)){//新虞城通号的市民卡记录已经存在
					result =  "虞城通号为：" + inCitizenCard.getCitizenCardNo() + "市民卡记录已经存在！";
				}else{//新建一条市民卡记录，将原卡的状态更新为“补卡”
					oldCitizenCard.setCardStatus(CicCardStatus.REISSUE.getValue());
					oldCitizenCard.setUpdateDate(inCitizenCard.getTxtDate());
					oldCitizenCard.setId(null);
					updateCitizenCard(oldCitizenCard, new String[]{"cardStatus","updateDate"});
					oldCitizenCard.setTxtDate(inCitizenCard.getTxtDate());
					oldCitizenCard.setName(inCitizenCard.getName());
					oldCitizenCard.setCardStatus(CicCardStatus.NORMAL.getValue());
					oldCitizenCard.setCitizenCardNo(inCitizenCard.getCitizenCardNo());
					oldCitizenCard.setOldCitizenCardNo(inCitizenCard.getOldCitizenCardNo());			
					updateCitizenCard(oldCitizenCard);
					//更新健康档案
					if(CicConstants.PAPERTYPE.equals(inCitizenCard.getPaperType())){
						updatePersonInfo(inCitizenCard.getPaperNo()
								,inCitizenCard.getCitizenCardNo()
								,CicCardStatus.NORMAL.getValue()
								,inCitizenCard.getReleaseDate()
								,null);
					}
				}
			}
		}
		return result;
	}
	
	@Override
	@Transactional
	public String changeCitizenCard(CicCitizenCard inCitizenCard) {
		/**
		 * （1）根据旧虞城通号将市民卡表中原记录中状态标记为“换卡”
		 * （2）市民卡中新增一条记录，存储新虞城通号。
		 * （3）更新健康档案中的虞城通号
		 */
		String result = "";
		if(ObjectUtil.isNotEmpty(inCitizenCard)){
			String oldCitizenCardNo = inCitizenCard.getOldCitizenCardNo();
			String paperType = inCitizenCard.getPaperType();
			String paperNo = inCitizenCard.getPaperNo();
			CicCitizenCard oldCitizenCard = getCitizenCard(oldCitizenCardNo,paperType,paperNo,CicCardStatus.NORMAL.getValue());
			if(ObjectUtil.isNullOrEmpty(oldCitizenCard)){
    			result =  "虞城通号为：" + oldCitizenCardNo + "，市民卡记录不存在！";
    		}else{
				CicCitizenCard citizenCard = getCitizenCard(inCitizenCard.getCitizenCardNo(),paperType,paperNo,CicCardStatus.NORMAL.getValue());
				if(ObjectUtil.isNotEmpty(citizenCard)){//新虞城通号的市民卡记录已经存在
					result =  "虞城通号为：" + oldCitizenCardNo + "，市民卡记录已经存在！";
				}else{//新建一条市民卡记录,将原卡的状态更新为“补卡”
					oldCitizenCard.setCardStatus(CicCardStatus.CHANGE.getValue());
					oldCitizenCard.setUpdateDate(inCitizenCard.getTxtDate());
					updateCitizenCard(oldCitizenCard, new String[]{"cardStatus","updateDate"});
					oldCitizenCard.setId(null);
					oldCitizenCard.setTxtDate(inCitizenCard.getTxtDate());
					oldCitizenCard.setName(inCitizenCard.getName());
					oldCitizenCard.setCardStatus(CicCardStatus.NORMAL.getValue());
					oldCitizenCard.setCitizenCardNo(inCitizenCard.getCitizenCardNo());
					oldCitizenCard.setOldCitizenCardNo(inCitizenCard.getOldCitizenCardNo());			
					updateCitizenCard(oldCitizenCard);
					if(CicConstants.PAPERTYPE.equals(inCitizenCard.getPaperType())){//更新健康档案
						updatePersonInfo(inCitizenCard.getPaperNo()
								,inCitizenCard.getCitizenCardNo()
								,CicCardStatus.NORMAL.getValue()
								,inCitizenCard.getReleaseDate()
								,null);
					}
				}
			}
		}
		return result;
	}
	
    /**
     * 设置机构、人员相关信息
     *
     * @param cicCitizenCard
     * @author Ye jianfei
     */
    private void setCitizenCard(CicCitizenCard cicCitizenCard){
    	if(ObjectUtil.isNullOrEmpty(cicCitizenCard.getId())){
    		cicCitizenCard.setIsDelete(0);
        	if(ObjectUtil.isNotEmpty(cicCitizenCard.getTxtDate())){
        		cicCitizenCard.setCreateDate(cicCitizenCard.getTxtDate());
        	}else if(ObjectUtil.isNotEmpty(cicCitizenCard.getReleaseDate())){
        		cicCitizenCard.setCreateDate(cicCitizenCard.getReleaseDate());
        	}else{
        		cicCitizenCard.setCreateDate(new Date());
        	}
    		cicCitizenCard.setCreateOrg("");
    		cicCitizenCard.setCreateUser("");
    	}
    	if(ObjectUtil.isNotEmpty(cicCitizenCard.getTxtDate())){
    		cicCitizenCard.setUpdateDate(cicCitizenCard.getTxtDate());
    	}else if(ObjectUtil.isNotEmpty(cicCitizenCard.getReleaseDate())){
    		cicCitizenCard.setUpdateDate(cicCitizenCard.getReleaseDate());
    	}else{
    		cicCitizenCard.setUpdateDate(new Date());
    	}
    	cicCitizenCard.setUpdateOrg("");
    	cicCitizenCard.setUpdateUser("");
    }
    
    /**
     * 根据虞城通号获取市民卡信息
     *
     * @param citizenCardNo
     * @return
     * @author Ye jianfei
     */
    private CicCitizenCard getCitizenCard(String citizenCardNo,String paperType,String paperNo,String cardStatus){
    	CicCitizenCard citizenCard = null;
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(citizenCardNo)){
    		ca.add("CITIZEN_CARD_NO",citizenCardNo);
    	}
		if(ObjectUtil.isNotEmpty(cardStatus)){
			ca.add("CARD_STATUS",cardStatus);
		}
    	if(StringUtil.isNotEmpty(paperType)){//证件类型
    		ca.add("PAPER_TYPE",paperType);
        	if(StringUtil.isNotEmpty(paperNo)){//证件号码
        		ca.add("PAPER_NO",paperNo);
        	}    		
    	}
		List<CicCitizenCard> cards = cicCitizenCardDao.getList(ca,new Order("UPDATE_DATE desc,id desc"));
		if(ObjectUtil.isNotEmpty(cards)){
			citizenCard = cards.get(0);
		}

    	return citizenCard;
    }
    
    /**
     * 增加黑名单
     *
     * @param cicCitizenCard
     * @return
     * @author Ye jianfei
     */
    @Transactional
    private String addBlackCitizenCard(CicCitizenCard cicCitizenCard){
    	String result = "";
    	/**
    	 * 1、查找原有状态为正常（状态等于“00”）的市民卡记录，将其标记为黑名单
    	 * 2、如果原有记录不存在，则返回错误信息，“不存在该市民卡信息”
    	 * 3、更新健康档案
    	 */
		String citizenCardNo = cicCitizenCard.getCitizenCardNo();
		String paperType = cicCitizenCard.getPaperType();
		String paperNo = cicCitizenCard.getPaperNo();
    	CicCitizenCard citizenCard = getCitizenCard(citizenCardNo,paperType,paperNo,CicCardStatus.NORMAL.getValue());
    	if(ObjectUtil.isNullOrEmpty(citizenCard)){
    		result = "虞城通号为：" + citizenCardNo + "，市民卡信息不存在或该市民卡状态异常!";
    	}else{
    		citizenCard = getCitizenCard(citizenCardNo,paperType,paperNo,null);
    		if(!citizenCard.getCardStatus().equals(CicCardStatus.NORMAL.getValue())){
    			result = "虞城通号为：" + citizenCardNo + "，市民卡信息已经在黑名单中!";
    		}else{
	    		citizenCard.setCardStatus(cicCitizenCard.getCardStatus());
	    		citizenCard.setUpdateDate(cicCitizenCard.getTxtDate());
	    		updateCitizenCard(citizenCard, new String[]{"cardStatus","updateDate"});
	    		if(CicConstants.PAPERTYPE.equals(cicCitizenCard.getPaperType())){//更新健康档案
					updatePersonInfo(cicCitizenCard.getPaperNo()
							,null
							,cicCitizenCard.getCardStatus()
							,null
							,cicCitizenCard.getTxtDate());
				}
    		}
    	}
    	return result;
    }
    
    /**
     * 减少黑名单
     *
     * @param cicCitizenCard
     * @return
     * @author Ye jianfei
     */
    @Transactional
    private String delBlackCitizenCard(CicCitizenCard cicCitizenCard){
    	String result = "";
    	/**
    	 * 1、查找原有状态为非正常（状态不等于“00”）的市民卡记录
    	 * 2、如果原有记录不存在，则返回错误信息，“不存在该市民卡信息”
    	 * 3、将该记录复制一份，状态修改为“正常”。
    	 * 4、更新健康档案
    	 */
		String citizenCardNo = cicCitizenCard.getCitizenCardNo();
		String paperType = cicCitizenCard.getPaperType();
		String paperNo = cicCitizenCard.getPaperNo();
    	CicCitizenCard citizenCard = getCitizenCard(citizenCardNo,paperType,paperNo,null);    	
    	if(ObjectUtil.isNullOrEmpty(citizenCard)){
    		result = "虞城通号为：" + citizenCardNo + "，市民卡信息不存在!";
    	}else{
    		if(citizenCard.getCardStatus().equals(CicCardStatus.NORMAL.getValue())){
    			result = "虞城通号为：" + citizenCardNo + "，该市民卡目前状态正常!";
    		}else if(citizenCard.getCardStatus().equals(CicCardStatus.LOSS.getValue())){//解除挂失时，状态必须为挂失。新建一条市民卡记录，原记录保留
	    		citizenCard.setId(null);
	    		citizenCard.setCardStatus(CicCardStatus.NORMAL.getValue());
	    		citizenCard.setUpdateDate(cicCitizenCard.getTxtDate());
	    		citizenCard.setCreateDate(cicCitizenCard.getTxtDate());
	    		updateCitizenCard(citizenCard);
	    		if(CicConstants.PAPERTYPE.equals(cicCitizenCard.getPaperType())){//更新健康档案
					updatePersonInfo(cicCitizenCard.getPaperNo()
							,null
							,CicCardStatus.NORMAL.getValue()
							,null
							,cicCitizenCard.getTxtDate());
				}
    		}else{
    			result = "虞城通号为：" + citizenCardNo + "，该市民卡状态必须为“挂失”状态，才能解除黑名单!";
    		}
    	}
    	return result;
    }
    
    @Override
    public int getUseCount(Date startDate,Date endDate){
    	Criteria ca = new Criteria();
    	DateUtil.getCriteriaByDateRange(ca, "READ_DATE", startDate,endDate); 
    	return readHealthRecordDao.countRow(ca);
    }
    
    @Override
    public String importCitizenCard(CicCitizenCard card){
		String result = "";
		if(ObjectUtil.isNotEmpty(card)){
//			String citizenCardNo = card.getCitizenCardNo();
//			String paperType = card.getPaperType();
//			String paperNo = card.getPaperNo();
//			//根据虞城通号查询是否已经存在该市民卡
//			CicCitizenCard citizenCard = getCitizenCard(citizenCardNo,null,null,CicCardStatus.NORMAL.getValue());
//			if(ObjectUtil.isNotEmpty(citizenCard)){
//				result += "虞城通号为：" + citizenCardNo + "的市民卡已经存在！";	
//			}
//			//根据证件号码查询是否已经存在该市民卡
//			citizenCard = getCitizenCard(null,paperType,paperNo,CicCardStatus.NORMAL.getValue());
//			if(ObjectUtil.isNotEmpty(citizenCard)){
//				result += "证件号码为：" + paperNo +  "的市民卡已经存在！";	
//			}
			if(StringUtil.isNullOrEmpty(result)){
				//发卡时，状态为正常
				card.setCardStatus(CicCardStatus.NORMAL.getValue());
//				if(CicConstants.PAPERTYPE.equals(card.getPaperType())){//更新健康档案
//					updatePersonInfo(card.getPaperNo()
//							,card.getCitizenCardNo()
//							,CicCardStatus.NORMAL.getValue()
//							,card.getReleaseDate()
//							,null);
//					updateOrgInfo(card);
//				}
				updateCitizenCard(card);
			}
		}
		return result;    	
    }
    /**
     * 更新健康档案
     *
     * @param idcard
     * @param citizenCardNo
     * @param cardStatus
     * @param releaseDate
     * @param txtDate
     * @author Ye jianfei
     */
    private void updatePersonInfo(String idcard,String citizenCardNo,String cardStatus,Date releaseDate,Date txtDate){
    	Parameters parameters = new Parameters();
    	if(StringUtil.isNotEmpty(citizenCardNo)){
    		parameters.add("CITIZEN_CARD_NO", citizenCardNo);//虞城通号
    	}
    	if(StringUtil.isNotEmpty(cardStatus)){
    		parameters.add("CARD_STATUS", cardStatus);//市民卡状态
    	}			
    	if(ObjectUtil.isNotEmpty(releaseDate)){
    		parameters.add("RELEASE_DATE", releaseDate);///发卡日期
    	}			
    	if(ObjectUtil.isNotEmpty(txtDate)){
    		parameters.add("UPDATE_DATE", txtDate);///交易日期
    	}
		personInfoDao.update(parameters,new Criteria("IDCARD",idcard));
    }
    
    /**
     * 新增或更新市民卡
     *
     * @param citizenCard
     * @param properties
     * @author Ye jianfei
     */
    private void updateCitizenCard(CicCitizenCard citizenCard,String...properties){
    	if(ObjectUtil.isNotEmpty(citizenCard)){
    		setCitizenCard(citizenCard);
    		if(ObjectUtil.isNotEmpty(citizenCard.getId())){
    			cicCitizenCardDao.update(citizenCard, properties);
    		}else{
    			cicCitizenCardDao.insert(citizenCard);
    		}
    	}
    }
    
    /**
     * 根据健康档案更新建档机构相关信息
     *
     * @param citizenCard
     * @author Ye jianfei
     */
    private void updateOrgInfo(CicCitizenCard citizenCard){
    	if(ObjectUtil.isNotEmpty(citizenCard)){
    		PersonInfo person = null;
    		Criteria ca = new Criteria("idcard", citizenCard.getPaperNo());
    		List<PersonInfo> list = personInfoDao.getList(ca,new String[]{"inputGbcode","inputCenterOrganCode","inputOrganCode","patownShip","householdType"});
    		if (ObjectUtil.isNotEmpty(list)){
    			person = list.get(0);
    			citizenCard.setInputGbcode(person.getInputGbcode());
    			citizenCard.setInputCenterOrganCode(person.getInputCenterOrganCode());
    			citizenCard.setInputOrganCode(person.getInputOrganCode());
    			citizenCard.setPatownShip(person.getPatownShip());
    			citizenCard.setHouseholdType(person.getHouseholdType());
    		}
    	}
    }
}
