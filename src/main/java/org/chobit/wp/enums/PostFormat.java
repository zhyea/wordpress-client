package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PostFormat {
    /**
     * 特征即是没有标题的文章
     */
    ASIDE("aside"),
    /**
     * 图像相册
     */
    GALLERY("gallery"),
    /**
     * 指向其他站点的链接
     */
    LINK("link"),
    /**
     * 一个图片，文章中的第一个<img/>标签
     */
    IMAGE("image"),
    /**
     * 引文
     */
    QUOTE("quote"),
    /**
     * 状态
     */
    STATUS("status"),
    /**
     * 视频
     */
    VIDEO("video"),
    /**
     * 音频
     */
    AUDIO("audio"),
    /**
     * 聊天
     */
    CHAT("chat"),

    ;


    public final String format;


    PostFormat(String format) {
        this.format = format;
    }

    @JsonValue
    public String getFormat() {
        return format;
    }
}
