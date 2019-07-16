package net.slipp.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	//private List<User> users= new ArrayList<User>();  db를 쓰니까 리스트는 이제 필요없음.
	
	@Autowired //DB 끌고오는애
	private UserRepository userRepository;

	@PostMapping("")
	public String create(User user) {
		System.out.println("user :" + user);
		userRepository.save(user); // jpaRepository에 기본적으로 save기능이 구현되어 있으므로 가져다 쓰기만 하면 됨
		return "redirect:/users"; // redirect가 아닌 그냥 list로 하면 변경사항이 적용되지 않은 list.html로 이동됨.
	}
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("users",userRepository.findAll());	// 이제 리스트에서 데이터를 가져오는게 아니고 DB에서 데이터를 가져옴.	
		return "/user/list";
	}
}
