public class RegisterCommand implements Command {
	@Autowired
private UserService userService;

@Override
public ModelAndView execute(Object request) {
	User user = (User) request;
	userService.addUser(user);
	return new ModelAndView("redirect:/login");
}
}
