package stevenkedziezoo;

public aspect lifeExpectancy {

    private final float RATE = .03f;
    private int counter = 1;
    private double cost = 0.0f;
    
    pointcut callLifeExpectancy() :
        call(* *.determineLifeExpectancy(..));
        
    after() : callLifeExpectancy() {
        cost = counter * RATE;
        ZooOrganizer.setBillingAmount(cost);
        ZooOrganizer.setLifeCount(counter);
        counter++;
    }
}