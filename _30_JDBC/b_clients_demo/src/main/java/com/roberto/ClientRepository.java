package com.roberto;

import javax.swing.text.html.Option;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ClientRepository {
    private static final Logger logger = Logger.getLogger(ClientRepository.class.getName());

    private final String url;
    private final String user;
    private final String password;

    public ClientRepository(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void save(String fullName, String email, String phone){
        String sql = """
                INSERT INTO clients(full_name, email, phone, status)
                VALUES (?, ?, ?, ?)
                """;

        try(
                Connection conn = DriverManager.getConnection(url,user,password);
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, ClientStatus.ACTIVE.name());

            int rows = ps.executeUpdate();

            logger.info("Cliente insertado, Filas afectadas: "+rows);
        }catch (SQLException e){
            logger.severe("Error al insertar cliente: "+e.getMessage());
        }
    }

    public List<Client> findAll(){
        String sql = """
                SELECT id, full_name, email, phone, status, created_at
                FROM clients
                ORDER BY id
                """;

        List<Client> clients = new ArrayList<>();

        try(
                Connection conn = DriverManager.getConnection(url,user,password);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while(rs.next()){
                clients.add(mapToClient(rs));
            }
        }catch (SQLException e){
            logger.severe("Error al listar clientes: "+e.getMessage());
        }

        return clients;
    }

    public Optional<Client> findByEmail(String email){
        String sql = """
                SELECT id, full_name, email, phone, status, created_at
                FROM clients
                WHERE email = ?
                """;

        try(
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1, email);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) return Optional.of(mapToClient(rs));
            }
        }catch (SQLException e){
            logger.severe("Error buscando cliente por email: "+e.getMessage());
        }
        return Optional.empty();
    }

    public void updatePhone(String email, String newPhone){
        String sql = """
                UPDATE clients
                SET phone = ?
                WHERE email = ?
                """;

        try(
                Connection conn = DriverManager.getConnection(url,user,password);
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1, newPhone);
            ps.setString(2, email);

            int rows = ps.executeUpdate();

            logger.info("Telefono actualizando. Filas afectadas: " +rows);
        }catch (SQLException e){
            logger.severe("Error actualizando telefono: "+e.getMessage());
        }
    }

    public void desactivate(String email){
        String sql = """
                UPDATE clients
                SET status = ?
                WHERE email = ?
                """;

        try(
                Connection conn = DriverManager.getConnection(url,user,password);
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, ClientStatus.INACTIVE.name());
            ps.setString(2,email);

            int rows = ps.executeUpdate();

            logger.info("Cliente desactivado. Filas afectadas: "+rows);
        }catch (SQLException e){
            logger.severe("Error desactivando cliente: "+e.getMessage());
        }
    }

    private Client mapToClient(ResultSet rs) throws SQLException{
        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp == null ? null : timestamp.toLocalDateTime();

        return new Client(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("phone"),
                ClientStatus.valueOf(rs.getString("status")),
                createdAt
        );
    }
}
