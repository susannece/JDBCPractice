package se.lexicon.data.jdbc;
import se.lexicon.data.ProductDAO;
import se.lexicon.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public Product save(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO product (id, name, price) VALUES (?,?,?)");
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Optional<Product> findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Product product = null;

        try{
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            while (result.next()){
                product = new Product(
                result.getInt("id"),
                result.getString("name"),
                result.getDouble("price"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Product product = null;
        List<Product> productList = new ArrayList<>();

        try{
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product ");
            result = preparedStatement.executeQuery();
            while (result.next()){
                product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("price"));
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> findByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Product product = null;
        List<Product> productList = new ArrayList<>();

        try{
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE name LIKE ? ");
            preparedStatement.setString(1, name);
            result = preparedStatement.executeQuery();
            while (result.next()){
                product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("price"));
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> findByPriceBetween(double low, double high) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Product product = null;
        List<Product> productList = new ArrayList<>();

        try{
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE price BETWEEN ? AND ? ");
            preparedStatement.setDouble(1, low);
            preparedStatement.setDouble(2, high);
            result = preparedStatement.executeQuery();
            while (result.next()){
                product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("price"));
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
       int rowsAffected = 0;

        try {
            connection = DatabaseCredential.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ? ");
            preparedStatement.setDouble(1, id);
            rowsAffected = preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return rowsAffected;
    }
}
