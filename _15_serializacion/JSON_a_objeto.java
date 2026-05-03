package _15_serializacion;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON_a_objeto {
    static void main() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = """
                    {
                    "nombre": "Roberto",
                    "edad":30
                    }
                    """;
            Usuario2 usuario = mapper.readValue(json, Usuario2.class);
            System.out.println(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Usuario2 {
    public String nombre;
    public int edad;
    public Usuario2(){}

    @Override
    public String toString() {
        return "Usuario2{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
