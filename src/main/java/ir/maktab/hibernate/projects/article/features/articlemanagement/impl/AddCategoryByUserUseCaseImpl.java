package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.AddCategoryByUserUseCase;
import org.hibernate.Session;

public class AddCategoryByUserUseCaseImpl implements AddCategoryByUserUseCase {
    @Override
    public Category add(Category category) {
        if (AuthenticationService.getInstance().getLoginUser() == null) return null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Integer id = (Integer) session.save(category);
        category = session.load(Category.class , id);

        session.close();

        return category;
    }
}
