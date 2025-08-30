package com.softwave.clean_arch_softwave.controller;

import com.softwave.clean_arch_softwave.adapters.ClienteRequestDTO;
import com.softwave.clean_arch_softwave.useCase.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteRequestDTO> cadastrar(@Valid @RequestBody ClienteRequestDTO dto){
        ClienteRequestDTO clienteCadastrado = ClienteRequestDTO.toDTO(
                clienteService.cadastrar(
                        ClienteRequestDTO.toEntity(dto)
                )
        );

        return ResponseEntity.status(201).body(clienteCadastrado);
    }
}