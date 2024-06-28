package org.sho.override;

import java.util.ArrayList;
import java.util.List;

public class AlpacaTest {

    public class Alpaca {

        public List<String> hairy(List<String> list) {
            return null;
        }
    }

    public class AlpacaChild extends Alpaca {

        // This is no override !!!
        // It is an overload !!! The parameter type must match exactly!
        // Only for the return type of an overloaded method the type must be covariant, not for the parameter type!
        // @Override
        public List<String> hairy(ArrayList<String> list) {
            return null;
        }
    }
}
