package datastructures;

public class Triplet<A, B, C>
{
  private A first;
  private B second;
  private C third;


  public Triplet(A first,
                 B second,
                 C third)
  {
    super();
    this.first = first;
    this.second = second;
    this.third = third;
  }


  public String toString()
  {
    return "(" + first.toString() + ", " + second.toString() + ", " + third.toString() + ")";
  }


  public A getFirst()
  {
    return first;
  }


  public B getSecond()
  {
    return second;
  }


  public C getThird()
  {
    return third;
  }

}
