package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllCategoriesUseCase;
import org.hibernate.Session;

import java.util.List;

public class FindAllCategoriesUseCaseImpl implements FindAllCategoriesUseCase {
    @Override
    public List<Category> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Category> categories = session.createQuery("from Category").list();

        session.close();
        return categories;
    }
}
