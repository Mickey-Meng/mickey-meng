package cn.iocoder.yudao.module.community.service.community;

import cn.iocoder.yudao.framework.test.core.util.RandomUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.community.controller.admin.community.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import cn.iocoder.yudao.module.community.dal.mysql.community.CommunityMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.community.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CommunityServiceImpl} 的单元测试类
*
* @author Mickey
*/
@Import(CommunityServiceImpl.class)
public class CommunityServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommunityServiceImpl communityService;

    @Resource
    private CommunityMapper communityMapper;

    @Test
    public void testCreate_success() {
        // 准备参数
        CommunityCreateReqVO reqVO = randomPojo(CommunityCreateReqVO.class);

        // 调用
        Integer Id = communityService.create(reqVO);
        // 断言
        assertNotNull(Id);
        // 校验记录的属性是否正确
        CommunityDO  communityDO = communityMapper.selectById(Id);
        assertPojoEquals(reqVO, communityDO);
    }

    @Test
    public void testUpdate_success() {
        // mock 数据
        CommunityDO db = randomPojo(CommunityDO.class);
        communityMapper.insert(db);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CommunityUpdateReqVO reqVO = randomPojo(CommunityUpdateReqVO.class, o -> {
            o.setId(db.getId()); // 设置更新的 ID
        });

        // 调用
        communityService.update(reqVO);
        // 校验是否更新正确
        CommunityDO  communityDo= communityMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, communityDo);
    }

    @Test
    public void testUpdate_notExists() {
        // 准备参数
        CommunityUpdateReqVO reqVO = randomPojo(CommunityUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> communityService.update(reqVO), COMMUNITY_NOT_EXISTS);
    }

    @Test
    public void testDelete_success() {
        // mock 数据
        CommunityDO db = randomPojo(CommunityDO.class);
        communityMapper.insert(db);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = db.getId();

        // 调用
        communityService.delete(id);
       // 校验数据不存在了
       assertNull(communityMapper.selectById(id));
    }

    @Test
    public void testDelete_notExists() {
        // 准备参数
        //Integer id = randomIntegerId();

        // 调用, 并断言异常
       // assertServiceException(() -> communityService.delete(id), COMMUNITY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPage() {
       // mock 数据
       CommunityDO db = randomPojo(CommunityDO.class, o -> { // 等会查询到
           o.setCommunityName(null);
           o.setCommunityCode(null);
           o.setProvincesCode(null);
           o.setCityCode(null);
           o.setDistrictCode(null);
           o.setTownCode(null);
           o.setDetailedAddress(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setPropertyId(null);
           o.setSort(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
        communityMapper.insert(db);
       // 测试 communityName 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCommunityName(null)));
       // 测试 communityCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCommunityCode(null)));
       // 测试 provincesCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setProvincesCode(null)));
       // 测试 cityCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCityCode(null)));
       // 测试 district Code 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setDistrictCode(null)));
       // 测试 townCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setTownCode(null)));
       // 测试 detailedAddress 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setDetailedAddress(null)));
       // 测试 longitude 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setLatitude(null)));
       // 测试 propertyId 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setPropertyId(null)));
       // 测试 sort 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setSort(null)));
       // 测试 remark 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCreateTime(null)));
       // 准备参数
       CommunityPageReqVO reqVO = new CommunityPageReqVO();
       reqVO.setCommunityName(null);
       reqVO.setCommunityCode(null);
       reqVO.setProvincesCode(null);
       reqVO.setCityCode(null);
       reqVO.setDistrictCode(null);
       reqVO.setTownCode(null);
       reqVO.setDetailedAddress(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setPropertyId(null);
       reqVO.setSort(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<CommunityDO> pageResult = communityService.getPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(db, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetList() {
       // mock 数据
       CommunityDO db = randomPojo(CommunityDO.class, o -> { // 等会查询到
           o.setCommunityName(null);
           o.setCommunityCode(null);
           o.setProvincesCode(null);
           o.setCityCode(null);
           o.setDistrictCode(null);
           o.setTownCode(null);
           o.setDetailedAddress(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setPropertyId(null);
           o.setSort(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       communityMapper.insert(db);
       // 测试 communityName 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCommunityName(null)));
       // 测试 communityCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCommunityCode(null)));
       // 测试 provincesCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setProvincesCode(null)));
       // 测试 cityCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCityCode(null)));
       // 测试 district Code 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setDistrictCode(null)));
       // 测试 townCode 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setTownCode(null)));
       // 测试 detailedAddress 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setDetailedAddress(null)));
       // 测试 longitude 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setLatitude(null)));
       // 测试 propertyId 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setPropertyId(null)));
       // 测试 sort 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setSort(null)));
       // 测试 remark 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       communityMapper.insert(cloneIgnoreId(db, o -> o.setCreateTime(null)));
       // 准备参数
       CommunityExportReqVO reqVO = new CommunityExportReqVO();
       reqVO.setCommunityName(null);
       reqVO.setCommunityCode(null);
       reqVO.setProvincesCode(null);
       reqVO.setCityCode(null);
       reqVO.setDistrictCode(null);
       reqVO.setTownCode(null);
       reqVO.setDetailedAddress(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setPropertyId(null);
       reqVO.setSort(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<CommunityDO> list = communityService.getList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(db, list.get(0));
    }

}
