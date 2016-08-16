package interceptor;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by Xiaofeng on 2016/8/16.
 */
public class TestInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        if(true){
            //继续执行被拦截的方法
            inv.invoke();
        }else {

        }
    }
}
