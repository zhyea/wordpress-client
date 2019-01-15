package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PostOrderBy {

    /**
     * 按发布日期排序
     */
    DATE("date"),
    /**
     * 按修改时间排序
     */
    MODIFIED("modified"),
    /**
     * 按文章ID排序
     */
    ID("ID "),
    /**
     * 按评论最多排序
     */
    COMMENT_COUNT("comment_count "),
    /**
     * 按标题排序
     */
    TITLE("title "),
    /**
     * 随机排序
     */
    RAND("rand"),

    ;

    public final String value;

    PostOrderBy(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
