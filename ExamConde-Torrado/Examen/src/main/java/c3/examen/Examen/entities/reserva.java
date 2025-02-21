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
    private espacio idEspacio;
    @OneToOne
    @JoinColumn(name = "id_ReservaFecha", nullable = false)
    private reservafecha idReservafecha;
    public reserva() {
    }
    public reserva(int id, String estado, cliente id_Cliente, espacio idEspacio, reservafecha idReservafecha) {
        this.id = id;
        this.estado = estado;
        this.id_Cliente = id_Cliente;
        this.idEspacio = idEspacio;
        this.idReservafecha = idReservafecha;
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
        return idEspacio;
    }
    public void setIdEspacio(espacio idEspacio) {
        this.idEspacio = idEspacio;
    }
    public reservafecha getIdReservafecha() {
        return idReservafecha;
    }
    public void setIdReservafecha(reservafecha idReservafecha) {
        this.idReservafecha = idReservafecha;
    }
    
}
