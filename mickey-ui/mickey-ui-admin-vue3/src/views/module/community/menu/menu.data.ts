import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { required } from '@/utils/formRules'
import { VxeCrudSchema, useVxeCrudSchemas } from '@/hooks/web/useVxeCrudSchemas'
import { DICT_TYPE } from '@/utils/dict'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  sort: [required]
})
// CrudSchema
const crudSchemas = reactive<VxeCrudSchema>({
  primaryKey: 'id', // 默认的主键ID
  primaryTitle: t('common.index'), // 默认显示的值
  primaryType: 'seq', // 默认为seq，序号模式
  action: true,
  actionWidth: '200', // 3个按钮默认200，如有删减对应增减即可
  columns: [
    {
      title: '菜单名称',
      field: 'menuZhName',
      isSearch: true
    },
    {
      title: '菜单编码',
      field: 'menuEnName',
      isSearch: true
    },
    {
      title: '菜单图标',
      field: 'menuIcon',
      isSearch: false
    },
    {
      title: '图标样式',
      field: 'iconStyle',
      isSearch: false
    },
    {
      title: '路由地址',
      field: 'routePath',
      isSearch: false,
      table: {
        align: 'left',
        width: '300px'
      }
    },
    {
      title: t('common.status'),
      field: 'status',
      dictType: DICT_TYPE.COMMON_STATUS,
      dictClass: 'number',
      isSearch: true,
      table: {
        slots: {
          default: 'status_default'
        }
      }
    },
    {
      title: '显示顺序',
      field: 'sort',
      form: {
        component: 'InputNumber',
        value: 0
      },
      isSearch: false
    },
    {
      title: '是否缓存',
      field: 'keepAlive',
      dictType: DICT_TYPE.INFRA_BOOLEAN_STRING,
      dictClass: 'number',
      isSearch: false
    },
    {
      title: t('common.createTime'),
      field: 'createTime',
      formatter: 'formatDate',
      isTable: false,
      isForm: false,
      search: {
        show: true,
        itemRender: {
          name: 'XDataTimePicker'
        }
      }
    }
  ]
})
export const { allSchemas } = useVxeCrudSchemas(crudSchemas)
