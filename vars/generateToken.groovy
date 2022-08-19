@Grab('com.google.auth:google-auth-library-oauth2-http:1.3.0')
@Grab('com.fasterxml.jackson.core:jackson-core:2.9.4')
@Grab('com.fasterxml.jackson.core:jackson-core:2.9.4')
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.auth.oauth2.IdToken;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.TokenVerifier;

def call() {
   ObjectMapper mapper = new ObjectMapper();
   String jsonClass = CREDENTIALS_JSON.getClass();
   sh 'echo ${jsonClass}'}
   @SuppressWarnings("unchecked")
   Map<String, Object> json = mapper.readValue(CREDENTIALS_JSON, HashMap.class);
   String clientId = "test";
   String clientEmail = "test";
   String privateKeyPcks8 = "test";
   String privateKeyId = "test";
   sh 'echo data:${json}'
   sh 'echo token generated!'
}
