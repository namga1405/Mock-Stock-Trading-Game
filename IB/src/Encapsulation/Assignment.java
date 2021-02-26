package Encapsulation;

public class Assignment
{
    private String title;
    private int total;
    
    public Assignment(String t, int tot)
    {
        this.title = t;
        this.total = tot;
    }

    public String getTitle()
    {
        return title;
    }
    
    public int getTotal()
    {
        return total;
    }
}
