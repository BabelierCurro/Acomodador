package com.example.Teatro.Cine.service;

import com.example.Teatro.Cine.model.Butaca;
import com.example.Teatro.Cine.repository.IButacaDB;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ButacaService implements IButacaService {

    private final IButacaDB butacaDB;

    public ButacaService(IButacaDB butacaDB) {
        this.butacaDB = butacaDB;
    }

    @Override
    public Map<Integer, Butaca> listarButacas() {
        return butacaDB.listarButacas();
    }

    @Override
    public boolean altaButaca(Butaca butaca) {
        return butacaDB.altaButaca(butaca);
    }

    @Override
    public boolean modificarButaca(int idButaca, Butaca butaca) {
        if (idButaca == butaca.getId()) {
            return butacaDB.modificarButaca(idButaca, butaca);
        }
        return false;
    }

    @Override
    public boolean borrarButaca(int idButaca) {
        if (idButaca <= butacaDB.listarButacas().size()) {
            return butacaDB.borrarButaca(idButaca);
        }
        return false;
    }
}
