package org.chobit.wp.model.request;


import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Map;

import static org.chobit.wp.tools.JsonKit.fromJson;
import static org.chobit.wp.tools.JsonKit.toJson;

public abstract class Request {

    public Map<String, Object> toMap() throws IOException {
        String json = toJson(this);
        return fromJson(json, new TypeReference<Map<String, Object>>() {
        });
    }
}
