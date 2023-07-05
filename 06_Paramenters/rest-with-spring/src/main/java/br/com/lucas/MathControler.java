package br.com.lucas;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.converter.Converter;
import br.com.lucas.exceptions.UnsupportedMathOperationException;
import br.com.lucas.math.SimpleMath;

@RestController
public class MathControler {
	
	//private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
		
		if(!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo))  {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sum(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
		
		if(!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo))  {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sub(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multi(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.multi(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
 	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.div(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.mean(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/raiz/{number}", method=RequestMethod.GET)
	public Double raiz(
			@PathVariable(value = "number") String number
	) throws Exception {
		if(!Converter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return math.raiz(Converter.convertToDouble(number));
	}
	
}
