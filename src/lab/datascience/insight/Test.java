package lab.datascience.insight;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		ZikaVirus virus = new ZikaVirus();
		String fileName = "zika.csv";

		try {
			List<FieldsFileCSV> fields = virus.getZikaVirus(Paths.get(fileName));

//			 virus.readCsv(fields);
//
//			 virus.casosZikaBrasil(fields);
//
//			 virus.casosZikaCeara(fields);
//
//			 virus.localidadeMaiorCasosZika(fields);
//
//			 virus.agruparCasosPorPais(fields);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}

	}

}
