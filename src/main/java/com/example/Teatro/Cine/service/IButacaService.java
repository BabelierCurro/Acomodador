package com.example.Teatro.Cine.service;

import com.example.Teatro.Cine.model.Butaca;

import java.util.Map;

public interface IButacaService {

    Map<Integer, Butaca> listarButacas();

    boolean altaButaca(Butaca butaca);

    boolean modificarButaca(int idButaca, Butaca butaca);

    boolean borrarButaca(int idButaca);
}
