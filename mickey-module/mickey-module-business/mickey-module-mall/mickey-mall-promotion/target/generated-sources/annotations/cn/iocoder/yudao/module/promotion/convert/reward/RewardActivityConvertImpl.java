package cn.iocoder.yudao.module.promotion.convert.reward;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.reward.vo.RewardActivityBaseVO;
import cn.iocoder.yudao.module.promotion.controller.admin.reward.vo.RewardActivityCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.reward.vo.RewardActivityRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.reward.vo.RewardActivityUpdateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.reward.RewardActivityDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class RewardActivityConvertImpl implements RewardActivityConvert {

    @Override
    public RewardActivityDO convert(RewardActivityCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        RewardActivityDO rewardActivityDO = new RewardActivityDO();

        rewardActivityDO.setName( bean.getName() );
        rewardActivityDO.setStartTime( bean.getStartTime() );
        rewardActivityDO.setEndTime( bean.getEndTime() );
        rewardActivityDO.setRemark( bean.getRemark() );
        rewardActivityDO.setConditionType( bean.getConditionType() );
        rewardActivityDO.setProductScope( bean.getProductScope() );
        List<Long> list = bean.getProductSpuIds();
        if ( list != null ) {
            rewardActivityDO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        rewardActivityDO.setRules( ruleListToRuleList( bean.getRules() ) );

        return rewardActivityDO;
    }

    @Override
    public RewardActivityDO convert(RewardActivityUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        RewardActivityDO rewardActivityDO = new RewardActivityDO();

        rewardActivityDO.setId( bean.getId() );
        rewardActivityDO.setName( bean.getName() );
        rewardActivityDO.setStartTime( bean.getStartTime() );
        rewardActivityDO.setEndTime( bean.getEndTime() );
        rewardActivityDO.setRemark( bean.getRemark() );
        rewardActivityDO.setConditionType( bean.getConditionType() );
        rewardActivityDO.setProductScope( bean.getProductScope() );
        List<Long> list = bean.getProductSpuIds();
        if ( list != null ) {
            rewardActivityDO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        rewardActivityDO.setRules( ruleListToRuleList( bean.getRules() ) );

        return rewardActivityDO;
    }

    @Override
    public RewardActivityRespVO convert(RewardActivityDO bean) {
        if ( bean == null ) {
            return null;
        }

        RewardActivityRespVO rewardActivityRespVO = new RewardActivityRespVO();

        rewardActivityRespVO.setName( bean.getName() );
        rewardActivityRespVO.setStartTime( bean.getStartTime() );
        rewardActivityRespVO.setEndTime( bean.getEndTime() );
        rewardActivityRespVO.setRemark( bean.getRemark() );
        rewardActivityRespVO.setConditionType( bean.getConditionType() );
        rewardActivityRespVO.setProductScope( bean.getProductScope() );
        List<Long> list = bean.getProductSpuIds();
        if ( list != null ) {
            rewardActivityRespVO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        rewardActivityRespVO.setRules( ruleListToRuleList1( bean.getRules() ) );
        if ( bean.getId() != null ) {
            rewardActivityRespVO.setId( bean.getId().intValue() );
        }
        rewardActivityRespVO.setStatus( bean.getStatus() );
        rewardActivityRespVO.setCreateTime( bean.getCreateTime() );

        return rewardActivityRespVO;
    }

    @Override
    public PageResult<RewardActivityRespVO> convertPage(PageResult<RewardActivityDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<RewardActivityRespVO> pageResult = new PageResult<RewardActivityRespVO>();

        pageResult.setList( rewardActivityDOListToRewardActivityRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected RewardActivityDO.Rule ruleToRule(RewardActivityBaseVO.Rule rule) {
        if ( rule == null ) {
            return null;
        }

        RewardActivityDO.Rule rule1 = new RewardActivityDO.Rule();

        rule1.setLimit( rule.getLimit() );
        rule1.setDiscountPrice( rule.getDiscountPrice() );
        rule1.setFreeDelivery( rule.getFreeDelivery() );
        rule1.setPoint( rule.getPoint() );
        List<Long> list = rule.getCouponIds();
        if ( list != null ) {
            rule1.setCouponIds( new ArrayList<Long>( list ) );
        }
        List<Integer> list1 = rule.getCouponCounts();
        if ( list1 != null ) {
            rule1.setCouponCounts( new ArrayList<Integer>( list1 ) );
        }

        return rule1;
    }

    protected List<RewardActivityDO.Rule> ruleListToRuleList(List<RewardActivityBaseVO.Rule> list) {
        if ( list == null ) {
            return null;
        }

        List<RewardActivityDO.Rule> list1 = new ArrayList<RewardActivityDO.Rule>( list.size() );
        for ( RewardActivityBaseVO.Rule rule : list ) {
            list1.add( ruleToRule( rule ) );
        }

        return list1;
    }

    protected RewardActivityBaseVO.Rule ruleToRule1(RewardActivityDO.Rule rule) {
        if ( rule == null ) {
            return null;
        }

        RewardActivityBaseVO.Rule rule1 = new RewardActivityBaseVO.Rule();

        rule1.setLimit( rule.getLimit() );
        rule1.setDiscountPrice( rule.getDiscountPrice() );
        rule1.setFreeDelivery( rule.getFreeDelivery() );
        rule1.setPoint( rule.getPoint() );
        List<Long> list = rule.getCouponIds();
        if ( list != null ) {
            rule1.setCouponIds( new ArrayList<Long>( list ) );
        }
        List<Integer> list1 = rule.getCouponCounts();
        if ( list1 != null ) {
            rule1.setCouponCounts( new ArrayList<Integer>( list1 ) );
        }

        return rule1;
    }

    protected List<RewardActivityBaseVO.Rule> ruleListToRuleList1(List<RewardActivityDO.Rule> list) {
        if ( list == null ) {
            return null;
        }

        List<RewardActivityBaseVO.Rule> list1 = new ArrayList<RewardActivityBaseVO.Rule>( list.size() );
        for ( RewardActivityDO.Rule rule : list ) {
            list1.add( ruleToRule1( rule ) );
        }

        return list1;
    }

    protected List<RewardActivityRespVO> rewardActivityDOListToRewardActivityRespVOList(List<RewardActivityDO> list) {
        if ( list == null ) {
            return null;
        }

        List<RewardActivityRespVO> list1 = new ArrayList<RewardActivityRespVO>( list.size() );
        for ( RewardActivityDO rewardActivityDO : list ) {
            list1.add( convert( rewardActivityDO ) );
        }

        return list1;
    }
}
