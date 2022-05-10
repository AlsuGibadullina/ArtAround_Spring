package ru.kpfu.itis.services;

import ru.kpfu.itis.models.entities.Product;

import java.util.Optional;

public interface ProductsService {

    public void addToPurchases(Long userId, Long productId);

    public void addToFavorites(Long userId, Long productId);

    public void removeFromPurchases(Long userId, Long productId);

    public void removeFromFavorites(Long userId, Long productId);

    Iterable<Product> findAll();

    Optional<Object> findFavoritesByUserId(Long userId);

    Optional<Object> findPurchasesByUserId(Long userId);

}
