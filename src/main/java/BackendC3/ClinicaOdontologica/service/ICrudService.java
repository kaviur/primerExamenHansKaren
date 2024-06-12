package BackendC3.ClinicaOdontologica.service;

import java.util.List;

public interface ICrudService<T, I> {

    T buscar(I id);
    T guardar(T t);
    T actualizar(T t);
    void eliminar(I id);
    List<T> buscarTodos();

}
