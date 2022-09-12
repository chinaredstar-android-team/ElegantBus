/*
 * ************************************************************
 * 文件：Event.java  模块：ElegantBus.lib.main  项目：ElegantBus
 * 当前修改时间：2022年09月12日 17:58:58
 * 上次修改时间：2022年09月12日 17:47:29
 * 作者：Cody.yi   https://github.com/codyer
 *
 * 描述：ElegantBus.lib.main
 * Copyright (c) 2022
 * ************************************************************
 */

package cody.bus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xu.yi. on 2019/3/31.
 * 事件类型,定义在枚举值上，定义事件名称和事件携带的数据类型
 * eg: @EventGroup(name = "MyApp",active = true)
 * public class MyApp {
 * <p>
 * { @Event }(value = "简单不支持多进程的事件", active = false)
 * String testString;
 * <p>
 * { @Event }(description = "支持多进程的事件测试对象", multiProcess = true)
 * TestBean testBean;
 * }
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Event {
    /**
     * @return 事件描述
     */
    String value() default "";

    /**
     * @return 同value作用一样，为了匹配实际意义添加
     */
    String description() default "";

    /**
     * @return 此事件是否支持多进程
     */
    boolean multiProcess() default false;

    /**
     * @return 是否激活, 可以根据需要配置是否激活事件分发，eg：debug开启，release关闭
     */
    boolean active() default true;
}
