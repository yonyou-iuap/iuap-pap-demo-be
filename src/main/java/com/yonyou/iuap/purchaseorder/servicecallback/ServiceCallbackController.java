package com.yonyou.iuap.purchaseorder.servicecallback;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author shixtf
 * @description: 流程服务回调
 * @date 2019/4/9  20:07
 */
@Controller
public class ServiceCallbackController {

    private Logger logger = LoggerFactory.getLogger(ServiceCallbackImpl.class);

    @Autowired
    private ServiceCallbackImpl serviceCallback;



    @RequestMapping(value="/service/callback/success", method = {RequestMethod.POST})
    @ResponseBody
    public Object serviceCallback(@RequestBody Map<String, Object> data, HttpServletRequest request) {

        logger.error("流程服务回调成功 data=[{}]", JSONObject.toJSONString(data));

        serviceCallback.serviceCallback(data);

        JSONObject result = new JSONObject();
        result.put("msgSuccess", true);
        result.put("desc","ok" );
        return result;
    }



    @RequestMapping(value="/service/callback/error", method = {RequestMethod.POST})
    @ResponseBody
    public Object serviceCallbackError(@RequestBody Map<String, Object> data, HttpServletRequest request) {

        logger.error("流程服务回调成功 data=[{}]", JSONObject.toJSONString(data));

        serviceCallback.callbackError(data);

        JSONObject result = new JSONObject();
        result.put("msgSuccess", false);
        result.put("desc","服务回调异常" );
        return result;
    }


}
