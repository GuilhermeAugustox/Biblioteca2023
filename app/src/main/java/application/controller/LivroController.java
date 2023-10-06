package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Livro; // Importe a classe Livro
import application.model.AutorRepository;
import application.model.LivroRepository;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private LivroRepository livroRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", livroRepo.findAll()); // Corrigido para livroRepo
        return "/livro/list";
    }
    
    @RequestMapping("/insert")
    public String insert() {
        return "/livro/insert";
    }

    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo) { // Corrigido para "titulo"
        Livro livro = new Livro(); // Corrigido para "Livro"
        livro.setTitulo(titulo); // Corrigido para "setTitulo"
        livroRepo.save(livro); // Corrigido para livroRepo
        return "redirect:/livro/list";
    }

    @RequestMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Livro> livro = livroRepo.findById(id); // Corrigido para livroRepo

        if(livro.isPresent()) {
            model.addAttribute("livro", livro.get());
            return "/livro/update";
        }

        return "redirect:/livro/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") int id,
        @RequestParam("titulo") String titulo // Corrigido para "titulo"
    ) {
        Optional<Livro> livro = livroRepo.findById(id); // Corrigido para livroRepo

        if(livro.isPresent()) {
            livro.get().setTitulo(titulo); // Corrigido para "setTitulo"
            livroRepo.save(livro.get());
        }

        return "redirect:/livro/list";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Livro> livro = livroRepo.findById(id); // Corrigido para livroRepo

        if(livro.isPresent()) {
            model.addAttribute("livro", livro.get());
            return "/livro/delete";
        }

        return "redirect:/livro/list";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id) {
        livroRepo.deleteById(id); // Corrigido para livroRepo
        return "redirect:/livro/list";
    }
}
