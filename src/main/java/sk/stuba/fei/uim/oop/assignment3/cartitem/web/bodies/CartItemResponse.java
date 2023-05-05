package sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
@Setter
@Getter
public class CartItemResponse {
    private final int amount;
    private final Long productId;
    public CartItemResponse(CartItem cartItem) {
        this.amount = cartItem.getAmount();
        this.productId = cartItem.getProduct().getId();
    }
}
