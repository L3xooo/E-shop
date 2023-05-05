package sk.stuba.fei.uim.oop.assignment3.cartitem.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findCartItemByProductId(Long id);
}
