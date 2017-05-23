package ffb;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZikaVirus {

	public boolean verificarArquivoExiste(Path caminho) {

		boolean ret = false;

		try {
			Stream<Path> stream = Files.list(caminho);

			Optional<Path> arq = stream.filter(p -> p.toString().endsWith("zika.csv")).findAny();

			ret = arq.isPresent(); // informa se o arquivo esta presente
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return ret;
	}

	public List<FieldsFileCSV> getZikaVirus(Path caminho) throws IOException {

		Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);

		// reuni o resultado da stream e os retorna na forma de uma lista.
		List<String> listaDeLinhas = linhas.collect(Collectors.toList());

		List<FieldsFileCSV> listaDeZika = new ArrayList<>();

		FieldsFileCSV zika;

		ListIterator<String> it = listaDeLinhas.listIterator();

		String str = null;

		while (it.hasNext()) {

			str = it.next();

			String info[] = str.split(",");

			zika = new FieldsFileCSV();
			zika.setReport_date(info[0]);
			zika.setLocation(info[1]);
			zika.setLocation_type(info[2]);
			zika.setData_field(info[3]);
			zika.setData_field_code(info[4]);
			zika.setTime_period(info[5]);
			zika.setTime_period_type(info[6]);
			zika.setValue(info[7]);
			zika.setUnit(info[8]);

			listaDeZika.add(zika);

		}

		return listaDeZika;
	}

	// imprimir todo csv
	public void readCsv(List<FieldsFileCSV> arg) {
		arg.stream().forEach(System.out::println);
	}

	public void casosZikaBrasil(List<FieldsFileCSV> arg) {
		long qtd = arg.stream().filter(zika -> zika.getLocation().contains("Brazil")).count();

		System.out.println(qtd + " casos");
	}

	public void casosZikaCeara(List<FieldsFileCSV> arg) {
		long qtd = arg.stream().filter(zika -> zika.getLocation().contains("Ceara")).count();

		System.out.println(qtd + " casos");
	}

	public void localidadeMaiorCasosZika(List<FieldsFileCSV> arg) {
		FieldsFileCSV casos = arg.stream().max(Comparator.comparing(FieldsFileCSV::getValue)).get();

		System.out.println("Maior caso de zika: " + casos.getLocation());
	}

	public void agruparCasosPorPais(List<FieldsFileCSV> arg) {
		Map<String, List<FieldsFileCSV>> groupByLocation = arg.stream()
				.collect(Collectors.groupingBy(FieldsFileCSV::getLocation));

		System.out.println(groupByLocation);

	}

}
