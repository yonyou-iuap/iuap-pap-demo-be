package com.yonyou.iuap.passenger.controller;

import com.yonyou.iuap.baseservice.print.controller.GenericPrintController;
import com.yonyou.iuap.passenger.entity.Passenger;
import com.yonyou.iuap.passenger.service.EmergencyContactService;
import com.yonyou.iuap.passenger.service.PassengerService;
import com.yonyou.iuap.passenger.service.TravelingInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：Passenger员工乘客信息 打印Controller——提供数据打印回调rest接口
 * 
 * @date 2018-10-25 20:12:16
 */
@Controller
@RequestMapping(value="/passenger")
public class PassengerPrintController extends GenericPrintController<Passenger> {

    private Logger logger = LoggerFactory.getLogger(PassengerController.class);


    private PassengerService service;
    private EmergencyContactService emergencyContactService;
    private TravelingInformationService travelingInformationService;

    @Autowired
    public void setService(PassengerService service) {
        this.service = service;
        super.setService(service);
    }
    
    @Autowired
    public void setEmergencyContactService(EmergencyContactService emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
        super.setSubService("EMERGENCY_CONTACT",emergencyContactService);
    }

    @Autowired
    public void setTravelingInformationService(TravelingInformationService travelingInformationService) {
        this.travelingInformationService = travelingInformationService;
        super.setSubService("TRAVELING_INFORMATION",travelingInformationService);
    
    }
}
