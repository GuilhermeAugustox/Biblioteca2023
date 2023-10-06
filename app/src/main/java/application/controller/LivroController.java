package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Autor;
import application.model.Livro;
import application.model.Genero;
import application.model.AutorRepository;
import application.model.GeneroRepository;
import application.model.LivroRepository;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private LivroRepository livroRepo;

    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", autorRepo.findAll());
        return "/livro/list"; // Removi a barra inicial aqui
    }
    
    @RequestMapping("/insert")
    public String insert() {
        return "/livro/insert"; // Removi a barra inicial aqui
    }

    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Livro licro = new livro();
        autor.setNome(nome);
        autorRepo.save(autor);
        return "redirect:/livro/list"; // Mantive a barra inicial aqui
    }

    @RequestMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Livro> livro = autorRepo.findById(id);

        if(autor.isPresent()) {
            model.addAttribute("livro", autor.get());
            return "/livro/update"; // Removi a barra inicial aqui
        }

        return "redirect:/livro/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") int id,
        @RequestParam("nome") String nome
    ) {
        Optional<Autor> autor = livroRepo.findById(id);

        if(livro.isPresent()) {
            livro.get().setNome(nome);
            livroRepo.save(livro.get());
        }

        return "redirect:/livro/list"; // Mantive a barra inicial aqui
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Livro> livro = livroRepo.findById(id);

        if(livro.isPresent()) {
            model.addAttribute("livro", livro.get());
            return "/livro/delete"; // Removi a barra inicial aqui
        }

        return "redirect:/livro/list";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id) {
        livroRepo.deleteById(id);
        return "redirect:/livro/list"; // Mantive a barra inicial aqui
    }
}
