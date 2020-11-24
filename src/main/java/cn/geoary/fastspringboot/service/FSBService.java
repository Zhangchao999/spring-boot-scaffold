package cn.geoary.fastspringboot.service;

import java.util.HashMap;

public interface FSBService {

    /**
     * 功能描述:
     * 〈通过主键查询〉
     *
     * @param id 主键
     * @return : java.util.HashMap
     * @author : zhangc
     * @date : 2020/11/24 21:57
     */
    HashMap queryById(int id);

    /**
     * 功能描述:
     * 〈查询全表〉
     *
     * @param  1
     * @return : java.util.HashMap
     * @author : zhangc
     * @date : 2020/11/24 21:57
     */
    HashMap queryByAll();

    /**
     * 功能描述:
     * 〈添加〉
     *
     * @param paramMap 1
     * @return : java.util.HashMap
     * @author : zhangc
     * @date : 2020/11/24 21:57
     */
    HashMap insert(HashMap paramMap);

    /**
     * 功能描述:
     * 〈更新〉
     *
     * @param paramMap 1
     * @return : java.util.HashMap
     * @author : zhangc
     * @date : 2020/11/24 21:58
     */
    HashMap update(HashMap paramMap);
}
