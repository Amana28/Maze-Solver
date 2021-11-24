public interface GenericStack<T> {

    // check if the GenericStack is empty
    boolean isEmpty();

    // push t onto the top of the GenericStack
    void push (T t);

    // pop the top element off the GenericStack and return it
    T pop ();

    // return the top item in the GenericStack
    T peek ();
    
}
