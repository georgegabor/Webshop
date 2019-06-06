/**
 * May 2019
 * @author GeorgeGabor
 *
 */

package com.webshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.dao.IWebShopDAO;
import com.webshop.entity.Product;

@Service
public class WebShopService implements IWebShopService
{

    @Autowired
    private IWebShopDAO dao;

    @Override
    public List<Product> getProducts()
    {
        return dao.getProducts();
    }

    @Override
    public Product createProduct(Product product)
    {
        return dao.createProduct(product);
    }

    @Override
    public Product updateProduct(int productId, Product product)
    {
        return dao.updateProduct(productId, product);
    }

    @Override
    public Product getProduct(int productId)
    {
        return dao.getProduct(productId);
    }

    @Override
    public boolean deleteProduct(int productId)
    {
        return dao.deleteProduct(productId);
    }

}
