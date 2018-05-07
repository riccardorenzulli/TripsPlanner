package com.giocompany.web.controller;

import com.giocompany.entities.User;
import javax.ejb.EJB;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.giocompany.managers.RegistrationManagerLocal;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MainController {
    
    @EJB(mappedName = "java:global/vai-ear/vai-ejb-1.0/RegistrationManager")
    private RegistrationManagerLocal RegistrationManager;

    public RegistrationManagerLocal getRegistrationManager() {
        return RegistrationManager;
    }

    public void setRegistrationManager(RegistrationManagerLocal RegistrationManager) {
        this.RegistrationManager = RegistrationManager;
    }
    
	@RequestMapping(value = { "/", "/welcome**", "/homepage" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("homepage");
		return model;

	}

        
        
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
                System.out.println("ho chiamato login in get");
		model.setViewName("login");

		return model;

	}
        
        @RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView SignUPget(@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid signup data!");
		}
                System.out.println("ho chiamato signup in get");
                model.addObject("user", new User());
		model.setViewName("signup");

		return model;

	}
        
        @RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView SignUPpost(@ModelAttribute("user") User user, 
      BindingResult result) {
            
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
                    System.out.println("sono in /signup haserror post ");
                    model.addObject("error", "Invalid signup data!");
		}else{
                    System.out.println("sono in /signup post");
                    System.out.println("user.name:" + user.getName());
                    System.out.println("user.id:" + user.getId());
                    RegistrationManager.createUser(user);
                    RegistrationManager.findAllUsers();
                }

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}

}