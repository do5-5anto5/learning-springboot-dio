package dio.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import dio.springboot.app.Calculadora;
import dio.springboot.app.ConversorJson;
import dio.springboot.app.ViaCepResponse;

@Component
public class MyApp implements CommandLineRunner {

	@Autowired
	private Calculadora  calculadora;
	@Override
	public void run(String... args) throws Exception {

		System.out.println("o resultado é " + calculadora.somar(2, 7));
	}
	
	@Bean
	public CommandLineRunner run(ConversorJson conversor) throws Exception {
		return args -> {

			String json = "{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\",\"localidade\": \"São Paulo\"}";
			ViaCepResponse response = conversor.converter(json);
			System.out.println("Dados do CEP: " + response);
		};
	}

}
