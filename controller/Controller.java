package controller;
import model.Coder;

public class Controller {
	Coder coder = new Coder();
	public String encrypt(String message) {
		return coder.encrypt(message);
	}
}
