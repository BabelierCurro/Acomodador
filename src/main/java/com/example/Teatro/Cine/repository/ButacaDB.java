package com.example.Teatro.Cine.repository;

import com.example.Teatro.Cine.model.Butaca;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ButacaDB implements IButacaDB {

    private Map<Integer, Butaca> listaButacas = new HashMap<>();
    private int lastID = 1;

    @Override
    public Map<Integer, Butaca> listarButacas() {
        return listaButacas;
    }

    @Override
    public boolean altaButaca(Butaca butaca) {
        butaca.setId(lastID++);
        listaButacas.put(butaca.getId(), butaca);
        return true;
    }

    @Override
    public boolean modificarButaca(int idButaca, Butaca butaca) {
        listaButacas.replace(idButaca, butaca);
        return true;
    }

    @Override
    public boolean borrarButaca(int idButaca) {
        if (listaButacas.remove(idButaca) != null) {
            return true;
        }
        return false;
    }
}
