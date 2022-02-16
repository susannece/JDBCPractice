package se.lexicon.data.jdbc;

import se.lexicon.data.ShoppingCartDAO;
import se.lexicon.model.ShoppingCart;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    @Override
    public ShoppingCart save(ShoppingCart cart) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO shopping_cart (id, last_update, order_status, delivery_address, customer_reference) VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, cart.getId());
            preparedStatement.setObject(2, cart.getLastUpdate());
            preparedStatement.setString(3, cart.getOrderStatus());
            preparedStatement.setString(4, cart.getDeliveryAddress());
            preparedStatement.setString(5, cart.getCustomerReference());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public Optional<ShoppingCart> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public List<ShoppingCart> findByOrderStatus(String status) {
        return null;
    }

    @Override
    public List<ShoppingCart> findByReference(String customerReference) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
