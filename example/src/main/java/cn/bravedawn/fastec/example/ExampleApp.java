package cn.bravedawn.fastec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.bravedawn.latte.app.Latte;
import cn.bravedawn.fastec.example.event.TestEvent;
import cn.bravedawn.latte.ec.database.DatabaseManager;
import cn.bravedawn.latte.ec.icon.FontEcModule;
import cn.bravedawn.latte.net.Interceptors.DebugInterceptor;
import cn.bravedawn.latte.net.rx.AddCookiesInterceptor;

/**
 * Created by 冯晓 on 2017/9/13.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                // load延迟
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1:8080")
                // 数据源
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withInterceptor(new DebugInterceptor("sort_list", R.raw.sort_list_data))
                .withInterceptor(new DebugInterceptor("sort_content_list", R.raw.sort_content_data_1))
                .withInterceptor(new DebugInterceptor("shop_cart_data", R.raw.shop_cart_data))
                .withInterceptor(new DebugInterceptor("shop_cart_count", R.raw.shop_cart_data))
                // 微信
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                // js事配置
                .withJavascriptInterface("latte")
                // web事件
                .withWebEvent("test", new TestEvent())
                // 添加cookie同步拦截器
                .withInterceptor(new AddCookiesInterceptor())
                // 浏览器加载的host
                .withWebHost("https://www.baidu/com/") //记得加一斜杆
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }

}
