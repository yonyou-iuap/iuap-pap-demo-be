class BusinessLogConfig_tree {

    def context;
    
    def tableDemo_insertSelective() {
        "表信息：执行保存方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.name}"
    }
    
    def tableDemo_deleteBatch() {
        "表信息：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
    
    def tableDemo_updateSelective() {
        "表信息：执行修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.name}"
    }
    
}
