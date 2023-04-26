package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product create(ProductRequest request);
    Product getProductById(Long id) throws NotFoundException;
    Product update(Long id, ProductRequest request) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
    int getAmount(Long id) throws NotFoundException;
    int addAmount(Long id, int addAmount) throws NotFoundException;
    void decreaseAmount(Long id,int decreaseAmount) throws NotFoundException, IllegalOperationException;
}
