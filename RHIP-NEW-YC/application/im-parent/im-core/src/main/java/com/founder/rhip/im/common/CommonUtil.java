package com.founder.rhip.im.common;

import com.founder.fasf.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtil {

	/**
	 * 转换年度、半年度、季度及月度
	 *
	 * @param dateStr
	 *            格式：YYYYMMDDHHMMSS 或 YYYYMMDD 或 YYYY-MM-DD 或 YYYY/MM/DD eg:
	 *            20151016 或 2015-10-16 或 2015/10/16
	 * @return [0]年度、[1]半年度、[2]季度、[3]月度
	 */
	public static int[] converToYearHalfYearQuarterMonth(String dateStr) {
		if (dateStr == null || dateStr.isEmpty()) {
			throw new NullPointerException("参数为空，请传入 'yyyyMMdd' 格式的日期字符串 .");
		}
		if (dateStr.indexOf("-") != -1) {
			dateStr = dateStr.replace("-", "");
		}
		if (dateStr.indexOf("/") != -1) {
			dateStr = dateStr.replace("/", "");
		}

		int[] a = new int[4];
		int y = Integer.valueOf(dateStr.substring(0, 4));
		int m = Integer.valueOf(dateStr.substring(4, 6));
		int q = 0;
		int hy = 0;
		if (m >= 1 && m <= 3) { // 1-3月
			q = 1;
			hy = 1;
		} else if (m >= 4 && m <= 6) {
			q = 2;
			hy = 1;
		} else if (m >= 7 && m <= 9) {
			q = 3;
			hy = 2;
		} else if (m >= 10 && m <= 12) {
			q = 4;
			hy = 2;
		} else {
			throw new IllegalArgumentException(" 日期参数 [" + dateStr + "] 的月份非法");
		}
		a[0] = y;
		a[1] = hy;
		a[2] = q;
		a[3] = m;
		return a;
	}

	/**
	 * 转换年度、半年度、季度及月度日度
	 *
	 * @param dateStr
	 *            格式：YYYYMMDDHHMMSS 或 YYYYMMDD 或 YYYY-MM-DD 或 YYYY/MM/DD eg:
	 *            20151016 或 2015-10-16 或 2015/10/16
	 * @return [0]年度、[1]半年度、[2]季度、[3]月度
	 */
	public static int[] converToYearHalfYearQuarterMonthDay(String dateStr) {
		if (dateStr == null || dateStr.isEmpty()) {
			throw new NullPointerException("参数为空，请传入 'yyyyMMdd' 格式的日期字符串 .");
		}
		if (dateStr.indexOf("-") != -1) {
			dateStr = dateStr.replace("-", "");
		}
		if (dateStr.indexOf("/") != -1) {
			dateStr = dateStr.replace("/", "");
		}

		int[] a = new int[5];
		int y = Integer.valueOf(dateStr.substring(0, 4));
		int m = Integer.valueOf(dateStr.substring(4, 6));
		int d = Integer.valueOf(dateStr.substring(6, 8));
		int q = 0;
		int hy = 0;
		if (m >= 1 && m <= 3) { // 1-3月
			q = 1;
			hy = 1;
		} else if (m >= 4 && m <= 6) {
			q = 2;
			hy = 1;
		} else if (m >= 7 && m <= 9) {
			q = 3;
			hy = 2;
		} else if (m >= 10 && m <= 12) {
			q = 4;
			hy = 2;
		} else {
			throw new IllegalArgumentException(" 日期参数 [" + dateStr + "] 的月份非法");
		}
		a[0] = y;
		a[1] = hy;
		a[2] = q;
		a[3] = m;
		a[4] = d;
		return a;
	}


	/**
	 * 转换日分组时间片，每组为某年某月某日
	 *
	 * @param startDate 格式：yyyyMMdd 或 yyyyMMddHhMM
	 * @param endDate 格式：yyyyMMdd 或 yyyyMMddHhMM
	 * @return List<String, String> , key = 月首日期 (格式：yyyyMMdd); value = 月尾日期(格式：yyyyMMdd);
	 */
	public static List<String> convertTimesliceForDayGroup(String startDate, String endDate) {
		if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
			if (Integer.valueOf(startDate) > Integer.valueOf(endDate)) {
				throw new IllegalArgumentException("参数 值不正确， startDate 不能比  endDate 大");
			}
			List<String> list = new ArrayList<String>();
			String startDateStr = getYyyyMmDdString(startDate);
			String endDateStr = getYyyyMmDdString(endDate);
			if (startDateStr.equals(endDateStr)) {//同年同月同日
				list.add(startDateStr);
			} else {
				int sYear = Integer.valueOf(startDateStr.substring(0, 4));
				int sMonth = Integer.valueOf(startDateStr.substring(4, 6));
				int eYear = Integer.valueOf(endDateStr.substring(0, 4));
				int eMonth = Integer.valueOf(endDateStr.substring(4, 6));
				int em = 12;
				String sYearMonth = startDateStr.substring(0, 6);
				String eYearMonth = endDateStr.substring(0, 6);
				int ssYear = sYear;
				for (int y = sYear; y <= eYear; y++) {
					if (y == eYear) {
						em = eMonth;
					}
					if (y > ssYear) {
						sMonth = 1;
					}
					for (int m = sMonth; m <= em; m++) {
						String k = getFirstDayOfMonth(y, m);
						String v = getLastDayOfMonth(y, m);
						String tempSym = k.substring(0, 6);
						if (sYearMonth.equals(tempSym)) {//开始年月相同
							k = startDateStr;
						} else if (eYearMonth.equals(tempSym)) {//结束的年月相同
							v = endDateStr;
						}
						int intk = Integer.valueOf(k);
						int intv = Integer.valueOf(v);
						for (int x = intk; x <= intv; x++) {
							list.add(String.valueOf(x));
						}
					}
				}
			}
			return list;
		} else {
			throw new NullPointerException("startDate 和 endDate 参数为空 .");
		}
	}

	/**
	 * 转换日期为字符串，结果为 YYYYMM 格式
	 *
	 * @param date
	 *            年月日
	 * @return 返回 YYYYMMDD 格式的日期字符串
	 */
	public static String getYyyyMmDdStringWithoutOnline(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	/**
	 * 转换日期为字符串，结果为 YYYYMM 格式
	 *
	 * @param date
	 *            年月日
	 * @return 返回 YYYYMMDD 格式的日期字符串
	 */
	public static String getYyyyMmDdStringYesterday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		String uploadDate = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return uploadDate;
	}
	/**
	 * 转换日期为字符串，结果为 yyyyMMdd 格式
	 *
	 * @param dateStr
	 *            格式 yyyyMMdd
	 * @return
	 */
	public static String getYyyyMmDdString(String dateStr) {
		return dateStr.substring(0, 8);
	}

	/**
	 * 转换日期为字符串，结果为 YYYYMMDD 格式
	 *
	 * @param date
	 *            年月日
	 * @return 返回 YYYYMMDD 格式的日期字符串
	 */
	public static int getYyyyMmDD(Date date) {
		return Integer.valueOf(DateUtil.getDateTime("yyyyMMdd", date));
	}

	/**
	 * 获得当前年度、半年度、季度及月度
	 *
	 * @author Bao Jingbin
	 * @return [0]年度、[1]半年度、[2]季度、[3]月度
	 */
	public static int[] getCurrentYearHalfYearQuarterMonth() {
		return converToYearHalfYearQuarterMonth(getYyyyMmDdString(DateUtil.getDateTime("yyyy-MM-dd", new Date())));
	}

	private static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);//月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
	}

	private static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);//月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
	}
}