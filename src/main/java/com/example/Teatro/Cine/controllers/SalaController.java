package com.example.Teatro.Cine.controllers;

import com.example.Teatro.Cine.model.Butaca;
import com.example.Teatro.Cine.service.IButacaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/butaca")
public class SalaController {

    private final IButacaService butacaService;

    public SalaController(IButacaService butacaService) {
        this.butacaService = butacaService;
    }

    @GetMapping
    public void butaca(Model model) {
        ArrayList<Butaca> butacas = new ArrayList<>(butacaService.listarButacas().values());
        model.addAttribute("butacas", butacas);
    }

    @PostMapping
    public String addButaca(@ModelAttribute("butaca") Butaca butaca, Model model) {
        butacaService.altaButaca(butaca);
        return "redirect:/butaca";
    }

    @PostMapping("/{id}/delete")
    public String eliminarButaca(@PathVariable("id") Integer id, Model model) {
        butacaService.borrarButaca(id);
        return "redirect:/butaca";
    }

    @GetMapping("/{idButaca}")
    public String detallesButaca(@PathVariable("idButaca") int id, Model model) {
        Butaca butaca = butacaService.listarButacas().get(id);
        model.addAttribute("butaca", butaca);
        return "butacaDetalles";
    }

    @PostMapping(value = "/{idButaca}")
    public String modificarButaca(@PathVariable("idButaca") int idButaca, @ModelAttribute("butaca") Butaca butaca,
            Model model) {
        butaca.setId(idButaca);
        butacaService.modificarButaca(idButaca, butaca);
        return "redirect:/butaca/{idButaca}";
    }
}
