package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cartitem.data.CartItem;

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
    @OneToMany(cascade = {CascadeType.REMOVE})
    private List<CartItem> shoppingList;
    private boolean payed;
    public Cart(){
        this.shoppingList = new ArrayList<>();
    }
}
