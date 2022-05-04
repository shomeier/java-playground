package org.sho.finallyBlock;

public class ReturnInTryBlockAutoClosable {

    public static void main(String... args) {

        // Output:
        // Resource is deleted: false
        // Resource is deleted: true
        MyResource myResource = new ResourceProvider().get().isDeleted();
    }

    static class ResourceProvider {

        public MyResource get() {

            try(MyResource myResource = new MyResource()) {

                // the return value will be stored in a local variable before executing the finally block
                // see also: https://www.pixelstech.net/article/1474892842-try-%7B-return-%7D-finally-%7B%7D
                // and: https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.10.2.5
                return myResource.isDeleted();
            }
        }
    }

    static class MyResource implements AutoCloseable {

        private boolean isDeleted = false;

        @Override
        public void close() {
            isDeleted = true;
        }

        public MyResource isDeleted() {

            System.out.println("Resource is deleted: " + isDeleted);
            return this;
        }
    }
}
