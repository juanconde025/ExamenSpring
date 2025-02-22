package c3.examen.Examen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "espacio")
public class espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String tipo;
    private int capacidad_maxima;
    private String disponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_Admin", nullable = false)
    private admin id_Admin;

    public espacio() {
    }

    public espacio(int id, String nombre, String tipo, int capacidad_maxima, String disponibilidad, admin id_Admin) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad_maxima = capacidad_maxima;
        this.disponibilidad = disponibilidad;
        this.id_Admin = id_Admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;   
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public admin getId_Admin() {
        return id_Admin;
    }

    public void setId_Admin(admin id_Admin) {
        this.id_Admin = id_Admin;
    }
    @Override
    public String toString() {
        return "Espacio{" + "id=" + id + ", nombre='" + nombre + '\'' + ", tipo='" + tipo + '\'' +
                ", capacidad maxima='" + capacidad_maxima + '\'' + ", disponibilidad=" + disponibilidad + ", Admin='" + id_Admin + '\'' + 
                + '}';
    }
    
}
