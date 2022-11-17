package com.founder.rhip.ehr.common;

import com.founder.elb.entity.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-1-14
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public enum RoleType {
    YS("00"),      //虚拟医生角色（为外部报卡使用）
    ADMIN("01"),   //疾控 卫生局
    JKJKDN("0101"),	//疾控-健康档案
    JKJKJY("0102"),	//疾控-健康教育
    JKYFJZ("0103"),	//疾控-预防接种
    JKEB("0104"), 	//疾控-儿保
    JKFB("0105"),     //疾控-妇保
    JKLNR("0106"),	//疾控-老年人健康
    JKMBK("0107"),      //疾控-慢病（慢病科\慢非传科）（原来的11）
    JKJFZX("0108"),     //疾控-精神病（精防科）（原来的24）
    JKJHB("0109"),    //疾控-结核病（原来的91）
    JKZYY("0110"),	//疾控-中医药
    JKFYK("0111"),      //疾控-传染病（防疫科\传防科)（原来的10）
    JKXXC("0112"),	//疾控-血吸虫（原来14分的）
    JKSCB("0113"),	//疾控-丝虫病（原来14分的）
    JKAZB("0114"),    //疾控-艾滋病（原来的）
    JKFNB("0115"),	//疾控-妇女病（两癌）
    JKXS("0116"),     //疾控-学生
    JKET("0117"),     //疾控-儿童
    JKDFB("0118"),    //疾控-地方病（原来14分的）
    JKTJZX("0119"),//疾控体检中心-血吸虫用（原来的是25）
    JKWJSZ("0120"),//疾控-问卷设置
    JKWJ("0122"),//卫监
    JKZH("0121"),//疾控-综合管理和绩效考核
    JKXG("0124"),//疾控-新冠
    JKZYB("0123"),//疾控-职业病

    ZX_GLY("02"),	//中心-管理员
    ZXJCSZ("0200"),	//中心-基础设置
    ZXJKDN("0201"),	//中心-健康档案
    ZXJKJY("0202"),	//中心-健康教育
    ZXYFJZ("0203"),	//中心-预防接种
    ZXEB("0204"), 	//中心-儿保
    ZXFB("0205"),	//中心-妇保
    ZXLNR("0206"),	//中心-老年人健康
    ZXMB("0207"),    //中心-慢病
    ZXJFYS("0208"),//精防医生（中心角色）（原来的36）
    ZXJHB("0209"),	//中心-结核病
    ZXZYY("0210"),	//中心-中医药
    ZXCRB("0211"),	//中心-传染病
    ZXXXC("0212"),	//中心-血吸虫（承担一部分03的工作,体现在血吸虫）
    ZXSCB("0213"),	//中心-丝虫病
    ZXAZB("0214"),//中心-艾滋病（原来的61）
    ZXFNB("0215"),	//中心-妇女病（两癌）
    ZXXS("0216"),    //中心-学生
    ZXET("0217"),    //中心-儿童
    ZXDFB("0218"),   //中心-地方病
    ZXTJZX("0219"),//乡镇卫生院体检中心（原来的26）
    ZXZH("0221"),//中心-综合管理和绩效考核
    ZXWJ("0222"),//中心-卫监
    ZXXG("0224"),    //中心-新冠
    ZXHIS("0299"),//中心-HIS
    ZXZYB("0223"),//中心-职业病

    YY_GLY("03"),	//医院-管理员
    YYJCSZ("0300"),	//医院-基础设置
    YYFJZ("0303"),	//医院-预防接种
    YYLNR("0306"),	//医院-老年人健康
    YYMB("0307"),   //医院-慢病
    YYJHB("0309"),	//医院-结核病
    YYZYY("0310"),//医院-中医药
    YYCRB("0311"),	//医院-传染病
    YYAZB("0314"),//医院-艾滋病
    DDCRBYY("0320"),//定点传染病医院（原来的21）
    YYZH("0321"),//医院-综合管理和绩效考核
    YYHIS("0399"),//医院-HIS
    YYXG("0324"),    //医院-新冠
    YYZYB("0323"),//医院-职业病

    Z_GLY("04"),	//站-管理员
    ZJCSZ("0400"),	//站-基础设置
    ZJKDN("0401"),	//站-健康档案
    ZJKJY("0402"),	//站-健康教育
    ZYFJZ("0403"),	//站-预防接种
    ZEB("0404"), 	//站-儿保
    ZFB("0405"),	    //站-妇保
    ZLNR("0406"),	//站-老年人健康
    ZMB("0407"),	    //站-慢病
    ZJSB("0408"),	//站-精神病
    ZJHB("0409"),	//站-结核病
    ZZYY("0410"),	//站-中医药
    ZCRB("0411"),	//站-传染病
    ZXXC("0412"),	//站-血吸虫
    ZSCB("0413"),	//站-丝虫病
    ZXB("0414"), 	//站-性病
    ZFNB("0415"),	//站-妇女病（两癌）
    ZXS("0416"),	    //站-学生
    ZET("0417"),	    //站-儿童
    ZDFB("0418"),     //站-地方病
    ZZH("0421"),//站-综合管理和绩效考核;
    ZWJ("0422"),//站-卫监
    ZXG("0424"),    //站-新冠
    ZHIS("0499"),//站-HIS
    QWGZX("05");     //区卫管中心

    private String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
    /** 
    * @Title: getZXRols 
    * @Description: 获取中心 
    * @param @param roleList
    * @param @return
    * @return List<Role>
    * @throws 
    */
    public static List<Role> getZXRols(List<Role> roleList){
    	List<RoleType> typeList = new ArrayList<RoleType>();
        typeList.add(ZX_GLY);   //中心-管理员
        typeList.add(ZXJCSZ);   //中心-基础设置
        typeList.add(ZXJKDN);	//中心-健康档案
        typeList.add(ZXJKJY);	//中心-健康教育
        typeList.add(ZXYFJZ);	//中心-预防接种
        typeList.add(ZXEB);     //中心-儿保
        typeList.add(ZXFB);     //中心-妇保
        typeList.add(ZXLNR);    //中心-老年人健康
        typeList.add(ZXMB);     //中心-慢病
        typeList.add(ZXJFYS);   //精防医生（中心角色）（原来的36）
        typeList.add(ZXJHB);	//中心-结核病
        typeList.add(ZXZYY);	//中心-中医药
        typeList.add(ZXCRB);	//中心-传染病
        typeList.add(ZXXXC);	//中心-血吸虫（承担一部分03的工作;体现在血吸虫）
        typeList.add(ZXSCB);	//中心-丝虫病typeList.add(ZXAZB("0214");//中心-艾滋病（原来的61）
        typeList.add(ZXFNB);	//中心-妇女病（两癌）
        typeList.add(ZXXS);     //中心-学生
        typeList.add(ZXET);     //中心-儿童
        typeList.add(ZXDFB);    //中心-地方病
        typeList.add(ZXTJZX);   //乡镇卫生院体检中心（原来的26）
        typeList.add(ZXWJ);     //中心-卫监
        typeList.add(ZXZH);     //中心-综合管理和绩效考核
        typeList.add(ZXHIS);    //中心-HIS
        typeList.add(ZXXG);    //中心-新冠


        typeList.add(ZXXG);     //中心-新冠
        List<Role> roles = new ArrayList<>();
    	
		for(Role role:roleList){
			for(RoleType type:typeList){
				if(type.getValue().equals(role.getRoleCode())){
					roles.add(role);
				}
			}
		}
    	return roles;
    }
    
    /** 
    * @Title: checkZxRole 
    * @Description: 判断是不是中心的角色
    * @param @param role
    * @param @return
    * @return boolean
    * @throws 
    */
    public static boolean checkZxRole(Role role){
    	List<RoleType> typeList = new ArrayList<RoleType>();
        typeList.add(ZX_GLY);   //中心-管理员
        typeList.add(ZXJCSZ);   //中心-基础设置
        typeList.add(ZXJKDN);	//中心-健康档案
        typeList.add(ZXJKJY);	//中心-健康教育
        typeList.add(ZXYFJZ);	//中心-预防接种
        typeList.add(ZXEB); 	//中心-儿保
        typeList.add(ZXFB);     //中心-妇保
        typeList.add(ZXLNR);	//中心-老年人健康
        typeList.add(ZXMB);     //中心-慢病
        typeList.add(ZXJFYS);   //精防医生（中心角色）（原来的36）
        typeList.add(ZXJHB);	//中心-结核病
        typeList.add(ZXZYY);	//中心-中医药
        typeList.add(ZXCRB);	//中心-传染病
        typeList.add(ZXXXC);	//中心-血吸虫（承担一部分03的工作;体现在血吸虫）
        typeList.add(ZXSCB);	//中心-丝虫病
        typeList.add(ZXAZB);    //中心-艾滋病（原来的61）
        typeList.add(ZXFNB);	//中心-妇女病（两癌）
        typeList.add(ZXXS);     //中心-学生
        typeList.add(ZXET);     //中心-儿童
        typeList.add(ZXDFB);    //中心-地方病
        typeList.add(ZXTJZX);   //乡镇卫生院体检中心（原来的26）
        typeList.add(ZXZH);     //中心-综合管理和绩效考核
        typeList.add(ZXWJ);     //中心-卫监
        typeList.add(ZXHIS);    //中心-HIS
        typeList.add(ZXXG);     //中心-新冠
        typeList.add(ZXZYB); //中心-职业病

        for(RoleType type:typeList){
    		if(role.getRoleCode().equals(type.getValue())){
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * @Title: checkQwgzxRole
     * @Description: 判断是不是区卫管中心的角色
     * @param @param role
     * @return boolean
     * @throws
     */
    public static boolean checkQwgzxRole(Role role){
        List<RoleType> typeList = new ArrayList<RoleType>();
        typeList.add(QWGZX);
        for(RoleType type:typeList){
            if(role.getRoleCode().equals(type.getValue())){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是不是市级医院的角色
     * @param role
     * @return
     */
    public static boolean checkSjyyRole(Role role){
        List<RoleType> typeList = new ArrayList<RoleType>();
        typeList.add(YY_GLY);	//医院-管理员
        typeList.add(YYJCSZ);	//医院-基础设置
        typeList.add(YYFJZ);	//医院-预防接种
        typeList.add(YYLNR);    //医院-老年人健康
        typeList.add(YYMB);     //医院-慢病
        typeList.add(YYJHB);	//医院-结核病
        typeList.add(YYZYY);    //医院-中医药
        typeList.add(YYCRB);	//医院-传染病
        typeList.add(YYAZB);    //医院-艾滋病
        typeList.add(DDCRBYY);  //定点传染病医院（原来的21）
        typeList.add(YYZH);     //医院-综合管理和绩效考核
        typeList.add(YYHIS);    //医院-HIS
        typeList.add(YYXG);    //医院-新冠
        typeList.add(YYZYB);    //医院-职业病

        for(RoleType type:typeList){
            if(role.getRoleCode().equals(type.getValue())){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是不是卫监的角色
     * @param role
     * @return
     */
    public static boolean checkWJRole(Role role){
        List<RoleType> typeList = new ArrayList<RoleType>();
        typeList.add(JKWJ);	//疾控-卫监
        for(RoleType type:typeList){
            if(role.getRoleCode().equals(type.getValue())){
                return true;
            }
        }
        return false;
    }

    /** 
    * @Title: checkZRole 
    * @Description: 判断是不是站的角色
    * @param @param role
    * @param @return
    * @return boolean
    * @throws 
    */
    public static boolean checkZRole(Role role){
        List<RoleType> typeList = new ArrayList<RoleType>();
        typeList.add(Z_GLY);	//站-管理员
        typeList.add(ZJCSZ);	//站-基础设置
        typeList.add(ZJKDN);	//站-健康档案
        typeList.add(ZJKJY);	//站-健康教育
        typeList.add(ZYFJZ);	//站-预防接种
        typeList.add(ZEB);  //站-儿保
        typeList.add(ZFB);  //站-妇保
        typeList.add(ZLNR); //站-老年人健康
        typeList.add(ZMB);  //站-慢病
        typeList.add(ZJSB);	//站-精神病
        typeList.add(ZJHB);	//站-结核病
        typeList.add(ZZYY);	//站-中医药
        typeList.add(ZCRB);	//站-传染病
        typeList.add(ZXXC);	//站-血吸虫
        typeList.add(ZSCB);	//站-丝虫病
        typeList.add(ZXB); 	//站-性病
        typeList.add(ZFNB);	//站-妇女病（两癌）
        typeList.add(ZXS);  //站-学生
        typeList.add(ZET);  //站-儿童
        typeList.add(ZDFB); //站-地方病
        typeList.add(ZZH);  //站-综合管理和绩效考核;
        typeList.add(ZWJ);  //站-卫监
        typeList.add(ZXG);  //站-新冠
        typeList.add(ZHIS); //站-HIS;
        for(RoleType type:typeList){
            if(role.getRoleCode().equals(type.getValue())){
                return true;
            }
        }
        return false;
    }
}
