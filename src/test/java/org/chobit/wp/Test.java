package org.chobit.wp;

import org.chobit.wp.model.request.PostRequest;
import org.chobit.wp.tools.JsonKit;

import java.io.IOException;
import java.util.Map;

/**
 * @author robin
 */
public class Test {

    public static void main(String[] args) throws IOException {
        PostRequest request = new PostRequest();
        request.setPostName("ceshi");
        request.setPostTitle("测试");

        Map<String, Object> m = request.toMap();
        System.out.println(JsonKit.toJson(m));

    }
}
