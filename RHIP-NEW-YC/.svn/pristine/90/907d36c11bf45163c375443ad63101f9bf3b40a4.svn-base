/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.constants.CoreConstants;
import com.founder.fasf.thread.NamedInheritableThreadLocal;
import com.founder.fasf.thread.NamedThreadLocal;

/**
 * Date Utility Class used to convert Strings to Dates and Timestamps
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler </a> to correct time
 *         pattern. Minutes should be mm not MM (MM is month).
 */
public class DateUtil extends BaseUtil {//private static Logger log = Logger.getLogger(DateUtil.class);
	
	private static final String FORMATER = "yyyy/MM/dd";

	private static final String TIME_PATTERN = "HH:mm";

	private static final ThreadLocal<Locale> localeContextHolder = new NamedThreadLocal<Locale>("Locale context");

	private static final ThreadLocal<Locale> inheritableLocaleContextHolder = new NamedInheritableThreadLocal<Locale>("Locale context");

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private DateUtil() {
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Calendar getToday() {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDateFormat());
		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(parseSimpleDate(todayAsString,getDateFormat()));
		return cal;
	}



	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDateFormat() {
		Locale locale = localeContextHolder.get();
		if (locale == null) {
			locale = inheritableLocaleContextHolder.get();
		}
		
		if(locale == null){
			locale = Locale.CHINA;	
		}
		String defaultDatePattern;
		try {
			defaultDatePattern = ResourceBundle.getBundle(CoreConstants.BUNDLE_KEY, locale).getString("date.format");
		} catch (MissingResourceException mse) {
			defaultDatePattern = "MM/dd/yyyy";
		} catch (NullPointerException mse) {
			defaultDatePattern = "MM/dd/yyyy";
		}
		return defaultDatePattern;
	}

