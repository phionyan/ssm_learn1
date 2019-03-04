# 一个ssm的demo
刚刚把ssm过了一遍，做个demo整合一下
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