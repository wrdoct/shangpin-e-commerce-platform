const Layout = () => import('@/layout/index.vue')

export default [
  {
    path: '/base',
    component: Layout,
    name: 'base',
    meta: {
      title: '基础数据管理',
    },
    icon: 'Histogram',
    children: [

    ],
  },
]