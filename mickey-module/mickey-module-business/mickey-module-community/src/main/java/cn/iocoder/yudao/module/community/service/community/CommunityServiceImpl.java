package cn.iocoder.yudao.module.community.service.community;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.community.convert.community.CommunityConvert;
import cn.iocoder.yudao.module.community.dal.mysql.community.CommunityMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.community.enums.ErrorCodeConstants.COMMUNITY_NOT_EXISTS;

/**
 * 小区信息 Service 实现类
 *
 * @author Mickey
 */
@Service
@Validated
public class CommunityServiceImpl implements CommunityService {

    @Resource
    private CommunityMapper communityMapper;

    @Override
    public Integer create(CommunityCreateReqVO createReqVO) {
        // 插入
        CommunityDO  communityDO = CommunityConvert.INSTANCE.convert(createReqVO);
        communityMapper.insert(communityDO);
        // 返回
        return communityDO.getId();
    }

    @Override
    public void update(CommunityUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateExists(updateReqVO.getId());
        // 更新
        CommunityDO updateObj = CommunityConvert.INSTANCE.convert(updateReqVO);
        communityMapper.updateById(updateObj);
    }

    @Override
    public void delete(Integer id) {
        // 校验存在
        this.validateExists(id);
        // 删除
        communityMapper.deleteById(id);
    }

    private void validateExists(Integer id) {
        if (communityMapper.selectById(id) == null) {
            throw exception(COMMUNITY_NOT_EXISTS);
        }
    }

    @Override
    public CommunityDO get(Integer id) {
        return communityMapper.selectById(id);
    }

    @Override
    public List<CommunityDO> getList(Collection<Integer> ids) {
        return communityMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommunityDO> getPage(CommunityPageReqVO pageReqVO) {
        return communityMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommunityDO> getList(CommunityExportReqVO exportReqVO) {
        return communityMapper.selectList(exportReqVO);
    }

    @Override
    public List<CommunityDO> getAllList() {
        return communityMapper.selectList();
    }

}
