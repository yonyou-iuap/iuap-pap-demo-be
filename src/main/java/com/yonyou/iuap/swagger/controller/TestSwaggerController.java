package com.yonyou.iuap.swagger.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
* @author liuklm:
* @version 创建时间：2018年11月21日 下午2:11:41
* 类说明  swagger test class 
*/
@RestController
@RequestMapping("/test_swagger")
@Api(tags = "TestSwagger接口",description="TestSwagger文档说明",hidden=true)
public class TestSwaggerController {
	
	@RequestMapping(value="selectAll",method=RequestMethod.GET)
	@ApiOperation(value="查询所有的人员",notes="查询所有的人员接口说明")
	@ApiImplicitParams({
		@ApiImplicitParam(name="month",value="年月，格式为：201801",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="pageSize",value="页码",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="pageNum",value="每页条数",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="empName",value="业务员名称",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="orderType",value="排序类型",dataType="String", paramType = "query"),
	})
	@ApiResponse(response=String.class, code = 200, message = "接口返回对象参数")
	public void selectAll(HttpServletRequest request) {
		System.out.println("查询所有的人员接口输出######");
	}
	
	@ApiOperation(value="根据id查询人员",notes="根据id查询人员接口")
	@ApiImplicitParam(name="id",value="用户ID",dataType="String", paramType = "query")
	@ApiResponse(response=String.class, code = 200, message = "接口返回对象参数")
	@RequestMapping(value="findById",method=RequestMethod.POST)
	@ResponseBody
	public Object findById(Integer id) {
		System.out.println("根据id查询人员接口");
		return new Object();
	}
	
	@ResponseBody
    @RequestMapping(value ="/getUserName", method= RequestMethod.GET)
    @ApiOperation(value="根据用户编号获取用户姓名", notes="可记录正确返回值")
    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public String getUserName(@RequestParam Integer userNumber){
       return "liuklm";
        
    }
    
    @ResponseBody
    @RequestMapping("/updatePassword")
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
        @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password, 
            @RequestParam(value="newPassword") String newPassword){
      if(userId <= 0 || userId > 2){
          return "未知的用户";
      }
      if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
          return "密码不能为空";
      }
      if(password.equals(newPassword)){
          return "新旧密码不能相同";
      }
      return "密码修改成功!";
    }
	
}
