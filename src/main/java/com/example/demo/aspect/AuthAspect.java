package com.example.demo.aspect;

import com.example.demo.common.Const;
import com.example.demo.common.Enum.UserTypeEnum;
import com.example.demo.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Aspect
@Component
public class AuthAspect {
    @Pointcut("@annotation(com.example.demo.aspect.RequireAuth))")
    public void auth() {

    }

    @Around("auth()")
    public Object doAuth(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        HttpSession session = request.getSession();
        MethodSignature signature = (MethodSignature) point.getSignature();
        RequireAuth annotation = signature.getMethod().getAnnotation(RequireAuth.class);
        UserTypeEnum role = annotation.role();
        System.out.println(role);
        User user = (User) session.getAttribute(Const.CUR_USER);
        if (user == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            if (role == user.getUserTypeEnum()) {
                return point.proceed(point.getArgs());
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return null;
    }
}
