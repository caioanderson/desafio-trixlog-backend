package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Rotas {

    @Id
    private String id;

    private String idRota;
    private String name;

    private LocalDateTime routeDate;

    private List<Paradas> stop;

    @DBRef
    private Users user;

    public Rotas(String id, String idRota, String name, LocalDateTime routeDate, List<Paradas> stop, Users user) {
        this.id = id;
        this.idRota = idRota;
        this.name = name;
        this.routeDate = routeDate;
        this.stop = stop;
        this.user = user;
    }

    public Rotas() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRouteDate() {
        return routeDate;
    }

    public void setRouteDate(LocalDateTime routeDate) {
        this.routeDate = routeDate;
    }

    public List<Paradas> getStop() {
        return stop;
    }

    public void setStop(List<Paradas> stop) {
        this.stop = stop;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getIdRota() {
        return idRota;
    }

    public void setIdRota(String idRota) {
        this.idRota = idRota;
    }
}
