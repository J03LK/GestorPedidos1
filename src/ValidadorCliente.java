public class ValidadorCliente {

    public static boolean esValido(String nombreCliente, String emailCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            System.out.println("Error: nombre de cliente invalido");
            return false;
        }
        if (emailCliente == null || !emailCliente.contains("@")) {
            System.out.println("Error: email invalido");
            return false;
        }
        return true;
    }
}