package se.lexicon;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import se.lexicon.data.ProductDAO;
import se.lexicon.data.ShoppingCartDAO;
import se.lexicon.data.ShoppingCartItemDAO;
import se.lexicon.data.jdbc.ProductDAOImpl;
import se.lexicon.data.jdbc.ShoppingCartDAOImpl;
import se.lexicon.data.jdbc.ShoppingCartItemDAOImpl;
import se.lexicon.model.Product;
import se.lexicon.model.ShoppingCart;
import se.lexicon.model.ShoppingCartItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ProductDAO product = new ProductDAOImpl();
//        product.save(new Product(90, "Band", 5));

        ShoppingCartDAO shoppingCart = new ShoppingCartDAOImpl();
//        shoppingCart.save(new ShoppingCart(65, LocalDateTime.now(), "klar", "Ronneby", "kund", true));

//        ShoppingCartItemDAO shoppingCartItem = new ShoppingCartItemDAOImpl();
//        shoppingCartItem.save(new ShoppingCartItem(45, 80, 90.50, product, shoppingCart));

//        System.out.println(product.findById(12));

//        List<Product> productList = new ArrayList<>(product.findByName("Banan"));
/*
        List<Product> productList = new ArrayList<>(product.findByPriceBetween(5, 10));
        for (Product prod : productList) {
            System.out.println("------");
            System.out.println(prod);
        }
*/
//        System.out.println("Borttagna rader: ");
//        System.out.println(product.delete(90));

        List<Product> productList = new ArrayList<>(product.findAll());
        for (Product prod : productList) {
            System.out.println("------");
            System.out.println(prod);
        }
    }
}
