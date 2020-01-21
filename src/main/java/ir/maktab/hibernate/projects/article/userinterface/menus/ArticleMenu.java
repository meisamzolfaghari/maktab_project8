package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.FindAllPublishedArticleUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllPublishedArticleUseCase;
import ir.maktab.hibernate.projects.article.userinterface.functions.Articles;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticleMenu extends Menu {

    public ArticleMenu() {
        setActions();
    }

    @Override
    public void execute() {

        command = "";

        while (!command.equals(Actions.back.name())) {

            FindAllPublishedArticleUseCase findAllPublishedArticleUseCase
                    = new FindAllPublishedArticleUseCaseImpl();

            List<Article> articles = findAllPublishedArticleUseCase.list();

            if (!articles.isEmpty())
                Articles.displayAll(articles);
            else {
                System.out.println("\t\u26A0 Articles List is empty!");
                break;
            }

            displayMenu();
            command = Users.takeCommand(actions);

            if (command.equals(Actions.exit.name())) {
                exit();
            } else if (command.equals(Actions.choose.name())) {
                User loginUser = AuthenticationService.getInstance().getLoginUser();
                Article chosenArticle = Articles.choose(articles);
                if (chosenArticle != null) {
                    if (chosenArticle.getUser().equals(loginUser))
                        new UserChooseArticleMenu(chosenArticle).execute();
                    else {
                        Articles.displayShortVersion(chosenArticle);
                        new FinalMenu().execute();
                    }
                }
            }
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+------------------------------------------------------------+");
        System.out.println("\t|                    Article Menu                            |");
        System.out.println("\t+------------------------------------------------------------+");
        System.out.println("\t|  choose          ---->    See Article.                     |");
        System.out.println("\t|  back            ---->    Back to User Menu.               |");
        System.out.println("\t|  exit            ---->    Exit.                            |");
        System.out.println("\t+------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.choose.name()
                        , Actions.back.name()
                        , Actions.exit.name()));
    }


}
