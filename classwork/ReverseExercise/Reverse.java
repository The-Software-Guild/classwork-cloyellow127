public class Reverse {
    private int number;
    private int reversedNumber;

    Reverse(int number){
        this.number = number;
        setReversedNumber();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        setReversedNumber();
    }

    public int getReversedNumber() {
        return reversedNumber;
    }

    protected void setReversedNumber() {
        reversedNumber = 0;

        while(number != 0){
            int remain = number % 10;
            reversedNumber = (reversedNumber * 10) + remain;
            number /= 10;
        }
    }
}
