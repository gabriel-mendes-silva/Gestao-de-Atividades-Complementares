package Repositorio;

public interface Persistencia <T>{
    void inserir(T t);
    T buscarPorId(int id);

}
