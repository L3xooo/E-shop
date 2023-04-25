package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
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
}
