import java.util.HashMap;
import java.util.Map;

public class CalculadoraDescuentos {

    private interface EstrategiaDescuento {
        double calcular(double subtotal);
    }

    private static final Map<String, EstrategiaDescuento> estrategias = new HashMap<>();

    static {
        estrategias.put("VIP", subtotal -> subtotal * 0.20);
        estrategias.put("FRECUENTE", subtotal -> subtotal * 0.10);
        estrategias.put("REGULAR", subtotal -> subtotal * 0.05);
        estrategias.put("NUEVO", subtotal -> 0.0);
    }

    public static double obtenerDescuento(String tipoCliente, double subtotal) {
        EstrategiaDescuento estrategia = estrategias.getOrDefault(tipoCliente.toUpperCase(), subtotal -> 0.0);
        return estrategia.calcular(subtotal);
    }
}