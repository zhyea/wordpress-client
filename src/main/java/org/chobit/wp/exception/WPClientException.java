package org.chobit.wp.exception;

/**
 * @author robin
 */
public class WPClientException extends RuntimeException {

    public WPClientException() {
        super();
    }

    public WPClientException(String message) {
        super(message);
    }

    public WPClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public WPClientException(Throwable cause) {
        super(cause);
    }
}
