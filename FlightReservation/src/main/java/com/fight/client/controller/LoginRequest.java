public class LoginRequest {
	private String email;
private String password;
private ModelMap modelMap;
public LoginRequest(String email, String password, ModelMap modelMap) {
	this.email = email;
	this.password = password;
	this.modelMap = modelMap;
}
public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public ModelMap getModelMap() {
	return modelMap;
}
}
