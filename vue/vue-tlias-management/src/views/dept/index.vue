<script setup>
import { onMounted, ref } from "vue";
import {queryAllApi, addApi, queryByIdApi, updateApi, deleteByIdApi} from "@/api/dept";
import { ElMessage } from 'element-plus'

onMounted(() => {
  search()
})

const search = async () => {
  const result = await queryAllApi();
  if (result.code){
    deptList.value = result.data
  }
}

const deptList = ref([])

// Dialog对话框
const dialogFormVisible = ref(false)

const dept = ref({
  name: ''
})

const formTitle = ref('')

const addDept = () => {
  dialogFormVisible.value = true
  formTitle.value = '新增部门'
  dept.value = {name: ''}
  if (deptFormRef.value){
    deptFormRef.value.resetFields()
  }

}

const save = async () => {
  //表单校验
  if (!deptFormRef.value) return;
  deptFormRef.value.validate(async (valid) => {
    if (valid) {
      let result;
      if (dept.value.id){  //修改
        result = await updateApi(dept.value)
      } else {
        result  = await addApi(dept.value);
      }
      if (result.code) {
        ElMessage.success('操作成功')
        dialogFormVisible.value = false
        search()
      } else {
        ElMessage.error(result.msg)
      }
    } else {
      ElMessage.error("表单校验不通过")
    }
  })
}


const rules = ref({
  name: [
    { required: true, message: '部门名称是必填项', trigger: 'blur' },
    { min: 2, max: 10, message: '部门名称长度应该在2-10位之间', trigger: 'blur' },
  ],
})

const deptFormRef = ref()

//编辑
const edit = async (id) => {
  formTitle.value = '修改部门'
  const result = await queryByIdApi(id)
  if (result.code) {
    dialogFormVisible.value = true
    dept.value = result.data
  }
}

//删除
const delById = (id) => {

}

</script>

<template>
  <h1>部门管理</h1>
  <div class="container">
    <el-button type="primary" @click="addDept">+ 新增部门</el-button>
  </div>

<!--  表格-->
  <div class="container">
    <el-table :data="deptList" border style="width: 100%">
      <el-table-column type="index" label="序号" width="100" align="center"/>
      <el-table-column prop="name" label="部门名称" width="260" align="center"/>
      <el-table-column prop="updateTime" label="最后操作时间" width="300" align="center"/>
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="edit(scope.row.id)"><el-icon><EditPen /></el-icon>编辑</el-button>
          <el-button type="danger" size="small" @click="delById(scope.row.id)"><el-icon><Delete /></el-icon>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

<!--  Dialog对话框-->
  <el-dialog v-model="dialogFormVisible" :title="formTitle" width="500">
    {{dept}}
    <el-form :model="dept" :rules="rules" ref="deptFormRef">
      <el-form-item label="部门名称" label-width=80px prop="name">
        <el-input v-model="dept.name" autocomplete="off" />
      </el-form-item>

    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </div>
    </template>
  </el-dialog>

</template>

<style scoped>
.container {
  margin: 10px 0px;
}
</style>
