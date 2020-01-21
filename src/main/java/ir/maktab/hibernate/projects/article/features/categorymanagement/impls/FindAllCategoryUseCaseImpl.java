package ir.maktab.hibernate.projects.article.features.categorymanagement.impls;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.categorymanagement.usecases.FindAllCategoryUseCase;

import java.util.List;

public class FindAllCategoryUseCaseImpl implements FindAllCategoryUseCase {
    @Override
    public List<Category> list() {
        return (List<Category>) HibernateUtil.getSession()
                .createQuery("from Category ").list();
    }
}
