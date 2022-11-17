package com.founder.rhip.ehr.repository.statistics;

/**
 * 统计sql
 * @author liuk
 *
 */
public interface RecordStatisticsSql {
    static String ADMIN_STAR_DATA_SQL=
        "SELECT TEMP.*, " +
            "RECORD_COUNT /  NULLIF(PERSON_COUNT , 0) RECORD_OCCUPANCY, " +
            " ONE_STAR_RECORD_COUNT / NULLIF(PERSON_COUNT , 0)ONE_STAR_RECORD_OCCUPANCY , " +
            " TWO_STAR_RECORD_COUNT /  NULLIF(PERSON_COUNT , 0) TWO_STAR_RECORD_OCCUPANCY, " +
            " THREE_STAR_RECORD_COUNT /  NULLIF(PERSON_COUNT , 0)THREE_STAR_RECORD_OCCUPANCY , " +
            " TWOA_STAR_RECORD_COUNT /  NULLIF(PERSON_COUNT , 0) TWOA_STAR_RECORD_OCCUPANCY, " +
            " ONE_STAR_RECORD_COM_COUNT / \"NULLIF\" (ONE_STAR_RECORD_COUNT, 0) ONE_STAR_RECORD_INTEGRITY, " +
            " TWO_STAR_RECORD_COM_COUNT / \"NULLIF\" (TWO_STAR_RECORD_COUNT, 0) TWO_STAR_RECORD_INTEGRITY, " +
            " THREE_STAR_RECORD_COM_COUNT / \"NULLIF\" (THREE_STAR_RECORD_COUNT, 0) THREE_STAR_RECORD_INTEGRITY, " +
            " TWOA_STAR_RECORD_COM_COUNT / \"NULLIF\" (TWOA_STAR_RECORD_COUNT, 0) TWOA_STAR_RECORD_INTEGRITY, " +
            " STAR_RECORD_COM_COUNT / \"NULLIF\" (RECORD_COUNT, 0) RECORD_INTEGRITY " +
            " FROM( " +
            "SELECT " +
            "	 T_PERS.GBCODE CODE, " +
            "	 T_PERS.PERSON_COUNT, " +
            "	 T_STAR.ONE_STAR_RECORD_COUNT, " +
            "	 T_STAR.RECORD_COUNT, " +
            "	 T_STAR.THREE_STAR_RECORD_COUNT, " +
            "	 T_STAR.TWOA_STAR_RECORD_COUNT, " +
            "	 T_STAR.TWO_STAR_RECORD_COUNT, " +
            "	 T_COM.ONE_STAR_RECORD_COM_COUNT, " +
            "	 T_COM.TWO_STAR_RECORD_COM_COUNT, " +
            "	 T_COM.THREE_STAR_RECORD_COM_COUNT, " +
            "	 T_COM.TWOA_STAR_RECORD_COM_COUNT, " +
            "	 T_COM.STAR_RECORD_COM_COUNT " +
            "FROM " +
            "	(	 " +
            "	SELECT " +
            "		POP.GBCODE,%1$s   PERSON_COUNT " +
            "	FROM BI_POPULACE POP  WHERE POP.GBCODE IS NOT NULL AND  POP.COUNT_YEAR=:countYear " +
            "	GROUP BY " +
            "		POP.GBCODE " +
            ") T_PERS  " +
            "LEFT JOIN   ( " +
            "		SELECT " +
            "			INPUT_GBCODE, " +
            "			\"SUM\" (TOTAL) AS RECORD_COUNT, " +
            "			\"SUM\" (ONE) ONE_STAR_RECORD_COUNT, " +
            "			\"SUM\" (TWO) TWO_STAR_RECORD_COUNT, " +
            "			\"SUM\" (THREE) THREE_STAR_RECORD_COUNT, " +
            "			NVL(\"SUM\"(THREE),0)+NVL(\"SUM\"(TWO),0) TWOA_STAR_RECORD_COUNT " +
            "		FROM " +
            "			( " +
            "				SELECT " +
            "					INPUT_GBCODE, " +
            "					\"COUNT\" (1) TOTAL, " +
            "					CASE \"STAR\" WHEN 1 THEN \"COUNT\" (\"STAR\") END AS ONE, " +
            "					CASE \"STAR\" WHEN 2 THEN \"COUNT\" (\"STAR\") END AS TWO, " +
            "					CASE \"STAR\" WHEN 3 THEN \"COUNT\" (\"STAR\") END AS THREE " +
            "				FROM " +
            "					 BI_PERSON_INFO WHERE INPUT_GBCODE IS NOT NULL AND FILING_FLAG='1'  %2$s " +
            "				GROUP BY " +
            "					INPUT_GBCODE, " +
            "					STAR " +
            "					) " +
            "			GROUP BY INPUT_GBCODE " +
            "	) T_STAR ON T_STAR.INPUT_GBCODE = T_PERS.GBCODE " +
            "LEFT JOIN ( " +
            "SELECT " +
            "			INPUT_GBCODE, " +
            "			\"SUM\" (ONE_COM) ONE_STAR_RECORD_COM_COUNT, " +
            "			\"SUM\" (TWO_COM) TWO_STAR_RECORD_COM_COUNT, " +
            "			\"SUM\" (THREE_COM) THREE_STAR_RECORD_COM_COUNT, " +
            "			NVL(\"SUM\"(THREE_COM),0)+NVL(\"SUM\"(TWO_COM),0) TWOA_STAR_RECORD_COM_COUNT, " +
            "			NVL(\"SUM\"(THREE_COM),0)+NVL(\"SUM\"(TWO_COM),0)+NVL(\"SUM\"(ONE_COM),0) STAR_RECORD_COM_COUNT " +
            "		FROM " +
            "			( " +
            "				SELECT " +
            "					INPUT_GBCODE, " +
            "					CASE \"STAR\" WHEN 1 THEN \"COUNT\" (\"STAR\") END AS ONE_COM, " +
            "					CASE \"STAR\" WHEN 2 THEN \"COUNT\" (\"STAR\") END AS TWO_COM, " +
            "					CASE \"STAR\" WHEN 3 THEN \"COUNT\" (\"STAR\") END AS THREE_COM " +
            "				FROM " +
            "					  BI_PERSON_INFO WHERE INPUT_GBCODE IS NOT NULL AND FILING_FLAG='1' AND \"INTEGRITY\">0.99 %2$s  " +
            "				GROUP BY " +
            "					INPUT_GBCODE, " +
            "					STAR " +
            "					) " +
            "			GROUP BY INPUT_GBCODE " +
            ") T_COM ON T_COM.INPUT_GBCODE = T_STAR.INPUT_GBCODE  )TEMP ORDER BY CODE " ;

