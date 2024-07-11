import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp2
{
    public static ArrayList<String> listSent=new ArrayList<>();
    public static ArrayList<String> listDraft=new ArrayList<>();
    public static ArrayList<String> listInbox=new ArrayList<>();

    public static String UserName="abinayaganeshan2003@gmail.com";
    public static String password="password";

    public static void main(String[] args)
    {
        authentication(password);
        options(UserName);
    }

    public static void authentication(String password)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter your Email : ");
        String From=in.nextLine();
        boolean valid=authenticationFrom(From);
        if(valid)
        {
            System.out.print("Enter your Password : ");
            String Password = in.nextLine();
            if(password.equals(Password))
            {
                System.out.println("---Logged in Successfully!---");
            }
            else
            {
                System.out.println("-----Enter the Correct Password-----");
                authentication(password);
            }
        }
    }

    public static Boolean authenticationFrom(String From)
    {
        Scanner in=new Scanner(System.in);
        if(!From.contains(UserName))
        {
            System.out.println("-----Enter Valid Mail Address-----");
            System.out.print("Enter your Email : ");
            From=in.nextLine();
            authenticationFrom(From);
        }
        return true;
    }

    public static Boolean authenticationTo(String To)
    {
        Scanner in=new Scanner(System.in);
        if(!To.contains("@gmail.com"))
        {
            System.out.println("-----Enter Valid Mail Address-----");
            System.out.print("Enter Recipient's Email : ");
            To=in.nextLine();
            authenticationTo(To);
        }
        return true;
    }
    public static void options(String From)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("Enter Your Option : \n1) Compose Email \n2) Draft Mail \n3) Sent Mail \n4) Inbox Mail \n5) Exit");
        System.out.println("=============================");
        int n=in.nextInt();
        switch (n) {
            case 1:
                composeEmail(From);
                break;
            case 2:
                draftMail(From);
                break;
            case 3:
                sentMail(From);
                break;
            case 4:
                inboxMail(From);
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Enter valid option:");
                options(From);
                break;

        }
    }
    static String To,Subject,Compose_Email;
    static int Option,s=0,d=0,inbox=0;
    public static void composeEmail(String From) {
        Scanner in=new Scanner(System.in);
        System.out.println("----------Compose Email----------");
        System.out.print("Enter Recipient's Email : ");
        To = in.nextLine();
        boolean check=authenticationTo(To);
        if(check)
        {
            System.out.println("Subject :");
            Subject = in.nextLine();
            System.out.println("Compose Email :");
            Compose_Email = in.nextLine();
            System.out.println("Enter your Option \n 1) Send Mail \n 2) Draft Mail \n 3) Exit ");
            System.out.println("---------------------------------");
            ComposeEmailOption(From);
        }
    }

    public static void ComposeEmailOption(String From)
    {
        Scanner in=new Scanner(System.in);
        Option = in.nextInt();
        switch (Option) {
            case 1:
                System.out.println("---mail successfully sent---");
                if(To.equals(From))
                {
                    inbox++;
                    listInbox.add("     ");
                    listInbox.add("Subject : "+Subject);
                    listInbox.add("From : "+From);
                    listInbox.add("To : "+To);
                    listInbox.add(Compose_Email);
                    listInbox.add("     ");
                }
                listSent.add("     ");
                listSent.add("Subject : "+Subject);
                listSent.add("From : "+From);
                listSent.add("To : "+To);
                listSent.add(Compose_Email);
                listSent.add("     ");
                s++;
                options(From);
                break;
            case 2:
                System.out.println("---mail successfully drafted---");
                listDraft.add("     ");
                listDraft.add("Subject : "+Subject);
                listDraft.add("From : "+From);
                listDraft.add("To : "+To);
                listDraft.add(Compose_Email);
                listDraft.add("     ");
                d++;
                options(From);
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("-----Enter valid option-----");
                ComposeEmailOption(From);
                break;
        }
    }
    public static void draftMail(String From)
    {
        if(Option==2 || d>0) {
            System.out.println("----------Draft Mail----------");
            for(String draft:listDraft)
            {
                System.out.println(draft);
            }
            System.out.println("------------------------------");
            options(From);
        }
        else
        {
            System.out.println("No Draft Mails");
            options(From);
        }
    }
    public static void sentMail(String From)
    {
        if(Option==1 || s>0) {
            System.out.println("----------Sent Mail----------");
            for(String sent:listSent)
            {
                System.out.println(sent);
            }
            System.out.println("-----------------------------");
            options(From);
        }
        else
        {
            System.out.println("No Sent Mails");
            options(From);
        }
    }
    public static void inboxMail(String From)
    {
        if(inbox>0)
        {
            for(String inbox:listInbox)
            {
                System.out.println(inbox);
            }
        }
        else
        {
            System.out.println("No Inbox Mails");
        }
        options(From);
    }
    public static void exit()
    {
        System.out.println("Thank You ! You're Welcoming !!");
    }
}