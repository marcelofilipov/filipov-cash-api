package com.filservtech.filipovcashapi.service;

import com.filservtech.filipovcashapi.model.Lancamento;
import com.filservtech.filipovcashapi.model.Pessoa;
import com.filservtech.filipovcashapi.repository.LancamentoRepository;
import com.filservtech.filipovcashapi.repository.PessoaRepository;
import com.filservtech.filipovcashapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(@Valid Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }

}