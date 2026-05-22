package org.serratec.ONG.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ONG.DTO.InteresseAdocaoRequestDto;
import org.serratec.ONG.DTO.InteresseAdocaoResponseDto;
import org.serratec.ONG.Service.InteresseAdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interesses-adocao")
@Tag(name = "Interesses de Adocao", description = "Gerenciamento de interesses de adocao")
public class InteresseAdocaoController {

    @Autowired
    private InteresseAdocaoService interesseService;

    @GetMapping
    @Operation(summary = "Lista todos os interesses de adocao")
    public ResponseEntity<List<InteresseAdocaoResponseDto>> findAll() {
        return ResponseEntity.ok(interesseService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca interesse por ID")
    public ResponseEntity<InteresseAdocaoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(interesseService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Registra interesse de adocao")
    public ResponseEntity<InteresseAdocaoResponseDto> save(
            @Valid @RequestBody InteresseAdocaoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interesseService.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados do interesse")
    public ResponseEntity<InteresseAdocaoResponseDto> update(@PathVariable Long id,
                                                             @Valid @RequestBody InteresseAdocaoRequestDto dto) {
        return ResponseEntity.ok(interesseService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um interesse de adocao")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interesseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