    static String ADMIN_STAR_DATA_SQL_CENTER=
        "with orgs as (select organ_code from MDM_ORGANIZATION\n" +
            "where GENRE_CODE in ('B100','C'))\n" +
            "SELECT\n" +
            "    temp.*,\n" +
            "    record_count / nullif(person_count,0) record_occupancy,\n" +
            "    one_star_record_count / nullif(person_count,0) one_star_record_occupancy,\n" +
            "    two_star_record_count / nullif(person_count,0) two_star_record_occupancy,\n" +
            "    three_star_record_count / nullif(person_count,0) three_star_record_occupancy,\n" +
            "    twoa_star_record_count / nullif(person_count,0) twoa_star_record_occupancy,\n" +
            "    one_star_record_com_count / \"NULLIF\"(one_star_record_count,0) one_star_record_integrity,\n" +
            "    two_star_record_com_count / \"NULLIF\"(two_star_record_count,0) two_star_record_integrity,\n" +
            "    three_star_record_com_count / \"NULLIF\"(three_star_record_count,0) three_star_record_integrity,\n" +
            "    twoa_star_record_com_count / \"NULLIF\"(twoa_star_record_count,0) twoa_star_record_integrity,\n" +
            "    star_record_com_count / \"NULLIF\"(record_count,0) record_integrity\n" +
            "FROM\n" +
            "    (\n" +
            "        SELECT\n" +
            "            t_pers.ORGAN_PARENT_CODE code,\n" +
            "            t_pers.person_count,\n" +
            "            t_star.one_star_record_count,\n" +
            "            t_star.record_count,\n" +
            "            t_star.three_star_record_count,\n" +
            "            t_star.twoa_star_record_count,\n" +
            "            t_star.two_star_record_count,\n" +
            "            t_star.one_star_record_com_count,\n" +
            "            t_star.two_star_record_com_count,\n" +
            "            t_star.three_star_record_com_count,\n" +
            "            t_star.twoa_star_record_com_count,\n" +
            "            t_star.star_record_com_count\n" +
            "        FROM\n" +
            "            (\n" +
            "                select ORGAN_PARENT_CODE, person_count from orgs left join(\n" +
            "                SELECT\n" +
            "                    ORGAN_PARENT_CODE,\n" +
            "                    %1$s  person_count\n" +
            "                from ( select \n" +
            "                case when t_org.GENRE_CODE = 'B100' or t_org.GENRE_CODE = 'C' then pop.ORGAN_CODE else t_org.PARENT_CODE end ORGAN_PARENT_CODE,\n" +
            "                    HOUSEHOLD_NUM, UN_HOUSE_HOLD_NUM \n" +
            "                FROM\n" +
            "                    bi_populace pop\n" +
            "                left join MDM_ORGANIZATION t_org on t_org.organ_code = pop.ORGAN_CODE\n" +
            "                WHERE\n" +
            "                    (pop.ORGAN_PARENT_CODE in (select * from orgs) or pop.ORGAN_CODE in (select * from orgs))\n" +
            "                    AND pop.count_year =:countYear)\n" +
            "                GROUP BY\n" +
            "                    ORGAN_PARENT_CODE) on orgs.organ_code = ORGAN_PARENT_CODE\n" +
            "            ) t_pers\n" +
            "            LEFT JOIN (\n" +
            "                SELECT\n" +
            "                    INPUT_CENTER_ORGAN_CODE,\n" +
            "                    \"SUM\"(total) AS record_count,\n" +
            "                    \"SUM\"(one) one_star_record_count,\n" +
            "                    \"SUM\"(two) two_star_record_count,\n" +
            "                    \"SUM\"(three) three_star_record_count,\n" +
            "                    nvl(\"SUM\"(three),0) + nvl(\"SUM\"(two),0) twoa_star_record_count,\n" +
            "                    \"SUM\"(one_com) one_star_record_com_count,\n" +
            "                    \"SUM\"(two_com) two_star_record_com_count,\n" +
            "                    \"SUM\"(three_com) three_star_record_com_count,\n" +
            "                    nvl(\"SUM\"(three_com),0) + nvl(\"SUM\"(two_com),0) twoa_star_record_com_count,\n" +
            "                    nvl(\"SUM\"(three_com),0) + nvl(\"SUM\"(two_com),0) + nvl(\"SUM\"(one_com),0) star_record_com_count\n" +
            "                FROM\n" +
            "                    (\n" +
            "                        SELECT\n" +
            "                            INPUT_CENTER_ORGAN_CODE,\n" +
            "                            \"COUNT\"(1) total,\n" +
            "                            CASE \"STAR\"\n" +
            "                                    WHEN 1   THEN \"COUNT\"(\"STAR\")\n" +
            "                                END\n" +
            "                            AS one,\n" +
            "                            CASE \"STAR\"\n" +
            "                                    WHEN 2   THEN \"COUNT\"(\"STAR\")\n" +
            "                                END\n" +
            "                            AS two,\n" +
            "                            CASE \"STAR\"\n" +
            "                                    WHEN 3   THEN \"COUNT\"(\"STAR\")\n" +
            "                                END\n" +
            "                            AS three,\n" +
            "                            CASE WHEN \"STAR\" = 1 AND \"INTEGRITY\" > 0.99  THEN \"COUNT\"(\"STAR\")\n" +
            "                                END\n" +
            "                            AS one_com,\n" +
            "                            CASE WHEN \"STAR\" = 2 AND \"INTEGRITY\" > 0.99  THEN \"COUNT\"(\"STAR\")\n" +
            "                                END\n" +
            "                            AS two_com,\n" +
            "                            CASE WHEN \"STAR\" = 3 AND \"INTEGRITY\" > 0.99  THEN \"COUNT\"(\"STAR\")\n" +
            "                                END\n" +
            "                            AS three_com\n" +
            "                            from (\n" +
            "                            select \n" +
            "                           case when t_org.GENRE_CODE = 'B100' or t_org.GENRE_CODE = 'C' then per.INPUT_ORGAN_CODE else t_org.PARENT_CODE end INPUT_CENTER_ORGAN_CODE,\n" +
            "                                star,INTEGRITY\n" +
            "                        FROM\n" +
            "                            bi_person_info per\n" +
            "                        left join MDM_ORGANIZATION t_org on t_org.organ_code = per.INPUT_ORGAN_CODE\n" +
            "                        WHERE\n" +
            "                    (INPUT_CENTER_ORGAN_CODE in (select * from orgs) or INPUT_ORGAN_CODE in (select * from orgs))\n" +
            "                            AND filing_flag = '1' %2$s) \n" +
            "                        GROUP BY\n" +
            "                            INPUT_CENTER_ORGAN_CODE,\n" +
            "                            star,INTEGRITY\n" +
            "                    )\n" +
            "                GROUP BY\n" +
            "                    INPUT_CENTER_ORGAN_CODE\n" +
            "            ) t_star ON t_star.INPUT_CENTER_ORGAN_CODE = t_pers.ORGAN_PARENT_CODE\n" +
            "    ) temp where temp.CODE is not null \n" +
            "ORDER BY\n" +
            "    code" ;

