package cn.geoary.fastspringboot.service.impl;

import cn.geoary.fastspringboot.constant.ServiceConstant;
import cn.geoary.fastspringboot.mapper.FSBMapper;
import cn.geoary.fastspringboot.service.FSBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Slf4j
@Service
public class FSBServiceImpl implements FSBService {

    @Resource
    private FSBMapper fsbMapper;

    @Override
    public HashMap queryById(int id) {
        HashMap result = new HashMap();
        HashMap fsbMap = null;
        try {
            fsbMap = fsbMapper.queryById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            // TODO 抛出异常并放回行数
            throw new RuntimeException("查询失败");
        }
        result.put(ServiceConstant.RESULT_CODE, ServiceConstant.RESULT_CODE_SUCCESS);
        result.put(ServiceConstant.RESULT_MESSAGE, "查询成功");
        result.put(ServiceConstant.RESULT_RESULTSET, fsbMap);
        return result;
    }

    @Override
    public HashMap queryByAll() {
        return null;
    }

    @Override
    public HashMap insert(HashMap paramMap) {
        return null;
    }

    @Override
    public HashMap update(HashMap paramMap) {
        return null;
    }
}
