# 一个ssm的demo	
> 本项目访问路径为：http://localhost:端口号/导入的项目名/listSomeCourse
> 如我的机器上访问路径为 http://localhost:8090/ssm_learn2/listSomeCourse

刚刚把ssm过了一遍，做个demo整合一下（结合how2j 的教程）
http://how2j.cn/k/ssm/ssm-tutorial/1137.html
<br>
<br>
<br>
* 前端
	>bootstrap
    
* 后台
	>spring mybatis spring-mvc
    
* 数据库
	>mysql
	
	
## 第5次提交改动
*  添加Page类用于分页
* UserMapper新增list方法，用于分页查询，并在User.xml做相应sql修改
* UserService接口中增加count()、list(Page page)方法,并在UserServiceImpl中实现
* UserController中新增listUser(Page page)方法，定位到分页显示页面（listSomeUser.jsp)
* jsp文件夹下新增listSomeUser.jsp
*  新增com.martin.test包,在其中新增MybatisTest类用于数据库连接测试

>ps:由于本地使用bootstrap，配置路径不熟悉，所有jsp暂且使用botstrap官网的在线资源，所以需要联网才能显示bootstrap样式


## 第六次提交改动（使用Pagehelper插件实现分页）

* 修改applicationContext.xml配置文件，增加对PageHelper插件的支持46-57行

* 修改UserController的代码如下

```
//		List<User> users = userService.list(page);
		PageHelper.offsetPage(page.getStart(),5);
		List<User> users = userService.list();
		
//		int total = userService.count();
		int total = (int) new PageInfo<>(users).getTotal();
		
```

## 第七次提交

##### 使用Durid连接池

* 什么是Druid
> Druid是一个高效的数据查询系统，主要解决的是对于大量的基于时序的数据进行聚合查询。数据可以实时摄入，进入到Druid后立即可查，同时数据是几乎是不可变。通常是基于时序的事实事件，事实发生后进入Druid，外部系统就可以对该事实进行查询
	
##### 练习CRUD
* 新增Course类（id、name、price、user），用户开设课程
* 新建相关的类service、serviceImpl、mapper等等。

ps：练习CRUD出了很多错，这两天都在调bug，最近比较忙，先实现基础的吧，CRUD不完整的地方以后补上
