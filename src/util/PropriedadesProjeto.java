package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropriedadesProjeto {
	
	public static String caminhoProjeto = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	public static String caminhoPropriedades = "/META-INF/";

	/**
	 * Carregará o conteúdo do arquivo '*.properties' para a memória.
	 * 
	 * @param nomeArquivoPropriedades
	 * @return
	 * @throws IOException
	 * 
	 */
	public static Properties carregarProperties(String nomeArquivoPropriedades) throws IOException {
		Properties p = new Properties();
		String caminhoCompleto = caminhoProjeto + caminhoPropriedades + nomeArquivoPropriedades;
		p.load(new FileInputStream(caminhoCompleto));
		return p;
	}

	/**
	 * As propriedades são separadas por linha dentro dos arquivos terminado em
	 * '*.properties'. Deverá ser passado como parâmetro o texto contido no lado
	 * esquerdo da igualdade. Somente uma linha por vês.
	 * 
	 * @param propriedade
	 * @return
	 */
	public static String getTexto(String nomeArquivoPropriedades, String propriedade) {

		try {
			return carregarProperties(nomeArquivoPropriedades).getProperty(propriedade);

		} catch (IOException e) {
			// TODO Auto-generated catch block getTexto(...)
			e.printStackTrace();
		}

		return propriedade;
	}
}
