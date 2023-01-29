import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { required } from '@/utils/formRules'
import { VxeCrudSchema, useVxeCrudSchemas } from '@/hooks/web/useVxeCrudSchemas'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  status: [required]
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
      title: '昵称',
      field: 'nickname',
      isSearch: true
    },
    {
      title: '真实姓名',
      field: 'realName',
      isSearch: true
    },
    {
      title: '年龄',
      field: 'age',
      form: {
        component: 'InputNumber',
        value: 0
      },
      isSearch: false
    },
    {
      title: '性别',
      field: 'gender',
      isSearch: true
    },
    {
      title: '身份证号码',
      field: 'idCardNumber',
      isSearch: true
    },
    {
      title: '手机号码',
      field: 'phoneNumber',
      isSearch: true
    },
    {
      title: '微信号',
      field: 'wechatId',
      isSearch: true
    },
    {
      title: 'QQ号码',
      field: 'qqNumber',
      isSearch: true
    },
    {
      title: '邮箱',
      field: 'email',
      isSearch: true
    },
    {
      title: '出生日期',
      field: 'birthday',
      isSearch: true
    },
    {
      title: '头像',
      field: 'portrait',
      isSearch: false
    },
    {
      title: '个性签名',
      field: 'signature',
      isSearch: false
    },
    {
      title: '状态',
      field: 'status',
      form: {
        component: 'InputNumber',
        value: 0
      }
    },
    {
      title: '注册方式',
      field: 'logonMode',
      isSearch: true
    },
    {
      title: '业主类型',
      field: 'ownerType'
    },
    {
      title: '排序',
      field: 'sort',
      form: {
        component: 'InputNumber',
        value: 0
      },
      isSearch: false
    },
    {
      title: '备注',
      field: 'remark',
      isSearch: false
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
    }
  ]
})
export const { allSchemas } = useVxeCrudSchemas(crudSchemas)
