package application.controller;

import org.springfrawork.beans.factory.annotion.Autowired;
import org.springfrawork.stereotype.Controller;
import org.springfrawork.ui.Model;
import org.springfrawork.web.bind.annotion.RequestMapping;
import org.springfrawork.web.bind.annotion.RequestMethod;
import org.springfrawork.web.bind.annotion.RequestParam;

import application.model.Genero;
import application.model.GeneroRepository;

@Controller
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "/genero/list";
    }
    
    @RequestMapping("/insert")
    public String insert() {
        return "/genero/insert";
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
        generoRepo.save(genero);
        return "redirect:/genero/list";
    }
}







