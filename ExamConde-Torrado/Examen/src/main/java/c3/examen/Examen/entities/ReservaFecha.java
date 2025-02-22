package c3.examen.Examen.entities;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservafecha")
public class ReservaFecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int año;
    private int mes;
    private int dia;
    private Time hora_inicio;
    private Time hora_final;
   
    public ReservaFecha() {
    }
    
    public ReservaFecha(int id, int año, int mes, int dia, Time hora_inicio, Time hora_final) {
        this.id = id;
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public Time getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public Time getHora_final() {
        return hora_final;
    }
    public void setHora_final(Time hora_final) {
        this.hora_final = hora_final;
    }
    
    
}