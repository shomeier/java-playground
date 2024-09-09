package org.sho.multicatch;

public class MultiCatch {

    void rollOut() throws ClassCastException {};

    public void transform(String c) {
        try {
            rollOut();


        // } catch (IllegalArgumentException | Exception e) { // does not compile
        // } catch (IllegalArgumentException | RuntimeException e) { // does not compile
        } catch (IllegalArgumentException | Error e) {
            // compiles because IllegalArgumentException is not subtype of Error
            // see also: https://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html:
            // "It is a compile-time error if a union of types contains two alternatives Di and Dj (i ≠ j) where Di is a subtype of Dj (§4.10.2)."

            // ... catch (IllegalArgumentException | RuntimeException e) does not compile
        }
    }
}
