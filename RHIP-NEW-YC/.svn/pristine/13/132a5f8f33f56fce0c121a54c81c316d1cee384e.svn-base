package com.founder.rhip.ehr.common;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressWarnings({"rawtypes", "unchecked"})
public class VoUtil {

    private static Logger logger = Logger.getLogger(VoUtil.class);

    public static <T> T getFormData(HttpServletRequest request, Class<T> clz) {
        try {
            List<String> keyList = getKeyList(request,clz);
            KeyMapData KeyMapData = getKeyMapData(keyList);
            T t = formKeyMapData(request, clz, KeyMapData, "");
            return t;
        } catch (Exception e) {
            //涓嶅仛澶勭悊
        }
        return null;
    }

    /**
     * 鍒涘缓Validate
     */
//	private static <T> void setValidate(HttpServletRequest request,Class<T> clz,T t ){
//		Annotation[] annotations = clz.getAnnotations();
//		
//		for(Annotation annotation : annotations){
//		}
//		
//	}
    private static <T> T formKeyMapData(HttpServletRequest request, Class<T> clz, KeyMapData KeyMapData, String befKey) throws Exception {
        String key = KeyMapData.getPartKey();
        if (ObjectUtil.isNotEmpty(befKey)) {
            key = befKey + "." + key;
        }
        List<KeyMapData> nextKeyMapDataList = KeyMapData.getNextKeys();
        if (ObjectUtil.isNullOrEmpty(nextKeyMapDataList)) {
            return getValue(request, clz, key);
        }
        T t = clz.newInstance();
        for (KeyMapData kData : nextKeyMapDataList) {
            String getMethodName = methodName("get", kData.getPartKey());
            String setMethodName = methodName("set", kData.getPartKey());
            try {
                Method getMethod = clz.getMethod(getMethodName);
                Method setMethod = clz.getMethod(setMethodName, getMethod.getReturnType());
                if (isParameterizedType(getMethod)) {
                    ArrayList dataList = getArrayList(t, getMethod);
                    Class<?> retType = getParameterizedType(getMethod);
                    int keyIndex = getPartKeyIndex(kData.getPartKey());
                    Object value = formKeyMapData(request, retType, kData, key);
                    setData(dataList, keyIndex, value);
                    setMethod.invoke(t, dataList);
                } else {
                    Object value = formKeyMapData(request, getMethod.getReturnType(), kData, key);
                    if (ObjectUtil.isNotEmpty(value)) {
                        BeanUtils.copyProperty(t, kData.getPartKey(), value);
                    }
                }
            } catch (Exception e) {
                logger.error(clz.toString() + "====" + key + "=====" + kData.getPartKey());
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 灏嗗璞℃斁鍒癓IST涓�
     */
    private static void setData(ArrayList dataList, int keyIndex,
                                Object value) throws Exception {
        if (ObjectUtil.isNullOrEmpty(value)) {
            return;
        }

        if (ObjectUtil.isNullOrEmpty(dataList)) {
            setList(dataList, keyIndex, value);
            return;
        }
        if (dataList.size() <= keyIndex) {
            setList(dataList, keyIndex, value);
            return;
        }
        Object dataObj = dataList.get(keyIndex);
        if (ObjectUtil.isNullOrEmpty(dataObj)) {
            dataList.remove(keyIndex);
            setList(dataList, keyIndex, value);
            return;
        }
        BeanUtils.copyProperties(dataObj, value);
    }

    /**
     * 灏嗗璞℃彃鍏ュ埌List涓殑鎸囧畾浣嶇疆
     */
    private static void setList(ArrayList dataList, int keyIndex, Object value) {
        if (dataList.size() <= keyIndex) {
            for (int i = dataList.size(); i < keyIndex + 1; i++) {
                dataList.add(null);
            }
        }
        dataList.add(keyIndex, value);
    }

    /**
     * 鑾峰彇KEY鍊间笂鐨勫簭鍙�
     */
    private static int getPartKeyIndex(String partKey) {
        Pattern pattern = Pattern.compile(".+\\[\\d+\\]");
        if (pattern.matcher(partKey).matches()) {
            int sIndex = partKey.indexOf("[") + 1;
            int eIndex = partKey.indexOf("]");
            partKey = partKey.substring(sIndex, eIndex);
        }
        return Integer.parseInt(partKey);
    }

    /**
     * 鑾峰彇瀵硅薄涓殑List
     */
    private static <T> ArrayList getArrayList(T t, Method method) throws Exception {
        Object o = method.invoke(t);
        if (ObjectUtil.isNotEmpty(o)) {
            return (ArrayList) o;
        }
        return new ArrayList();
    }

    /**
     * 鏍规嵁request涓殑KEY鍊艰幏鍙栧�
     */
    private static <T> T getValue(HttpServletRequest request, Class<T> clz, String key) {
        Object o = request.getParameter(key);
        String dFormat="yyyy/MM/dd";
        String HFormat="yyyy/MM/dd HH";
        String mFormat="yyyy/MM/dd HH:mm";
        String sFormat="yyyy/MM/dd HH:mm:ss";
        String SFormat="yyyy/MM/dd HH:mm:ss.S";
        
        if (clz.getName().equals(Date.class.getName())) {
            String os = o.toString();
            os = os.replaceAll("-", "/");
            
            if(DateUtil.isValidDate(os, SFormat)){
            	o = DateUtil.parseSimpleDate(os, SFormat);
            }else if(DateUtil.isValidDate(os, sFormat)){
            	o = DateUtil.parseSimpleDate(os, sFormat);
            }else if(DateUtil.isValidDate(os, mFormat)){
            	o = DateUtil.parseSimpleDate(os, mFormat);
            }else if(DateUtil.isValidDate(os, HFormat)){
            	o = DateUtil.parseSimpleDate(os, HFormat);
            }else if(DateUtil.isValidDate(os, dFormat)){
            	o = DateUtil.parseSimpleDate(os, dFormat);
            }
        }
        return (T) o;
    }

    /**
     * 缁勮KeyMapData瀵硅薄
     */
    private static KeyMapData getKeyMapData(List<String> keyList) {
        if (ObjectUtil.isNullOrEmpty(keyList)) {
            return null;
        }
        String firstKey = getPartKey(keyList.get(0), 0);
        KeyMapData KeyMapData = new KeyMapData();
        KeyMapData.setPartKey(firstKey);

        List<String> nextKeyList = getNextKeyList(keyList);

        if (ObjectUtil.isNullOrEmpty(nextKeyList)) {
            return KeyMapData;
        }
        List<String> nextFirstKeyList = getnextFirstKeyList(nextKeyList);
        List<KeyMapData> KeyMapDataList = new ArrayList<KeyMapData>();

        for (String str : nextFirstKeyList) {
            KeyMapData nextKeyMapData = getKeyMapData(getNextKeyListByFirst(str, nextKeyList));
            KeyMapDataList.add(nextKeyMapData);
        }
        KeyMapData.setNextKeys(KeyMapDataList);
        return KeyMapData;
    }

    /**
     *
     *
     * */
    private static List<String> getNextKeyListByFirst(String firstKey, List<String> nextKeyList) {
        List<String> keyList = new ArrayList<String>();
        for (String key : nextKeyList) {
            String key1 = getPartKey(key, 0);
            if (key1.equals(firstKey)) {
                keyList.add(key);
            }
        }
        return keyList;
    }

    /**
     * 鍒犻櫎閲嶅鏁版嵁
     */
    private static List<String> getnextFirstKeyList(List<String> nextKeyList) {
        List<String> nextFirstKeyList = new ArrayList<String>();

        for (String key : nextKeyList) {
            String nextFirstKey = getPartKey(key, 0);
            boolean flagIn = checkStringIn(nextFirstKeyList, nextFirstKey);
            if (flagIn) {
                continue;
            }
            nextFirstKeyList.add(nextFirstKey);
        }
        return nextFirstKeyList;
    }

    /**
     * 鍙傛暟TestVo.user.id绫讳技鏁版嵁鐨凩IST 杩斿洖user.id绫讳技鏁版嵁鐨凩IST
     */
    private static List<String> getNextKeyList(List<String> keyList) {
        List<String> nextKeyList = new ArrayList<String>();

        for (String key : keyList) {
            String[] keyParts = key.split("\\.");
            if (keyParts.length == 1) {
                continue;
            }
            nextKeyList.add(getNextKey(key));
        }
        return nextKeyList;
    }

    /**
     * 鑾峰彇鎵�湁鐨凨ey鍊�
     * @param <T>
     */
    private static <T> List<String> getKeyList(HttpServletRequest request, Class<T> clz) {
        Map<String, Object[]> map = (Map<String, Object[]>) request.getParameterMap();
        Object[] keyArray = map.keySet().toArray();
        List<String> keyList = new ArrayList<String>();

        for (Object o : keyArray) {
            String key = cutColon(o.toString());
            String keyFir = getPartKey(key, 0);
            String clzName = getPartKey(clz.getName(),-1);
            if(keyFir.equals(clzName)){
            	keyList.add(key);
            }
        }
        return keyList;
    }

    // /**
    // * 鑾峰彇鎵�湁鐨凨ey涓庢潯浠剁殑Map鍊�
    // * */
    // @SuppressWarnings("unchecked")
    // private static HashMap<String,String> getWhereMap(HttpServletRequest
    // request,String voName){
    // Map<String, Object[]> map = (Map<String, Object[]>)
    // request.getParameterMap();
    // Object[] keyArray = map.keySet().toArray();
    //
    // HashMap<String,String> hmap = new HashMap<String,String>();
    //
    // for(Object o :keyArray){
    // String keyString = o.toString();
    // String[] partKeys = keyString.split("\\.");
    //
    // if(partKeys.length > 1 && partKeys[0].equals(voName)){
    // hmap.put(getNextKey(partKeys[0]),partKeys[1]);
    // }
    // }
    // return hmap;
    // }

    /**
     * 鎷嗗垎鍐掑彿鈥滐細鈥�
     */
    private static String cutColon(String str) {
        return str.split(":")[0];
    }

    /**
     *
     * */
    public static String getNextKey(String key) {
        String[] arry = key.split("\\.");
        if (arry.length == 1) {
            return null;
        }
        String ret = arry[1];
        if (arry.length == 2) {
            return ret;
        }
        for (int i = 2; i < arry.length; i++) {
            ret += "." + arry[i];
        }
        return ret;
    }

    /**
     * 鏍规嵁index 鑾峰彇Key锛�濡傛灉index涓�1锛屽垯杩斿洖鏈�悗涓�綅
     */
    private static String getPartKey(String key, int index) {
        String[] arry = key.split("\\.");
        if (index == -1) {
            return arry[arry.length - 1];
        }
        if (index >= arry.length) {
            return null;
        }
        return arry[index];
    }

    private static boolean checkStringIn(List<String> list, String str) {
        for (String s : list) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String methodName(String b, String name) {
        Pattern pattern = Pattern.compile(".+\\[\\d+\\]");
        if (pattern.matcher(name).matches()) {
            int kIndex = name.indexOf("[");
            name = name.substring(0, kIndex);
        }
        String f = name.substring(0, 1).toUpperCase();
        name = b + f + name.substring(1);
        return name;
    }

    /**
     * 杩斿洖鏂规硶鏄笉鏄硾鍨�
     *
     * @return
     */
    private static boolean isParameterizedType(Method method) {
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            return true;
        }
        return false;
    }

    private static Class<?> getParameterizedType(Method method) throws Exception {
        Type returnType = method.getGenericReturnType();// 杩斿洖绫诲瀷
        if (returnType instanceof ParameterizedType)/**//* 濡傛灉鏄硾鍨嬬被鍨�*/ {
            Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();// 娉涘瀷绫诲瀷鍒楄〃
            for (Type type : types) {
                return (Class<?>) type;
            }
        }
        return null;
    }

//	public static void main(String[] args) throws Exception {
//		TestVo testVo = new TestVo();
//		Method method = testVo.getClass().getMethod("getOrg");
//
//		Class<?> clz = getParameterizedType(method);
//
//		System.out.println("===" + getPartKeyIndex("fjdksa[121]"));
//
//		//
//		// String s =
//		// testVo.getClass().getMethod("getOrg").getGenericReturnType().getClass().getName();
//		// System.out.println("===========" + s);
//		//
//		// Type returnType = method.getGenericReturnType();// 杩斿洖绫诲瀷
//		// System.out.println("  " + returnType);
//		// if (returnType instanceof ParameterizedType)/**//* 濡傛灉鏄硾鍨嬬被鍨�*/{
//		// Type[] types = ((ParameterizedType) returnType)
//		// .getActualTypeArguments();// 娉涘瀷绫诲瀷鍒楄〃
//		// System.out.println("  TypeArgument: ");
//		// for (Type type : types) {
//		// System.out.println("   " + type);
//		// }
//		// }
//	}
}

class KeyMapData {

    private String partKey;
    private List<KeyMapData> nextKeys;

    public String getPartKey() {
        return partKey;
    }

    public void setPartKey(String partKey) {
        this.partKey = partKey;
    }

    public List<KeyMapData> getNextKeys() {
        return nextKeys;
    }

    public void setNextKeys(List<KeyMapData> nextKeys) {
        this.nextKeys = nextKeys;
    }
}
