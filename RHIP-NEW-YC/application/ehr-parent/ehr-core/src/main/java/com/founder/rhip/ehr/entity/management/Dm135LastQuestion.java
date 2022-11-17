package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by jingqiu on 17-4-18.
 */
@Entity
@Table(name = "DM_135LAST_QUESTION")
public class Dm135LastQuestion {

    @Id
    @Column(name ="ID",columnDefinition ="VARCHAR2|主键",length = 32, nullable = true)
    private String id;

    @Column(name ="SURVEY_TARGET",columnDefinition ="VARCHAR2|调查对象",length = 20, nullable = true)
    private String surveyTarget;

    @Column(name ="DT",columnDefinition ="DATE|日期",length = 7, nullable = true)
    private Date dt;

    @Column(name ="AREA_CODE",columnDefinition ="VARCHAR2|地区编码",length = 20, nullable = true)
    private String areaCode;

    @Column(name ="PERSON_NAME",columnDefinition ="VARCHAR2|姓名",length = 20, nullable = true)
    private String personName;

    @Column(name ="PHYSICAL_EXAM_NO",columnDefinition ="VARCHAR2|体检号",length = 20, nullable = true)
    private String physicalExamNo;

    @Column(name ="CELL_PHONE",columnDefinition ="VARCHAR2|手机",length = 20, nullable = true)
    private String cellPhone;
    @Column(name ="CONTACT_CELL_PHONE",columnDefinition ="VARCHAR2|联系人手机",length = 20, nullable = true)
    private String contactCellPhone;
    @Column(name ="SURVEYER",columnDefinition ="VARCHAR2|调查者",length = 20, nullable = true)
    private String surveyer;
    @Column(name ="SURVEY_DT",columnDefinition ="DATE|调查日期",length = 7, nullable = true)
    private Date surveyDt;
    @Column(name ="BEGIN_HOUR",columnDefinition ="VARCHAR2|调查开始时间小时",length = 6, nullable = true)
    private String beginHour;
    @Column(name ="BEGIN_MIN",columnDefinition ="VARCHAR2|调查开始时间分钟",length = 6, nullable = true)
    private String beginMin;
    @Column(name ="A1",columnDefinition ="VARCHAR2|A1. 性别：1=男性 2=女性",length = 20, nullable = true)
    private String a1;
    @Column(name ="A2",columnDefinition ="VARCHAR2|A2. 民族：1＝汉 2＝回 8＝其他(注明)",length = 20, nullable = true)
    private String a2;
    @Column(name ="A2_A",columnDefinition ="VARCHAR2|A2.1.民族其他注明",length = 20, nullable = true)
    private String a2A;
    @Column(name ="A3",columnDefinition ="VARCHAR2|A3.婚姻状况：1＝结婚/同居 2＝丧偶 3＝离婚/分居 4＝未婚",length = 20, nullable = true)
    private String a3;
    @Column(name ="A4",columnDefinition ="VARCHAR2|A4.职业1＝企业工人（包括农民工）2＝ 国家机关及事业单位（管理人员/干部） 3＝专业技术人员（医护人员、教师等） 4＝服务人员/三资企业及民营企业职员 5＝ 三资企业及民营企业主及个体经营者 6＝ 退离休人员/家庭妇女/无业人员 7＝ 交通运输业人员 8＝ 无正式工作的临时工9＝其他(注明)",length = 20, nullable = true)
    private String a4;
    @Column(name ="A4_A",columnDefinition ="VARCHAR2|职业注明",length = 20, nullable = true)
    private String a4A;
    @Column(name ="A5",columnDefinition ="VARCHAR2|A5. 您的家庭人均月收入为以下哪个水平？ 1＝501~1000 2＝1001~2000 3＝2001~3000元 4＝3001~4000元 5＝4001及以上",length = 20, nullable = true)
    private String a5;
    @Column(name ="A6",columnDefinition ="VARCHAR2|A6. 医疗费用情况？ 1＝公费医疗 2＝职工医疗保险 3＝商业医疗保险 4＝自费 5＝合作医疗 6=其他",length = 20, nullable = true)
    private String a6;
    @Column(name ="A6_A",columnDefinition ="VARCHAR2|医疗费用其他注明",length = 20, nullable = true)
    private String a6A;
    @Column(name ="B1",columnDefinition ="VARCHAR2|B1．您吸烟吗？ 1＝是 2=以前吸 0＝否",length = 20, nullable = true)
    private String b1;
    @Column(name ="B2",columnDefinition ="VARCHAR2|B2.您大概吸烟多少年？ 00＝从未规律吸烟 99＝不详",length = 30, nullable = true)
    private String b2;
    @Column(name ="B3",columnDefinition ="VARCHAR2|B3.您每天平均吸烟多少支？ 00＝少于每天1支",length = 20, nullable = true)
    private String b3;
    @Column(name ="B4",columnDefinition ="VARCHAR2|B4.您多大年龄戒烟的？ 00＝未戒烟 99＝不详",length = 20, nullable = true)
    private String b4;
    @Column(name ="B5",columnDefinition ="VARCHAR2|B5.您周围是否有人吸烟？（每日大于1小时） 1＝是 2＝否",length = 20, nullable = true)
    private String b5;
    @Column(name ="B6",columnDefinition ="VARCHAR2|B6.您喝酒吗？ 1＝经常 2＝偶尔 3＝否（转问膳食习惯）",length = 20, nullable = true)
    private String b6;
    @Column(name ="B7_A",columnDefinition ="VARCHAR2|B7.过去12个月中，您饮过何种以下不同的酒？ A.啤酒",length = 20, nullable = true)
    private String b7A;
    @Column(name ="B7_B",columnDefinition ="VARCHAR2|b.白酒",length = 20, nullable = true)
    private String b7B;
    @Column(name ="B7_C",columnDefinition ="VARCHAR2|c.葡萄酒",length = 20, nullable = true)
    private String b7C;
    @Column(name ="B7_D",columnDefinition ="VARCHAR2|d.米酒或黄酒",length = 20, nullable = true)
    private String b7D;
    @Column(name ="B8",columnDefinition ="VARCHAR2|B8.您多大年龄开始规律饮酒的？（每年至少12次以上） 00＝从未规律饮酒 99＝不详",length = 20, nullable = true)
    private String b8;
    @Column(name ="B9",columnDefinition ="VARCHAR2|B9.主食 食用频率",length = 25, nullable = true)
    private String b9;
    @Column(name ="B9_A",columnDefinition ="VARCHAR2|食用量（斤）",length = 25, nullable = true)
    private String b9A;
    @Column(name ="B9_B",columnDefinition ="VARCHAR2|食用量（两）",length = 25, nullable = true)
    private String b9B;
    @Column(name ="B10",columnDefinition ="VARCHAR2|B10.肉类 食用频率",length = 25, nullable = true)
    private String b10;
    @Column(name ="B10_A",columnDefinition ="VARCHAR2|食用量（斤）",length = 25, nullable = true)
    private String b10A;
    @Column(name ="B10_B",columnDefinition ="VARCHAR2|食用量（两）",length = 25, nullable = true)
    private String b10B;
    @Column(name ="B11",columnDefinition ="VARCHAR2|B11.鱼类 食用频率",length = 25, nullable = true)
    private String b11;
    @Column(name ="B11_A",columnDefinition ="VARCHAR2|食用量（斤）",length = 25, nullable = true)
    private String b11A;
    @Column(name ="B11_B",columnDefinition ="VARCHAR2|食用量（两）",length = 25, nullable = true)
    private String b11B;
    @Column(name ="B12",columnDefinition ="VARCHAR2|B13.蔬菜 食用频率",length = 25, nullable = true)
    private String b12;
    @Column(name ="B12_A",columnDefinition ="VARCHAR2|食用量（斤）",length = 25, nullable = true)
    private String b12A;
    @Column(name ="B12_B",columnDefinition ="VARCHAR2|食用量（两）",length = 25, nullable = true)
    private String b12B;
    @Column(name ="B13",columnDefinition ="VARCHAR2|B13.您的口味与当地一般人比：1=偏咸 2=差不多 3=偏淡 4=偏甜",length = 25, nullable = true)
    private String b13;
    @Column(name ="B14",columnDefinition ="VARCHAR2|B14.您最近一周吃肉是否＜75g/天",length = 25, nullable = true)
    private String b14;
    @Column(name ="B15",columnDefinition ="VARCHAR2|B15.您吃肉的种类是",length = 25, nullable = true)
    private String b15;
    @Column(name ="B16",columnDefinition ="VARCHAR2|B16.您最近一周吃蛋的个数",length = 25, nullable = true)
    private String b16;
    @Column(name ="B17",columnDefinition ="VARCHAR2|B17.您近一周吃油炸食品数量",length = 25, nullable = true)
    private String b17;
    @Column(name ="B18",columnDefinition ="VARCHAR2|B18.您近一周吃奶油糕点的数量",length = 25, nullable = true)
    private String b18;
    @Column(name ="C1_A",columnDefinition ="VARCHAR2|家族史 高血压 父",length = 25, nullable = true)
    private String c1A;
    @Column(name ="C1_B",columnDefinition ="VARCHAR2|家族史 高血压 母",length = 25, nullable = true)
    private String c1B;
    @Column(name ="C1_C",columnDefinition ="VARCHAR2|家族史 高血压 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c1C;
    @Column(name ="C1_D",columnDefinition ="VARCHAR2|家族史 高血压 总人数",length = 25, nullable = true)
    private String c1D;
    @Column(name ="C1_E",columnDefinition ="VARCHAR2|家族史 高血压 子女的发病人数",length = 25, nullable = true)
    private String c1E;
    @Column(name ="C1_F",columnDefinition ="VARCHAR2|家族史 高血压 总人数",length = 25, nullable = true)
    private String c1F;
    @Column(name ="C2_A",columnDefinition ="VARCHAR2|家族史 高血脂症 父",length = 25, nullable = true)
    private String c2A;
    @Column(name ="C2_B",columnDefinition ="VARCHAR2|家族史 高血脂症 母",length = 25, nullable = true)
    private String c2B;
    @Column(name ="C2_C",columnDefinition ="VARCHAR2|家族史 高血脂症 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c2C;
    @Column(name ="C2_D",columnDefinition ="VARCHAR2|家族史 高血脂症 总人数",length = 25, nullable = true)
    private String c2D;
    @Column(name ="C2_E",columnDefinition ="VARCHAR2|家族史 高血脂症 子女的发病人数",length = 25, nullable = true)
    private String c2E;
    @Column(name ="C2_F",columnDefinition ="VARCHAR2|家族史 高血脂症 总人数",length = 25, nullable = true)
    private String c2F;
    @Column(name ="C3_A",columnDefinition ="VARCHAR2|家族史 糖尿病 父",length = 25, nullable = true)
    private String c3A;
    @Column(name ="C3_B",columnDefinition ="VARCHAR2|家族史 糖尿病 母",length = 25, nullable = true)
    private String c3B;
    @Column(name ="C3_C",columnDefinition ="VARCHAR2|家族史 糖尿病 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c3C;
    @Column(name ="C3_D",columnDefinition ="VARCHAR2|家族史 糖尿病 总人数",length = 25, nullable = true)
    private String c3D;
    @Column(name ="C3_E",columnDefinition ="VARCHAR2|家族史 糖尿病 子女的发病人数",length = 25, nullable = true)
    private String c3E;
    @Column(name ="C3_F",columnDefinition ="VARCHAR2|家族史 糖尿病 总人数",length = 25, nullable = true)
    private String c3F;
    @Column(name ="C4_A",columnDefinition ="VARCHAR2|家族史 冠心病 父",length = 25, nullable = true)
    private String c4A;
    @Column(name ="C4_B",columnDefinition ="VARCHAR2|家族史 冠心病 母",length = 25, nullable = true)
    private String c4B;
    @Column(name ="C4_C",columnDefinition ="VARCHAR2|家族史 冠心病 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c4C;
    @Column(name ="C4_D",columnDefinition ="VARCHAR2|家族史 冠心病 总人数",length = 25, nullable = true)
    private String c4D;
    @Column(name ="C4_E",columnDefinition ="VARCHAR2|家族史 冠心病 子女的发病人数",length = 25, nullable = true)
    private String c4E;
    @Column(name ="C4_F",columnDefinition ="VARCHAR2|家族史 冠心病 总人数",length = 25, nullable = true)
    private String c4F;
    @Column(name ="C5_A",columnDefinition ="VARCHAR2|家族史 脑卒中 父",length = 25, nullable = true)
    private String c5A;
    @Column(name ="C5_B",columnDefinition ="VARCHAR2|家族史 脑卒中 母",length = 25, nullable = true)
    private String c5B;
    @Column(name ="C5_C",columnDefinition ="VARCHAR2|家族史 脑卒中 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c5C;
    @Column(name ="C5_D",columnDefinition ="VARCHAR2|家族史 脑卒中 总人数",length = 25, nullable = true)
    private String c5D;
    @Column(name ="C5_E",columnDefinition ="VARCHAR2|家族史 脑卒中 子女的发病人数",length = 25, nullable = true)
    private String c5E;
    @Column(name ="C5_F",columnDefinition ="VARCHAR2|家族史 脑卒中 总人数",length = 25, nullable = true)
    private String c5F;
    @Column(name ="C6_A",columnDefinition ="VARCHAR2|家族史 乙肝 父",length = 25, nullable = true)
    private String c6A;
    @Column(name ="C6_B",columnDefinition ="VARCHAR2|家族史 乙肝 母",length = 25, nullable = true)
    private String c6B;
    @Column(name ="C6_C",columnDefinition ="VARCHAR2|家族史 乙肝 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c6C;
    @Column(name ="C6_D",columnDefinition ="VARCHAR2|家族史 乙肝 总人数",length = 25, nullable = true)
    private String c6D;
    @Column(name ="C6_E",columnDefinition ="VARCHAR2|家族史 乙肝 子女的发病人数",length = 25, nullable = true)
    private String c6E;
    @Column(name ="C6_F",columnDefinition ="VARCHAR2|家族史 乙肝 总人数",length = 25, nullable = true)
    private String c6F;
    @Column(name ="C7_A",columnDefinition ="VARCHAR2|家族史 丙肝 父",length = 25, nullable = true)
    private String c7A;
    @Column(name ="C7_B",columnDefinition ="VARCHAR2|家族史 丙肝 母",length = 25, nullable = true)
    private String c7B;
    @Column(name ="C7_C",columnDefinition ="VARCHAR2|家族史 丙肝 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c7C;
    @Column(name ="C7_D",columnDefinition ="VARCHAR2|家族史 丙肝 总人数",length = 25, nullable = true)
    private String c7D;
    @Column(name ="C7_E",columnDefinition ="VARCHAR2|家族史 丙肝 子女的发病人数",length = 25, nullable = true)
    private String c7E;
    @Column(name ="C7_F",columnDefinition ="VARCHAR2|家族史 丙肝 总人数",length = 25, nullable = true)
    private String c7F;
    @Column(name ="C8_A",columnDefinition ="VARCHAR2|家族史 结核 父",length = 25, nullable = true)
    private String c8A;
    @Column(name ="C8_B",columnDefinition ="VARCHAR2|家族史 结核 母",length = 25, nullable = true)
    private String c8B;
    @Column(name ="C8_C",columnDefinition ="VARCHAR2|家族史 结核 兄弟姐妹的发病人数",length = 25, nullable = true)
    private String c8C;
    @Column(name ="C8_D",columnDefinition ="VARCHAR2|家族史 结核 总人数",length = 25, nullable = true)
    private String c8D;
    @Column(name ="C8_E",columnDefinition ="VARCHAR2|家族史 结核 子女的发病人数",length = 25, nullable = true)
    private String c8E;
    @Column(name ="C8_F",columnDefinition ="VARCHAR2|家族史 结核 总人数",length = 25, nullable = true)
    private String c8F;
    @Column(name ="C9",columnDefinition ="VARCHAR2|C9.您是否已绝经",length = 25, nullable = true)
    private String c9;
    @Column(name ="C9_A",columnDefinition ="VARCHAR2|C9.1.如果否，您现在是否怀孕",length = 25, nullable = true)
    private String c9A;
    @Column(name ="C9_B",columnDefinition ="VARCHAR2|C9.1.如果是，您是多大岁数绝经的",length = 25, nullable = true)
    private String c9B;
    @Column(name ="C10",columnDefinition ="VARCHAR2|C10.您服用过避孕药吗",length = 25, nullable = true)
    private String c10;
    @Column(name ="C11",columnDefinition ="VARCHAR2|C11.您怀孕过吗（包括流产、死产、人工受孕、堕胎、活产和正在怀孕）",length = 25, nullable = true)
    private String c11;
    @Column(name ="C12",columnDefinition ="VARCHAR2|C12.您怀孕过多少次？ 99＝不详",length = 25, nullable = true)
    private String c12;
    @Column(name ="C13",columnDefinition ="VARCHAR2|C13.您有过哺乳经历么",length = 25, nullable = true)
    private String c13;
    @Column(name ="C14",columnDefinition ="VARCHAR2|C14.医生曾告诉过您血压高吗？",length = 25, nullable = true)
    private String c14;
    @Column(name ="C15",columnDefinition ="VARCHAR2|C15.首次确诊的年龄",length = 25, nullable = true)
    private String c15;
    @Column(name ="C16_A",columnDefinition ="VARCHAR2|C16.1.您现在是否服用降压药",length = 25, nullable = true)
    private String c16A;
    @Column(name ="C16_B",columnDefinition ="VARCHAR2|C16.2.你是否遵医嘱服降压药",length = 25, nullable = true)
    private String c16B;
    @Column(name ="C17",columnDefinition ="VARCHAR2|C17.您服用降压药已有多长时间了",length = 25, nullable = true)
    private String c17;
    @Column(name ="C18",columnDefinition ="VARCHAR2|C18.您患高血压后，采取了哪些措施来控制血压（此题可多选）",length = 25, nullable = true)
    private String c18;
    @Column(name ="C19",columnDefinition ="VARCHAR2|C19.医生告诉过您血脂高吗",length = 25, nullable = true)
    private String c19;
    @Column(name ="C20_A",columnDefinition ="VARCHAR2|C20.1.您是否服用降脂药",length = 25, nullable = true)
    private String c20A;
    @Column(name ="C20_B",columnDefinition ="VARCHAR2|C20.2.您服用降脂药已经多长时间了",length = 25, nullable = true)
    private String c20B;
    @Column(name ="C20_C",columnDefinition ="VARCHAR2|C20.3.最近两周您服过降脂药吗",length = 25, nullable = true)
    private String c20C;
    @Column(name ="C21",columnDefinition ="VARCHAR2|C21.医生曾告诉过你有糖尿病吗",length = 25, nullable = true)
    private String c21;
    @Column(name ="C21_A1",columnDefinition ="VARCHAR2|C21.a.诊断日期",length = 25, nullable = true)
    private String c21A1;
    @Column(name ="C21_A2",columnDefinition ="VARCHAR2|",length = 25, nullable = true)
    private String c21A2;
    @Column(name ="C21_B1",columnDefinition ="VARCHAR2|C21.b.诊断时的空腹血糖值",length = 25, nullable = true)
    private String c21B1;
    @Column(name ="C21_B2",columnDefinition ="VARCHAR2|C21.b.诊断时的空腹血糖值",length = 25, nullable = true)
    private String c21B2;
    @Column(name ="C21_C1",columnDefinition ="VARCHAR2|C21.c.诊断时的餐后2小时糖耐量",length = 25, nullable = true)
    private String c21C1;
    @Column(name ="C21_C2",columnDefinition ="VARCHAR2|C21.c.诊断时的餐后2小时糖耐量",length = 25, nullable = true)
    private String c21C2;
    @Column(name ="C22",columnDefinition ="VARCHAR2|C22.并发症",length = 25, nullable = true)
    private String c22;
    @Column(name ="C23",columnDefinition ="VARCHAR2|C23.医生第一次告诉你糖尿病时您年龄多大",length = 25, nullable = true)
    private String c23;
    @Column(name ="C24",columnDefinition ="VARCHAR2|C24.您目前使用胰岛素吗",length = 25, nullable = true)
    private String c24;
    @Column(name ="C25",columnDefinition ="VARCHAR2|C25.您使用胰岛素多长时间了",length = 25, nullable = true)
    private String c25;
    @Column(name ="C26",columnDefinition ="VARCHAR2|C26.您目前服用口服降糖药吗",length = 25, nullable = true)
    private String c26;
    @Column(name ="C27",columnDefinition ="VARCHAR2|C27.您服用口服降糖药多长时间了",length = 25, nullable = true)
    private String c27;
    @Column(name ="C28",columnDefinition ="VARCHAR2|C28.您患糖尿病后，采取了哪些措施来控制血糖？",length = 25, nullable = true)
    private String c28;
    @Column(name ="C29",columnDefinition ="VARCHAR2|C29.医生是否诊断过您有脑卒中",length = 25, nullable = true)
    private String c29;
    @Column(name ="C30",columnDefinition ="VARCHAR2|C30.脑卒中类型",length = 25, nullable = true)
    private String c30;
    @Column(name ="C31",columnDefinition ="VARCHAR2|C31.医生是否诊断过您有冠心病",length = 25, nullable = true)
    private String c31;
    @Column(name ="C32",columnDefinition ="VARCHAR2|C32.冠心病类型",length = 25, nullable = true)
    private String c32;
    @Column(name ="C33",columnDefinition ="VARCHAR2|C33.您是否患过肝病？",length = 25, nullable = true)
    private String c33;
    @Column(name ="C34",columnDefinition ="VARCHAR2|C34.您患过何种肝炎？",length = 25, nullable = true)
    private String c34;
    @Column(name ="C35",columnDefinition ="VARCHAR2|C35.您哪一年被诊断患有肝病？",length = 25, nullable = true)
    private String c35;
    @Column(name ="C36",columnDefinition ="VARCHAR2|C36.您是否接受过治疗？",length = 25, nullable = true)
    private String c36;
    @Column(name ="C37",columnDefinition ="VARCHAR2|",length = 25, nullable = true)
    private String c37;
    @Column(name ="C38",columnDefinition ="VARCHAR2|C38.您是否患过结核？",length = 25, nullable = true)
    private String c38;
    @Column(name ="C39",columnDefinition ="VARCHAR2|C39.您哪一年被诊断患有结核？",length = 25, nullable = true)
    private String c39;
    @Column(name ="C40",columnDefinition ="VARCHAR2|C40.您是否接受过治疗？",length = 25, nullable = true)
    private String c40;
    @Column(name ="C41",columnDefinition ="VARCHAR2|C41.恶性肿瘤",length = 25, nullable = true)
    private String c41;
    @Column(name ="C41_A",columnDefinition ="VARCHAR2|恶性肿瘤名称",length = 100, nullable = true)
    private String c41A;
    @Column(name ="C41_B",columnDefinition ="VARCHAR2|恶性肿瘤icd10",length = 100, nullable = true)
    private String c41B;
    @Column(name ="C42",columnDefinition ="VARCHAR2|C42.医生是否诊断过您患有肾脏疾病",length = 25, nullable = true)
    private String c42;
    @Column(name ="C43",columnDefinition ="VARCHAR2|C43.肾脏疾病类型",length = 25, nullable = true)
    private String c43;
    @Column(name ="C44",columnDefinition ="VARCHAR2|C44.医生是否诊断过您患有肾功能衰竭或终末期肾病",length = 25, nullable = true)
    private String c44;
    @Column(name ="D1_A",columnDefinition ="VARCHAR2|D1.您每天上下班主要采用的方式及其时间。步行",length = 25, nullable = true)
    private String d1A;
    @Column(name ="D1_B",columnDefinition ="VARCHAR2|自行车",length = 25, nullable = true)
    private String d1B;
    @Column(name ="D1_C",columnDefinition ="VARCHAR2|公交、地铁、班车",length = 25, nullable = true)
    private String d1C;
    @Column(name ="D1_D",columnDefinition ="VARCHAR2|自驾车、电动车、摩托车",length = 25, nullable = true)
    private String d1D;
    @Column(name ="D2",columnDefinition ="VARCHAR2|D2.过去30天，您是否参加过任何体育锻炼或运动？",length = 2, nullable = true)
    private String d2;
    @Column(name ="D3_A",columnDefinition ="VARCHAR2|D3.1.重度体力活动（登山、负重跑或快跑、骑快车等剧烈运动）",length = 25, nullable = true)
    private String d3A;
    @Column(name ="D3_B",columnDefinition ="VARCHAR2|D3.2.中度体力活动（慢跑、快步走、秧歌、跳舞、健身操、游泳、球类）",length = 25, nullable = true)
    private String d3B;
    @Column(name ="D3_C",columnDefinition ="VARCHAR2|D3.3.轻度体力活动（散步、气功、伸展运动、家务）",length = 25, nullable = true)
    private String d3C;
    @Column(name ="D4_A",columnDefinition ="VARCHAR2|D4.通常在工作日内，您一天坐着工作的时间有（小时）",length = 25, nullable = true)
    private String d4A;
    @Column(name ="D4_B",columnDefinition ="VARCHAR2|D4.通常在工作日内，您一天坐着工作的时间有（分钟）",length = 25, nullable = true)
    private String d4B;
    @Column(name ="D5_A",columnDefinition ="VARCHAR2|D5.其他静息活动(坐或躺：看书、吃饭、聊天、打牌、看电视等)（小时）",length = 25, nullable = true)
    private String d5A;
    @Column(name ="D5_B",columnDefinition ="VARCHAR2|D5.其他静息活动(坐或躺：看书、吃饭、聊天、打牌、看电视等)（分钟）",length = 25, nullable = true)
    private String d5B;
    @Column(name ="D6_A",columnDefinition ="VARCHAR2|D6.1您的睡眠质量如何：",length = 25, nullable = true)
    private String d6A;
    @Column(name ="D6_B",columnDefinition ="VARCHAR2|D6.2睡眠障碍：",length = 25, nullable = true)
    private String d6B;
    @Column(name ="END_HOUR",columnDefinition ="VARCHAR2|调查结束时间（时）",length = 20, nullable = true)
    private String endHour;
    @Column(name ="END_MIN",columnDefinition ="VARCHAR2|调查结束时间（分）",length = 20, nullable = true)
    private String endMin;
    @Column(name ="E1",columnDefinition ="VARCHAR2|E1.您是否出现过嗅觉问题？（持续至少3个月）即您无法闻到味道，或者当您闻某物时，您闻到的味道和该物应有的味道不符。",length = 25, nullable = true)
    private String e1;
    @Column(name ="E1_A",columnDefinition ="VARCHAR2|E1.1.是哪种情况：",length = 25, nullable = true)
    private String e1A;
    @Column(name ="E2",columnDefinition ="VARCHAR2|E2.您是否出现过味觉问题？（持续至少3个月）即您无法尝到味道，或者口中感觉不到应该有的滋味，如苦、咸、酸、或者甜味。",length = 25, nullable = true)
    private String e2;
    @Column(name ="E2_A",columnDefinition ="VARCHAR2|E2.1.是哪种情况：",length = 25, nullable = true)
    private String e2A;
    @Column(name ="E3_A",columnDefinition ="VARCHAR2|E3.1.一般晚上几点钟睡觉",length = 25, nullable = true)
    private String e3A;
    @Column(name ="E3_B1",columnDefinition ="VARCHAR2|E3.2.每天夜间睡眠时间",length = 25, nullable = true)
    private String e3B1;
    @Column(name ="E3_B2",columnDefinition ="VARCHAR2|平均每天午睡时间",length = 25, nullable = true)
    private String e3B2;
    @Column(name ="E3_C1",columnDefinition ="VARCHAR2|E3.3.请对您近1个月的睡眠情况进行总体评估（第一列是问题）是否有入睡困难",length = 25, nullable = true)
    private String e3C1;
    @Column(name ="E3_C2",columnDefinition ="VARCHAR2|是否半夜会醒来",length = 25, nullable = true)
    private String e3C2;
    @Column(name ="E3_C3",columnDefinition ="VARCHAR2|比期望的时间早醒",length = 25, nullable = true)
    private String e3C3;
    @Column(name ="E3_C4",columnDefinition ="VARCHAR2|起床后觉得没有休息好",length = 25, nullable = true)
    private String e3C4;
    @Column(name ="E3_C5",columnDefinition ="VARCHAR2|经常在白天觉得乏力、疲惫、或犯困吗",length = 25, nullable = true)
    private String e3C5;
    @Column(name ="E3_D",columnDefinition ="VARCHAR2|E3.4.在过去的2年里，您是否使用药物改善睡眠（如安眠药等）",length = 25, nullable = true)
    private String e3D;
    @Column(name ="E3_E",columnDefinition ="VARCHAR2|E3.5.睡眠打鼾吗？",length = 25, nullable = true)
    private String e3E;
    @Column(name ="E3_E1",columnDefinition ="VARCHAR2|E3.5.1.鼾声比平时说话声还响或关着门也能听到吗？",length = 25, nullable = true)
    private String e3E1;
    @Column(name ="E3_E2",columnDefinition ="VARCHAR2|E3.5.2.有人说你睡觉时有呼吸暂停吗？（>10秒）",length = 25, nullable = true)
    private String e3E2;
    @Column(name ="E3_F",columnDefinition ="VARCHAR2|E3.6.是否曾经被告知自己在做噩梦的时候，会随着梦境动手脚？",length = 25, nullable = true)
    private String e3F;
    @Column(name ="E4_A",columnDefinition ="VARCHAR2|E4.在您最近几个月中，在以下情况下您打瞌睡的可能性 坐着阅读书刊",length = 25, nullable = true)
    private String e4A;
    @Column(name ="E4_B",columnDefinition ="VARCHAR2|看电视",length = 25, nullable = true)
    private String e4B;
    @Column(name ="E4_C",columnDefinition ="VARCHAR2|在公共场所坐着不动",length = 25, nullable = true)
    private String e4C;
    @Column(name ="E4_D",columnDefinition ="VARCHAR2|作为乘客，在汽车里坐1个小时，中间不休息",length = 25, nullable = true)
    private String e4D;
    @Column(name ="E4_E",columnDefinition ="VARCHAR2|在环境许可时，下午躺下休息",length = 25, nullable = true)
    private String e4E;
    @Column(name ="E4_F",columnDefinition ="VARCHAR2|坐着与人谈话",length = 25, nullable = true)
    private String e4F;
    @Column(name ="E4_G",columnDefinition ="VARCHAR2|午餐不喝酒情况下，餐后静坐时",length = 25, nullable = true)
    private String e4G;
    @Column(name ="E4_H",columnDefinition ="VARCHAR2|遇堵车时，停车数分钟",length = 25, nullable = true)
    private String e4H;
    @Column(name ="BAR_CODE",columnDefinition ="VARCHAR2|条形码",length = 32, nullable = true)
    private String barCode;
    @Column(name ="SURVEY_POPU_TYPE",columnDefinition ="VARCHAR2|",length = 25, nullable = true)
    private String surveyPopuType;
    @Column(name ="ID_NO",columnDefinition ="VARCHAR2|",length = 32, nullable = true)
    private String idNo;
    @Column(name ="D3_B1",columnDefinition ="VARCHAR2|D3.2.中度体力活动（慢跑、快步走、秧歌、跳舞、健身操、游泳、球类）每天",length = 25, nullable = true)
    private String d3B1;
    @Column(name ="D3_C1",columnDefinition ="VARCHAR2|D3.3.轻度体力活动（散步、气功、伸展运动、家务）每天",length = 25, nullable = true)
    private String d3C1;
    @Column(name ="D3_A1",columnDefinition ="VARCHAR2|D3.1.重度体力活动（登山、负重跑或快跑、骑快车等剧烈运动）每天",length = 25, nullable = true)
    private String d3A1;
    @Column(name ="C25_A",columnDefinition ="VARCHAR2|C25.a.服用药品名称",length = 100, nullable = true)
    private String c25A;
    @Column(name ="C37_B",columnDefinition ="DATE|",length = 7, nullable = true)
    private Date c37B;
    @Column(name ="C37_A",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c37A;
    @Column(name ="C16_C",columnDefinition ="VARCHAR2|C16.c.服用药品名称",length = 25, nullable = true)
    private String c16C;
    @Column(name ="C20_D",columnDefinition ="VARCHAR2|C20.4.服用药品名称",length = 100, nullable = true)
    private String c20D;
    @Column(name ="C54",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c54;
    @Column(name ="ENTERDOCTOR",columnDefinition ="VARCHAR2|录入医生",length = 100, nullable = true)
    private String enterdoctor;
    @Column(name ="C56_G",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56G;
    @Column(name ="C56_F",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56F;
    @Column(name ="C56_E",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56E;
    @Column(name ="C56_D",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56D;
    @Column(name ="C56_C",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56C;
    @Column(name ="C56_B",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56B;
    @Column(name ="C56_A",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c56A;
    @Column(name ="C55_G",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55G;
    @Column(name ="C55_F",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55F;
    @Column(name ="C55_E",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55E;
    @Column(name ="C55_D",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55D;
    @Column(name ="C55_C",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55C;
    @Column(name ="C55_B",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55B;
    @Column(name ="C55_A",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c55A;
    @Column(name ="C53",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String c53;
    @Column(name ="ADDRESS",columnDefinition ="VARCHAR2|",length = 100, nullable = true)
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurveyTarget() {
        return surveyTarget;
    }

    public void setSurveyTarget(String surveyTarget) {
        this.surveyTarget = surveyTarget;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhysicalExamNo() {
        return physicalExamNo;
    }

    public void setPhysicalExamNo(String physicalExamNo) {
        this.physicalExamNo = physicalExamNo;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getContactCellPhone() {
        return contactCellPhone;
    }

    public void setContactCellPhone(String contactCellPhone) {
        this.contactCellPhone = contactCellPhone;
    }

    public String getSurveyer() {
        return surveyer;
    }

    public void setSurveyer(String surveyer) {
        this.surveyer = surveyer;
    }

    public Date getSurveyDt() {
        return surveyDt;
    }

    public void setSurveyDt(Date surveyDt) {
        this.surveyDt = surveyDt;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getBeginMin() {
        return beginMin;
    }

    public void setBeginMin(String beginMin) {
        this.beginMin = beginMin;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA2A() {
        return a2A;
    }

    public void setA2A(String a2A) {
        this.a2A = a2A;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA4A() {
        return a4A;
    }

    public void setA4A(String a4A) {
        this.a4A = a4A;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public String getA6A() {
        return a6A;
    }

    public void setA6A(String a6A) {
        this.a6A = a6A;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public String getB6() {
        return b6;
    }

    public void setB6(String b6) {
        this.b6 = b6;
    }

    public String getB7A() {
        return b7A;
    }

    public void setB7A(String b7A) {
        this.b7A = b7A;
    }

    public String getB7B() {
        return b7B;
    }

    public void setB7B(String b7B) {
        this.b7B = b7B;
    }

    public String getB7C() {
        return b7C;
    }

    public void setB7C(String b7C) {
        this.b7C = b7C;
    }

    public String getB7D() {
        return b7D;
    }

    public void setB7D(String b7D) {
        this.b7D = b7D;
    }

    public String getB8() {
        return b8;
    }

    public void setB8(String b8) {
        this.b8 = b8;
    }

    public String getB9() {
        return b9;
    }

    public void setB9(String b9) {
        this.b9 = b9;
    }

    public String getB9A() {
        return b9A;
    }

    public void setB9A(String b9A) {
        this.b9A = b9A;
    }

    public String getB9B() {
        return b9B;
    }

    public void setB9B(String b9B) {
        this.b9B = b9B;
    }

    public String getB10() {
        return b10;
    }

    public void setB10(String b10) {
        this.b10 = b10;
    }

    public String getB10A() {
        return b10A;
    }

    public void setB10A(String b10A) {
        this.b10A = b10A;
    }

    public String getB10B() {
        return b10B;
    }

    public void setB10B(String b10B) {
        this.b10B = b10B;
    }

    public String getB11() {
        return b11;
    }

    public void setB11(String b11) {
        this.b11 = b11;
    }

    public String getB11A() {
        return b11A;
    }

    public void setB11A(String b11A) {
        this.b11A = b11A;
    }

    public String getB11B() {
        return b11B;
    }

    public void setB11B(String b11B) {
        this.b11B = b11B;
    }

    public String getB12() {
        return b12;
    }

    public void setB12(String b12) {
        this.b12 = b12;
    }

    public String getB12A() {
        return b12A;
    }

    public void setB12A(String b12A) {
        this.b12A = b12A;
    }

    public String getB12B() {
        return b12B;
    }

    public void setB12B(String b12B) {
        this.b12B = b12B;
    }

    public String getB13() {
        return b13;
    }

    public void setB13(String b13) {
        this.b13 = b13;
    }

    public String getB14() {
        return b14;
    }

    public void setB14(String b14) {
        this.b14 = b14;
    }

    public String getB15() {
        return b15;
    }

    public void setB15(String b15) {
        this.b15 = b15;
    }

    public String getB16() {
        return b16;
    }

    public void setB16(String b16) {
        this.b16 = b16;
    }

    public String getB17() {
        return b17;
    }

    public void setB17(String b17) {
        this.b17 = b17;
    }

    public String getB18() {
        return b18;
    }

    public void setB18(String b18) {
        this.b18 = b18;
    }

    public String getC1A() {
        return c1A;
    }

    public void setC1A(String c1A) {
        this.c1A = c1A;
    }

    public String getC1B() {
        return c1B;
    }

    public void setC1B(String c1B) {
        this.c1B = c1B;
    }

    public String getC1C() {
        return c1C;
    }

    public void setC1C(String c1C) {
        this.c1C = c1C;
    }

    public String getC1D() {
        return c1D;
    }

    public void setC1D(String c1D) {
        this.c1D = c1D;
    }

    public String getC1E() {
        return c1E;
    }

    public void setC1E(String c1E) {
        this.c1E = c1E;
    }

    public String getC1F() {
        return c1F;
    }

    public void setC1F(String c1F) {
        this.c1F = c1F;
    }

    public String getC2A() {
        return c2A;
    }

    public void setC2A(String c2A) {
        this.c2A = c2A;
    }

    public String getC2B() {
        return c2B;
    }

    public void setC2B(String c2B) {
        this.c2B = c2B;
    }

    public String getC2C() {
        return c2C;
    }

    public void setC2C(String c2C) {
        this.c2C = c2C;
    }

    public String getC2D() {
        return c2D;
    }

    public void setC2D(String c2D) {
        this.c2D = c2D;
    }

    public String getC2E() {
        return c2E;
    }

    public void setC2E(String c2E) {
        this.c2E = c2E;
    }

    public String getC2F() {
        return c2F;
    }

    public void setC2F(String c2F) {
        this.c2F = c2F;
    }

    public String getC3A() {
        return c3A;
    }

    public void setC3A(String c3A) {
        this.c3A = c3A;
    }

    public String getC3B() {
        return c3B;
    }

    public void setC3B(String c3B) {
        this.c3B = c3B;
    }

    public String getC3C() {
        return c3C;
    }

    public void setC3C(String c3C) {
        this.c3C = c3C;
    }

    public String getC3D() {
        return c3D;
    }

    public void setC3D(String c3D) {
        this.c3D = c3D;
    }

    public String getC3E() {
        return c3E;
    }

    public void setC3E(String c3E) {
        this.c3E = c3E;
    }

    public String getC3F() {
        return c3F;
    }

    public void setC3F(String c3F) {
        this.c3F = c3F;
    }

    public String getC4A() {
        return c4A;
    }

    public void setC4A(String c4A) {
        this.c4A = c4A;
    }

    public String getC4B() {
        return c4B;
    }

    public void setC4B(String c4B) {
        this.c4B = c4B;
    }

    public String getC4C() {
        return c4C;
    }

    public void setC4C(String c4C) {
        this.c4C = c4C;
    }

    public String getC4D() {
        return c4D;
    }

    public void setC4D(String c4D) {
        this.c4D = c4D;
    }

    public String getC4E() {
        return c4E;
    }

    public void setC4E(String c4E) {
        this.c4E = c4E;
    }

    public String getC4F() {
        return c4F;
    }

    public void setC4F(String c4F) {
        this.c4F = c4F;
    }

    public String getC5A() {
        return c5A;
    }

    public void setC5A(String c5A) {
        this.c5A = c5A;
    }

    public String getC5B() {
        return c5B;
    }

    public void setC5B(String c5B) {
        this.c5B = c5B;
    }

    public String getC5C() {
        return c5C;
    }

    public void setC5C(String c5C) {
        this.c5C = c5C;
    }

    public String getC5D() {
        return c5D;
    }

    public void setC5D(String c5D) {
        this.c5D = c5D;
    }

    public String getC5E() {
        return c5E;
    }

    public void setC5E(String c5E) {
        this.c5E = c5E;
    }

    public String getC5F() {
        return c5F;
    }

    public void setC5F(String c5F) {
        this.c5F = c5F;
    }

    public String getC6A() {
        return c6A;
    }

    public void setC6A(String c6A) {
        this.c6A = c6A;
    }

    public String getC6B() {
        return c6B;
    }

    public void setC6B(String c6B) {
        this.c6B = c6B;
    }

    public String getC6C() {
        return c6C;
    }

    public void setC6C(String c6C) {
        this.c6C = c6C;
    }

    public String getC6D() {
        return c6D;
    }

    public void setC6D(String c6D) {
        this.c6D = c6D;
    }

    public String getC6E() {
        return c6E;
    }

    public void setC6E(String c6E) {
        this.c6E = c6E;
    }

    public String getC6F() {
        return c6F;
    }

    public void setC6F(String c6F) {
        this.c6F = c6F;
    }

    public String getC7A() {
        return c7A;
    }

    public void setC7A(String c7A) {
        this.c7A = c7A;
    }

    public String getC7B() {
        return c7B;
    }

    public void setC7B(String c7B) {
        this.c7B = c7B;
    }

    public String getC7C() {
        return c7C;
    }

    public void setC7C(String c7C) {
        this.c7C = c7C;
    }

    public String getC7D() {
        return c7D;
    }

    public void setC7D(String c7D) {
        this.c7D = c7D;
    }

    public String getC7E() {
        return c7E;
    }

    public void setC7E(String c7E) {
        this.c7E = c7E;
    }

    public String getC7F() {
        return c7F;
    }

    public void setC7F(String c7F) {
        this.c7F = c7F;
    }

    public String getC8A() {
        return c8A;
    }

    public void setC8A(String c8A) {
        this.c8A = c8A;
    }

    public String getC8B() {
        return c8B;
    }

    public void setC8B(String c8B) {
        this.c8B = c8B;
    }

    public String getC8C() {
        return c8C;
    }

    public void setC8C(String c8C) {
        this.c8C = c8C;
    }

    public String getC8D() {
        return c8D;
    }

    public void setC8D(String c8D) {
        this.c8D = c8D;
    }

    public String getC8E() {
        return c8E;
    }

    public void setC8E(String c8E) {
        this.c8E = c8E;
    }

    public String getC8F() {
        return c8F;
    }

    public void setC8F(String c8F) {
        this.c8F = c8F;
    }

    public String getC9() {
        return c9;
    }

    public void setC9(String c9) {
        this.c9 = c9;
    }

    public String getC9A() {
        return c9A;
    }

    public void setC9A(String c9A) {
        this.c9A = c9A;
    }

    public String getC9B() {
        return c9B;
    }

    public void setC9B(String c9B) {
        this.c9B = c9B;
    }

    public String getC10() {
        return c10;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public String getC11() {
        return c11;
    }

    public void setC11(String c11) {
        this.c11 = c11;
    }

    public String getC12() {
        return c12;
    }

    public void setC12(String c12) {
        this.c12 = c12;
    }

    public String getC13() {
        return c13;
    }

    public void setC13(String c13) {
        this.c13 = c13;
    }

    public String getC14() {
        return c14;
    }

    public void setC14(String c14) {
        this.c14 = c14;
    }

    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public String getC16A() {
        return c16A;
    }

    public void setC16A(String c16A) {
        this.c16A = c16A;
    }

    public String getC16B() {
        return c16B;
    }

    public void setC16B(String c16B) {
        this.c16B = c16B;
    }

    public String getC17() {
        return c17;
    }

    public void setC17(String c17) {
        this.c17 = c17;
    }

    public String getC18() {
        return c18;
    }

    public void setC18(String c18) {
        this.c18 = c18;
    }

    public String getC19() {
        return c19;
    }

    public void setC19(String c19) {
        this.c19 = c19;
    }

    public String getC20A() {
        return c20A;
    }

    public void setC20A(String c20A) {
        this.c20A = c20A;
    }

    public String getC20B() {
        return c20B;
    }

    public void setC20B(String c20B) {
        this.c20B = c20B;
    }

    public String getC20C() {
        return c20C;
    }

    public void setC20C(String c20C) {
        this.c20C = c20C;
    }

    public String getC21() {
        return c21;
    }

    public void setC21(String c21) {
        this.c21 = c21;
    }

    public String getC21A1() {
        return c21A1;
    }

    public void setC21A1(String c21A1) {
        this.c21A1 = c21A1;
    }

    public String getC21A2() {
        return c21A2;
    }

    public void setC21A2(String c21A2) {
        this.c21A2 = c21A2;
    }

    public String getC21B1() {
        return c21B1;
    }

    public void setC21B1(String c21B1) {
        this.c21B1 = c21B1;
    }

    public String getC21B2() {
        return c21B2;
    }

    public void setC21B2(String c21B2) {
        this.c21B2 = c21B2;
    }

    public String getC21C1() {
        return c21C1;
    }

    public void setC21C1(String c21C1) {
        this.c21C1 = c21C1;
    }

    public String getC21C2() {
        return c21C2;
    }

    public void setC21C2(String c21C2) {
        this.c21C2 = c21C2;
    }

    public String getC22() {
        return c22;
    }

    public void setC22(String c22) {
        this.c22 = c22;
    }

    public String getC23() {
        return c23;
    }

    public void setC23(String c23) {
        this.c23 = c23;
    }

    public String getC24() {
        return c24;
    }

    public void setC24(String c24) {
        this.c24 = c24;
    }

    public String getC25() {
        return c25;
    }

    public void setC25(String c25) {
        this.c25 = c25;
    }

    public String getC26() {
        return c26;
    }

    public void setC26(String c26) {
        this.c26 = c26;
    }

    public String getC27() {
        return c27;
    }

    public void setC27(String c27) {
        this.c27 = c27;
    }

    public String getC28() {
        return c28;
    }

    public void setC28(String c28) {
        this.c28 = c28;
    }

    public String getC29() {
        return c29;
    }

    public void setC29(String c29) {
        this.c29 = c29;
    }

    public String getC30() {
        return c30;
    }

    public void setC30(String c30) {
        this.c30 = c30;
    }

    public String getC31() {
        return c31;
    }

    public void setC31(String c31) {
        this.c31 = c31;
    }

    public String getC32() {
        return c32;
    }

    public void setC32(String c32) {
        this.c32 = c32;
    }

    public String getC33() {
        return c33;
    }

    public void setC33(String c33) {
        this.c33 = c33;
    }

    public String getC34() {
        return c34;
    }

    public void setC34(String c34) {
        this.c34 = c34;
    }

    public String getC35() {
        return c35;
    }

    public void setC35(String c35) {
        this.c35 = c35;
    }

    public String getC36() {
        return c36;
    }

    public void setC36(String c36) {
        this.c36 = c36;
    }

    public String getC37() {
        return c37;
    }

    public void setC37(String c37) {
        this.c37 = c37;
    }

    public String getC38() {
        return c38;
    }

    public void setC38(String c38) {
        this.c38 = c38;
    }

    public String getC39() {
        return c39;
    }

    public void setC39(String c39) {
        this.c39 = c39;
    }

    public String getC40() {
        return c40;
    }

    public void setC40(String c40) {
        this.c40 = c40;
    }

    public String getC41() {
        return c41;
    }

    public void setC41(String c41) {
        this.c41 = c41;
    }

    public String getC41A() {
        return c41A;
    }

    public void setC41A(String c41A) {
        this.c41A = c41A;
    }

    public String getC41B() {
        return c41B;
    }

    public void setC41B(String c41B) {
        this.c41B = c41B;
    }

    public String getC42() {
        return c42;
    }

    public void setC42(String c42) {
        this.c42 = c42;
    }

    public String getC43() {
        return c43;
    }

    public void setC43(String c43) {
        this.c43 = c43;
    }

    public String getC44() {
        return c44;
    }

    public void setC44(String c44) {
        this.c44 = c44;
    }

    public String getD1A() {
        return d1A;
    }

    public void setD1A(String d1A) {
        this.d1A = d1A;
    }

    public String getD1B() {
        return d1B;
    }

    public void setD1B(String d1B) {
        this.d1B = d1B;
    }

    public String getD1C() {
        return d1C;
    }

    public void setD1C(String d1C) {
        this.d1C = d1C;
    }

    public String getD1D() {
        return d1D;
    }

    public void setD1D(String d1D) {
        this.d1D = d1D;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getD3A() {
        return d3A;
    }

    public void setD3A(String d3A) {
        this.d3A = d3A;
    }

    public String getD3B() {
        return d3B;
    }

    public void setD3B(String d3B) {
        this.d3B = d3B;
    }

    public String getD3C() {
        return d3C;
    }

    public void setD3C(String d3C) {
        this.d3C = d3C;
    }

    public String getD4A() {
        return d4A;
    }

    public void setD4A(String d4A) {
        this.d4A = d4A;
    }

    public String getD4B() {
        return d4B;
    }

    public void setD4B(String d4B) {
        this.d4B = d4B;
    }

    public String getD5A() {
        return d5A;
    }

    public void setD5A(String d5A) {
        this.d5A = d5A;
    }

    public String getD5B() {
        return d5B;
    }

    public void setD5B(String d5B) {
        this.d5B = d5B;
    }

    public String getD6A() {
        return d6A;
    }

    public void setD6A(String d6A) {
        this.d6A = d6A;
    }

    public String getD6B() {
        return d6B;
    }

    public void setD6B(String d6B) {
        this.d6B = d6B;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndMin() {
        return endMin;
    }

    public void setEndMin(String endMin) {
        this.endMin = endMin;
    }

    public String getE1() {
        return e1;
    }

    public void setE1(String e1) {
        this.e1 = e1;
    }

    public String getE1A() {
        return e1A;
    }

    public void setE1A(String e1A) {
        this.e1A = e1A;
    }

    public String getE2() {
        return e2;
    }

    public void setE2(String e2) {
        this.e2 = e2;
    }

    public String getE2A() {
        return e2A;
    }

    public void setE2A(String e2A) {
        this.e2A = e2A;
    }

    public String getE3A() {
        return e3A;
    }

    public void setE3A(String e3A) {
        this.e3A = e3A;
    }

    public String getE3B1() {
        return e3B1;
    }

    public void setE3B1(String e3B1) {
        this.e3B1 = e3B1;
    }

    public String getE3B2() {
        return e3B2;
    }

    public void setE3B2(String e3B2) {
        this.e3B2 = e3B2;
    }

    public String getE3C1() {
        return e3C1;
    }

    public void setE3C1(String e3C1) {
        this.e3C1 = e3C1;
    }

    public String getE3C2() {
        return e3C2;
    }

    public void setE3C2(String e3C2) {
        this.e3C2 = e3C2;
    }

    public String getE3C3() {
        return e3C3;
    }

    public void setE3C3(String e3C3) {
        this.e3C3 = e3C3;
    }

    public String getE3C4() {
        return e3C4;
    }

    public void setE3C4(String e3C4) {
        this.e3C4 = e3C4;
    }

    public String getE3C5() {
        return e3C5;
    }

    public void setE3C5(String e3C5) {
        this.e3C5 = e3C5;
    }

    public String getE3D() {
        return e3D;
    }

    public void setE3D(String e3D) {
        this.e3D = e3D;
    }

    public String getE3E() {
        return e3E;
    }

    public void setE3E(String e3E) {
        this.e3E = e3E;
    }

    public String getE3E1() {
        return e3E1;
    }

    public void setE3E1(String e3E1) {
        this.e3E1 = e3E1;
    }

    public String getE3E2() {
        return e3E2;
    }

    public void setE3E2(String e3E2) {
        this.e3E2 = e3E2;
    }

    public String getE3F() {
        return e3F;
    }

    public void setE3F(String e3F) {
        this.e3F = e3F;
    }

    public String getE4A() {
        return e4A;
    }

    public void setE4A(String e4A) {
        this.e4A = e4A;
    }

    public String getE4B() {
        return e4B;
    }

    public void setE4B(String e4B) {
        this.e4B = e4B;
    }

    public String getE4C() {
        return e4C;
    }

    public void setE4C(String e4C) {
        this.e4C = e4C;
    }

    public String getE4D() {
        return e4D;
    }

    public void setE4D(String e4D) {
        this.e4D = e4D;
    }

    public String getE4E() {
        return e4E;
    }

    public void setE4E(String e4E) {
        this.e4E = e4E;
    }

    public String getE4F() {
        return e4F;
    }

    public void setE4F(String e4F) {
        this.e4F = e4F;
    }

    public String getE4G() {
        return e4G;
    }

    public void setE4G(String e4G) {
        this.e4G = e4G;
    }

    public String getE4H() {
        return e4H;
    }

    public void setE4H(String e4H) {
        this.e4H = e4H;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getSurveyPopuType() {
        return surveyPopuType;
    }

    public void setSurveyPopuType(String surveyPopuType) {
        this.surveyPopuType = surveyPopuType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getD3B1() {
        return d3B1;
    }

    public void setD3B1(String d3B1) {
        this.d3B1 = d3B1;
    }

    public String getD3C1() {
        return d3C1;
    }

    public void setD3C1(String d3C1) {
        this.d3C1 = d3C1;
    }

    public String getD3A1() {
        return d3A1;
    }

    public void setD3A1(String d3A1) {
        this.d3A1 = d3A1;
    }

    public String getC25A() {
        return c25A;
    }

    public void setC25A(String c25A) {
        this.c25A = c25A;
    }

    public Date getC37B() {
        return c37B;
    }

    public void setC37B(Date c37B) {
        this.c37B = c37B;
    }

    public String getC37A() {
        return c37A;
    }

    public void setC37A(String c37A) {
        this.c37A = c37A;
    }

    public String getC16C() {
        return c16C;
    }

    public void setC16C(String c16C) {
        this.c16C = c16C;
    }

    public String getC20D() {
        return c20D;
    }

    public void setC20D(String c20D) {
        this.c20D = c20D;
    }

    public String getC54() {
        return c54;
    }

    public void setC54(String c54) {
        this.c54 = c54;
    }

    public String getEnterdoctor() {
        return enterdoctor;
    }

    public void setEnterdoctor(String enterdoctor) {
        this.enterdoctor = enterdoctor;
    }

    public String getC56G() {
        return c56G;
    }

    public void setC56G(String c56G) {
        this.c56G = c56G;
    }

    public String getC56F() {
        return c56F;
    }

    public void setC56F(String c56F) {
        this.c56F = c56F;
    }

    public String getC56E() {
        return c56E;
    }

    public void setC56E(String c56E) {
        this.c56E = c56E;
    }

    public String getC56D() {
        return c56D;
    }

    public void setC56D(String c56D) {
        this.c56D = c56D;
    }

    public String getC56C() {
        return c56C;
    }

    public void setC56C(String c56C) {
        this.c56C = c56C;
    }

    public String getC56B() {
        return c56B;
    }

    public void setC56B(String c56B) {
        this.c56B = c56B;
    }

    public String getC56A() {
        return c56A;
    }

    public void setC56A(String c56A) {
        this.c56A = c56A;
    }

    public String getC55G() {
        return c55G;
    }

    public void setC55G(String c55G) {
        this.c55G = c55G;
    }

    public String getC55F() {
        return c55F;
    }

    public void setC55F(String c55F) {
        this.c55F = c55F;
    }

    public String getC55E() {
        return c55E;
    }

    public void setC55E(String c55E) {
        this.c55E = c55E;
    }

    public String getC55D() {
        return c55D;
    }

    public void setC55D(String c55D) {
        this.c55D = c55D;
    }

    public String getC55C() {
        return c55C;
    }

    public void setC55C(String c55C) {
        this.c55C = c55C;
    }

    public String getC55B() {
        return c55B;
    }

    public void setC55B(String c55B) {
        this.c55B = c55B;
    }

    public String getC55A() {
        return c55A;
    }

    public void setC55A(String c55A) {
        this.c55A = c55A;
    }

    public String getC53() {
        return c53;
    }

    public void setC53(String c53) {
        this.c53 = c53;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
