package org.chobit.wp.enums;

public enum PostTaxonomy {


    CATEGORY("category"),
    TAG("post_tag"),
    ;
    public final String taxonomy;

    PostTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }
}
