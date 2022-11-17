package com.founder.fasf.log;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class LoggerUtil
{
    /**
     * 缩进字符
     */
    private static String indent = "\t";

    private static final int RECURRENCE_LEVEL = 10;

    private static final Pattern FIELD_NAME_PATTERN = Pattern.compile("^[a-z][a-zA-Z0-9]*$");

    /**
     * 防止实例化对象
     */
    private LoggerUtil()
    {

    }

    public static void debug(Object message)
    {
        DebugLogger.log(message);
    }

    public static void info(Object message)
    {
        InfoLogger.log(message);
    }

    public static void performance(Object message)
    {
        PerformanceLogger.log(message);
    }

    /**
     * 生成参数形式的日志内容
     * @param 日志标题
     * @param params 需要输出的参数列表
     * @return 生成的日志内容
     */
    public static String generateParamsLogContent(String logTitle,
            Object[] params)
    {
        StringBuilder logStr = new StringBuilder();
        try
        {
            if (logTitle != null)
            {
                logStr.append(logTitle);
            }

            ArrayList<Object> fieldList = new ArrayList<Object>();
            for (int i = 0; i < params.length; i++)
            {
                logStr.append(String.format("\n%sParamter[%s] : ", indent, i));
                fieldList.clear();
                appendParamToLog(params[i], null, logStr, 2, fieldList);
            }
        }
        catch (Exception e)
        {
            return String.format("日志输出失败（请检查日志管理工具） : \n" + e.toString());
        }

        return logStr.toString();
    }

    /**
     *
     * @param param  parameter
     * @param field  field
     * @param logStr log string
     * @param level  level for indentation
     * @param fieldObjList field list
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private static void appendParamToLog(Object param, Field field,
            StringBuilder logStr, int level, ArrayList<Object> fieldObjList)
            throws IllegalArgumentException, IllegalAccessException
    {
        if (!isValidLevel(level) || isRecurrence(param, fieldObjList))
        {
            return;
        }

        if (param != null)
        {
            fieldObjList.add(param);
        }

        StringBuilder curIndent = new StringBuilder();
        for (int i = 0; i < level; i++)
        {
            curIndent.append(indent);
        }

        boolean arrayFlag = isArray(param);
        boolean listFlag = isList(param);

        if (arrayFlag || listFlag)
        {
            logStr.append("\n");
            logStr.append(curIndent);
            logStr.append("[");

            if (field != null)
            {
                logStr.append(getClassName(field.getType()));
            }
            else if (param != null)
            {
                logStr.append(getClassName(param.getClass()));
            }

            logStr.append("] ");

            if (field != null)
            {
                logStr.append(field.getName()).append(" ");
            }

            logStr.append(": ");
            // StringBuilder arrLogStr = new StringBuilder();
            int count = 0;
            if (arrayFlag)
            {
                count = Array.getLength(param);
            }
            else
            {
                count = ((List<?>) param).size();
            }

            // boolean isSimpleArrxay = true;
            Object value;

            for (int i = 0; i < count; i++)
            {
                if (arrayFlag)
                {
                    value = Array.get(param, i);
                }
                else
                {
                    value = ((List<?>) param).get(i);
                }
                appendParamToLog(value, null, logStr, level + 1, fieldObjList);
            }
        }
        else if (isMap(param))
        {
            Map<?, ?> map = (Map<?, ?>) param;

            if (map != null && map.size() > 0)
            {
                logStr.append("\n");
                logStr.append(curIndent);
                logStr.append("[");

                if (field != null)
                {
                    logStr.append(getClassName(field.getType()));
                }
                else if (param != null)
                {
                    logStr.append(getClassName(param.getClass()));
                }

                logStr.append("] ");

                if (field != null)
                {
                    logStr.append(field.getName()).append(" ");
                }

                logStr.append(": ");

                for (Entry<?, ?> entry : map.entrySet())
                {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    logStr.append("\n");
                    logStr.append(curIndent).append(indent);
                    logStr.append("[").append(getClassName(key.getClass())).append(
                            "] ");
                    logStr.append("<");
                    logStr.append(key).append("> = ");
                    appendParamToLog(value, null, logStr, level + 1,
                            fieldObjList);
                }
            }
        }
        else if (hasSubFields(param))
        {
            logStr.append("\n");
            logStr.append(curIndent);
            logStr.append("[");

            if (field != null)
            {
                logStr.append(getClassName(field.getType()));
            }
            else if (param != null)
            {
                logStr.append(getClassName(param.getClass()));
            }

            logStr.append("] ");

            if (field != null)
            {
                logStr.append(field.getName()).append(" : ");
            }

            if (param != null)
            {
                Class<?> paramClass = param.getClass();
                Field[] fields = paramClass.getDeclaredFields();

                if (fields.length > 0)
                {
                    for (Field subField : fields)
                    {
                        subField.setAccessible(true);
                        Object subFieldObj = subField.get(param);
                        if (isValidField(subField))
                        {
                            appendParamToLog(subFieldObj, subField, logStr,
                                    level + 1, fieldObjList);
                        }
                    }
                }
            }
        }
        else
        {
            logStr.append("\n");
            logStr.append(curIndent);
            logStr.append("[");
            if (field != null)
            {
                logStr.append(getClassName(field.getType()));
            }
            else if (param != null)
            {
                logStr.append(getClassName(param.getClass()));
            }

            logStr.append("] ");

            if (field != null)
            {
                logStr.append(field.getName()).append(" ");
            }

            logStr.append(": ");
            logStr.append(param);
        }
    }

    /**
     *
     * @param obj  parameter
     * @return       whether object has sub fields 
     */
    private static boolean hasSubFields(Object obj)
    {
        if (obj != null)
        {
            Class<?> objClass = obj.getClass();
            String className = objClass.getCanonicalName();
            if (objClass.isPrimitive())
            {
                return false;
            }
            else if (isCustomClass(className))
            {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param className class name
     * @return       whether className is custom class name
     */
    private static boolean isCustomClass(String className)
    {
        if (className != null && className.contains("mbis"))
        {
            return true;
        }

        return false;
    }

    /**
     *
     * @param obj    object
     * @param fieldObjList field object list
     * @return       whether list contains object
     */
    private static boolean isRecurrence(Object obj,
            ArrayList<Object> fieldObjList)
    {
        return false;
    }

    /**
     *
     * @param level  recurrence level
     * @return
     */
    private static boolean isValidLevel(int level)
    {
        return level >= 0 && level <= RECURRENCE_LEVEL;
    }

    /**
     *
     * @param field  field
     * @return       whether field is valid field to display value
     */
    private static boolean isValidField(Field field)
    {
        if (field != null)
        {
            String fieldName = field.getName();
            if (fieldName != null
                && FIELD_NAME_PATTERN.matcher(fieldName).matches())
            {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param obj    object
     * @return       whether object is array
     */
    private static boolean isArray(Object obj)
    {
        if (obj != null && obj.getClass().isArray())
        {
            return true;
        }

        return false;
    }

    /**
     *
     * @param obj    object
     * @return       whether object is List
     */
    private static boolean isList(Object obj)
    {
        if (obj != null && obj instanceof List<?>)
        {
            return true;
        }

        return false;
    }

    /**
     *
     * @param obj    object
     * @return       whether object is Map
     */
    private static boolean isMap(Object obj)
    {
        if (obj != null && obj instanceof Map)
        {
            return true;
        }

        return false;
    }

    /**
     *
     * @param cls    Class对象
     * @return       Class名称
     */
    private static String getClassName(Class<?> cls)
    {
        return cls != null ? cls.getCanonicalName() : "null";
    }
}
