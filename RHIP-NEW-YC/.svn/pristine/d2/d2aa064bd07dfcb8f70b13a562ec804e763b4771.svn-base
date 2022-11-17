package com.founder.rhip.cic;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;

@Component("cicCardImportProcessor")
public class CicCardImportProcessor implements ApplicationContextAware{

	@Resource(name = "cicCardService")
	private ICicCardService cicCardService;
	
	private static Logger log = Logger.getLogger(CicCardImportProcessor.class);
	
	private ApplicationContext context;
	private static Validator validator;
	private FileWriter fwMessage;
	private FileWriter fwCard;
	private Integer totalErrorNumber = 0;
	private Integer errorNumber = 0;
	private Integer currentNumber = 0;
	private static StringBuilder infoMessage;
	private static StringBuilder cardMessage;
	
	private static CicCardImportProcessor dataProcessor;
	public static void main(String[] args) {
		init();
		try {
			runConsole();
		} catch (Exception e) {
			System.out.println("命令错误！" + e.getMessage());
		}

	}
	private static void runConsole() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			showMenu();
			while (true) {
				String cmd = in.readLine().trim();
				try {
					int code = Integer.parseInt(cmd);
					if (0 == code)
						break;
				} catch (Exception e) {}
				runcmd(cmd);
			}
			System.exit(0);
		} finally {
			in.close();
		}
	}
	private static void showMenu() {
		System.out.println("=============please select===============");
		System.out.println(" 1 导入数据");
		System.out.println("====================================");
		System.out.println(" 0 退出");
		System.out.println("====================================");
		System.out.println("输入需要执行操作的序号:");
	}
	
	private static int _code = -1;
	private static void runcmd(String code) {
		if (1 == _code ) {
				dataProcessor.execute(_code);
				_code = -1;
				showMenu();
		}else {
			dataProcessor.execute(Integer.parseInt(code));
			_code = -1;
			showMenu();
		}
	}	
	
	public synchronized void execute(int code) {
		if (code == 1) {
			ImportProcessor processor = new ImportProcessor();
			processor.run();
		}
	}
	
	private class ImportProcessor implements Runnable {
		@Override
		public void run() {
			try {
				currentNumber = 0;
				totalErrorNumber = 0;
				CicCitizenCard card = null;
				CicResult cicCardResult = null;
				String encoding="GBK";
		        File file=new File("d://RegHealth20140702.txt");
		        if(file.isFile() && file.exists()){ //判断文件是否存在
		        	InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
		            BufferedReader bufferedReader = new BufferedReader(read);
		            String lineTxt = null;
		            fwMessage = new FileWriter("d://message.txt");
		            fwCard = new FileWriter("d://card.txt");
		            log.info("开始导入市民卡数据...");
					Long start = System.currentTimeMillis();
		            while((lineTxt = bufferedReader.readLine()) != null){
		            	currentNumber ++;
		            	if(currentNumber == 1){//跳过第一行
		            		continue;
		            	}
		            	card = new CicCitizenCard();
		            	String message = getCitizenCard(lineTxt,card);
		            	if(StringUtil.isEmpty(message)){
		            		cicCardResult = new CicResult();
		            		dealWithCreate(card,cicCardResult);
		            		if(StringUtil.isNotEmpty(cicCardResult.getMessage())){
		            			infoMessage.append(currentNumber+ "：" + cicCardResult.getMessage() + "\r\n");
			            		cardMessage.append(lineTxt + "\r\n");
			            		errorNumber++;	 
			            		totalErrorNumber++;
			            		System.out.println("第" + (currentNumber-1) + "条，导入失败:" + cicCardResult.getMessage());
		            		}else{
		            			System.out.println("第" + (currentNumber-1) + "条，导入成功:");
		            		}
		            	}else{
		            		infoMessage.append((currentNumber-1)+ "：" + message + "\r\n");
		            		cardMessage.append(lineTxt + "\r\n");
		            		errorNumber++;
		            		totalErrorNumber++;
		            		System.out.println("第" + (currentNumber-1) + "条，导入失败:" + message);
		            	}
		            	if(errorNumber>=2000){
		            		fwMessage.write(infoMessage.toString());
		            		fwCard.write(cardMessage.toString());
		            		infoMessage = new StringBuilder();
		            		cardMessage = new StringBuilder();
		            		errorNumber = 0;
		            	}
		            }
		            Long end = System.currentTimeMillis();
		            infoMessage.append("导入市民卡数据完成,共花费" + formatTime(end - start));
		            fwMessage.write(infoMessage.toString());
	        		fwCard.write(cardMessage.toString());
		            read.close();
		        }else{
		        	System.out.println("找不到指定的文件");
		        }
			} catch (Exception e) {
			    System.out.println("读取文件内容出错");
			    e.printStackTrace();
			}	
			finally {
	            try {
	            	infoMessage.append("共" + (currentNumber-1) + "条数据");
	            	infoMessage.append("共失败：" + totalErrorNumber);
	            	infoMessage.append("共成功：" + (currentNumber-1-totalErrorNumber));
	            	fwMessage.write(infoMessage.toString());
	            	fwMessage.close();
	            	fwCard.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
			System.out.println("共" + (currentNumber-1) + "条数据");
			System.out.println("共失败：" + totalErrorNumber);
			System.out.println("共成功：" + (currentNumber-1-totalErrorNumber));
		}
	};
	private static String getCitizenCard(String lineTxt,CicCitizenCard card){
		String result = "";
		if(StringUtil.isNotEmpty(lineTxt)){
			String [] array = lineTxt.split("\\|"); 
			if(ObjectUtil.isNotEmpty(array)){
				if(array.length==11){
					card.setPaperType(array[1]);
					card.setPaperNo(array[2]);
					card.setCitizenCardNo(array[3]);
					card.setName(array[4]);
					card.setReleaseDate(DateUtil.parseSimpleDate(array[5], "yyyyMMdd"));
					card.setCorpName(array[6]);
					card.setPhone(array[7]);
					card.setPrAddr(array[8]);
					card.setBirthday(DateUtil.parseSimpleDate(array[9],"yyyyMMdd"));
					card.setGender(array[10]);
					card.setCardStatus(CicCardStatus.NORMAL.getValue());
				}else{
					result = "字段数不正确/r/n";
				}
			}
		}
		return result;
	}	
	public static void init() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:config/applicationContext.xml");
		dataProcessor = (CicCardImportProcessor) ctx.getBean("cicCardImportProcessor");
		infoMessage = new StringBuilder();
		cardMessage = new StringBuilder();
	}
	/**
	 * 发卡
	 *
	 * @param cicCitizenCard
	 * @param cicCardResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithCreate(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		String message = cicCardService.importCitizenCard(cicCitizenCard);
		if(StringUtil.isNotEmpty(message)){
			cicCardResult.setMessage(message);
		}
//		/**
//		 * 参数验证
//		 */
//		boolean checkFlag = checkData(cicCitizenCard,cicCardResult,new String[]{"paperType","paperNo","citizenCardNo"
//				,"name","releaseDate","corpName"
//				,"phone","prAddr","birthday","gender"});
//		if(checkFlag){
//			message = cicCardService.importCitizenCard(cicCitizenCard);
//			if(StringUtil.isNotEmpty(message)){
//				cicCardResult.setMessage(message);
//			}
//		}
	}		
    
	/**
	 * 检查身份证的格式
	 * 
	 * @param idcard
	 * @return
	 */
	protected boolean checkIdacrd(String idcard,CicResult cicCardResult,String message) {
		boolean result = true;
		try {
			result = IDCardUtil.validateCard(idcard);
			if(!result){
				cicCardResult.setMessage(message + "格式非法。");
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	private boolean checkData(CicCitizenCard cicCitizenCard,CicResult cicCardResult,String...properties) {
		boolean result = true;
		String message = validateModel(cicCitizenCard,properties);
		if(StringUtil.isNotEmpty(message)){
			cicCardResult.setMessage(message);
			result = false;
		}
		if(CicConstants.PAPERTYPE.equals(cicCitizenCard.getPaperType())){//如果是身份证
			result &= checkIdacrd(cicCitizenCard.getPaperNo(),cicCardResult,"身份证号码");
		}
		return result;
	}
	
	private String formatTime(long millis) {
		String unit = "秒";
		double sec = (double)millis / 1000;
		if (sec >= 60) {
			sec = sec / 60;
			unit = "分钟";
		}
		if (sec >= 60) {
			sec = sec / 60;
			unit = "小时";
		}
		return String.format("%.2f", sec) + unit;
	}
	
	/**
	 * 验证模型
	 *
	 * @param data
	 * @return
	 * @author Ye jianfei
	 */
	protected String  validateModel(Object data,String... properties){
		StringBuffer buffer = new StringBuffer();//用于存储验证后的错误信息
		Set<ConstraintViolation<Object>> constraintViolations;
		for(String property:properties){
			constraintViolations = validator.validateProperty(data,property);
			Iterator<ConstraintViolation<Object>> iter = constraintViolations.iterator();  
			while (iter.hasNext()) {  
				String message = iter.next().getMessage();  
				buffer.append(message);  
				buffer.append(";");
			}			
		}
		return buffer.toString();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
