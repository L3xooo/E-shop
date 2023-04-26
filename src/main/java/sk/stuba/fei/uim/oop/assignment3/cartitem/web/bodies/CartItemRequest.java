package sk.stuba.fei.uim.oop.assignment3.cartitem.web.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {
    private int amount;
    private Long productId;
}
