package AgroTrackpesagem.demo.service;

import AgroTrackpesagem.demo.enums.AnimalStatus;
import AgroTrackpesagem.demo.exception.BusinessRuleException;
import AgroTrackpesagem.demo.exception.EntityNotFoundException;
import AgroTrackpesagem.demo.mapperDto.animal.*;
import AgroTrackpesagem.demo.model.Animal;
import AgroTrackpesagem.demo.model.Surrounded;
import AgroTrackpesagem.demo.repository.AnimalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository repository;
    private final SurroundedService surroundedService;
    private final AnimalMapper mapper;

    public List<AnimalResponseDTO> findAll(){
        return mapper.toResponseDTOList(repository.findAll());
    }

    public AnimalResponseDTO findById(Long idAnimal){
        return mapper.toResponseDTO(returnAnimalById(idAnimal));
    }

    @Transactional
    public AnimalResponseDTO create(AnimalDTO dto){
        Surrounded surrounded = surroundedService.fetchEmptySurround(dto.getSurrounded());
        Animal animal = mapper.toEntity(dto);
        animalIsLive(animal);

        animal.setSurrounded(surrounded);
        return mapper.toResponseDTO(repository.save(animal));
    }

    @Transactional
    public AnimalResponseDTO update(Long idAnimal, AnimalUpdateDTO dto){
        Animal entity = returnAnimalById(idAnimal);
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public AnimalResponseDTO moveAnimal(Long idAnimal, AnimalSurroundedMoveDTO dto) {
        Animal entity = getActiveById(idAnimal);
        Surrounded surrounded = surroundedService.fetchEmptySurround(dto.surrounded());
        entity.setSurrounded(surrounded);

        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public AnimalResponseDTO updateStatus(Long idAnimal, UpdateAnimalStatusDTO dto){
        Animal entity = returnAnimalById(idAnimal);
        animalIsLive(entity);
        entity.setStatus(dto.status());

        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(Long idAnimal){
        isExistAnimal(idAnimal);
        repository.deleteById(idAnimal);
    }

    public Animal returnAnimalById(Long idAnimal){
        return repository.findById(idAnimal)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Animal returnAnimalByTag(String tag){
        return repository.findByTag(tag)
                .orElseThrow(EntityNotFoundException::new);
    }

    // retorna só animais vivos
    public Animal getActiveById(Long id) {
        Animal entity = returnAnimalById(id);
        animalIsLive(entity);
        return entity;
    }

    public void animalIsLive(Animal animal){
        if (animal.getStatus() == AnimalStatus.DECEASED) {
            throw new BusinessRuleException();
        }
    }

    public void isExistAnimal(Long idAnimal){
        if(!repository.existsById(idAnimal)){
            throw new EntityNotFoundException();
        }
    }


}
