public class ServicioEmail {

    public void enviarConfirmacion(String emailCliente, String nombreCliente, double total) {
        System.out.println("Enviando correo a " + emailCliente + "...");
        System.out.println("Asunto: Confirmacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombreCliente + ", su pedido por $"
                + total + " ha sido procesado.");
        System.out.println("[LOG] Pedido procesado para " + nombreCliente
                + " Total: " + total);
    }

    public void enviarCancelacion(String emailCliente, String nombreCliente, int idPedido) {
        System.out.println("Enviando correo a " + emailCliente + "...");
        System.out.println("Asunto: Cancelacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombreCliente + ", su pedido #"
                + idPedido + " ha sido cancelado.");
    }
}