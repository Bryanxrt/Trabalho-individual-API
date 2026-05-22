package org.serratec.ONG.Service;

import org.serratec.ONG.DTO.AnimalResponseDto;
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
    
}
