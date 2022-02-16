package se.lexicon.data;

import se.lexicon.model.ShoppingCart;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {
    public ShoppingCart save(ShoppingCart cart);
    public Optional<ShoppingCart> findById(int id);
    public List<ShoppingCart> findAll();
    public List<ShoppingCart> findByOrderStatus(String status);
    public List<ShoppingCart> findByReference(String customerReference);
    public void delete(int id);

}
