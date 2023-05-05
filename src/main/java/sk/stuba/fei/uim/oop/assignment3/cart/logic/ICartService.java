package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartService {
    Cart getCartById(Long id) throws NotFoundException;
    Cart create();
    void delete(Long id) throws NotFoundException;
    Cart addToCart(Long cartId, CartItemRequest request) throws NotFoundException, IllegalOperationException;
    String payForCart(Long cartId) throws NotFoundException, IllegalOperationException;
}
