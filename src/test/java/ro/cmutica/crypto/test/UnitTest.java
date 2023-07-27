package ro.cmutica.crypto.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.cmutica.crypto.impl.Crypto;

/**
 *
 * @author cmutica
 */
public class UnitTest {
    
    private static final String TEST_TEXT =
            """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit,
            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            """;
    private String text_criptat;

    public UnitTest() throws Exception {
        this.text_criptat = Crypto.encrypt(TEST_TEXT);
    }    
    
    @Test
    @DisplayName(value = "check APPS_KEY envar")
    public void TestEnvVar(){
        var _key = System.getenv("APPS_KEY");
        assertNotNull(_key, "envar exists");
    }
    
    @Test
    @DisplayName(value = "encrypt text")
    public void TestEncrypt(){
        assertNotNull(this.text_criptat, "text was encrypted");
    }
    
    @Test
    @DisplayName(value = "decrypt text")
    public void TestDecrypt() throws Exception{
        var _rezultat = Crypto.decrypt(this.text_criptat);
        assertEquals(TEST_TEXT, _rezultat, "text was corectly decrypted");
    }
}
