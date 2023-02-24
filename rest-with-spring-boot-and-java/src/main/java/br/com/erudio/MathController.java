package br.com.erudio;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private  final AtomicLong counter = new AtomicLong();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET) //parametros  soma
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne, //variaveis, ela e usada para recuperar dados da URLs
            @PathVariable(value = "numberTwo")String numberTwo
    )
        throws Exception{
            if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }

            return converteToDouble(numberOne) + converteToDouble(numberTwo);
    }
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET) //subtração
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne, //variaveis, ela e usada para recuperar dados da URLs
            @PathVariable(value = "numberTwo")String numberTwo
    )
            throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return converteToDouble(numberOne) - converteToDouble(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET) //multiplicação
    public Double mult(
            @PathVariable(value = "numberOne") String numberOne, //variaveis, ela e usada para recuperar dados da URLs
            @PathVariable(value = "numberTwo")String numberTwo
    )
            throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return converteToDouble(numberOne) * converteToDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET) //divisão
    public Double div(
            @PathVariable(value = "numberOne") String numberOne, //variaveis, ela e usada para recuperar dados da URLs
            @PathVariable(value = "numberTwo")String numberTwo
    )
            throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return converteToDouble(numberOne) / converteToDouble(numberTwo);
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET) //media
    public Double med(
            @PathVariable(value = "numberOne") String numberOne, //variaveis, ela e usada para recuperar dados da URLs
            @PathVariable(value = "numberTwo")String numberTwo
    )
            throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return (converteToDouble(numberOne) + converteToDouble(numberTwo))/2;
    }

    @RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET) //raiz quadrada
    public Double raiz(
            @PathVariable(value = "number") String number //variaveis, ela e usada para recuperar dados da URLs
    )
            throws Exception{
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return Math.sqrt(converteToDouble(number));
    }

    private Double converteToDouble(String strNumber){
        if (strNumber == null) return 0D;

        //para aceitar tanto ponto quanto virgula = Dolar 10.25 ou Reais 10,25
        String number = strNumber.replaceAll(",",".");

        if(isNumeric(number)) return Double.parseDouble(number); // se for verdadeira, vai retornar um double - String para Double

        return null;

    }
    private boolean isNumeric(String strNumber){
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
                                    //verificar se e positivo ou negativo, de 0 a 9, e numeros fracionarios
    }
}
