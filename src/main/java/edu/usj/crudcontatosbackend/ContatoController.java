package edu.usj.crudcontatosbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/contato")
public class ContatoController {
    
    @Autowired
    IContatoRepository contatoRepository;

    @GetMapping(value="/")
    public List<ContatoEntity> getReadAll() {
        List<ContatoEntity> lista = contatoRepository.findAll();
        return lista;
    }

    @GetMapping(value="/{id}")
    public ContatoEntity getReadById(@PathVariable Long id) {
        ContatoEntity contato = contatoRepository.findById(id).get();
        return contato;
    }

    @PostMapping(value="/")
    public ContatoEntity postCreateContato(@RequestBody ContatoEntity contato) {
        ContatoEntity contatoNovo = contatoRepository.save(contato);
        return contatoNovo;
    }

    @GetMapping(value="/delete/{id}")
    public void getDeleteById(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }
    
    @DeleteMapping(value="/{id}")
    public void deleteContatoById(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }

    @GetMapping(value="/pesquisar")
    public List<ContatoEntity> getContatoByNome(@RequestParam String nome) {
        List<ContatoEntity> lista = contatoRepository.findByNomeContainingIgnoreCase(nome);
        return lista;
    }
    


}
