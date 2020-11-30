package cn.geoary.fastspringboot.util;

import java.util.HashMap;

public class AOPUtil {
    private AOPUtil() {

    }


    /**
     * 功能描述:
     * 〈合并数组〉
     *
     * @param keys   键的数组
     * @param values 值的数组
     * @return : java.util.HashMap
     * @author : zhangc
     * @date : 2020/11/30 14:03
     */
    public static HashMap mergeArray(String[] keys, Object[] values) {
        HashMap resultMap = null;
        if (keys.length != values.length) {
            return resultMap;
        } else {
            resultMap = new HashMap();
            for (int i = 0, j = values.length; i < j; i++) {
                resultMap.put(keys[i], values[i]);
            }
        }
        return resultMap;
    }
}
