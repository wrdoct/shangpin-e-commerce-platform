const Layout = () => import('@/layout/index.vue')

export default [
  {
    path: '/users',
    component: Layout,
    name: 'users',
    meta: {
      title: '会员管理',
    },
    icon: 'User',
    children: [

    ],
  },
]