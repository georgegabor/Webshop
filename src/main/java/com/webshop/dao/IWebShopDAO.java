/**
 * May 2019
 * @author GeorgeGabor
 *
 */

package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Product;

public interface IWebShopDAO
{
    List<Product> getProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(int productId,Product product);
    boolean deleteProduct(int productId);

}
