package AgroTrackpesagem.demo.swaggerDoc;

import AgroTrackpesagem.demo.mapperDto.animal.*;
import AgroTrackpesagem.demo.model.Animal;
import AgroTrackpesagem.demo.model.Weighing;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AnimalSwagger {
    @GetMapping("/search-all")
    @Operation(
            summary = "Retorna todos os animais",
            description = "Retorna a lista completa de todos os animais cadastrados no sistema e suas informaçoes",
            tags = "Animal",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Weighing.class))
                    ),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<CollectionModel<EntityModel<AnimalResponseDTO>>> listAll();

    @GetMapping("/{idAnimal}/search")
    @Operation(
            summary = "Busca um animal pelo identificador único",
            description = "Retorna os detalhes completos de um animal específico pelo identificador único",
            tags = "Animal",
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
    ResponseEntity<EntityModel<AnimalResponseDTO>> getById(@PathVariable Long idAnimal);

    @PostMapping("/register")
    @Operation(
            summary = "Registra um animal",
            description = "Registre um cercado personalizado no sistema, definindo sua finalidade " +
                    "(NELORE, ANGUS, BRAHMAN, HEREFORD, SENEPOL)",
            tags = "Animal",
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
    ResponseEntity<EntityModel<AnimalResponseDTO>> create(@RequestBody AnimalDTO dto);

    @PutMapping("/{idAnimal}/update/all")
    @Operation(
            summary = "Atualizar o animal",
            description = "Atualize os campos de animal pelo identificador único",
            tags = "Animal",
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
    ResponseEntity<EntityModel<AnimalResponseDTO>> update(
            @PathVariable Long idAnimal,
            @RequestBody AnimalUpdateDTO dto);

    @PutMapping("/{idAnimal}/move/surrounded")
    @Operation(
            summary = "Move animal de cercado",
            description = "Mova o animal de cercado pelo identificador único",
            tags = "Animal",
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
    ResponseEntity<EntityModel<AnimalResponseDTO>> moveAnimal(
            @PathVariable Long idAnimal,
            @RequestBody AnimalSurroundedMoveDTO dto);

    @PutMapping("/{idAnimal}/update/status")
    @Operation(
            summary = "Atualizar o Status do animal",
            description = "Atualize o status do animal pelo identificador único",
            tags = "Animal",
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
    ResponseEntity<EntityModel<AnimalResponseDTO>> updateStatus(
            @PathVariable Long idAnimal,
            @RequestBody UpdateAnimalStatusDTO dto);

    @DeleteMapping("/{idAnimal}/delete")
    @Operation(
            summary = "Deletar animal pelo identificador único",
            description = "Deletar animal pelo identificador único",
            tags = "Surrounded",
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
    ResponseEntity<Void> delete(@PathVariable Long idAnimal);
}
