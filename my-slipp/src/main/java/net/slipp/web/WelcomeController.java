package net.slipp.web;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/helloworld")
	public String welcome(Model model) {
		//System.out.println("name :"+name);
		//System.out.println("age : "+age);
		List<MyModel> repo = Arrays.asList(new MyModel("javajigi"), new MyModel("heegoori"));
		model.addAttribute("repo", repo);	
		return "welcome";
		
	}
	
}
