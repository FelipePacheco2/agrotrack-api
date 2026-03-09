package AgroTrackpesagem.demo.assembler;

import AgroTrackpesagem.demo.controller.AnimalController;
import AgroTrackpesagem.demo.controller.EquipmentController;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentResponseDTO;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EquipamentAssembler extends
        RepresentationModelAssemblerSupport<EquipmentResponseDTO, EntityModel<EquipmentResponseDTO>> {

        public EquipamentAssembler() {
        super(EquipmentMapper.class, (Class<EntityModel<EquipmentResponseDTO>>) (Class<?>) EntityModel.class);
    }

        @Override
        public EntityModel<EquipmentResponseDTO> toModel (EquipmentResponseDTO dto){
            EquipmentController controller = methodOn(EquipmentController.class);
        return EntityModel.of(dto,
                linkTo(controller.listAll()).withRel("find-All-Tag-equipment").withType("GET"),
                linkTo(controller.create(null)).withRel("create-equipment").withType("POST"),
                linkTo(controller.update(dto.getId(), null)).withRel("update-equipment").withType("PUT"),
                linkTo(controller.delete(dto.getId())).withRel("delete-equipment").withType("DELETE")
        );
    }

}
