package org.chobit.wp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.chobit.wp.model.interval.Enclosure;

import java.util.Date;
import java.util.List;

public class Post {

    @JsonProperty("post_id")
    private String postId;

    @JsonProperty("post_title")
    private String postTitle;

    @JsonProperty("post_date_gmt")
    private Date postDateGmt;

    @JsonProperty("post_modified")
    private Date postModified;

    @JsonProperty("post_modified_gmt")
    private Date postModifiedGmt;

    @JsonProperty("post_status")
    private String postStatus;

    @JsonProperty("post_type")
    private String postType;

    @JsonProperty("post_format")
    private String postFormat;

    @JsonProperty("post_name")
    private String postName;

    @JsonProperty("post_author")
    private String postAuthor;

    @JsonProperty("post_password")
    private String postPassword;

    @JsonProperty("post_excerpt")
    private String postExcerpt;

    @JsonProperty("post_content")
    private String postContent;

    @JsonProperty("post_parent")
    private String postParent;

    @JsonProperty("post_mime_type")
    private String postMimeType;

    private String link;

    private String guid;

    @JsonProperty("menu_order")
    private int menuOrder;

    @JsonProperty("comment_status")
    private String commentStatus;

    @JsonProperty("ping_status")
    private String pingStatus;

    private boolean sticky;

    @JsonProperty("post_thumbnail")
    private List<MediaItem> postThumbnail;

    private List<Term> terms;

    @JsonProperty("custom_fields")
    private List<CustomField> customFields;

    private Enclosure enclosure;


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Date getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(Date postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public Date getPostModifiedGmt() {
        return postModifiedGmt;
    }

    public void setPostModifiedGmt(Date postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
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

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
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

    public String getPostParent() {
        return postParent;
    }

    public void setPostParent(String postParent) {
        this.postParent = postParent;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
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

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public List<MediaItem> getPostThumbnail() {
        return postThumbnail;
    }

    public void setPostThumbnail(List<MediaItem> postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
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


    public static class CustomField {

        private String id;

        private String key;

        private String value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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
