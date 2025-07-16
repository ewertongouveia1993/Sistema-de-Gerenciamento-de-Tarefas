package com.treina.recife.sgp.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.treina.recife.sgp.model.Usuario;
import com.treina.recife.sgp.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    Logger logger = Logger.getLogger(UsuarioController.class.getName());

    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> getUsuarios(
            @PageableDefault(sort = "userId", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Usuario> usuarios = usuarioService.getUsuarios(pageable);

        if (usuarios.isEmpty()) {
            logger.info("Ainda não há usuários cadastrados.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Page.empty());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarios);

        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable(value = "usuarioId") long usuarioId) {

        Optional<Usuario> usuario = usuarioService.getUsuarioById(usuarioId);

        if (usuario.isEmpty()) {
            logger.warning("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            logger.info(usuario.get().toString());
            return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> createUsuario(@org.springframework.web.bind.annotation.RequestBody Usuario usuario) {

        if (usuarioService.isEmailAlreadyTaken(usuario.getEmail())) {
            logger.warning("E-mail já cadastrado");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado");
        }

        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        logger.info("Usuário criado: " + createdUsuario.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }
}
