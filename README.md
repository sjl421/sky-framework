## AisMVC,一款仿SpringMVC框架的轻便快捷的Java MVC开发框架

#### 前言
*  写这个框架的意义在于过去使用springmvc框架作为项目中的Controller层,springmvc的简洁配置和使用让我们选择了它,但这个框架我用着也发现了它也有很多冗余功能的地方。我们团队开发web项目一般采用前后端分离,所以后端的的Controller层的功能仅仅只有提供ajax接口,页面集成后的跳转,过滤器和拦截器,所以我就想着自己写一款仿springmvc的mvc框架作为自己和团队以后的开发中小型项目的框架,舍掉冗余的部分,只要项目中实际需要的功能

#### 这个框架暂时还没有经过严密的测试,所以想使用的同学我在这里说声抱歉,虽然我自己通过maven打成jar包测试过,但暂时没有用于实际开发的打算,第一是自己一个人的实力有限还是怕真实运用中出现自己不能解决的问题,其实我目前内心的真实想法是告诉大家一个mvc框架到底是怎么实现的,springmvc框架想一下吃透也不现实,如果通过我的这个框架大家也有写框架的动力和思路我也是我想看到的,也想告诉大家只要动起手来自己也能写框架,有些东西不是说说而已。很多人或许会说现在mvc框架这么多,你的这个算什么啊？但我想说现在很多时候我们百度搜索的资料来自前人,很多都是5,6年前的老资料了,我也不想以后我们的后辈通过搜索引擎搜出来的还是我们这个时候搜出来的前人总结,开发的资料。我想我也应该留点东西了。
#### 框架流程图

![me](http://o9beglkd1.bkt.clouddn.com/B21B9E90-F3A9-4C2D-8BEA-A0375CE87CD8.jpg)

#### 功能代码演示

```Java

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
    @MapURL(value = "getUser", RequestMethod = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUser(int userid){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userid",userid);
        return jsonObject;

    }
}

```
#### mvc框架功能介绍
* 注解实现
* @MapURL注解实现http请求路由
* 反射实现方法参数注入
* String返回类型方法转发请求
* @ResponseBody注解实现ajax接口
* 增加config.ini配置文件,实现定向动态扫描项目中的@Controller 类
* 增加注解参数RequestMethod 默认http请求类型,请求类型不合法返回405状态码

#### commit log
* 1.0 初始化项目
* 1.1 dhy join 
* 1.2 mvc框架功能雏形
* 1.3 增加handlerMapping处理器映射,控制器卸耦
* 1.4 增加config.ini配置文件,实现定向动态扫描项目中的@Controller 类
* 1.5 增加注解参数RequestMethod 默认http请求类型,请求类型不合法返回405状态码
* 1.6 下一步准备做项目的容错处理,过滤器准备用原生的不准备加入框架
* 1.7 修改部分目录结构,画框架整体流程图,后面继续做容错处理和性能优化
