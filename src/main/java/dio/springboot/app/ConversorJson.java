//aqui o professor cria uma classe para tornar o gson um Bean... e o valor nao retornar nulo
//deve ter algo a haver com a versão do Java ou de dependencias no momento da 
//gravação da aula.
//no caso deste código em questão, o @Autowired funcionou perfeitamente.

//TODO: testar em outras situações


package dio.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ConversorJson {
	
	@Autowired
	private Gson gson;
	
	public ViaCepResponse converter(String json) {
		ViaCepResponse response = gson.fromJson(json, ViaCepResponse.class);
		return response;
	}
}
