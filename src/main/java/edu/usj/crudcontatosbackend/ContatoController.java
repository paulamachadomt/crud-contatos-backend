package edu.usj.crudcontatosbackend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/contato")
public class ContatoController {
    
    @Autowired
    IContatoRepository contatoRepository;

    @PostMapping(value="/")
    public ContatoEntity postCreateContato(@RequestBody ContatoEntity contato) {
        ContatoEntity contatoNovo = contatoRepository.save(contato);
        return contatoNovo;
    }

    @GetMapping(value="")
    public List<ContatoEntity> getReadAll() {
        List<ContatoEntity> lista = contatoRepository.findAll();
        return lista;
    }

    @GetMapping(value="/{id}")
    public ContatoEntity getReadById(@PathVariable Long id) {
        ContatoEntity contato = contatoRepository.findById(id).get();
        return contato;
    }

    @PutMapping(value="/{id}/atualizar")
    public ContatoEntity updateContato(@RequestBody ContatoEntity contato, @PathVariable Long id){
        ContatoEntity contatoOriginal = contatoRepository.findById(id).get();
        contatoOriginal.setNome(contato.getNome());
        contatoOriginal.setTelefone(contato.getTelefone());
        contatoOriginal.setTipo(contato.getTipo());
        contatoOriginal.setEmail(contato.getEmail());
        contatoRepository.save(contatoOriginal);
        return contatoOriginal;
    }

    @GetMapping(value="/pesquisar")
    public List<ContatoEntity> getContatoByNome(@RequestParam String nome) {
        List<ContatoEntity> lista = contatoRepository.findByNomeContainingIgnoreCase(nome);
        return lista;
    }

    @GetMapping(value="/delete/{id}")
    public void getDeleteById(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }

    @DeleteMapping(value="/{id}")
    public void deleteContatoById(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }

}
