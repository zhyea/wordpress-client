package org.chobit.wp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.chobit.wp.exception.WPClientException;
import org.chobit.wp.model.request.PostFilter;
import org.chobit.wp.model.request.PostRequest;
import org.chobit.wp.model.response.Author;
import org.chobit.wp.model.response.Post;
import org.chobit.wp.model.response.UserBlog;
import org.chobit.wp.tools.JsonKit;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robin
 */
class WPClient {

    private WPConfig config;

    private XmlRpcClient client;


    WPClient(String xmlRpcUrl, boolean trustAll, int connectTimeout, int readTimeout) throws MalformedURLException {
        XmlRpcClientConfigImpl c = new XmlRpcClientConfigImpl();
        c.setServerURL(new URL(xmlRpcUrl));
        if (connectTimeout > 0) {
            c.setConnectionTimeout(config.getConnectTimeout());
        }
        if (readTimeout > 0) {
            c.setReplyTimeout(config.getReadTimeout());
        }
        if (trustAll) {
            acceptAndCertificate();
        }
        client = new XmlRpcClient();
        client.setConfig(c);
    }


    WPClient(WPConfig cfg) throws MalformedURLException {
        this(cfg.getXmlRpcUrl(), cfg.isTrustAll(), cfg.getConnectTimeout(), cfg.getReadTimeout());
        XmlRpcClientConfig c = this.client.getClientConfig();
        this.config = cfg;
    }


    boolean deletePost(int postId) throws XmlRpcException, IOException {
        Object[] params = new Object[]{config.getBlogId(), config.getUsername(), config.getPassword(), postId};
        boolean result = execute("wp.deletePost", params, Boolean.class);
        return result;
    }


    boolean editPost(int postId, PostRequest post) throws XmlRpcException, IOException {
        Object[] params = new Object[]{config.getBlogId(), config.getUsername(), config.getPassword(), postId, post.toMap()};
        boolean result = execute("wp.editPost", params, Boolean.class);
        return result;
    }


    int newPost(PostRequest post) throws XmlRpcException, IOException {
        Object[] params = new Object[]{config.getBlogId(), config.getUsername(), config.getPassword(), post.toMap()};
        int postId = execute("wp.newPost", params, Integer.class);
        return postId;
    }


    Post getPost(int postId, String... fields) throws XmlRpcException, IOException {
        ArrayList<Object> params = new ArrayList<>(5);
        params.addAll(Arrays.asList(config.getBlogId(), config.getUsername(), config.getPassword(), postId));
        if (null != fields && fields.length > 0) {
            params.add(fields);
        }
        Post post = execute("wp.getPost", params.toArray(), Post.class);
        return post;
    }


    List<Post> getPosts(PostFilter filter, String... fields) throws XmlRpcException, IOException {
        ArrayList<Object> params = new ArrayList<>(5);
        params.addAll(Arrays.asList(config.getBlogId(), config.getUsername(), config.getPassword()));
        if (null != filter) {
            params.add(filter.toMap());
        }
        if (null != fields && fields.length > 0) {
            params.add(fields);
        }
        List<Post> posts = execute("wp.getPosts", params.toArray(), new TypeReference<List<Post>>() {
        });
        return posts;
    }


    List<Author> getAuthors() throws XmlRpcException, IOException {
        Object[] params = new Object[]{config.getBlogId(), config.getUsername(), config.getPassword()};
        List<Author> authors = execute("wp.getAuthors", params, new TypeReference<List<Author>>() {
        });
        return authors;
    }


    List<UserBlog> getUsersBlogs() throws XmlRpcException, IOException {
        return getUsersBlogs(config.getUsername(), config.getPassword());
    }


    List<UserBlog> getUsersBlogs(String username, String password) throws XmlRpcException, IOException {
        Object[] params = new Object[]{username, password};
        List<UserBlog> ubList = execute("wp.getUsersBlogs", params, new TypeReference<List<UserBlog>>() {
        });
        return ubList;
    }


    private <T> T execute(String methodName, Object[] params, Class<T> classOfT) throws XmlRpcException, IOException {
        String json = execute(methodName, params);
        return JsonKit.fromJson(json, classOfT);
    }


    private <T> T execute(String methodName, Object[] params, TypeReference<T> typeReference) throws XmlRpcException, IOException {
        String json = execute(methodName, params);
        return JsonKit.fromJson(json, typeReference);
    }


    private String execute(String methodName, Object[] params) throws XmlRpcException, JsonProcessingException {
        Object obj = client.execute(methodName, params);
        return JsonKit.toJson(obj);
    }


    private void acceptAndCertificate() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs,
                                               String authType) {// Trust always
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs,
                                               String authType) {// Trust always
                }
            }};
            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            // Create empty HostnameVerifier
            HostnameVerifier hv = (arg0, arg1) -> true;

            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        } catch (Exception e) {
            throw new WPClientException(e);
        }
    }
}
