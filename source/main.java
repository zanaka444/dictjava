package dictjava.source;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;
import source.dict;

@RunWith(Suite.class)
@SuiteClasses({ tests.testDictEmpty.class,
//                tests.testDictManyItems.class, 
//                tests.testDictOneItem.class, 
//                tests.testDictTwoItems.class, 
          })


public class main {
    public static void main(String[] args) {

        org.junit.runner.JUnitCore.main("Main");
    }
}
