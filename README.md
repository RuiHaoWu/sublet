
<p align="center">
	<strong>Sublet "房转"系统</strong>
</p>
<p align="center">
	👉 <a href="https://www.sublet-manager.xyz">https://www.sublet-manager.xyz</a> 👈
</p>

<p align="center">
    <a target="_blank" href="https://spring.io/projects/spring-cloud">
<img src="https://img.shields.io/badge/Spring%20Cloud-2020.0.3-yellow.svg" alt="Coverage Status">
	</a>
	<a target="_blank" href="https://spring.io/projects/spring-boot">
 <img src="https://img.shields.io/badge/Spring%20Boot-2.5.4-blue.svg" alt="Downloads">
	</a>
    <a target="_blank" href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">
		<img src="https://img.shields.io/badge/JDK-8+-green.svg" />
	</a>
	<a target="_blank" href="http://www.gnu.org/licenses/lgpl.html">
		<img src="https://img.shields.io/badge/license-LGPL--3.0-blue" />
	</a>
</p>

## 📚 项目介绍

Sublet“房转”系统是可以提供房子转让信息的发布系统，让想要租房或者房子转让的人多一个渠道，让信息更加聚集。

之前一直想要做点开源的东西，但是又不知道做个什么类型的系统，看到身边的一些同事依赖于中介或者在其他非房子转让平台发布转租信息，突然想到可以搭专门提供房子转让的平台。便有了这个项目，目前还有许多功能没有完善，后续会继续完善，争取真正的投入使用。

在开发工程中也借鉴了许多优秀的开源项目，由于自己是后端程序员，管理中台的前端是由[jeepay](https://github.com/jeequan/jeepay-ui)的项目改造的，减少前端的开发工作。

### 🍟 项目体验

> 用户名/密码  sublet/sublet123456

- [sublet管理后中台](https://www.sublet-manager.xyz)

### **🥪 项目进度**

| 项目               | 说明           | 地址                                  |
| ------------------ | -------------- | ------------------------------------- |
| sublet             | 后端代码       | https://github.com/RuiHaoWu/sublet    |
| sublet-ui-manager  | 管理台前端代码 | https://github.com/RuiHaoWu/sublet-ui |
| sublet-ui-frontend | 前台前端代码   | 未完成                                |

### 🍎 项目特点

- 管理平台操作界面简洁、易用
- 前后端分离架构，方便二次开发

- 基于 Spring Cloud  、Spring Boot、 OAuth2 的 RBAC **权限管理系统**
- 提供对常见容器化支持 Docker支持

###  🍿 功能模块

![功能结构图](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/ce93113c85f14a7389f4487600770160.png)

## 🥞 快速开始

> 核心依赖

| 依赖                                                         | 描述                              | 版本     |
| ------------------------------------------------------------ | --------------------------------- | -------- |
| Spring Boot                                                  | 开发框架                          | 2.5.4    |
| Spring Cloud                                                 | 分布式框架                        | 2020.0.3 |
| Spring Cloud Alibaba                                         | 分布式组件                        | 2021.1   |
| Spring Security OAuth2                                       | 安全认证框架                      | 2.1.2    |
| [MyBatis-Plus](https://gitee.com/link?target=https%3A%2F%2Fmp.baomidou.com%2F) | MyBatis增强工具                   | 3.4.3.3  |
| [Hutool](https://gitee.com/link?target=https%3A%2F%2Fwww.hutool.cn%2F) | Java工具类库                      | 5.7.12   |
| [Ant Design Vue](https://gitee.com/link?target=https%3A%2F%2Fwww.antdv.com%2Fdocs%2Fvue%2Fintroduce-cn%2F) | Ant Design的Vue实现，前端开发使用 | 2.1.2    |

> 项目结构

```
sublet-ui  -- https://github.com/RuiHaoWu/sublet-ui

sublet
├── sublet-auth -- 认证中心
└── pig-common -- 系统公共模块
     ├── sublet-common-bom -- 全局依赖管理控制
     ├── sublet-common-core -- 公共工具类核心包
     ├── sublet-common-feign -- feign 扩展封装
     ├── sublet-common-log -- 日志服务
     ├── sublet-common-mybatis -- mybatis 扩展封装
     ├── sublet-common-redis -- redis缓存
     ├── sublet-common-security -- 安全工具类
     └── sublet-common-web -- web基础包
├── sublet-gateway -- Spring Cloud Gateway网关
└── pig-modules -- 系统业务模块
     ├── pig-chat -- 聊天模块
     	├── sublet-chat-api -- 聊天公共api模块
	└── sublet-chat-biz -- 聊天业务处理模块
     ├── pig-post -- 帖子模块
     	├── sublet-post-api -- 帖子公共api模块
	└── sublet-post-biz -- 帖子业务处理模块
     └── pig-user -- 用户模块
     	├── sublet-user-api -- 用户权限管理公共api模块
	└── sublet-user-biz -- 用户权限管理业务处理模块
```

> 数据库初始化说明

- 数据库初始化管理员账号 admin/123456
- 阿里云oss存储需自己配置

## 🍯 系统截图

![转租信息列表](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/26b4b8e12552450fbc61606b7034a532.png)

![转租详情](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/1ae5189a43cf401dbd113b29cb17819b.png)

![帖子评论](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/705da3f2fb474880992a18fd2b6e7765.png)

![用户管理](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/085bb5be6cd74446b36b663ddea042aa.png)

![编辑角色](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/62f4492bdefb449c8c0546d19c57c0cd.png)

![系统日志详情](http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/a76ac71f74cf4f529b699534d8f2a157.png)

