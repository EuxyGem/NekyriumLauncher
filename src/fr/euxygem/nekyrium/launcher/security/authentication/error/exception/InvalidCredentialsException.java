package fr.euxygem.nekyrium.launcher.security.authentication.error.exception;

import fr.euxygem.nekyrium.launcher.security.authentication.error.model.AuthenticationErrorModel;

/**
 * @author EuxyGem
 **/

public class InvalidCredentialsException extends Exception
{
    private final AuthenticationErrorModel model;

    public InvalidCredentialsException(AuthenticationErrorModel model)
    {
        super(model.getErrorMessage());
        this.model = model;
    }

    public AuthenticationErrorModel getErrorModel()
    {
        return model;
    }
}
