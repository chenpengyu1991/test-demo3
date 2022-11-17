package com.founder.rhip.ehr.controller.external;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuk
 * 
 */
public class IcdTypeMapping {

	private final static Map<String, IcdType> cache = new HashMap<String, IcdType>();

	public final static String CD_CATEGORY = "1";
	public final static String ID_CATEGORY = "2";
	public final static String FD_CATEGORY = "3";

	public IcdTypeMapping() {
		initCd();
		//initIdm();
		initFd();
	}

	private void initFd() {
		IcdType di1 = new IcdType(FD_CATEGORY, "1", "1");
		cache.put("K29", di1);
	}

	private void initCd() {
		IcdType hbp1 = new IcdType(CD_CATEGORY, EHRConstants.DM_HBP_TYPE, "1");
		cache.put("I10", hbp1);

		IcdType hbp2 = new IcdType(CD_CATEGORY, EHRConstants.DM_HBP_TYPE, "1");
		cache.put("I11", hbp2);

		IcdType hbp3 = new IcdType(CD_CATEGORY, EHRConstants.DM_HBP_TYPE, "1");
		cache.put("I12", hbp3);

		IcdType hbp4 = new IcdType(CD_CATEGORY, EHRConstants.DM_HBP_TYPE, "1");
		cache.put("I13", hbp4);
		
		IcdType di1 = new IcdType(CD_CATEGORY, EHRConstants.DM_DI_TYPE, "1");
		cache.put("E10", di1);

		IcdType di2 = new IcdType(CD_CATEGORY, EHRConstants.DM_DI_TYPE, "2");
		cache.put("E11", di2);
		cache.put("E14", di2);

		IcdType di3 = new IcdType(CD_CATEGORY, EHRConstants.DM_DI_TYPE, "3");
		cache.put("O24", di3);// 妊娠期糖尿病

		IcdType di4 = new IcdType(CD_CATEGORY, EHRConstants.DM_DI_TYPE, "4");
		cache.put("E13", di4);
		
		
		IcdType di5 = new IcdType(CD_CATEGORY, EHRConstants.DM_DI_TYPE, "");
		cache.put("E12", di5);

		// 冠心病
		// 急性心梗 I21.900 DMD00008 1
		// 心绞痛 I20.900 DMD00008 2
		// 冠心病猝死 I25.900 / DMD00008 3
		// 其他 I25.902 DMD00008 4 其它
		IcdType coronary2 = new IcdType(CD_CATEGORY, EHRConstants.DM_CORONARY_TYPE, "2");
		cache.put("I20", coronary2);

		IcdType coronary1 = new IcdType(CD_CATEGORY, EHRConstants.DM_CORONARY_TYPE, "1");
		cache.put("I21", coronary1);

		IcdType coronary4 = new IcdType(CD_CATEGORY, EHRConstants.DM_CORONARY_TYPE, "4");
		cache.put("I24", coronary4);

		IcdType coronary6 = new IcdType(CD_CATEGORY, EHRConstants.DM_CORONARY_TYPE, "3");
		cache.put("I25.900", coronary6);

		IcdType coronary7 = new IcdType(CD_CATEGORY, EHRConstants.DM_CORONARY_TYPE, "4");
		cache.put("I25.902", coronary7);

		IcdType coronary5 = new IcdType(CD_CATEGORY, EHRConstants.DM_CORONARY_TYPE, "");
		cache.put("I22", coronary5);
		cache.put("I23", coronary5);
		cache.put("I25", coronary5);
	

		// 脑出血 I61.900 DMD00 09 1
		// 脑梗塞 I63.900 DMD00009 2
		// 蛛网膜下腔出血 I60.900 DMD00009 3
		// 未分类 I64.x00 DMD00009 4
		IcdType stroke3 = new IcdType(CD_CATEGORY, EHRConstants.DM_STROKE_TYPE, "3");
		cache.put("I60", stroke3);

		IcdType stroke1 = new IcdType(CD_CATEGORY, EHRConstants.DM_STROKE_TYPE, "1");
		cache.put("I61", stroke1);
		cache.put("I62", stroke1);

		IcdType stroke2 = new IcdType(CD_CATEGORY, EHRConstants.DM_STROKE_TYPE, "2");
		cache.put("I63", stroke2);

		IcdType stroke4 = new IcdType(CD_CATEGORY, EHRConstants.DM_STROKE_TYPE, "4");
		cache.put("I67", stroke4);
		
		IcdType stroke5 = new IcdType(CD_CATEGORY, EHRConstants.DM_STROKE_TYPE, "");
		cache.put("I64", stroke5);
		cache.put("I65", stroke5);
		cache.put("I66", stroke5);
		cache.put("I68", stroke5);
		

		IcdType tumor = new IcdType(CD_CATEGORY, EHRConstants.DM_TUMOR_TYPE);

		for (int i = 0; i < 10; i++) {
			cache.put("C0" + i, tumor);
		}

		for (int i = 10; i < 98; i++) {
			cache.put("C" + i, tumor);
		}
		cache.put("D32", tumor);
		cache.put("D33", tumor);
	}

