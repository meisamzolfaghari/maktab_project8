package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayArticle;
import ir.maktab.hibernate.projects.article.core.display.DisplayCategory;
import ir.maktab.hibernate.projects.article.core.functions.ChooseArticle;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeArticleToAdd;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.AddArticlesByUserUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.FindUserArticlesByUserUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.AddArticleByUserUseCase;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindUserArticlesByUserUseCase;

import java.util.List;

public class UserArticleMenu implements Menu {
    @Override
    public void execute() {

        String command = "";
        while (!command.equals(Actions.back.name())) {

            FindUserArticlesByUserUseCase findUserArticlesByUserUseCase
                    = new FindUserArticlesByUserUseCaseImpl();

            List<Article> articles = findUserArticlesByUserUseCase.list();

            if (!articles.isEmpty())
                DisplayArticle.displayShortVersion(articles);
            else
                System.out.println("\t\u26A0 You didn't Add any Article yet!");

            command = TakeCommand.takeUserArticleCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.see.name())) {
                if (!articles.isEmpty()) {
                    Article chosenArticle = ChooseArticle.choose(articles);

                    DisplayArticle.displayFullVersion(chosenArticle);

                    while (!command.equals(Actions.back.name())) {
                        command = TakeCommand.takeFinalCommand();

                        if (command.equals(Actions.exit.name())) {
                            System.out.println("\n bye bye!");
                            System.exit(0);
                        }
                    }
                    command = Actions.see.name();
                }
                else
                    System.out.println("\t\u26A0 Add an Article First!");

            }

            else if (command.equals(Actions.edit.name())) {
                if (!articles.isEmpty()) {

                    Article chosenArticle = ChooseArticle.choose(articles);

                    Menu editArticleMenu = new EditArticleMenu(chosenArticle);
                    editArticleMenu.execute();
                }
                else
                    System.out.println("\t\u26A0 Add an Article First!");
            }

            else if (command.equals(Actions.add.name())) {
                AddArticleByUserUseCase addArticleByUserUseCase
                        = new AddArticlesByUserUseCaseImpl();

                Article articleToAdd = TakeArticleToAdd.take();

                Article addedArticle = addArticleByUserUseCase.add(articleToAdd);

                if (addedArticle != null)
                    System.out.println("\t\u2714 Article successfully Added.\n");
                else
                    System.out.println("\t\u274c failed to Add Article!\n");

            }
        }
    }
}
