package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayArticle;
import ir.maktab.hibernate.projects.article.core.functions.ChooseArticle;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.FindAllArticlesUseCaseImp;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllArticlesUseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticleMenu extends Menu {
    @Override
    public void execute() {

        command = "";

        while (!command.equals(Actions.back.name())) {

            FindAllArticlesUseCase findAllArticlesUseCase
                    = new FindAllArticlesUseCaseImp();

            List<Article> articles = new ArrayList<>();

            findAllArticlesUseCase.list().stream()
                    .filter(Article::isPublished)
                    .forEach(articles::add);

            if (!articles.isEmpty())
                DisplayArticle.displayShortVersion(articles);
            else {
                System.out.println("\t\u26A0 Articles List is empty!");
                break;
            }

            takeCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.see.name())) {

                DisplayArticle.displayFullVersion(ChooseArticle.choose(articles));

                new FinalMenu().execute();
            }

        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                    Article Menu                               |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  see             ---->    See your Article.                   |");
        System.out.println("\t|  back            ---->    Back to User Menu.                  |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.see.name()
                        , Actions.back.name()
                        , Actions.exit.name()));
    }


}
