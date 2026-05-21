package org.serratec.ONG.Repository;

import org.serratec.ONG.Domain.InteresseAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseAdocaoRepository extends JpaRepository<InteresseAdocao, Long> {
}
