package ru.kpfu.itis.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.models.entities.Product;

import java.util.Optional;

public interface ProductsRepository extends CrudRepository<Product, Long> {
    Optional<Object> findFavoritesByUserId(Long userId);

    Optional<Object> findPurchasesByUserId(Long userId);

    public void addToPurchases(Long userId, Long productId);

    public void addToFavorites(Long userId, Long productId);

    public void removeFromPurchases(Long userId, Long productId);

    public void removeFromFavorites(Long userId, Long productId);

}