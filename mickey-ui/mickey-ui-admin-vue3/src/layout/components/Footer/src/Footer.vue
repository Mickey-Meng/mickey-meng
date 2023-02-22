<script setup lang="ts">
import { useAppStore } from '@/store/modules/app'
import { computed } from 'vue'
import { useDesign } from '@/hooks/web/useDesign'

const { getPrefixCls } = useDesign()

const prefixCls = getPrefixCls('footer')

const appStore = useAppStore()

const title = computed(() => appStore.getTitle)
</script>

<template>
  <div
    :class="prefixCls"
    class="text-center text-[var(--el-text-color-placeholder)] bg-[var(--app-contnet-bg-color)] h-[var(--app-footer-height)] leading-[var(--app-footer-height)] dark:bg-[var(--el-bg-color)]"
  >
    <p style="font-size: 14px"
      >Copyright ©2023-{{ title }} 版权所有 |
      <a href="https://beian.miit.gov.cn" target="_blank">陕ICP备2023000880号-1</a>
          <div style="width:300px;margin:0 auto; padding:20px 0;">
		 		    <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=61019002002343" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;">
              <img src="@/assets/imgs/beian_icon.png" style="float:left;"/>
              <p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">陕公网安备 61019002002343号</p>
            </a>
		 	    </div>
    </p>
  </div>
</template>
