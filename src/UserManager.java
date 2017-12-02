public class UserManager {


    private static UserCollection allUsers = new UserCollection();


    public User getUserbyUsername(String username)
    {
        return allUsers.getUserbyUsername(username);
    }

    public User getUserbyEmail(String email)
    {
        return allUsers.getUserbyEmail(email);
    }


    public static void initialize()
    {

        User A = new User("boss32734@hotmail.com","12345678","Lastnight");
        User B = new User("Manger@hotmail.com","zeasda8","Mingd");
        User C = new User("Aobey@hotmail.com","1asdr1","Lolipop");
        User D = new User("Auzy@gmail.com","16878678","pongnut18");
        User E = new User("manilamanual@hotmail.com","0849211234","Ominidas");
        User F = new User("pigletMetpig@hotmail.com","12126547","lnwmak555");
        User G = new User("whyme555@gmail.com","AAA234","bozo007");
        User T = new User("t","t","testUser");

        allUsers.addUser(A);
        allUsers.addUser(B);
        allUsers.addUser(C);
        allUsers.addUser(D);
        allUsers.addUser(E);
        allUsers.addUser(F);
        allUsers.addUser(G);
        allUsers.addUser(T);


    }


}