package _22_Try_with_Resourse;

public class f_simular_jdbc_recursos_custom {
    static void main() throws Exception{
        try(Conexion conexion = new Conexion();
        Statement statement = conexion.crearStatement();
        ResultSet resultSet = statement.ejecutarConsulta()){
            resultSet.leer();
        }
    }
}

class ResultSet implements AutoCloseable {
    public void leer(){
        System.out.println("Leyendo resultados");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cerrando resultSet");
    }
}

class Statement implements AutoCloseable {
    public ResultSet ejecutarConsulta(){
        System.out.println("Ejecutando consulta");
        return new ResultSet();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cerrando statement");
    }
}

class Conexion implements AutoCloseable{
    public Statement crearStatement(){
        System.out.println("Creando statement");
        return new Statement();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cerrando conexion");
    }
}
