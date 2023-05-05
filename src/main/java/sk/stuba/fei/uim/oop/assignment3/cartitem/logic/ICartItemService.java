package sk.stuba.fei.uim.oop.assignment3.cartitem.logic;

import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface ICartItemService {
    List<CartItem> getCartItemByProductId(Long id) throws NotFoundException;
    CartItem createCartItem(CartItemRequest request) throws NotFoundException;
}
