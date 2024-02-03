<template>
    <div class="search-div">
        <!-- 搜索表单 -->
        <el-form label-width="70px" size="small">
            <el-form-item label="角色名称">
                <el-input
                        v-model="queryDto.roleName"
                        style="width: 100%"
                        placeholder="请输入角色名称"
                        ></el-input>
            </el-form-item>
            <el-row style="display:flex">
                <el-button type="primary" size="small" @click="searchSysRole">
                    搜索
                </el-button>
                <el-button size="small" @click="resetData">重置</el-button>
            </el-row>
        </el-form>

        <!-- 添加按钮 -->
        <div class="tools-div">
            <el-button type="success" size="small">添 加</el-button>
        </div>
        
        <!--- 角色表格数据 -->
        <el-table :data="list" style="width: 100%">
            <el-table-column prop="roleName" label="角色名称" width="180" />
            <el-table-column prop="roleCode" label="角色code" width="180" />
            <el-table-column prop="createTime" label="创建时间" />
            <el-table-column label="操作" align="center" width="280">
            <el-button type="primary" size="small">
                修改
            </el-button>
            <el-button type="danger" size="small">
                删除
            </el-button>
            </el-table-column>
        </el-table>

        <!--分页条-->
        <el-pagination
                    v-model:current-page="pageParams.pageNum"
                    v-model:page-size="pageParams.pageSize"
                    :page-sizes="[10, 20, 50, 100]"
                    @size-change="fetchData"
                    @current-change="fetchData"
                    layout="total, sizes, prev, pager, next"
                    :total="total"
        />
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue';
import { GetSysRoleListByPage } from '@/api/sysRole'

// 分页条总记录数
let total = ref(0)

// 定义表格--角色列表数据模型
let list = ref([])

//分页数据
const pageParamsForm = {
  pageNum: 1, // 页码
  pageSize: 10, // 每页记录数
}
const pageParams = ref(pageParamsForm) // 将pageParamsForm包装成支持响应式的对象

// 搜索表单数据
const queryDto = ref({
    "roleName": "" 
})

// 页面加载完毕以后请求后端接口获取数据
onMounted(() => {
    fetchData() ;
})

// 搜索按钮点击事件处理函数
const searchSysRole = () => {
    fetchData() ;
}

// 重置
const resetData = () => {
    queryDto.value.roleName = ""
    fetchData() ;
}

// axios远程调用后端分页查询接口
const fetchData = async () => {
    const {data , code , message } = await GetSysRoleListByPage(pageParams.value.pageNum , pageParams.value.pageSize , queryDto.value) ;
    list.value = data.list ;
    total.value = data.total
}

</script>

<style scoped>

.search-div {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ebeef5;
  border-radius: 3px;
  background-color: #fff;
}

.tools-div {
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ebeef5;
  border-radius: 3px;
  background-color: #fff;
}

</style>