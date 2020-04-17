package fun.oook.webchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2018/10/22 12:27
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 注册视图控制器
     *
     * @param registry re
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/about").setViewName("about");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置Server虚拟路径，handler为前台访问的目录，location为对应的本地目录
        registry.addResourceHandler("/file/speech/**").addResourceLocations("file:D:\\workspace\\fileUpload\\mp3" + File.separator);
        registry.addResourceHandler("/static/canvas/**").addResourceLocations("file:D:\\workspace\\practise\\idea\\apps\\web-chat\\src\\main\\resources\\static\\canvas\\");
        registry.addResourceHandler("/static/video/**").addResourceLocations("file:E:\\FBI\\未成年勿入\\18\\");
    }
}
