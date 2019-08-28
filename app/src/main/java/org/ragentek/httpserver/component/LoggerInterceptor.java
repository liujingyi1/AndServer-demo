package org.ragentek.httpserver.component;

import android.support.annotation.NonNull;
import android.util.Log;

import com.yanzhenjie.andserver.annotation.Interceptor;
import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpMethod;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yanzhenjie.andserver.util.MultiValueMap;

import org.ragentek.httpserver.util.JsonUtils;

@Interceptor
public class LoggerInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean onIntercept(@NonNull HttpRequest request, @NonNull HttpResponse response,
                               @NonNull RequestHandler handler) {
        String path = request.getPath();
        HttpMethod method = request.getMethod();
        MultiValueMap<String, String> valueMap = request.getParameter();
        Log.i("jingyi", "Path: " + path);
        Log.i("jingyi", "Method: " + method.value());
        Log.i("jingyi", "Param: " + JsonUtils.toJsonString(valueMap));
        return false;
    }
}
