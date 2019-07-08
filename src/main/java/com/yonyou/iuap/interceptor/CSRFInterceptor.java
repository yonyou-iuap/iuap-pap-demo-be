package com.yonyou.iuap.interceptor;

import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.iuap.CSRFToken;
import com.yonyou.iuap.cache.CacheManager;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.mvc.type.JsonErrorResponse;
import com.yonyou.iuap.mvc.type.JsonResponse;

@Component
public class CSRFInterceptor extends HandlerInterceptorAdapter {
	private Logger logger;
	public static final String RANDOM = "random-num";
	public static final String TOKEN = "x-xsrf-token";
	@Autowired
	private CacheManager cacheManager;

	public CSRFInterceptor() {
		this.logger = LoggerFactory.getLogger(CSRFInterceptor.class);
	}

	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		boolean result = true;
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Method method = handlerMethod.getMethod();
			final CSRFToken CSRFToken = method.getAnnotation(CSRFToken.class);
			if (CSRFToken != null && CSRFToken.verify()) {
				final RequestMapping classRequestMapping = method.getDeclaringClass()
						.getAnnotation(RequestMapping.class);
				final String classPath = classRequestMapping.value()[0];
				if (!this.verifyCSRFToken(request, classPath)) {
					response.setContentType("application/json;charset=UTF-8");
					response.setStatus(403);
					final String MSG = "非法请求！";
					this.logger.warn(MSG);
					final JsonResponse json = this.buildGlobalError(MSG);
					final PrintWriter out = response.getWriter();
					out.print(JSONObject.toJSONString((Object) json));
					response.flushBuffer();
					result = false;
				}
			}
		}
		this.setCSRFTokenHeader(request, response, handler);
//		final Enumeration<String> names = (Enumeration<String>) request.getParameterNames();
//		this.setCSRFTokenHeader(request, response, handler);
		return result;
	}

	public JsonResponse buildGlobalError(final String msg) {
		final JsonErrorResponse errorResponse = new JsonErrorResponse();
		errorResponse.setMessage(StringEscapeUtils.escapeHtml(msg));
		return (JsonResponse) errorResponse;
	}

	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {
	}

	private void setCSRFTokenHeader(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler) {
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Method method = handlerMethod.getMethod();
			final CSRFToken CSRFToken = method.getAnnotation(CSRFToken.class);
			if (CSRFToken != null && CSRFToken.refresh()) {
				final RequestMapping classRequestMapping = method.getDeclaringClass()
						.getAnnotation(RequestMapping.class);
				final String classPath = classRequestMapping.value()[0];
				String randomNum = request.getParameter(RANDOM);
				if (randomNum == null) {
					randomNum = request.getHeader(RANDOM);
				}
				final Random random = ThreadLocalRandom.current();
				final String xsrfTokenStr = random.nextLong() + "";
				this.cacheManager.hset(TOKEN,
						classPath + "_" + randomNum + "_" + InvocationInfoProxy.getToken(),
						(Serializable) xsrfTokenStr);
				response.setHeader(TOKEN, xsrfTokenStr);
			}
		}
	}

	protected boolean verifyCSRFToken(final HttpServletRequest request, final String csrftokenKey) {
		String reqXsrfToken = request.getParameter(TOKEN);
		String randomNum = request.getParameter(RANDOM);
		if (reqXsrfToken == null) {
			reqXsrfToken = request.getHeader(TOKEN);
		}
		if (randomNum == null) {
			randomNum = request.getHeader(RANDOM);
		}
		final String sessionXsrfToken = (String) this.cacheManager.hget(TOKEN,
				csrftokenKey + "_" + randomNum + "_" + InvocationInfoProxy.getToken());
		return reqXsrfToken != null && reqXsrfToken.equals(sessionXsrfToken);
	}
}