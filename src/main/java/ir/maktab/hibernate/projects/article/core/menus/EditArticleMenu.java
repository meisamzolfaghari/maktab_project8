package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayArticle;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.impl.EditArticleByUserUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.EditArticleByUserUseCase;

import java.util.Date;
import java.util.Scanner;

public class EditArticleMenu implements Menu {
    private Article articleForEdit;

    public EditArticleMenu(Article articleForEdit) {
        this.articleForEdit = articleForEdit;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        String command = "";

        while (!command.equals(Actions.back.name())) {

            DisplayArticle.displayFullVersion(articleForEdit);

            command = TakeCommand.takeEditArticleCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.back.name())) continue;

            EditArticleByUserUseCase editArticleByUserUseCase
                    = new EditArticleByUserUseCaseImpl();

            Date currentDate = new Date(System.currentTimeMillis());

            Article editedArticle;

            if (command.equals(Actions.publish.name())) {
                if (articleForEdit.isPublished()) {
                    articleForEdit.setPublished(true);
                    articleForEdit.setLastUpdateDate(currentDate);
                    articleForEdit.setPublishDate(currentDate);

                    editedArticle = editArticleByUserUseCase.edit(articleForEdit);

                    if (editedArticle.isPublished() && editedArticle.getPublishDate().equals(currentDate))
                        System.out.println("\t\u2714 Article successfully published.\n");
                    else
                        System.out.println("\t\u274c publish failed!\n");
                } else
                    System.out.println("\t\u274c publish failed! you have Already published this Article.\n");
            } else if (command.equals(Actions.unpublish.name())) {
                if (!articleForEdit.isPublished()) {
                    articleForEdit.setPublished(false);
                    articleForEdit.setLastUpdateDate(currentDate);
                    articleForEdit.setPublishDate(null);

                    editedArticle = editArticleByUserUseCase.edit(articleForEdit);

                    if (editedArticle.isPublished() && editedArticle.getPublishDate().equals(currentDate))
                        System.out.println("\t\u2714 Article successfully Unpublished.\n");
                    else
                        System.out.println("\t\u274c Unpublish Failed!\n");
                } else
                    System.out.println("\t\u274c Unpublish failed! you have Already Unpublished this Article.\n");
            } else if (command.equals(Actions.title.name())) {
                System.out.println("\t\u29bf Last Title : " + articleForEdit.getTitle());
                System.out.print("\t\u29bf New Title >>> ");
                articleForEdit.setTitle(in.nextLine());
                articleForEdit.setLastUpdateDate(currentDate);

                editedArticle = editArticleByUserUseCase.edit(articleForEdit);

                if (editedArticle.getTitle().equals(articleForEdit.getTitle())
                        && editedArticle.getLastUpdateDate().equals(currentDate))
                    System.out.println("\t\u2714 Article's Title successfully Edited.\n");
                else
                    System.out.println("\t\u274c Failed to Edit Articles Title!\n");

            } else if (command.equals(Actions.brief.name())) {
                System.out.println("\t\u29bf Last Brief : " + articleForEdit.getBrief());
                System.out.print("\t\u29bf New Brief >>> ");
                articleForEdit.setBrief(in.nextLine());
                articleForEdit.setLastUpdateDate(currentDate);

                editedArticle = editArticleByUserUseCase.edit(articleForEdit);

                if (editedArticle.getBrief().equals(articleForEdit.getBrief())
                        && editedArticle.getLastUpdateDate().equals(currentDate))
                    System.out.println("\t\u2714 Article's Brief successfully Edited.\n");
                else
                    System.out.println("\t\u274c Failed to Edit Articles Brief!\n");
            } else if (command.equals(Actions.content.name())) {
                System.out.println("\t\u29bf Last Content : " + articleForEdit.getContent());
                System.out.print("\t\u29bf New Content >>> ");
                articleForEdit.setContent(in.nextLine());
                articleForEdit.setLastUpdateDate(currentDate);

                editedArticle = editArticleByUserUseCase.edit(articleForEdit);

                if (editedArticle.getContent().equals(articleForEdit.getContent())
                        && editedArticle.getLastUpdateDate().equals(currentDate))
                    System.out.println("\t\u2714 Article's Content successfully Edited.\n");
                else
                    System.out.println("\t\u274c Failed to Edit Articles Content!\n");
            }
        }
    }
}
