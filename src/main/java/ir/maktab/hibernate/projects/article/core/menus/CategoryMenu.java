package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayCategory;
import ir.maktab.hibernate.projects.article.core.functions.ChooseCategory;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCategoryToAdd;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.AddCategoryByUserUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.FindAllCategoriesUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.AddCategoryByUserUseCase;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllCategoriesUseCase;

import java.util.List;

public class CategoryMenu implements Menu {

    private Category chosenCategory;

    @Override
    public void execute() {

        String command = "";

        while (!command.equals("choose")) {
            FindAllCategoriesUseCase findAllCategoriesUseCase
                    = new FindAllCategoriesUseCaseImpl();

            List<Category> categories = findAllCategoriesUseCase.list();

            if (!categories.isEmpty())
                DisplayCategory.display(categories);
            else
                System.out.println("\t\u26A0 Category List is empty!");

            command = TakeCommand.takeCategoryCommand();

            if (command.equals(Actions.choose.name())) {
                if (!categories.isEmpty())
                    setChosenCategory(ChooseCategory.choose(categories));
                else
                    System.out.println("\t\u26A0 Add a Category First.");

            }

            else if (command.equals(Actions.add.name())) {
                AddCategoryByUserUseCase addCategoryByUserUseCase
                        = new AddCategoryByUserUseCaseImpl();

                Category categoryToAdd = TakeCategoryToAdd.take();

                Category addedCategory = addCategoryByUserUseCase.add(categoryToAdd);

                if (categoryToAdd.getTitle().equals(addedCategory.getTitle()))
                    System.out.println("\t\u2714 Category successfully Added.\n");
                else
                    System.out.println("\t\u274c Failed to Add Category!\n");
            }
        }
    }

    private void setChosenCategory(Category chosenCategory) {
        this.chosenCategory = chosenCategory;
    }

    public Category getChosenCategory() {
        return chosenCategory;
    }
}
