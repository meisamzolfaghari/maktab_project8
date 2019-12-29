package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayArticle;
import ir.maktab.hibernate.projects.article.core.functions.ChooseArticle;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.FindAllArticlesUseCaseImp;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllArticlesUseCase;

import java.util.List;

public class ArticleMenu implements Menu {
    @Override
    public void execute() {

        String command = "";

        while (!command.equals(Actions.back.name())) {

            FindAllArticlesUseCase findAllArticlesUseCase
                    = new FindAllArticlesUseCaseImp();

            List<Article> articles = findAllArticlesUseCase.list();
            if (!articles.isEmpty())
                DisplayArticle.displayShortVersion(articles);
            else {
                System.out.println("\t\u26A0 Articles List is empty!");
                break;
            }

            command = TakeCommand.takeArticleCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.see.name())) {

                DisplayArticle.displayFullVersion(ChooseArticle.choose(articles));

                while (!command.equals(Actions.back.name())) {

                    command = TakeCommand.takeFinalCommand();

                    if (command.equals(Actions.exit.name())) {
                        System.out.println("\n bye bye!");
                        System.exit(0);
                    }

                }
            }

        }
    }
}
