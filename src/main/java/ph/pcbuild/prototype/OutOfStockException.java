package ph.pcbuild.prototype;

public class OutOfStockException extends CartException {
    public OutOfStockException(String msg) {
        super(msg);
    }
}
