package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService service;
    @GetMapping(value = "/{id}")
    public CartResponse getCart(@PathVariable("id") Long cartId) throws NotFoundException {
        return new CartResponse(this.service.getCartById(cartId));
    }
    @PostMapping()
    public ResponseEntity<CartResponse> addCart() {
        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id") Long cartId) throws NotFoundException {
        this.service.delete(cartId);
    }
    @PostMapping(value = "/{id}/add")
    public CartResponse addToCart(@PathVariable("id") Long cartId, @RequestBody CartItemRequest request) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addToCart(cartId, request));
    }
    @GetMapping(value = "/{id}/pay")
    public double payForCart(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        return this.service.payForCart(cartId);
    }
}
