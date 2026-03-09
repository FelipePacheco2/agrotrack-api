package AgroTrackpesagem.demo.swaggerDoc;

import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentDTO;
import AgroTrackpesagem.demo.mapperDto.equipment.EquipmentResponseDTO;
import AgroTrackpesagem.demo.model.Animal;
import AgroTrackpesagem.demo.model.Equipment;
import AgroTrackpesagem.demo.model.Weighing;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface EquipmentSwagger {
    @GetMapping("/search-all")
    @Operation(
            summary = "Retorna todos os Equipamentos",
            description = "Retorna a lista completa de todos os Equipamentos cadastrados no sistema, exibindo detalhes.",
            tags = "Equipment",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Equipment.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<CollectionModel<EntityModel<EquipmentResponseDTO>>> listAll();

    @PostMapping("/register")
    @Operation(
            summary = "Registra um Equipamento",
            description = "Registre um Equipamento  no sistema",
            tags = "Equipment",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Weighing.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<EntityModel<EquipmentResponseDTO>> create(@RequestBody EquipmentDTO dto);

    @PutMapping("/{id}/update/all")
    @Operation(
            summary = "Atualizar o equipamento",
            description = "Atualize os campos do equipamento pelo identificador único",
            tags = "Equipment",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Weighing.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<EntityModel<EquipmentResponseDTO>> update(
            @PathVariable Long id,
            @RequestBody EquipmentDTO dto);

    @DeleteMapping("/{id}/delete")
    @Operation(
            summary = "Deletar o equipamento pelo identificador único",
            description = "Deletar equipamento pelo identificador único",
            tags = "Equipment",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Animal.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<Void> delete(@PathVariable Long id);
}
