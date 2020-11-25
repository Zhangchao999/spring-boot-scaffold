package cn.geoary.fastspringboot.service.impl;

import cn.geoary.fastspringboot.constant.ServiceConstant;
import cn.geoary.fastspringboot.mapper.FSBMapper;
import cn.geoary.fastspringboot.service.FSBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackForClassName = "RuntimeException")
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
        HashMap result = new HashMap();
        List fsbs = fsbMapper.queryByAll();
        result.put(ServiceConstant.RESULT_CODE, ServiceConstant.RESULT_CODE_SUCCESS);
        result.put(ServiceConstant.RESULT_MESSAGE, "查询成功");
        result.put(ServiceConstant.RESULT_RESULTLIST, fsbs);
        return result;
    }

    @Override
    public HashMap insert(HashMap paramMap) {
        HashMap result = new HashMap();
        try {
            fsbMapper.insert(paramMap);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        result.put(ServiceConstant.RESULT_CODE, ServiceConstant.RESULT_CODE_SUCCESS);
        result.put(ServiceConstant.RESULT_MESSAGE, "添加成功");
        return result;
    }

    @Override
    public HashMap update(HashMap paramMap) {
        HashMap result = new HashMap();
        try {
            fsbMapper.update(paramMap);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        result.put(ServiceConstant.RESULT_CODE, ServiceConstant.RESULT_CODE_SUCCESS);
        result.put(ServiceConstant.RESULT_MESSAGE, "更新成功");
        return result;
    }

    @Override
    public HashMap rollbackTest(HashMap paramMap) {
        HashMap result = new HashMap();
        try {
            fsbMapper.insert(paramMap);
            fsbMapper.update(paramMap);
            // 测试数据是否能回滚
            if (1 == 1) {
                int a = 1 / 0;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        result.put(ServiceConstant.RESULT_CODE, ServiceConstant.RESULT_CODE_SUCCESS);
        result.put(ServiceConstant.RESULT_MESSAGE, "测试回滚");
        return result;
    }
}
