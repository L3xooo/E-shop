package sk.stuba.fei.uim.oop.assignment3.cartitem.data;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private int amount;
    @ManyToOne
    private Product product;
    public CartItem(){}
    public CartItem(Product product,int amount){
        this.amount = amount;
        this.product = product;
    }
}
