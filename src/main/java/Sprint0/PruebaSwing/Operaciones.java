package Sprint0.PruebaSwing;

public class Operaciones {
    private float resultadoFInal;
    public float suma(float primerNumero,float segundoNUmero){
        return resultadoFInal = primerNumero + segundoNUmero;
    }
    public float resta(float primerNumero,float segundoNumero){
        return resultadoFInal = primerNumero - segundoNumero;
    }
    public float multiplicacion(float primerNumero,float segundoNumero)
    {
        return resultadoFInal = primerNumero * segundoNumero;
    }
    public float division(float primerNumero,float segundoNumero){
        if(segundoNumero!=0)
            return resultadoFInal = primerNumero/segundoNumero;
        else
            return -1;
    }

}


