package ph.pcbuild.prototype;

public class OutOfStockException extends AddToCartException {
    public OutOfStockException(String msg) {
        super(msg);
    }
}
