@Grab('com.google.auth:google-auth-library-oauth2-http:1.3.0')
@Grab('com.fasterxml.jackson.core:jackson-core:2.9.4')
@Grab('com.fasterxml.jackson.core:jackson-core:2.9.4')
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.auth.oauth2.IdToken;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.TokenVerifier;

def call() {
   String AUDIENCE = "https://resi.io";
   File file = new File(CREDENTIALS_JSON);
   ObjectMapper mapper = new ObjectMapper();
   @SuppressWarnings("unchecked")
   Map<String, Object> json = mapper.readValue(file, HashMap.class);
   String clientId = (String) json.get("client_id");
   String clientEmail = (String) json.get("client_email");
   String privateKeyPcks8 = (String) json.get("private_key");
   String privateKeyId = (String) json.get("private_key_id");
   ServiceAccountCredentials serviceAccountCredentials = ServiceAccountCredentials.fromPkcs8(clientId, clientEmail, privateKeyPcks8, privateKeyId,
				Collections.emptyList());
   IdToken idToken = serviceAccountCredentials.idTokenWithAudience(AUDIENCE, null);
   String token = idToken.getTokenValue();
   String test = "my test value";
   sh "${token}";
}
