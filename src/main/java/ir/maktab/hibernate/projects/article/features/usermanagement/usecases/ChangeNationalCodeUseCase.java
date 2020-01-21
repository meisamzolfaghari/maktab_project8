package ir.maktab.hibernate.projects.article.features.usermanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.User;

public interface ChangeNationalCodeUseCase {
    User change(User user , String newNationalCode);
}
