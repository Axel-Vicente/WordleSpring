package com.example.jueguito.controller;

import com.example.jueguito.entities.Tablero;
import com.example.jueguito.services.WordleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordleController {
    @Autowired
    WordleService service;

    @GetMapping("/reset")
    public ModelAndView reset(){
        service.reset();

        return index();
    }

    @GetMapping("/play")
    public ModelAndView play(@RequestParam(value = "palabra") String palabra) {
        Tablero tablero = service.getTablero();
        service.play(palabra);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("palabra", tablero);
        mav.addObject("parar", service.getParar());
        mav.addObject("ganador", service.getGanador());
        mav.addObject("perdedor", service.getPerdedor());
        mav.addObject("palabras", service.getComparacionLetras());
        mav.addObject("palabrasProbadas", service.getComparacionLetras2());
        mav.addObject("palabrasUsadas", service.getPalabrasUsadas());
        mav.addObject("intentos", service.getIntentos());
        mav.addObject("letrasEncontradas", service.getLetrasSacadas());
        mav.addObject("logitudPalabra", service.getLongitudPalabra());
        return mav;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("palabra", service.getTablero());
        mav.addObject("parar", service.getParar());
        mav.addObject("intentos", service.getIntentos());
        mav.addObject("logitudPalabra", service.getLongitudPalabra());

        return mav;
    }
}
