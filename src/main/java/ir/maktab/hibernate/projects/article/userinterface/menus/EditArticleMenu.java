package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.*;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.*;
import ir.maktab.hibernate.projects.article.userinterface.functions.Articles;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;

public class EditArticleMenu extends Menu {
    private Article chosenArticle;

    public EditArticleMenu(Article articleForEdit) {
        this.chosenArticle = articleForEdit;
        setActions();
    }

    @Override
    public void execute() {
        command = "";

        while (!command.equals(Actions.back.name())) {
            Articles.displayFullVersion(chosenArticle);

            displayMenu();
            command = Users.takeCommand(actions);

            if (command.equals(Actions.exit.name())) {
                exit();
            } else if (command.equals(Actions.publish.name())) {
                PublishArticleUseCase publishArticleUseCase
                        = new PublishArticleUseCaseImpl();
                publishArticleUseCase
                        .publish(chosenArticle, Articles.takeCurrentTime());
            } else if (command.equals(Actions.unpublish.name())) {
                UnPublishArticleUseCase unPublishArticleUseCase
                        = new UnPublishArticleUseCaseImpl();
                unPublishArticleUseCase
                        .unPublish(chosenArticle, Articles.takeCurrentTime());
            } else if (command.equals(Actions.title.name())) {
                ChangeArticleTitleUseCase changeArticleTitleUseCase
                        = new ChangeArticleTitleUseCaseImpl();
                changeArticleTitleUseCase
                        .change(chosenArticle, Articles.takeNewTitle()
                                , Articles.takeCurrentTime());
            } else if (command.equals(Actions.brief.name())) {
                ChangeArticleBriefUseCase changeArticleBriefUseCase
                        = new ChangeArticleBriefUseCaseImpl();
                changeArticleBriefUseCase
                        .change(chosenArticle, Articles.takeNewBrief()
                                , Articles.takeCurrentTime());
            } else if (command.equals(Actions.content.name())) {
                ChangeArticleContentUseCase changeArticleContentUseCase
                        = new ChangeArticleContentUseCaseImpl();
                changeArticleContentUseCase
                        .change(chosenArticle, Articles.takeNewContent()
                                , Articles.takeCurrentTime());
            }
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Edit Article Menu                       |");
        System.out.println("\t+---------------------------------------------------------------+");
        if (!chosenArticle.isPublished())
            System.out.println("\t|  publish         ---->    Publish chosen Article.             |");
        else
            System.out.println("\t|  unpublish       ---->    UnPublish chosen Article.           |");
        System.out.println("\t|  title           ---->    Edit Title.                         |");
        System.out.println("\t|  brief           ---->    Edit Brief.                         |");
        System.out.println("\t|  content         ---->    Edit Content.                       |");
        System.out.println("\t|  back            ---->    Back to Article Menu.               |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.title.name()
                        , Actions.brief.name()
                        , Actions.content.name()
                        , Actions.back.name()
                        , Actions.exit.name()));
        if (!chosenArticle.isPublished())
            actions.add(Actions.publish.name());
        else
            actions.add(Actions.unpublish.name());
    }
}
