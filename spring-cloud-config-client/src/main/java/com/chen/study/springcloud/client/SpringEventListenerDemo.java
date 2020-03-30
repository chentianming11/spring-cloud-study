package com.chen.study.springcloud.client;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring事件：
 *  ApplicationEvent ：根据order控制顺序，数值越小，优先级越高
 *  实现Order接口或者@Order
 * @author 陈添明
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        // spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册监听器
        context.addApplicationListener((ApplicationListener<MyAppEvent>) event ->
                System.out.println("收到事件：source=" + event.getSource() +
                ", context=" + event.getContext()));
        context.refresh();

        // 发布事件
        context.publishEvent(new MyAppEvent(context,"自定义事件！！！"));
        context.publishEvent(new MyAppEvent(context, 1000));
    }


    @Getter
    public static class MyAppEvent extends ApplicationEvent {

        private final ApplicationContext context;

        public MyAppEvent(ApplicationContext context, Object source) {
            super(source);
            this.context = context;
        }
    }
}
