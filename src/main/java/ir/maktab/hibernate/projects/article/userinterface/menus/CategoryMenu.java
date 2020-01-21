package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.categorymanagement.impls.AddCategoryUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.categorymanagement.impls.FindAllCategoryUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.categorymanagement.usecases.AddCategoryUseCase;
import ir.maktab.hibernate.projects.article.features.categorymanagement.usecases.FindAllCategoryUseCase;
import ir.maktab.hibernate.projects.article.userinterface.functions.Categories;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryMenu extends Menu {

    private Category chosenCategory;

    public CategoryMenu() {
        setActions();
    }

    @Override
    public void execute() {

        command = "";

        while (!command.equals("choose")) {
            FindAllCategoryUseCase findAllCategoryUseCase
                    = new FindAllCategoryUseCaseImpl();
            List<Category> categories = findAllCategoryUseCase.list();

            if (!categories.isEmpty())
                Categories.displayAll(categories);
            else
                System.out.println("\t\u26A0 Category List is empty!");

            displayMenu();
            Users.takeCommand(actions);

            if (command.equals(Actions.choose.name())) {
                if (!categories.isEmpty()) {
                    Category chosenCategory = Categories.choose(categories);
                    if (chosenCategory != null)
                        setChosenCategory(chosenCategory);
                } else
                    System.out.println("\t\u26A0 Add a Category First.");
            } else if (command.equals(Actions.add.name())) {
                AddCategoryUseCase addCategoryUseCase
                        = new AddCategoryUseCaseImpl();
                addCategoryUseCase
                        .add(Categories.takeTitle(), Categories.takeDescription());
            }
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Category Menu                           |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  choose          ---->    choose a category.                  |");
        System.out.println("\t|  add             ---->    add a category.                     |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.choose.name()
                        , Actions.add.name()));
    }

    private void setChosenCategory(Category chosenCategory) {
        this.chosenCategory = chosenCategory;
    }

    public Category getChosenCategory() {
        return chosenCategory;
    }
}
