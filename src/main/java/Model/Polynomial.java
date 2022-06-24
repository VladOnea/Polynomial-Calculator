package Model;

//import main.java.Model.Monomial;

import java.util.ArrayList;
import java.util.Collections;


public class Polynomial {
    private ArrayList<Monomial> polynom=new ArrayList<>();

    public Polynomial(String s){
      //      s=s.replace("0","");
        if(s.charAt(0)=='-'){ // here is a special case, it is dealing with a polynomial starting with 0
            s="-"+s.substring(1).replace("-","+-");
        }
        else{
            s=s.replace("-", "+-"); // I replaced all - signs with +-
        }
        for(String additional: s.split("\\+")){ //split
            Monomial mon=new Monomial();
            int rank;
            double coefficient;
            int seeCoeff = additional.indexOf("x");
            int seePower= additional.indexOf("^");
            int seePositive = additional.charAt(0);
            if(additional.contains("x"))
            {
                if(additional.contains("^")){
                    rank=Integer.parseInt(additional.substring(seePower+1));// after ^ I have the power
                }
                else
                    rank=1;
                if (seeCoeff== 1 && seePositive=='-'){
                    coefficient=-1;
                }
                else if(seeCoeff==0) {
                    coefficient=1;
                }
                else coefficient=Double.parseDouble(additional.substring(0,seeCoeff));
            }
            else{
                rank=0;
                coefficient=Double.parseDouble(additional);
            }
            mon.setCoeficient(coefficient);
            mon.setRank(rank);
            int validation=0;
            for(Monomial monomial:polynom) // here I was dealing with the situation of 2 polynomials with same rank
                if(monomial.getRank()==mon.getRank()){
                monomial.setCoeficient(monomial.getCoefficient()+mon.getCoefficient());
                    validation=1;
                }
                if(validation==0) {
                    polynom.add(mon);
                }

        }


    }

    public ArrayList<Monomial> getMonomials() {
        return polynom;
    }

    public Polynomial() {
        this.polynom= new ArrayList<>();
    }

    public void addMonom( Monomial mon){
        this.polynom.add(mon);
    }
    public String toString(){
        int validation=0;
        Collections.sort(polynom);
        String result="";
        for(Monomial mon: this.polynom) {
            if(mon.getCoefficient()>0) {
                validation=1;
                if (mon.getRank() == 1) { //case with x^1

                    result +="+" + mon.getCoefficient() + "x";
                } else if (mon.getRank() == 0) { //case with x^0
                    result +="+"+ mon.getCoefficient();
                } else result +="+"+ mon.getCoefficient() + "x^" + mon.getRank(); // other cases except rank={0,1}
            }
            else { //here coefficient <0
                if (mon.getCoefficient() != 0) {
                    validation=1;

                    if (mon.getRank() == 1) {

                        result += mon.getCoefficient() + "x"; //with negative coefficient
                    } else if (mon.getRank() == 0) {
                        result += mon.getCoefficient(); //with negative coefficient
                    } else result += mon.getCoefficient() + "x^" + mon.getRank();//with negative coefficient
                }
              //  else result=result+"0"; // here both rank and coefficient are 0
            }

        }
        if(validation==0)
            return "0";
        if (result.charAt(0)=='+') // for example if at integration the result strats with "+" I
           result=result.substring(1); // jumped over it to firstly display  the coefficient


        return result;
    }

}


