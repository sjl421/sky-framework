package org.skyisbule.framwork.mvc.test;

import com.alibaba.fastjson.JSONObject;
import org.skyisbule.framwork.mvc.annotation.Controller;
import org.skyisbule.framwork.mvc.annotation.MapURL;
import org.skyisbule.framwork.mvc.annotation.ResponseBody;
import org.skyisbule.framwork.mvc.structure.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by gaorui on 16/6/14.
 */
@Controller
public class test {


    /**
     * @author gaorui
     * @param s1
     * @param s2
     * @param request
     * @param response
     * @param session
     * 普通url处理
     */
    @MapURL(value = "get",RequestMethod = RequestMethod.GET)
    public void get(String s1,String s2,HttpServletRequest request, HttpServletResponse response, HttpSession session){

            System.out.print(s1+""+s2);
            return;
    }



    /**
     * @author gaorui
     * @return String
     * 服务端跳转页面处理,默认 web-inf下所有 .html文件
     */
    @MapURL(value="foward")
    public String foward(){

        return "page/succ";

    }

    /**
     * @author gaorui
     * @param userid
     * @return Object
     * 服务端处理前端ajax请求,返回json数据
     */
    @MapURL(value = "", RequestMethod = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUser(Integer userid,Integer me){



        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userid",me);
        return jsonObject;

    }


}
