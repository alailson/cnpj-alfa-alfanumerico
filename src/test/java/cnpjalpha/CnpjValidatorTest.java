package cnpjalpha;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CnpjValidatorTest {

	private static final List<String> cnpjsAllValid;

	static {
		cnpjsAllValid = readAllLinesFromFile();
	}

	public CnpjValidatorTest() {
	}

	public static List<String> readAllLinesFromFile() {
		try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("valid_cnpjs").toURI()))) {
			return lines.collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			return Collections.emptyList();
		}
	}

	@Test
	public void testValidarCnpjJava7ouMenor() {
		for (String cnpj : cnpjsAllValid) {
			assertTrue(CnpjValidator.validarCnpjJava7ouMenor(cnpj));
		}
	}
	
	@Test
	public void testValidarCnpjJava9() {
		cnpjsAllValid.forEach(cnpj -> assertTrue(CnpjValidator.validarCnpjJava9(cnpj)));
	}
}
