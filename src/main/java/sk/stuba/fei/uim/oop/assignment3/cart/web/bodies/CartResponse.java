package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartResponse {
    private final long id;
    private final List<CartItemResponse> shoppingList;
    private final boolean payed;
    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList().stream().map(CartItemResponse::new).collect(Collectors.toList());
        this.payed = cart.isPayed();
    }
}