	public static String getDateTimeFormat() {
		return DateUtil.getDateFormat() + " HH:mm:ss.S";
	}





	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static String toDateString(Date aDate,String format) {
		SimpleDateFormat df;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(StringUtils.isBlank(format) ? getDateFormat() : format);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}
	


    

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    
    /**
     * Return default datePattern (MM/dd/yyyy)
     * @return a string representing the date pattern on the UI
     */
//    public static String getDatePattern() {
//        Locale locale = LocaleContextHolder.getLocale();
//        String defaultDatePattern;
//        try {
//           defaultDatePattern = ResourceBundle.getBundle(CoreConstants.BUNDLE_KEY, locale).getString("date.format");
//        } catch (MissingResourceException mse) {
//            defaultDatePattern = "yyyy/MM/dd";
//        }
//
//        return defaultDatePattern;
//    }
    
    
    /** 
    * @Title: lastDateOfMonth 
    * @Description: 传入日期获取当月的最后一天
    * @param @param date
    * @param @return
    * @return Date
    * @throws 
    */
    public static Date lastDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 2;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		
		Date lastDate = new Date(first.getTime() - 1);
		return lastDate;
	}
    
    /** 
    * @Title: lastTimeOfDay 
    * @Description: 传入日期获取当天的最后时刻
    * @param @param date
    * @param @return
    * @return Date
    * @throws 
    */
    public static Date lastTimeOfDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH) + 1; 
		
		String dateString = year + "/" + month + "/" + day + " 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		
		Date lastDate = new Date(first.getTime() - 1);
		return lastDate;
	}
    
    /** 
    * @Title: lastTimeOfDay 
    * @Description: 传入日期获取当天的00时刻
    * @param @param date
    * @param @return
    * @return Date
    * @throws 
    */
    public static Date firstTimeOfDay(Date date){
    	String dateString = DateUtil.getDateTime("yyyy/MM/dd", date);
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd");
		return first;
	}
	
	/** 
	* @Title: firstDateOfMonth 
	* @Description: 传入日期获取当月的第一天
	* @param @param date
	* @param @return
	* @return Date
	* @throws 
	*/
    public static Date firstDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		return first;
	}
    
    /** 
	* @Title: firstDateOfMonth 
	* @Description: 传入日期获取当年的第一天
	* @param @param date
	* @param @return
	* @return Date
	* @throws 
	*/
    public static Date firstDateOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		
		String dateString = year + "/01/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		return first;
	}
    
    /** 
	* @Title: firstDateOfMonth 
	* @Description: 传入日期获取当年的最后一天
	* @param @param date
	* @param @return
	* @return Date
	* @throws 
	*/
    public static Date lastDateOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR) + 1;
		
		String dateString = year + "/01/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		Date lastDate = new Date(first.getTime() - 1);
		return lastDate;
	}
    
    /**
     * return age
     * @param birthday
     * @param specifiedDate
     * @return
     */
    public static String getAge(Date birthday, Date specifiedDate) {
    	int year = 0;
    	int month = 0;
    	int day = 0;
    	if (birthday == null) {
    		log.error("birthday is null!");
    	} else {
    		Calendar date = Calendar.getInstance();
    		Calendar now = Calendar.getInstance();
    		if (specifiedDate != null) {
    			if (birthday.compareTo(specifiedDate) > 0) {
					log.error("specified date is less than the birthday! ");
				} else {
					now.setTime(specifiedDate);
				}
			}
    		date.setTime(birthday);
    	    day = now.get(Calendar.DAY_OF_MONTH) - date.get(Calendar.DAY_OF_MONTH);
    	    month = now.get(Calendar.MONTH) - date.get(Calendar.MONTH);
    	    year = now.get(Calendar.YEAR) - date.get(Calendar.YEAR);
    	    if(day<0){
    	    	month -= 1;
    	    	now.add(Calendar.MONTH, -1);
    	    	day = day + now.getActualMaximum(Calendar.DAY_OF_MONTH);
    	    }
    	    if(month<0){
    	    	month = (month+12)%12;
    	    	year--;
    	    }
    	}
    	
    	if(year == 0 && month != 0) {
    		return String.valueOf(month) + "月";
    	} else if ((year == 0 && month == 0)) {
    		return String.valueOf(day) + "天";
    	} else {
    		return String.valueOf(year) + "岁";
    	}
    }

    
    /**
	 * 根据日期获取时星期几
	 * @param date
	 * @return
	 */
	public static String getWeekByDate(Date date) {
		
		if (ObjectUtil.isNotEmpty(date)) {
			log.error("date is null!");
		}
		Calendar calendar = Calendar.getInstance();//获得一个日历
	    calendar.setTime(date);//设置当前时间,月份是从0月开始计算
	    int number = calendar.get(Calendar.DAY_OF_WEEK);//星期表示1-7，是从星期日开始，   
	    String [] str = {"","日","一","二","三","四","五","六",};
	    
	    return str[number];
	}
	
	
	/**
	 * 获取day天后日期类型
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getAfterDay(Date date, int day) {
		if (null == date && day <= 0) return date;
		return new Date(date.getTime()+ day * 24 * 60 * 60 * 1000);
	}

	/**
	 * 当前日期xx天后的日期 或者XX天前的日期
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getDaysLater(Date date,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	/**
	 * 当前日期xx月后的日期 或者XX月前的日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getMonthsLater(Date date,int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}
	
	/**
	 * 当前日期xx月后的日期 或者XX月前的日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getYearsLater(Date date,int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		return calendar.getTime();
	}
	
	/**
	 * 获取day天前日期
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getBeforeDay(Date date, int day) {
		if (null == date && day >=0) {
			return date;
		}
		return new Date(date.getTime() - day * 24 * 60 * 60 * 1000);
	}
	
	/**
	 * 获取day天后日期类型
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date convertDate(String fmt,Date aDate) {
		return parseSimpleDate(getDateTime(fmt,aDate),fmt);
	}
	
	public static Date parseSimpleDate(String dateStr, String formater) {
		Date date = null;
		if (null == dateStr || dateStr.trim().length() < 1) {
			return null;
		}
		if (log.isDebugEnabled()) {
			log.debug("converting '" + dateStr + "' to date with mask '" + formater + "'");
		}
		SimpleDateFormat format = new SimpleDateFormat(StringUtils.isBlank(formater) ? FORMATER : formater);
		try {
			date =  format.parse(dateStr);
		} catch (ParseException e) {
			log.error("Could not convert '" + dateStr + "' to a date, throwing exception");
			e.printStackTrace();
		}
		return date;
	}





	/**
	 * 根据年龄计算出生日期
	 * 
	 * @param age
	 * @param type
	 * @return
	 */
	public static Date getBirthdayByAge(int age) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 0 - age);
		return cal.getTime();
	}

	/**
	 * 根据年龄计算出生年份
	 * 
	 * @param age
	 * @param type
	 * @return
	 */
	public static int getBirthYearByAge(int age) {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) - age;
	}

	/**
	 * 根据生日获得年龄
	 * 
	 * @param birthday
	 * @return
	 */
	public static int getAgeByBirthday(Date birthday) {
		if (null == birthday) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;//注意此处，如果不加1的话计算结果是错误的
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				//monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				} else {
					//do nothing
				}
			} else {
				//monthNow>monthBirth
				age--;
			}
		} else {
			//monthNow<monthBirth
			//donothing
		}
		return age;
	}
	
	/**
	 * 根据生日获得年龄
	 * 返回年龄是整周岁后者半周岁，例如（14周岁，14.5周岁）
	 * @param birthday
	 * @return
	 */
	public static double getAgeByBirthday(Date birthday, Date now) {
		if (null == birthday || null == now ) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(now);
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH)+1;
		int dayNow = cal.get(Calendar.DAY_OF_MONTH); 
		
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH)+1;
		int dayBirth = cal.get(Calendar.DAY_OF_MONTH);
		
		double age =  yearNow -  yearBirth;
		if (monthNow == monthBirth) {
			if (dayNow < dayBirth) {
				age = age - 0.5;
			}
		} else if (monthNow < monthBirth) {
			int monthDiff = monthBirth - monthNow;
			if (monthDiff > 6) {
				age = age - 1;
			} else if(monthDiff == 6) {
				if (dayNow < dayBirth) {
					age = age - 1;
				} else {
					age = age - 0.5;
				}
			}  else {
				age = age - 0.5;
			}
		} else {
			int monthDiff = monthNow - monthBirth;
			if (monthDiff > 6) {
				age = age + 0.5;
			} else if(monthDiff == 6) {
				if (dayNow >= dayBirth) {
					age = age + 0.5;
				}
			}
		}
		return age;
	}

	/**
	 * 根据时间段拼装查询条件
	 * 
	 * @param criteria
	 *            查询条件
	 * @param property
	 *            属性名
	 * @param bDate
	 *            开始时间
	 * @param eDate
	 *            结束时间
	 */
	public static void getCriteriaByDateRange(Criteria criteria, String property, Date bDate, Date eDate) {

		// 开始时间不为空，结束时间为空
		if (bDate != null && eDate == null)
			criteria.add(property, OP.GE, makeTimeToZero(bDate));
		if (bDate != null && eDate != null) {
			Object[] obj = new Object[2];
			obj[0] = makeTimeToZero(bDate);
			obj[1] = makeTimeToMax(eDate);
			criteria.add(property, OP.BETWEEN, obj);
		}
		if (bDate == null && eDate != null)
			criteria.add(property, OP.LE, makeTimeToMax(eDate));
	}

	/**
	 * 根据出生年拼装查询条件
	 * 
	 * @param criteria
	 *            查询条件
	 * @param property
	 *            属性名
	 * @param bDate
	 *            开始时间
	 * @param eDate
	 *            结束时间
	 */
	public static void getCriteriaByYearRange(Criteria criteria, String property, int bYear, int eYear) {
		if (bYear == -1 && eYear != -1)
			getCriteriaByDateRange(criteria, property, null, getDateByYearMonthDay(eYear, 11, 31));
		if (bYear != -1 && eYear != -1)
			getCriteriaByDateRange(criteria, property, getDateByYearMonthDay(bYear, 0, 1), getDateByYearMonthDay(eYear, 11, 31));
		if (bYear != -1 && eYear == -1)
			getCriteriaByDateRange(criteria, property, getDateByYearMonthDay(bYear, 0, 1), null);
	}

	public static Date getDateByYearMonthDay(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

	/**
	 * 获取两个日期间隔天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static int getBetweenDays(Date before, Date after) {
		Calendar start = Calendar.getInstance();
		start.setTime(before);
		Calendar end = Calendar.getInstance();
		end.setTime(after);
		return getDaysBetween(start, end);
	}

	/**
	 * 获取两个日期间隔天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDaysBetween(Calendar start, Calendar end) {
		if (start.after(end)) {
			Calendar swap = start;
			start = end;
			end = swap;
		}
		int days = end.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR);
		int y2 = end.get(Calendar.YEAR);
		if (start.get(Calendar.YEAR) != y2) {
			start = (Calendar) start.clone();
			do {
				days += start.getActualMaximum(Calendar.DAY_OF_YEAR);
				start.add(Calendar.YEAR, 1);
			} while (start.get(Calendar.YEAR) != y2);
		}
		return days + 1;
	}

	/**
	 * 将Data中时间部分变为0
	 * 
	 * @param date
	 * @return
	 */
	public static Date makeTimeToZero(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		makeTimeToZero(calendar);
		return calendar.getTime();
	}

	public static void makeTimeToZero(Calendar calendar) {
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		calendar.set(Calendar.AM_PM,0);
	}
	
	/**
	 * 将Data中时间部分变为最大
	 * 
	 * @param date
	 * @return
	 */
	public static Date makeDateToZero(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		makeDateToZero(calendar);
		return calendar.getTime();
	}

	public static void makeDateToZero(Calendar calendar) {
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		makeTimeToZero(calendar);
	}
	
	/**
	 * 将Data中时间部分变为最大
	 * 
	 * @param date
	 * @return
	 */
	public static Date makeDateToMax(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		makeDateToMax(calendar);
		return calendar.getTime();
	}

	public static void makeDateToMax(Calendar calendar) {
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		makeTimeToZero(calendar);
	}

	/**
	 * 将Data中时间部分变为最大
	 * 
	 * @param date
	 * @return
	 */
	public static Date makeTimeToMax(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		makeTimeToMax(calendar);
		return calendar.getTime();
	}

	public static void makeTimeToMax(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */
	public static Date getCurrentWithoutTime() {
		Date current = new Date();
		return makeTimeToZero(current);
	}

	/**
	 * 生成日期字符串列表
	 * 
	 * @param fromDate
	 * @param days
	 * @return
	 */
	public static List<String> makeDayList(Date fromDate, int days) {
		return makeDayList(fromDate, "yyyy-MM-dd", days);
	}

	/**
	 * 生成日期字符串列表
	 * 
	 * @param fromDate
	 * @param pattern
	 * @param days
	 * @return
	 */
	public static List<String> makeDayList(Date fromDate, String pattern, int days) {
		List<String> weeks = new ArrayList<String>();
		for (int i = 0; i < days; i++) {
			weeks.add(DateUtil.getDateTime(pattern, add(fromDate, Calendar.DAY_OF_MONTH, i)));
		}
		return weeks;
	}

	/**
	 * 计算周数
	 * 
	 * @param fromDate
	 * @param pattern
	 * @param days
	 * @return
	 */
	public static int getWeeks(int days) {
		return days % 7 == 0 ? days / 7 : days / 7 + 1;
	}

	public static void setStartDateRange(Criteria criteria, String type, String per) {
		// 时间间隔
		if ("1".equals(type)) {
			// 最近三个
			criteria.add(per, OP.GE, add(getCurrentWithoutTime(), Calendar.MONTH, -3));
		} else if ("2".equals(type)) {
			// 最近一年
			criteria.add(per, OP.GE, add(getCurrentWithoutTime(), Calendar.YEAR, -1));
		}
	}

	/**
	 * 获取份的日期范围
	 * 
	 * @param month
	 * @return
	 */
	public static Date[] getDateRangeByMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		makeTimeToZero(calendar);
		Date startDate = calendar.getTime();
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), maxDay, 23, 59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		Date endDate = calendar.getTime();
		return new Date[] { startDate, endDate };
	}

	/**
	 * 返回季节范围
	 * @param season
	 * @return
	 */
	public static Date[] getDateRangeBySeason(int season) {

		// 一：11号，331号
		// 二：41号，630号
		// 三：71号，930号
		// 四：101号，1231号

		Date startDate = null;
		Date endDate = null;

		int month = 0;
		int monthEnd = 0;
		int day = 1;
		switch (season) {
		case 1:
			month = Calendar.JANUARY;
			monthEnd = Calendar.MARCH;
			day = 31;
			break;
		case 2:
			month = Calendar.APRIL;
			monthEnd = Calendar.JUNE;
			day = 30;
			break;
		case 3:
			month = Calendar.JULY;
			monthEnd = Calendar.SEPTEMBER;
			day = 30;
			break;

		default:
			month = Calendar.OCTOBER;
			monthEnd = Calendar.DECEMBER;
			day = 31;
			break;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		makeTimeToZero(calendar);
		startDate = calendar.getTime();
		calendar.set(Calendar.MONTH, monthEnd);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		makeTimeToMax(calendar);
		endDate = calendar.getTime();
		return new Date[] { startDate, endDate };
	}

	/**
	 * 返回年日期范围
	 * @param year
	 * @return
	 */
	public static Date[] getDateRangeByYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		makeTimeToZero(calendar);
		Date startDate = calendar.getTime();
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		makeTimeToMax(calendar);
		Date endDate = calendar.getTime();
		return new Date[] { startDate, endDate };
	}

	/**
	 * 返回统计年范围
	 * @param year
	 * @return
	 */
	public static Date[] getDateRangeByYearStatistics(int year) {
		// 统计年
		// 10 月 1 日到次年9月 30日
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year - 1);
		calendar.set(Calendar.MONTH, Calendar.OCTOBER);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		makeTimeToZero(calendar);
		Date startDate = calendar.getTime();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		makeTimeToMax(calendar);
		Date endDate = calendar.getTime();
		return new Date[] { startDate, endDate };
	}

	/**
	 * 返回日期范围
	 * @param start
	 * @param end
	 * @return
	 */
	public static Date[] getDateRange(String start, String end) {
		Date startDate = parseSimpleDate(start,FORMATER);
		if (null != startDate) {
			startDate = makeTimeToZero(startDate);
		}
		Date endDate = parseSimpleDate(end,FORMATER);
		if (null != endDate) {
			endDate = makeTimeToMax(endDate);
		}
		return new Date[] { startDate, endDate };
	}

	/**
	 * 返回年龄日期范围
	 * @param start
	 * @param end
	 * @return
	 */
	public static Date[] getDateRangeByAge(String start, String end) {
		int startAge = 0;
		try {
			startAge = Integer.parseInt(start);
		} catch (Exception e) {
			startAge = -1;
		}

		int endAge = 0;
		try {
			endAge = Integer.parseInt(end);
		} catch (Exception e) {
			endAge = -1;
		}

		Date startDate = null;
		Date endDate = null;
		if (-1 != startAge) {
			endDate = makeDateToMax(getBirthdayByAge(startAge));
		}

		if (-1 != endAge) {
			startDate = makeDateToZero(getBirthdayByAge(endAge));
		}
		return new Date[] { startDate, endDate };
	}

	/**
	 * 季节大写
	 * @return
	 */
	public static Map<Integer, String> getSeasonMap() {
		Map<Integer, String> month = new HashMap<Integer, String>();
		month.put(1, "一");
		month.put(2, "二");
		month.put(3, "三");
		month.put(4, "四");
		return month;
	}

	/**
	 * 月份大写
	 * @return
	 */
	public static Map<Integer, String> getMonthMap() {
		Map<Integer, String> month = new HashMap<Integer, String>();
		month.put(Calendar.JANUARY, "一");
		month.put(Calendar.FEBRUARY, "二");
		month.put(Calendar.MARCH, "三");
		month.put(Calendar.APRIL, "四");
		month.put(Calendar.MAY, "五");
		month.put(Calendar.JUNE, "六");
		month.put(Calendar.JULY, "七");
		month.put(Calendar.AUGUST, "八");
		month.put(Calendar.SEPTEMBER, "九");
		month.put(Calendar.OCTOBER, "十");
		month.put(Calendar.NOVEMBER, "十一");
		month.put(Calendar.DECEMBER, "十二");
		return month;
	}

	/**
	 * 获取指定之前年列表
	 * @param count
	 * @return
	 */
	public static List<Integer> getBeforeYears(int count) {
		List<Integer> years = new ArrayList<Integer>();
		int year = getCurrentYear();
		for (int i = 0; i <= count; i++) {
			years.add(year--);
		}
		return years;
	}

	/**
	 * 当前年
	 * @return
	 */
	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 当前年
	 * @return
	 */
	public static int getDateYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

    /**
     * 获取时间项
     * @return
     */
    public static int getField(Date date, int field){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int value = calendar.get(field);
        return value;
    }

	/**
	 * 日期计算
	 * @param date
	 * @param calendarField
	 * @param amount
	 * @return
	 */
	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}
	
	/**
	 * 根据出生年拼装查询条件，精确到月日
	 */
	public static void getCriteriaByYear(Criteria criteria, String property, int bYear, int eYear) {
		if (bYear == -1 && eYear != -1)
			getCriteriaByDateRange(criteria, property, null, getDateByYear(eYear));
		if (bYear != -1 && eYear != -1)
			getCriteriaByDateRange(criteria, property, getDateByYear(bYear), getDateByYear(eYear));
		if (bYear != -1 && eYear == -1)
			getCriteriaByDateRange(criteria, property, getDateByYear(bYear), null);
	}

	public static Date getDateByYear(int year) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
