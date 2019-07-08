class BusinessLogConfig_model {

    def context;
    
    def model_insertSelective() {
        "视图模型：执行保存方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.modelName}"
    }
    
    def model_deleteBatch() {
        "视图模型：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
    
    def model_updateSelective() {
        "视图模型：执行修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.modelName}"
    }
    
    def model_save() {
        "视图模型：执行添加或修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.modelName}"
    }
}
