package test.java;

import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationTest {
    @Test
    public void TestAdd(){
        Polynomial P=new Polynomial("x+x+x+5");
        Polynomial Q=new Polynomial("3x");
        Polynomial Add= new Polynomial("6.0x+5.0");
        Assertions.assertEquals(Add.toString(), Operations.add(P,Q).toString(),"Wrong add!");

    }
    @Test
    public void TestSub(){
        Polynomial P=new Polynomial("x+2");
        Polynomial Q=new Polynomial("x-2");
        Polynomial Sub= new Polynomial("4.0");
        Assertions.assertEquals(Sub.toString(), Operations.sub(P,Q).toString(),"Wrong subtraction!");

    }
    @Test
    public void TestMul(){
        Polynomial P=new Polynomial("x+2");
        Polynomial Q=new Polynomial("x-2");
        Polynomial Mul= new Polynomial("1.0x^2-4.0");
        Assertions.assertEquals(Mul.toString(), Operations.multiply(P,Q).toString(),"Wrong multiply!");

    }
    @Test
    public void TestInteg(){
        Polynomial P=new Polynomial("x^3+x+7");
        Polynomial Integ= new Polynomial("0.25x^4+0.5x^2+7.0x");
        Assertions.assertEquals(Integ.toString(), Operations.integration(P).toString(),"Wrong integration!");

    }
    @Test
    public void TestDer(){
        Polynomial P=new Polynomial("x^2+x+1");
        Polynomial Der= new Polynomial("2.0x+1.0");
        Assertions.assertEquals(Der.toString(), Operations.derivative(P).toString(),"Wrong derivative!");
    }

}
