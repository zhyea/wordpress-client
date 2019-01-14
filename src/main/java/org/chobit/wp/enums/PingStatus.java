package org.chobit.wp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author robin
 */
public enum  PingStatus {

    /**
     * 打开pingback功能
     */
    OPEN("open"),
    /**
     * 关闭pingback功能
     */
    CLOSED("closed"),
    ;

    public final String status;

    PingStatus(String alias) {
        this.status = alias;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
