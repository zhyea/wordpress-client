# 简介
WordPress Client是一个Java版的WordPress客户端操作库， 主要基于[WordPress XML-RPC API](https://codex.wordpress.org/XML-RPC_WordPress_API)实现。目前WordPress Client提供了如下能力：

* 获取WordPress用户信息
* 获取博客文章信息
* 发布文章到WordPress部署的博客
* 对已发布的文章进行编辑、删除等操作

# 使用

## 添加依赖
只需要在maven工程中的pom文件中添加如下依赖就可以使用wp-client：

```xml
        <dependency>
            <groupId>org.chobit.wp</groupId>
            <artifactId>wordpress-client</artifactId>
            <version>0.1.1</version>
        </dependency>
```
目前wp-client的版本是0.1.1。请尽量使用最新版本。

## 创建WordPress操作实例

WordPress实例是所有操作的基础。要创建WordPress实例我们需要先创建一个WPConfig实例，即WordPress配置对象。WPConfig实例构建方式如下：

```java
        WPConfig config =
                new WPConfigBuilder().xmlRpcUrl(XML_RPC_URL)
                        .username(USERNAME)
                        .password(PASSWORD)
                        .trustAll(true)
                        .build();
```

不建议也不允许直接构建WPConfig实例，正确的方式是通过WPConfigBuilder来完成构建。构建中的几个重要参数如下：

* xmlRpcUrl：xmlRpc服务端地址，WordPress博客的地址通常为**博客地址 + xmlrpc.php**，如我的博客：http://www.zhyea.com/xmlrpc.php
* username和password：登录WordPress博客后台使用的用户名和密码
* trustAll：如博客未启用https，可忽略；如已启用https，建议将之设置为true，否则需要导入证书文件后再进行操作

使用WPConfig实例来创建WordPress实例：

```java
        WordPress wp = new WordPress(config);
```

在WordPress类中封装了与WordPress进行交互的各种方法。接下来会逐个详细介绍下。

## 获取作者信息

在WordPress中提供了getUserBlogs和getAuthors两个方法来获取作者信息。

使用getUsersBlogs()方法可以获取非常简单的用户和博客信息：
```java
        List<UserBlog> list = wp.getUsersBlogs();
```
返回值如下：
```json
[
    {
        "blogName": "ZY笔记",
        "url": "http://www.zhyea.com/",
        "admin": false,
        "blogid": 1,
        "xmlrpc": "http://www.zhyea.com/xmlrpc.php"
    }
]
```
(为了便于查看，故用json包装了下返回结果)

getAuthors()方法返回的主要是用户相关的信息：
```java
        List<Author> list = wp.getAuthors();
```
返回值如下：
```json
[
    {
        "user_id": "1",
        "user_login": "zhyea",
        "display_name": "白42"
    },
    {
        "user_id": "2",
        "user_login": "robin",
        "display_name": "robin"
    }
]
```

## 新增文章

## 获取文章

## 编辑文章

## 删除文章

