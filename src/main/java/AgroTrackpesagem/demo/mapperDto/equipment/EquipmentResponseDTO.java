package AgroTrackpesagem.demo.mapperDto.equipment;

import AgroTrackpesagem.demo.enums.StatusGeneral;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipmentResponseDTO {
    private Long id;
    private String model;
    private String serialNumber;
    private StatusGeneral statusGeneral;
}
