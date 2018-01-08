/**
 *
 */
package com.yryz.kgwplug.gwapi;


import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author lixiaokang
 * @email lixiaokang@163.com
 * @date 2016年10月23日 下午1:31:21
 */
public interface GWRiskApi {
    /**
     * @param params
     * @description: 需要开启线程异步处理，超时返回false
     * @author PeterLee
     * @date 2018/1/5 15:36
     */
    public JSONObject checkToken(Map<String, Object> params);

    /**
     * @param params
     * @description: 公共风控服务，需要开启线程异步处理，超时返回成功 目前禁用，降维到业务层
     * 反参json 必须有 restcode,showmsg,errormsg
     * 超时反参为 100 成功，视为风控被降级
     * @author PeterLee
     * @date 2018/1/5 15:34
     */
    JSONObject checkRisk(Map<String, Object> params);
    /**
     * @param params
     * @description: 需要开启线程异步处理，超时返回成功 目前禁用，降维到业务层
     * 反参json 必须有 restcode,showmsg,errormsg
     * 超时反参为 100 成功，视为风控被降级
     * @author PeterLee
     * @date 2018/1/5 15:34
     */
    JSONObject aspectBefore(Map<String, Object> params);
    /**
     * @param params
     * @description: 需要开启线程异步处理，超时返回成功  目前禁用，降维到业务层
     * 反参json 必须有 restcode,showmsg,errormsg
     * 超时反参为 100 成功，视为风控被降级
     * @author PeterLee
     * @date 2018/1/5 15:34
     */
    JSONObject aspectAfter(Map<String, Object> params);
}
