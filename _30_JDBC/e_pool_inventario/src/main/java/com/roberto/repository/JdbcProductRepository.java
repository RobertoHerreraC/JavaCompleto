package com.roberto.repository;

import com.roberto.config.ConnectionFactory;
import com.roberto.exception.ProductAlreadyExistsException;
import com.roberto.model.Product;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository  implements  ProductRepository{

    private final ConnectionFactory connectionFactory;

    public JdbcProductRepository(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void save(String code, String name, BigDecimal price, int stock) {
        String sql = """
                INSERT INTO products_2(code, name, price, stock)
                VALUES(?, ?, ?,?)
                """;
        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,code);
            ps.setString(2,name);
            ps.setBigDecimal(3,price);
            ps.setInt(4,stock);

            int rows = ps.executeUpdate();

        }catch (SQLException e){
            if("23505".equals(e.getSQLState())) throw new ProductAlreadyExistsException(code);

            throw new IllegalArgumentException("Error guardando producto",e);
        }
    }

    @Override
    public List<Product> findAllActive() {
        String sql = """
                SELECT id, code, name, price, stock, active, created_at
                FROM products_2
                WHERE active = TRUE
                ORDER BY id
                """;
        List<Product> products = new ArrayList<>();

        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while(rs.next()){
                products.add(mapToProduct(rs));
            }
            return products;
        }catch (SQLException e){
            throw new IllegalStateException("Error listando productos",e);
        }
    }

    @Override
    public Optional<Product> findByCode(String code) {
        String sql = """
                SELECT id, code, name, price, stock, active, created_at
                FROM products_2
                WHERE code = ?
                """;

        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,code);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(mapToProduct(rs));
                }
                return Optional.empty();
            }
        }catch (SQLException e){
            throw new IllegalStateException("Error buscando producto",e);
        }
    }

    @Override
    public boolean updateStock(String code, int newStock) {
        String sql = """
                UPDATE products_2
                SET stock = ?
                WHERE code = ?
                AND active = TRUE
                """;

        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setInt(1,newStock);
            ps.setString(2,code);
            int rows = ps.executeUpdate();
            return rows>0;
        }catch (SQLException e){
            throw new IllegalStateException("Error actualizando stock",e);
        }
    }

    @Override
    public boolean desactivate(String code) {
        String sql = """
                UPDATE products_2
                SET active = FALSE
                WHERE code = ?
                """;

        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,code);
            int rows = ps.executeUpdate();
            return rows>0;
        }catch (SQLException e){
            throw new IllegalStateException("Error desactivando producto.",e);
        }
    }

    private Product mapToProduct(ResultSet rs) throws SQLException {
        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp==null? null:timestamp.toLocalDateTime();

        return new Product(
                rs.getLong("id"),
                rs.getString("code"),
                rs.getString("name"),
                rs.getBigDecimal("price"),
                rs.getInt("stock"),
                rs.getBoolean("active"),
                createdAt
        );
    }
}
