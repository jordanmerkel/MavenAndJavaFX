import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("Please enter the name of the book or type quit to exit:");
            Scanner keyboard = new Scanner(System.in);
            String title = keyboard.nextLine();
            if (title.equals("quit"))
            {
                break;
            }
            else
                {
                    String sql = "SELECT titles.title, authors.au_lname, authors.au_fname, publishers.pub_name " +
                            "FROM titles" +
                            " INNER JOIN authors ON titles.au_id = authors.au_id " +
                            "INNER JOIN publishers ON titles.pub_id = publishers.pub_id " +
                            "WHERE titles.title = ?";

                    try
                    {
                        String url = "jdbc:sqlite:C:\\Users\\jmm8707\\IdeaProjects\\lab13\\src\\main\\resources\\mybookstore";
                        Connection connection = DriverManager.getConnection(url);

                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, title);

                        ResultSet rSet = statement.executeQuery();

                        while (rSet.next())
                        {
                            System.out.println();
                            System.out.println(rSet.getString("title"));
                            System.out.println(rSet.getString("au_lname"));
                            System.out.println(rSet.getString("au_fname"));
                            System.out.println(rSet.getString("pub_name"));
                            System.out.println();
                        }
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
    }
}
