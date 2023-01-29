package cn.iocoder.yudao.module.community.dal.mysql.user;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.community.dal.dataobject.user.CommunityUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会员 User Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CommunityUserMapper extends BaseMapperX<CommunityUserDO> {

    default CommunityUserDO selectByMobile(String mobile) {
        return selectOne(CommunityUserDO::getPhoneNumber, mobile);
    }

    default List<CommunityUserDO> selectListByNicknameLike(String nickname) {
        return selectList(new LambdaQueryWrapperX<CommunityUserDO>()
                .likeIfPresent(CommunityUserDO::getNickname, nickname));
    }

}
