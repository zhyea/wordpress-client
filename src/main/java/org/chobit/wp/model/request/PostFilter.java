package org.chobit.wp.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.chobit.wp.enums.PostOrderBy;
import org.chobit.wp.enums.PostStatus;
import org.chobit.wp.enums.SortOrder;

/**
 * @author robin
 */
public class PostFilter extends Request {

    @JsonProperty("post_type")
    private String postType;

    @JsonProperty("post_status")
    private PostStatus postStatus;

    private int number;

    private int offset;

    private PostOrderBy orderBy;

    private SortOrder order;


    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public PostOrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(PostOrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public SortOrder getOrder() {
        return order;
    }

    public void setOrder(SortOrder order) {
        this.order = order;
    }
}
