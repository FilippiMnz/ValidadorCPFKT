import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)
    println("Insira o CPF para ser validado: ")
    val CPFUser = scanner.nextLine()

    if(ValidadorCPF(CPFUser)){
        println("O CPF ${CPFUser} é Valido ")
    } else{
        println("O CPF ${CPFUser} não é valido")
    }

}

fun ValidadorCPF(cpf : String): Boolean {
    //Fazer a limpeza do CPF
    //Retirar pontos e quaisquer outros elementos
    val cpfLimpo = cpf.replace("[^\\d]".toRegex(), "")


    //Verificar se possui 11 digitos
    if (cpfLimpo.length != 11) {
        return false
    }

    //Calculo para o primeiro digito Verificador
    //Inicio
    var soma = 0
    for (i in 0..8) {
        soma += (cpfLimpo[i] - '0') * (10 - i)
    }
    var restoCPF = soma % 11
    var PrimeiroDigitoVerificador = if (restoCPF < 2) 0 else 11 - restoCPF

    if (PrimeiroDigitoVerificador != cpfLimpo[9].toString().toInt()) {
        return false
    }
    //Final

    //Segundo Digito Verificador
    //Inicio
    soma = 0
    for (i in 0..9) {
        soma += (cpfLimpo[i] - '0') * (11 - i)
    }
    restoCPF = soma % 11
    var SegundoDigitoVerificador = if (restoCPF < 2) 0 else 11 - restoCPF

    if (SegundoDigitoVerificador != cpfLimpo[10].toString().toInt()) {
        return false
    }
    //Fim

    return true
}
