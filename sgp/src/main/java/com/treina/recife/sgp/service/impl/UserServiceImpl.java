package com.treina.recife.sgp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.treina.recife.sgp.repository.UsuarioRepository;
import com.treina.recife.sgp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   UsuarioRepository usuarioRepository;



    @Override
    public Page getUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);

    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        eturn usuarioRepository.save(usuario);


    @Override
    public void deleteUsuario(long userId) {
        usuarioRepository.deleteById(userId);

    }

    @Override
    public boolean isEmailAlreadyTaken(String email) {
        usuarioRepository.existByEmail(email);



}
