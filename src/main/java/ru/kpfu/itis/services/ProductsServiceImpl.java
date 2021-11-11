package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Product;
import ru.kpfu.itis.repositories.ProductsRepository;

import java.util.List;

public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void addToPurchases(Long userId, Long productId) {
        productsRepository.addToPurchases(userId, productId);
    }

    @Override
    public void addToFavorites(Long userId, Long productId) {
        productsRepository.addToFavorites(userId, productId);
    }

    @Override
    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Product> findFavoritesByUserId(Long userId) {
        return productsRepository.findFavoritesByUserId(userId);
    }

    @Override
    public List<Product> findPurchasesByUserId(Long userId) {
        return productsRepository.findPurchasesByUserId(userId);
    }

    @Override
    public void removeFromPurchases(Long userId, Long productId) {
        productsRepository.removeFromPurchases(userId, productId);
    }

    @Override
    public void removeFromFavorites(Long userId, Long productId) {
        productsRepository.removeFromFavorites(userId, productId);
    }
}
