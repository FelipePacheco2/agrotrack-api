package AgroTrackpesagem.demo.mapperDto.equipment;

import AgroTrackpesagem.demo.enums.StatusGeneral;

public record EquipmentDTO(
        String model,
        String serialNumber,
        StatusGeneral statusGeneral
) {
}
