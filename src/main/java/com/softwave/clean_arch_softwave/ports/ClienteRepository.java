package com.softwave.clean_arch_softwave.ports;

import com.softwave.clean_arch_softwave.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
