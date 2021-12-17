
/********************* PAYMENT METHOD *********************/

interface PaymentMethod {

    public boolean pay();

}

class Swish implements PaymentMethod {
    private String phoneNumber;

    public Swish(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean pay() {
        return true;
    }

}

class PayPal implements PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public boolean pay() {
        return true;
    }

}

class CreditCard implements PaymentMethod {
    private String creditCardNrNumber;
    private String expiredDate;
    private int cvc;
    public String name;

    public CreditCard(String creditCardNrNumber,  String expiredDate, int cvc, String name) {
        this.creditCardNrNumber = creditCardNrNumber;
        this.expiredDate = expiredDate;
        this.cvc = cvc;
        this.name = name;
    }

    @Override
    public boolean pay() {
        return true;
    }

}

/********************* Account *********************/

abstract class Account {

    private String email;
    private String password;
    private boolean adminAccountStatus = false;


    public Account(String email, String password, boolean adminAccountStatus) {
        this.email = email;
        this.password = password;
        this.adminAccountStatus = adminAccountStatus;
    }

    public boolean getAdminAccountStatus() {
        return false;
    }

    public boolean signIn(User user) {
        return true;
    }

    public boolean signOut(User user) {
        return true;
    }
}

class UserAccount extends Account {

    public UserAccount(String email, String password) {
        super(email, password, false);
    }

}

class AdminAccount extends Account {

    public AdminAccount(String email, String password) {
        super(email, password, true);
    }

    public void deleteUserAccount(UserAccount account) {

    }

    public void sendWarning(UserAccount account) {

    }
}

/********************* MATCH *********************/

class Match{
    public boolean liked;
    public String id; 

    public Match(boolean liked, String id){
        this.liked = liked;
        this.id = id;
    }
}




/********************* ACCOUNTING *********************/

class Accounting {
    private LineItem[] lineItems;

    private class LineItem {
        public boolean paidStatus;
    
    }

    
    /******** FEATURES ********/
    enum Features {
        none, 
        rewind,
        moreSwipes,
        profileBoost,
        superLike,
    }
    public class PaidFeatures extends LineItem {
        private Features features;

        public PaidFeatures(){
            this.features = Features.none;
        }

        public boolean payFeatures(){
            return true;
        }
    
    }

    /******** SUBSCRIPTION ********/
    enum SubscriptionTiers {
        none, 
        monthly,
        yearly
    }
    public class Subscription extends LineItem  {
        private SubscriptionTiers subscription;

        private Subscription(){
            this.subscription = SubscriptionTiers.none;
        }

        public boolean payMonthlySubscription(){
            return true;
        }

        public boolean payYearlySubscription(){
            return true;
        }
    
    }

}

/********************* USER *********************/



public class User {

    public String name;
    public int age;
    public int userID;

    public String location;
    public String language;

    private PaymentMethod[] paymentMethods;
    public Match[] matches;

    public User(String name, int age, int userID,
                String location, String language, 
                PaymentMethod[] paymentMethods, Match[] matches
                )
    {
        this.name = name;
        this.age = age;
        this.userID = userID;
        this.location = location;
        this.language = language;
        this.paymentMethods = paymentMethods;
    }

    public User getMatch(User user) {
        return user;
    }

    public void createProfile(String bio, String tags, String picture) {
        return;
    }

    public void like(User user) {
        return;
    }

    public static void main(String args[]) {
        System.out.println("Everything compiles!");

    }

}

