package be.jochenhansoul.inheritance;

public class App {
    public static void main(String[] args) {
        Super superObject = new Super();
        Super subAsSuper = new Sub();
        Sub sub = new Sub();

        // test variables
        System.out.println("***testing variables***");
        System.out.println("***static***");
        System.out.println("super:      " + superObject.TEST_FINAL);
        System.out.println("subAsSuper: " + subAsSuper.TEST_FINAL);
        System.out.println("sub:        " + sub.TEST_FINAL);
        System.out.println("***dynamic***");
        System.out.println("super:      " + superObject.testDynamic);
        System.out.println("subAsSuper: " + subAsSuper.testDynamic);
        System.out.println("sub:        " + sub.testDynamic);
        System.out.println("");
        System.out.println("");

        // test methods
        System.out.println("***testing methods***");
        System.out.println("***static***");
        System.out.println("Super: " + Super.getAmount());
        System.out.println("Sub:   " + Sub.getAmount());
        System.out.println("***static on object (bad practice)***");
        System.out.println("super:      " + superObject.getAmount());
        System.out.println("subAsSuper: " + subAsSuper.getAmount());
        System.out.println("sub:        " + sub.getAmount());
        System.out.println("***dynamic***");
        System.out.println("super:      " + superObject.dynamicMethod());
        System.out.println("subAsSuper: " + subAsSuper.dynamicMethod());
        System.out.println("sub:        " + sub.dynamicMethod());
        System.out.println("");
        System.out.println("");

        // toString()
        System.out.println("***toString()***");
        System.out.println("super:      " + superObject.toString());
        System.out.println("subAsSuper: " + subAsSuper.toString());
        System.out.println("sub:        " + sub.toString());
    }
}
