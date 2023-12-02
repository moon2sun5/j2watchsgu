package com.sgu.j2watch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.repositories.ProductRepository;
import com.sgu.j2watch.repositories.ProductRepositoryJPA;
import com.sgu.j2watch.repositories.ThongKeTopSPRepository;
import com.sgu.j2watch.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    
    @Autowired
    private ProductRepositoryJPA productRepositoryJPA;
   

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = null;

        if (result.isPresent()) {
            product = result.get();
        } else {
            // Handle the case where the product is not found.
            // Throw an exception or return null.
        }

        return product;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

	@Override
	public Product getProductById(Integer id_product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Integer id_product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getProductsByBrandId(Integer brand_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByCategoryId(Integer category_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Product> searchNameProduct(String keyName){
		return this.productRepositoryJPA.searchNameProduct(keyName);
	}
	
	@Override
	public List<Product> findByCondition(Integer id_category, Integer id_brand, Float price){
		return this.productRepositoryJPA.findByCondition(id_category, id_brand, price);
	}
	
	@Override
	public List<Product> productBestSeller(){
		return this.productRepositoryJPA.productBestSeller();
	}
	
}