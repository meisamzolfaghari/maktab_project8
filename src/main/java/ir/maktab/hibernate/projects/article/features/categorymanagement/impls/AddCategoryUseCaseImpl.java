package ir.maktab.hibernate.projects.article.features.categorymanagement.impls;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.categorymanagement.usecases.AddCategoryUseCase;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AddCategoryUseCaseImpl implements AddCategoryUseCase {
    @Override
    public Category add(String title, String description) {
        if (title == null || title.isEmpty()) {
            System.out.println("\t\u274c Failed to Add Category! Title Error.\n");
            return null;
        }
        if (description == null || description.isEmpty()) {
            System.out.println("\t\u274c Failed to Add Category! Description Error.\n");
            return null;
        }

        Session session = HibernateUtil.getSession();

        List<Category> categories = session.createQuery("from Category").list();

        if (categories.stream().anyMatch(category -> category.getTitle().equals(title))) {
            System.out.println("\t\u274c Failed to Add Category! This Category Already Exist.\n");
            return null;
        }
            Category categoryToAdd = new Category(null , title, description , new ArrayList<>());

        categoryToAdd.setId((Integer) session.save(categoryToAdd));
        Category addedCategory = session.load(Category.class,categoryToAdd.getId());

        if (addedCategory != null)
            System.out.println("\t\u2714 Category successfully Added.\n");
        else
            System.out.println("\t\u274c Failed to Add Category!\n");
        return addedCategory;
    }
}
