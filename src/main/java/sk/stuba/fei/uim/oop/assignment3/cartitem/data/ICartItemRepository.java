package sk.stuba.fei.uim.oop.assignment3.cartitem.data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItem,Long> {
    CartItem findCartItemByProductIdAndCartId(Long productId,Long cartId);
}
