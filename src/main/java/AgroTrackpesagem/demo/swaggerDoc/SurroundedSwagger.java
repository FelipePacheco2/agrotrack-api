package AgroTrackpesagem.demo.swaggerDoc;

import AgroTrackpesagem.demo.mapperDto.surrounded.SurroundedDTO;
import AgroTrackpesagem.demo.mapperDto.surrounded.SurroundedResponseDTO;
import AgroTrackpesagem.demo.model.Surrounded;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface SurroundedSwagger {
    @GetMapping("/all")
    @Operation(
            summary = "Retorna todos os cercados",
            description = "Retorna a lista completa de todos os cercados cadastrados no sistema, exibindo detalhes " +
                    "individuais como capacidade, localização e status de ocupação.",
            tags = "Surrounded",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Surrounded.class))
                    ),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<CollectionModel<EntityModel<SurroundedResponseDTO>>> listAll();

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca um cercado pelo identificador único",
            description = "Retorna os detalhes completos de um cercado específico (localização, capacidade e ocupação) através do seu ID.",
            tags = "Surrounded",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Surrounded.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<EntityModel<SurroundedResponseDTO>> getById(@PathVariable Long id);

    @PostMapping("/register")
    @Operation(
            summary = "Registra um cercado",
            description = "Registre um cercado no sistema, definindo sua finalidade " +
                    "(MATERNITY, FATTENING, REPRODUCTION, QUARANTINE).",
            tags = "Surrounded",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Surrounded.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<EntityModel<SurroundedResponseDTO>> create(@RequestBody SurroundedDTO dto);

    @PutMapping("/{id}/update")
    @Operation(
            summary = "Atualizar o cercado",
            description = "Atualize os campos de cercado pelo identificador único",
            tags = "Surrounded",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Surrounded.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<EntityModel<SurroundedResponseDTO>> update(
            @PathVariable Long id,
            @RequestBody SurroundedDTO dto);

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar cercado pelo identificador único",
            description = "Deletar cercado pelo identificador único, desde que não tenha nenhum animal dentro",
            tags = "Surrounded",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Surrounded.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<Void> delete(@PathVariable Long id);
}
