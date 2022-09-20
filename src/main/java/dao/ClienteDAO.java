package dao;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends BaseDAO{
    public static List<Cliente> selectClientes(){
        final String sql = "SELECT * FROM cliente ORDER BY nomeCliente";
        try
                (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                )
        {
            List<Cliente> clienteList = new ArrayList<>();
            while (rs.next()){
                clienteList.add(resultSetToCliente(rs));
            }
            return clienteList;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Cliente> selectClienteByName(String nome){
        final String sql = "SELECT * FROM cliente WHERE LOWER(nomeCliente) LIKE ? ORDER BY nomeCliente";
        try
                (
                      Connection conn = getConnection();
                      PreparedStatement pstmt = conn.prepareStatement(sql);
                        )
        {
            pstmt.setString(1,"%" + nome.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                List<Cliente> clienteList = new ArrayList<>();
                clienteList.add(resultSetToCliente(rs));
                while (rs.next()) {
                    clienteList.add(resultSetToCliente(rs));
                }
                rs.close();
                return clienteList;
            }
            else
                return null;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cliente selectClienteById(int id){
        final String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        try
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        )
        {
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            Cliente cliente = null;
            if(rs.next())
                cliente = resultSetToCliente(rs);
            rs.close();
            return cliente;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Cliente selectClienteByEmail(String email) {
        final String sql = "SELECT * FROM cliente WHERE emailCliente = ?";
        try
                (
                    Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setString(1,email);
            ResultSet rs = pstmt.executeQuery();
            Cliente cliente = null;
            if(rs.next())
                cliente = resultSetToCliente(rs);
            rs.close();
            return  cliente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertCliente(Cliente cliente) {
        final String sql = "INSERT INTO cliente(nomeCliente, enderecoCliente, cepCliente, telefoneCliente, emailCliente) VALUES(?, ?, ?, ?, ?)";
        try
                (
                      Connection conn = getConnection();
                      PreparedStatement pstmt = conn.prepareStatement(sql);
                      )
        {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEndereco());
            pstmt.setString(3, cliente.getCep());
            pstmt.setString(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getEmail());
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCliente(Cliente cliente){
        final String sql = "UPDATE cliente SET nomeCliente=?, enderecoCliente=?, cepCliente=?, telefoneCliente=?, emailCliente=? WHERE idCliente=?";
        try
                (
                 Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                        )
        {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEndereco());
            pstmt.setString(3, cliente.getCep());
            pstmt.setString(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getEmail());
            pstmt.setInt(6, cliente.getId());
            int count = pstmt.executeUpdate();
            return count > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCliente(int id) {
        final String sql = "DELETE FROM cliente WHERE id = ?";
        try
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        )
        {
            pstmt.setInt(1, id);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Cliente resultSetToCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getInt("idCliente"));
        c.setNome(rs.getString("nomeCliente"));
        c.setEndereco(rs.getString("enderecoCliente"));
        c.setCep(rs.getString("cepCliente"));
        c.setTelefone(rs.getString("telefoneCliente"));
        c.setEmail(rs.getString("emailCliente"));
        return c;
    }



    public static void main(String[] args) {


        System.out.println("\nAlterando um cliente");
        Cliente cliente = selectClienteById(1);
        cliente.setEndereco("Fernando Osório, 749");
        System.out.println(ClienteDAO.updateCliente(cliente));
        System.out.println("\nCliente alterado: " + ClienteDAO.selectClienteById(1));
    }
}
