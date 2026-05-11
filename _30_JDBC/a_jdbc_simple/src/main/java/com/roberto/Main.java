package com.roberto;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc_demo";
    private static final String USER = "root";
    private static final String PASSWORD = "DevPassword123";
    static void main() {
        insertProduct("Mouse Logitech", new BigDecimal("89.90"));
        insertProduct("Teclado", new BigDecimal("46.90"));
        insertProduct("Pantalla", new BigDecimal("150.00"));
        insertProduct("Laptop", new BigDecimal("2000.00"));


        listProducts();

    }

    private static void insertProduct(String name, BigDecimal price){
        String sql = """
                INSERT INTO products(name, price)
                VALUES(?, ?)
                """;

        try(
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1, name);
            ps.setBigDecimal(2, price);

            int rows = ps.executeUpdate();

            logger.info("Producto insertando. Filas afectadas: "+rows);
        }catch (SQLException e){
            logger.severe("Error insertando producto: "+e.getMessage());
        }
    }

    private static void listProducts(){
        String sql = """
                SELECT id, name, price, created_at
                FROM products
                ORDER BY id
                """;

        try(
                Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDateTime createAt = rs.getTimestamp("created_at")
                        .toLocalDateTime();

                System.out.println(
                        id + " | "+
                                name + " | "+
                                price + " | "+
                                createAt
                );
            }
        }catch (SQLException e){
            logger.severe("Error listando productos: "+e.getMessage());
        }
    }
}
