package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.logic.ICartItemService;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository repository;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartItemService cartItemService;

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
    public Cart addToCart(Long cartId, CartItemRequest request) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getUnpaid(cartId);
        this.productService.decreaseAmount(request.getProductId(), request.getAmount());

        CartItem searchResult = checkProductInCart(cart, request.getProductId());

        if ( searchResult != null) {
            searchResult.setAmount(searchResult.getAmount() + request.getAmount());
        } else {
            CartItem cartItem = this.cartItemService.createCartItem(request);
            cart.getShoppingList().add(cartItem);
        }
        return this.repository.save(cart);
    }

    @Override
    public String payForCart(Long cartId) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getUnpaid(cartId);
        cart.setPayed(true);
        this.repository.save(cart);
        double price = 0;
        for (int a = 0; a < cart.getShoppingList().size(); a++) {
            price += cart.getShoppingList().get(a).getAmount()*cart.getShoppingList().get(a).getProduct().getPrice();
        }
        return Double.toString(price);
    }

    private CartItem checkProductInCart(Cart cart, Long productId){
        for (int a = 0; a < cart.getShoppingList().size(); a++) {
            if (cart.getShoppingList().get(a).getProduct().getId() == productId) {
                return cart.getShoppingList().get(a);
            }
        }
        return null;
    }

    public Cart getUnpaid(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getCartById(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        return cart;
    }
}