    /**卫管中心统计SQL*/
    static final String ORG_STAR_STATISTICS_SQL="SELECT " +
        "	TEMP.*, RECORD_COUNT / NULLIF(PERSON_COUNT , 0)RECORD_OCCUPANCY, " +
        "	ONE_STAR_RECORD_COUNT / NULLIF(PERSON_COUNT , 0)ONE_STAR_RECORD_OCCUPANCY, " +
        "	TWO_STAR_RECORD_COUNT / NULLIF(PERSON_COUNT , 0)TWO_STAR_RECORD_OCCUPANCY, " +
        "	THREE_STAR_RECORD_COUNT / NULLIF(PERSON_COUNT , 0)THREE_STAR_RECORD_OCCUPANCY, " +
        "	TWOA_STAR_RECORD_COUNT / NULLIF(PERSON_COUNT , 0)TWOA_STAR_RECORD_OCCUPANCY, " +
        "	ONE_STAR_RECORD_COM_COUNT / \"NULLIF\" (ONE_STAR_RECORD_COUNT, 0) ONE_STAR_RECORD_INTEGRITY, " +
        "	TWO_STAR_RECORD_COM_COUNT / \"NULLIF\" (TWO_STAR_RECORD_COUNT, 0) TWO_STAR_RECORD_INTEGRITY, " +
        "	THREE_STAR_RECORD_COM_COUNT / \"NULLIF\" (THREE_STAR_RECORD_COUNT, 0) THREE_STAR_RECORD_INTEGRITY, " +
        "	TWOA_STAR_RECORD_COM_COUNT / \"NULLIF\" (TWOA_STAR_RECORD_COUNT, 0) TWOA_STAR_RECORD_INTEGRITY, " +
        "	STAR_RECORD_COM_COUNT / \"NULLIF\" (RECORD_COUNT, 0) RECORD_INTEGRITY " +
        " FROM( " +
        "		SELECT " +
        "			T_PERS.CODE, " +
        "			T_PERS.PERSON_COUNT, " +
        "			T_STAR.ONE_STAR_RECORD_COUNT, " +
        "			T_STAR.RECORD_COUNT, " +
        "			T_STAR.THREE_STAR_RECORD_COUNT, " +
        "			T_STAR.TWOA_STAR_RECORD_COUNT, " +
        "			T_STAR.TWO_STAR_RECORD_COUNT, " +
        "			T_COM.ONE_STAR_RECORD_COM_COUNT, " +
        "			T_COM.TWO_STAR_RECORD_COM_COUNT, " +
        "			T_COM.THREE_STAR_RECORD_COM_COUNT, " +
        "			T_COM.TWOA_STAR_RECORD_COM_COUNT, " +
        "			T_COM.STAR_RECORD_COM_COUNT " +
        "		FROM " +
        "			( " +
        "				SELECT " +
        "					pop.ORGAN_CODE CODE,  " +
        "					%1$s PERSON_COUNT " +
        "				FROM " +
        "				 BI_POPULACE pop "+
        "				WHERE " +
        "					  pop.COUNT_YEAR=:countYear AND ORGAN_PARENT_CODE=:orgCode "  +
        "						OR  ORGAN_CODE =:orgCode "+
        "				GROUP BY " +
        "					pop.ORGAN_CODE " +
        "			) T_PERS " +
        "LEFT JOIN   ( " +
        "		SELECT " +
        "			CODE, " +
        "			\"SUM\" (TOTAL) AS RECORD_COUNT, " +
        "			\"SUM\" (ONE) ONE_STAR_RECORD_COUNT, " +
        "			\"SUM\" (TWO) TWO_STAR_RECORD_COUNT, " +
        "			\"SUM\" (THREE) THREE_STAR_RECORD_COUNT, " +
        "			nvl(\"SUM\"(THREE),0)+nvl(\"SUM\"(TWO),0) TWOA_STAR_RECORD_COUNT " +
        "		FROM " +
        "			( " +
        "				SELECT " +
        "				INPUT_ORGAN_CODE	CODE, " +
        "					\"COUNT\" (1) TOTAL, " +
        "					CASE \"STAR\" WHEN 1 THEN \"COUNT\" (\"STAR\") END AS ONE, " +
        "					CASE \"STAR\" WHEN 2 THEN \"COUNT\" (\"STAR\") END AS TWO, " +
        "					CASE \"STAR\" WHEN 3 THEN \"COUNT\" (\"STAR\") END AS THREE " +
        "				FROM	 " +
        "					 BI_PERSON_INFO WHERE INPUT_CENTER_ORGAN_CODE  = :orgCode  AND  FILING_FLAG='1' %2$s  " +
        "				GROUP BY " +
        "					INPUT_ORGAN_CODE, " +
        "					STAR " +
        "					) " +
        "			GROUP BY CODE " +
        "	) T_STAR ON T_STAR.CODE = T_PERS.CODE " +
        "LEFT JOIN ( " +
        "	SELECT " +
        "			CODE, " +
        "			\"SUM\" (ONE_COM) ONE_STAR_RECORD_COM_COUNT, " +
        "			\"SUM\" (TWO_COM) TWO_STAR_RECORD_COM_COUNT, " +
        "			\"SUM\" (THREE_COM) THREE_STAR_RECORD_COM_COUNT, " +
        "			nvl(\"SUM\"(THREE_COM),0)+nvl(\"SUM\"(TWO_COM),0) TWOA_STAR_RECORD_COM_COUNT, " +
        "			nvl(\"SUM\"(THREE_COM),0)+nvl(\"SUM\"(TWO_COM),0)+nvl(\"SUM\"(ONE_COM),0) STAR_RECORD_COM_COUNT " +
        "		FROM " +
        "			( " +
        "				SELECT " +
        "				INPUT_ORGAN_CODE	CODE, " +
        "					CASE \"STAR\" WHEN 1 THEN \"COUNT\" (\"STAR\") END AS ONE_COM, " +
        "					CASE \"STAR\" WHEN 2 THEN \"COUNT\" (\"STAR\") END AS TWO_COM, " +
        "					CASE \"STAR\" WHEN 3 THEN \"COUNT\" (\"STAR\") END AS THREE_COM " +
        "				FROM " +
        "					 BI_PERSON_INFO WHERE INPUT_CENTER_ORGAN_CODE = :orgCode  AND FILING_FLAG='1'  AND \"INTEGRITY\">0.99   %2$s   " +
        "				GROUP BY " +
        "					INPUT_ORGAN_CODE, " +
        "					STAR " +
        "					) " +
        "			GROUP BY CODE " +
        ") T_COM ON T_COM.CODE = T_STAR.CODE  )temp ORDER BY CODE ";

