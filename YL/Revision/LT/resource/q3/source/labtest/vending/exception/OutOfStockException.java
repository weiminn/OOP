package labtest.vending.exception;

import labtest.vending.model.*;

public class OutOfStockException extends Exception {
    private Product product;

    public OutOfStockException(String message, Product product) {
        super(message);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
