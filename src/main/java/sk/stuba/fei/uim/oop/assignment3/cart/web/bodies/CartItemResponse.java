package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

@Getter
@Setter
@NoArgsConstructor
public class CartItemResponse {
    private long productId;
    private long amount;

    public CartItemResponse(CartItem cartItem){
        this.productId = cartItem.getProduct().getId();
        this.amount = cartItem.getProduct().getAmount();
    }
}
