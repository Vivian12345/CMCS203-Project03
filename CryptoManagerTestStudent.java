import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("I AM VIVIAN"));
		assertFalse(CryptoManager.isStringInBounds("x3423z@gmail.com"));
		assertFalse(CryptoManager.isStringInBounds("I AM vivian"));
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds. Try again.", CryptoManager.caesarEncryption("efg", 2));
		assertEquals("KI\\", CryptoManager.caesarEncryption("CAT", 200));
		assertEquals(",%8", CryptoManager.caesarEncryption("HAT", 100));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("BDD", CryptoManager.bellasoEncryption("ABC", "AB"));
		assertEquals("365", CryptoManager.bellasoEncryption("123", "BD"));
	}
	@Test
	void testCaesarDecryption() {
		assertEquals("CAT", CryptoManager.caesarDecryption("KI\\", 200));
		assertEquals("HAT", CryptoManager.caesarDecryption(",%8", 100));
		
	}

	@Test
	void testBellasoDecryption() {
		assertEquals("ABC", CryptoManager.bellasoDecryption("BDD", "AB"));
		assertEquals("123", CryptoManager.bellasoDecryption("365", "BD"));
	}

}
