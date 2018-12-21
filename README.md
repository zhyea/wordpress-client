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

getAuthors()方法返回的是用户相关的信息：
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

新增文章可以使用newPost()方法，示例代码如下：  
```java
        PostRequest post = new PostRequest();
        post.setPostTitle("测试PostName");
        post.setPostContent("这是一段测试文章内容");
        post.setCategories("测试");
        post.setTags("a", "b", "c");
        post.setPostName("test-post-name");
        int postId = wp.newPost(post);
```
该方法的返回结果为postId，即文章ID。

这里需要注意postName和postTitle。postTitle指的是文章标题；postName指的则是文章别名，主要在文章的url路径中使用。通常建议将postName设置为英文字符。

更多发布文章的参数可以参考[XML-RPC WordPress API/Posts - newPost](https://codex.wordpress.org/XML-RPC_WordPress_API/Posts#wp.newPost)文档描述。

## 获取文章

获取文章有两个方法：getPosts和getPost。前者用于获取多篇文章，后者用于根据postId来获取文章。

### getPosts

getPosts方法如下：
```java
    List<Post> getPosts(PostFilter filter, String... fields)
```
参数filter决定返回结果的数量、排序字段和排序方式等信息。  

变长参数fields则决定了返回结果中包含哪些字段。如果要返回全部字段，可以不填。使用空字符串或其他非法字段则只返回postId。可用fields值请参考[XML-RPC WordPress API/Posts - getPost](https://codex.wordpress.org/XML-RPC_WordPress_API/Posts#Return_Values)。

示例代码如下：
```java
        PostFilter f = new PostFilter();
        f.setNumber(2);
        List<Post> list = wp.getPosts(f,"post_title");
```

返回结果为：

```json
[
    {
        "post_id": "2174",
        "post_title": "sbt下载加速方案"
    },
    {
        "post_id": "2170",
        "post_title": "Java 中文字符按Unicode排序"
    }
]
```

再次啰嗦下，正常的返回结果是一个Post实例集合，不是json字符串，这里使用json字符串只是为了便于展示。如需要获取json结果集可以自行将结果集转为json，也可以调用wp-client提供的JsonKit.toJson()进行处理。

### getPost

getPost方法如下：

```java
    Post getPost(int postId, String... fields) 
```

通过postId获取对应文章的信息。变长参数fields的使用请参考getPosts方法。

## 编辑文章



## 删除文章

