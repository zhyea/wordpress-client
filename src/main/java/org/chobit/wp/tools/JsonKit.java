package org.chobit.wp.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author robin
 */
public abstract class JsonKit {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);

        SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        MAPPER.setDateFormat(defaultDateFormat);
    }


    public static String toJson(Object src) throws JsonProcessingException {
        return MAPPER.writeValueAsString(src);
    }


    public static <T> T fromJson(String json, Class<T> classOfT) throws IOException {
        return MAPPER.readValue(json, classOfT);
    }


    public static <T> T fromJson(String json, TypeReference<T> typeReference) throws IOException {
        return MAPPER.readValue(json, typeReference);
    }


    private JsonKit() {
        throw new UnsupportedOperationException("private constructor, cannot be accessed.");
    }
}
