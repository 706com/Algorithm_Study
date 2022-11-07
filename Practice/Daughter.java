package Practice;

public class Daughter extends Parents {
    final protected int x = 5;

    public void name() {
        super.name();
        familyName();
        System.out.println("국주");
    }
}

