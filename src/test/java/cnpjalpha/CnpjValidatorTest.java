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
	private static final List<String> cnpjsToFailValidation;

	static {
		cnpjsAllValid = readAllLinesFromFile("valid_cnpjs");
		cnpjsToFailValidation = readAllLinesFromFile("invalid_cnpjs");
	}

	public CnpjValidatorTest() {
	}

	public static List<String> readAllLinesFromFile(final String name) {
		try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(name).toURI()))) {
			return lines.collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			return Collections.emptyList();
		}
	}
	
	@Test
	public void testValidateCnpj() {
		cnpjsAllValid.forEach(cnpj -> assertTrue(CnpjValidator.validateCnpj(cnpj)));
		cnpjsToFailValidation.forEach(cnpj -> assertFalse(CnpjValidator.validateCnpj(cnpj)));
	}
}
