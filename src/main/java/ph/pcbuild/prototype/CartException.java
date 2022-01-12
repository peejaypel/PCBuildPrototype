package ph.pcbuild.prototype;

public class CartException extends RuntimeException {
    CartException() {}

    CartException(String message) {
        super(message);
    }

    CartException(Throwable cause) {
        super(cause);
    }

    CartException(String message, Throwable cause) {
        super(message, cause);
    }

    CartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
