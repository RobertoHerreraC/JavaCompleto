package com.roberto.repository;

import com.roberto.config.DatabaseConfig;
import com.roberto.exception.ProductAlreadyExistsException;
import com.roberto.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class JdbcProductRepository implements ProductRepository{

    private static final Logger logger = Logger.getLogger(JdbcProductRepository.class.getName());

    private final DatabaseConfig config;

    public JdbcProductRepository(DatabaseConfig config){
        this.config = config;
    }


    @Override
    public void save(String code, String name, BigDecimal price) {
        String sql = """
                INSERT INTO products_1 (code, name, price)
                VALUES (? , ?, ?)
                """;

        try(
                Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1,code);
            ps.setString(2,name);
            ps.setBigDecimal(3,price);

            int rows = ps.executeUpdate();
            logger.info("Se agrego el producto. Filas afectadas: "+rows);
        }catch (SQLException e){
            if("23505".equals(e.getSQLState())) throw new ProductAlreadyExistsException(code);

            throw new IllegalStateException("Error guardando producto",e);
        }
    }

    @Override
    public List<Product> findAll() {

        String sql = """
                SELECT id, code, name, price, active, created_at
                FROM products_1
                ORDER BY id
                """;
        List<Product> products = new ArrayList<>();
        try(
                Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while(rs.next()){
                products.add(mapToProduct(rs));
            }
        }catch (SQLException e){
            throw new IllegalStateException("Error listando productos",e);
        }


        return products;
    }

    @Override
    public Optional<Product> findByCode(String code) {
        String sql = """
                SELECT id, code, name, price, active, created_at
                FROM products_1
                WHERE code = ?
                """;

        try(
                Connection con = DriverManager.getConnection(config.getUrl(), config.getUser(),config.getPassword());
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,code);
            try(
                    ResultSet rs = ps.executeQuery()
                    ){
                if(rs.next()) return Optional.of(mapToProduct(rs));

                return Optional.empty();
            }

        }catch (SQLException e){
            throw new IllegalStateException("Error buscando producto",e);
        }

    }

    @Override
    public boolean updatePrice(String code, BigDecimal newPrice) {
        String sql = """
                UPDATE products_1
                SET price = ?
                WHERE code = ? 
                """;

        try(
                Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setBigDecimal(1,newPrice);
            ps.setString(2,code);

            int rows = ps.executeUpdate();

            logger.info("Precio actualizado. Filas actualizadas: "+rows);

            return rows>0;
        }catch (SQLException e){
            throw new IllegalStateException("Error actualizando precio",e);
        }
    }

    @Override
    public boolean desactivate(String code) {
        String sql = """
                UPDATE products_1
                SET active = FALSE
                WHERE code = ?
                """;

        try(
                Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,code);
            int rows = ps.executeUpdate();
            logger.info("Producto desactivado. Filas actualizadas: "+rows);
            return rows>0;
        }catch (SQLException e){
            throw new IllegalStateException("Error desactivando producto",e);
        }
    }

    private Product mapToProduct(ResultSet rs) throws SQLException{
        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp==null? null:timestamp.toLocalDateTime();

        return new Product(
                rs.getInt("id"),
                rs.getString("code"),
                rs.getString("name"),
                rs.getBigDecimal("price"),
                rs.getBoolean("active"),
                createdAt
        );

    }
}
