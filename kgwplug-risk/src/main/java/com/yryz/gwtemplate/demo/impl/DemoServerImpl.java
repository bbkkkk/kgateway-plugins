/**
 *
 */
package com.yryz.gwtemplate.demo.impl;

import com.alibaba.fastjson.JSONObject;
import com.kgw.annotation.KgwRegister;
import com.yryz.gwtemplate.demo.DemoServer;

import java.util.Map;
import java.util.Random;

/**
 * @author lixiaokang
 * @email lixiaokang@163.com
 * @date 2016年10月23日 下午1:31:47
 */
public class DemoServerImpl implements DemoServer {


    @KgwRegister(gwindex = "testindex12345", gwname = "initcase", checkSession = true, expireTime = 30000, developer = "admin")
    public JSONObject sayHello(Map<String, Object> params) {

        System.err.println("server:这是收到的客户端数据：" + params);
        //加个标记
//		str=str+"-（来自服务端的标记）";
        Random random = new Random();
        int max=20;
        int min=10;
        int s = random.nextInt(max)%(max-min+1) + min;
        if(s>12&&s<16) {
//            System.out.println(1 / 0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else  if(s==12||s==16) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else    if(s==18) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        params.put("str_", "-（来自服务端的标记）");
        System.err.println("server:这是返回客户端的数据：" + params);
        return (JSONObject) JSONObject.toJSON(params);
    }
}
