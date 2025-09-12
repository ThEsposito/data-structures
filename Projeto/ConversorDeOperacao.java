import java.util.IllegalFormatException;

public class ConversorDeOperacao {
    // Usar hashmap seria bem mais interessante
    // Será que eu deveria tratar as variáveis cadastradas em uma classe diferente?

    private Character[] variables = new Character[26];
    private Double[] varValues = new Double[26];

    // O que faço com os parênteses??
    private static Character[] operators = {'+', '-', '*', '/', '^'};
    int varIdx = 0;
    
    // A exceção seria pra caso encontrássemos algum espaço em branco, ou char's inválidos
    public String infixToPosfix(String infix) throws VariableNotInitializedException, IllegalFormatException {        
        infix = infix.trim();
        // É mais adequado usar StringBuilder?
        String posfix = "";

        // Achar alguma fonte pra citar esse regex que usei aí
        String[] operators = infix.split("\\s+");

        for(String operator: operators) {
            // Poderia usar mais regex pra verificar se contém apenas números, ao invés de usar o try catch 
            // na lógica da função (o que não é uma boa prática) ou usar essa função (que é mais lenta, eu acho)
            if(Util.isNumber(operator)){
                
            } else if(operator.length() == 1){
                char variable = operator.charAt(0);
                // *verificar se está cadastrado em variables*
                // Se não estiver, posso lançar uma exceção, que vai ser tratada na main
                if(Util.arrayContains(variables, Character.toUpperCase(variable))){
                    
                }
            }
        }

        return posfix;
    }
}