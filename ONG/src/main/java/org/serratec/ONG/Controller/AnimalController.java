package org.serratec.ONG.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ONG.DTO.AnimalRequestDto;
import org.serratec.ONG.DTO.AnimalResponseDto;
import org.serratec.ONG.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
@Tag(name = "Animais", description = "Gerenciamento de animais disponíveis para adoção")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    @Operation(summary = "Lista todos os animais")
    public ResponseEntity<List<AnimalResponseDto>> findAll() {
        return ResponseEntity.ok(animalService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca animal por ID")
    public ResponseEntity<AnimalResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo animal")
    public ResponseEntity<AnimalResponseDto> save(@Valid @RequestBody AnimalRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados de um animal")
    public ResponseEntity<AnimalResponseDto> update(@PathVariable Long id, @Valid @RequestBody AnimalRequestDto dto) {
        return ResponseEntity.ok(animalService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um animal")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
