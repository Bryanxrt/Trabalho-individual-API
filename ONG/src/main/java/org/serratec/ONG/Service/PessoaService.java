package org.serratec.ONG.Service;

import org.serratec.ONG.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private final PessoaRepository pessoaRepository;
    
    @Autowired
    private PessoaService pessoaService;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
}
