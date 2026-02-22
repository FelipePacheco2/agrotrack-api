package AgroTrackpesagem.demo.swaggerDoc;

import AgroTrackpesagem.demo.mapperDto.weighing.WeighingDTO;
import AgroTrackpesagem.demo.mapperDto.weighing.WeighingResponseDTO;
import AgroTrackpesagem.demo.model.Weighing;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface WeighingSwagger {
    @GetMapping("/search")
    @Operation(
            summary = "Consultar registros biométrico via identificador único (Tag)",
            description = "Retorna regitro de pessagens de um animal " +
                    "específico utilizando o código da tag/brinco como critério de busca.",
            tags = "Weighing",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Weighing.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<CollectionModel<EntityModel<WeighingResponseDTO>>> listAll(@RequestParam("tag") String tag);

    @PostMapping("/register")
    @Operation(
            summary = "Registra a pessagem via identificador único (Tag)",
            description = "Registra a pessagens de um animal " +
                    "específico utilizando o código da tag/brinco como critério de busca.",
            tags = "Weighing",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Weighing.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<EntityModel<WeighingResponseDTO>> create(@RequestBody WeighingDTO dto);
}