    static final String RECORD_STATIC_SQL=
        "SELECT " +
            "	POP.GBCODE CODE, " +
            "	POP.PERSON_COUNT, " +
            "	POP.HOUSEHOLD_PERSON_COUNT, " +
            "	POP.UNHOUSEHOLD_PERSON_COUNT, " +
            "	REC.RECORD_COUNT, " +
            "	REC.HOUSEHOLD_RECORD_COUNT, " +
            "	REC.UNHOUSEHOLD_RECORD_COUNT, " +
            "	REC.RECORD_COUNT / \"NULLIF\" (POP.PERSON_COUNT, 0) RECORD_OCCUPANCY, " +
            "	REC.HOUSEHOLD_RECORD_COUNT / \"NULLIF\" (POP.HOUSEHOLD_PERSON_COUNT,0) HOUSEHOLD_RECORD_OCCUPANCY, " +
            "	REC.UNHOUSEHOLD_RECORD_COUNT / \"NULLIF\" ( POP.UNHOUSEHOLD_PERSON_COUNT, 0 ) UNHOUSEHOLD_RECORD_OCCUPANCY " +
            " FROM " +
            "(SELECT " +
            "		POP.GBCODE,\"SUM\" (POP.HOUSEHOLD_NUM) + \"SUM\" (POP.UN_HOUSE_HOLD_NUM)   PERSON_COUNT, " +
            "	\"SUM\" (POP.HOUSEHOLD_NUM) HOUSEHOLD_PERSON_COUNT, " +
            "	\"SUM\" (POP.UN_HOUSE_HOLD_NUM) UNHOUSEHOLD_PERSON_COUNT " +
            "	FROM  BI_POPULACE POP  WHERE POP.GBCODE IS NOT NULL AND POP.COUNT_YEAR=:countYear  " +
            "	GROUP BY " +
            "		POP.GBCODE " +
            ") POP " +
            "LEFT JOIN  " +
            "( " +
            "SELECT " +
            "	INPUT_GBCODE, " +
            "	\"SUM\" (UNHOUSEHOLD_RECORD_COUNT) UNHOUSEHOLD_RECORD_COUNT, " +
            "	\"SUM\"(RECORD_COUNT) RECORD_COUNT, " +
            "	\"SUM\"(RECORD_COUNT)-\"NVL\"(\"SUM\" (UNHOUSEHOLD_RECORD_COUNT),0) HOUSEHOLD_RECORD_COUNT " +
            "FROM " +
            "	( " +
            "		SELECT " +
            "			INPUT_GBCODE, " +
            "			HOUSEHOLD_TYPE, " +
            "			\"COUNT\"(1) RECORD_COUNT , " +
            "			CASE \"HOUSEHOLD_TYPE\" 	WHEN '2' THEN \"COUNT\"(HOUSEHOLD_TYPE) END AS UNHOUSEHOLD_RECORD_COUNT " +
            "		FROM " +
            "						BI_PERSON_INFO WHERE INPUT_GBCODE IS NOT NULL AND  FILING_FLAG='1' %1$s  " +
            "		GROUP BY " +
            "			INPUT_GBCODE, " +
            "			HOUSEHOLD_TYPE " +
            "	) " +
            "GROUP BY " +
            "	INPUT_GBCODE " +
            ") REC ON POP.GBCODE= REC.INPUT_GBCODE ORDER BY CODE";
    static final String ORG_RECORD_STATIC_SQL=
        "SELECT " +
            "	POP.ORGAN_CODE CODE , " +
            "	POP.PERSON_COUNT, " +
            "	POP.HOUSEHOLD_PERSON_COUNT, " +
            "	POP.UNHOUSEHOLD_PERSON_COUNT, " +
            "	REC.RECORD_COUNT, " +
            "	REC.HOUSEHOLD_RECORD_COUNT, " +
            "	REC.UNHOUSEHOLD_RECORD_COUNT, " +
            "	REC.RECORD_COUNT / \"NULLIF\" (POP.PERSON_COUNT, 0) RECORD_OCCUPANCY, " +
            "	REC.HOUSEHOLD_RECORD_COUNT / \"NULLIF\" (POP.HOUSEHOLD_PERSON_COUNT,0) HOUSEHOLD_RECORD_OCCUPANCY, " +
            "	REC.UNHOUSEHOLD_RECORD_COUNT / \"NULLIF\" ( POP.UNHOUSEHOLD_PERSON_COUNT, 0 ) UNHOUSEHOLD_RECORD_OCCUPANCY " +
            " FROM " +
            "( " +
            "				SELECT " +
            "					POP.ORGAN_CODE ,  " +
            "					\"SUM\" (HOUSEHOLD_NUM) + \"SUM\" (UN_HOUSE_HOLD_NUM)  PERSON_COUNT, " +
            "					\"SUM\" (POP.HOUSEHOLD_NUM) HOUSEHOLD_PERSON_COUNT, " +
            "					\"SUM\" (POP.UN_HOUSE_HOLD_NUM) UNHOUSEHOLD_PERSON_COUNT " +
            "				FROM " +
            "			         BI_POPULACE POP" +
            "				WHERE " +
            "					POP.COUNT_YEAR=:countYear AND POP.ORGAN_PARENT_CODE =:orgCode OR ORGAN_CODE =:orgCode " +
            "				GROUP BY " +
            "					POP.ORGAN_CODE " +
            "				 " +
            ") POP " +
            "LEFT JOIN  " +
            "( " +
            "SELECT " +
            "	INPUT_ORGAN_CODE, " +
            "	\"SUM\" (UNHOUSEHOLD_RECORD_COUNT) UNHOUSEHOLD_RECORD_COUNT, " +
            "	\"SUM\"(RECORD_COUNT) RECORD_COUNT, " +
            "	\"SUM\"(RECORD_COUNT)-\"NVL\"(\"SUM\" (UNHOUSEHOLD_RECORD_COUNT),0) HOUSEHOLD_RECORD_COUNT " +
            "FROM " +
            "	( " +
            "		SELECT " +
            "			INPUT_ORGAN_CODE, " +
            "			HOUSEHOLD_TYPE, " +
            "			\"COUNT\"(1) RECORD_COUNT , " +
            "			CASE \"HOUSEHOLD_TYPE\" 	WHEN '2' THEN \"COUNT\"(HOUSEHOLD_TYPE) END AS UNHOUSEHOLD_RECORD_COUNT " +
            "		FROM BI_PERSON_INFO WHERE INPUT_CENTER_ORGAN_CODE = :orgCode AND FILING_FLAG='1' %1$s  " +
            "		GROUP BY " +
            "			INPUT_ORGAN_CODE, " +
            "			HOUSEHOLD_TYPE " +
            "	) " +
            "GROUP BY " +
            "	INPUT_ORGAN_CODE " +
            ") REC ON POP.ORGAN_CODE= REC.INPUT_ORGAN_CODE ORDER BY CODE";
    static final String RECORD_STATIC_SQL_CENTERE=
        "with orgs as (select organ_code from MDM_ORGANIZATION\n" +
            "where GENRE_CODE in ('B100', 'C'))\n" +
            "SELECT\n" +
            "    pop.ORGAN_PARENT_CODE code,\n" +
            "    pop.person_count,\n" +
            "    pop.household_person_count,\n" +
            "    pop.unhousehold_person_count,\n" +
            "    rec.record_count,\n" +
            "    rec.household_record_count,\n" +
            "    rec.unhousehold_record_count,\n" +
            "    rec.record_count / \"NULLIF\"(pop.person_count,0) record_occupancy,\n" +
            "    rec.household_record_count / \"NULLIF\"(pop.household_person_count,0) household_record_occupancy,\n" +
            "    rec.unhousehold_record_count / \"NULLIF\"(pop.unhousehold_person_count,0) unhousehold_record_occupancy\n" +
            "FROM\n" +
            "    (select ORGAN_PARENT_CODE, person_count,\n" +
            "    household_person_count,unhousehold_person_count\n" +
            "    from orgs left join(\n" +
            "        SELECT\n" +
            "            ORGAN_PARENT_CODE,\n" +
            "            \"SUM\"(household_num) + \"SUM\"(un_house_hold_num) person_count,\n" +
            "            \"SUM\"(household_num) household_person_count,\n" +
            "            \"SUM\"(un_house_hold_num) unhousehold_person_count\n" +
            "            from( \n" +
            "            select \n" +
            "                case when t_org.GENRE_CODE = 'B100' or t_org.GENRE_CODE = 'C' then pop.ORGAN_CODE else t_org.PARENT_CODE end ORGAN_PARENT_CODE,\n" +
            "                    HOUSEHOLD_NUM, UN_HOUSE_HOLD_NUM \n" +
            "                FROM\n" +
            "                    bi_populace pop\n" +
            "                left join MDM_ORGANIZATION t_org on t_org.organ_code = pop.ORGAN_CODE\n" +
            "                WHERE\n" +
            "                    (pop.ORGAN_PARENT_CODE in (select * from orgs) or pop.ORGAN_CODE in (select * from orgs))\n" +
            "                    AND pop.count_year =:countYear)\n" +
            "             GROUP BY\n" +
            "            ORGAN_PARENT_CODE) on orgs.organ_code = ORGAN_PARENT_CODE\n" +
            "    ) pop\n" +
            "    LEFT JOIN (\n" +
            "        SELECT\n" +
            "            INPUT_CENTER_ORGAN_CODE,\n" +
            "            \"SUM\"(unhousehold_record_count) unhousehold_record_count,\n" +
            "            \"SUM\"(record_count) record_count,\n" +
            "            \"SUM\"(record_count) - \"NVL\"(\"SUM\"(unhousehold_record_count),0) household_record_count\n" +
            "        FROM\n" +
            "            (\n" +
            "                SELECT\n" +
            "                    INPUT_CENTER_ORGAN_CODE,\n" +
            "                    household_type,\n" +
            "                    \"COUNT\"(1) record_count,\n" +
            "                    CASE \"HOUSEHOLD_TYPE\"\n" +
            "                            WHEN '2'   THEN \"COUNT\"(household_type)\n" +
            "                        END\n" +
            "                    AS unhousehold_record_count\n" +
            "                FROM(select \n" +
            "                           case when t_org.GENRE_CODE = 'B100' or t_org.GENRE_CODE = 'C' then per.INPUT_ORGAN_CODE else t_org.PARENT_CODE end INPUT_CENTER_ORGAN_CODE,\n" +
            "                                household_type\n" +
            "                        FROM\n" +
            "                    bi_person_info per\n" +
            "                    left join MDM_ORGANIZATION t_org on t_org.organ_code = per.INPUT_ORGAN_CODE\n" +
            "                        WHERE\n" +
            "                    (INPUT_CENTER_ORGAN_CODE in (select * from orgs) or INPUT_ORGAN_CODE in (select * from orgs))\n" +
            "                    AND filing_flag = '1' %1$s)\n" +
            "                GROUP BY\n" +
            "                    INPUT_CENTER_ORGAN_CODE,\n" +
            "                    household_type\n" +
            "            )\n" +
            "        GROUP BY\n" +
            "            INPUT_CENTER_ORGAN_CODE\n" +
            "    ) rec ON pop.ORGAN_PARENT_CODE = rec.INPUT_CENTER_ORGAN_CODE where pop.ORGAN_PARENT_CODE is not null \n" +
            "ORDER BY\n" +
            "    code";
}
