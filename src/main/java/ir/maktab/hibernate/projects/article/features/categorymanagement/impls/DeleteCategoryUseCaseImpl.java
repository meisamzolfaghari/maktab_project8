package ir.maktab.hibernate.projects.article.features.categorymanagement.impls;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.categorymanagement.usecases.DeleteCategoryUseCase;
import org.hibernate.Session;

import java.util.List;

public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {
    @Override
    public Boolean delete(Category categoryToDelete) {
        if (categoryToDelete == null) {
            System.out.println("\t\u274c Failed to Delete Category! Category Error.\n");
            return false;
        }

        Session session = HibernateUtil.getSession();
        List<Category> categories = session.createQuery("from Category").list();
        if (!categories.contains(categoryToDelete)){
            System.out.println("\t\u274c Failed to Delete Category! This Category doesn't Exist.\n");
            return false;
        }

        session.remove(categoryToDelete);
        Category deletedCategory = session.load(Category.class,categoryToDelete.getId());
        if (deletedCategory == null) {
            System.out.println("\t\u2714 Category successfully Deleted.\n");
            return true;
        }
        else
            System.out.println("\t\u274c Failed to Delete Category!\n");
        return false;
    }
}
