package c3.examen.Examen.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "reserva")
public class reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    private cliente id_Cliente;
    @OneToOne
    @JoinColumn(name = "id_Espacio", nullable = false)
    private espacio id_Espacio;
    @OneToOne
    @JoinColumn(name = "id_ReservaFecha", nullable = false)
    private reservafecha id_ReservaFecha;
    public reserva() {
    }
    public reserva(int id, String estado, cliente id_Cliente, espacio id_Espacio, reservafecha id_ReservaFecha) {
        this.id = id;
        this.estado = estado;
        this.id_Cliente = id_Cliente;
        this.id_Espacio = id_Espacio;
        this.id_ReservaFecha = id_ReservaFecha;
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
    public cliente getId_Cliente() {
        return id_Cliente;
    }
    public void setId_Cliente(cliente id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    public espacio getIdEspacio() {
        return id_Espacio;
    }
    public void setIdEspacio(espacio id_Espacio) {
        this.id_Espacio = id_Espacio;
    }
    public reservafecha getIdReservafecha() {
        return id_ReservaFecha;
    }
    public void setIdReservafecha(reservafecha id_ReservaFecha) {
        this.id_ReservaFecha = id_ReservaFecha;
    }
    
}
