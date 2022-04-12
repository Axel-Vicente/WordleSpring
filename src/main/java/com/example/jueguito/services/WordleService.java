package com.example.jueguito.services;

import com.example.jueguito.entities.Tablero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@Service
@Getter
@Setter
public class WordleService {

    private Tablero tablero;
    private Boolean parar;
    private Boolean ganador;
    private Boolean perdedor;
    private HashSet<String> letrasSacadas;
    private Character[] comparacionLetras;
    private Character[] comparacionLetras2;
    private List<String> palabrasUsadas;
    private Integer intentos;
    private int longitudPalabra;


    public WordleService() {
        this.parar = false;
        this.ganador = false;
        this.perdedor = false;
        this.tablero = new Tablero();
        this.longitudPalabra = tablero.getPalabra().length();
        this.letrasSacadas = new HashSet<>();
        this.palabrasUsadas = new ArrayList<>();
        this.comparacionLetras = new Character[tablero.getPalabra().length()];
        this.intentos = 5;
    }

    public void play(String palabraProbada) {
        palabraProbada.toLowerCase();
        palabrasUsadas.add(palabraProbada);
        comparacionLetras2 = palabraToChar(palabraProbada);

        if (parar) return;

        if(tablero.getPalabra().equals(palabraProbada)){
            ganador = true;
            parar = true;
        }else{
            --intentos;
            if(intentos == 0){
                perdedor = true;
                parar = true;
            }else {
                for (int i = 0; i < comparacionLetras.length; i++) {
                    if (comparacionLetras[i] == comparacionLetras2[i]) {
                        letrasSacadas.add(String.valueOf(comparacionLetras2[i]));
                        comparacionLetras[i] = '1';
                    }else if (tablero.getPalabra().contains(comparacionLetras2[i].toString())){
                        letrasSacadas.add(String.valueOf(comparacionLetras2[i]));
                        comparacionLetras[i] = '2';
                    }
                }
            }
        }
    }

    public void reset(){
        this.parar = false;
        this.ganador = false;
        this.tablero = new Tablero();
        this.longitudPalabra = tablero.getPalabra().length();
        this.letrasSacadas = new HashSet<>();
        this.palabrasUsadas = new ArrayList<>();
        this.comparacionLetras = new Character[tablero.getPalabra().length()];
        this.intentos = 5;
    }

    public Character[] palabraToChar(String palabraProbada){
        Character[] comparacionLetras2 = new Character[palabraProbada.length()];

        for(int i = 0; i < tablero.getPalabra().length(); i++){
            comparacionLetras[i] = tablero.getPalabra().charAt(i);
        }
        for (int i = 0; i < palabraProbada.length(); i++) {
            comparacionLetras2[i] = palabraProbada.charAt(i);
        }
        return comparacionLetras2;
    }
}
