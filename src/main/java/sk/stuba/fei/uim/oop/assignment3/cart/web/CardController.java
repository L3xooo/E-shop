package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@RestController
@RequestMapping("/cart")
public class CardController {
    @Autowired
    private ICartService service;
    @GetMapping(value = "/{id}")
    public CartResponse getCart(@PathVariable("id") Long cartId) throws NotFoundException {
        return new CartResponse(this.service.getCartById(cartId));
    }
}
