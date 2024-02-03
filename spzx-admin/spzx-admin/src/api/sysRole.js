import request from '@/utils/request'

const base_api = '/admin/system/sysRole'

// 分页角色列表
export const GetSysRoleListByPage = (pageNum , pageSize , queryDto) => {
    return request({
        // url: '/admin/system/sysRole/findByPage/' + pageNum + "/" + pageSize, // 路径
        url: `${base_api}/findByPage/${pageNum}/${pageSize}`, // 路径 // ``模板字符串
        method: 'post', // 提交方式
        // 接口@RequestBody；前端data:名称，以json格式传输 
        data: queryDto // 其他参数 
        // 接口没有注解；前端params:名称
        // params: queryDto
    })
}
