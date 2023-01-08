package com.mickeymeng.framework.module.bpm.controller.admin.task;

import com.mickeymeng.framework.common.core.util.web.WebFrameworkUtils;
import com.mickeymeng.framework.common.pojo.CommonResult;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.module.bpm.controller.admin.task.vo.task.*;
import com.mickeymeng.framework.module.bpm.service.task.BpmTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

@Api(tags = "管理后台 - 流程任务实例")
@RestController
@RequestMapping("/bpm/task")
@Validated
public class BpmTaskController {

    @Resource
    private BpmTaskService taskService;

    @GetMapping("todo-page")
    @ApiOperation("获取 Todo 待办任务分页")
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<PageResult<BpmTaskTodoPageItemRespVO>> getTodoTaskPage(@Valid BpmTaskTodoPageReqVO pageVO) {
        return CommonResult.success(taskService.getTodoTaskPage(WebFrameworkUtils.getLoginUserId(), pageVO));
    }

    @GetMapping("done-page")
    @ApiOperation("获取 Done 已办任务分页")
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<PageResult<BpmTaskDonePageItemRespVO>> getDoneTaskPage(@Valid BpmTaskDonePageReqVO pageVO) {
        return CommonResult.success(taskService.getDoneTaskPage(WebFrameworkUtils.getLoginUserId(), pageVO));
    }

    @GetMapping("/list-by-process-instance-id")
    @ApiOperation(value = "获得指定流程实例的任务列表", notes = "包括完成的、未完成的")
    @ApiImplicitParam(name = "processInstanceId", value = "流程实例的编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<List<BpmTaskRespVO>> getTaskListByProcessInstanceId(
        @RequestParam("processInstanceId") String processInstanceId) {
        return CommonResult.success(taskService.getTaskListByProcessInstanceId(processInstanceId));
    }

    @PutMapping("/approve")
    @ApiOperation("通过任务")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> approveTask(@Valid @RequestBody BpmTaskApproveReqVO reqVO) {
        taskService.approveTask(WebFrameworkUtils.getLoginUserId(), reqVO);
        return CommonResult.success(true);
    }

    @PutMapping("/reject")
    @ApiOperation("不通过任务")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> rejectTask(@Valid @RequestBody BpmTaskRejectReqVO reqVO) {
        taskService.rejectTask(WebFrameworkUtils.getLoginUserId(), reqVO);
        return CommonResult.success(true);
    }

    @PutMapping("/update-assignee")
    @ApiOperation(value = "更新任务的负责人", notes = "用于【流程详情】的【转派】按钮")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> updateTaskAssignee(@Valid @RequestBody BpmTaskUpdateAssigneeReqVO reqVO) {
        taskService.updateTaskAssignee(WebFrameworkUtils.getLoginUserId(), reqVO);
        return CommonResult.success(true);
    }

}
