class BusinessLogConfig_purchaseOrder {

    def context;
    
    def purchaseOrder_saveAssoVo() {
        "请购单：执行保存或修改方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time},编码为${context._methodReturn.orderCode}"
    }
    
    def purchaseOrder_deleteBatch() {
        "请购单：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
   		 
   def purchaseOrder_deleAssoVo() {
        "请购单：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
    
    def purchaseOrderDetail_deleteBatch() {
        "请购单：执行删除方法:IP地址为${context._ip},USER用户为${context._user},TIME操作时间为${context._time}"
    }
}
