/**
 * May 2019
 * @author GeorgeGabor
 *
 */

package com.webshop.services;

import java.util.List;

import com.webshop.entity.Product;

public interface IWebShopService
{
    List<Product> getProducts();
    Product createProduct(Product product);
    Product updateProduct(int productId, Product product);
    Product getProduct(int productId);
    boolean deleteProduct(int productId);
}