	private void initIdm() {
		IcdType a;
		a = new IcdType("A20", ID_CATEGORY, EHRConstants.IDM_A, "101");
		cache.put("A20", a);
		a = new IcdType("A00", ID_CATEGORY, EHRConstants.IDM_A, "102");
		cache.put("A00", a);

		IcdType b;
		b = new IcdType("B33.803", ID_CATEGORY, EHRConstants.IDM_B, "201");
		cache.put("B33.803", b);
        //U04.9 sars
        b = new IcdType("U04.9", ID_CATEGORY, EHRConstants.IDM_B, "201");
        cache.put("U04.9", b);

		b = new IcdType("B24", ID_CATEGORY, EHRConstants.IDM_B, "202");
		cache.put("B24", b);
		b = new IcdType("A80", ID_CATEGORY, EHRConstants.IDM_B, "204");
		cache.put("A80", b);
		b = new IcdType("J09", ID_CATEGORY, EHRConstants.IDM_B, "205");
		cache.put("J09", b);
		b = new IcdType("J10.0", ID_CATEGORY, EHRConstants.IDM_B, "206");
		cache.put("J10.0", b);
		b = new IcdType("B05", ID_CATEGORY, EHRConstants.IDM_B, "207");
		cache.put("B05", b);
		b = new IcdType("A98.502+", ID_CATEGORY, EHRConstants.IDM_B, "208");
		cache.put("A98.502+", b);
		b = new IcdType("A82", ID_CATEGORY, EHRConstants.IDM_B, "209");
		cache.put("A82", b);
		b = new IcdType("A83.001", ID_CATEGORY, EHRConstants.IDM_B, "210");
		cache.put("A83.001", b);
		b = new IcdType("A90", ID_CATEGORY, EHRConstants.IDM_B, "211");
		cache.put("A90", b);
		b = new IcdType("A22.000", ID_CATEGORY, EHRConstants.IDM_B, "2122");
		cache.put("A22.000", b);
		b = new IcdType("A22.100", ID_CATEGORY, EHRConstants.IDM_B, "2121");
		cache.put("A22.100", b);
		b = new IcdType("A22", ID_CATEGORY, EHRConstants.IDM_B, "2123");
		cache.put("A22", b);
		b = new IcdType("A15", ID_CATEGORY, EHRConstants.IDM_B, "2144");
		cache.put("A15", b);
		b = new IcdType("A16", ID_CATEGORY, EHRConstants.IDM_B, "2144");
		cache.put("A16", b);
		b = new IcdType("A19", ID_CATEGORY, EHRConstants.IDM_B, "2144");
		cache.put("A19", b);
		b = new IcdType("A01.0", ID_CATEGORY, EHRConstants.IDM_B, "2151");
		cache.put("A01.0", b);
		b = new IcdType("A01.1", ID_CATEGORY, EHRConstants.IDM_B, "2152");
		cache.put("A01.1", b);
		b = new IcdType("A01.2", ID_CATEGORY, EHRConstants.IDM_B, "2152");
		cache.put("A01.2", b);
		b = new IcdType("A01.3", ID_CATEGORY, EHRConstants.IDM_B, "2152");
		cache.put("A01.3", b);
		b = new IcdType("A01.4", ID_CATEGORY, EHRConstants.IDM_B, "2152");
		cache.put("A01.4", b);
        b = new IcdType("A01", ID_CATEGORY, EHRConstants.IDM_B, "2151");
        cache.put("A01", b);
		b = new IcdType("A39", ID_CATEGORY, EHRConstants.IDM_B, "216");
		cache.put("A39", b);
		b = new IcdType("A37", ID_CATEGORY, EHRConstants.IDM_B, "217");
		cache.put("A37", b);
		b = new IcdType("A36", ID_CATEGORY, EHRConstants.IDM_B, "218");
		cache.put("A36", b);
		b = new IcdType("A33", ID_CATEGORY, EHRConstants.IDM_B, "219");
		cache.put("A33", b);
		b = new IcdType("A38", ID_CATEGORY, EHRConstants.IDM_B, "220");
		cache.put("A38", b);
		b = new IcdType("A23", ID_CATEGORY, EHRConstants.IDM_B, "221");
		cache.put("A23", b);
		b = new IcdType("A54", ID_CATEGORY, EHRConstants.IDM_B, "222");
		cache.put("A54", b);
		b = new IcdType("B65", ID_CATEGORY, EHRConstants.IDM_B, "225");
		cache.put("B65", b);
		b = new IcdType("A27", ID_CATEGORY, EHRConstants.IDM_B, "224");
		cache.put("A27", b);
		b = new IcdType("A50", ID_CATEGORY, EHRConstants.IDM_B, "2231");
		cache.put("A50", b);
		b = new IcdType("A51", ID_CATEGORY, EHRConstants.IDM_B, "2231");
		cache.put("A51", b);
		b = new IcdType("A52", ID_CATEGORY, EHRConstants.IDM_B, "2231");
		cache.put("A52", b);
		b = new IcdType("A53", ID_CATEGORY, EHRConstants.IDM_B, "2231");
		cache.put("A53", b);
		b = new IcdType("B50", ID_CATEGORY, EHRConstants.IDM_B, "2263");
		cache.put("B50", b);
		b = new IcdType("B51", ID_CATEGORY, EHRConstants.IDM_B, "2261");
		cache.put("B51", b);
		b = new IcdType("B52", ID_CATEGORY, EHRConstants.IDM_B, "2262");
		cache.put("B52", b);
		b = new IcdType("B53", ID_CATEGORY, EHRConstants.IDM_B, "2263");
		cache.put("B53", b);
		b = new IcdType("B54", ID_CATEGORY, EHRConstants.IDM_B, "2263");
		cache.put("B54", b);
		b = new IcdType("B15", ID_CATEGORY, EHRConstants.IDM_B, "2031");
		cache.put("B15", b);
		b = new IcdType("B16", ID_CATEGORY, EHRConstants.IDM_B, "2032");
		cache.put("B16", b);
		b = new IcdType("B17", ID_CATEGORY, EHRConstants.IDM_B, "2035");
		cache.put("B17", b);
		b = new IcdType("B18", ID_CATEGORY, EHRConstants.IDM_B, "2035");
		cache.put("B18", b);
		b = new IcdType("B19", ID_CATEGORY, EHRConstants.IDM_B, "2035");
		cache.put("B19", b);
		b = new IcdType("A03", ID_CATEGORY, EHRConstants.IDM_B, "2131");
		cache.put("A03", b);
		b = new IcdType("A06.0", ID_CATEGORY, EHRConstants.IDM_B, "2132");
		cache.put("A06.0", b);

		IcdType c;
		c = new IcdType("J10", ID_CATEGORY, EHRConstants.IDM_C, "301");
		cache.put("J10", c);
		c = new IcdType("J11", ID_CATEGORY, EHRConstants.IDM_C, "301");
		cache.put("J11", c);
		c = new IcdType("B26", ID_CATEGORY, EHRConstants.IDM_C, "302");
		cache.put("B26", c);
		c = new IcdType("B06", ID_CATEGORY, EHRConstants.IDM_C, "303");
		cache.put("B06", c);
		c = new IcdType("B30", ID_CATEGORY, EHRConstants.IDM_C, "304");
		cache.put("B30", c);
		c = new IcdType("A30", ID_CATEGORY, EHRConstants.IDM_C, "305");
		cache.put("A30", c);
		c = new IcdType("B55", ID_CATEGORY, EHRConstants.IDM_C, "307");
		cache.put("B55", c);
		c = new IcdType("B67", ID_CATEGORY, EHRConstants.IDM_C, "308");
		cache.put("B67", c);
		c = new IcdType("B74", ID_CATEGORY, EHRConstants.IDM_C, "309");
		cache.put("B74", c);
		c = new IcdType("B08.401", ID_CATEGORY, EHRConstants.IDM_C, "311");
		cache.put("B08.401", c);
		c = new IcdType("A04", ID_CATEGORY, EHRConstants.IDM_C, "310");
		cache.put("A04", c);
		c = new IcdType("A75.001", ID_CATEGORY, EHRConstants.IDM_C, "306");
		cache.put("A75.001", c);
		c = new IcdType("A75.20", ID_CATEGORY, EHRConstants.IDM_C, "306");
		cache.put("A75.20", c);
		c = new IcdType("A75.90", ID_CATEGORY, EHRConstants.IDM_C, "306");
		cache.put("A75.90", c);
	}

	public IcdType getType(String icd) {
		if (ObjectUtil.isNullOrEmpty(icd)) {
			return null;
		}
		int length = icd.length();
		IcdType type = null;
		for (int i = length; i >= 3; i--) {
			if (i == 4) {
				continue;// .的情况去掉
			}
			type = cache.get(icd.substring(0, i));
			if (null != type) {
				break;
			}
		}
		return type;
	}

	public static void main(String[] adf) {
		String icd = "E10.1346";
		int length = icd.length();
		for (int i = length; i >= 3; i--) {
			if (i == 4) {
				continue;
			}
			String vString = icd.substring(0, i);
			System.out.println(vString);
		}
	}
}
