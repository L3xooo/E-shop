package sk.stuba.fei.uim.oop.assignment3.cartitem.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.ICartItemRepository;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

@Service
public class CartItemService implements ICartItemService{
    @Autowired
    private ICartItemRepository repository;
    @Autowired
    private IProductService productService;

    @Override
    public CartItem getCartItemByProductIdAndCartId(Long productId, Long cartId) {
        return this.repository.findCartItemByProductIdAndCartId(productId,cartId);
    }
    @Override
    public CartItem createCartItem(CartItemRequest request) throws NotFoundException {
        return this.repository.save(new CartItem(this.productService.getProductById(request.getProductId()),
                request.getAmount()));
    }
    @Override
    public void save(CartItem cartItem) {
        this.repository.save(cartItem);
    }
}
