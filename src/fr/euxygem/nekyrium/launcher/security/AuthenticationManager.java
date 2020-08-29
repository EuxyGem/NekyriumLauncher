package fr.euxygem.nekyrium.launcher.security;

import com.google.gson.Gson;
import fr.euxygem.nekyrium.launcher.security.authentication.error.exception.InvalidCredentialsException;
import fr.euxygem.nekyrium.launcher.security.authentication.error.exception.UserMigratedException;
import fr.euxygem.nekyrium.launcher.security.authentication.error.model.AuthenticationErrorModel;
import fr.euxygem.nekyrium.launcher.security.authentication.request.*;
import fr.euxygem.nekyrium.launcher.security.authentication.response.AuthenticationResponse;
import fr.euxygem.nekyrium.launcher.security.authentication.response.RefreshResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**
 * @author EuxyGem
 **/

public class AuthenticationManager
{
    public AuthenticationResponse authenticate(String email, String password) throws Exception
    {
        HashMap<String, Object> AGENT_MAP = new HashMap<>();
        AGENT_MAP.put("name", "Minecraft");
        AGENT_MAP.put("version", 1);

        return (AuthenticationResponse) this.sendRequest("https://authserver.mojang.com/authenticate", new AuthenticationRequest(AGENT_MAP, email, password), AuthenticationResponse.class);
    }

    public void invalidate(String accessToken, String clientToken) throws Exception
    {
        this.sendRequest("https://authserver.mojang.com/invalidate", new InvalidateRequest(accessToken, clientToken), null);
    }

    public RefreshResponse refresh(String accessToken, String clientToken) throws Exception
    {
        return (RefreshResponse) this.sendRequest("https://authserver.mojang.com/refresh", new RefreshRequest(accessToken, clientToken), RefreshResponse.class);
    }

    public void signout(String email, String password) throws Exception
    {
        this.sendRequest("https://authserver.mojang.com/signout", new SignoutRequest(email, password), null);
    }

    public void validate(String accessToken) throws Exception
    {
        this.sendRequest("https://authserver.mojang.com/validate", new ValidateRequest(accessToken), null);
    }

    private Object sendRequest(String url, Object request, Class<?> wrapTo) throws Exception
    {
        Gson gson = new Gson();

        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.addRequestProperty("Accept-Charset", "UTF-8");
        connection.addRequestProperty("Content-Type", "application/json");
        connection.connect();

        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes(gson.toJson(request));

        int responseCode = connection.getResponseCode();

        if (responseCode == 204)
        {
            return null;
        } else
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseCode == 200 ? connection.getInputStream() : connection.getErrorStream()));

            String response = bufferedReader.readLine();
            while (response != null && response.startsWith("\uFEFF"))
                response = response.substring(1);

            if (responseCode != 200)
            {
                AuthenticationErrorModel model = gson.fromJson(response, AuthenticationErrorModel.class);

                if (model.getCause() != null && model.getCause().equalsIgnoreCase("UserMigratedException"))
                    throw new UserMigratedException(model);
                else
                    throw new InvalidCredentialsException(model);
            }

            bufferedReader.close();
            dataOutputStream.flush();
            dataOutputStream.close();
            connection.disconnect();

            return gson.fromJson(response, wrapTo);
        }
    }
}
