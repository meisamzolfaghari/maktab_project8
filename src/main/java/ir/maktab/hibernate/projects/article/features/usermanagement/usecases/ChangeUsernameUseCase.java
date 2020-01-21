package ir.maktab.hibernate.projects.article.features.usermanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.User;

public interface ChangeUsernameUseCase {
    User change(User user , String newUsername);
}
