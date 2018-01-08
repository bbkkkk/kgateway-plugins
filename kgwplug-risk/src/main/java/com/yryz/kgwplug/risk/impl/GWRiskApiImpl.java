/**
 *
 */
package com.yryz.kgwplug.risk.impl;

import com.alibaba.fastjson.JSONObject;
import com.yryz.kgwplug.gwapi.GWRiskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author lixiaokang
 * @email lixiaokang215@163.com
 * @date 2016年10月23日 下午1:31:47
 */

public class GWRiskApiImpl implements GWRiskApi {
    private final static Logger log = LoggerFactory.getLogger(GWRiskApiImpl.class);

    @Override
    public JSONObject checkToken(Map<String, Object> params) {

        long gw_starttime = System.currentTimeMillis();
        long gw_usedmills;
        JSONObject json = new JSONObject();
        ExecutorService executor = null;
        FutureTask<JSONObject> future = null;
        long timeout = 1000;//超时时间
        try {
            final Map<String, Object> invokeParams = params;
            executor = Executors.newSingleThreadExecutor();
            future = new FutureTask<JSONObject>(new Callable<JSONObject>() {
                @Override
                public JSONObject call() throws Exception {
                    //验证token逻辑
                    JSONObject extjson = new JSONObject();//
                    extjson.put("rstcode", 100);
                    extjson.put("showmsg", "Token校验通过");
                    extjson.put("errormsg", "Token校验通过");
                    return extjson;
                }
            });
            executor.execute(future);
            JSONObject result = future.get(timeout, TimeUnit.MILLISECONDS);

            if (result != null && result.containsKey("rstcode") && ("100".equals(result.getString("rstcode")))){
                json.putAll(result);
            }else{
                log.error("Token校验失败，入参:" + params + "返参：" + result.toJSONString());
                json.put("rstcode", 111);
                json.put("showmsg", "服务器开小差了");
                json.put("errormsg", "Token校验出现未知异常，强制拒绝访问");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Token服务调用失败" + params, e);
            json.put("rstcode", 111);
            json.put("showmsg", "服务器开小差了");
            json.put("errormsg", "Token校验失败强制拒绝访问，Token服务调用失败:" + e.getMessage());
        } finally {
            if (future != null) {
                future.cancel(true);
            }
            if (executor != null) {
                executor.shutdown();
            }
        }
        gw_usedmills = System.currentTimeMillis() - gw_starttime;
        json.put("gw_usedmills", gw_usedmills);
        log.info("Token层耗时毫秒数：" + gw_usedmills + ",Token层出参：" + json.toString());
        return json;
    }

    @Override
    public JSONObject checkRisk(Map<String, Object> params) {
        long gw_starttime = System.currentTimeMillis();
        long gw_usedmills;
        JSONObject json = new JSONObject();
        ExecutorService executor = null;
        FutureTask<JSONObject> future = null;
        long timeout = 1000;//超时时间
        try {
            final Map<String, Object> invokeParams = params;
            executor = Executors.newSingleThreadExecutor();
            future = new FutureTask<JSONObject>(new Callable<JSONObject>() {
                @Override
                public JSONObject call() throws Exception {

                    //验证Token逻辑
                    JSONObject extjson = new JSONObject();//
                    extjson.put("rstcode", 100);
                    extjson.put("showmsg", "风控校验通过");
                    extjson.put("errormsg", "风控校验通过");
                    return extjson;
                }
            });
            executor.execute(future);
            JSONObject result = future.get(timeout, TimeUnit.MILLISECONDS);

            if (result != null && result.containsKey("rstcode") && (!"100".equals(result.getString("rstcode")))){
                json.putAll(result);
                log.warn("风控服务拦截了请求，入参:" + params + "返参：" + result.toJSONString());
                gw_usedmills = System.currentTimeMillis() - gw_starttime;
                json.put("gw_usedmills", gw_usedmills);
                return json;
            }else{
                log.error("风控服务返回结果未遵守返参规则，入参:" + params + "返参：" + result.toJSONString());
                json.put("rstcode", 100);
                json.put("showmsg", "服务器开小差了");
                json.put("errormsg", "风控服务强制通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("风控服务调用失败" + params, e);
            json.put("rstcode", 100);
            json.put("showmsg", "服务器开小差了");
            json.put("errormsg", "风控服务强制通过，风控服务调用失败:" + e.getMessage());
        } finally {
            if (future != null) {
                future.cancel(true);
            }
            if (executor != null) {
                executor.shutdown();
            }
        }
         gw_usedmills = System.currentTimeMillis() - gw_starttime;
        json.put("gw_usedmills", gw_usedmills);
        log.info("风控层耗时毫秒数：" + gw_usedmills + ",风控层出参：" + json.toString());
        return json;
    }

    @Override
    public JSONObject aspectBefore(Map<String, Object> params) {
        long gw_starttime = System.currentTimeMillis();
        long gw_usedmills;
        JSONObject json = new JSONObject();
        ExecutorService executor = null;
        FutureTask<JSONObject> future = null;
        long timeout = 1000;//超时时间
        try {
            final Map<String, Object> invokeParams = params;
            executor = Executors.newSingleThreadExecutor();
            future = new FutureTask<JSONObject>(new Callable<JSONObject>() {
                @Override
                public JSONObject call() throws Exception {

                    //验证前切面逻辑
                    JSONObject extjson = new JSONObject();//
                    extjson.put("rstcode", 100);
                    extjson.put("showmsg", "前切面通过");
                    extjson.put("errormsg", "前切面通过");
                    return extjson;
                }
            });
            executor.execute(future);
            JSONObject result = future.get(timeout, TimeUnit.MILLISECONDS);

            if (result != null && result.containsKey("rstcode") && (!"100".equals(result.getString("rstcode")))){
                json.putAll(result);
                log.warn("前置切面拦截了请求，入参:" + params + "返参：" + result.toJSONString());
                gw_usedmills = System.currentTimeMillis() - gw_starttime;
                json.put("gw_usedmills", gw_usedmills);
                return json;
            }else{
                log.error("前置切面返回结果未遵守返参规则，入参:" + params + "返参：" + result.toJSONString());
                json.put("rstcode", 100);
                json.put("showmsg", "服务器开小差了");
                json.put("errormsg", "前置切面强制通过");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("前切面服务调用失败" + params, e);
            json.put("rstcode", 100);
            json.put("showmsg", "服务器开小差了");
            json.put("errormsg", "前切面服务调用失败:" + e.getMessage());
        } finally {
            if (future != null) {
                future.cancel(true);
            }
            if (executor != null) {
                executor.shutdown();
            }
        }
         gw_usedmills = System.currentTimeMillis() - gw_starttime;
        json.put("gw_usedmills", gw_usedmills);
        log.info("前切面层耗时毫秒数：" + gw_usedmills + ",前切面层出参：" + json.toString());
        return json;
    }

    @Override
    public JSONObject aspectAfter(Map<String, Object> params) {
        long gw_starttime = System.currentTimeMillis();
        long gw_usedmills;
        JSONObject json = new JSONObject();
        ExecutorService executor = null;
        FutureTask<JSONObject> future = null;
        long timeout = 1000;//超时时间
        try {
            final Map<String, Object> invokeParams = params;
            executor = Executors.newSingleThreadExecutor();
            future = new FutureTask<JSONObject>(new Callable<JSONObject>() {
                @Override
                public JSONObject call() throws Exception {

                    //验证后切面逻辑
                    JSONObject extjson = new JSONObject();//
                    extjson.put("rstcode", 100);
                    extjson.put("showmsg", "后切面通过");
                    extjson.put("errormsg", "后切面通过");
                    return extjson;
                }
            });
            executor.execute(future);
            JSONObject result = future.get(timeout, TimeUnit.MILLISECONDS);

            if (result != null && result.containsKey("rstcode") && (!"100".equals(result.getString("rstcode")))){
                json.putAll(result);
                log.warn("后切面拦截了请求，入参:" + params + "返参：" + result.toJSONString());
                gw_usedmills = System.currentTimeMillis() - gw_starttime;
                json.put("gw_usedmills", gw_usedmills);
                return json;
            }else{
                log.error("后置切面返回结果未遵守返参规则，入参:" + params + "返参：" + result.toJSONString());
                json.put("rstcode", 100);
                json.put("showmsg", "服务器开小差了");
                json.put("errormsg", "后置切面强制通过");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("后切面服务调用失败" + params, e);
            json.put("rstcode", 100);
            json.put("showmsg", "服务器开小差了");
            json.put("errormsg", "后切面服务调用失败:" + e.getMessage());
        } finally {
            if (future != null) {
                future.cancel(true);
            }
            if (executor != null) {
                executor.shutdown();
            }
        }
         gw_usedmills = System.currentTimeMillis() - gw_starttime;
        json.put("gw_usedmills", gw_usedmills);
        log.info("后切面层耗时毫秒数：" + gw_usedmills + ",后切面层出参：" + json.toString());
        return json;
    }
}
