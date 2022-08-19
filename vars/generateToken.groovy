@Grab('com.google.auth:google-auth-library-oauth2-http:1.3.0')
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.auth.oauth2.IdToken;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.TokenVerifier;

def call() {
   String clientId = "test";
   String clientEmail = "test";
   String privateKeyPcks8 = "test";
   String privateKeyId = "test";
   sh 'echo ev:${CREDENTIALS_JSON}'
   sh 'echo token generated!'
}
