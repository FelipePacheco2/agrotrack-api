package AgroTrackpesagem.demo.controller;

import AgroTrackpesagem.demo.assembler.EquipamentAssembler;
import AgroTrackpesagem.demo.mapperDto.animal.AnimalResponseDTO;
import AgroTrackpesagem.demo.mapperDto.animal.AnimalUpdateDTO;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentDTO;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentResponseDTO;
import AgroTrackpesagem.demo.mapperDto.surrounded.SurroundedDTO;
import AgroTrackpesagem.demo.mapperDto.surrounded.SurroundedResponseDTO;
import AgroTrackpesagem.demo.service.EquipmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Equipament")
@Tag(name = "Equipament", description = "Gestão de equipamentos")
public class EquipmentController implements AgroTrackpesagem.demo.swaggerDoc.EquipmentSwagger {
    private final EquipamentAssembler assembler;
    private final EquipmentService service;

    @GetMapping("/search-all")
    @Override
    public ResponseEntity<CollectionModel<EntityModel<EquipmentResponseDTO>>> listAll(){
        return ResponseEntity.ok(assembler.toCollectionModel(service.findAll()));
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<EntityModel<EquipmentResponseDTO>> create(@RequestBody EquipmentDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toModel(service.create(dto)));
    }

    @PutMapping("/{id}/update/all")
    @Override
    public ResponseEntity<EntityModel<EquipmentResponseDTO>> update(
            @PathVariable Long id,
            @RequestBody EquipmentDTO dto){
        return ResponseEntity.ok(
                assembler.toModel(service.update(id, dto)));
    }

    @DeleteMapping("/{id}/delete")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
