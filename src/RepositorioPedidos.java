import java.sql.*;

public class RepositorioPedidos {
    private Connection conexionBD;

    public RepositorioPedidos() {
        try {
            this.conexionBD = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda", "root", "admin123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarPedido(String nombreCliente, double total) {
        try {
            Statement stmt = conexionBD.createStatement();
            String sql = "INSERT INTO pedidos (cliente, total) VALUES ('"
                    + nombreCliente + "'," + total + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido: " + e.getMessage());
        }
    }

    public void eliminarPedido(int idPedido) {
        try {
            Statement stmt = conexionBD.createStatement();
            String sql = "DELETE FROM pedidos WHERE id=" + idPedido;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al cancelar el pedido: " + e.getMessage());
        }
    }
}