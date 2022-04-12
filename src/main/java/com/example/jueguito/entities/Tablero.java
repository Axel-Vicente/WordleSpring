package com.example.jueguito.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tablero {
    private String palabra;
    private String[] lista_palabras = {"avion", "barco", "colegio", "direccion", "epifania", "francia", "gordura", "portero", "imagen", "juego"};

    public Tablero(){
        palabra = lista_palabras[(int)(Math.random()*lista_palabras.length)];
    }

    public boolean comprobar_letra(String letra){
        boolean letra_encontrada = false;
        for(int i = 0; i < palabra.length(); i++){
            if(palabra.charAt(i) == letra.charAt(0)){
                letra_encontrada = true;
            }
        }
        return letra_encontrada;
    }
}
