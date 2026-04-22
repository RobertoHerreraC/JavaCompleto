package Proyectos.MaquinaSnacksArchivos.src.servicio;

import Proyectos.MaquinaSnacksArchivos.src.dominio.Snack;

import java.util.List;

public interface IServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnack();
    List<Snack> getSnacks();
}
