package main.java.api;

import java.util.ArrayList;
import java.util.List;

public class Agrupamento<T> {
    private final ArrayList<T> listagem = new ArrayList<>();

    public boolean adicionar(T elemento) {
        return listagem.add(elemento);
    }

    public boolean remover(T elemento) {
        return listagem.remove(elemento);
    }

    public boolean contem(T elemento) {
        return listagem.contains(elemento);
    }

    public T get(int i) {
        return listagem.get(i);
    }

    public int tamanho() {
        return listagem.size();
    }

    public void adicionarEmGrupo(ArrayList<T> elementos) {
        for (T t : elementos) {
            adicionar(t);
        }
    }

    public ArrayList<T> getListagem() {
        return new ArrayList<T>(this.listagem);
    }

    public void esvaziarListagem() {
        this.listagem.removeAll(List.copyOf(listagem));
    }
}
