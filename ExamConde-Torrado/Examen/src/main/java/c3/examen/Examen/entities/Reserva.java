package c3.examen.Examen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String estado;

    @ManyToOne
@JoinColumn(name = "id_Cliente", nullable = false)
private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_Espacio", nullable = false)
    private Espacio espacio;
    @OneToOne
    @JoinColumn(name = "id_ReservaFecha", nullable = false)
    private ReservaFecha reservaFecha;
    
    public Reserva() {
    }
   
    public Reserva(int id, String estado, Cliente cliente, Espacio espacio, ReservaFecha reservaFecha) {
        this.id = id;
        this.estado = estado;
        this.cliente = cliente;
        this.espacio = espacio;
        this.reservaFecha = reservaFecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public ReservaFecha getReservaFecha() {
        return reservaFecha;
    }

    public void setReservaFecha(ReservaFecha reservaFecha) {
        this.reservaFecha = reservaFecha;
    }

    
    
}
