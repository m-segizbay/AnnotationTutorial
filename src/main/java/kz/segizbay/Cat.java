package kz.segizbay;

@AppTable(title = "cats")
public class Cat {
    @AppField
    private int id;

    @AppField
    private String name;
    private int version;

}