//		c.set(Calendar.MONTH, month);
//		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

    /**
     * 返回季节范围
     * @param season
     * @return
     */
    public static Date[] getDateRangeByYearAndSeason(int year, int season) {

        // 一：11号，331号
        // 二：41号，630号
        // 三：71号，930号
        // 四：101号，1231号

        Date startDate = null;
        Date endDate = null;

        int month = 0;
        int monthEnd = 0;
        int day = 1;
        switch (season) {
            case 1:
                month = Calendar.JANUARY;
                monthEnd = Calendar.MARCH;
                day = 31;
                break;
            case 2:
                month = Calendar.APRIL;
                monthEnd = Calendar.JUNE;
                day = 30;
                break;
            case 3:
                month = Calendar.JULY;
                monthEnd = Calendar.SEPTEMBER;
                day = 30;
                break;

            default:
                month = Calendar.OCTOBER;
                monthEnd = Calendar.DECEMBER;
                day = 31;
                break;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        makeTimeToZero(calendar);
        startDate = calendar.getTime();
        calendar.set(Calendar.MONTH, monthEnd);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        makeTimeToMax(calendar);
        endDate = calendar.getTime();
        return new Date[] { startDate, endDate };
    }

    /**
     * 格式化日期显示
     * @param millis
     * @return
     */
    public static String formatTime(long millis) {
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
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     *
     * @param aMask
     *            the date pattern the string is in
     * @param aDate
     *            a date object
     * @return a formatted string representation of the date
     *
     * @see java.text.SimpleDateFormat
     */
    public static String toFormatString(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    public static String convertDateToStringForDB(Date aDate) {
        return convertDateToString(aDate);
    }

    /**
     * Return default datePattern (MM/dd/yyyy)
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        Locale locale = LocaleContextHolder.getLocale();
        String defaultDatePattern;
        try {
            defaultDatePattern = ResourceBundle.getBundle(CoreConstants.BUNDLE_KEY, locale).getString("date.format");
        } catch (MissingResourceException mse) {
            defaultDatePattern = "yyyy/MM/dd";
        }

        return defaultDatePattern;
    }

    public static Date parseDateString(String dateStr) {
        return parseSimpleDate(dateStr, FORMATER);
    }

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 *
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convert(String aMask, String strDate) {
		SimpleDateFormat df;
		Date date = null;
		/*if (strDate.indexOf("-") > 0) {
			strDate = strDate.replace("-","/");
		}*/
		df = new SimpleDateFormat(aMask);
		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
		}
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate + "' to a date, throwing exception");
			pe.printStackTrace();
		}
		return date;
	}

    public static String getStringByDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(FORMATER);
        return format.format(date);
    }

    public static boolean isValidDate(String dateStr,String aMask){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(aMask);
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2004/02/29会被接受，并转换成2004/03/01
            dateFormat.setLenient(false);
            dateFormat.parse(dateStr);
            return true;
        }catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

	/**
	 * 根据日期获取其年份
	 * @return
	 */
	public static int getYearByDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

}
