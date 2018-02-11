package com.spring.boot.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * FastJson对响应数据处理的相关配置
 * @author wang_donggang
 */
@Configuration
public class FastJSONConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		
		// 序列化
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		// 时间戳格式
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		
		// 为空返回值转换
		ValueFilter valueFilter = new ValueFilter() {
			/**
			 * Object cls 是class
			 * String key 是key值
			 * Object val 是value值
			 */
            public Object process(Object cls, String key, Object val) {
                if (null == val)
                	val = "";
                return val;
            }
        };
        fastJsonConfig.setSerializeFilters(valueFilter);
        
        fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);
	}
}
