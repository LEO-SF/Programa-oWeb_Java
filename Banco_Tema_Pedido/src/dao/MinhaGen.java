package dao;

import java.util.*;
import java.util.function.Predicate;

public class MinhaGen<E>{
    private List<E> lista;

    public MinhaGen() {
        lista = new ArrayList<>();
    }
    public void cadastrar(E objeto) {
        lista.add(objeto);
    }

    public E pesquisarPorString(String valorBusca, Predicate<E> predicate) {
        for (E objeto : lista) {
            if (predicate.test(objeto)) {
                return objeto;
            }
        }
        return null;
    }

    public E excluirPorString(String str, Predicate<E> predicate) {
        int i = 0;
        for (E objeto : lista) {
            if (predicate.test(objeto)) {
                return lista.remove(i);
            }
            i++;
        }
        return null;
    }

    public void listarTodos() {
        String auxPessoas = "";
        if (lista != null) {
            for (E objeto : lista) {
                if (objeto != null)
                    auxPessoas += objeto + "\n";
            }
        }
        System.out.println("\n" + auxPessoas);
    }
}


