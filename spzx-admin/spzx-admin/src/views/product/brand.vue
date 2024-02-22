<template>
    <div class="tools-div">
        <el-button type="success" size="small">添 加</el-button>
    </div>

    <el-table :data="list" style="width: 100%">
        <el-table-column prop="name" label="品牌名称" />
        <el-table-column prop="logo" label="品牌图标" #default="scope">
            <img :src="scope.row.logo" width="50" />
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" />
        <el-table-column label="操作" align="center" width="200" >
            <el-button type="primary" size="small">
                修改
            </el-button>
            <el-button type="danger" size="small">
                删除
            </el-button>
        </el-table-column>
    </el-table>

    <el-pagination
               v-model:current-page="pageParams.page"
               v-model:page-size="pageParams.limit"
               :page-sizes="[10, 20, 50, 100]"
               layout="total, sizes, prev, pager, next"
               :total="total"
               @size-change="handleSizeChange"
               @current-change="handleCurrentChange"
               />

</template>

<script setup>
import { ref , onMounted } from 'vue'
import { GetBrandPageList } from '@/api/brand.js'

// 定义表格数据模型
const list = ref([])

// 分页条数据模型
const total = ref(0)

//分页条数据模型
const pageParamsForm = {
  page: 1, // 页码
  limit: 10, // 每页记录数
}
const pageParams = ref(pageParamsForm)

// 钩子函数
onMounted(()=> {
    fetchData()
})

//页面变化
const handleSizeChange = size => {
    pageParams.value.limit = size
    fetchData()
}
const handleCurrentChange = number => {
    pageParams.value.page = number
    fetchData()
}

// 分页查询
const fetchData = async () => {
   const {code , message , data} = await GetBrandPageList(pageParams.value.page , pageParams.value.limit) 
   list.value = data.list
   total.value = data.total
}

</script>

<style scoped>
.tools-div {
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ebeef5;
  border-radius: 3px;
  background-color: #fff;
}
</style>