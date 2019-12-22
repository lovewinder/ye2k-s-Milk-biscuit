package cn.y.ye2k.interceptor;

import cn.y.ye2k.common.enums.StringConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录拦截器
 *
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 无需拦截的url集合
     */
    private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    /**
     * 最后执行，通常用于释放资源，处理异常。我们可以根据ex是否为空，来进行相关的异常处理。
     * 因为我们在平时处理异常时，都是从底层向上抛出异常，最后到了spring框架从而到了这个方法中。
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) {
        // TODO Auto-generated method stub

    }

    /**
     * 该方法在action执行后，生成视图前执行。在这里，我们有机会修改视图层数据。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) {
        // TODO Auto-generated method stub

    }

    /**
     * 该方法在action执行前执行，可以实现对数据的预处理，
     * 比如：编码、安全控制等。如果方法返回true，则继续执行action。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        //本地开发用
        return true;

/*        //获取请求的URL
        String requestUri = request.getRequestURI();
        if (requestUri.startsWith(request.getContextPath())) {
            requestUri = requestUri.substring(request.getContextPath().length());
        }
        //系统根目录
*//*        if (StringUtils.equals(StringConstant.SYSTEMROOT, requestUri)) {
            return true;
        }*//*
        //放行exceptUrls中配置的url
        for (String url : exceptUrls) {
            if (url.endsWith("/**")) {
                if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
                    return true;
                }
            } else if (requestUri.startsWith(url)) {
                return true;
            }
        }
        //其他需要登录后才能进行访问的url
        String sessionid = request.getSession().getId();
        Object obj = request.getSession().getAttribute("users");
        if (obj != null) {
            return true;
        }
        response.sendRedirect("/login.html");
        return false;*/
    }

}
