package org.chobit.wp;

import org.chobit.wp.model.request.PostRequest;

import java.io.IOException;

/**
 * @author robin
 */
public class Test {

    public static void main(String[] args) throws IOException {
        PostRequest request = new PostRequest();
        request.setPostAuthor(11);
        System.out.println(request.toMap());
    }
}
