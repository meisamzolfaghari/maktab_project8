package ir.maktab.hibernate.projects.article.userinterface.menus;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected String command;
    protected List<String> actions;

    public Menu() {
    }

    public abstract void execute();
    protected abstract void displayMenu();

    protected void exit() {
        System.out.println("\n bye bye!");
        System.exit(0);
    }

    protected abstract void setActions();
}
