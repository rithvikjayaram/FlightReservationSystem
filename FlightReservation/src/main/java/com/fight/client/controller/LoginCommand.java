public class LoginCommand implements Command {
	@Autowired
private UserService userService;
@Override
public ModelAndView execute(Object request) {
	LoginRequest loginRequest = (LoginRequest) request;
	String email = loginRequest.getEmail();
	String password = loginRequest.getPassword();
	ModelMap modelMap = loginRequest.getModelMap();
	
	User user = userService.findByEmail(email);
	if (user != null && user.getPassword().equals(password)) {
		return new ModelAndView("redirect:/flight/find");
	} else {
		modelMap.addAttribute("msg", "Invalid username or password");
		return new ModelAndView("login/login");
	}
}
}
