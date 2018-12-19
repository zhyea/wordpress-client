package org.chobit.wp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.chobit.wp.enums.PostStatus;
import org.chobit.wp.model.interval.Enclosure;

import java.beans.Transient;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.chobit.wp.enums.PostTaxonomy.CATEGORY;
import static org.chobit.wp.enums.PostTaxonomy.TAG;

public class PostRequest extends Request {

    public PostRequest() {
    }

    @JsonProperty("post_type")
    private String postType;

    @JsonProperty("post_status")
    private String postStatus = PostStatus.PUBLISH.status;

    @JsonProperty("post_title")
    private String postTitle;

    @JsonProperty("post_author")
    private Integer postAuthor;

    @JsonProperty("post_excerpt")
    private String postExcerpt;

    @JsonProperty("post_content")
    private String postContent;

    @JsonProperty("post_date_gmt")
    private Date postDateGmt;

    @JsonProperty("post_format")
    private String postFormat;

    @JsonProperty("post_name")
    private String postName;

    @JsonProperty("post_password")
    private String postPassword;

    @JsonProperty("comment_status")
    private String commentStatus;

    @JsonProperty("ping_status")
    private String pingStatus;

    private Integer sticky;

    @JsonProperty("post_thumbnail")
    private Integer postThumbnail;

    @JsonProperty("post_parent")
    private Integer postParent;

    @JsonProperty("custom_fields")
    private List<CustomField> customFields;

    private Enclosure enclosure;

    @JsonProperty("terms_names")
    private Map<String, String[]> termsNames;

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Integer getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Integer postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(Date postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public String getPostFormat() {
        return postFormat;
    }

    public void setPostFormat(String postFormat) {
        this.postFormat = postFormat;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public Integer getSticky() {
        return sticky;
    }

    public void setSticky(Integer sticky) {
        this.sticky = sticky;
    }

    public Integer getPostThumbnail() {
        return postThumbnail;
    }

    public void setPostThumbnail(Integer postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    public Integer getPostParent() {
        return postParent;
    }

    public void setPostParent(Integer postParent) {
        this.postParent = postParent;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public Map<String, String[]> getTermsNames() {
        return termsNames;
    }

    public void setTermsNames(Map<String, String[]> termsNames) {
        this.termsNames = termsNames;
    }

    @Transient
    public void setCategories(String... categories) {
        if (null == termsNames) {
            setTermsNames(new HashMap<>(2));
        }
        if (null != categories && categories.length > 0) {
            termsNames.put(CATEGORY.taxonomy, categories);
        }
    }

    @Transient
    public void setTags(String... tags) {
        if (null == termsNames) {
            setTermsNames(new HashMap<>(2));
        }
        if (null != tags && tags.length > 0) {
            termsNames.put(TAG.taxonomy, tags);
        }
    }


    public static class CustomField {

        private String key;

        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
