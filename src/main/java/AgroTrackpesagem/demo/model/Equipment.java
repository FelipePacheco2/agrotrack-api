package AgroTrackpesagem.demo.model;

import AgroTrackpesagem.demo.enums.StatusGeneral;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // model e numberSerie esta True para testes, mas o certo seria Obrigatorio.
    @Column(name="model", nullable = true, unique = true, length = 20)
    private String model;

    @Column(name="serial_number", nullable = true, unique = true, length = 15)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="status_general", nullable = false, length = 20)
    private StatusGeneral statusGeneral;
}
