package dao;

public interface OperacoesDAO<T> {
    public int inserir(T obj);
    public MinhaGen<T> listarTodos();
    public int atualizar(T obj);
    public int deletar(T obj);
    public T pesquisarID(int id);
}