package sk.stuba.fei.uim.oop.assignment3.cartitem.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.ICartItemRepository;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

@Service
public class CartItemService implements ICartItemService{
    @Autowired
    private ICartItemRepository repository;
    @Autowired
    private IProductService service;

    @Override
    public CartItem getCartItemById(Long id) throws NotFoundException {
        CartItem cartItem = this.repository.findCartItemById(id);
        if (cartItem == null) {
            throw new NotFoundException();
        }
        return cartItem;
    }
    @Override
    public CartItem createCartItem(CartItemRequest request) throws NotFoundException {
        return this.repository.save(new CartItem(this.service.getProductById(request.getProductId()), request.getAmount()));
    }
}