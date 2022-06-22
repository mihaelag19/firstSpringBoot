package ro.itschool.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.itschool.entity.Pancake;
import ro.itschool.repository.PancakeRepository;

@Controller
public class GreetingController {
    @Autowired
    private PancakeRepository pancakeRepository;

//----------------POST Pancake---------------

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("NumeCursant", "Cursant 1");
        model.addAttribute("pancakes", pancakeRepository.findAll());
        return "greeting";
    }
//----------------POST Pancake---------------
@GetMapping("/greeting2")
    public String greetingForm(Model model ) {
    model.addAttribute("pancakeObject", new Pancake());

    return "greeting";

    @PostMapping("/greeting2")
            public String greetingSubmit(@ModelAttribute  Pancake pancake ;
    pancake, Model model){
        model.addAttribute(("greeting", greeting));
        pancakeRepository.save(pancake);
        return  "greeting";
    }
}
}