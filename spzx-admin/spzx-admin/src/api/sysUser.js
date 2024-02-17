import request from '@/utils/request'

const base_api = '/admin/system/sysUser'

// 分页查询
export const GetSysUserListByPage = (pageNum , pageSize , queryDto) => {
    return request({
        url: `${base_api}/findByPage/${pageNum}/${pageSize}`,
        method: 'get',
        params: queryDto
    })
}

// 新增用户的方法
export const SaveSysUser = (data) => {
    return request({
        url: `${base_api}/saveSysUser`,
        method: "post",
        data
    })
}

// 修改用户数据的方法
export const UpdateSysUser = (sysUser) => {
    return request({
        url: `${base_api}/updateSysUser`,
        method: "put",
        data: sysUser
    })
}

// 根据id删除用户
export const DeleteSysUserById = (userId) => {
    return request({
        url: `${base_api}/deleteById/${userId}`,
        method: 'delete'
    })
}
