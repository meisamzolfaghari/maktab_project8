package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LogoutUseCase;

public class LogoutUseCaseImpl implements LogoutUseCase {

    @Override
    public void logout() {
        AuthenticationService.getInstance().setLoginUser(null);
    }
}
