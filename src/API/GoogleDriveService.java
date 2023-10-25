package API;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.Credential.Builder;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
//import com.google.api.client.googleapis.extensions.java6.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class GoogleDriveService {
    private static final String APPLICATION_NAME = "Your Application Name";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

//    public static Drive initializeDriveService(String clientId, String clientSecret, String refreshToken) throws IOException, GeneralSecurityException {
//        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//
//        // Load client secrets from a JSON file
//        File clientSecretFile = new File("path/to/client_secrets.json");
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(new FileInputStream(clientSecretFile)));
//
//        // Set up the credential
// GoogleCredential credential = new GoogleCredential.Builder()
//                .setTransport(httpTransport)
//                .setJsonFactory(JSON_FACTORY)
//                .setClientSecrets(clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret())
//                .build()
//                .setRefreshToken(refreshToken);
//
//        // Initialize the Google Drive service
//        return new Drive.Builder(httpTransport, JSON_FACTORY, credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
    public static Drive initializeDriveService() throws IOException, GeneralSecurityException {
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    
    
    String clientSecretData = "{\"web\":{\"client_id\":\"966023748146-edce4e3v614356a9ckrditnvneumcrbh.apps.googleusercontent.com\",\"project_id\":\"my-project-dorra\",\"auth_uri\":\"https://accounts.google.com/o/oauth2/auth\",\"token_uri\":\"https://oauth2.googleapis.com/token\",\"auth_provider_x509_cert_url\":\"https://www.googleapis.com/oauth2/v1/certs\",\"client_secret\":\"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\",\"redirect_uris\":[\"https://developers.google.com/oauthplayground/\"]}}";
    
    GoogleClientSecrets.Details details = GoogleClientSecrets.load(JSON_FACTORY, new StringReader(clientSecretData)).getDetails();
    
    
    GoogleCredential credential = new GoogleCredential.Builder()
        .setTransport(httpTransport)
        .setJsonFactory(JSON_FACTORY)
        .setClientSecrets(details.getClientId(), details.getClientSecret())
        .build()
        .setAccessToken("1//04HmFmr_jvK4lCgYIARAAGAQSNwF-L9Ira9p-Tu0q6Q_FteHrTzzPdOe1WwfLuUfbZDUCdS69cR_z9K76bzaXHOT1OoqNA7khfvE");
    
    
    return new Drive.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName(APPLICATION_NAME)
        .build();
}

}

