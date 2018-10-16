package ua.andrZav.infrastructure.config.web;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@Component
public class ModelInterceptor extends HandlerInterceptorAdapter {

  @Resource
  ApplicationContext applicationContext;
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      modelAndView.addObject("env", applicationContext.getEnvironment().getActiveProfiles()[0]);
      modelAndView.addObject("timestamp", Instant.now().toEpochMilli());
  }
}
