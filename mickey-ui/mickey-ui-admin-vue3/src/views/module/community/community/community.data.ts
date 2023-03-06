import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { required } from '@/utils/formRules'
import { VxeCrudSchema, useVxeCrudSchemas } from '@/hooks/web/useVxeCrudSchemas'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  communityName: [required],
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
      title: '小区名称',
      field: 'communityName',
      isSearch: true
    },
    {
      title: '小区编码',
      field: 'communityCode',
      isSearch: true
    },
    {
      title: '省区划码',
      field: 'provincesCode',
      isSearch: true
    },
    {
      title: '市区划码',
      field: 'cityCode',
      isSearch: true
    },
    {
      title: '区县区划码',
      field: 'district Code',
      isSearch: true
    },
    {
      title: '乡镇划码',
      field: 'townCode',
      isSearch: false
    },
    {
      title: '详细地址',
      field: 'detailedAddress',
      isSearch: true
    },
    {
      title: '经度',
      field: 'longitude',
      isSearch: false
    },
    {
      title: '纬度',
      field: 'latitude',
      isSearch: false
    },
    {
      title: '物业ID',
      field: 'propertyId',
      form: {
        component: 'InputNumber',
        value: 0
      },
      isSearch: true
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
