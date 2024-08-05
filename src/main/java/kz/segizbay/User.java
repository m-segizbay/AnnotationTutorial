package kz.segizbay;

@AppTable(title = "users")
public class User {
    @AppField
    private int id;

    @AppField
    private String name;

    @AppField
    private String surname;

    @AppField
    private String email;
}
