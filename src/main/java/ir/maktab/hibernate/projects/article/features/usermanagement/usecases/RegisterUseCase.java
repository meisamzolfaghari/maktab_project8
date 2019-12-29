package ir.maktab.hibernate.projects.article.features.usermanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.User;

import java.util.Date;

public interface RegisterUseCase {
    User register(User user);
}
