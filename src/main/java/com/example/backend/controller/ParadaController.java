package com.example.backend.controller;

import com.example.backend.model.Paradas;
import com.example.backend.model.Rotas;
import com.example.backend.service.ParadaService;
import org.apache.lucene.util.SloppyMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/api/v1")
public class ParadaController {

    @Autowired
    private ParadaService paradaService;

    @PostMapping("/rotas/salvar")
    public ResponseEntity<String> salvar(@RequestBody Rotas rotas){
        return new ResponseEntity(paradaService.salvarParada(rotas), HttpStatus.OK);
    }

    @GetMapping("/rotas/{routeId}")
   public ResponseEntity<List<Paradas> > generatedRoutes(@PathVariable String routeId){
        Rotas rotas = paradaService.getRota(routeId);

        List<Paradas> listaRotasOrdAux = new ArrayList<>();
        TreeMap<Double, List<Paradas>> mapRoutes = new TreeMap<>();

        if(rotas.getStop().size() == 2){
            return new ResponseEntity(rotas.getStop(), HttpStatus.OK);
        }else{
            for (int i = 0; i < rotas.getStop().size(); i++){
                for(int j = i + 1; j < rotas.getStop().size(); j++){

                    double lat1 = Double.parseDouble(rotas.getStop().get(i).getLat());
                    double lng1 = Double.parseDouble(rotas.getStop().get(i).getLng());

                    double lat2 = Double.parseDouble(rotas.getStop().get(j).getLat());
                    double lng2 = Double.parseDouble(rotas.getStop().get(j).getLng());

                    double distance = SloppyMath.haversinMeters(lat1, lng1, lat2, lng2);

                    List<Paradas> listAuxVerificada = new ArrayList<>();
                    listAuxVerificada.add(rotas.getStop().get(i));
                    listAuxVerificada.add(rotas.getStop().get(j));

                    mapRoutes.put(distance, listAuxVerificada);

                }
            }
            for (Map.Entry<Double, List<Paradas>> entry : mapRoutes.entrySet()) {
                List<Paradas> value = entry.getValue();
                //System.out.println(key);
                for(int i = 0; i < value.size(); i++){
                    listaRotasOrdAux.add(value.get(i));
                }
            }

        }

        List<Paradas> listaRotasOrd = listaRotasOrdAux.stream().distinct().collect(Collectors.toList());

        return new ResponseEntity(listaRotasOrd, HttpStatus.OK);
    }


}
