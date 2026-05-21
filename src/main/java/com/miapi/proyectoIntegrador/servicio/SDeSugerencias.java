package com.miapi.proyectoIntegrador.servicio;

import com.miapi.proyectoIntegrador.modelo.Catalogo;
import com.miapi.proyectoIntegrador.repositorio.RDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SDeSugerencias {

    @Autowired
    private RDeCatalogo repositorio;

    public int calcularPuntaje(Catalogo planta,int luzU,int riegoU, int tempU, int ambU,int cuiU) {
        int puntaje = 0;

        puntaje +=5 - Math.abs(planta.getLuz()-luzU);
        puntaje +=5 - Math.abs(planta.getRiego()-riegoU);
        puntaje +=5 - Math.abs(planta.getTemperatura()-tempU);
        puntaje +=5 - Math.abs(planta.getAmbiente()-ambU);
        puntaje +=5 - Math.abs(planta.getCuidado()-cuiU);

        return puntaje;

    }

    public Catalogo Sugerir(int luzU, int riegoU, int tempU, int ambU, int cuiU) {
        List<Catalogo> plantas =repositorio.findAll();

        Catalogo mejorPlanta= null;
        int mejorPuntaje = 0;

        for (Catalogo catalogo : plantas) {
            int puntaje = calcularPuntaje(catalogo,luzU,riegoU,tempU,ambU,cuiU);

            if (puntaje > mejorPuntaje) {
                mejorPuntaje = puntaje;
                mejorPlanta = catalogo;
            }
        }
        return mejorPlanta;
    }

}
