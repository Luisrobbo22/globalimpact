package br.com.fiap.globalimpact.controller;

import br.com.fiap.globalimpact.model.Cliente;
import br.com.fiap.globalimpact.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MessageSource messages;


    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("clientes");
        List<Cliente> clientes = clienteService.findAll();

        modelAndView.addObject("clientes", clientes);
        System.out.println(clientes);
        return modelAndView;
    }

    @RequestMapping("new")
    public String create(Cliente cliente) {
        return "cliente-form";
    }

    @PostMapping
    public String save(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
        clienteService.create(cliente);

        if (result.hasErrors())
            return "cliente-form";

        redirect.addFlashAttribute("message",
                messages.getMessage("message.success.newcliente",
                        null,
                        LocaleContextHolder.getLocale()));

        return "redirect:cliente";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, RedirectAttributes redirect) {
        ModelAndView modelAndView = new ModelAndView("clientes");
        final List<Cliente> clientes = clienteService.remove(id);

        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }
}
