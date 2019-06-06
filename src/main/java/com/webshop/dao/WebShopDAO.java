/**
 * May 2019
 * @author GeorgeGabor
 *
 */

package com.webshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.entity.Product;

@Transactional
@Repository
public class WebShopDAO implements IWebShopDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    // method to get all products available in database and return it as List<Product>

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProducts()
    {
        String hql = "FROM Product as atcl ORDER BY atcl.id";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }

    //  method to get a particular Product detail by given product id

    @Override
    public Product getProduct(int productId)
    {
        return entityManager.find(Product.class, productId);
    }

    // method to create new product in database

    @Override
    public Product createProduct(Product product)
    {
        entityManager.persist(product);
        Product b = getLastInsertedProduct();
        return b;
    }

    //  method to update product detail in database

    @Override
    public Product updateProduct(int productId, Product product)
    {
        Product productFromDB = getProduct(productId);
        productFromDB.setName(product.getName());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setPrice(product.getPrice());

        entityManager.flush();

        Product updatedProduct = getProduct(productId);

        return updatedProduct;
    }

    //  method for deleting a particular record(by ProductId) from the database

    @Override
    public boolean deleteProduct(int productId)
    {
        Product product = getProduct(productId);
        entityManager.remove(product);

        boolean status = entityManager.contains(product);
        if(status)
        {
            return false;
        }
        return true;
    }

    // method will get the latest inserted record from the database and return the object of Product class @return product

    private Product getLastInsertedProduct()
    {
        String hql = "from Product order by id DESC";
        Query query = entityManager.createQuery(hql);
        query.setMaxResults(1);
        Product product = (Product)query.getSingleResult();
        return product;
    }
}
