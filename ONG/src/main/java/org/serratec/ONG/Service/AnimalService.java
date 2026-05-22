package org.serratec.ONG.Service;

import org.serratec.ONG.DTO.AnimalRequestDto;
import org.serratec.ONG.DTO.AnimalResponseDto;
import org.serratec.ONG.Domain.Animal;
import org.serratec.ONG.Exception.ResourceNotFoundException;
import org.serratec.ONG.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<AnimalResponseDto> findAll() {
        return animalRepository.findAll().stream()
                .map(AnimalResponseDto::from)
                .collect(Collectors.toList());
    }

    public AnimalResponseDto findById(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", id));
        return AnimalResponseDto.from(animal);
    }

    public AnimalResponseDto salvar(AnimalRequestDto dto) {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setRaca(dto.getRaca());
        animal.setAdotado(false);
        animal.setDataChegada(dto.getDataChegada());
        return AnimalResponseDto.from(animalRepository.save(animal));
    }

    public AnimalResponseDto atualizar(Long id, AnimalRequestDto dto) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", id));
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setRaca(dto.getRaca());
        animal.setDataChegada(dto.getDataChegada());
        return AnimalResponseDto.from(animalRepository.save(animal));
    }

    public void delete(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Animal", id);
        }
        animalRepository.deleteById(id);
    }
}
