import java.util.List;

public class GestorPedidos {

    private RepositorioPedidos repositorio;
    private GeneradorFactura generadorFactura;
    private ServicioEmail servicioEmail;

    public GestorPedidos(RepositorioPedidos repositorio, GeneradorFactura generadorFactura, ServicioEmail servicioEmail) {
        this.repositorio = repositorio;
        this.generadorFactura = generadorFactura;
        this.servicioEmail = servicioEmail;
    }

    public void procesarPedido(String nombreCliente, String emailCliente,
                               List<String> nombresProductos,
                               List<Double> preciosProductos,
                               List<Integer> cantidades,
                               String tipoCliente) {

        if (!ValidadorCliente.esValido(nombreCliente, emailCliente)) return;

        double subtotal = 0;
        for (int i = 0; i < nombresProductos.size(); i++) {
            subtotal += preciosProductos.get(i) * cantidades.get(i);
        }

        double descuento = 0;
        if (tipoCliente.equals("VIP")) {
            descuento = subtotal * 0.20;
        } else if (tipoCliente.equals("FRECUENTE")) {
            descuento = subtotal * 0.10;
        } else if (tipoCliente.equals("REGULAR")) {
            descuento = subtotal * 0.05;
        } else if (tipoCliente.equals("NUEVO")) {
            descuento = 0;
        }

        double impuesto = (subtotal - descuento) * 0.12;
        double total = subtotal - descuento + impuesto;

        repositorio.guardarPedido(nombreCliente, total);
        generadorFactura.generar(nombreCliente, nombresProductos, preciosProductos, cantidades, subtotal, descuento, impuesto, total);
        servicioEmail.enviarConfirmacion(emailCliente, nombreCliente, total);
    }

    public void cancelarPedido(String nombreCliente, String emailCliente, int idPedido) {

        if (!ValidadorCliente.esValido(nombreCliente, emailCliente)) return;

        repositorio.eliminarPedido(idPedido);
        servicioEmail.enviarCancelacion(emailCliente, nombreCliente, idPedido);
    }
}