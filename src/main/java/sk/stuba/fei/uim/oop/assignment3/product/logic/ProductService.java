package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;


@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;
}
