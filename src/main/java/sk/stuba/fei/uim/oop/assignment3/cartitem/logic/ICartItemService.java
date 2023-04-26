package sk.stuba.fei.uim.oop.assignment3.cartitem.logic;

import org.aspectj.weaver.ast.Not;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartItemService {
    CartItem getCartItemById(Long id) throws NotFoundException;
    CartItem createCartItem(CartItemRequest request) throws NotFoundException;
}
