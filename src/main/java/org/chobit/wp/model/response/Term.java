package org.chobit.wp.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Term {


    private String termId;

    private String name;

    private String slug;

    @JsonProperty("term_group")
    private String termGroup;

    @JsonProperty("term_taxonomy_id")
    private String termTaxonomyId;

    private String taxonomy;

    private String description;

    private String parent;

    private int count;


    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTermGroup() {
        return termGroup;
    }

    public void setTermGroup(String termGroup) {
        this.termGroup = termGroup;
    }

    public String getTermTaxonomyId() {
        return termTaxonomyId;
    }

    public void setTermTaxonomyId(String termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
