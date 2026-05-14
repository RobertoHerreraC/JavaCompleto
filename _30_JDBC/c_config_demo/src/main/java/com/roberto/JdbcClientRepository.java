package com.roberto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JdbcClientRepository implements  ClientRepository{

    private static  final Logger logger = Logger.getLogger(JdbcClientRepository.class.getName());

    private final DatabaseConfig config;

    public JdbcClientRepository(DatabaseConfig config){
        this.config = config;
    }

    @Override
    public void save(String fullName, String email, String phone, String status) {
        String sql = """
                INSERT INTO clients(full_name, email, phone,
                status) VALUES (?, ?, ?, ?)
                """;

        try(
                Connection conn = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());
                PreparedStatement ps = conn.prepareStatement(sql);

                ){
            ps.setString(1,fullName);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setString(4,status);

            int rows = ps.executeUpdate();
            logger.info("Cliente insertado. Filas afectadas: "+rows);

        }catch (SQLException e){
            if("23505".equals(e.getSQLState())){
                logger.warning("El email ya existe: "+email);
                return;
            }
            logger.severe("Error guardando cliente: "+e.getMessage());
        }
    }

    @Override
    public List<Client> findAll() {
        String sql = """
                SELECT id, full_name, email, phone, status, created_at
                FROM clients
                ORDER BY id
                """;
        List<Client> clients = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while(rs.next()) clients.add(mapToClient(rs));
        }catch (SQLException e){
            logger.severe("Error listando clientes: "+e.getMessage());
        }

        return clients;
    }

    private Client mapToClient(ResultSet rs)throws SQLException{
        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp ==null? null: timestamp.toLocalDateTime();
        return new Client(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("status"),
                createdAt
        );
    }
}
