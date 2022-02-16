package se.lexicon.data.jdbc;
import se.lexicon.data.ShoppingCartItemDAO;
import se.lexicon.data.jdbc.DatabaseCredential;
import se.lexicon.model.ShoppingCartItem;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {

    @Override
    public ShoppingCartItem save(ShoppingCartItem cartItem) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO shopping_cart_item (id, amount, total_price, product_id, shopping_cart_id) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, cartItem.getId());
            preparedStatement.setInt(2, cartItem.getAmount());
            preparedStatement.setDouble(3, cartItem.getTotalPrice());
            preparedStatement.setInt(4, cartItem.getItem().getId());
            preparedStatement.setInt(5, cartItem.getCart().getId());
            preparedStatement.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return cartItem;
    }

    @Override
    public Optional<ShoppingCartItem> findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultCartItem = null;
        ResultSet resultProduct = null;
        ResultSet resultCart = null;
        ShoppingCartItem shoppingCartItem = null;

        try{
            connection = DatabaseCredential.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM shopping_cart_item WHERE id = ?");
            statement.setInt(1, id);
            resultCartItem = statement.executeQuery();
            while (resultCartItem.next()){
                resultCartItem.getInt("id");
                resultCartItem.getInt("amount");
                resultCartItem.getDouble("totalt_price");
                resultCartItem.getInt("product_id");
                resultCartItem.getInt("shopping_cart_id");
            }
 /*           connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT * FROM shopping_cart WHERE id = ?");
            statement.setInt(1, +++++++++++++++++);
            resultCart = statement.executeQuery();
            while (resultCart.next()){
                resultCart.getInt("id");
                resultCart.getDate("last_update");
                resultCart.getString("order_status");
                resultCart.getString("delivery_address");
                resultCart.getString("customer_reference");
            }
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
            statement.setInt(1, ++++++++++++++++++++++);
            resultPoduct = statement.executeQuery();
            while (resultCartItem.next()){
                resultProduct.getInt("id");
                resultProduct.getString("name");
                resultProduct.getDouble("price");
            }
*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ShoppingCartItem> findAll() {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByCartId(int id) {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByProductId(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
