import java.util.List;
import java.util.stream.Collectors;

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

    public CreditCard(String creditCardNrNumber, String expiredDate, int cvc, String name) {
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

/********************* MATCH *********************/

class Match {
    public boolean liked;
    public String id;

    public Match(boolean liked, String id) {
        this.liked = liked;
        this.id = id;
    }
}

/********************* ACCOUNTING *********************/

class Accounting {
    private List<LineItem> lineItems;

    public Accounting(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    private class LineItem {
        private boolean unpaid;

        public LineItem() {
            this.unpaid = true;
        }

        public boolean unpaid() {
            return this.unpaid;
        }

        public void payLineItem() {
            this.unpaid = false;
        }
    }

    public List<LineItem> getUnpaidLineItems() {

        List<LineItem> unpaidLineItems = this.lineItems.stream()
                .filter(lineItem -> lineItem.unpaid() == true)
                .collect(Collectors.toList());

        return unpaidLineItems;
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

        public PaidFeatures() {
            this.features = Features.none;
        }

        public boolean payFeatures() {
            return true;
        }

    }

    /******** SUBSCRIPTION ********/
    enum SubscriptionTier {
        none,
        monthly,
        yearly
    }

    public class Subscription extends LineItem {
        private SubscriptionTier subscription;

        private Subscription() {
            this.subscription = SubscriptionTier.none;
        }

        public boolean payMonthlySubscription() {
            this.subscription = SubscriptionTier.monthly;
            return true;
        }

        public boolean payYearlySubscription() {
            this.subscription = SubscriptionTier.yearly;
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
            PaymentMethod[] paymentMethods, Match[] matches) {
        this.name = name;
        this.age = age;
        this.userID = userID;
        this.location = location;
        this.language = language;
        this.paymentMethods = paymentMethods;
        this.matches = matches;
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
