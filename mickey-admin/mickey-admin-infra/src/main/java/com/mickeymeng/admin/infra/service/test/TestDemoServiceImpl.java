package com.mickeymeng.admin.infra.service.test;

import com.mickeymeng.admin.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import com.mickeymeng.admin.infra.controller.admin.test.vo.TestDemoExportReqVO;
import com.mickeymeng.admin.infra.controller.admin.test.vo.TestDemoPageReqVO;
import com.mickeymeng.admin.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import com.mickeymeng.admin.infra.convert.test.TestDemoConvert;
import com.mickeymeng.admin.infra.dal.dataobject.test.TestDemoDO;
import com.mickeymeng.admin.infra.dal.mysql.test.TestDemoMapper;
import com.mickeymeng.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static com.mickeymeng.framework.common.constants.ErrorCodeConstants.TEST_DEMO_NOT_EXISTS;
import static com.mickeymeng.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 字典类型 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TestDemoServiceImpl implements TestDemoService {

    @Resource
    private TestDemoMapper testDemoMapper;

    @Override
    public Long createTestDemo(TestDemoCreateReqVO createReqVO) {
        // 插入
        TestDemoDO testDemo = TestDemoConvert.INSTANCE.convert(createReqVO);
        testDemoMapper.insert(testDemo);
        // 返回
        return testDemo.getId();
    }

    @Override
    @CacheEvict(value = "test", key = "#updateReqVO.id")
    public void updateTestDemo(TestDemoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTestDemoExists(updateReqVO.getId());
        // 更新
        TestDemoDO updateObj = TestDemoConvert.INSTANCE.convert(updateReqVO);
        testDemoMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "test", key = "#id")
    public void deleteTestDemo(Long id) {
        // 校验存在
        this.validateTestDemoExists(id);
        // 删除
        testDemoMapper.deleteById(id);
    }

    private void validateTestDemoExists(Long id) {
        if (testDemoMapper.selectById(id) == null) {
            throw exception(TEST_DEMO_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(cacheNames = "test", key = "#id")
    public TestDemoDO getTestDemo(Long id) {
        return testDemoMapper.selectById(id);
    }

    @Override
    public List<TestDemoDO> getTestDemoList(Collection<Long> ids) {
        return testDemoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TestDemoDO> getTestDemoPage(TestDemoPageReqVO pageReqVO) {
//        testDemoMapper.selectList2();
        return testDemoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TestDemoDO> getTestDemoList(TestDemoExportReqVO exportReqVO) {
        return testDemoMapper.selectList(exportReqVO);
    }

}
