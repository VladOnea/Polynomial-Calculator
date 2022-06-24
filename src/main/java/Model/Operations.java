package Model;



import java.util.Collections;


public class Operations {

    public static Polynomial add(Polynomial P, Polynomial Q){
        int samePower=0;
        Polynomial result= new Polynomial();
        for(Monomial A: P.getMonomials()){
            result.addMonom(new Monomial(A)); //result=A
        }
        for(Monomial B: Q.getMonomials()){
            samePower=0;
            for(Monomial C: result.getMonomials()){
                if(C.getRank()== B.getRank())// in the second monomial if we find same rank with result
                {
                    samePower=1;
                    C.setCoeficient(B.getCoefficient() + C.getCoefficient());//just add coefficient
                }

            }
            if(samePower==0){ // the rank is different
                result.addMonom(new Monomial(B)); //add monomial to result
            }

        }

        Collections.sort(result.getMonomials());
        return result;
    }
    public static Polynomial sub(Polynomial P, Polynomial Q){ // same aproach as at add but the difference here are
        int samePower=0;                                     // - signs
        Polynomial result= new Polynomial();
        for(Monomial A: P.getMonomials()){
            result.addMonom(new Monomial(A));
        }
        for(Monomial B: Q.getMonomials()){
            samePower=0;
            for(Monomial C: result.getMonomials()){
                if(C.getRank()== B.getRank())
                {
                    samePower=1;
                    C.setCoeficient(C.getCoefficient() - B.getCoefficient());
                }
            }
            if(samePower==0){
                result.addMonom(new Monomial(B.getRank(),-B.getCoefficient()));
            }
        }

        Collections.sort(result.getMonomials());
        return result;
    }

     /*public ArrayList<Polynomial> division(Polynomial D, Polynomial I){
         ArrayList<Polynomial> result = new ArrayList<Polynomial>();
         Model.Polynomial quotient= new Model.Polynomial();
        Model.Polynomial remainder= new Model.Polynomial();
            while(D.()>= I.getRank()){

        }
         return result;
     }*/
    public static Polynomial multiply(Polynomial P, Polynomial Q){
        Polynomial result= new Polynomial();
        for(Monomial A: P.getMonomials()){
            for(Monomial B: Q.getMonomials()) {
                Monomial mon= new Monomial();
                mon.setRank(A.getRank()+ B.getRank());         // add the rank
                mon.setCoeficient(A.getCoefficient()* B.getCoefficient());// it multiplies coeff of every monom from each polynomial
                result.addMonom(mon);// notice that we can have monomials with same rank
            }
        }
        for(Monomial R1: result.getMonomials()){ //if we find monomials with same rank and diff coeff
            for(Monomial R2: result.getMonomials()){
                if(R1.getRank()==R2.getRank() && R1!=R2){
                    R1.setCoeficient(R1.getCoefficient()+ R2.getCoefficient());
                    R2.setCoeficient(0);//the second monomial should disappear
                }
            }
        }
        Collections.sort(result.getMonomials());
        return result;
    }

    public static Polynomial integration(Polynomial P){ //performs in O(n)
        Polynomial result= new Polynomial();
        for(Monomial A: P.getMonomials()){
            Monomial mon= new Monomial();
            mon.setCoeficient(A.getCoefficient() / (A.getRank()+1));
            mon.setRank(A.getRank()+1);
            result.addMonom(mon);
        }
        return result;
    }
    public static Polynomial derivative(Polynomial P){ //performs in O(n)
        Polynomial result= new Polynomial();
        for(Monomial A: P.getMonomials()){
            if(A.getRank()>0) {
                Monomial mon = new Monomial();
                mon.setCoeficient(A.getCoefficient() * A.getRank());
                mon.setRank(A.getRank() - 1);
                result.addMonom(mon);
            }
        }
        return result;
    }
}


