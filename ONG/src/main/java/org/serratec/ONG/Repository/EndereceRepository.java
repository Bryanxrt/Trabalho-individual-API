package org.serratec.ONG.Repository;

import org.serratec.ONG.Domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndereceRepository  extends JpaRepository<Endereco,Long> {
}
