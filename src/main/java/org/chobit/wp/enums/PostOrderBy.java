package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PostOrderBy {

    /**
     * 无序
     */
    NONE("none"),
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
     * 按评论数量排序
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
    /**
     * 按post_name（即post slug）排序
     */
    NAME("name"),
    /**
     * 按post_type排序
     */
    TYPE("type"),
    /**
     * 按author排序
     */
    AUTHOR("author"),
    /**
     * 按文章/页面的parent id排序
     */
    PARENT("parent"),
    /**
     *  适用于搜索文章的情况。按搜索结果的相关性排序。
     *  首先，是否整句匹配；第二，是否全部搜索内容都在文章标题里面；第三：是否部分搜索内容在文章标题里面；第四：是否整句都出现在文章内容里面
     */
    RELEVANCE("relevance"),

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
