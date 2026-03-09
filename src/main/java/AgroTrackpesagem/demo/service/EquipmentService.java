package AgroTrackpesagem.demo.service;

import AgroTrackpesagem.demo.exception.EntityNotFoundException;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentDTO;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentMapper;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentResponseDTO;
import AgroTrackpesagem.demo.model.Equipment;
import AgroTrackpesagem.demo.repository.EquipmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentMapper mapper;
    private final EquipmentRepository repository;

    public List<EquipmentResponseDTO> findAll(){
        return mapper.toListRes(repository.findAll());
    }

    @Transactional
    public EquipmentResponseDTO create(EquipmentDTO dto){
        return mapper.toDtoRes(repository.save(mapper.toEntity(dto)));
    }

    @Transactional
    public EquipmentResponseDTO update(Long id, EquipmentDTO dto){
        Equipment entity = returnEquipmentById(id);
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDtoRes(repository.save(entity));
    }


    public void delete(long id){
        isExist(id);
        repository.deleteById(id);
    }

    public Equipment returnEquipmentById(long id){
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void isExist(long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
    }
}
