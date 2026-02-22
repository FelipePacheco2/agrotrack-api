package AgroTrackpesagem.demo.controller;


import AgroTrackpesagem.demo.assembler.AnimalAssembler;
import AgroTrackpesagem.demo.mapperDto.animal.*;
import AgroTrackpesagem.demo.service.AnimalService;
import AgroTrackpesagem.demo.swaggerDoc.AnimalSwagger;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animals")
@Tag(name = "Animal", description = "Controle de identificação, localização e dados genéticos do rebanho.")
public class AnimalController implements AnimalSwagger {
    private final AnimalService service;
    private final AnimalAssembler assembler;

    @GetMapping("/search-all")
    @Override
    public ResponseEntity<CollectionModel<EntityModel<AnimalResponseDTO>>> listAll(){
        return ResponseEntity.ok(assembler.toCollectionModel(service.findAll()));
    }

    @GetMapping("/{idAnimal}/search")
    @Override
    public ResponseEntity<EntityModel<AnimalResponseDTO>> getById(@PathVariable Long idAnimal) {
        return ResponseEntity.ok(assembler.toModel(service.findById(idAnimal)));
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<EntityModel<AnimalResponseDTO>> create(@RequestBody AnimalDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toModel(service.create(dto)));
    }

    @PutMapping("/{idAnimal}/update/all")
    @Override
    public ResponseEntity<EntityModel<AnimalResponseDTO>> update(
            @PathVariable Long idAnimal,
            @RequestBody AnimalUpdateDTO dto){
        return ResponseEntity.ok(
                assembler.toModel(service.update(idAnimal, dto)));
    }

    @PutMapping("/{idAnimal}/move/surrounded")
    @Override
    public ResponseEntity<EntityModel<AnimalResponseDTO>> moveAnimal(
            @PathVariable Long idAnimal,
            @RequestBody AnimalSurroundedMoveDTO dto){
        return ResponseEntity.ok(
                assembler.toModel(service.moveAnimal(idAnimal, dto))
        );
    }

    @PutMapping("/{idAnimal}/update/status")
    @Override
    public ResponseEntity<EntityModel<AnimalResponseDTO>> updateStatus(
            @PathVariable Long idAnimal,
            @RequestBody UpdateAnimalStatusDTO dto){
        return ResponseEntity.ok(
                assembler.toModel(service.updateStatus(idAnimal, dto)));
    }

    @DeleteMapping("/{idAnimal}/delete")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long idAnimal){
        service.delete(idAnimal);
        return ResponseEntity.noContent().build();
    }
}
