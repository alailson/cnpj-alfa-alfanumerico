/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <github.com/alailson> wrote this file. As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return. Alailson Bolzon Alonso
 * ----------------------------------------------------------------------------
 */
package cnpjalpha;

public final class CnpjValidator {

	// this method should work for legacy-code systems that use older versions of Java (7 or lower)
	/**
	 * This method should work for legacy-code systems that use older versions of Java (7 or lower).
	 * Basic cnpj validation. Tries to avoid mutation as much as possible.
	 * 
	 * @param cnpj
	 * @return <code>true</code> if cnpj is a valid CNPJ, <code>false</code> otherwise
	 */
	public static boolean validarCnpjJava7ouMenor(final String cnpj) {
		final char[] charsArray = cnpj.toCharArray();
		final int[] cnpjIntValues = new int[charsArray.length];

		for (int index = 0; index < charsArray.length; index++) {
			cnpjIntValues[index] = charsArray[index] - 48;
		}

		return calcularPrimeiroDigitoVerificador(cnpjIntValues) == cnpjIntValues[12] && calcularSegundoDigitoVerificador(cnpjIntValues) == cnpjIntValues[13];
	}

	// to compute the first verification digit
	private static int calcularPrimeiroDigitoVerificador(final int[] cnpj) {
		final int fator1 = 5 * cnpj[0] + 4 * cnpj[1] + 3 * cnpj[2] + 2 * cnpj[3]
				+ 9 * cnpj[4] + 8 * cnpj[5] + 7 * cnpj[6] + 6 * cnpj[7] + 5 * cnpj[8]
				+ 4 * cnpj[9] + 3 * cnpj[10] + 2 * cnpj[11];
		final int fator2 = 11 - (fator1 % 11);

		return fator2 >= 10 ? 0 : fator2;
	}

	// to compute the second verification digit
	private static int calcularSegundoDigitoVerificador(final int[] cnpj) {
		final int fator1 = 6 * cnpj[0] + 5 * cnpj[1] + 4 * cnpj[2] + 3 * cnpj[3]
				+ 2 * cnpj[4] + 9 * cnpj[5] + 8 * cnpj[6] + 7 * cnpj[7] + 6 * cnpj[8]
				+ 5 * cnpj[9] + 4 * cnpj[10] + 3 * cnpj[11] + 2 * cnpj[12];
		final int fator2 = 11 - (fator1 % 11);

		return fator2 >= 10 ? 0 : fator2;
	}
}
