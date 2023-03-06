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
  primaryKey: 'receivablesId', // 默认的主键ID
  primaryTitle: t('common.index'), // 默认显示的值
  primaryType: 'seq', // 默认为seq，序号模式
  action: true,
  actionWidth: '200', // 3个按钮默认200，如有删减对应增减即可
  columns: [
    {
      title: '客户编码',
      field: 'customerCode',
      isSearch: true
    },
    {
      title: '客户名称',
      field: 'customerName',
      isSearch: true
    },
    {
      title: '联系电话',
      field: 'telephoneNo',
      isSearch: true
    },
    {
      title: '地址',
      field: 'address',
      isSearch: true
    },
    {
      title: '销售渠道',
      field: 'salesChannel',
      isSearch: true
    },
    {
      title: '导购员',
      field: 'shoppingGuide',
      isSearch: true
    },
    {
      title: '销售金额',
      field: 'salesAmount',
      isSearch: true
    },
    {
      title: '优惠金额',
      field: 'preferentialAmount',
      isSearch: true
    },
    {
      title: '退货金额',
      field: 'refundGoodsAmount',
      isSearch: true
    },
    {
      title: '退款金额',
      field: 'refundAmount',
      isSearch: true
    },
    {
      title: '收款金额',
      field: 'collectedAmount',
      isSearch: true
    },
    {
      title: '应收余额',
      field: 'receivableBalance',
      isSearch: true
    },
    {
      title: '应收金额',
      field: 'receivableAmount',
      isSearch: true
    },
    {
      title: '是否结清',
      field: 'isSettle',
      isSearch: true
    },
    {
      title: '备注',
      field: 'remarks',
      isSearch: true
    },
    {
      title: '审核状态',
      field: 'approvalState',
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
      title: '货物类型',
      field: 'goodsType'
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
