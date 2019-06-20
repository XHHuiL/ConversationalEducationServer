# 对话式教学微信小程序后端
## 刘辉 16302010048

### 1. 项目组织及文件说明
```
│          
├─lib
│      mysql-connector-java-8.0.16.jar              数据库链接jar包
│      
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─fudan
│  │  │          │  ServiceApplication.java         入口类
│  │  │          │  
│  │  │          ├─controller
│  │  │          │      AnswerController.java       操纵答案相关的api
│  │  │          │      ChapterController.java      操纵章节相关的api
│  │  │          │      ContentController.java      操纵章节内容相关的api
│  │  │          │      CourseController.java       操纵课程相关的api
│  │  │          │      NoteController.java         操纵笔记相关的api
│  │  │          │      OptionController.java       操纵问题选项相关的api
│  │  │          │      UserController.java         操纵用户相关的api
│  │  │          │      
│  │  │          ├─dao
│  │  │          │      AnswerDao.java              答案的数据访问对象
│  │  │          │      ChapterDao.java             章节的数据访问对象
│  │  │          │      ContentDao.java             章节内容的数据访问对象
│  │  │          │      CourseDao.java              课程的数据访问对象
│  │  │          │      NoteDao.java                笔记的数据访问对象
│  │  │          │      OptionDao.java              问题选项的数据访问对象
│  │  │          │      UserConnectCourseDao.java   用户和课程关联的数据访问对象
│  │  │          │      UserDao.java                用户的数据访问对象
│  │  │          │      
│  │  │          ├─entity
│  │  │          │      Answer.java                 答案实体类
│  │  │          │      AnswerExample.java
│  │  │          │      Chapter.java                章节实体类
│  │  │          │      ChapterExample.java
│  │  │          │      Content.java                章节内容实体类
│  │  │          │      ContentExample.java
│  │  │          │      Course.java                 课程实体类
│  │  │          │      CourseExample.java
│  │  │          │      Note.java                   笔记实体类
│  │  │          │      NoteExample.java
│  │  │          │      Option.java                 问题选项实体类
│  │  │          │      OptionExample.java
│  │  │          │      User.java                   用户实体类
│  │  │          │      UserConnectCourse.java      用户和课程关联实体类
│  │  │          │      UserConnectCourseExample.java
│  │  │          │      UserExample.java
│  │  │          │      
│  │  │          ├─request
│  │  │          │      LoginRequest.java           登录请求体
│  │  │          │      
│  │  │          ├─response
│  │  │          │      CourseResponse.java         课程响应体
│  │  │          │      LoginResponse.java          登录响应体
│  │  │          │      NoteResponse.java           笔记响应体
│  │  │          │      OptionsResponse.java        问题选项响应体
│  │  │          │      
│  │  │          ├─service
│  │  │          │      AnswerService.java          答案服务
│  │  │          │      ChapterService.java         章节服务
│  │  │          │      ContentService.java         用户和课程关联服务
│  │  │          │      CourseService.java          课程服务
│  │  │          │      HttpClientService.java      Http请求服务
│  │  │          │      NoteService.java            笔记服务
│  │  │          │      OptionService.java          问题选项服务
│  │  │          │      UserService.java            用户服务
│  │  │          │      
│  │  │          └─util
│  │  │                  ConvertEntityToResponse.java   将实体类转换为相应的响应体类
│  │  │                  MapFactory.java                通过Map构造响应体
│  │  │                  UrlBuilder.java                构造请求其他服务器的Url
│  │  │                  
│  │  └─resources
│  │      │  application.yml                            应用的配置文件
│  │      │  
│  │      ├─mapper
│  │      │      AnswerDao.xml                          答案的数据库操作文件
│  │      │      ChapterDao.xml                         章节的数据库操作文件
│  │      │      ContentDao.xml                         章节内容的数据库操作文件
│  │      │      CourseDao.xml                          课程的数据库操作文件
│  │      │      NoteDao.xml                            笔记的数据库操作文件
│  │      │      OptionDao.xml                          问题选项的数据库操作文件
│  │      │      UserConnectCourseDao.xml               用户和课程关联的数据库操作文件
│  │      │      UserDao.xml                            用户的数据库操作文件
|  |
```

### 2. 关键功能实现细节
+ 登录、注册
    + 使用@RequestMapping注解login()函数，以响应微信小程序的登录请求
    + 在login()的参数部分使用注解@RequestBody获取登录请求体
    + 向教师Web应用后端发起http请求以登录/注册用户，并将获得的token返回给微信小程序
+ 数据库增、删、改、查
    + 使用插件better-mybatis-generator生成数据库相关操作的entity、dao、mapper。必要时，修改dao、mapper以满足需要
    + 在package com.fudan.controller下创建相应的controller以响应相关请求
    + 在package com.fudan.service下创建相应的service，调用dao中操纵数据库的具体函数

### 3. 服务器部署配置
##### 1. 配置Web Server
+ 购买阿里云的学生优惠产品——轻量应用服务器，配置好远程链接用户名、密码以及防火墙
+ 首先按照 https://docs.docker.com/install/linux/docker-ce/ubuntu/ 的步骤在云服务器上安装好docker
+ 拉取java镜像：docker pull java:latest 
+ 将项目打包成jar包，使用远程连接工具MobaXterm将jar包上传到云服务器的某个目录下，<br>如/root/ConversationalEducation，下一步会将此目录挂在到docker容器的特定目录下
+ 启动java容器：docker run -idt --name adweb-server -v $PWD/ConversationalEducation:/root/ConversationalEducation  -p 80:80 java:latest
+ 进入java容器：docker exec -it adweb-server /bin/bash
+ 进入挂载的目录：cd /root/ConversationalEducation
+ 后台运行Spring Boot项目：nohup java -jar adweb-server.jar &
+ 退出java容器：exit

##### 2. 配置数据库
+ 拉取特定版本的mysql镜像：docker pull mysql:8.0.16
+ 启动mysql容器：docker run -idt --name adweb-mysql -v $PWD/mysql-image-data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456  mysql:8.0.16
+ 最后使用数据库连接工具（如Navicat）将数据导入mysql容器即可
