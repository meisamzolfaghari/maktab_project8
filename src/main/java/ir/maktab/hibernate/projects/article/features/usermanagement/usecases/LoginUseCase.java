package ir.maktab.hibernate.projects.article.features.usermanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.User;

public interface LoginUseCase {
    User login(String username, String password);
}
