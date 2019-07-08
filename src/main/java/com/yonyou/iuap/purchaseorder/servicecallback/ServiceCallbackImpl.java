package com.yonyou.iuap.purchaseorder.servicecallback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.yonyou.iuap.pap.msg.sdk.MessageSendSdk;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yonyou.bpm.rest.BpmRests;
import yonyou.bpm.rest.HistoryService;
import yonyou.bpm.rest.exception.RestException;
import yonyou.bpm.rest.param.BaseParam;
import yonyou.bpm.rest.request.historic.HistoricProcessInstancesQueryParam;
import yonyou.bpm.rest.response.runtime.process.ProcessInstanceResponse;
import yonyou.bpm.rest.utils.BaseUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shixtf
 * @description:
 * @date 2019/4/18  21:24
 */
@Service
public class ServiceCallbackImpl {


    private static final String TENANTID = "tenantId";
    private static final String NOTICE = "notice";
    private static final String SENDER = "sender";
    private static final String RECEIVER_ARRAY = "receiverArray";
    private static final String MSG_CHANNEL_ARRAY = "msgChannelArray";
    private static final String MSGTYPE = "msgType";

    private Logger logger = LoggerFactory.getLogger(ServiceCallbackImpl.class);

    @Value("${bpmrest.server}")
    private String serverUrl;
    @Value("${bpmrest.tenant}")
    private String tenant;
    @Value("${bpmrest.token}")
    private String token;



    /* *
     * @author shixtf
     * @description
     *  流程服务回调
     *  data {
              "processEnd": false,
              "userPhone": "13609888888",
              "language": "zh-CN",
              "tenantCode": "ssuiy6kk",
              "userName": "花-租户管理员04",
              "userId": "d1723bc1-ee55-4a8b-ad8a-1dd5e55d3954",
              "userCode": "YHT-808-8031553501319258",
              "processDefinitionKey": "eiap329168",
              "businessKey": "2e3177cc-0771-43d6-b496-aa0d3c22410a",
              "tenantId": "ssuiy6kk",
              "processInstId": "6da190ef-5ac6-11e9-87f2-00ff1b1d586c"
            }
     *
     * @date  2019/4/9  20:56
     **/
    public void serviceCallback(Map<String, Object> data) {

        boolean processEnd = (boolean)data.get("processEnd");
        String userPhone = (String )data.get("userPhone");
        String language = (String )data.get("language");
        String tenantCode = (String )data.get("tenantCode");
        String userName = (String )data.get("userName");
        String userId = (String )data.get("userId");
        String userCode = (String )data.get("userCode");
        String processDefinitionKey = (String )data.get("processDefinitionKey");
        String tenantId = (String )data.get("tenantId");
        String processInstId = (String )data.get("processInstId");
        ProcessInstanceResponse process = null;
        process = getProcessInstanceById(processInstId,userId,tenantId);


        StringBuffer content = new StringBuffer();
        if (process != null) {
            content.append(process.getName()).append("   ").append("流程服务回调成功");
        }
        content.append("  ");
        content.append("回调返回信息; processEnd= ").append(processEnd).append("  ");
        content.append("tenantCode=").append(tenantCode).append("  ");
        content.append("userPhone=").append(userPhone).append("  ");
        content.append("language=").append(language).append("  ");
        content.append("userName=").append(userName).append("  ");
        content.append("userId=").append(userId).append("  ");
        content.append("userCode=").append(userCode).append("  ");
        content.append("processDefinitionKey=").append(processDefinitionKey).append("  ");
        content.append("tenantId=").append(tenantId).append("  ");
        content.append("processInstId=").append(processInstId).append("  ");

        Map<String, Object> textParamMap = new HashMap<>(16);
        String[] channelArray = {"sys"};
        String[] receiverArray = null;
        if (StringUtils.isNotBlank(userId)) {
            receiverArray = new String[] {userId};
        }
        if ( receiverArray == null && process != null && process.getStartParticipant() != null  && StringUtils.isNotBlank(process.getStartParticipant().getId())) {
            receiverArray = new String[]{process.getStartParticipant().getId()};
        }
        textParamMap.put("subject", "流程回调服务成功");
        textParamMap.put("content", content.toString());
        textParamMap.put(MSGTYPE, NOTICE);
        textParamMap.put(TENANTID,tenantId);
        textParamMap.put(MSG_CHANNEL_ARRAY, channelArray);
        textParamMap.put(SENDER, userId);
        textParamMap.put(RECEIVER_ARRAY, receiverArray);
        MessageSendSdk.sendTextMessage(JSON.toJSONString(textParamMap));
    }


    private ProcessInstanceResponse getProcessInstanceById(String processInstId,String userId, String tenantId) {
        ProcessInstanceResponse process = null;
        try {
            BaseParam baseParam = new BaseParam();
            baseParam.setServer(serverUrl);
            baseParam.setTenant(tenant);
            baseParam.setOperatorID("U001");
            baseParam.setClientToken(token);
            baseParam.setTenantLimitId(tenantId);
            HistoryService historyService  = BpmRests.getBpmRest(baseParam).getHistoryService();
            HistoricProcessInstancesQueryParam queryParam = new HistoricProcessInstancesQueryParam();
            queryParam.setProcessInstanceId(processInstId);
            JsonNode jsonNode = (JsonNode) historyService.getHistoricProcessInstances(queryParam);
            ArrayNode arrayNode = BaseUtils.getData(jsonNode);
            if (arrayNode != null && arrayNode.size() > 0) {
                process = JSONObject.parseObject(arrayNode.get(0).toString(), ProcessInstanceResponse.class);
            }

        } catch (RestException e) {
            logger.error("根据流程id=[{}] 查询历史流程实例异常", processInstId, e);
        }
        return process;
    }




    public void callbackError(Map<String, Object> data) {
        Map<String, Object> textParamMap = new HashMap<>(16);

        String userId = (String )data.get("userId");
        String tenantId = (String )data.get("tenantId");
        String processInstId = (String )data.get("processInstId");
        ProcessInstanceResponse process = null;
        process = getProcessInstanceById(processInstId,userId,tenantId);

        String[] channelArray = {"sys"};
        String[] receiverArray = null;
        if (StringUtils.isNotBlank(userId)) {
            receiverArray = new String[] {userId};
        }
        if ( receiverArray == null && process != null && process.getStartParticipant() != null  && StringUtils.isNotBlank(process.getStartParticipant().getId())) {
            receiverArray = new String[]{process.getStartParticipant().getId()};
        }
        textParamMap.put("subject", "流程回调服务失败");
        textParamMap.put("content","流程服务回调失败");
        textParamMap.put(MSGTYPE, NOTICE);
        textParamMap.put(TENANTID,tenantId);
        textParamMap.put(MSG_CHANNEL_ARRAY, channelArray);
        textParamMap.put(SENDER, userId);
        textParamMap.put(RECEIVER_ARRAY, receiverArray);
        MessageSendSdk.sendTextMessage(JSON.toJSONString(textParamMap));
    }
}
