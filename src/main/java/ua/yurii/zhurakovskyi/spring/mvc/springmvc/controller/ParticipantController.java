package ua.yurii.zhurakovskyi.spring.mvc.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.yurii.zhurakovskyi.spring.mvc.springmvc.domain.Participant;
import ua.yurii.zhurakovskyi.spring.mvc.springmvc.service.ParticipantService;

@Controller
public class ParticipantController {
	@Autowired
	private ParticipantService service;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("participants", service.findAll());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "PARTICIPANT_CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
		service.save(participant);
		req.setAttribute("participants", service.findAll());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest req) {
		req.setAttribute("participant", service.findOne(id));
		req.setAttribute("mode", "PARTICIPANT_EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam int id, HttpServletRequest req) {
		service.delete(id);
		req.setAttribute("participants", service.findAll());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}
}
