package com.example.Teatro.Cine.repository;

import com.example.Teatro.Cine.model.Butaca;

import java.util.Map;

public interface IButacaDB {
    Map<Integer, Butaca> listarButacas();

    boolean altaButaca(Butaca butaca);

    boolean modificarButaca(int idButaca, Butaca butaca);

    boolean borrarButaca(int idButaca);
}
