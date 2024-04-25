package com.example.Teatro.Cine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Butaca {
    private int id;
    private int fila;
    private int numero;
    private boolean ocupada;
}
