package se.lexicon.data;

import se.lexicon.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    public Product save(Product product);
    public Optional<Product> findById(int id);
    public List<Product> findAll();
    public List<Product> findByName(String name);
    public List<Product> findByPriceBetween(double low, double high);
    public int delete(int id);


}
