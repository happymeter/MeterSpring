package fu.meter.common.utils;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020 All Right Reserved 。
 * @ClassName PropertyUtil
 * @desc 读取spring配置文件中的参数工具类
 * @date 2020/11/13 9:19
 */
@Component
public class PropertyUtil implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver=stringValueResolver;
    }

    /**
     * @param key	参数名称
     * @return 返回字符串
     * @desc 解析配置文件中的配置值
     * @author meter
     * @date 2020/11/13 10:33
     */
    private String getPropertiesValue(String key) {
        if(key != null && !"".equals(key)) {
            return stringValueResolver.resolveStringValue(new StringBuilder("${").append(key).append("}").toString());
        }
        return key;
    }
    /**
     * @param propertyName
     * @return java.lang.String
     * @desc 获取配置文件属性值
     * @author meter
     * @date 2020/11/13 10:35
     */
    public String getPropertyValue(String propertyName){
        return getPropertiesValue(propertyName);
    }
    /**
     * @param propertyName
     * @param defaultValue
     * @return java.lang.String
     * @desc 获取配置文件属性值;如果为空则返回默认值
     * @author meter
     * @date 2020/11/13 10:37
     */
    public String getPropertyValue(String propertyName,String defaultValue){
        String value= getPropertiesValue(propertyName);
        if(value == null || "".equals(value)){
            return defaultValue;
        }
        return value;
    }
    /**
     * @param propertyName
     * @return java.lang.Integer
     * @desc 获取整形配置属性值
     * @author meter
     * @date 2020/11/13 10:40
     */
    public Integer getPropertyIntValue(String propertyName){
        String value=getPropertyValue(propertyName);
        if(value != null && !"".equals(propertyName)){
            return Integer.parseInt(value);
        }
        return null;
    }
    /**
     * @param propertyName
     * @return java.lang.Integer
     * @desc 获取整形配置属性值；如果为空则返回默认值
     * @author meter
     * @date 2020/11/13 10:40
     */
    public Integer getPropertyIntValue(String propertyName,Integer defaultValue){
        Integer value=getPropertyIntValue(propertyName);
        if(value == null){
            return defaultValue;
        }
        return value;
    }
}
