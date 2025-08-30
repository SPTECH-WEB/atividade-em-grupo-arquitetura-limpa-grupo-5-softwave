package com.softwave.clean_arch_softwave.useCase;

import com.softwave.clean_arch_softwave.entities.Cliente;
import com.softwave.clean_arch_softwave.ports.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
        Cliente clienteCadastrado = clienteRepository.save(cliente);
        clienteCadastrado.setRisco(clienteCadastrado.getIdade(), clienteCadastrado.getRendaMensal());
        clienteCadastrado = clienteRepository.save(clienteCadastrado);
        return clienteCadastrado;
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente com ID " + id + " não encontrado."
                ));
    }
}
