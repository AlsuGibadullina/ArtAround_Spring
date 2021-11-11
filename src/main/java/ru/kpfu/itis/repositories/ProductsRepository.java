package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Product;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Product> {
    List<Product> findFavoritesByUserId(Long userId);

    List<Product> findPurchasesByUserId(Long userId);

    public void addToPurchases(Long userId, Long productId);

    public void addToFavorites(Long userId, Long productId);

    public void removeFromPurchases(Long userId, Long productId);

    public void removeFromFavorites(Long userId, Long productId);

}