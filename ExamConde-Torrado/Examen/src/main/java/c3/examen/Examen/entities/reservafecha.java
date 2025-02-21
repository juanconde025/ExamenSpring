package c3.examen.Examen.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "reservafecha")
public class reservafecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
