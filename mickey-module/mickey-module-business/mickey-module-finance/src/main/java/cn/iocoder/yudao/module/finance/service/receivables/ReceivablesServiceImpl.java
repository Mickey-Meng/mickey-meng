package cn.iocoder.yudao.module.finance.service.receivables;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.finance.controller.admin.receivables.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivables.ReceivablesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.finance.convert.receivables.ReceivablesConvert;
import cn.iocoder.yudao.module.finance.dal.mysql.receivables.ReceivablesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.finance.enums.ErrorCodeConstants.*;

/**
 * 键值参数 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ReceivablesServiceImpl implements ReceivablesService {

    @Resource
    private ReceivablesMapper receivablesMapper;

    @Override
    public String createReceivables(ReceivablesCreateReqVO createReqVO) {
        // 插入
        ReceivablesDO receivables = ReceivablesConvert.INSTANCE.convert(createReqVO);
        receivablesMapper.insert(receivables);
        // 返回
        return receivables.getReceivablesId();
    }

    @Override
    public void updateReceivables(ReceivablesUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateReceivablesExists(updateReqVO.getReceivablesId());
        // 更新
        ReceivablesDO updateObj = ReceivablesConvert.INSTANCE.convert(updateReqVO);
        receivablesMapper.updateById(updateObj);
    }

    @Override
    public void deleteReceivables(String id) {
        // 校验存在
        this.validateReceivablesExists(id);
        // 删除
        receivablesMapper.deleteById(id);
    }

    private void validateReceivablesExists(String id) {
        if (receivablesMapper.selectById(id) == null) {
            throw exception(RECEIVABLES_NOT_EXISTS);
        }
    }

    @Override
    public ReceivablesDO getReceivables(String id) {
        return receivablesMapper.selectById(id);
    }

    @Override
    public List<ReceivablesDO> getReceivablesList(Collection<String> ids) {
        return receivablesMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ReceivablesDO> getReceivablesPage(ReceivablesPageReqVO pageReqVO) {
        return receivablesMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ReceivablesDO> getReceivablesList(ReceivablesExportReqVO exportReqVO) {
        return receivablesMapper.selectList(exportReqVO);
    }

}
