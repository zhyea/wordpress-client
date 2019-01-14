package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author robin
 */
public enum CommentStatus {

    /**
     * 允许评论
     */
    OPEN("open"),
    /**
     * 不允许评论
     */
    CLOSED("closed"),
    /**
     * 仅允许注册用户评论
     */
    REGISTERED_ONLY("registered_only"),
    ;

    public final String status;


    CommentStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
