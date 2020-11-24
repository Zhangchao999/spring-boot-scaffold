package cn.geoary.fastspringboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FSBMapper {
    /**
     * 功能描述:
     * 〈查询 by id〉
     *
     * @param id 1
     * @return : java.util.HashMap
     * @author : zhangc
     * @date : 2020/11/24 20:59
     */
    HashMap queryById(int id);

    /**
     * 功能描述:
     * 〈查询所有〉
     *
     * @return : java.util.List
     * @author : zhangc
     * @date : 2020/11/24 20:59
     */
    List queryByAll();

    /**
     * 功能描述:
     * 〈添加〉
     *
     * @param paramMap 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/24 20:59
     */
    void insert(HashMap paramMap);

    /**
     * 功能描述:
     * 〈更新/删除〉
     *
     * @param paramMap 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/24 20:59
     */
    void update(HashMap paramMap);
}
