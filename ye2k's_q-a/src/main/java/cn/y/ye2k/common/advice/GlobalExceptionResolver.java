package cn.y.ye2k.common.advice;

import cn.y.ye2k.common.exceptions.Ye2kException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常捕获
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
@ControllerAdvice
public class GlobalExceptionResolver extends DefaultHandlerExceptionResolver {

    /**
     * 接受自定义的运行时异常
     * @param e 异常信息对象
     * @return 提示信息
     */
    @ExceptionHandler(Ye2kException.class)
    public ResponseEntity<ExceptionResult> handleLyException(Ye2kException e) {
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e));
    }

    /**
     * 接受非自定义的运行时异常
     * @param e 异常信息对象
     * @return 提示信息
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getServletPath();
        //返回异常拦截
        if (url.startsWith("/")) {
            if (ex instanceof HttpRequestMethodNotSupportedException) {
                setResponseParam(response, 405, "请求方式错误！");
                return null;
            }
            if (ex instanceof MissingServletRequestParameterException) {
                setResponseParam(response, 400, "错误请求！");
                return null;
            }
            if (ex instanceof NoHandlerFoundException) {
                //可以进行其他方法处理，LOG或者什么详细记录，我这里直接返回JSON
                setResponseParam(response, 404, "请求路径错误！");
                return null;
            }
            setResponseParam(response, 500, "服务器内部错误！服务暂时不可用！");
            return null;
        }

        //这里调用父类的异常处理方法，实现其他不需要的异常交给SpringMVC处理
        return super.doResolveException(request, response, handler, ex);

    }

    private void setResponseParam(HttpServletResponse response, int code, String msg) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(code + msg);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(json);
    }
}