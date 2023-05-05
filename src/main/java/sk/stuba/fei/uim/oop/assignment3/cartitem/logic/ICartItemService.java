package sk.stuba.fei.uim.oop.assignment3.cartitem.logic;

import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartItemService {
    CartItem getCartItemByProductIdAndCartId(Long productId,Long cartId) throws NotFoundException;
    CartItem createCartItem(CartItemRequest request) throws NotFoundException;
    void save(CartItem cartItem);
}
