package proyectoJSF.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SaludoView {
	
	private String input;
	private String output;

	public void submit() {
		output = "Hola estimado " + input;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}
}
