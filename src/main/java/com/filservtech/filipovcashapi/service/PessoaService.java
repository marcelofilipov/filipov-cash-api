package com.filservtech.filipovcashapi.service;

import com.filservtech.filipovcashapi.model.Pessoa;
import com.filservtech.filipovcashapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pessoaAlterada = buscarPessoaPeloCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pessoaAlterada, "codigo");

        return pessoaRepository.save(pessoaAlterada);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }

    private Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
        if (pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return pessoaSalva;
    }

}
