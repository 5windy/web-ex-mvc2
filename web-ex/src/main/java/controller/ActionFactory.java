package controller;

import controller.user.EditUserAction;
import controller.user.JoinAction;
import controller.user.LoginAction;
import controller.user.LogoutAction;

public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("leave")) {
		} else if (command.equals("update-user")) {
			action = new EditUserAction();
		}

		return action;
	}

}
