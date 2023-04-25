package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository repository;
    @Autowired
    private IProductService service;

    @Override
    public Cart getCartById(Long id) throws NotFoundException {
        Cart cart = this.repository.findCartById(id);
        if (cart == null) {
            throw new NotFoundException();
        }
        return cart;

    }
    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Cart cart = this.getCartById(id);
        this.repository.delete(cart);
    }

    @Override
    public void addToCart(Long id, Product product) throws NotFoundException {
        Cart cart = this.getCartById(id);
        if (cart.isPayed()) {
            throw new NotFoundException();
        }
        cart.getShoppingList().add(product);
        this.repository.save(cart);
    }


}
