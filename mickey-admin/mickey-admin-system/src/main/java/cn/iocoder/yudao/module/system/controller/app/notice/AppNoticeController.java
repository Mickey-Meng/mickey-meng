package cn.iocoder.yudao.module.system.controller.app.notice;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.controller.app.notice.vo.AppNoticeReqVO;
import cn.iocoder.yudao.module.system.controller.app.notice.vo.AppNoticeRespVO;
import cn.iocoder.yudao.module.system.convert.notice.NoticeConvert;
import cn.iocoder.yudao.module.system.service.notice.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

@Api(tags = "用户APP - 通知公告")
@RestController
@RequestMapping("/notice")
@Validated
public class AppNoticeController {

    @Resource
    private NoticeService noticeService;

    @GetMapping("/list")
    @ApiOperation("获得通知公告")
    //@PreAuthorize("@ss.hasPermission('system:notice:query')")
    public CommonResult<List<AppNoticeRespVO>> getNotice(@Validated AppNoticeReqVO reqVO) {
        List<AppNoticeRespVO> appNoticeList = NoticeConvert.INSTANCE.convertList(noticeService.getAppNoticeList(reqVO));
        return CommonResult.success(appNoticeList);
    }

}
