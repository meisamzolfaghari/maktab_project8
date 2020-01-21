package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.AddArticlesByUserUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.DeleteArticleUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.FindUserArticleUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.AddArticleByUserUseCase;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.DeleteArticleUseCase;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindUserArticleUseCase;
import ir.maktab.hibernate.projects.article.userinterface.functions.Articles;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserArticleMenu extends Menu {

    public UserArticleMenu() {
        setActions();
    }

    @Override
    public void execute() {

        command = "";
        while (!command.equals(Actions.back.name())) {

            FindUserArticleUseCase findUserArticleUseCase
                    = new FindUserArticleUseCaseImpl();
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            List<Article> articles = findUserArticleUseCase.findAll(loginUser);

            if (!articles.isEmpty())
                Articles.displayAll(articles);
            else
                System.out.println("\t\u26A0 You didn't Add any Article yet!");

            displayMenu();
            command = Users.takeCommand(actions);

            if (command.equals(Actions.exit.name())) {
                exit();
            } else if (command.equals(Actions.choose.name())) {
                if (!articles.isEmpty()) {
                    Article chosenArticle = Articles.choose(articles);
                    if (chosenArticle != null)
                        new UserChooseArticleMenu(chosenArticle).execute();
                } else
                    System.out.println("\t\u26A0 Add an Article First!");
            } else if (command.equals(Actions.edit.name())) {
                if (!articles.isEmpty()) {
                    Article chosenArticle = Articles.choose(articles);
                    if (chosenArticle != null)
                        new EditArticleMenu(chosenArticle).execute();
                } else
                    System.out.println("\t\u26A0 Add an Article First!");
            } else if (command.equals(Actions.add.name())) {
                AddArticleByUserUseCase addArticleByUserUseCase
                        = new AddArticlesByUserUseCaseImpl();
                CategoryMenu categoryMenu = new CategoryMenu();
                categoryMenu.execute();
                addArticleByUserUseCase
                        .add(Articles.takeTitle(), Articles.takeBrief(), Articles.takeContent()
                                , Articles.takeCurrentTime(), loginUser, categoryMenu.getChosenCategory());
            } else if (command.equals(Actions.delete.name())) {
                DeleteArticleUseCase deleteArticleUseCase
                        = new DeleteArticleUseCaseImpl();
                Article chosenArticle = Articles.choose(articles);
                if (chosenArticle != null)
                    deleteArticleUseCase.delete(chosenArticle);
            }
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                    User Article Menu                          |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  choose          ---->    See your Article.                   |");
        System.out.println("\t|  edit            ---->    Edit your Article.                  |");
        System.out.println("\t|  add             ---->    Insert a new Article.               |");
        System.out.println("\t|  delete          ---->    Delete an Article.                  |");
        System.out.println("\t|  back            ---->    Back to User Menu.                  |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.choose.name()
                        , Actions.edit.name()
                        , Actions.add.name()
                        , Actions.delete.name()
                        , Actions.back.name()
                        , Actions.exit.name()));
    }
}
