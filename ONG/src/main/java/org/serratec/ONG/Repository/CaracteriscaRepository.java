package org.serratec.ONG.Repository;

import org.serratec.ONG.Domain.Caracterisca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteriscaRepository extends JpaRepository<Caracterisca, Long> {
}
