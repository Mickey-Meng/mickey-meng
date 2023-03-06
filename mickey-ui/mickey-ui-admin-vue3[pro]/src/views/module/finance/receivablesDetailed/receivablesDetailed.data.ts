import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { required } from '@/utils/formRules'
import { VxeCrudSchema, useVxeCrudSchemas } from '@/hooks/web/useVxeCrudSchemas'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  receivablesId: [required]
})
// CrudSchema
const crudSchemas = reactive<VxeCrudSchema>({
  primaryKey: 'receivablesDetailedId', // 默认的主键ID
  primaryTitle: t('common.index'), // 默认显示的值
  primaryType: 'seq', // 默认为seq，序号模式
  action: true,
  actionWidth: '200', // 3个按钮默认200，如有删减对应增减即可
  columns: [
    {
      title: '收款单ID',
      field: 'receivablesId',
      isSearch: true
    },
    {
      title: '收据单号',
      field: 'receiptNumber',
      isSearch: true
    },
    {
      title: '收款账户',
      field: 'collectionAccount',
      isSearch: true
    },
    {
      title: '收款金额',
      field: 'itemCollectedAmount',
      isSearch: true
    },
    {
      title: '收款人',
      field: 'collectionUser',
      isSearch: true
    },
    {
      title: '收银员(财务)',
      field: 'cashierCode',
      isSearch: true
    },
    {
      title: '收款时间',
      field: 'collectionDate',
      form: {
        component: 'DatePicker',
        componentProps: {
          type: 'datetime',
          valueFormat: 'x'
        }
      },
      formatter: 'formatDate',
      search: {
        show: true,
        itemRender: {
          name: 'XDataTimePicker'
        }
      }
    },
    {
      title: '审核状态',
      field: 'approvalState',
      isSearch: true
    },
    {
      title: '备注',
      field: 'remarks',
      isSearch: true
    },
    {
      title: '创建时间',
      field: 'createTime',
      isForm: false,
      formatter: 'formatDate',
      search: {
        show: true,
        itemRender: {
          name: 'XDataTimePicker'
        }
      }
    },
    {
      title: '创建用户',
      field: 'creator',
      isSearch: true
    },
    {
      title: '修改用户',
      field: 'updater',
      isSearch: true
    }
  ]
})
export const { allSchemas } = useVxeCrudSchemas(crudSchemas)
