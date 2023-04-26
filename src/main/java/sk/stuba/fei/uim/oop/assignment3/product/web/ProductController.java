package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;
    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest body){
        return new ResponseEntity<>(new ProductResponse(this.service.create(body)), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        return new ProductResponse(this.service.getProductById(productId));
    }
    @PutMapping(value = "/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long productId,@RequestBody ProductRequest body) throws NotFoundException {
        return new ProductResponse(this.service.update(productId,body));
    }
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) throws NotFoundException {
        this.service.delete(productId);
    }
    @GetMapping("/{id}/amount")
    public Amount getProductAmount(@PathVariable("id") Long productId) throws NotFoundException {
        return new Amount(this.service.getAmount(productId));
    }
    @PostMapping("/{id}/amount")
    public Amount addProductAmount(@PathVariable("id") Long productId, @RequestBody Amount body) throws NotFoundException {
        return new Amount(this.service.addAmount(productId,body.getAmount()));
    }
    @PutMapping("/{id}/amount")
    public void decreaseProductAmount(@PathVariable("id") Long productId, @RequestBody Amount body) throws NotFoundException, IllegalOperationException {
        this.service.decreaseAmount(productId,body.getAmount());
    }


}
