package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Product;

import javax.servlet.http.Cookie;
import java.util.List;

public interface ProductsService {

    public void addToPurchases(Long userId, Long productId);

    public void addToFavorites(Long userId, Long productId);

    public void removeFromPurchases(Long userId, Long productId);

    public void removeFromFavorites(Long userId, Long productId);

    List<Product> findAll();

    List<Product> findFavoritesByUserId(Long userId);

    List<Product> findPurchasesByUserId(Long userId);

}
