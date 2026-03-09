package AgroTrackpesagem.demo.mapperDto.equipment;

import AgroTrackpesagem.demo.mapperDto.MapperGeneric;
import AgroTrackpesagem.demo.model.Equipment;
import jakarta.persistence.Entity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipmentMapper extends MapperGeneric<EquipmentDTO, Equipment> {

    List<EquipmentResponseDTO> toListRes(List<Equipment> entity);
    EquipmentResponseDTO toDtoRes(Equipment entity);
}
