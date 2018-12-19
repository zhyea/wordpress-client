package org.chobit.wp.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author robin
 */
public class UserBlog {


    @JsonProperty("blogid")
    private int blogId;

    private String blogName;

    private String url;

    private boolean isAdmin;

    @JsonProperty("xmlrpc")
    private String xmlRpc;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getXmlRpc() {
        return xmlRpc;
    }

    public void setXmlRpc(String xmlRpc) {
        this.xmlRpc = xmlRpc;
    }


    @Override
    public String toString() {
        return "UserBlog{" +
                "blogId=" + blogId +
                ", blogName='" + blogName + '\'' +
                ", url='" + url + '\'' +
                ", isAdmin=" + isAdmin +
                ", xmlRpc='" + xmlRpc + '\'' +
                '}';
    }
}
