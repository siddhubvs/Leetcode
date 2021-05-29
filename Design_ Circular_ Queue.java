class MyCircularQueue 
{
    int A[];
    int size = 0, front = 0, rear = -1;

    public MyCircularQueue(int k) 
    {
        A = new int[k];
    }
    
    public boolean enQueue(int value) 
    {
        if(isFull())
        {
            return false;
        }
        else
        {
            rear = (rear + 1) % A.length;
            A[rear] = value;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() 
    {
        if(isEmpty())
        {
            return false;
        }
        else
        {
            front = (front + 1) % A.length;
            size--;
            return true;
        }
        
    }
    
    public int Front() 
    {
        return isEmpty() ? -1 : A[front];
    }
    
    public int Rear() 
    {
        return isEmpty() ? -1 : A[rear];
    }
    
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    public boolean isFull() 
    {
        return size == A.length;
    }
}
