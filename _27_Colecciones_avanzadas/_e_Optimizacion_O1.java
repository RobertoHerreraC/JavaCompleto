package _27_Colecciones_avanzadas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _e_Optimizacion_O1 {
    static void main() {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario(1,"Roberto"));
        lista.add(new Usuario(2,"Kateryn"));
        lista.add(new Usuario(3,"Ingrid"));
        Usuario respuesta = buscarConList(lista,2);
        System.out.println(respuesta);

        Map<Integer, Usuario> mapa = new HashMap<>();
        mapa.put(1, new Usuario(1,"Roberto"));
        mapa.put(2, new Usuario(2,"Kateryn"));
        mapa.put(3, new Usuario(3,"Ingrid"));
        Usuario respuestaMapa = buscarConMap(mapa,3);
        System.out.println(respuestaMapa);
    }

    private static Usuario buscarConList(List<Usuario> lista, int id) {
        Usuario encontrado = null;
        for(Usuario u : lista){
            if(u.id==id) return u;
        }
        return encontrado;
    }

    private static Usuario buscarConMap(Map<Integer,Usuario> mapa, int id){
        return mapa.get(id);
    }
}

class Usuario{
    int id;
    String nombre;
    Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
