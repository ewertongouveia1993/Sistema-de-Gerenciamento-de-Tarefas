package com.treina.recife.sgp.controller;

@RestController
@RequerstMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    Logger logger = LogManager.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService){

        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> getUsuarios(@PageableDefault(sort = "userId", 
    direction = Sort.Direction.ASC) Pageable pageable){

        Page<Usuario> usuarios = usuarioService.getUsuarios(pageable);

        if(usuarios.isEmpty()){
            logger.info("Ainda não há usuários cadastrados.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Page.empty());
        } esle {
            return ResponseEntity.status(HttpStatus.OK)body.(usuarios);

        }
    }


    @GetMapping("{/usuarioId}")
    public ResponseEntity<Object> getUsuarioById(PathVariable(value = "usuarioId") long usuarioId {

        Optional<Usuario> usuario = usuarioService.getUsuarioById(usuarioId);

        if(usuario.isEmpty()) {
        logger.warn("Usuário não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }else {
            logger.info(usuario.get()).toString());
            return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
        }
    }

    @PostMapping()
    Public ResponseEntity<Object> createUsuario