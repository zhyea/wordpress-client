package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author robin
 */
public enum PostStatus {


    /**
     * 公开的
     */
    PUBLISH("publish"),
    /**
     * 待审核
     */
    PENDING("pending"),
    /**
     * 草稿
     */
    DRAFT("draft"),
    /**
     * 自动草稿
     */
    AUTO_DRAFT("auto-draft"),
    /**
     * 定时
     */
    FUTURE("future"),
    /**
     * 私有的
     */
    PRIVATE("private"),
    /**
     * 继承，子页面继承父级页面属性
     */
    INHERIT("inherit"),
    /**
     * 垃圾箱
     */
    TRASH("trash"),
    ;

    public final String status;

    PostStatus(String alias) {
        this.status = alias;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
