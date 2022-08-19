@Grab('com.google.auth:google-auth-library-oauth2-http:1.3.0')
@Grab('com.fasterxml.jackson.core:jackson-core:2.9.4')
@Grab('com.fasterxml.jackson.core:jackson-core:2.9.4')
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.auth.oauth2.IdToken;
import com.google.auth.oauth2.ServiceAccountCredentials;

def call() {
    String AUDIENCE = "https://resi.io";
    Map<String, Object> jsonMap = getJsonMap();
    ServiceAccountCredentials serviceAccountCredentials = getServiceAccountCredentials(jsonMap);
    String token = serviceAccountCredentials.idTokenWithAudience(AUDIENCE, null).getTokenValue();
    createArtifact(token);
}

def getJsonMap() {
    File file = new File(CREDENTIALS_JSON);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(file, HashMap.class);
}

def getServiceAccountCredentials(jsonMap) {
    String clientId = (String) jsonMap.get("client_id");
    String clientEmail = (String) jsonMap.get("client_email");
    String privateKeyPcks8 = (String) jsonMap.get("private_key");
    String privateKeyId = (String) jsonMap.get("private_key_id");
    return ServiceAccountCredentials.fromPkcs8(clientId, clientEmail, privateKeyPcks8, privateKeyId,
            Collections.emptyList());
}

def createArtifact(token) {
    writeFile file: "token.txt", text: token
    archiveArtifacts artifacts: outputFile
}
