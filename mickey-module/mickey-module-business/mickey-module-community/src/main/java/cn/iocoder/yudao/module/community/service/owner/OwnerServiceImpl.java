package cn.iocoder.yudao.module.community.service.owner;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.community.convert.owner.OwnerConvert;
import cn.iocoder.yudao.module.community.dal.mysql.owner.OwnerMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.community.enums.ErrorCodeConstants.*;

/**
 * 业主信息 Service 实现类
 *
 * @author Mickey
 */
@Service
@Validated
public class OwnerServiceImpl implements OwnerService {

    @Resource
    private OwnerMapper ownerMapper;

    @Override
    public Long createOwner(OwnerCreateReqVO createReqVO) {
        // 插入
        OwnerDO owner = OwnerConvert.INSTANCE.convert(createReqVO);
        ownerMapper.insert(owner);
        // 返回
        return owner.getId();
    }

    @Override
    public void updateOwner(OwnerUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateOwnerExists(updateReqVO.getId());
        // 更新
        OwnerDO updateObj = OwnerConvert.INSTANCE.convert(updateReqVO);
        ownerMapper.updateById(updateObj);
    }

    @Override
    public void deleteOwner(Long id) {
        // 校验存在
        this.validateOwnerExists(id);
        // 删除
        ownerMapper.deleteById(id);
    }

    private void validateOwnerExists(Long id) {
        if (ownerMapper.selectById(id) == null) {
            throw exception(OWNER_NOT_EXISTS);
        }
    }

    @Override
    public OwnerDO getOwner(Long id) {
        return ownerMapper.selectById(id);
    }

    @Override
    public List<OwnerDO> getOwnerList(Collection<Long> ids) {
        return ownerMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OwnerDO> getOwnerPage(OwnerPageReqVO pageReqVO) {
        return ownerMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OwnerDO> getOwnerList(OwnerExportReqVO exportReqVO) {
        return ownerMapper.selectList(exportReqVO);
    }

}
