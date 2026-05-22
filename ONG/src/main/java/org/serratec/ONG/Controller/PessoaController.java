package org.serratec.ONG.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.ONG.DTO.PessoaRequestDto;
import org.serratec.ONG.DTO.PessoaResponseDto;
import org.serratec.ONG.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@Tag(name = "Pessoas", description = "Gerenciamento de pessoas interessadas em adoção")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @Operation(summary = "Lista todas as pessoas")
    public ResponseEntity<List<PessoaResponseDto>> findAll() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca pessoa por ID")
    public ResponseEntity<PessoaResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra uma nova pessoa")
    public ResponseEntity<PessoaResponseDto> save(@Valid @RequestBody PessoaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados de uma pessoa")
    public ResponseEntity<PessoaResponseDto> update(@PathVariable Long id, @Valid @RequestBody PessoaRequestDto dto) {
        return ResponseEntity.ok(pessoaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma pessoa")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idPessoa}/apadrinhar/{idAnimal}")
    @Operation(summary = "Pessoa apadrinha um animal", description = "Cria vínculo de apadrinhamento entre a pessoa e o animal")
    public ResponseEntity<PessoaResponseDto> apadrinhar(@PathVariable Long idPessoa, @PathVariable Long idAnimal) {
        return ResponseEntity.ok(pessoaService.apadrinharAnimal(idPessoa, idAnimal));
    }
}
