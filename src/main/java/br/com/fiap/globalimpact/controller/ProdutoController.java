package br.com.fiap.globalimpact.controller;

import br.com.fiap.globalimpact.model.Produto;
import br.com.fiap.globalimpact.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MessageSource messages;

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("produtos");
        List<Produto> produtos = produtoService.findAll();

        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @RequestMapping("new")
    public String create(Produto produto) {
        return "produto-form";
    }

    @PostMapping
    public String save(@Valid Produto produto, BindingResult result, RedirectAttributes redirect) {
        produtoService.create(produto);

        if (result.hasErrors())
            return "produto-form";

        redirect.addFlashAttribute("message",
                messages.getMessage("message.success.newproduto",
                        null,
                        LocaleContextHolder.getLocale()));

        return "redirect:produto";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, RedirectAttributes redirect) {
        ModelAndView modelAndView = new ModelAndView("produtos");
        List<Produto> produtos = produtoService.remove(id);

        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }
}
