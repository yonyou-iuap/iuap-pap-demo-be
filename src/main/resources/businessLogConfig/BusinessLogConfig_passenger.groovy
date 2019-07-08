class BusinessLogConfig_passenger {

    def context;
    
    def emergencyContact_insertSelective() {
        "紧急联系人：执行保存方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.contactName}"
    }
    
    def emergencyContact_deleteBatch() {
        "紧急联系人：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
    
    def emergencyContact_updateSelective() {
        "紧急联系人：执行修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.contactName}"
    }
    
        
    def travelingInformation_insertSelective() {
        "乘车信息：执行保存方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.line}"
    }
    
    def travelingInformation_deleteBatch() {
        "乘车信息：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
    
    def travelingInformation_updateSelective() {
        "乘车信息：执行修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},名称为${context._param0.line}"
    }
    
    
    def passenger_insertSelective() {
        "员工津贴：执行保存方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},编码为${context._methodReturn.code},名称为${context._param0.name}"
    }
    
    def passenger_deleteBatch() {
        "员工津贴：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
    
    def passenger_updateSelective() {
        "员工津贴：执行修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},编码为${context._methodReturn.code},名称为${context._param0.name}"
    }
    
}
