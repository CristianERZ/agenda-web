package com.analistas.agenda.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.analistas.agenda.model.orm.Categoria;
import com.analistas.agenda.model.orm.Cliente;
import com.analistas.agenda.model.service.ICategoriaService;
import com.analistas.agenda.model.service.IClienteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
@SessionAttributes({"cliente"})
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @Autowired
    ICategoriaService categoriaService;

//------------------------------------------------------------------------------------------//   
    @GetMapping("/listado")
    public String listar(Model model) {

        model.addAttribute("titulo", "Lista De Clientes");
        model.addAttribute("clientes", clienteService.buscarTodo());

        return "clientes/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){

        model.addAttribute("titulo", "Nuevo Cliente");
        model.addAttribute("cliente", new Cliente());

        return "clientes/form";
    }
//--------------------------------------------------------------------------------------------------------------------//    

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){

        Cliente cliente = clienteService.buscarPorId(id);

        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);

        return "clientes/form";
    }
//---------------------------------------------------------------------------------------------------------------------//

    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, BindingResult result, @RequestParam("cat") Long idCat, Model model, SessionStatus status){

        if (result.hasErrors()){
            model.addAttribute("titulo", "ERROR");
            return "clientes/form";
        }
        
        cliente.setCategoria(categoriaService.buscarPorId(idCat));
        clienteService.guardar(cliente);
        status.setComplete();

        return "redirect:/clientes/listado";
    }
//-------------------------------------------------------------------------------------------//
    
    @GetMapping("/borrar/{id}")
    public String deshabilitarOrhabilitarCliente(@PathVariable("id") Long id, Model model){

        Cliente cliente = clienteService.buscarPorId(id);
        cliente.setActivo(!cliente.isActivo());

        clienteService.guardar(cliente);

        return "redirect:/clientes/listado";
    }
//-------------------------------------------------------------------------------------------//
    
    @ModelAttribute("categorias")
    public List<Categoria> getCategorias(){

        return categoriaService.buscarTodo();
    }
}

