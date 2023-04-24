package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;


@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        return this.repository.save(new Product(request));
    }
    @Override
    public Product getProductById(long id) throws NotFoundException {
        Product product = this.repository.findProductById(id);
        if (product == null) {
            throw new NotFoundException();
        }
        return this.repository.findProductById(id);
    }

    @Override
    public Product update(long id, ProductRequest request) throws NotFoundException {
        Product product = this.getProductById(id);
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        return this.repository.save(product);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        Product product = this.getProductById(id);
        this.repository.delete(product);
    }

    public int getAmount(long id) throws NotFoundException {
        Product product = this.getProductById(id);
        return product.getAmount();
    }

    @Override
    public int addAmount(long id, int addAmount) throws NotFoundException {
        Product product = this.getProductById(id);
        product.setAmount(product.getAmount()+addAmount);
        this.repository.save(product);
        return product.getAmount();
    }
}
