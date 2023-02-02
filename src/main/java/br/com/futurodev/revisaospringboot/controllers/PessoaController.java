package br.com.futurodev.revisaospringboot.controllers;

import br.com.futurodev.revisaospringboot.models.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private List<Pessoa> pessoas = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> readList() {
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        if (id != null) {
            Pessoa pessoaEncontrada = findById(id);
            if (pessoaEncontrada != null) {
                return ResponseEntity.ok(pessoaEncontrada);
            }
        }
        return ResponseEntity.status(404).body("Pessoa não encontrada!");
    }

    @PostMapping
    public Pessoa create() {
        Pessoa pessoa = new Pessoa(
                "Pessoa " + (pessoas.size() + 1),
                "Documento da pessoa " + (pessoas.size() + 1)
        );
        pessoas.add(pessoa);
        return pessoa;
    }

    @PutMapping
    public Pessoa update(Long id, String nome, String numeroDocumento) {
        Pessoa pessoaEncontrada = findById(id);
        if (pessoaEncontrada != null) {
            pessoaEncontrada.setNome(nome);
            pessoaEncontrada.setNumeroDocumento(numeroDocumento);
        }
        return pessoaEncontrada;
    }

    @DeleteMapping
    public boolean delete(Long id) {
        Pessoa pessoaEncontrada = findById(id);
        if (pessoaEncontrada != null) {
            pessoas.remove(pessoaEncontrada);
            return true;
        }
        return false;
    }

    private Pessoa findById(Long id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
                return pessoa;
            }
        }
        return null;
    }

}
