package ph.pcbuild.prototype;

public class AddToCartException extends RuntimeException {
    AddToCartException() {}

    AddToCartException(String message) {
        super(message);
    }

    AddToCartException(Throwable cause) {
        super(cause);
    }

    AddToCartException(String message, Throwable cause) {
        super(message, cause);
    }

    AddToCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
