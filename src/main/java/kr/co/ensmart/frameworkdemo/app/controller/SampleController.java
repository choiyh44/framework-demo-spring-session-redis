package kr.co.ensmart.frameworkdemo.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class SampleController {

	@GetMapping("")
	public String index(HttpSession session) {
		session.setAttribute("name", "testname");
		return session.getId() + "Hello " + session.getAttribute("name");
	}
}
