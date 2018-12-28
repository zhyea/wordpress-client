package org.chobit.wp.enums;

/**
 * @author robin
 */
public enum PostTaxonomy {

    /**
     * 文章分类
     */
    CATEGORY("category"),
    /**
     * 文章标签
     */
    TAG("post_tag"),
    ;
    public final String taxonomy;

    PostTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }
}
