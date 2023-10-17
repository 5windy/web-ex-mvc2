package controller;

import controller.user.LoginAction;

public class ActionFactory {
	
	private ActionFactory(){}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("login")) {
			action = new LoginAction();
		}
		else if(command.equals("join")) {}
		else if(command.equals("logout")) {}
		else if(command.equals("leave")) {}
		else if(command.equals("update")) {}
		
		return action;
	}

}
