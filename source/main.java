package dictjava.source;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import dictjava.tests.*;
import dictjava.source.dict;

@RunWith(Suite.class)
@SuiteClasses({ testDictEmpty.class,
                testDictManyItems.class,
                testDictOneItem.class,
                testDictTwoItems.class,
          })


public class main {
    public static void main(String[] args) {

        org.junit.runner.JUnitCore.main("Main");
    }
}
