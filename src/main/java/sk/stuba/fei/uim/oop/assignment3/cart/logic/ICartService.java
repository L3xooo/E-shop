package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

public interface ICartService {
    Cart getCartById(Long id) throws NotFoundException;
    Cart create();
    void delete(Long id) throws NotFoundException;
    void addToCart(Long id, Product product) throws NotFoundException;
}
