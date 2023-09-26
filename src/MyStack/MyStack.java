package MyStack;

public class MyStack <T> {
    private Node<T> top;

    public void push(T data){
        if (top == null){
            top = new Node<>(data);
            return;
        }

        Node<T> temp = new Node<>(data);
        temp.setNext(top);
        top = temp;
    }

    public T pop(){
        if (top == null) throw new RuntimeException("Stack is empty");
        T temp = top.getData();

        top = top.getNext();
        return temp;
    }

    public T peek(){
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.getData();
    }

    public boolean isEmpty(){
        return top == null;
    }


}
