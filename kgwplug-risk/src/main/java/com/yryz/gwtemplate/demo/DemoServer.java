/**
 *
 */
package com.yryz.gwtemplate.demo;


import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author lixiaokang
 * @email lixiaokang@163.com
 * @date 2016年10月23日 下午1:31:21
 */
public interface DemoServer {

    JSONObject sayHello(Map<String, Object> params);


}
