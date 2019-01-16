package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PostType {

    /**
     * 文章
     */
    POST("post"),
    /**
     * 页面
     */
    PAGE("page"),
    /**
     * 修订版数据
     */
    REVISION("revision"),
    /**
     * 附件
     */
    ATTACHMENT("attachment"),
    /**
     * 导航菜单条目
     */
    NAV_MENU_ITEM("nav_menu_item"),
    /**
     * 除修订版数据以及禁止搜索引擎搜索到的数据之外的全部内容
     */
    ANY("any");

    public final String type;

    PostType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
