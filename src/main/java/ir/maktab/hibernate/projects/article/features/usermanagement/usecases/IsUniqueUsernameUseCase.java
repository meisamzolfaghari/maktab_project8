package ir.maktab.hibernate.projects.article.features.usermanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.User;

public interface IsUniqueUsernameUseCase {
    Boolean test(String username);
}
