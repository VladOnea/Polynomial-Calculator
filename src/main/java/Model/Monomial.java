package Model;

public class Monomial implements Comparable{
    private int rank;
    private double coefficient;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoeficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Monomial(int rank, double coefficient) {
        this.rank = rank;
        this.coefficient = coefficient;
    }

    public Monomial(){

    }
    public Monomial(Monomial mon) {
        rank = mon.getRank();
        coefficient = mon.getCoefficient();
    }

    public int compareTo(Object o) {
        if(this.rank > ((Monomial) o).getRank())
            return -1;
        else if (this.rank < ((Monomial) o).getRank())
            return 1;
        return 0;
    }
}


