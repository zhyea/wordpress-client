package org.chobit.wp;

import org.chobit.wp.exception.WPClientException;
import org.chobit.wp.model.response.UserBlog;

import java.util.List;

/**
 * @author robin
 */
public final class WPConfigBuilder {


    private WPConfig config = new WPConfig();

    public WPConfigBuilder username(String username) {
        this.config.setUsername(username);
        return this;
    }


    public WPConfigBuilder password(String password) {
        this.config.setPassword(password);
        return this;
    }


    public WPConfigBuilder xmlRpcUrl(String xmlRpcUrl) {
        this.config.setXmlRpcUrl(xmlRpcUrl);
        return this;
    }


    public WPConfigBuilder trustAll(boolean trustAll) {
        this.config.setTrustAll(trustAll);
        return this;
    }


    public WPConfigBuilder connectTimeout(int connectTimeout) {
        if (connectTimeout < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.config.setConnectTimeout(connectTimeout);
        return this;
    }


    public WPConfigBuilder readTimeout(int readTimeout) {
        if (readTimeout < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.config.setReadTimeout(readTimeout);
        return this;
    }


    public WPConfig build() {
        try {
            WPClient client = new WPClient(config.getXmlRpcUrl(),
                    config.isTrustAll(),
                    config.getConnectTimeout(),
                    config.getReadTimeout());
            List<UserBlog> list = client.getUsersBlogs(config.getUsername(), config.getPassword());
            if (null == list || list.isEmpty()) {
                throw new WPClientException("Error in wp config, please check");
            }
            UserBlog ub = list.get(0);
            this.config.setBlogId(ub.getBlogId());
            return config;
        } catch (Exception e) {
            throw new WPClientException("Error in wp config, please check", e);
        }
    }
}
