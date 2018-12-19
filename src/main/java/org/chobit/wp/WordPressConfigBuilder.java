package org.chobit.wp;

import org.chobit.wp.exception.WPClientException;
import org.chobit.wp.model.response.UserBlog;

import java.util.List;

/**
 * @author robin
 */
public final class WordPressConfigBuilder {


    private WordPressConfig config = new WordPressConfig();

    public WordPressConfigBuilder username(String username) {
        this.config.setUsername(username);
        return this;
    }


    public WordPressConfigBuilder password(String password) {
        this.config.setPassword(password);
        return this;
    }


    public WordPressConfigBuilder xmlRpcUrl(String xmlRpcUrl) {
        this.config.setXmlRpcUrl(xmlRpcUrl);
        return this;
    }


    public WordPressConfigBuilder trustAll(boolean trustAll) {
        this.config.setTrustAll(trustAll);
        return this;
    }


    public WordPressConfig build() {
        try {
            WPClient client = new WPClient(config.getXmlRpcUrl(), config.isTrustAll());
            List<UserBlog> list = client.getUsersBlogs(config.getUsername(), config.getPassword());
            if (null == list || list.isEmpty()) {
                throw new WPClientException("Error in wp config, please check");
            }
            UserBlog ub = list.get(0);
            this.config.setBlogId(ub.getBlogId());
            this.config.setXmlRpcUrl(config.getXmlRpcUrl());
            return config;
        } catch (Exception e) {
            throw new WPClientException("Error in wp config, please check", e);
        }
    }
}
