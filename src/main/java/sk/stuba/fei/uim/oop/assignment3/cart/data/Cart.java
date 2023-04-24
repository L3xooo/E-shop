package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<Product> shoppingList;
    private boolean payed;
    public Cart(){
        this.shoppingList = new ArrayList<>();
    }
    public Cart(CartRequest cartReq){
        this.shoppingList = new ArrayList<>();
        this.payed = cartReq.getPayed();
    }
}
