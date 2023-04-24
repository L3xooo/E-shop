package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import java.util.List;

@Getter
@Setter
public class CartRequest {
    private List<Product> shoppingList;
    private boolean payed;
}
