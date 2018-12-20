package org.chobit.wp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.chobit.wp.model.request.PostFilter;
import org.chobit.wp.model.request.PostRequest;
import org.chobit.wp.model.response.Author;
import org.chobit.wp.model.response.Post;
import org.chobit.wp.model.response.UserBlog;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.chobit.wp.Config.*;
import static org.chobit.wp.tools.JsonKit.toJson;

/**
 * @author robin
 */
@Ignore
public class WordPressTest {

    private WordPress wp = new WordPress(buildConfig());


    @Test
    public void getUserBlog() {
        UserBlog ub = wp.getUserBlog();
        Assert.assertNotNull(ub);
    }

    @Test
    public void getUsersBlogs() {
        List<UserBlog> list = wp.getUsersBlogs();
        System.out.println(list);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void getAuthor() {
        Author a = wp.getAuthor();
        Assert.assertNotNull(a);
    }

    @Test
    public void getAuthors() {
        List<Author> list = wp.getAuthors();
        System.out.println(list);
        Assert.assertFalse(list.isEmpty());
    }


    @Test
    public void getPosts() throws JsonProcessingException {
        PostFilter f = new PostFilter();
        f.setNumber(30);
        List<Post> list = wp.getPosts(f);
        System.out.println(toJson(list));
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void getPost() {
        Post p = wp.getPost(29, "post_content");
        System.out.println(p);
        Assert.assertNotNull(p);
    }


    @Test
    public void newPost() {
        PostRequest post = new PostRequest();
        post.setPostTitle("测试PostName" + System.currentTimeMillis());
        post.setPostContent("这是一段测试内容：" + System.currentTimeMillis());
        post.setCategories("测试");
        post.setTags("a", "b", "c");
        post.setPostName("abczzdddd");
        String postId = wp.newPost(post);
        System.out.println(postId);
        Assert.assertNotNull(postId);
    }


    @Test
    public void editPost() {
        PostRequest post = new PostRequest();
        post.setPostTitle("测试编辑" + System.currentTimeMillis());
        post.setPostContent("这是一段编辑后的测试内容：" + System.currentTimeMillis());
        boolean result = wp.editPost(29, post);
        System.out.println(result);
        Assert.assertTrue(result);
    }


    //@Test
    public void deletePost() {
        int postId = 26;
        boolean result = wp.deletePost(postId);
        System.out.println(result);
        Assert.assertTrue(result);
    }


    private WPConfig buildConfig() {
        return new WPConfigBuilder()
                .username(USERNAME)
                .password(PASSWORD)
                .xmlRpcUrl(XML_RPC_URL)
                .trustAll(true)
                .build();
    }

}
