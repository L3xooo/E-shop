package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartService {
    Cart getCartById(Long id) throws NotFoundException;
}
