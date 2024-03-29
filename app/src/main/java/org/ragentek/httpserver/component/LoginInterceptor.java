package org.ragentek.httpserver.component;

import android.support.annotation.NonNull;
import android.util.Log;

import com.yanzhenjie.andserver.annotation.Interceptor;
import com.yanzhenjie.andserver.error.BasicException;
import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.framework.handler.MethodHandler;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yanzhenjie.andserver.http.session.Session;
import com.yanzhenjie.andserver.mapping.Addition;

import org.apache.commons.lang3.ArrayUtils;

@Interceptor
public class LoginInterceptor implements HandlerInterceptor {

    public static final String LOGIN_ATTRIBUTE = "USER.LOGIN.SIGN";

    @Override
    public boolean onIntercept(@NonNull HttpRequest request, @NonNull HttpResponse response,
                               @NonNull RequestHandler handler) {
        Log.i("jingyi", "onIntercept");

        if (handler instanceof MethodHandler) {
            MethodHandler methodHandler = (MethodHandler)handler;
            Addition addition = methodHandler.getAddition();
            if (!isLogin(request, addition)) {
                throw new BasicException(401, "You are not logged in yet.");
            }
        }
        return false;
    }

    private boolean isNeedLogin(Addition addition) {

        Log.i("jingyi", "isNeedLogin 1");

        if (addition == null) return false;

        String[] stringType = addition.getStringType();
        Log.i("jingyi", "isNeedLogin 2");
        if (ArrayUtils.isEmpty(stringType)) return false;

        boolean[] booleanType = addition.getBooleanType();
        Log.i("jingyi", "isNeedLogin 3");
        if (ArrayUtils.isEmpty(booleanType)) return false;
        Log.i("jingyi", "isNeedLogin "+stringType[0]+"  "+booleanType[0]);
        return stringType[0].equalsIgnoreCase("login") && booleanType[0];
    }

    private boolean isLogin(HttpRequest request, Addition addition) {
        Log.i("jingyi", "isLogin");

        if (isNeedLogin(addition)) {
            Session session = request.getSession();
            if (session != null) {
                Object o = session.getAttribute(LOGIN_ATTRIBUTE);
                return o != null && (o instanceof Boolean) && ((boolean)o);
            }
            return false;
        }
        return true;
    }
}
