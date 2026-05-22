package org.serratec.ONG.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ONG.DTO.CaracteriscaRequestDto;
import org.serratec.ONG.DTO.CaracteriscaResponseDto;
import org.serratec.ONG.Service.CaracteriscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristicas")
@Tag(name = "Características", description = "Gerenciamento de características dos animais")
public class CaracteriscaController {

    @Autowired
    private CaracteriscaService caracteriscaService;

    @GetMapping
    @Operation(summary = "Lista todas as caracteristicas")
    public ResponseEntity<List<CaracteriscaResponseDto>> findAll() {
        return ResponseEntity.ok(caracteriscaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca caracteristica por ID")
    public ResponseEntity<CaracteriscaResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(caracteriscaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra caracteristicas de um animal")
    public ResponseEntity<CaracteriscaResponseDto> save(
            @Valid @RequestBody CaracteriscaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteriscaService.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza caracteristicas de um animal")
    public ResponseEntity<CaracteriscaResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody CaracteriscaRequestDto dto) {
        return ResponseEntity.ok(caracteriscaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove caracteristicas de um animal")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        caracteriscaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
